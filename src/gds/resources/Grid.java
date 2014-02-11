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
public class Grid {
        int opacity = 110; //grid covers background image
        Color col = new Color ( 130, 130, 130, opacity );
        int mS = 40; //grid unit size
        int width = 8;
        int height = 8;
        int currentX;
        int currentY;
        int originX;
        int originY;
        boolean select = false;
        boolean paintGrid = true;
        
        public void selectOn() {
            select = true;
        }
        public void selectOff() {
            select = false;
        }
        
      //used for relating grid lines to display for editing elements
        public void setOriginX( int x ) {
            originX = x;
        }
        public void setOriginY( int y ) {
            originY = y;
        }
        public boolean isLocation( int x, int y ) {
            return true;
        }
        public int currentX() {
            return currentX;
        }
        public int currentY() {
            return currentY;
        }
        public int originX() {
            return originX;
        }
        public int originY() {
            return originY;
        }
        public void setX( int xLoc ) {
            if ( xLoc - originX < 0 ) currentX = (xLoc-6 - originX)/mS;
            else currentX = (xLoc+6 - originX)/mS;
        }
        public void setY( int yLoc ) {
            if ( yLoc - originY < 0 ) currentY = (yLoc-6 - originY)/mS ;
            else currentY = (yLoc+6 - originY)/mS ;
        }
        public boolean isReticle( int xLoc, int yLoc ) {
            int modX = Math.abs((originX - xLoc) % mS);
            int modY = Math.abs((originY- yLoc) % mS);
            int hereX = Math.abs(xLoc - originX);
            int hereY = Math.abs(yLoc - originY);
            int halfX = ((width / 2) * mS);
            int halfY = ((height / 2) * mS);
            return ((modX < 5 || modX > mS - 5) && (modY < 5 || modY > mS - 5)
                    && hereX < halfX && hereY < halfY);
        }
        
      //grid setters
        public void changeWidth( int w ) { width = w; }
        public void changeHeight( int h ) { height = h; }
        public void changeModuleSize( int m ) { mS = m; }
        
        public void toggleGrid(){
            if( paintGrid )paintGrid=false;
            else paintGrid = true;
        }
        public void paintGrid ( Graphics2D g, int w, int h ) {
            if ( paintGrid )paintGridCall(g,w,h);
            g.setStroke(new BasicStroke(3F));
            g.setColor( new Color( 0,200,0,100 ) );
            g.drawLine( w / 2, 0, w / 2, h );
            g.setColor( new Color( 200,0,0,100 ) );
            g.drawLine( 0, h / 2, w, h / 2);
            g.setStroke(new BasicStroke(1F));
        }
        private void paintGridCall ( Graphics2D g, int w, int h ) {
            int offX = ( w - width*mS ) / 2;
            int offY = ( h - height*mS ) / 2;
            
            //semi opaque backdrop covers background image
            g.setColor(col);
            g.fillRect(0, 0, w, h);

            g.setStroke(new BasicStroke(1F));
            g.setColor( Color.BLACK );
            for (int x = 0; x <= width; ++x) {
                g.drawLine( x*mS + offX, offY, x*mS + offX, height*mS + offY );
            }
            for (int y = 0; y <= height; ++y ) {
                g.drawLine( offX, y*mS + offY, width*mS + offX, y*mS + offY);
            }
        }
        public void setOpacity( int o ) {
            opacity = o;
            col = new Color ( 100, 100, 100, opacity );
        }
        public void paintAddable(Graphics2D g, Element e){
            if ( select ) {
                if ( e.isEmpty() ){
                    g.setColor(new Color(255,255,255,200));
                    g.fillOval(originX+(currentX*mS)-6, originY+(currentY*mS)-6, 12, 12);
                }
                else
                    paintAddableElement( g, e );
            }
        }
        public void paintAddableElement( Graphics2D g, Element e ) {
        for ( Connection c : e.connections() )
            paintAddableConnection(g, c);
        for ( Child c : e.children() )
            paintAddableLocation(g, c.location());
        }
        public void paintAddableLocation(Graphics2D g, Location l) {
            g.setColor(new Color( 255,255,255,180));
            g.fillOval(originX+(currentX*mS)-6+(l.xLoc()*mS), originY+(currentY*mS)-6+(l.yLoc()*mS), 12, 12);
            g.setColor(new Color( 255,255,255,180));
            g.drawOval(originX+(currentX*mS)-6+(l.xLoc()*mS), originY+(currentY*mS)-6+(l.yLoc()*mS), 12, 12);
        }
        public void paintAddableConnection( Graphics2D g, Connection c ) {
            int x1 = c.a().location( ).xLoc( );
            int y1 = c.a().location( ).yLoc( );
            int x2 = c.b().location( ).xLoc( );
            int y2 = c.b().location( ).yLoc( );
            g.drawLine( x1, y1, x2, y2 );
        }
        public void paintHighlightedLocation(Graphics2D g, Location l) {
            g.setColor(new Color( 255,255,255,180));
            g.fillOval(originX-6+(l.xLoc()*mS), originY-6+(l.yLoc()*mS), 12, 12);
            g.setColor(new Color( 255,255,255,180));
            g.drawOval(originX-6+(l.xLoc()*mS), originY-6+(l.yLoc()*mS), 12, 12);
        }
    }
