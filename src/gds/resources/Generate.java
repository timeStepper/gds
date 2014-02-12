/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import static gds.resources.Design.intersect;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author owenpaulmeyer
 */
public class Generate {
    Design design;
    Source source;
    Grid grid;
    
    Generate(int x, int y, Grid g){
        design = new Design();
        grid = g;
    }
    public void setSource(Child c){
        
        source = new Source(c);
    }
    public void setSeed(Child c){
        design.setSeed(c);
    }
    public ArrayList<Child> intersection( Location loc ){
        ArrayList<Child> intersection = new ArrayList<>();
        Child located = Child.locate(source.element(), loc);
        
        Bounds bounds = Source.bounds(located);
        Design bounded = Design.bounded(bounds, design);
//        System.out.println("Bounded:\n"+bounded);
//        System.out.println("Located:");
//        located.displayChildren();
        return intersect( located, bounded );
        
    }
    public void boundTest(Bounds b){
        System.out.println("Seed:\n"+design);
        Design des = Design.bounded(b, design);
        System.out.println("Bounded:\n"+des);
    }
    public void intersectionTest(Location l){
        ArrayList<Child> intersection = intersection(l);
        System.out.println("Intersection:\n"+intersection);
    }
    //the parent call for painting this object
    public void paint(Graphics2D g){
        paintDesign(g);
    }
    public void paintDesign( Graphics2D g ) {
        for ( Location l : design.grid() ){
            paintLocation(g,l);
        }
        for ( WeightedEdge we :design.edges() ){
            paintEdge(g,we);
        }
    }
    public void paintLocation(Graphics2D g, Location l) {
        g.setColor(Color.ORANGE);
        g.fillOval(grid.originX+(l.xLoc()*grid.mS)-2, grid.originY+(l.yLoc()*grid.mS)-2, 4, 4);
        g.setColor(Color.BLACK);
        g.drawOval(grid.originX+(l.xLoc()*grid.mS)-2, grid.originY+(l.yLoc()*grid.mS)-2, 4, 4);
    }
    public void paintEdge( Graphics2D g, WeightedEdge we ) {
        g.setColor(Color.WHITE);
        
        int x1 = we.startX();
        int y1 = we.startY();
        int x2 = we.finX();
        int y2 = we.finY();
        g.setStroke(new BasicStroke(2F));
        g.drawLine( x1*grid.mS + grid.originX, y1*grid.mS + grid.originY, x2*grid.mS + grid.originX, y2*grid.mS + grid.originY );
        g.setStroke(new BasicStroke(1F));
        g.setColor(Color.BLACK);
        g.drawLine( x1*grid.mS + grid.originX, y1*grid.mS + grid.originY, x2*grid.mS + grid.originX, y2*grid.mS + grid.originY );
    }
}
