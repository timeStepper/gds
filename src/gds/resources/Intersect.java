/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;


import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author owenpaulmeyer
 */
public class Intersect {
    private HashMap<Child, Weight> applicates = new HashMap<>();
    private HashMap<Edge, Weight> buffer = new HashMap<>();
    private HashSet<Edge> difference = new HashSet<>();
    private int boundDesignSize;
    private HashSet<Edge> intersection = new HashSet<>();
    private Weight threshold = new Weight(0, 0);
    private double  connectValue = .5;
    
    public HashMap<Edge,Weight> buffer(){
        return buffer;
    }
    public HashSet<Edge> difference(){
        return difference;
    }
    public HashMap<Child, Weight> applicates(){
        return applicates;
    }
    public HashSet<Edge> intersection(){
        return intersection;
    }
    public int boundSize(){
        return boundDesignSize;
    }
    public double threshold(){
        return threshold.decide();
    }
    public void resetThreshold(){
        threshold = new Weight(1,1);
    }
    //populates applicates 
    public void intersect(Design bounded, Source located){
        applicates.clear();
        buffer.clear();
        difference.clear();
        intersection.clear();
        boundDesignSize=0;
        intersectCall(bounded, located.element());
    }
    private Weight intersectCall(Design bounded, Child located){
        int edgecount = 0;
        if (!bounded.edges().isEmpty()){
            boundDesignSize = bounded.edges().size();
            //Child of all empties
            if (located.containsAllEmpties()){
                int denominator = located.connections().size();
                //for each intersecting edge increase the weight value by 1
                for ( Connection cn : located.connections() ){
                    if ( bounded.contains(cn)){
                        ++edgecount;
                        intersection.add(new Edge(cn));//for visToolz visuals
                    }
                    else difference.add(new Edge(cn));
                }
                if (edgecount>0){
                    Weight w = new Weight(edgecount, denominator);
                    //accepts the entire Child at the Weight of (intersection/possible intersection)
                    applicates.put(located,w);
                    threshold.applyWeight(w);
                    //System.out.println(located+" :: "+w);
                    return w;
                }
                else {
                    Weight empty = new Weight(0, denominator);
                    applicates.put(located,empty);
                    return empty;
                }
            }
            //Child of non empties
            else {
                Weight w = new Weight(0,0);
                for ( Child c : located.children() ){
                    //accumulate the weights of the children of 'located'
                    Weight getW = intersectCall(bounded, c);
                    w.applyWeight(getW);
                }
                applicates.put(located,w);
                threshold.applyWeight(w);
                return w;
            }
        }return new Weight(0, 0);//nothing here to intersect with
    }
    //application of intersection
    public void bufferIntersection(Source located){
        for (Child app : applicates.keySet()){
            if (!app.containsAllEmpties())
                distributeConnect(app,located);
        }
        for (Child app : applicates.keySet()){
            if (app.containsAllEmpties())
                applicate(app, located);
        }
    }
    //recursive application bringing the weight of the parent
    //down the rabbit hole and distributing it throughout
    private void applicate(Child ch, Source located){
            for (Connection cn : ch.connections()){
                Edge e = new Edge(cn);
                Weight w = new Weight(applicates.get(ch));
                if (!buffer.containsKey(e))
                    buffer.put(e, w);
                else buffer.get(e).applyWeight(w);
            }
    }
    public void distributeConnect(Child child, Source located){
        HashMap<Child,Double> buff = new HashMap<>();
        ArrayList<Child> adjs;
        for (Child ch:child.children()){
            adjs = located.lookupTable().get(ch);
            if (adjs!=null){
                double half = applicates.get(child).intersectValue()*connectValue;
                for (Child c:adjs){
                    buff.put(c,half);
                }
            }
        }
        for (Child c:buff.keySet()){
            applicates.get(c).addIntersectValue(buff.get(c));
        }
    }
    public static void main(String args[]) {
        System.out.println("o hell o");
        Intersect inter = new Intersect();
        Design design = new Design();
        Source test = setTest();
        design.setSeed(test.element());
        design.setBounds();
        test = test.locate(new Location(1,-3));
        

        inter.intersect(design, test);
        inter.bufferIntersection(test);
//        for (Child c : inter.applicates.keySet()){
//            System.out.println(c+"-> "+inter.applicates.get(c));
//            //c.displayChildren();
//        }
        for (Edge e : inter.buffer.keySet()){
            System.out.println(e+" -> "+inter.buffer.get(e));
        }
        System.out.println("thresh: "+inter.threshold);
    }
    public static Source setTest(){
        Gson gson = new Gson();
        BufferedReader read = null;
        String input=null;
        try{
		read = new BufferedReader(new FileReader("C:\\Users\\owenpaulmeyer\\Documents\\GDS\\roofSet.gds"));
                try {
                    input = read.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(GDS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch(FileNotFoundException fnf){System.out.println(fnf+": fileLoad trouble");}
        return new Source(gson.fromJson(input, Child.class).clone());
    }
}