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
public class Placement {
    private HashMap<Child, Weight> applicants = new HashMap<>();
    private HashMap<Edge, Weight> applicated = new HashMap<>();
    private Source locatedSource;
    private HashSet<Edge> difference = new HashSet<>();
    private HashSet<Edge> intersection = new HashSet<>();
    private int boundDesignSize;
    private int sourceSize;
    private Weight threshold = new Weight(0, 0);
    private double  connectValue = .5;
    
    public Placement(){}
    public Placement(Source s){
        locatedSource = s;
    }
    public void setLocated(Source l){
        locatedSource = l;
    }
    public void setConnectValue(double d){
        connectValue = d;
    }
    public HashMap<Edge,Weight> applicated(){
        return applicated;
    }
    public HashSet<Edge> difference(){
        return difference;
    }
    public HashMap<Child, Weight> applicants(){
        return applicants;
    }
    public HashSet<Edge> intersection(){
        return intersection;
    }
    public int boundSize(){
        return boundDesignSize;
    }
    public int sourceSize(){
        return sourceSize;
    }
    public double threshold(){
        return threshold.decide();
    }
    public void resetThreshold(){
        threshold = new Weight(1,1);
    }
    public void placement(Design bounded){
        applicants.clear();
        applicated.clear();
        difference.clear();
        intersection.clear();
        //threshold = new Weight(0, 0);
        boundDesignSize=0;
        sourceSize = locatedSource.size();
        for (Child c:locatedSource.element().children()){
            placementCall(bounded, c);
        }
    }
    private Weight placementCall(Design bounded, Child located){
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
                    applicants.put(located,w);
                    
                    
//                    ArrayList<Child> adjs = lookup.get(located);
//                    if (adjs!=null){
//                        for(Child c:adjs){
//                            applicants.put(located,w);
//                        }
//                    }
                    
                    
                    threshold.applyWeight(w);
                    //System.out.println(located+" :: "+w);
                    return w;
                }
                else {
                    Weight empty = new Weight(0, denominator);
                    applicants.put(located,empty);
                    return empty;
                }
            }
            //Child of non empties
            else {
                Weight w = new Weight(0,0);
                for ( Child c : located.children() ){
                    //accumulate the weights of the children of 'located'
                    Weight getW = placementCall(bounded, c);
                    w.applyWeight(getW);
                }
                applicants.put(located,w);
                threshold.applyWeight(w);
                return w;
            }
        }return new Weight(0, 0);//nothing here to intersect with
    }
//    private int placementCall(Design bounded, Child located){
//        int edgecount = 0;
//        if (!bounded.edges().isEmpty()){
//            boundDesignSize = bounded.edges().size();
//            //empties
//            if (located.isEmpty()){
//                Location a = located.location();
//                if (bounded.contains(a)){
//                    ArrayList<Child> adjs = locatedSource.lookupTable().get(located);
//                    for (Child c:adjs){
//                        Location b = c.location();
//                        Edge e = new Edge(a,b);
////                        System.out.println("child "+located);
//                        if (bounded.contains(e)){
//                            edgecount++;
//                            intersection.add(new Edge(a,b));
//                        }
//                    }
//                }
//                if (edgecount > 0){
//                    Weight w = new Weight(1, 1);
//                    applicants.put(located,w);
//                    return 1;
//                }
//                else {
//                    return 0;
//                }
//            }
//            //non empties
//            else {
//                Weight w = new Weight(0,0);
//                for ( Child c : located.children() ){
//                    //accumulate the weights of the children of 'located'
//                    int top = placementCall(bounded, c);
//                    w.addTopValue(top);
//                }
//                w.addBottomValue(located.size());
//                applicants.put(located,w);
//                if (w.decide()!=0)
//                    threshold.applyWeight(w);//new Weight(w.decide(),1));
//                return (int)(w.topValue());
//            }
//        }return 0;//nothing here to intersect with
//    }
    public void applyPlacement(){
        applyPlacement(new Value());
    }
    public void applyPlacement(Value value){
        applicated.clear(); 
        for (Child app : applicants.keySet()){
            applicate(app, value);
        }
    }
    //application is the point where an edge gets it's value
    private void applicate(Child ch, Value value){
        if (ch.containsAllEmpties()){
                Weight w = new Weight(applicants.get(ch));
                Weight val = value.evaluate(
                        sourceSize,
                        boundDesignSize,
                        intersection.size(),
                        difference.size());
                w.applyWeight(val);
            for (Connection cn : ch.connections()){
                Weight app = new Weight(w);//copy here to avoid multiple reference!
                Edge e = new Edge(cn);
                if (!applicated.containsKey(e))
                    applicated.put(e, app);
                else applicated.get(e).applyWeight(app);
            }
        }
        else {
            for (Child c:ch.children()){
                applicate(c, value);
            }
        }
    }
    private void applicateQ(Child ch, Value value){
        if (ch.isEmpty()){
            ArrayList<Child> adjs = locatedSource.lookupTable().get(ch);
            for (Child c:adjs){
                Edge e = new Edge(c.location(),ch.location());
                Weight n = applicants.get(ch);
                if (n==null)n = new Weight(1,1);
                Weight w = new Weight(n);//applicants.get(ch));
                Weight val = value.evaluate(
                        sourceSize,
                        boundDesignSize,
                        intersection.size(),
                        difference.size());
                w.applyWeight(val);
                if (!applicated.containsKey(e))
                    applicated.put(e, w);
                else applicated.get(e).applyWeight(w);
            }
        }
        else {
            for (Child c:ch.children()){
                applicate(c, value);
            }
        }
    }
//    
 
    public static void main(String args[]) {
        System.out.println("o hell o");
        Placement inter;
        Design design = new Design();
        Source test = setTest();
        design.setSeed(test.element());
        design.setBounds();
        test = test.locate(new Location(2,-3));
        inter = new Placement(test);

        inter.placement(design);
        //inter.bufferPlacement();
        for (Child c : inter.applicants.keySet()){
            if(!c.isEmpty())
                System.out.println(c+"-> "+inter.applicants.get(c));
        }System.out.println();
//        for (Edge e : inter.buffer.keySet()){
//            System.out.println(e+" -> "+inter.buffer.get(e));
//        }
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



   
    //populates applicates 
//    public void placement(Design bounded, Source located){
//        applicants.clear();
//        buffer.clear();
//        difference.clear();
//        intersection.clear();
//        boundDesignSize=0;
//        sourceSize = located.size();
//        placementCall(bounded, located.element(), located.lookupTable());
//    }
//    private Weight placementCall(Design bounded, Child located, Rules lookup){
//        int edgecount = 0;
//        if (!bounded.edges().isEmpty()){
//            boundDesignSize = bounded.edges().size();
//            //Child of all empties
//            if (located.containsAllEmpties()){
//                int denominator = located.connections().size();
//                //for each intersecting edge increase the weight value by 1
//                for ( Connection cn : located.connections() ){
//                    if ( bounded.contains(cn)){
//                        ++edgecount;
//                        intersection.add(new Edge(cn));//for visToolz visuals
//                    }
//                    else difference.add(new Edge(cn));
//                }
//                if (edgecount>0){
//                    Weight w = new Weight(edgecount, denominator);
//                    
//                    
//                    //accepts the entire Child at the Weight of (intersection/possible intersection)
//                    applicants.put(located,w);
//                    
//                    
////                    ArrayList<Child> adjs = lookup.get(located);
////                    if (adjs!=null){
////                        for(Child c:adjs){
////                            applicants.put(located,w);
////                        }
////                    }
//                    
//                    
//                    threshold.applyWeight(w);
//                    //System.out.println(located+" :: "+w);
//                    return w;
//                }
//                else {
//                    Weight empty = new Weight(0, denominator);
//                    applicants.put(located,empty);
//                    return empty;
//                }
//            }
//            //Child of non empties
//            else {
//                Weight w = new Weight(0,0);
//                for ( Child c : located.children() ){
//                    //accumulate the weights of the children of 'located'
//                    Weight getW = placementCall(bounded, c, lookup);
//                    w.applyWeight(getW);
//                }
//                applicants.put(located,w);
//                threshold.applyWeight(w);
//                return w;
//            }
//        }return new Weight(0, 0);//nothing here to intersect with
//    }
    //application of intersection
//    public void bufferPlacement(Source located){
//        for (Child app : applicants.keySet()){
//            if (!app.containsAllEmpties())
//                distributeWeightsAlongConnections(app,located);
//        }
//        for (Child app : applicants.keySet()){
//            if (app.containsAllEmpties())
//                applicate(app, located);
//        }
//    }
    //recursive application bringing the weight of the parent
    //down the rabbit hole and distributing it throughout
    
//is called when !child.containsAllEmpties()
//    public void distributeWeightsAlongConnections(Child child, Source located){
//        HashMap<Child,Double> buff = new HashMap<>();
//        ArrayList<Child> adjs;
//        for (Child ch:child.children()){
//            adjs = located.lookupTable().get(ch);
//            if (adjs!=null){
//                double half = applicants.get(child).topValue()*connectValue;
//                for (Child c:adjs){
//                    buff.put(c,half);
//                }
//            }
//        }
//        for (Child c:buff.keySet()){
//            applicants.get(c).addTopValue(buff.get(c));
//        }
//    }