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
        int opacity = 90; //grid covers background image
        Color col = new Color ( 136, 177, 245, opacity );
        int mS = 40; //grid unit size
        int width = 8;
        int height = 8;
        
        Grid (  ) {            
        }
        
        public void changeWidth( int w ) { width = w; }
        public void changeHeight( int h ) { height = h; }
        public void changeModuleSize( int m ) { mS = m; }
        
        public void paintGrid ( Graphics2D g, int w, int h ) {
            int offX = ( w - width*mS ) / 2;
            int offY = ( h - height*mS ) / 2;

            g.setStroke(new BasicStroke(1F));
            g.setColor( Color.BLACK );
            for (int x = 0; x <= width; ++x) {
                g.drawLine( x*mS + offX, offY, x*mS + offX, height*mS + offY );
            }
            for (int y = 0; y <= height; ++y ) {
                g.drawLine( offX, y*mS + offY, width*mS + offX, y*mS + offY);
            }
            
            g.setColor(col);
            g.fillRect(0, 0, w, h);
            g.setStroke(new BasicStroke(3F));
            
            g.setColor( new Color( 0,255,0,100 ) );
            g.drawLine( w / 2, 0, w / 2, h );
            g.setColor( new Color( 255,0,0,100 ) );
            g.drawLine( 0, h / 2, w, h / 2);
            g.setStroke(new BasicStroke(1F));
            
        }
     
    }
