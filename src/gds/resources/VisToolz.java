/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashSet;

/**
 *
 * @author owenpaulmeyer
 */
public class VisToolz {
    private int currentX=0;
    private int currentY=0;
    private Bounds bounds;//for stepping
    private Grid grid;
    private Source source;
    private Source locatedSource;
    private Design design = new Design();
    private Design boundedDesign;
    private Design designBuffer = new Design();
    private boolean paintIntersect=false;
    private boolean paintSeed=false;
    private boolean paintApplicates=false;
    private boolean paintBuffer=false;
    private boolean paintSource=false;
    private int offset = 2;
    Intersect intersect = new Intersect();
    private Color seedColor = Color.CYAN;
    private Color applicateColor = Color.WHITE;
    private Color bufferColor = Color.BLUE;
    private Color intersectColor = Color.GREEN;
    private Color sourceColor = Color.YELLOW;
    private double thresholdAdjust = 1;
    private double adjustAdjust = 88;
    
    VisToolz(Grid g){
        grid = g;
    }
    
    public void setX(int x){
        currentX=x;
    }
    public void setY(int y){
        currentY=y;
    }
    public void setBound(Bounds bs){
        bounds = bs;
    }
    public void setSource(Child c){
        source = source = new Source(c.clone());
        locatedSource = source.locate(new Location(0,0));
    }
    public void setSeed(Child c){
        //System.out.println("c "+c);
        design.setSeed(c.clone());
        design.setBounds();
    }
    public void setAdjust(double a){
        thresholdAdjust = a / adjustAdjust;
    }
    public void setAdjustAdjust(double a){
        adjustAdjust = a;
    }
    public void step(){
        if ( currentX < bounds.xmax() )currentX++;
        else {
            currentX = bounds.xmin();
            if ( currentY < bounds.ymax() )currentY++;
            else currentY = bounds.ymin();
        }
    }
    public void up(){
        --currentY;
        locatedSource = source.locate(new Location(currentX, currentY));
        intersect.intersect(design, locatedSource);
        intersect.bufferIntersection(locatedSource);
    }
    public void down(){
        ++currentY;
        locatedSource = source.locate(new Location(currentX, currentY));
        intersect.intersect(design, locatedSource);
        intersect.bufferIntersection(locatedSource);
    }
    public void left(){
        --currentX;
        locatedSource = source.locate(new Location(currentX, currentY));
        intersect.intersect(design, locatedSource);
        intersect.bufferIntersection(locatedSource);
    }
    public void right(){
        ++currentX;
        locatedSource = source.locate(new Location(currentX, currentY));
        intersect.intersect(design, locatedSource);
        intersect.bufferIntersection(locatedSource);
    }
    
    public void togglePaintSource(){
        if(paintSource)paintSource=false;
        else paintSource = true;
    }
    public void togglePaintIntersect(){
        if(paintIntersect)paintIntersect=false;
        else paintIntersect = true;
    }
    public void togglePaintSeed(){
        if(paintSeed)paintSeed=false;
        else paintSeed=true;
    }
    public void togglePaintApplicates(){
        if(paintApplicates)paintApplicates=false;
        else paintApplicates=true;
    }
    public void togglePaintBuffer(){
        if(paintBuffer)paintBuffer=false;
        else paintBuffer = true;
    }
    public void paintViz(Graphics2D g){
        if(paintBuffer)paintBuffer(g);
        else{
            if(paintIntersect)paintIntersect(g);
            if(paintSeed)paintSeed(g);
            if(paintApplicates)paintApplicates(g);
            if(paintSource)paintSource(g);
            }
    }
    public void paintSource(Graphics2D g){
        //System.out.println(locatedSource);
        HashSet<Edge> edges = Child.flattenEdges(locatedSource.element());
        for (Edge e : edges){
            paintEdge(g,e,sourceColor,1F);
        }
    }
    public void paintIntersect(Graphics2D g){
        for (Edge e:intersect.intersection()){
            paintEdge(g,e,intersectColor,7F);
        }
    }
    public void paintSeed(Graphics2D g){
        for (Edge e : design.edges()){
            paintEdge(g,e,seedColor,2F);
        }
    }
    public void paintApplicates(Graphics2D g){
        HashSet<Edge> edges = new HashSet<>();
        for(Edge e:intersect.buffer().keySet()){//can use the weights here for visuals
            Weight w = intersect.buffer().get(e);
            if (w.decide()!=0)
                paintEdge(g,e,applicateColor,2F);
        }
    }
    public void paintBuffer(Graphics2D g){
        double t = 0;
        for (Edge e : designBuffer.edges()){
            Weight w = designBuffer.edgeMap().get(e);
            t = intersect.threshold()*thresholdAdjust;
            if (w.decide() > t){
                paintEdge(g,e,bufferColor,2F);
                //System.out.println(e+" -> "+w.decide()+" < "+t);
            }
        }
    }
    //color will provide opacity level
    public void paintEdge( Graphics2D g, Edge e, Color color, Float weight ) {
        g.setColor(color);
        int x1 = e.aX();
        int y1 = e.aY();
        int x2 = e.bX();
        int y2 = e.bY();
        g.setStroke(new BasicStroke(weight, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.drawLine( x1*grid.mS + grid.originX, y1*grid.mS + grid.originY, x2*grid.mS + grid.originX, y2*grid.mS + grid.originY );

    }
    public void buffer(){
        intersect.resetThreshold();
        designBuffer.clearEdges();
        Source localSource;
        for ( int x = design.bounds.xmin()-offset; x <= design.bounds.xmax()+offset; ++x )
            for ( int y = design.bounds.ymin()-offset; y <= design.bounds.ymax()+offset; ++y){
                Location here = new Location(x,y);
                
                localSource = source.locate(here);
                setBoundedDesign(here, localSource);
                intersect.intersect(boundedDesign, localSource);
                intersect.bufferIntersection(localSource);
                for (Edge e:intersect.buffer().keySet()){
                    //if (intersect.buffer().get(e).decide()>design.threshold()){
                        designBuffer.setEdge(e,intersect.buffer().get(e));
                    //}
                }
            }
//        designBuffer.decide(intersect.threshold());
//        design = designBuffer;
//        design.setBounds();
    }
    public void decide(){
        designBuffer.decide(intersect.threshold()*thresholdAdjust);
        design = new Design(designBuffer);
        design.setBounds();
    }
    public void generation(){
        buffer();
        decide();
    }
    public void setLocatedSource(Location loc){
        locatedSource = source.locate(loc);
    }
    public void setBoundedDesign(Location loc, Source localSource){
        boundedDesign = Design.bounded(localSource.bounds(), design);
    }
}
