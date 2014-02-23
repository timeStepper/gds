/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author owenpaulmeyer
 */
public class Intersection {
    HashSet<Edge> difference = new HashSet<>();
    HashMap<Child, Weight> applicates = new HashMap<>();
    
    public void intersect(Design bounded, Source located){
        difference.clear();
        applicates.clear();
        intersectCall(bounded, located.element(), located.lookupTable() );
    }
    private void intersectCall(Design bounded, Child located, Rules lookup){
        int edgecount=0;
        if (!bounded.edges().isEmpty()){
            for ( Edge e : bounded.edges() ){
                
            }
        }
    }
//    private void intersectCall(Design bounded, Child located, Rules lookup){
//        int edgecount = 0;
//        if (!bounded.edges().isEmpty()){
//            if (located.containsAllEmpties()){
//                for ( Connection cn : located.connections() ){
//                    if ( bounded.contains(cn))
//                        ++edgecount;
//                }
//                if (edgecount>0)
//                    applicates.put(located,new Weight(edgecount, located.connections().size()));
//            }
//            else {
//                for ( Child c : located.children() )
//                    intersectCall(bounded, c, lookup);
//                if ( containsAll(located.children())){
//                    Weight w = new Weight(0,0);
//                    //here is where the higher level child intersection
//                    //weight is calculated: by accumulating all the weights
//                    //of it's children(this may not be the best approach)****
//                    for(Child c : located.children())
//                        w.applyWeight(applicates.get(c));
//                }
//            }
//        }
//    }
    private boolean containsAll(ArrayList<Child> cs){
        for (Child c : cs)
            if (!applicates.containsKey(c))return false;
        return true;
    }
}
