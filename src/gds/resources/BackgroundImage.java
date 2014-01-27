/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author owenpaulmeyer
 */

    class BackgroundImage {
        private BufferedImage image;
        int xLoc;
        int yLoc;
        int width;
        int height;
        
        public void loadImage ( File f ) {
            try {
                image = ImageIO.read ( f );
                width = image.getWidth( );
                height = image.getHeight( );
                } catch ( IOException ex ) {
            }
        }
        public void closeImage( ) {
            image = null;
        }
        public void paintImage( Graphics2D g ) {
            g.drawImage(image, xLoc, yLoc, width, height,null);
            //repaint(); this was the cpu hog bug!!!
        }
        public void resizeImage ( int x, int y ) {  
                width = x;
                height = y;
//                int scaleX = (int) (image.getWidth() * width);
//                int scaleY = (int) (image.getHeight() * height);
//                Image imagez = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
//                BufferedImage buffered = new BufferedImage(scaleX, scaleY, BufferedImage.TYPE_3BYTE_BGR);
//                buffered.getGraphics().drawImage(imagez, 0, 0 , null);
                image =  (BufferedImage) image.getScaledInstance(
                        width, height, BufferedImage.SCALE_DEFAULT );
        }
        public void moveImage ( int x, int y ){
                xLoc = xLoc + x;
                yLoc = yLoc + y;
        }
    }
    
