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
    public ArrayList<Child> intersect( Source source ){
        ArrayList<Child> intersection = new ArrayList<>();
        
        return intersection;
    }
    
}
class Source extends Element{
    HashMap<Location, ArrayList<Child>> rules;//adjacency list for Child

    Source() {
        super();
        rules = new HashMap<>();
        computeRules();
    }
    private void computeRules(){
        for ( Connection conn : connections() ){
            Child a = conn.a();
            Child b = conn.b();
            addRule( a.location(), b);
            addRule( b.location(), a);
        }
    }
    public void addRule( Location l, Child c){
        if (rules.containsKey(l)){
            rules.get(l).add(c);
        }
        else {
            ArrayList<Child> newrule = new ArrayList<>();
            newrule.add(c);
            rules.put(l, newrule);
        }
    }
}

class WeightedEdge{
    Weight weight = new Weight();
    Location start;
    Location fin;
    
    WeightedEdge( Location a, Location b ){
        start = a;
        fin = b;
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
