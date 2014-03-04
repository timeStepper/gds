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
    double intersect_source=0;
    double intersect_bounded=0;
    double intersect_one=0;
    //switches:
    boolean i_s=true;
    boolean i_b=false;
    boolean i_o=false;
    
    public void setI_S(double percent){
        intersect_source = percent;
    }
    public void setI_B(double percent){
        intersect_bounded = percent;
    }
    public void setI_O(double percent){
        intersect_one = percent;
    }
    public void toggleI_S(){
        if (i_s)i_s = false;
        else i_s = true;
    }
    public void toggleI_B(){
        if (i_b)i_b = false;
        else i_b = true;
    }
    public void toggleI_O(){
        if (i_o)i_o = false;
        else i_o = true;
    }
    public Weight evaluate(int source, int bounded, int intersect){
        Weight rtn = new Weight(0,0);        
        if (i_s){
            rtn.addTopValue(intersect*intersect_source);
            rtn.addBottomValue(source*intersect_source);
        }
        if (i_b){
            rtn.addTopValue(intersect);
            rtn.addBottomValue(bounded);
        }
        if (i_o){
            rtn.addTopValue(intersect);
            rtn.addBottomValue(1);
        }
//        System.out.println("val "+rtn);
        return rtn;
    }
}
