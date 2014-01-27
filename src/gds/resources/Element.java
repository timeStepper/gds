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
    private HashSet< Child > children;
    private HashSet< Connection > connections;
    
    Element ( ) {
        children  = new HashSet<  >( );
        connections = new HashSet<  >( );
    }
    HashSet< Child > children( ) {
        return children;
    }
    HashSet< Connection > connections( ) {
        return connections;
    }
    
    boolean isEmpty( ) {
        return children.isEmpty() && connections.isEmpty();
    }
    
    public void addChild( Element e, Location l, int s ) {
        Child c = new Child ( e, l, s );
        children.add( c );
    }
    
    public void addConnection( Child a, Child b ) {
        Connection c = new Connection ( a, b );
        connections.add( c );
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
    
    Child ( Element e, Location l, int s ) {
        child = e;
        location = l;
    }
    
    Element child( ) {
        return child;
    }
    Location location( ) {
        return location;
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
        
        return  child.equals( c.child( ) ) &&
                location.equals( c.location( ) );
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
