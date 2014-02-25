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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author owenpaulmeyer
 */
public class Intersect {
    private HashMap<Child, Weight> applicates = new HashMap<>();
    private HashMap<Edge, Weight> buffer = new HashMap<>();
    private Weight threshold = new Weight(0, 0);
    private double  connectValue = .5;
    
    public HashMap<Edge,Weight> buffer(){
        return buffer;
    }
    public double threshold(){
        return threshold.decide();
    }
    public void resetThreshold(){
        threshold = new Weight(1,1);
    }
    public void intersect(Design bounded, Source located){
        applicates.clear();
        buffer.clear();
        //threshold = new Weight(0,0);
        intersectCall(bounded, located.element());
    }
    private Weight intersectCall(Design bounded, Child located){
        int edgecount = 0;
        if (!bounded.edges().isEmpty()){
            //Child of all empties
            if (located.containsAllEmpties()){
                int denominator = located.connections().size();
                //for each intersecting edge increase the weight value by 1
                for ( Connection cn : located.connections() ){
                    if ( bounded.contains(cn))
                        ++edgecount;
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
    public void bufferIntersection(Source located){
        for (Child app : applicates.keySet()){
            //apply the whole child 'app' with weight w
            //this is the top level where no Connections exist
            applicate(app, located);
        }
    }
    //recursive application bringing the weight of the parent
    //down the rabbit hole and distributing it throughout
    private void applicate(Child ch, Source located){
        if (ch.containsAllEmpties())
            for (Connection cn : ch.connections()){
                Edge e = new Edge(cn);
                Weight w = new Weight(applicates.get(ch));
                if (!buffer.containsKey(e))
                    buffer.put(e, w);
                else buffer.get(e).applyWeight(w);
            }
        else {//distribute Weigts along Connections when c is not empty:
            HashMap<Child,Double> buff = new HashMap<>();//this buffer is needed for parallelism
            for (Child c : ch.children()){
                //applicate(c,located);//increases the resolution, value remains the same
                double half = applicates.get(c).intersectValue()*connectValue;
                for (Child child : located.lookupTable().get(c)){
                    buff.put(child, half);
                    //this almost works buts not parallel:
                    //applicates.get(child).addIntersectValue(half);
                }
            }
            for (Child buffC : buff.keySet())
                applicates.get(buffC).addIntersectValue(buff.get(buffC));
        }
    }
    public void connectionDistribution(){
        
    }
    public static void main(String args[]) {
        System.out.println("o hell o");
        Intersect inter = new Intersect();
        Design design = new Design();
        Source test = setTest();
        design.setSeed(test.element());
        design.setBounds();
        test = test.locate(new Location(0,0));
        

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