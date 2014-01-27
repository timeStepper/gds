/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author owenpaulmeyer
 */
public class EditElement {
        Element editable;
        
        public void initEdit( ) {
            editable = new Element( );
        }
        
        public void paintEdit( Graphics2D g ) {
            paintElement( g, editable );
        }
        
        public void paintElement( Graphics2D g, Element e ) {
        for ( Connection c : e.connections() )
            paintConnection(g, c);
        for ( Child c : e.children() )
            paintLocation(g, c.location());
        }
        public void paintLocation(Graphics2D g, Location l) {
            g.setColor(Color.WHITE);
            g.fillOval(l.xLoc(), l.yLoc(), 8, 8);
            g.setColor(Color.BLACK);
            g.drawOval(l.xLoc(), l.yLoc(), 8, 8);
        }
        
        public void paintConnection( Graphics2D g, Connection c ) {
            int x1 = c.a().location( ).xLoc( );
            int y1 = c.a().location( ).yLoc( );
            int x2 = c.b().location( ).xLoc( );
            int y2 = c.b().location( ).yLoc( );
            g.drawLine( x1, y1, x2, y2 );
        }

    }
