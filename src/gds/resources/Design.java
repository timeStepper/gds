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
    boolean[][] grid;
    int width;
    int height;
    ArrayList<WeightedEdge> edges = new ArrayList<>();
    Source source;
    
    Design( int x, int y ){
        width = x;
        height = y;
        grid = new boolean[x][y];
        initialize();
    }
    public boolean isOccupied(int x, int y ){
        return grid[x][y];
    }
    public void initialize(){
        for ( int x = 0; x < width; ++x )
            for ( int y = 0; y < height; ++y )
                grid[x][y] = false;
    }
    public void setSource( Source s ){
        source = s;
    }
    public void addEdge( WeightedEdge we ){
        edges.add(we);
    }
    public Design bounded( Bounds bounds ){
        Design rtn = new Design( width, height );
        for ( int x = 0; x < width; ++x )
            for ( int y = 0; y < height; ++y ){
                if ( bounds.isBounded(x,y))
                    rtn.grid[x][y] = true;
            }
        for ( WeightedEdge we : edges )
            if(bounds.isBounded(we))
                rtn.addEdge(we);
        return rtn;
    }
    public ArrayList<Child> intersection( Source source, Location loc ){
        ArrayList<Child> intersection = new ArrayList<>();
        //Child located = 
        return intersection;
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
        bounds();
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
    private Location start;
    private Location fin;
    
    WeightedEdge( Location a, Location b ){
        start = a;
        fin = b;
    }
    public Location start(){
        return start;
    }
    public Location fin(){
        return fin;
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
