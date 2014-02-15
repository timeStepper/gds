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
    public HashSet<Child> intersection( Location loc ){
        HashSet<Child> intersection = new HashSet<>();
        source.locate(loc); //sets source.located and source.adjacencyList at "loc"
        Bounds bounds = Source.bounds(source.located);
        Design bounded = Design.bounded(bounds, design);
        return Design.intersect( source.located, bounded );
    }
    public void boundTest(Bounds b){
        System.out.println("Seed:\n"+design);
        Design des = Design.bounded(b, design);
        System.out.println("Bounded:\n"+des);
    }
    public void intersectionTest(Location l){
        HashSet<Child> intersection = intersection(l);
        for ( Child lhs : intersection ){
            System.out.println(lhs+" -> "+source.adjacencyList.get(lhs));
        }
    }
    //the parent call for painting this object
    public void paint(Graphics2D g){
        paintDesign(g);
    }
    public void paintDesign( Graphics2D g ) {
        for ( Location l : design.grid() ){
            paintLocation(g,l);
        }
        for ( Edge e : design.edges() ){
            paintEdge(g,e);
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
        g.setStroke(new BasicStroke(2F));
        g.drawLine( x1*grid.mS + grid.originX, y1*grid.mS + grid.originY, x2*grid.mS + grid.originX, y2*grid.mS + grid.originY );
        g.setStroke(new BasicStroke(1F));
        g.setColor(Color.BLACK);
        g.drawLine( x1*grid.mS + grid.originX, y1*grid.mS + grid.originY, x2*grid.mS + grid.originX, y2*grid.mS + grid.originY );
    }
}
