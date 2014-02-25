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
public class Weight{
    private double intersect;
    private double difference;
    
    Weight(){
        intersect = 0;
        difference = 0;
    }
    Weight( double a, double b){
        intersect = a;
        difference = b;
    }
    Weight(Weight w){
        intersect = w.intersectValue();
        difference = w.differenceValue();
    }
    public double decide(){
        if (difference==0)return 0;
        else return intersect/difference;
    }
    public void applyWeight(Weight weight){
        intersect += weight.intersectValue();
        difference += weight.differenceValue();
    }
    public void addIntersectValue(double v){
        intersect+=v;
    }
    public double intersectValue(){
        return intersect;
    }
    public double differenceValue(){
        return difference;
    }
    public String toString(){
        return "["+intersect+", "+difference+"]";
    }
}

