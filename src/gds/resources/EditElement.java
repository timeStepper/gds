/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.NoSuchElementException;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author owenpaulmeyer
 * EditElement is the central control of element editing, handling the updates
 * between the dynamicTree, childList, connectionList and the element data
 * structure which is within EditElement
 */
public class EditElement {
        int originX;        //used for painting
        int originY;        //used for painting
        int module = 40;    //used for painting
        Element element;// = null;//new Element();
        Child selected; //rootNode of elementTree must be Child
        ChildrenList selected_ChildrenList;
        ConnectionsList selected_ConnectionsList;
        Element addable = null;//the element that can be added to the current selection by mouse clicks
        DynamicTree dynamicTree;
        
        EditElement ( DynamicTree dt, ChildrenList cL, ConnectionsList cnL ){
            dynamicTree = dt;
            //System.out.println( "dynamic tree " + dt );
            element = dynamicTree.root().childElement();
            selected = dynamicTree.root();
            selected_ChildrenList = cL;
            selected_ConnectionsList = cnL;
        }
        public void resetRoot(){
            dynamicTree.clear();
            selected = dynamicTree.root();
            Child root = dynamicTree.root();
            root = new Child();
            changeSelected( root );
        }
        public void setAddable( Element e ){
            addable = e;
        }
        /*
        allows moving around in the global element
        records the current state of the Lists
        updates the Lists to the current selected
        */
        public void changeSelected( Child c ){
            updateChildrenList( c );
            selected = c;
        }
        public void updateChildrenList( Child c ){
            selected_ChildrenList.removeAll();
            for ( Child child : c.childElement().children() )
                selected_ChildrenList.addChild(child);
        }
        public void addChild( Child c ){
            if ( c.childElement().isEmpty() ) c = new Child( new Element(), c.location() );
            if ( selected_ChildrenList.alreadyInList(c) )return;
            selected.childElement().addChild(c);
            dynamicTree.addObject(c);
            selected_ChildrenList.addChild(c);
//            new Child( element, new Location(0,0)).display();
//            System.out.println();
        }
        public void removeChild( Location l )throws NoSuchElementException{
            //Child c = new Child ( addable, l );
            try{
                Child c = selected.childElement().childAt(l);
                selected.childElement().removeChild(c);
                selected_ChildrenList.removeChild(c);
                dynamicTree.removeChild(c);
                //the following commented out for testing in case dynamic tree throws this error
//                try {
//                    dynamicTree.removeChild(c);
//                }catch (NoSuchElementException exc){
//                    System.out.println( "wow: "+exc);
//                }
            }catch (NoSuchElementException nse){
                System.out.println("err: "+nse);
            }
            
        }
        public Element addable() {
            return addable;
        }
        
        //painting methods;  the current selected child's element is what is painted
        public void paintEdit( Graphics2D g ) {
            if ( selected.childElement() != null ) paintElement( g, selected.childElement() );
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
            
        }
        public void setX( int x ) {
            originX = x;
        }
        public void setY( int y ) {
            originY = y;
        }
        
        class Lists {
            ChildrenList childrenList;
            //ConnectionList connectionList;
            
            void setCurrenList( ChildrenList cl ){
                childrenList = cl;
            }
//            void setConnectionList( ConnectionList cl ){
//                connectionList = cl;
//            }
        }

    }
