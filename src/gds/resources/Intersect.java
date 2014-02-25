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
    
    public void intersect(Design bounded, Source located){
        applicates.clear();
        buffer.clear();
        threshold = new Weight(0,0);
        intersectCall(bounded, located.element());
//        for (Child c : applicates.keySet()){
//            System.out.println(c+"-> "+applicates.get(c));
//        }
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
    private void connectWeights(Child located, Rules lookup){
        for (Child c : located.children()){
            Weight getW = applicates.get(c);
            for (Child child : lookup.get(c)){
                double half = getW.intersectValue()/2;
                if (applicates.containsKey(child))
                    applicates.get(child).applyWeight(new Weight(half,0));
                else applicates.put(child, new Weight(half,0));
            }
        }
    }
    private void bufferIntersection(Source located){
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
                //System.out.println("w "+w);
                if (!buffer.containsKey(e))
                    buffer.put(e, w);
                else buffer.get(e).applyWeight(w);
            }
        else {
            //recursive desent and Connection Weight distribution
            for (Child c : ch.children()){
                applicate(c, located);//desend
//                Weight w = applicates.get(c);
//                for (Child child : located.lookupTable().get(c)){
//                    double half = w.intersectValue()/2;
//                    if (applicates.containsKey(child))
//                        applicates.get(child).applyWeight(new Weight(half,0));
//                    else applicates.put(child, new Weight(half,0));
//                }
            }
        }
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
//        }
        for (Edge e : inter.buffer.keySet()){
            System.out.println(e+" -> "+inter.buffer.get(e));
        }
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
//class Intersection{
//    HashSet<Edge> difference = new HashSet<>();
//    HashSet<Edge> intersection = new HashSet<>(); 
//    HashMap<Child, Weight> applicates = new HashMap<>();
//    
//    public void addDiff(Edge e){
//        difference.add(e);
//    }
//    public void putInter(Child c, Weight w){
//        applicates.put(c,w);
//    }
//}
