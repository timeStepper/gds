package gds.resources;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author owenpaulmeyer
 */
public class Element {
    private ArrayList< Child > children;
    private ArrayList< Connection > connections;
    
    Element ( ) {
        children  = new ArrayList<  >( );
        connections = new ArrayList<  >( );
    }
    ArrayList< Child > children( ) {
        return children;
    }
    ArrayList< Connection > connections( ) {
        return connections;
    }
    
    boolean isEmpty( ) {
        return children.isEmpty() && connections.isEmpty();
    }
    
    public void addChild( Child c ) {
        children.add( c );
    }
    public void removeChild( Child c ){;
        if ( children.contains( c ) )
            children.remove( c );
    }
    
    public void addConnection( Child a, Child b ) {
        Connection c = new Connection ( a, b );
        connections.add( c );
    }
    
    @Override
    public String toString(  ) {
        if ( isEmpty() ) return "Empty";
        else return "!";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Element e = ( Element ) obj;
        
        return  children.equals( e.children( ) ) &&
                connections.equals( e.connections( ) );
    }
}


class Child {
    private Element child;
    private Location location;
    private String name;
    
    Child ( Element e, Location l ) {
        if (e==null)return;//prevents:  don't know why the first attempt to make child with null element works???
        child = e;
        location = l;
        name = "empt";
    }
    Child ( ) {
        name = "root";
        child = new Element();
        location = new Location( 0, 0 );
    }
    
    Element childElement( ) {
        return child;
    }
    Location location( ) {
        return location;
    }
    
    public void setName( String n ){
        name = n;
    }
    @Override
    public String toString() {
        return "[ "+name+", "+location.toString()+"  ]";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Child c = ( Child ) obj;
        
        return  child.equals( c.childElement( ) ) &&
                location.equals( c.location( ) );
    }
    public void display(){
        display("");
    }
    public void display( String tab ){
        if ( child.isEmpty() ) System.out.println( tab+toString());
        else {
            for ( Child c : child.children() )
                c.display(tab+="  ");
        }
    }
}
class Location {
    private final int xCoord;
    private final int yCoord;
    
    Location ( int x, int y ) {
        xCoord = x; yCoord = y;
    }
    int xLoc( ) {
        return xCoord;
    }
    int yLoc( ) {
        return yCoord;
    }
    @Override
    public String toString() {
        return "( "+xCoord+", "+yCoord+" )";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Location l = ( Location ) obj;
        return l.xCoord == xCoord && l.yCoord == yCoord;
    }
}
class Connection {
    private Child a;
    private Child b;
    
    Connection( Child _a, Child _b ) {
        a = _a; b = _b;
    }
    
    Child a( ) {
        return a;
    }
    Child b( ) {
        return b;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Connection c = ( Connection ) obj;
        if ( a.equals( c.a( ) ) ) return b.equals( c.b( ) );
        else if ( a.equals( c.b ( ) ) ) return b.equals( c.a( ) );
        else return false;
    }
    
}
