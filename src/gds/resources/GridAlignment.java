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
public class GridAlignment {
    int originX;
    int originY;
    int module = 40;
    
    public void setOriginX( int x ){
        originX = x;
    }
    public void setOriginY( int y ){
        originY = y;
    }
    public int originX() {
        return originX;
    }
    public int originY() {
        return originY;
    }
    public int moduleSize() {
        return module;
    }
}
