/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 *
 * @author owenpaulmeyer
 */
public class Child {
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
//    public double getValue(){
//        return element().value();
//    }
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
        for ( Connection cn : c.connections() )
            //assuming no connections between empty and non empty childs:
            if ( cn.a().isEmpty() ) edges.add(cn);
        for ( Child ch : c.children() )
            for ( Connection cn : flattenConnectionsCall( ch ) )
                if (!edges.contains(cn))edges.add(cn);//rem dubs
        return edges;
    }
    public static HashSet<Edge> flattenEdges(Child c){
        //Child ch = locate(c,c.location());
        return flattenEdgesCall(c);
    }
    private static HashSet<Edge> flattenEdgesCall(Child c){
        HashSet<Edge> edges = new HashSet<>();
        if ( c.isEmpty())return edges;
        for ( Connection cn : c.connections() ){
            if ( cn.a().isEmpty() ) {
                Edge e = new Edge(cn.aLoc(),cn.bLoc());
                edges.add(e);
            }
        }
        for ( Child ch : c.children() )
            for ( Connection cn : flattenConnectionsCall( ch ) ){
                Edge e = new Edge(cn.aLoc(),cn.bLoc());
                if (!edges.contains(e))edges.add(e);
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
    
    @Override
    public Child clone(){
        return new Child( child.clone(), location );//'child' is an Element
    }
    @Override
    public String toString() {
        if (isEmpty())
            return "[E: "+location.toString()+"]";
        else return "[P: "+location.toString()+"]";
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
