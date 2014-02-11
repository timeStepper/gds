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
public class Generate {
    Design design;
    Source source;
    Grid grid;
    
    Generate(int x, int y, Grid g){
        design = new Design(x,y);
        grid = g;
    }
    public void setSource(Child c){
        source.setSource(c);
    }
    public void setSeed(Child c){
        design.setSeed(c);
    }
    public void paint(Graphics2D g){
        paintDesign(g);
    }
    
    
    
        
    public void paintDesign( Graphics2D g ) {
        for(int x = 0;x<design.width();++x)
            for(int y=0;y<design.height();++y){
                Location l = new Location( x,y);
                if (design.contains(l))
                    paintLocation(g,l);
            }
        for ( WeightedEdge we : design.edges() ){
            paintEdge(g,we);
            System.out.println(we);
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
