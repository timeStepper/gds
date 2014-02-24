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
    private HashMap<Edge, Double> buffer = new HashMap<>();
    private Weight threshold = new Weight(0, 0);
    
    public void intersect(Design bounded, Source located){
        applicates.clear();
        intersectCall(bounded, located.element(), located.lookupTable() );
    }
//    private void intersectCall(Design bounded, Child located, Rules lookup){
//        int edgecount=0;
//        if (!bounded.edges().isEmpty()){
//            for ( Edge e : bounded.edges() ){
//                
//            }
//        }
//    }
    //*WILL* handles the job of distributing mitigated weightes along Connections
    private Weight intersectCall(Design bounded, Child located, Rules lookup){
        int edgecount = 0;
        if (!bounded.edges().isEmpty()){
            //Child of all empties
            if (located.containsAllEmpties()){
                //for each intersecting edge increase the weight value by 1
                for ( Connection cn : located.connections() ){
                    if ( bounded.contains(cn))
                        ++edgecount;
                }
                if (edgecount>0){
                    Weight w = new Weight(edgecount, located.connections().size());
                    //accepts the entire Child at the Weight of (intersection/possible intersection)
                    applicates.put(located,w);
                    threshold.applyWeight(w);
                    return w;
                }
            }
            //Child of non empties
            else {
                Weight w = new Weight(0,0);
                for ( Child c : located.children() ){
                    //accumulate the weights of the children of 'located'
                    Weight getW = intersectCall(bounded, c, lookup);
                    w.applyWeight(getW);
                    //distribute 1/2 w to Connected Childs
                    ArrayList<Child> adjs = lookup.get(c);
                    for (Child child : adjs){
                        Weight halfW = new Weight(getW.intersectValue()/2, getW.differenceValue());
                        applicates.put(child, halfW);
                    }
                }
                applicates.put(located,w);
                threshold.applyWeight(w);
                return w;
            }
        }return new Weight(0, 0);//nothing here to intersect with
    }
    private void bufferIntersection(){
        for (Child app : applicates.keySet()){
            Weight w = applicates.get(app);
            //apply the whole child 'app' with weight w
            //this is the top level where no Connections exist
            applicate(app, w.decide());
        }
    }
    //recursive application bringing the weight of the parent
    //down the rabbit hole and distributing it throughout
    //the job of distributing Weights along Connections has already
    //been handled by intersectCall()
    private void applicate(Child ch, double val){
        if (ch.containsAllEmpties())
            for (Connection cn : ch.connections()){
                Edge e = new Edge(cn);
                Weight w = applicates.get(ch);
                buffer.put(e, val+w.decide());
            }
        else {
            //recursive desent
            for (Child c : ch.children())
                applicate(c, val+applicates.get(ch).decide());
        }
    }
    public static void main(String args[]) {
        System.out.println("o hell o");
        Intersect inter = new Intersect();
        Design design = new Design();
        Source test = setTest();
        test = test.locate(new Location(0,0));
        design.setSeed(test.element());
        inter.intersect(design, test);
        for (Child c : inter.applicates.keySet()){
            System.out.println(c+" -> "+inter.applicates.get(c));
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
