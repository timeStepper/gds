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
public class Edge{
    private Location nodeA;
    private Location nodeB;
    
    Edge( Location a, Location b ){
        nodeA = a;
        nodeB = b;
    }
    Edge(Connection cn){
        nodeA = cn.aLoc();
        nodeB = cn.bLoc();
    }
    public Location nodeA(){
        return nodeA;
    }
    public Location nodeB(){
        return nodeB;
    }
    
    public int aX(){
        return nodeA.xLoc();
    }
    public int aY(){
        return nodeA.yLoc();
    }
    public int bX(){
        return nodeB.xLoc();
    }
    public int bY(){
        return nodeB.yLoc();
    }
    @Override
    public String toString(){
        return "["+nodeA+", "+nodeB+"]";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Edge e = ( Edge ) obj;
        
        return  (nodeA.equals( e.nodeA( ) ) && nodeB.equals( e.nodeB( ) )) ||
                (nodeA.equals( e.nodeB( ) ) && nodeB.equals( e.nodeA( ) ));
    }

    @Override
    public int hashCode() {
        int hash;
        hash = (nodeA.xLoc()*nodeA.yLoc()) + (nodeB.xLoc()*nodeB.yLoc());
        return hash;
    }
}

