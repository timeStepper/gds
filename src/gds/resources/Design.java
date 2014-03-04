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
    private HashMap<Edge, Weight> edges = new HashMap<>();
    double maxWeight = 0;
    Bounds bounds;
    double inter;
    double differ;
    double adjust=1;
    double diffnum;
    double diffden;
    double diffadj=1;
    
    
    public Design(){}
    
    public Design(double ad){
        adjust = ad;
    }
    public Design(Design d){
        for(Edge e:d.edges.keySet()){
            edges.put(e,d.edges.get(e));
        }
    }
    
    public boolean isOccupied(int x, int y ){
        return contains(new Location(x,y));
    }
    public boolean contains(Location l){
        return nodes.contains(l);
    }
//    public boolean contains(Child c){
//        return contains(c.location());
//    }
    public boolean contains(Connection conn){
        Edge e = new Edge(conn.aLoc(),conn.bLoc());
        return edges.containsKey(e);
    }
    public boolean contains(Location a, Location b){
        Edge e1 = new Edge(a, b);
        Edge e2 = new Edge(b, a);
        return edges.containsKey(e1) || edges.containsKey(e2);
    }
    public HashSet<Location> grid(){
        return nodes;
    }
    public void clearEdges(){
        edges.clear();
    }
    public Set<Edge> edges(){
        return edges.keySet();
    }
    public HashMap<Edge,Weight> edgeMap(){
        return edges;
    }
    
    public void setSeed( Child child ){
        nodes.clear();
        edges.clear();
        ArrayList<Child> kids = Child.flattenChildren(child);
        HashSet<Connection> conns = Child.flattenConnections(child);
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
    public void setEdge(Edge e, Weight w){
        double d = w.decide();
        if (d>maxWeight)maxWeight = d;
        if(edges.containsKey(e))
            edges.get(e).applyWeight(w);
        else edges.put(e,w);
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
    public void setBounds(){
        int xmin = Integer.MAX_VALUE;
        int xmax = Integer.MIN_VALUE;
        int ymin = Integer.MAX_VALUE;
        int ymax = Integer.MIN_VALUE;
//        for( Location l : nodes ){
//            if ( l.xLoc() < xmin ) xmin = l.xLoc();
//            if ( l.xLoc() > xmax ) xmax = l.xLoc();
//            if ( l.yLoc() < ymin ) ymin = l.yLoc();
//            if ( l.yLoc() > ymax ) ymax = l.yLoc();
//        }
        for ( Edge e : edges.keySet() ){
            if ( e.aX() < xmin ) xmin = e.aX();
            if ( e.bX() < xmin ) xmin = e.bX();
            if ( e.aX() > xmax ) xmax = e.aX();
            if ( e.bX() > xmax ) xmax = e.bX();
            if ( e.aY() < ymin ) ymin = e.aY();
            if ( e.bY() < ymin ) ymin = e.bY();
            if ( e.aY() > ymax ) ymax = e.aY();
            if ( e.bY() > ymax ) ymax = e.bY();
        }
        Bounds rtn = new Bounds(xmin,xmax,ymin,ymax);
        bounds = rtn;
    }
    //used for getting the Bounded region of the Design
    public static Design bounded( Bounds bounds, Design d ){
        Design rtn = new Design( 0 );
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
            if(bounds.isBounded(e)){
                rtn.addEdge(e);
            }
        return rtn;
    }
    public Weight getWeight(Edge e){
        return edges.get(e);
    }
    public void resetThreshold(){
        inter=0;
        differ=0;
    }
    public void balanceDiffer(double d){
        differ+=d;
    }
    public void balanceInter(double i){
        inter+=i;
    }
    public double threshold(){
//        System.out.println("inter "+inter);
//        System.out.println("differ "+differ);
        if (differ==0||adjust==0)return 0;
        return inter/differ/adjust;
    }
    public void adjust(double a){
        adjust = a;
    }
    public void resetDiffThresh(){
        diffnum=0;
        diffnum=0;
    }
    public void balanceDiffNum(double d){
        diffnum += d;
    }
    public void balanceDiffDen(double d){
        diffden += d;
    }
    public double diffThreshold(){
        System.out.println("diffnum "+diffnum);
        System.out.println("diffden "+diffden);
        System.out.println("diffadj "+diffadj);
        System.out.println("result "+diffnum/diffden/diffadj+"\n");
        if (diffden==0) return 0;
        return diffnum/diffden/diffadj;
    }
    public void adjustDiff(double a){
        diffadj=a;
        System.out.println("adjusting: "+a);
    }
    public static Design difference( Child located, Design bounded ){
        Design difference = new Design(0);
        HashSet<Connection> edges = Child.flattenConnections(located);
        for(Edge e : bounded.edges()){
            Location a = new Location(e.aX(),e.aY());
            Location b = new Location(e.bX(),e.bY());
            Connection check = new Connection(new Child(new Element(),a), new Child(new Element(), b));
            if (!edges.contains(check)) difference.addEdge(e);
        }
//        System.out.println("bounded: "+bounded.edges().size());
//        System.out.println("differs: "+difference.edges().size()+"\n");
        return difference;
    }
    public void applyDifference(Design difference, double diff){
        if (diff!=0){
            for ( Edge e : difference.edges()){
                if ( !edges.containsKey(e) )
                    edges.put(e,new Weight(0,0));
                Weight app = new Weight(0,diff);
                edges.get(e).applyWeight(app);
                //System.out.println("weight: "+app);
            }
        }
    }
    //applies the weights in difference to the edges in this
    public void applyDifferenceBuffer(Design difference){
        for ( Edge e : difference.edges()){
            if ( edges.containsKey(e) )
                edges.get(e).applyWeight(difference.getWeight(e));
        }
    }
    //helper to intersection
    public static HashSet<Child> intersect( Child located, Rules rules, Design bounded ){
        HashSet<Child> intersections = new HashSet<>();
        //this method starts on the following for loop
        //recognizing that 'located' will always be the root Child.
        for ( Child c : located.children())
            if (c.isEmpty()) {
                
                ArrayList<Child> connects = rules.get(c);
                for ( Child r : connects ){
                    if ( bounded.contains(c.location(),r.location())){
                        //intersections.add(c);
                        intersections.add(r);
                    }
                }
            }
            else intersections = union(intersections, intersect(c,rules, bounded));
        if ( containsAll(intersections, located.children()) ){
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
    private static HashSet<Connection> unionC(HashSet<Connection> a, HashSet<Connection> b){
        HashSet<Connection> rtn = new HashSet<>();
        for ( Connection ca : a )
            rtn.add(ca);
        for (Connection cb : b )
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
    public void applyRules( HashSet<Child> intersection, Rules lookup, double inter, double diff ){
        
        for( Child lhs : intersection ){
            ArrayList< Child > rhss = lookup.get(lhs);
            if ( rhss != null )
                for ( Child rhs : rhss ){
                    applyRule( lhs.location(), rhs, inter, diff );
                }
        }
    }
    public void applyRule( Location lhs, Child rhs, double inters, double diffs ){
        if (rhs.isEmpty()){
            Edge e = new Edge( lhs, rhs.location() );
            if ( !edges.containsKey(e) )
                edges.put(e,new Weight(0,0));
            Weight w = edges.get(e);
            Weight weight = new Weight(inters, diffs);
            w.applyWeight(weight);
        }
        else
            applyElement(rhs, inters, diffs);
    }
    public void applyElement(Child elem, double inters, double diffs){
        for ( Connection cn : elem.connections()){
            if (cn.a().isEmpty()) applyRule(cn.a().location(),cn.b(), inters, diffs);
            else {
                applyElement(cn.a(), inters, diffs);
                applyElement(cn.b(), inters, diffs);
            }
        }
    }
    public void decide(double threshold){
        //System.out.println("Edges: "+edges.keySet());
        HashMap<Edge, Weight> bufferEdges = new HashMap<>();
        HashSet<Location> bufferNodes = new HashSet<>();
        Set<Edge> keys = edges.keySet();
        for( Edge e : keys ){
            double edgeValue = edges.get(e).decide();
//            System.out.println("edgevalue: "+edgeValue);
//            System.out.println("threshold: "+threshold+"\n");
            if (edgeValue > threshold){
                bufferEdges.put(e, new Weight(1,1));
                bufferNodes.add(new Location(e.aX(),e.aY()));
                bufferNodes.add(new Location(e.bX(),e.bY()));
            }
        }
        edges = bufferEdges;
        nodes = bufferNodes;
        setBounds();
    }
    @Override
    public String toString(){
        return nodes.toString();
    }
    public void displayEdges(){
        for ( Edge e : edges.keySet()){
            System.out.println(e);
        }
    }
}


