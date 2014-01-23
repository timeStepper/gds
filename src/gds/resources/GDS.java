/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author owenpaulmeyer
 */

public class GDS extends javax.swing.JFrame {

    public GDS() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gds = new javax.swing.JFileChooser();
        outerPanel = new javax.swing.JPanel();
        displayArea = new MyPanel();
        leftFlank = new javax.swing.JPanel();
        topBar = new javax.swing.JPanel();
        rightFlank = new javax.swing.JPanel();
        bottomBar = new javax.swing.JPanel();
        gridY = new javax.swing.JSpinner();
        gridYlabel = new javax.swing.JLabel();
        gridX = new javax.swing.JSpinner();
        gridXlabel = new javax.swing.JLabel();
        gridSize = new javax.swing.JSpinner();
        moduleSize = new javax.swing.JLabel();
        readY = new javax.swing.JTextField();
        labelY = new javax.swing.JLabel();
        labelX = new javax.swing.JLabel();
        readX = new javax.swing.JTextField();
        scale_position = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Close = new javax.swing.JMenuItem();

        gds.setDialogTitle("Select Image");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        displayArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        displayArea.setBackground( new Color( 136, 177, 245 ) );

        javax.swing.GroupLayout displayAreaLayout = new javax.swing.GroupLayout(displayArea);
        displayArea.setLayout(displayAreaLayout);
        displayAreaLayout.setHorizontalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        displayAreaLayout.setVerticalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );

        leftFlank.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        leftFlank.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                leftFlankComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout leftFlankLayout = new javax.swing.GroupLayout(leftFlank);
        leftFlank.setLayout(leftFlankLayout);
        leftFlankLayout.setHorizontalGroup(
            leftFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );
        leftFlankLayout.setVerticalGroup(
            leftFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        topBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 82, Short.MAX_VALUE)
        );

        rightFlank.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rightFlank.setMaximumSize(new java.awt.Dimension(100, 32767));

        javax.swing.GroupLayout rightFlankLayout = new javax.swing.GroupLayout(rightFlank);
        rightFlank.setLayout(rightFlankLayout);
        rightFlankLayout.setHorizontalGroup(
            rightFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 104, Short.MAX_VALUE)
        );
        rightFlankLayout.setVerticalGroup(
            rightFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
        );

        bottomBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        gridY.setValue(8);
        gridY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gridYStateChanged(evt);
            }
        });

        gridYlabel.setText("units Y");

        gridX.setValue(8);
        gridX.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gridXStateChanged(evt);
            }
        });

        gridXlabel.setText("units X");

        gridSize.setValue(40);
        gridSize.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gridSizeStateChanged(evt);
            }
        });

        moduleSize.setText("unit Size");

        readY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readYActionPerformed(evt);
            }
        });

        labelY.setText("Y");

        labelX.setText("X");

        readX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readXActionPerformed(evt);
            }
        });

        scale_position.setText("scale");
        scale_position.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scale_positionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomBarLayout = new javax.swing.GroupLayout(bottomBar);
        bottomBar.setLayout(bottomBarLayout);
        bottomBarLayout.setHorizontalGroup(
            bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomBarLayout.createSequentialGroup()
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addComponent(gridY, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gridYlabel))
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addComponent(gridX, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gridXlabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scale_position, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moduleSize)))
                .addGap(18, 18, 18)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(readX)
                    .addComponent(readY, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelY)
                    .addComponent(labelX))
                .addContainerGap())
        );
        bottomBarLayout.setVerticalGroup(
            bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomBarLayout.createSequentialGroup()
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gridY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gridYlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gridX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gridXlabel)
                    .addComponent(scale_position, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moduleSize)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(readY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelY))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(readX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelX))
                .addContainerGap())
        );

        javax.swing.GroupLayout outerPanelLayout = new javax.swing.GroupLayout(outerPanel);
        outerPanel.setLayout(outerPanelLayout);
        outerPanelLayout.setHorizontalGroup(
            outerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(outerPanelLayout.createSequentialGroup()
                .addComponent(leftFlank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(outerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightFlank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        outerPanelLayout.setVerticalGroup(
            outerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outerPanelLayout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(outerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(outerPanelLayout.createSequentialGroup()
                        .addComponent(displayArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bottomBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rightFlank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftFlank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Image");

        Open.setText("Open Image");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu2.add(Open);

        Close.setText("Close Image");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        jMenu2.add(Close);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        int returnVal = gds.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = gds.getSelectedFile();
              MyPanel dpA = (MyPanel)displayArea;
              dpA.loadImage( file );
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void scale_positionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scale_positionActionPerformed
        MyPanel dpa = ( MyPanel ) displayArea;
        dpa.resize( );
    }//GEN-LAST:event_scale_positionActionPerformed

    private void gridXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridXStateChanged
        MyPanel dp = (MyPanel) displayArea;
        int c = (int) gridX.getValue( );
        dp.changeGridWidth( c );
        readX.setText( c + "" );
    }//GEN-LAST:event_gridXStateChanged

    private void gridYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridYStateChanged
        MyPanel dp = (MyPanel) displayArea;
        dp.changeGridHeight( (int) gridY.getValue( ));
    }//GEN-LAST:event_gridYStateChanged

    private void readXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_readXActionPerformed

    private void leftFlankComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_leftFlankComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_leftFlankComponentHidden

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        MyPanel dp = (MyPanel) displayArea;
        dp.closeImage( );
    }//GEN-LAST:event_CloseActionPerformed

    private void gridSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridSizeStateChanged
        MyPanel dp = (MyPanel) displayArea;
        dp.changeGridUnit( ( int )gridSize.getValue( ) );
    }//GEN-LAST:event_gridSizeStateChanged

    private void readYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_readYActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GDS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GDS().setVisible(true);
            }
        });
    }
    
    public class MyPanel extends JPanel {
        private BufferedImage image;
        
        private int xLoc = 0;
        private int yLoc = 0;     
        private boolean toggle = true;
        private int width;
        private int height;
        Grid grid = new Grid( );
        
        
        public void changeGridWidth( int w ) { grid.changeWidth( w ); repaint(); }
        public void changeGridHeight( int h ) { grid.changeHeight( h ); repaint(); }
        public void changeGridUnit( int u ) { grid.changeModuleSize( u ); repaint(); }
        //javax.swing.GroupLayout displayAreaLayout = new javax.swing.GroupLayout(this);
        
        
        
        public void resize( ){
            if ( toggle ) toggle = false;
            else toggle = true;
        }
        
        public void loadImage ( File f ) {
            //image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            try {
                image = ImageIO.read ( f );
                width = image.getWidth( );
                height = image.getHeight( );
                
                //setAlpha( );
            } catch ( IOException ex ) {
                
            }
            repaint();
        }
        public void closeImage( ) { image = null; repaint( ); }
        

        public MyPanel ( ) {
            
            addMouseMotionListener ( new MouseAdapter ( ) {
                @Override
                public void mouseDragged ( MouseEvent e ) {
                    changeImage ( e.getX( ), e.getY( ) );
                }
            });
            addMouseMotionListener ( new MouseAdapter ( ) {
                @Override
                public void mouseMoved ( MouseEvent e ) {
                    int dw = getWidth( );
                    int dh = getHeight( );
                    
                    readY.setText( (e.getY( ) - dh/2) + "" );
                    readX.setText( (e.getX( ) - dw/2) + "" );
                    System.out.println( "dh: " + dh );
                    System.out.println( "dw: " + dw );
                }
            });
        }
        
        private void changeImage ( int x, int y ) {
            
            if ( toggle ) moveImage ( x, y );
            else resizeImage ( x, y );
        }

        private void resizeImage ( int x, int y ) {                        
                repaint(xLoc,yLoc,width,height);
                // Update coordinates.
                width = x;
                height = y;
                image = (BufferedImage)image.getScaledInstance( width, height, BufferedImage.SCALE_DEFAULT );                
                // Repaint the square at the new location.
                repaint(xLoc, yLoc, width, height);
        }
        private void moveImage ( int x, int y ){
            
                
                // The square is moving, repaint background 
                // over the old square location. 
                repaint(xLoc,yLoc,width ,height);
                // Update coordinates.
                xLoc = x;
                yLoc = y;
                
                // Repaint the square at the new location.
                repaint( xLoc, yLoc, width, height);
            
        }
        @Override
        protected void paintComponent(Graphics g1) {
            Graphics2D g = (Graphics2D)g1;
            super.paintComponent(g);
            g.drawImage(image, xLoc, yLoc, width, height,null); // see javadoc for more info on the parameters
            //g.drawOval(50, 50, 50, 50);
            //g.setColor( new Color ( 200, 20 , 20, 122 ) );
            //g.fillRect(75, 75, 50, 50);
            //g.setColor( Color.BLACK );
            //g.drawRect(75, 75, 50, 50);
            grid.drawGrid( g, getWidth( ), getHeight( ) );
        }
    }
    
    class Grid {
        int opacity = 90;
        Color col = new Color ( 136, 177, 245, opacity );
        int mS = 40;
        int width = 8;
        int height = 8;
        
        Grid (  ) {            
        }
        
        public void changeWidth( int w ) { width = w; }
        public void changeHeight( int h ) { height = h; }
        public void changeModuleSize( int m ) { mS = m; }
        
        public void drawGrid ( Graphics2D g, int w, int h ) {
            
            
            int offX = ( w - width*mS ) / 2;
            int offY = ( h - height*mS ) / 2;
            
//            g.setColor(col);
//            g.fillRect(0, 0, w, h);
//            g.setStroke(new BasicStroke(3F));
//            int dw = displayArea.getWidth( );
//            int dh = displayArea.getHeight( );
//            g.setColor( new Color( 0,255,0,100 ) );
//            g.drawLine( dw / 2, 0, dw / 2, dh );
//            g.setColor( new Color( 255,0,0,100 ) );
//            g.drawLine( 0, dh / 2, dw, dh / 2);
            
            g.setStroke(new BasicStroke(1F));
            g.setColor( Color.BLACK );
            for (int x = 0; x <= width; ++x) {
                g.drawLine( x*mS + offX, offY, x*mS + offX, height*mS + offY );
            }
            for (int y = 0; y <= height; ++y ) {
                g.drawLine( offX, y*mS + offY, width*mS + offX, y*mS + offY);
            }
            
            g.setColor(col);
            g.fillRect(0, 0, w, h);
            g.setStroke(new BasicStroke(3F));
            int dw = displayArea.getWidth( );
            int dh = displayArea.getHeight( );
            g.setColor( new Color( 0,255,0,100 ) );
            g.drawLine( dw / 2, 0, dw / 2, dh );
            g.setColor( new Color( 255,0,0,100 ) );
            g.drawLine( 0, dh / 2, dw, dh / 2);
            
        }
     
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Close;
    private javax.swing.JMenuItem Open;
    private javax.swing.JPanel bottomBar;
    private javax.swing.JPanel displayArea;
    private javax.swing.JFileChooser gds;
    private javax.swing.JSpinner gridSize;
    private javax.swing.JSpinner gridX;
    private javax.swing.JLabel gridXlabel;
    private javax.swing.JSpinner gridY;
    private javax.swing.JLabel gridYlabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JPanel leftFlank;
    private javax.swing.JLabel moduleSize;
    private javax.swing.JPanel outerPanel;
    private javax.swing.JTextField readX;
    private javax.swing.JTextField readY;
    private javax.swing.JPanel rightFlank;
    private javax.swing.JButton scale_position;
    private javax.swing.JPanel topBar;
    // End of variables declaration//GEN-END:variables
    
}


