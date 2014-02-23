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
        if (value==.1)value = c.getValue()*1.25;
        else value += c.getValue()*1.25;
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
class Child {
    private Element child;
    private Location location;
    private String name;
    //private double value = 1;
    
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
    public Element element( ) {
        return child;
    }
    public Location location(){
        return location;
    }
    ArrayList< Child > children(){
        return element().children();
    }
    ArrayList< Connection > connections() {
        return element().connections();
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
    public boolean containsAll(HashSet<Connection> cns){
        for(Connection cn : cns)
            if (!connections().contains(cn)) return false;
        return true;
    }
    public boolean containsAllEmpties(){
        if (isEmpty())return false;
        else
            for (Child ch: children()){
                if (!ch.isEmpty())return false;
            }
        return true;
    }
//    public double value(){
//        return value;
//    }
//    public void setValue(double v){
//        value = v;
//    }
    public double getValue(){
        return element().value();
    }
    //this is used for paint purposes only
    public Child locateToPaint( Location l ){
        return new Child ( element(), location().add( l ));
    }
    //this is the method to call for getting the located version of a child
    public static Child locate( Child c, Location l ){
        Child rtn = c.clone();
        rtn.located(l);
        return rtn;
    }
    //helper to static locate
    private void located( Location l ){
        if (!isEmpty())
            for ( Child ch : children() ){
                ch.location = ch.location.add(l);
                ch.located(ch.location());
            }
    }
    //public static ArrayList<Child> 
    //this version will double up on recurances
    public static ArrayList<Child> flattenChildren( Child c){
        Child ch = locate(c,c.location());
        return flattenChildrenCall(ch);
    }
    private static ArrayList<Child> flattenChildrenCall( Child c){
        ArrayList<Child> empties = new ArrayList<>();
        if ( c.isEmpty() ) empties.add(c);
        else for ( Child ch : c.children() )
            empties.addAll( flattenChildrenCall( ch ));
        return empties;
    }
    //flattens to empty edges
    public static HashSet<Connection> flattenConnections( Child c ){
        Child ch = locate(c,c.location());
        return flattenConnectionsCall(ch);
    }
    private static HashSet<Connection> flattenConnectionsCall( Child c ){
        HashSet<Connection> edges = new HashSet<>();
        if ( c.isEmpty())return edges;
        else for ( Child ch : c.children() )
            for ( Connection cn : flattenConnectionsCall( ch ) )
                if (!edges.contains(cn))edges.add(cn);
        for ( Connection cn : c.connections() )
            if ( cn.a().isEmpty() ) edges.add(cn);
        return edges;
    }
    public static HashSet<Edge> flattenEdges(Child c){
        Child ch = locate(c,c.location());
        return flattenEdgesCall(ch);
    }
    private static HashSet<Edge> flattenEdgesCall(Child c){
        HashSet<Edge> edges = new HashSet<>();
        if ( c.isEmpty())return edges;
        else for ( Child ch : c.children() )
            for ( Connection cn : flattenConnectionsCall( ch ) ){
                Edge e = new Edge(cn.aLoc(),cn.bLoc());
                if (!edges.contains(e))edges.add(e);
            }
        for ( Connection cn : c.connections() ){
            //if ( cn.a().isEmpty() ) edges.add(cn);
        }
        return edges;
    }
    public void translate( int x, int y ){
        location = location().add(new Location( x, y));
    }
    public void transform( Transform t ){
        if (isEmpty()) location =  Transform.transform(t, location);
        else {
            location =  Transform.transform(t, location);
            for ( Child c : children() )
                c.transform( t );
        }
    }
    public int xLoc(){
        return location().xLoc();
    }
    public int yLoc(){
        return location().yLoc();
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
        if (isEmpty())
            return "[E: "+location.toString()+", "+getValue()+"]";
        else return "[P: "+location.toString()+", "+getValue()+"]";
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
        
        return  child.equals( c.element( ) ) &&
                location.equals( c.location( ) );
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.location);
        return hash;
    }
    public void displayChildren(){
        System.out.println("ChildrenOf: "+this);
        for(Child c : children())
            //System.out.println(c);
            display("", c);
    }
    public void display( String tab, Child ch ){
        System.out.println( tab+ch);
        for (Child c : ch.children()) {
            display(tab + "  ", c);
        }
    }
    public void displayConnections(){
        System.out.println("Connections:");
        for ( Connection cn : connections() ){
            System.out.println(cn);
        }
        System.out.println();
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