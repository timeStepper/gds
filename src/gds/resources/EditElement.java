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
import java.util.NoSuchElementException;

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
        ArrayList< Child > highlighted = new ArrayList<>();
        ChildrenList selected_ChildrenList;
        ConnectionsList selected_ConnectionsList;
        Element addable = null;//the element that can be added to the current selection by mouse clicks
        DynamicTree dynamicTree;
        AddableList addableList;
        Grid grid;
        boolean paintEmpties = false;
        
        EditElement ( DynamicTree dt, ChildrenList cL, ConnectionsList cnL, Grid g ){
            
            dynamicTree = dt;
            //System.out.println( "dynamic tree " + dt );
            //element = dynamicTree.root().childElement();
            selected = dynamicTree.root();
            selected_ChildrenList = cL;
            selected_ConnectionsList = cnL;
            grid = g;
        }
        //needs further testing for garbage collection
        public void resetRoot(){
            dynamicTree.clear();
            Child root = dynamicTree.root();
//            System.out.println("bef " +root);
            root.empty();
            changeSelected( root );
            root = dynamicTree.root();
//            System.out.println( "aft " + root);
        }
        
        public void setAddable( Element e ){
            addable = e;
        }
        public void setAddableList( AddableList aL ){
            addableList = aL;
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
        public void highlight( Location l )throws NoSuchElementException{
            try {
                Child c = selected.childAt(l);
                if( highlighted.contains(c) ) highlighted.remove(c);
                else if ( highlighted.size()==2 ){
                    highlighted.set(0, highlighted.get(1));
                    highlighted.set(1, c);
                }else highlighted.add(c);
            } catch( NoSuchElementException nse ){}
        }
        public void makeConnection( ){
            if (highlighted.size() > 1){
                Child a = highlighted.get(0);
                Child b = highlighted.get(1);
                selected.childElement().addConnection(a, b);
            }
        }
        public void makeElement(){
            addableList.addElement(selected.childElement().clone());
        }
        public void breakElement(){
            ArrayList<Child> childs = new ArrayList<>();
            ArrayList<Connection> conns = new ArrayList<>();
            
        }
        /*
        allows moving around in the global element
        records the current state of the Lists
        updates the Lists to the current selected
        */
        public void changeSelected( Child c ){
            selected = c;
            updateChildrenList( c );
            highlighted.clear();
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
            dynamicTree.addChild(c);
            selected_ChildrenList.addChild(c);
//            new Child( element, new Location(0,0)).display();
//            System.out.println();
        }
        public void removeChild( Location l )throws NoSuchElementException{
            //Child c = new Child ( addable, l );
            try{
                Child c = new Child( addable, l );
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
        public void translate(int x, int y){
            for ( Child c : selected.childElement().children() )
                c.translate( x, y );
            dynamicTree.updateUI();
        }
        public void rotateLeft(){
            for ( Child c : selected.childElement().children() )
                c.rotateLeft();
            dynamicTree.updateUI();
        }
        public void rotateRight(){
            for ( Child c : selected.childElement().children() )
                c.rotateRight();
            dynamicTree.updateUI();
        }
        public void reflectX(){
            for ( Child c : selected.childElement().children() )
                c.reflectX();
            dynamicTree.updateUI();
        }
        public void reflectY(){
            for ( Child c : selected.childElement().children() )
                c.reflectY();
            dynamicTree.updateUI();
        }
        public void scale(int s){
            for ( Child c : selected.childElement().children() )
                c.scale(s);
            dynamicTree.updateUI();
        }
        public Element addable() {
            return addable;
        }
        public void renameAddable( String name ){
            addable.rename(name);
        }
        
        //painting methods;  the current selected child's element is what is painted
        public void paintEdit( Graphics2D g ) {
            if ( selected.childElement() != null ) {
                if(paintEmpties) paintEmpties( g, selected );
                else paintElement( g, selected.childElement() );
            }
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
            g.setColor(Color.WHITE);
            //g.setStroke(new BasicStroke(2F));
            int x1 = c.a().location( ).xLoc( );
            int y1 = c.a().location( ).yLoc( );
            int x2 = c.b().location( ).xLoc( );
            int y2 = c.b().location( ).yLoc( );
            g.drawLine( x1*module + originX, y1*module + originY, x2*module + originX, y2*module + originY );
            //g.setStroke(new BasicStroke(1F));
            //g.setColor(Color.BLACK);
            //g.drawLine( x1*module + originX, y1*module + originY, x2*module + originX, y2*module + originY );
        }
        
        public void paintEmpties( Graphics2D g, Child c ){
            if ( c.childElement().isEmpty()) {
                
                paintLocation( g, c.location());
            }
            else {
                for ( Connection conn : c.childElement().connections() )
                    paintEmptyConnection( g, conn.locate(c.location()));
                for ( Child child : c.childElement().children())
                    paintEmpties( g, child.locate(c.location()));
            }
        }
        public void paintEmptyConnection( Graphics2D g, Connection c ) {
            g.setColor(Color.WHITE);
            //g.setStroke(new BasicStroke(2F));
            int x1 = c.a().location( ).xLoc( );
            int y1 = c.a().location( ).yLoc( );
            int x2 = c.b().location( ).xLoc( );
            int y2 = c.b().location( ).yLoc( );
            g.drawLine( x1*module + originX, y1*module + originY, x2*module + originX, y2*module + originY );
            //g.setStroke(new BasicStroke(1F));
            //g.setColor(Color.BLACK);
            //g.drawLine( x1*module + originX, y1*module + originY, x2*module + originX, y2*module + originY );
        }
        public void paintHighlighted( Graphics2D g ){
            for ( Child c : highlighted ){
                grid.paintHighlightedLocation(g, c.location());
                
            }
        }
        

        public void paintAddable( Graphics2D g){
            grid.paintAddable(g, addable);
        }
        public void togglePaintEmpty(){
            if(paintEmpties)paintEmpties = false;
            else paintEmpties = true;
        }
    }
