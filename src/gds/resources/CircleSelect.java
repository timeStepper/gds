/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author owenpaulmeyer
 */
public class CircleSelect {
    int x;
    int y;
    CircleSelect( int xl, int yl ){
        x = xl;
        y = yl;
    }
    public void paintCircleSelect( Graphics2D g ){
        g.setColor(Color.WHITE);
        //g.fillOval(originX+(l.xLoc()*module)-4, originY+(l.yLoc()*module)-4, 8, 8);
    }
}
