/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author owenpaulmeyer
 */
public class Design {
    private HashSet<Location> nodes = new HashSet<>();
    private HashMap<Edge, Weight> edges = new HashMap<>();
    
    public boolean isOccupied(int x, int y ){
        return contains(new Location(x,y));
    }
    public boolean contains(Location l){
        return nodes.contains(l);
    }
//    public boolean contains(Child c){
//        return contains(c.location());
//    }
    private boolean contains(Connection conn){
        Edge e = new Edge(conn.aLoc(),conn.bLoc());
        return edges.containsKey(e);
    }
    public HashSet<Location> grid(){
        return nodes;
    }
    public Set<Edge> edges(){
        return edges.keySet();
    }
    
    public void setSeed( Child child ){
        nodes.clear();
        edges.clear();
        ArrayList<Child> kids = Child.flattenChildren(child);
        ArrayList<Connection> conns = Child.flattenConnections(child);
        for ( Child c : kids ){
            plant(c);
        }
        for ( Connection con : conns )
            edges.put(new Edge(con.aLoc(),con.bLoc()), new Weight());
    }
    //helper to setSeed
    private void plant( Child child ){
        if (child.isEmpty()) {
            addNode(child);
        }
        else {
            for ( Child c : child.children() ){
                plant(c);
            }
            addEdges( child );  
        }
    }
    public void addEdge( Edge e ){
        edges.put(e,new Weight());
    }
    private void addEdges( Child c ){
        for ( Connection cn : c.connections() )
            addEdge( new Edge(cn.aLoc(),cn.bLoc()));
    }
    public void addNode( Child child ){
        Location l = child.location();
        nodes.add(l);
    }
    //used for getting the Bounded region of the Design
    public static Design bounded( Bounds bounds, Design d ){
        Design rtn = new Design( );
        for ( Location l : d.nodes ){
            int x = l.xLoc();
            int y = l.yLoc();
            if ( bounds.isBounded(x, y) ){
                Location loc = new Location(x,y);
                rtn.nodes.add(loc);
            }
        }
        Set<Edge> keys = d.edges.keySet();
        for ( Edge e : keys )
            if(bounds.isBounded(e))
                rtn.addEdge(e);
        return rtn;
    }
    public static Design difference( Child located, Design bounded ){
        Design difference = new Design();
        ArrayList<Connection> edges = Child.flattenConnections(located);
        for ( Connection cn : edges ){
            if ( !bounded.contains(cn) ) {
                Edge e = new Edge(cn.aLoc(),cn.bLoc());
                difference.addEdge(e);
            }
        }
        return difference;
    }
    //helper to intersection
    public static HashSet<Child> intersect( Child located, Design bounded ){
        HashSet<Child> intersections = new HashSet<>();
        //this method starts on the following for loop
        //recognizing that 'locted' will always be the root Child.
        for ( Child c : located.children())
            if (c.isEmpty()) {
                if (bounded.contains(c.location())) {
                    if (!intersections.contains(c)) {
                        intersections.add(c);
                    }
                }
            }
            else intersections = union(intersections,intersect(c,bounded));
        if ( containsAll(intersections, located.children()) ){
                //&& bounded.containsAllConnections(located.connections())){
//            if ( areAllEmpties(located.children())){
//                if ( bounded.containsAllConnections(located.connections()))
//                    intersections.add(located);
//            }
//            else 
              intersections.add(located);
        }
        return intersections;
    }
    //helper to intersect;  a contains all b
    private static boolean containsAll(HashSet<Child> a, ArrayList<Child> b){
        for (Child c : b)
            if ( !a.contains(c) )return false;
        return true;
    }
    //helper to intersect
    private static HashSet<Child> union(HashSet<Child> a, HashSet<Child> b){
        HashSet<Child> rtn = new HashSet<>();
        for ( Child ca : a )
            rtn.add(ca);
        for (Child cb : b )
            if (!rtn.contains(cb))
                rtn.add(cb);
        //System.out.println("union: "+rtn);
        return rtn;
    }
    //helper to intersect
//    private static boolean areAllEmpties(ArrayList<Child> cs){
//        for( Child c : cs)
//            if (!c.isEmpty())return false;
//        return true; 
//    }
    //helper to intersect
//    private boolean containsAllConnections( ArrayList<Connection> conns ){
//        for ( Connection cn : conns )
//            if ( contains(cn) )return false;
//        return true;
//    }
    public void applyRules( Rules rules, Weight weight ){
        Set<Child> keys = rules.keySet();
        for( Child lhs : keys )
            for ( Child rhs : rules.get(lhs) ){
                Edge e = new Edge( lhs.location(), rhs.location() );
                
            }
    }
    @Override
    public String toString(){
        return nodes.toString();
    }
}
class Source {
    Child element;
    Child located;
    Rules adjacencyList = new Rules();
    Bounds bounds;  //used for quickening rebounding per location for intersection

    Source( Child c ) {
        element = c;
    }
    public Child element(){
        return element;
    }
    //computes the field for this object
    private void bounds(){
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
    //returns the connections between children. for use after the input is located
    //the initial call notes that there is always a global child ( the parent element )
    private Rules adjacencyList(Child located){
        Rules rtn = new Rules();
//        System.out.println("located: "+located);
//        System.out.println("located children: "+located.children());
//        System.out.println("located connections: "+located.connections());
        for ( Child child : located.children() ){
            rtn.makeAddRules(located, child);
            if (!child.isEmpty()) rtn.union(adjacencyList(child));
        }
        return rtn;
    }
    public void setAdjacencyList(Child located){
        Rules adj = adjacencyList(located);
        adjacencyList = adj;
    }
    public void locate(Location l){
        located = Child.locate(element, l);
        setAdjacencyList(located);
    }
}

class Edge{
    private Location nodeA;
    private Location nodeB;
    
    Edge( Location a, Location b ){
        nodeA = a;
        nodeB = b;
    }
    public Location nodeA(){
        return nodeA;
    }
    public Location nodeB(){
        return nodeB;
    }
    
    public int aX(){
        return nodeA.xLoc();
    }
    public int aY(){
        return nodeA.yLoc();
    }
    public int bX(){
        return nodeB.xLoc();
    }
    public int bY(){
        return nodeB.yLoc();
    }
    @Override
    public String toString(){
        return "["+nodeA+", "+nodeB+"]";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Edge e = ( Edge ) obj;
        
        return  (nodeA.equals( e.nodeA( ) ) && nodeB.equals( e.nodeB( ) )) ||
                (nodeA.equals( e.nodeB( ) ) && nodeB.equals( e.nodeA( ) ));
    }

    @Override
    public int hashCode() {
        int hash;
        hash = (nodeA.xLoc()*nodeA.yLoc()) + (nodeB.xLoc()*nodeB.yLoc());
        return hash;
    }
}
class Weight{
    private double intersect;
    private double difference;
    
    Weight(){
        intersect = 1;
        difference = 1;
    }
    Weight( double a, double b){
        intersect = a;
        difference = b;
    }
    public void applyWeight(Weight weight){
        intersect += weight.intersectValue();
        difference += weight.differenceValue();
    }
    public double intersectValue(){
        return intersect;
    }
    public double differenceValue(){
        return difference;
    }
}
class Bounds {
    private final int xmin;
    private final int xmax;
    private final int ymin;
    private final int ymax;
    
    Bounds ( int xmn, int xmx, int ymn, int ymx ){
        xmin = xmn;
        xmax = xmx;
        ymin = ymn;
        ymax = ymx;
    }
    public int xmin() {
        return xmin;
    }
    public int xmax() {
        return xmax;
    }
    public int ymin() {
        return ymin;
    }
    public int ymax() {
        return ymax;
    }
    public boolean isBounded( int x, int y ){
//        System.out.println("xmin -> xmax, x:" + xmin+" -> "+xmax+", "+x);
//        System.out.println("ymin -> ymax, y:" + ymin+" -> "+ymax+", "+y);
        boolean rtn = x<=xmax&&x>=xmin&&y<=ymax&&y>=ymin;
//        System.out.println(rtn);
        return rtn;
    }
    public boolean isBounded( Edge e ){
        return isBounded(e.aX(),e.aY())&&
                isBounded(e.bX(),e.bY());
    }
    public static Bounds maxminBounds( Bounds b1, Bounds b2 ){
        int xmn;
        int xmx;
        int ymn;
        int ymx;
        xmn = Math.min(b1.xmin(), b2.xmin());
        xmx = Math.max(b1.xmax(), b2.xmax());
        ymn = Math.min(b1.ymin(), b2.ymin());
        ymx = Math.max(b1.ymax(), b2.ymax());
        return new Bounds(xmn,xmx,ymn,ymx);
    }
    @Override
    public String toString(){
        return "xmin: "+xmin+"\nxmax: "+xmax+"\nymin: "+ymin+"\nymax: "+ymax;
    }
}
class Rules extends HashMap<Child, ArrayList<Child>>{
    
    public Rules intersectToRules( HashSet<Child> intersection, Child locatedSource ){
        Rules rtn = new Rules();
        for ( Child lhs : intersection ){
            
        }
        return rtn;
    }
    public void addRule(Child lhs, Child rhs){
        if (containsKey(lhs))
            get(lhs).add(rhs);
        else {
            ArrayList<Child> r = new ArrayList<>();
            r.add(rhs);
            put(lhs,r);
        }
    }
    public void makeAddRules(Child parent, Child c){
        for ( Connection cn : parent.connections()){
            if ( cn.a().equals(c) ) addRule(c,cn.b());
            if ( cn.b().equals(c) ) addRule(c,cn.a());
        }
    }
    public void union( Rules rs ){
        Set<Child> keys = rs.keySet();
        for ( Child lhs : keys ){
            ArrayList<Child> cs = rs.get(lhs);
            for ( Child rhs : cs )
                addRule(lhs,rhs);
        }
    }
    public boolean containsAll( ArrayList<Child> cs ){
        for (Child c : cs)
            if ( !containsKey(c) ) return false;
        return true;
    }
}
