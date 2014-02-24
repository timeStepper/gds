package gds.resources;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
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
    String name = "!";
    private double value=0;
    
    Element ( ) {
        children  = new ArrayList<  >( );
        connections = new ArrayList<  >( );
        value = .1;
    }
    Element( ArrayList<Child> childs, ArrayList<Connection> conns, double val ){
        children = childs;
        connections = conns;
        value = val;
    }
    ArrayList< Child > children( ) {
        return children;
    }
    ArrayList< Connection > connections( ) {
        return connections;
    }
    double value(){
        return value;
    }
    public void setValue( double v ){
        value = v;
    }
    @Override
    public Element clone(){
        //double val = value();
        ArrayList<Child> childs = new ArrayList<>();
        ArrayList<Connection> conns = new ArrayList<>();
        for ( Child c : children )
            childs.add(c.clone());
        for ( Connection cn : connections ){
            int idxA = childs.indexOf(cn.a());
            int idxB = childs.indexOf(cn.b());
            conns.add(new Connection( childs.get(idxA), childs.get(idxB) ));
        }
        return new Element( childs, conns, value );
    }
    boolean isEmpty( ) {
        return children.isEmpty();
    }
    public void addChild( Child c ) {
        children.add( c );
//        if (value==.1)value = c.getValue()*1.25;
//        else value += c.getValue()*1.25;
    }
    public void removeChild( Child c ){
        if ( children.contains( c ) )
            children.remove( c );
    }
    public void removeConnection( Child ch ){
        ArrayList<Connection> removes = new ArrayList<>();
        for ( Connection cn : connections ){
            if( cn.a().equals(ch) || cn.b().equals(ch))
                removes.add(cn);
        }
        for ( Connection cn : removes )
            connections.remove(cn);
    }
    public Child childAt( Location l )throws NoSuchElementException{
        for( Child c: children)
            if (c.location().equals(l))return c;
        throw new NoSuchElementException();
    }
    public void addConnection( Child a, Child b ) {
        Connection c = new Connection ( a, b );
        connections.add( c );
    }
    public void rename( String nm ){
        name = nm;
    }
    
    @Override
    public String toString(  ) {
        if ( isEmpty() ) return "Empty";
        else return name;
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
    public Location add( Location l  ){
        return new Location( xCoord+l.xLoc(), yCoord+l.yLoc());
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.xCoord;
        hash = 29 * hash + this.yCoord;
        return hash;
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
    Location aLoc(){
        return a.location();
    }
    Location bLoc(){
        return b.location();
    }
    public Connection clone(){
        return new Connection( a.clone(), b.clone());
    }
    public Connection locate( Location l ){
        Child newA = a.locateToPaint(l);
        Child newB = b.locateToPaint(l);
        return new Connection( newA, newB );
    }
    public boolean isEmpty(){
        return a.isEmpty() && b.isEmpty();
    }
    public boolean equalsEdge(Edge e){
        Location la = new Location(e.aX(),e.aY());
        Location lb = new Location(e.bX(),e.bY());
        if ( la.equals(aLoc()))return lb.equals(bLoc());
        else if ( la.equals(bLoc()))return lb.equals(aLoc());
        else return false;
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

    @Override
    public int hashCode() {
        int hash = (a.xLoc()*a.yLoc()) + (b.xLoc()*b.yLoc());
        return hash;
    }
    @Override
    public String toString(){
        return "["+a().location()+", "+b().location()+"]";
    }
    
}
class Transform{
    int a;
    int b;
    int c;
    int d;
    
    Transform( int a1, int b1, int c1, int d1 ){
        a = a1;
        b = b1;
        c = c1;
        d = d1;
    }
    public static Location transform( Transform t, Location l ){
        int lx;
        int ly;
        lx = (t.a*l.xLoc())+(t.b*l.yLoc());
        ly = (t.c*l.xLoc())+(t.d*l.yLoc());
        return new Location( lx, ly );
    }
}