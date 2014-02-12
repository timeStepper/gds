/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author owenpaulmeyer
 */
public class Design {
    private HashSet<Location> nodes = new HashSet<>();
    private ArrayList<WeightedEdge> edges = new ArrayList<>();
    
    public boolean isOccupied(int x, int y ){
        return contains(new Location(x,y));
    }
    public boolean contains(Location l){
        return nodes.contains(l);
    }
    public HashSet<Location> grid(){
        return nodes;
    }
    public ArrayList<WeightedEdge> edges(){
        return edges;
    }
    
    public void setSeed( Child child ){
        ArrayList<Child> kids = Child.flattenChildren(child);
        ArrayList<Connection> conns = Child.flattenConnections(child);
        for ( Child c : kids ){
            plant(c);
        }
        for ( Connection con : conns )
            edges.add(new WeightedEdge(con.a(),con.b()));
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
    public void addEdge( WeightedEdge we ){
        edges.add(we);
    }
    private void addEdges( Child c ){
        for ( Connection cn : c.connections() )
            addEdge( new WeightedEdge(cn.a(),cn.b()));
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
        for ( WeightedEdge we : d.edges )
            if(bounds.isBounded(we))
                rtn.addEdge(we);
        return rtn;
    }
    
    //helper to intersection
        public static ArrayList<Child> intersect( Child located, Design bounded ){
        //System.out.println("located: "+located);
        //located.displayChildren();
        ArrayList<Child> intersections = new ArrayList<>();
        if ( located.isEmpty() ){
            if ( bounded.contains( located.location()))
                intersections.add(located);
        }
        else {
            for ( Child c : located.children())
                intersections.addAll(intersect(c,bounded));
//                    System.out.println("located.children():\n"+located.children());
//                    System.out.println("intersections:\n"+intersections);
            if ( containsAll(intersections, located.children())){
                
                intersections.add(located);
            }
        }
        return intersections;
    }
    //a contains all b
    private static boolean containsAll(ArrayList<Child> a, ArrayList<Child> b){
        for (Child c : b)
            if ( !a.contains(c) )return false;
        return true;
    }
    @Override
    public String toString(){
        return nodes.toString();
    }
}
class Source {
    Child element;
    HashMap<Child, ArrayList<Child>> rules;//adjacency list for Child
    Bounds bounds;  //used for quickening rebounding per location for intersection

    Source( Child c ) {
        element = c;
        rules = new HashMap<>();
        //computeRules();
    }
//    public void setSource( Child c ){
//        element = c;
//        bounds();
//    }
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
    //not recursive
    private void computeRules(){
        for ( Connection conn : element.connections() ){
            Child a = conn.a();
            Child b = conn.b();
            addRule( a, b);
            addRule( b, a);
        }
    }
    public void addRule( Child lhs, Child c){
        if (rules.containsKey(lhs)){
            rules.get(lhs).add(c);
        }
        else {
            ArrayList<Child> rhs = new ArrayList<>();
            rhs.add(c);
            rules.put(lhs , rhs);
        }
    }
}

class WeightedEdge{
    private Weight weight = new Weight();
    private Child start;
    private Child fin;
    
    WeightedEdge( Child a, Child b ){
        start = a;
        fin = b;
    }
    public Child start(){
        return start;
    }
    public Child fin(){
        return fin;
    }
    public int startX(){
        return start.xLoc();
    }
    public int startY(){
        return start.yLoc();
    }
    public int finX(){
        return fin.xLoc();
    }
    public int finY(){
        return fin.yLoc();
    }
    @Override
    public String toString(){
        return "["+start+", "+fin+"]";
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
    public boolean isBounded( WeightedEdge we ){
        return isBounded(we.start().xLoc(),we.start().yLoc())&&
                isBounded(we.fin().xLoc(),we.fin().yLoc());
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
