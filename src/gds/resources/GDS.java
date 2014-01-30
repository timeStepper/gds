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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.event.MouseInputAdapter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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
        imageOpacity = new javax.swing.JSlider();
        gridcontrolLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        verticalSplit = new javax.swing.JSplitPane();
        centerPanels = new javax.swing.JSplitPane();
        centerRightPanels = new javax.swing.JSplitPane();
        displayArea = new MyPanel();
        elementTabs = new javax.swing.JTabbedPane();
        childScroll = new javax.swing.JScrollPane();
        childList = new javax.swing.JList();
        connectionScroll = new javax.swing.JScrollPane();
        connectionList = new javax.swing.JList();
        leftFlank = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addableElementList = new AddableList(addableListModel, edit);
        addableElementListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        //treeModel.addTreeModelListener(new MyTreeModelListener());
        dynamicTree = new DynamicTree(rootNode,treeModel);
        dynamicTreeLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        editMode = new javax.swing.JToggleButton();
        genMode = new javax.swing.JToggleButton();
        editmodelabel = new javax.swing.JLabel();
        genmodelabel = new javax.swing.JLabel();
        topBar = new javax.swing.JPanel();
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

        bottomBar.setBackground(new java.awt.Color(180, 180, 180));
        bottomBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        bottomBar.setMinimumSize(new java.awt.Dimension(0, 120));

        gridY.setValue(4);
        gridY.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                gridYStateChanged(evt);
            }
        });

        gridYlabel.setText("units Y");

        gridX.setValue(4);
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

        imageOpacity.setMaximum(255);
        imageOpacity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                imageOpacityStateChanged(evt);
            }
        });

        gridcontrolLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridcontrolLabel.setText("Grid Controls");

        jLabel1.setText("Image Opacity");

        javax.swing.GroupLayout bottomBarLayout = new javax.swing.GroupLayout(bottomBar);
        bottomBar.setLayout(bottomBarLayout);
        bottomBarLayout.setHorizontalGroup(
            bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomBarLayout.createSequentialGroup()
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gridX, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gridXlabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gridY, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gridYlabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bottomBarLayout.createSequentialGroup()
                                .addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(imageOpacity, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bottomBarLayout.createSequentialGroup()
                                .addComponent(moduleSize)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel1))))
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(gridcontrolLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(gridX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gridXlabel)
                    .addComponent(gridYlabel)
                    .addComponent(moduleSize))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gridcontrolLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(bottomBarLayout.createSequentialGroup()
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(readY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelY)
                            .addComponent(readX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelX))
                        .addGap(14, 14, 14)
                        .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hereXr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hereYr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addComponent(imageOpacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        verticalSplit.setDividerLocation(0);
        verticalSplit.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        centerPanels.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        centerPanels.setDividerLocation(170);

        centerRightPanels.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        centerRightPanels.setDividerLocation(500);

        displayArea.setBackground(new java.awt.Color(210, 210, 210));
        displayArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        displayArea.setBackground( new Color( 130, 130, 130 ) );

        javax.swing.GroupLayout displayAreaLayout = new javax.swing.GroupLayout(displayArea);
        displayArea.setLayout(displayAreaLayout);
        displayAreaLayout.setHorizontalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );
        displayAreaLayout.setVerticalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 518, Short.MAX_VALUE)
        );

        centerRightPanels.setLeftComponent(displayArea);

        elementTabs.setBackground(new java.awt.Color(180, 180, 180));
        elementTabs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        childScroll.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        childList.setBackground(new java.awt.Color(180, 180, 180));
        childScroll.setViewportView(childList);

        elementTabs.addTab("Chld", childScroll);

        connectionScroll.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        connectionList.setBackground(new java.awt.Color(180, 180, 180));
        connectionScroll.setViewportView(connectionList);

        elementTabs.addTab("Cnct", connectionScroll);

        centerRightPanels.setRightComponent(elementTabs);

        centerPanels.setRightComponent(centerRightPanels);

        leftFlank.setBackground(new java.awt.Color(180, 180, 180));
        leftFlank.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        addableElementList.setBackground(new java.awt.Color(180, 180, 180));
        addableElementList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setViewportView(addableElementList);

        addableElementListLabel.setText("Select  Addable");

        dynamicTree.setBackground(new java.awt.Color(180, 180, 180));
        dynamicTree.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(dynamicTree);

        dynamicTreeLabel.setText("Element Tree");

        jPanel1.setBackground(new java.awt.Color(180, 180, 180));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editMode, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editmodelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(genMode, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genmodelabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editMode, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editmodelabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genMode, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genmodelabel)))
        );

        javax.swing.GroupLayout leftFlankLayout = new javax.swing.GroupLayout(leftFlank);
        leftFlank.setLayout(leftFlankLayout);
        leftFlankLayout.setHorizontalGroup(
            leftFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftFlankLayout.createSequentialGroup()
                .addGroup(leftFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addableElementListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dynamicTreeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        leftFlankLayout.setVerticalGroup(
            leftFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftFlankLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dynamicTreeLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addableElementListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        centerPanels.setLeftComponent(leftFlank);

        verticalSplit.setBottomComponent(centerPanels);

        topBar.setBackground(new java.awt.Color(180, 180, 180));
        topBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        verticalSplit.setLeftComponent(topBar);

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
        removeElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeElementActionPerformed(evt);
            }
        });
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

        scaleImage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        scaleImage.setText("Scale Image");
        scaleImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleImageActionPerformed(evt);
            }
        });
        imageMenu.add(scaleImage);

        translateImage.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
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
            .addComponent(bottomBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(verticalSplit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(verticalSplit)
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
        grid.changeWidth( (int) gridX.getValue( )*2 );
        displayArea.repaint();
    }//GEN-LAST:event_gridXStateChanged

    private void gridYStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_gridYStateChanged
        grid.changeHeight( (int) gridY.getValue( )*2 );
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

    private void imageOpacityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_imageOpacityStateChanged
        int op = imageOpacity.getValue();
        grid.setOpacity( op );
        ((MyPanel)displayArea).repaint();
        hereXr.setText( grid.opacity+"" );
    }//GEN-LAST:event_imageOpacityStateChanged

    private void removeElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeElementActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeElementActionPerformed

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
                    switch ( editElem ) {
                        case Add:
                            grid.setX( xLoc );
                            grid.setY(yLoc);
                            if ( grid.isReticle( xLoc, yLoc ) ) {
                                grid.selectOn();
                                mp.repaint();
                            }
                            else {
                                grid.selectOff();
                                mp.repaint();
                            }
                            break;
                        case Remove:
                            
                            break;
                    }
                break;
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
                        int button = e.getButton();
                        if ( button == MouseEvent.BUTTON1 ){
                            Location l = new Location( grid.currentX(), grid.currentY() );
                            Child c = new Child( new Element(), l );
                            edit.addEmpty( c );
                            //((DynamicTree)dynamicTree).addObject( c );

                            mp.repaint();
                        }
                        else if ( button == MouseEvent.BUTTON3 ) {

                        }
                    
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
    private javax.swing.JList addableElementList;
    private javax.swing.JLabel addableElementListLabel;
    private javax.swing.JPanel bottomBar;
    private javax.swing.JSplitPane centerPanels;
    private javax.swing.JSplitPane centerRightPanels;
    private javax.swing.JList childList;
    private javax.swing.JScrollPane childScroll;
    private javax.swing.JList connectionList;
    private javax.swing.JScrollPane connectionScroll;
    private javax.swing.JPanel displayArea;
    private javax.swing.JTree dynamicTree;
    private javax.swing.JLabel dynamicTreeLabel;
    private javax.swing.JMenu editMenu;
    private javax.swing.JToggleButton editMode;
    private javax.swing.JLabel editmodelabel;
    private javax.swing.JTabbedPane elementTabs;
    private javax.swing.JFileChooser gds;
    private javax.swing.JToggleButton genMode;
    private javax.swing.JLabel genmodelabel;
    private javax.swing.JSpinner gridSize;
    private javax.swing.JSpinner gridX;
    private javax.swing.JLabel gridXlabel;
    private javax.swing.JSpinner gridY;
    private javax.swing.JLabel gridYlabel;
    private javax.swing.JLabel gridcontrolLabel;
    private javax.swing.JTextField hereXr;
    private javax.swing.JTextField hereYr;
    private javax.swing.JMenu imageMenu;
    private javax.swing.JSlider imageOpacity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JPanel leftFlank;
    private javax.swing.JLabel moduleSize;
    private javax.swing.JTextField readX;
    private javax.swing.JTextField readY;
    private javax.swing.JMenuItem removeElement;
    private javax.swing.JMenuItem scaleImage;
    private javax.swing.JPanel topBar;
    private javax.swing.JMenuItem translateImage;
    private javax.swing.JSplitPane verticalSplit;
    // End of variables declaration//GEN-END:variables
    private Mode mode = new Mode( );
    Grid grid = new Grid();
    BackgroundImage backgroundImage = new BackgroundImage();
    EditElement edit = new EditElement();
    //the root of elementTree
    DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode( new Child() );
    //the elementTree is modified by methods on treeModel
    DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
    DefaultListModel addableListModel = new DefaultListModel();
}


