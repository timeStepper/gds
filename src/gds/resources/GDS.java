/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import javax.swing.event.MouseInputAdapter;

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
        hereYr = new javax.swing.JTextField();
        hereXr = new javax.swing.JTextField();
        rightFlank = new javax.swing.JPanel();
        editMode = new javax.swing.JToggleButton();
        genMode = new javax.swing.JToggleButton();
        editmodelabel = new javax.swing.JLabel();
        genmodelabel = new javax.swing.JLabel();
        displayArea = new MyPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        addEmpty = new javax.swing.JMenuItem();
        removeElement = new javax.swing.JMenuItem();
        imageMenu = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Close = new javax.swing.JMenuItem();
        scaleImage = new javax.swing.JMenuItem();
        translateImage = new javax.swing.JMenuItem();

        gds.setDialogTitle("Select Image");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        labelY.setText("Y");

        labelX.setText("X");

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
                        .addComponent(gridXlabel))
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(moduleSize)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 538, Short.MAX_VALUE)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hereXr, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addComponent(readX, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelX)))
                .addGap(25, 25, 25)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(readY, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hereYr, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelY)
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
                    .addComponent(gridXlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moduleSize)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bottomBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(readY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelY)
                    .addComponent(readX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelX))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hereXr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hereYr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        rightFlank.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rightFlank.setMaximumSize(new java.awt.Dimension(100, 32767));

        editMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editModeActionPerformed(evt);
            }
        });

        genMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genModeActionPerformed(evt);
            }
        });

        editmodelabel.setText("Edit Mode");

        genmodelabel.setText("Gen Mode");

        javax.swing.GroupLayout rightFlankLayout = new javax.swing.GroupLayout(rightFlank);
        rightFlank.setLayout(rightFlankLayout);
        rightFlankLayout.setHorizontalGroup(
            rightFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightFlankLayout.createSequentialGroup()
                .addGroup(rightFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightFlankLayout.createSequentialGroup()
                        .addComponent(editMode, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editmodelabel))
                    .addGroup(rightFlankLayout.createSequentialGroup()
                        .addComponent(genMode, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genmodelabel)))
                .addGap(0, 49, Short.MAX_VALUE))
        );
        rightFlankLayout.setVerticalGroup(
            rightFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightFlankLayout.createSequentialGroup()
                .addGroup(rightFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editMode, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editmodelabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genMode, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genmodelabel))
                .addGap(0, 542, Short.MAX_VALUE))
        );

        displayArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        displayArea.setBackground( new Color( 136, 177, 245 ) );

        javax.swing.GroupLayout displayAreaLayout = new javax.swing.GroupLayout(displayArea);
        displayArea.setLayout(displayAreaLayout);
        displayAreaLayout.setHorizontalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        displayAreaLayout.setVerticalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        editMenu.setText("Edit");

        addEmpty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        addEmpty.setText("Add Empty");
        addEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmptyActionPerformed(evt);
            }
        });
        editMenu.add(addEmpty);

        removeElement.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
        removeElement.setText("Remove Element");
        editMenu.add(removeElement);

        jMenuBar1.add(editMenu);

        imageMenu.setText("Image");

        Open.setText("Open Image");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        imageMenu.add(Open);

        Close.setText("Close Image");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        imageMenu.add(Close);

        scaleImage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        scaleImage.setText("Scale Image");
        scaleImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleImageActionPerformed(evt);
            }
        });
        imageMenu.add(scaleImage);

        translateImage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.SHIFT_MASK));
        translateImage.setText("Translate Image");
        translateImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateImageActionPerformed(evt);
            }
        });
        imageMenu.add(translateImage);

        jMenuBar1.add(imageMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(rightFlank, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(displayArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(bottomBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightFlank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(displayArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        int returnVal = gds.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = gds.getSelectedFile();
              backgroundImage.loadImage( file );
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void gridXStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridXStateChanged
        grid.changeWidth( (int) gridX.getValue( ) );
        displayArea.repaint();
    }//GEN-LAST:event_gridXStateChanged

    private void gridYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridYStateChanged
        grid.changeHeight( (int) gridY.getValue( ) );
        displayArea.repaint();
    }//GEN-LAST:event_gridYStateChanged

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        backgroundImage.closeImage( );
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_CloseActionPerformed

    private void gridSizeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridSizeStateChanged
        int m = (int)gridSize.getValue();
        grid.changeModuleSize( m );
        edit.setModule(m);
        displayArea.repaint();
    }//GEN-LAST:event_gridSizeStateChanged

    private void editModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editModeActionPerformed
        if ( genMode.isSelected( ) ) genMode.setSelected( false );
        mode.setEdit();
    }//GEN-LAST:event_editModeActionPerformed

    private void genModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genModeActionPerformed
        if ( editMode.isSelected( ) ) editMode.setSelected( false );
        mode.setGen();
    }//GEN-LAST:event_genModeActionPerformed

    private void scaleImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleImageActionPerformed
        mode.scaleImage();
        genMode.setSelected( false );
        editMode.setSelected( false );
    }//GEN-LAST:event_scaleImageActionPerformed

    private void translateImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateImageActionPerformed
        mode.translateImage();
        genMode.setSelected( false );
        editMode.setSelected( false );
    }//GEN-LAST:event_translateImageActionPerformed

    private void addEmptyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmptyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEmptyActionPerformed

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
        public MyPanel ( ) {
            
            addMouseMotionListener ( mode );
            addMouseListener ( mode );
        }
        
        @Override
        protected void paintComponent(Graphics g1) {
            Graphics2D g = (Graphics2D)g1;
            super.paintComponent(g);
            backgroundImage.paintImage( g );
            grid.paintGrid( g, getWidth( ), getHeight( ) );
            edit.paintEdit( g );
        }
    }

    class Mode extends MouseInputAdapter { //implements MouseMotionListener, MouseListener {
        State mode = State.Off;
        State image = State.Off;
        State editElem = State.Add;
        int xLoc;
        int yLoc;
        int setX;
        int setY;
        
        public void scaleImage(){
            image = State.Scale;
            mode = State.Off;
        }
        public void translateImage() {
            image = State.Move;
            mode = State.Off;
        }
        public void setGen( ) {
            mode = State.Gen;
            image = State.Off;
        }
        public void setEdit( ) {
            mode = State.Edit;
            image = State.Off;
        }
        
        @Override
        public void mouseMoved(MouseEvent e) {
            xLoc = e.getX();
            yLoc = e.getY();
            MyPanel mp = ( MyPanel )displayArea;
            switch ( mode ) {
                case Edit :
                    grid.setX( xLoc );
                    grid.setY(yLoc);
                    int module = grid.mS;
                    int modX = Math.abs((grid.originX() - xLoc) % module);
                    int modY = Math.abs((grid.originY() - yLoc) % module);
                    int hereX = Math.abs(xLoc - grid.originX());
                    int hereY = Math.abs(yLoc - grid.originY());
                    int halfX = ((grid.width/2) *module) ;
                    int halfY = ((grid.height/2) *module) ;
                    readY.setText( setY +"");
                    readX.setText( setX +"");
//                    if ( (modX < 5 || modX > module-5) && (modY < 5 || modY > module-5) &&
//                            hereX < halfX && hereY < halfY ) {
                    if ( grid.isReticle( xLoc, yLoc ) ) {
                        Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR); 
                        setCursor(cursor);
                    }
                    else setCursor( Cursor.DEFAULT_CURSOR );
            }
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            MyPanel mp = ( MyPanel )displayArea;
            int x = e.getX();
            int y = e.getY();
            switch ( image ) {
                case Move:
                    backgroundImage.moveImage( x - xLoc, y - yLoc );
                    xLoc = x;
                    yLoc = y;
                    break;
                case Scale:
                    backgroundImage.resizeImage(x, y);
                    break;
            }
            mp.repaint();
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            
            MyPanel mp = ( MyPanel )displayArea;
            switch ( mode ) {
                case Edit :
                    Location l = new Location( grid.currentX(), grid.currentY() );
                    edit.addEmpty( l );
                    mp.repaint();
                    
            }
        }
        //update displayArea relations with grid and edit
        @Override
        public void mouseEntered(MouseEvent e) {
            MyPanel mp = (MyPanel)displayArea;
            int ox = mp.getWidth() / 2;
            int yx = mp.getHeight() / 2;
            grid.setOriginX(ox);
            grid.setOriginY(yx);
            edit.setX(ox);
            edit.setY(yx);            
            mp.repaint();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            setCursor(Cursor.DEFAULT_CURSOR);
        }
        @Override
        public void mousePressed(MouseEvent e) {
            
        }
        @Override
        public void mouseReleased(MouseEvent e) {
            
        }
    }

    
    class Circle {
        int x;
        int y;
        State state = State.Off;
        
        public void paintCirc( Graphics2D g ) {
            switch ( state ){
                case On :
                    g.setColor(Color.white);
                    g.fillOval(x, y, 8, 8);
                    g.setColor(Color.BLACK);
                    g.drawOval( x, y, 8, 8 );
                    break;
            }
        }
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Close;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem addEmpty;
    private javax.swing.JPanel bottomBar;
    private javax.swing.JPanel displayArea;
    private javax.swing.JMenu editMenu;
    private javax.swing.JToggleButton editMode;
    private javax.swing.JLabel editmodelabel;
    private javax.swing.JFileChooser gds;
    private javax.swing.JToggleButton genMode;
    private javax.swing.JLabel genmodelabel;
    private javax.swing.JSpinner gridSize;
    private javax.swing.JSpinner gridX;
    private javax.swing.JLabel gridXlabel;
    private javax.swing.JSpinner gridY;
    private javax.swing.JLabel gridYlabel;
    private javax.swing.JTextField hereXr;
    private javax.swing.JTextField hereYr;
    private javax.swing.JMenu imageMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JLabel moduleSize;
    private javax.swing.JTextField readX;
    private javax.swing.JTextField readY;
    private javax.swing.JMenuItem removeElement;
    private javax.swing.JPanel rightFlank;
    private javax.swing.JMenuItem scaleImage;
    private javax.swing.JMenuItem translateImage;
    // End of variables declaration//GEN-END:variables
    private Mode mode = new Mode( );
    Grid grid = new Grid();
    BackgroundImage backgroundImage = new BackgroundImage();
    EditElement edit = new EditElement();
}


