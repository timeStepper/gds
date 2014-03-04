/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author owenpaulmeyer
 */
public class Generate {
    Design design;
    Design boundedDesign;
    double decisionThreshold = .5;
    Source source;
    Source locatedSource;
    Grid grid;
    int offset = 4;
    Placement intersect = new Placement();
    
    
    public Generate(){}
    Generate(int x, int y, Grid g){
        design = new Design(2);
        grid = g;
    }
    public Source source(){
        return source;
    }
    public void setThreshold(double t){
        design.adjust(t);
    }
    public void setDiffThreshold(double t){
        design.adjustDiff(t);
    }
    public void setSource(Child c){
        source = new Source(c.clone());
    }
    public void setSeed(Child c){
        design.setSeed(c.clone());
        design.setBounds();
        //System.out.println(designBounds);
    }
    
    public void setLocatedSource(Location loc){
        locatedSource = source.locate(loc);
    }
    public void setBoundedDesign(Location loc){
        boundedDesign = Design.bounded(locatedSource.bounds(), design);
    }
    public HashSet<Child> intersection( Location loc ){
        HashSet<Child> rtn = Design.intersect(
                    locatedSource.element(), locatedSource.lookupTable(), boundedDesign );
//        for ( Child c : rtn ){
//            c.setValue(valuate(c));
//        }
        return rtn;
    }
    private double valuate(Child c){
        double value = 0;
        if ( c.isEmpty() ){
            ArrayList<Child> rhss = locatedSource.lookupTable().get(c);
            if (rhss!=null)
                for ( Child ch : rhss ){
                    if ( boundedDesign.contains(ch.location()))
                        value += 1;
                }
        }
        else {
            for ( Child ch : c.children() )
                value += valuate(ch);
        }
        return value;
    }
    public void generation(){
        design.resetThreshold();
        Design buffer = new Design(design.adjust);
        for ( int x = design.bounds.xmin()-offset; x <= design.bounds.xmax()+offset; ++x ){
            for ( int y = design.bounds.ymin()-offset; y <= design.bounds.ymax()+offset; ++y){
                
                Location here = new Location(x,y);
                setLocatedSource(here);
                setBoundedDesign(here);
                double bounded = boundedDesign.edges().size();
                    if ( bounded != 0 ){
    //                System.out.println("X: "+x);
    //                System.out.println("Y: "+y);
                        HashSet<Child> intersection = intersection(new Location(x,y));
                        Design difference = Design.difference(locatedSource.element(), boundedDesign);
                        //double interSize = Source.interSize(intersection, locatedSource);
                        double interVal;
                        double diffVal;
                        double differ = difference.edges().size();
                        interVal = intersection.size() / bounded;
                        diffVal = differ / bounded;
                        //System.out.println("diffVal "+diffVal);
                        //System.out.println("bounded"+bounded);
                        //System.out.println("interval: "+interVal);
                        buffer.balanceDiffer(diffVal);//source.intersectValue);
                        buffer.balanceInter(interVal);
                        buffer.applyRules(intersection, 
                                locatedSource.lookupTable(), interVal, diffVal);//source.intersectValue);//diff);
                        //buffer.applyDifference(difference, interVal);//invDiff);
                    }
            }
        }
        buffer.decide(buffer.threshold());
        
        design = buffer;
        
    }
    public void boundTest(Bounds b){
        System.out.println("Seed:\n"+design);
        Design des = Design.bounded(b, design);
        System.out.println("Bounded:\n"+des);
    }
    public void intersectionTest(Location l ){
        HashSet<Child> intersection = intersection(l);
        Rules.intersectToRules( intersection, locatedSource.lookupTable() ).display();
//        for ( Child lhs : intersection ){
//            System.out.println(lhs+" -> "+source.adjacencyList.get(lhs));
//        }
    }
    //the parent call for painting this object
    public void paint(Graphics2D g){
        paintDesign(g);
    }
    public void paintDesign( Graphics2D g ) {
//        for ( Location l : design.grid() ){
//            paintLocation(g,l);
//        }
        for ( Edge e : design.edges() ){
            //if (design.edgeMap().get(e).decide() > decisionThreshold)
            paintEdge(g,e);
        }
        for ( Edge e : design.edges() ){
            if (design.edgeMap().get(e).decide() > decisionThreshold)
            paintEdgeIn(g,e);
        }
    }
    public void paintLocation(Graphics2D g, Location l) {
        g.setColor(Color.ORANGE);
        g.fillOval(grid.originX+(l.xLoc()*grid.mS)-2, grid.originY+(l.yLoc()*grid.mS)-2, 4, 4);
        g.setColor(Color.BLACK);
        g.drawOval(grid.originX+(l.xLoc()*grid.mS)-2, grid.originY+(l.yLoc()*grid.mS)-2, 4, 4);
    }
    public void paintEdge( Graphics2D g, Edge e ) {
        g.setColor(Color.WHITE);
        int x1 = e.aX();
        int y1 = e.aY();
        int x2 = e.bX();
        int y2 = e.bY();
        g.setStroke(new BasicStroke(3F, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        g.drawLine( x1*grid.mS + grid.originX, y1*grid.mS + grid.originY, x2*grid.mS + grid.originX, y2*grid.mS + grid.originY );

    }
    public void paintEdgeIn( Graphics2D g, Edge e ){
        int x1 = e.aX();
        int y1 = e.aY();
        int x2 = e.bX();
        int y2 = e.bY();
        g.setStroke(new BasicStroke(.5F));
        g.setColor(Color.BLACK);
        g.drawLine( x1*grid.mS + grid.originX, y1*grid.mS + grid.originY, x2*grid.mS + grid.originX, y2*grid.mS + grid.originY );
    }
}
//public void differentiate(){
//        design.resetThreshold();
//        Design buffer = new Design(design.adjust);
//        buffer.adjustDiff(design.diffadj);
//        for ( int x = design.bounds.xmin()-offset; x <= design.bounds.xmax()+offset; ++x ){
//            for ( int y = design.bounds.ymin()-offset; y <= design.bounds.ymax()+offset; ++y){
//                
//                Location here = new Location(x,y);
//                setLocatedSource(here);
//                setBoundedDesign(here);
//                double bounded = boundedDesign.edges().size();
//                    if ( bounded != 0 ){
//                        HashSet<Child> intersection = intersection(new Location(x,y));
//                        Design difference = Design.difference(locatedSource.element(), boundedDesign);
//                        double interVal;
//                        double diffVal;
//                        double differ = difference.edges().size();
//                        interVal = intersection.size() / bounded;
//                        diffVal = differ / bounded;
//                        buffer.balanceDiffNum(diffVal);
//                        //buffer.balanceDiffDen(source.intersectValue);
//                        buffer.applyDifference(difference, interVal);//invDiff);
//                    }
//            }
//        }
//        buffer.adjustDiff(design.diffadj);
//        System.out.println("designDiffAdj: "+design.diffadj);
//        design.applyDifferenceBuffer(buffer);
//        design.decide(buffer.diffThreshold());
//    }