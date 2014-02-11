/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author owenpaulmeyer
 */
public class Design {
    private HashMap<Location,Child> grid = new HashMap<>();
    private int width;
    private int height;
    private ArrayList<WeightedEdge> edges = new ArrayList<>();
    
    Design( int x, int y ){
        width = x;
        height = y;
    }
    public boolean isOccupied(int x, int y ){
        return contains(new Location(x,y));
    }
    public boolean contains(Location l){
        if ( grid.containsKey(l))return true;
        else return false;
    }
    public HashMap<Location,Child> grid(){
        return grid;
    }
    public ArrayList<WeightedEdge> edges(){
        return edges;
    }
    public int width(){
        return width;
    }
    public int height(){
        return height;
    }
    
    public void setSeed( Child child ){
        ArrayList<Child> kids = Child.flattenChildren(child);
        ArrayList<Connection> conns = Child.flattenConnections(child);
        for ( Child c : kids )
            plant(c);
        for ( Connection con : conns )
            edges.add(new WeightedEdge(con.a(),con.b()));
//        Child located = child.locate(new Location(0,0));
//        for ( Child c : located.children() ){
//            plant(c);
//        }
//        for ( Connection con : child.connections()){
//            edges.add(new WeightedEdge(con.a(),con.b()));
//        }
    }
    //helper to setSeed
    private void plant( Child child ){
        for ( Child c : child.children() ){
            if (c.isEmpty()) addNode(c);
            else {
                plant(c);
                addEdges( child );  
            }
        }
    }
    public void addEdge( WeightedEdge we ){
        edges.add(we);
    }
    public void addEdges( Child c ){
        for ( Connection cn : c.connections() )
            addEdge( new WeightedEdge(cn.a(),cn.b()));
    }
    public void addNode( Child child ){
        Location l = child.location();
        grid.put(l,child);
    }
    //used for getting the Bounded region of the Design
    public Design bounded( Bounds bounds ){
        Design rtn = new Design( width, height );
        for ( int x = 0; x < width; ++x )
            for ( int y = 0; y < height; ++y ){
                if ( bounds.isBounded(x,y))
                    rtn.grid.put(new Location(x, y),new Child());
            }
        for ( WeightedEdge we : edges )
            if(bounds.isBounded(we))
                rtn.addEdge(we);
        return rtn;
    }
    public ArrayList<Child> intersection( Source source, Location loc ){
        ArrayList<Child> intersection = new ArrayList<>();
        Child located = Child.locate(source.element(), loc);
        Bounds bounds = Source.bounds(located);
        Design bounded = bounded(bounds);
        return intersect( located, bounded );
    }
    private ArrayList<Child> intersect( Child located, Design bounded ){
        ArrayList<Child> intersections = new ArrayList<>();
        if ( located.isEmpty() ){
            if ( bounded.contains( located.location()))
                intersections.add(located);
        }
        else {
            for ( Child c:located.children())
                intersections.addAll(intersect(c,bounded));
            if ( containsAll(intersections, located.children()))
                intersections.add(located);
        }
        return intersections;
    }
    //a contains all b
    private static boolean containsAll(ArrayList<Child> a, ArrayList<Child> b){
        boolean rtn = true;
        for (Child c : b)
            rtn &= a.contains(c);
        return rtn;
    }
    
}
class Source {
    Child element;
    HashMap<Child, ArrayList<Child>> rules;//adjacency list for Child
    Bounds bounds;  //used for quickening rebounding per location for intersection

    Source() {
        super();
        rules = new HashMap<>();
        //computeRules();
        
    }
    public void setSource( Child c ){
        element = c;
        bounds();
    }
    public Child element(){
        return element;
    }
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
        return x<=xmax&&x>=xmin&&y<=ymax&&y>=ymin;
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
