/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author owenpaulmeyer
 */
public class Source {
    private Child element;
    //the adjacencyList serves as a lookup table for Rule application,
    //where the Childs in the intersection of the Source and the
    //Design are looked up in this table
    private Rules adjacencyList;
    private Bounds bounds;  //used for quickening rebounding per location for intersection
    //HashSet<Connection> edges;
    private int size;

    public Source( Child c ) {
        element = c;
        setBounds();
        size = Child.flattenConnections(c).size();
        //edges = Child.flattenConnections(c);
    }
    public Child element(){
        return element;
    }
    public ArrayList<Child> children(){
        return element.children();
    }
    public Bounds bounds(){
        return bounds;
    }
    public int size(){
        return size;
    }
    //computes the field for this object
    private void setBounds(){
        int xmin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE;
        int ymin = Integer.MAX_VALUE;
        int ymax = Integer.MIN_VALUE;
        Bounds bs = new Bounds(xmin,xmax,ymin,ymax);
        for( Child c:element.children())
            bs = Bounds.maxminBounds(bs,bounds(c));
        bounds = bs;
    }
    //used external to this class
    public static Bounds bounds(Child ch){
        int xmin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE;
        int ymin = Integer.MAX_VALUE;
        int ymax = Integer.MIN_VALUE;
        Bounds rtn = new Bounds(xmin,xmax,ymin,ymax);
        if (ch.isEmpty()){
            xmin = ch.location().xLoc();
            xmax = ch.location().xLoc();
            ymin = ch.location().yLoc();
            ymax = ch.location().yLoc();
            return new Bounds(xmin,xmax,ymin,ymax);
        }
        else for ( Child c:ch.children()){
            rtn = Bounds.maxminBounds(rtn,bounds(c));
        }
        return rtn;
    }
//    public HashSet<Connection> edges(){
//        return edges;
//    }
    public Rules lookupTable(){
        return adjacencyList;
    }
    
    //old adjList for generation without Intersect class
    private static Rules adjacencyList(Child located){
        Rules rtn = new Rules();
        for ( Child child : located.children() ){
            rtn.makeAddRules(located, child);
            if (!child.isEmpty()) rtn.union(adjacencyList(child));
        }
        return rtn;
    }
    
    //new adjList for Intersect Class
//    private static Rules adjacencyList(Child located){
//        Rules rtn = new Rules();
//        for ( Child child : located.children() ){
//            if(!child.isEmpty()){
//                rtn.makeAddRules(located, child);
//                rtn.union(adjacencyList(child));
//            }
//        }
//        return rtn;
//    }
    
    
    public void setAdjacencyList(){
        adjacencyList = adjacencyList(element);
    }
    //this returns the Source @ the specified location with it's
    //located adjacencyList which serves as a lookup for Rule application
    public Source locate(Location l){
        Source located = new Source(Child.locate(element, l));
        located.setAdjacencyList();
        return located;
    }
    public static int interSize(HashSet<Child> list, Source located){
        int rtn = 0;
        for ( Connection cn : located.element().connections() ){
            if ( list.contains(cn.a())&&list.contains(cn.b())) ++rtn;
        }
        return rtn;
    }
    @Override
    public String toString(){
        return element.toString();
    }
    public void display(){
        element.displayChildren();
    }
}
