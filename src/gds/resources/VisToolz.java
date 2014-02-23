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
    private int currentX;
    private int currentY;
    private Bounds bounds;
    private Grid grid;
    private Source source;
    private Design design;
    private Design buffer;
    private boolean paintIntersect=false;
    private boolean paintDifference=false;
    private boolean paintRules=false;
    private boolean paintBuffer=false;
    
    
    
    public void setX(int x){
        currentX=x;
    }
    public void setY(int y){
        currentY=y;
    }
    public void setBound(Bounds bs){
        bounds = bs;
    }
    public void setGrid(Grid g){
        grid = g;
    }
    public void step(){
        if ( currentX < bounds.xmax() )currentX++;
        else {
            currentX = bounds.xmin();
            if ( currentY < bounds.ymax() )currentY++;
            else currentY = bounds.ymin();
        }
    }
    public void paintViz(Graphics2D g){
        if(paintBuffer)paintBuffer(g);
        else{
            if(paintIntersect)paintIntersect(g);
            if(paintDifference)paintDifference(g);
            if(paintRules)paintRules(g);
            }
    }
    public void paintIntersect(Graphics2D g){
        
    }
    public void paintDifference(Graphics2D g){
        
    }
    public void paintRules(Graphics2D g){
        
    }
    public void paintBuffer(Graphics2D g){
        
    }
    public void togglePaintIntersect(){
        if(paintIntersect)paintIntersect=false;
        else paintIntersect = true;
    }
    public void togglePaintDifference(){
        if(paintDifference)paintDifference=false;
        else paintDifference=true;
    }
    public void togglePaintRules(){
        if(paintRules)paintRules=false;
        else paintRules=true;
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
}
