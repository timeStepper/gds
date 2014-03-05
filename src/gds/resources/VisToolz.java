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
    private HashMap<Location,Placement> placementBuffer = new HashMap<>();
    private boolean paintIntersect=false;
    private boolean paintSeed=false;
    private boolean paintApplicates=false;
    private boolean paintBuffer=false;
    private boolean paintSource=false;
    private boolean paintIntersectBuffer=false;
    private int offset = 2;
    Placement placement = new Placement();
    private Color seedColor = Color.BLACK;
    private Color applicateColor = Color.WHITE;
    private Color bufferColor = Color.BLUE;
    private Color intersectColor = Color.GREEN;
    private Color sourceColor = Color.YELLOW;
    private double thresholdAdjustUpper = 1;
    private double thresholdAdjustLower = 0;
    private double adjustAdjust = 10;
    private double intersectVal;
    private double differenceVal;
    private double boundSizeVal;
    private double intersectThreshold;
    //Value is here, as it remains consistent for a whole generation
    public Value value=new Value();
    
    
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
    public void setAdjustUpper(double a){
        thresholdAdjustUpper = a;
    }
    public void setAdjustLower(double a){
        thresholdAdjustLower = a;
    }
    public void setAdjustAdjust(double a){
        adjustAdjust = a;
    }
    public void setIntersectVal(double d){
        intersectVal = d/100;
    }
//    public void setBoundSizeVal(double d){
//        boundSizeVal = d/100;
//    }
//    public void setDifferenceVal(double d){
//        differenceVal = d/100;
//    }
//    public void invertIntersectVal(){
//        intersectVal = 1/intersectVal;
//    }
//    public void invertBoundSizeVal(){
//        boundSizeVal = 1/boundSizeVal;
//    }
//    public void invertDifferenceVal(){
//        differenceVal = 1/differenceVal ;
//    }
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
        placement = new Placement(locatedSource);
        placement.placement(design);
        placement.applyPlacement();
    }
    public void down(){
        ++currentY;
        locatedSource = source.locate(new Location(currentX, currentY));
        placement = new Placement(locatedSource);
        placement.placement(design);
        placement.applyPlacement();
    }
    public void left(){
        --currentX;
        locatedSource = source.locate(new Location(currentX, currentY));
        placement = new Placement(locatedSource);
        placement.placement(design);
        placement.applyPlacement();
    }
    public void right(){
        ++currentX;
        locatedSource = source.locate(new Location(currentX, currentY));
        placement = new Placement(locatedSource);
        placement.placement(design);
        placement.applyPlacement();
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
    public void togglePaintIntersectBuffer(){
        if(paintIntersectBuffer)paintIntersectBuffer=false;
        else paintIntersectBuffer = true;
    }
    public void paintViz(Graphics2D g){
        if (paintIntersectBuffer)paintPlacementBuffer(g);
        else{
            if(paintSeed)paintSeed(g);
            if(paintApplicates)paintApplicants(g);
            if(paintSource)paintSource(g);
            if(paintIntersect)paintIntersect(g);
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
        for (Edge e:placement.intersection()){
            paintEdge(g,e,intersectColor,4F);
        }
    }
    public void paintSeed(Graphics2D g){
        for (Edge e : design.edges()){
            paintEdge(g,e,seedColor,.5F);
        }
    }
    public void paintApplicants(Graphics2D g){
        HashSet<Edge> edges = new HashSet<>();
        for(Edge e:placement.applicated().keySet()){//can use the weights here for visuals
            Weight w = placement.applicated().get(e);
            if (w.decide()!=0){
//                System.out.println(w.decide());
                int op = (int) (255*w.decide())+50;
                if (op>255)op=255;
                Color col = new Color(255,255,255,op);
                paintEdge(g,e,col,3F);
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
    public void paintPlacementBuffer(Graphics2D g){
        for (Location loc : placementBuffer.keySet()){
            Placement plc = placementBuffer.get(loc);
            paintPlacement(g, plc);
        }
    }
    private void paintPlacement(Graphics2D g, Placement plcmnt){
        double lower;
        double weight;
        plcmnt.applyPlacement(value);
        for (Edge e : plcmnt.applicated().keySet()){
            Weight w = plcmnt.applicated().get(e);
            lower = thresholdAdjustLower*adjustAdjust*plcmnt.threshold();
            weight = w.decide();
            if (weight > lower && weight < thresholdAdjustUpper){
                paintEdge(g,e,bufferColor,2F);
            }
        }
    }
    public void decidePlacements(){
        design.clear();
        for (Location l : placementBuffer.keySet()){
            Placement plcmnt = placementBuffer.get(l);
            plcmnt.applyPlacement(value);
            for (Edge e:plcmnt.applicated().keySet()){
                Weight w = plcmnt.applicated().get(e);
                double lower = thresholdAdjustLower*adjustAdjust*placement.threshold();
                double weight = w.decide();
                if (weight > lower && weight < thresholdAdjustUpper){
                    design.setEdge(e,w);
                }
            }
        }
        //design.decide(0);
    }
    public void bufferPlacements(){
        Design bounded;
        placementBuffer.clear();//{here}
        Source localSource;//relocated for each here
        for ( int x = design.bounds.xmin()-offset; x <= design.bounds.xmax()+offset; ++x )
            for ( int y = design.bounds.ymin()-offset; y <= design.bounds.ymax()+offset; ++y){
                Location here = new Location(x,y);
                localSource = source.locate(here);//located here
                Placement placement = new Placement(localSource);//for each here
                bounded = Design.bounded(localSource.bounds(), design);
                placement.placement(bounded);
                //deep buffer placement results for 'here'
                placementBuffer.put(here,placement);
            }
    }
//    public void buffer(){
//        Placement placement;
//        designBuffer.clearEdges();
//        Design bounded;
//        Source localSource;
//        for ( int x = design.bounds.xmin()-offset; x <= design.bounds.xmax()+offset; ++x )
//            for ( int y = design.bounds.ymin()-offset; y <= design.bounds.ymax()+offset; ++y){
//                Location here = new Location(x,y);
//                localSource = source.locate(here);
//                placement = new Placement(localSource);
//                bounded = Design.bounded(localSource.bounds(), design);
//                placement.placement(bounded);
//                placement.bufferPlacement();
//                //buffer intersect results for 'here'
//                for (Edge e:placement.buffer().keySet()){
////                    System.out.println(e+" -> "+intersect.buffer().get(e));
//                    designBuffer.setEdge(e,placement.buffer().get(e));
//                }
//            }
//    }
//    public void decide(){
//        designBuffer.decide(thresholdAdjustUpper*adjustAdjust);
//        design = new Design(designBuffer);
//        design.setBounds();
//    }
//    public void generation(){
//        buffer();
//        decide();
//    }
}


