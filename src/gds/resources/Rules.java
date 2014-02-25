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
public class Rules extends HashMap<Child, ArrayList<Child>>{
    
    public static Rules intersectToRules( HashSet<Child> intersection, Rules sourceAdjacency ){
        Rules intersectionRules = new Rules();
        for ( Child lhs : intersection ){
            intersectionRules.addRule(lhs, sourceAdjacency.get(lhs));
        }
        return intersectionRules;
    }
    public void addRule(Child lhs, Child rhs){
        if (containsKey(lhs)){
            ArrayList<Child> list = get(lhs);
            if ( !list.contains(rhs))list.add(rhs);
        }
        else {
            ArrayList<Child> r = new ArrayList<>();
            r.add(rhs);
            put(lhs,r);
        }
    }
    public void addRule( Child lhs, ArrayList<Child> rhs){
        if (containsKey(lhs))
            get(lhs).addAll(rhs);
        else put(lhs,rhs);
    }
    public void makeAddRules(Child parent, Child c){
        for ( Connection cn : parent.connections()){
            if ( cn.a().equals(c) ) addRule(c,cn.b());
            else if ( cn.b().equals(c) ) addRule(c,cn.a());
        }
    }
    public void union( Rules rs ){
        for ( Child lhs : rs.keySet() ){
            ArrayList<Child> cs = rs.get(lhs);
            for ( Child rhs : cs )
                addRule(lhs,rhs);
        }
    }
    public boolean containsAll( ArrayList<Child> cs ){
        for (Child c : cs)
            if ( !containsKey(c) ) return false;
        return true;
    }
    public void display(){
        Set<Child> keys = keySet();
        for ( Child lhs:keys){
            System.out.println(lhs+" -> "+get(lhs));
        }
    }
}


