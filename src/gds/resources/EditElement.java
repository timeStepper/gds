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
        int originX;        //used for painting
        int originY;        //used for painting
        int module = 40;    //used for painting
        Element element = new Element();
        Element selection;
        Element addable;
        
        public void setAddable( Element e ){
            addable = e;
        }
        public void setSelection( Element e ){
            selection = e;
        }
        
        public void addEmpty( Location l ) {
            element.addChild( Element.empty(), l );
        }
        public void addElement( Location l, Element e ){
            element.addChild( e, l);
        }
        
        
      //painting methods
        public void paintEdit( Graphics2D g ) {
            if ( !element.isEmpty() ) paintElement( g, element );
        }
        public void paintElement( Graphics2D g, Element e ) {
        for ( Connection c : e.connections() )
            paintConnection(g, c);
        for ( Child c : e.children() )
            paintLocation(g, c.location());
        }
        public void paintLocation(Graphics2D g, Location l) {
            g.setColor(Color.WHITE);
            g.fillOval(originX+(l.xLoc()*module)-4, originY+(l.yLoc()*module)-4, 8, 8);
            g.setColor(Color.BLACK);
            g.drawOval(originX+(l.xLoc()*module)-4, originY+(l.yLoc()*module)-4, 8, 8);
        }
        public void paintConnection( Graphics2D g, Connection c ) {
            int x1 = c.a().location( ).xLoc( );
            int y1 = c.a().location( ).yLoc( );
            int x2 = c.b().location( ).xLoc( );
            int y2 = c.b().location( ).yLoc( );
            g.drawLine( x1, y1, x2, y2 );
        }
        public void setModule( int m ) {
            module = m;
            System.out.println( "module " + module);
        }
        public void setX( int x ) {
            originX = x;
        }
        public void setY( int y ) {
            originY = y;
        }

    }
