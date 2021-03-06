/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

/**
 *
 * @author owenpaulmeyer
 */
public class Value{
    //percentages:
    double intersectValue=.5;
    double boundedValue=.5;
    double sourceValue=.5;
    double differenceValue=.5;
    //switches:
    boolean intersect=true;
    boolean bounded=true;
    boolean source=true;
    boolean diff=true;
    
    public void slideIntersect(double percent){
        intersectValue = percent;
    }
    public void slideBounded(double percent){
        boundedValue = percent;
    }
    public void slideSource(double percent){
        sourceValue = percent;
    }
    public void slideDifference(double percent){
        differenceValue = percent;
    }
    public void toggleIntersect(){
        if (intersect)intersect = false;
        else intersect = true;
    }
    public void toggleBounded(){
        if (bounded)bounded = false;
        else bounded = true;
    }
    public void toggleSource(){
        if (source)source = false;
        else source = true;
    }
    public Weight evaluate(int source, int bounded, int intersect, int differ){
        Weight rtn = new Weight(0,0);        
        if (this.intersect){
            rtn.addTopValue(intersect*intersectValue);
        }
        if (this.bounded){
            rtn.addBottomValue(bounded*boundedValue);
        }
        if (this.source){
            rtn.addBottomValue(source*sourceValue);
        }
        if (this.diff){
            rtn.addBottomValue(differ*differenceValue);
        }
//        System.out.println("val "+rtn);
        return rtn;
    }
}
