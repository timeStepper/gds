/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
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
    private Design designBuffer = new Design();
    private HashMap<Location,Intersect> intersectBuffer = new HashMap<>();
    private boolean paintIntersect=false;
    private boolean paintSeed=false;
    private boolean paintApplicates=false;
    private boolean paintBuffer=false;
    private boolean paintSource=false;
    private boolean paintIntersectBuffer=false;
    private int offset = 2;
    Intersect intersect = new Intersect();
    private Color seedColor = Color.BLACK;
    private Color applicateColor = Color.WHITE;
    private Color bufferColor = Color.BLUE;
    private Color intersectColor = Color.GREEN;
    private Color sourceColor = Color.YELLOW;
    private double thresholdAdjust = 1;
    private double adjustAdjust = 1;
    private double intersectVal;
    private double differenceVal;
    private double boundSizeVal;
    private double intersectThreshold;
    
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
        design.setSeed(c.clone());
        design.setBounds();
    }
    public void setAdjust(double a){
        thresholdAdjust = a/100;
    }
    public void setAdjustAdjust(double a){
        adjustAdjust = a;
    }
    public void setIntersectVal(double d){
        intersectVal = d/100;
    }
    public void setBoundSizeVal(double d){
        boundSizeVal = d/100;
    }
    public void setDifferenceVal(double d){
        differenceVal = d/100;
    }
    public void invertIntersectVal(){
        intersectVal = 1/intersectVal;
    }
    public void invertBoundSizeVal(){
        boundSizeVal = 1/boundSizeVal;
    }
    public void invertDifferenceVal(){
        differenceVal = 1/differenceVal ;
    }
    public void computeIntersectThreshold(){
        //double intersectThreshold = inters.intersection().size() / source.size();
//        differenceThreshold = inters.difference().size() / source.size();
//        intersectThreshold = inters.intersection().size() / source.size();//could be boundedSize too
        //boundSizeThreshold = inters.boundSize();
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
    public void togglePaintIntersectBuffer(){
        if(paintIntersectBuffer)paintIntersectBuffer=false;
        else paintIntersectBuffer = true;
    }
    public void paintViz(Graphics2D g){
        if(paintBuffer)paintBuffer(g);
        else if (paintIntersectBuffer)paintIntersectBuffer(g);
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
    public void paintIntersectBuffer(Graphics2D g){
        for (Location loc : intersectBuffer.keySet()){
            Intersect inters = intersectBuffer.get(loc);
            paintIntersectCall(g,inters);
        }
    }
    private void paintIntersectCall(Graphics2D g, Intersect inters){
        
        double t;
        for (Edge e : inters.buffer().keySet()){
            Weight w = inters.buffer().get(e);
            double in = inters.intersection().size();
            double diff = inters.difference().size();
            if ( diff == 0 )t=100;
            else
                t = (in/diff)*differenceVal*adjustAdjust;
            //System.out.println("t "+t);
            if (w.decide() > t){
                paintEdge(g,e,bufferColor,2F);
            }
        }
    }
    public void paintIntersect(Graphics2D g){
        for (Edge e:intersect.intersection()){
            paintEdge(g,e,intersectColor,4F);
        }
    }
    public void paintSeed(Graphics2D g){
        for (Edge e : design.edges()){
            paintEdge(g,e,seedColor,.5F);
        }
    }
    public void paintApplicates(Graphics2D g){
        HashSet<Edge> edges = new HashSet<>();
        for(Edge e:intersect.buffer().keySet()){//can use the weights here for visuals
            Weight w = intersect.buffer().get(e);
            if (w.decide()!=0){
//                System.out.println(w.decide());
                int op = (int) (255*w.decide())+50;
                if (op>255)op=255;
                Color col = new Color(255,255,255,op);
                paintEdge(g,e,col,3F);
            }
        }
    }
    public void paintBuffer(Graphics2D g){
        double t = 0;
        for (Edge e : designBuffer.edges()){
            Weight w = designBuffer.edgeMap().get(e);
            intersectThreshold = (intersect.threshold()*adjustAdjust)*thresholdAdjust;
            if (w.decide() > intersectThreshold){
                paintEdge(g,e,bufferColor,2F);
                //System.out.println(e+" -> "+w.decide()+" < "+t);
            }
        }
    }
    public void paintChild(Graphics2D g, int opacity, float weight, Child child){
        Color color = new Color(46,159,255,opacity);
        for (Child c:child.children()){
            //assumes containsallEmpties test @ Caller
            for(Connection cn:c.connections()){
                Edge e = new Edge(cn);
                paintEdge(g,e,color,weight);
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
    
    public void bufferIntersects(){
        Design bounded;
        intersectBuffer.clear();//used for {here}
        Source localSource;//relocated for each here
        for ( int x = design.bounds.xmin()-offset; x <= design.bounds.xmax()+offset; ++x )
            for ( int y = design.bounds.ymin()-offset; y <= design.bounds.ymax()+offset; ++y){
                Location here = new Location(x,y);
                Intersect intersectB = new Intersect();//for each here
                localSource = source.locate(here);//located here
                bounded = Design.bounded(localSource.bounds(), design);
                intersectB.intersect(bounded, localSource);
                intersectB.bufferIntersection(localSource);
                //deep buffer intersect results for 'here'
                intersectBuffer.put(here,intersectB);
            }
    }
    public void decideIntersects(){
        designBuffer.clearEdges();
        for (Location l : intersectBuffer.keySet()){
            Intersect i = intersectBuffer.get(l);
            for (Edge e:intersect.buffer().keySet()){
                designBuffer.setEdge(e,intersect.buffer().get(e));
            }
        }
        designBuffer.decide(intersectThreshold);
        design = new Design(designBuffer);
        design.setBounds();
    }
    public void buffer(){
        designBuffer.clearEdges();
        Design bounded;
        Source localSource;
        for ( int x = design.bounds.xmin()-offset; x <= design.bounds.xmax()+offset; ++x )
            for ( int y = design.bounds.ymin()-offset; y <= design.bounds.ymax()+offset; ++y){
                Location here = new Location(x,y);
                localSource = source.locate(here);
                bounded = Design.bounded(localSource.bounds(), design);
                intersect.intersect(bounded, localSource);
                intersect.bufferIntersection(localSource);
                //buffer intersect results for 'here'
                for (Edge e:intersect.buffer().keySet()){
//                    System.out.println(e+" -> "+intersect.buffer().get(e));
                    designBuffer.setEdge(e,intersect.buffer().get(e));
                }
            }
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
}


