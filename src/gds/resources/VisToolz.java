/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

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
    private Design buffer;
    private boolean paintIntersect=false;
    private boolean paintSeed=false;
    private boolean paintApplicates=false;
    private boolean paintBuffer=false;
    private int offset = 0;
    Intersect intersect = new Intersect();
    
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
    }
    public void setSeed(Child c){
        System.out.println("c "+c);
        design.setSeed(c.clone());
        design.setBounds();
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
    }
    public void down(){
        ++currentY;
    }
    public void left(){
        --currentX;
    }
    public void right(){
        ++currentX;
    }
    public void paintViz(Graphics2D g){
        if(paintBuffer)paintBuffer(g);
        else{
            if(paintIntersect)paintIntersect(g);
            if(paintSeed)paintSeed(g);
            if(paintApplicates)paintApplicates(g);
            }
    }
    public void paintIntersect(Graphics2D g){
        
    }
    public void paintSeed(Graphics2D g){
        
    }
    public void paintApplicates(Graphics2D g){
        
    }
    public void paintBuffer(Graphics2D g){
        
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
    public void generation(){
        Design designBuffer = new Design();
        intersect.resetThreshold();
        for ( int x = design.bounds.xmin()-offset; x <= design.bounds.xmax()+offset; ++x )
            for ( int y = design.bounds.ymin()-offset; y <= design.bounds.ymax()+offset; ++y){
                
                Location here = new Location(x,y);
                setLocatedSource(here);
                setBoundedDesign(here);
                intersect.intersect(boundedDesign, locatedSource);
                intersect.bufferIntersection(locatedSource);
                for (Edge e:intersect.buffer().keySet()){
//                System.out.println(e+"->"+intersect.buffer().get(e)+" / "+design.threshold());
                    if (intersect.buffer().get(e).decide()>design.threshold()){
                        //System.out.println(e+ "->" + intersect.buffer().get(e));
                        designBuffer.setEdge(e,intersect.buffer().get(e));
                    }
                }
            }
        
        //System.out.println("buffer "+buffer.edges().size());
        designBuffer.decide(intersect.threshold());
        //System.out.println("buffer "+buffer.edges().size()+", "+design.threshold());
        design = designBuffer;
    }
    public void setLocatedSource(Location loc){
        locatedSource = source.locate(loc);
    }
    public void setBoundedDesign(Location loc){
        boundedDesign = Design.bounded(locatedSource.bounds(), design);
    }
}
