package gds.resources;


import java.util.ArrayList;
import java.util.NoSuchElementException;

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
    
    Element ( ) {
        children  = new ArrayList<  >( );
        connections = new ArrayList<  >( );
    }
    Element( ArrayList<Child> childs, ArrayList<Connection> conns){
        children = childs;
        connections = conns;
    }
    ArrayList< Child > children( ) {
        return children;
    }
    ArrayList< Connection > connections( ) {
        return connections;
    }
    public Element clone(){
        ArrayList<Child> childs = new ArrayList<>();
        ArrayList<Connection> conns = new ArrayList<>();
        for ( Child c : children )
            childs.add(c.clone());
        for ( Connection cn : connections ){
            int idxA = childs.indexOf(cn.a());
            int idxB = childs.indexOf(cn.b());
            conns.add(new Connection( childs.get(idxA), childs.get(idxB) ));
        }
        return new Element( childs, conns );
    }
    boolean isEmpty( ) {
        return children.isEmpty();
    }
    
    public void addChild( Child c ) {
        children.add( c );
    }
    public void removeChild( Child c ){;
        if ( children.contains( c ) )
            children.remove( c );
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


class Child {
    private Element child;
    private Location location;
    private String name;
    
    Child ( Element e, Location l ) {
        if (e==null)return;//prevents:  don't know why the first attempt to make child with null element works???
        child = e;
        location = l;
        name = "empty";
    }
    Child ( ) {
        name = "root";
        child = new Element();
        location = new Location( 0, 0 );
    }
    public void empty(){
        child = new Element();
    }
    public boolean isEmpty(){
        return child.isEmpty();
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
    public Child childAt( Location l )throws NoSuchElementException{
        try{
            return child.childAt(l);
        }catch(NoSuchElementException nse){
            throw nse;
        }
        
    }
    public Child locate( Location l ){
        return new Child ( child, location.add( l ));
    }
    
    public void translate( int x, int y ){
        location = location().add(new Location( x, y));
    }
    public void transform( Transform t ){
        if (isEmpty()) location =  Transform.transform(t, location);
        else {
            location =  Transform.transform(t, location);
            for ( Child c : childElement().children() )
                c.transform( t );
        }
    }
    public void rotateRight( ){
        transform(new Transform(0,(-1),1,0) );
    }
    public void rotateLeft( ){
        transform(new Transform(0,1,-1,0) );
    }
    public void reflectX( ){
        transform(new Transform(1,0,0,-1) );
    }
    public void reflectY( ){
        transform(new Transform(-1,0,0,1) );
    }
    public void scale( int s ){
        transform(new Transform(s,0,0,s) );
    }
    
    public Child clone(){
        return new Child( child.clone(), location );
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
    public Connection clone(){
        return new Connection( a.clone(), b.clone());
    }
    public Connection locate( Location l ){
        Child newA = a.locate(l);
        Child newB = b.locate(l);
        return new Connection( newA, newB );
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