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
    private double top;
    private double bottom;
    
    Weight(){
        top = 0;
        bottom = 0;
    }
    Weight( double a, double b){
        top = a;
        bottom = b;
    }
    Weight(Weight w){
        top = w.topValue();
        bottom = w.bottomValue();
    }
    public double decide(){
        if (bottom==0)return 0;
        else return top/bottom;
    }
    public void applyWeight(Weight weight){
        top += weight.topValue();
        bottom += weight.bottomValue();
    }
    public void addTopValue(double v){
        top+=v;
    }
    public void addBottomValue(double v){
        bottom+=v;
    }
    public double topValue(){
        return top;
    }
    public double bottomValue(){
        return bottom;
    }
    public String toString(){
        return "["+top+", "+bottom+"]";
    }
}

