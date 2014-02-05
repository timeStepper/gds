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
import java.awt.RenderingHints;
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
        hereYr = new javax.swing.JTextField();
        hereXr = new javax.swing.JTextField();
        imageOpacity = new javax.swing.JSlider();
        gridcontrolLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        editMode = new javax.swing.JToggleButton();
        genMode = new javax.swing.JToggleButton();
        gridToggleButton = new javax.swing.JButton();
        verticalSplit = new javax.swing.JSplitPane();
        centerPanels = new javax.swing.JSplitPane();
        centerRightPanels = new javax.swing.JSplitPane();
        displayArea = globalDisplayArea;
        elementTabs = new javax.swing.JTabbedPane();
        editControls = new javax.swing.JPanel();
        makeElementButton = new javax.swing.JButton();
        resetRootButton = new javax.swing.JButton();
        viewEmptiesButton = new javax.swing.JButton();
        renameAddable = new javax.swing.JTextField();
        renameAddableButton = new javax.swing.JButton();
        makeConnectionButton = new javax.swing.JButton();
        rotateRightButton = new javax.swing.JButton();
        rotateLeftButton = new javax.swing.JButton();
        reflectXButton = new javax.swing.JButton();
        reflectYButton = new javax.swing.JButton();
        scaleElementButton = new javax.swing.JButton();
        scaleField = new javax.swing.JTextField();
        translateButton = new javax.swing.JButton();
        readX = new javax.swing.JTextField();
        labelX = new javax.swing.JLabel();
        readY = new javax.swing.JTextField();
        labelY = new javax.swing.JLabel();
        childScroll = new javax.swing.JScrollPane();
        childList = childrenList;
        connectionScroll = new javax.swing.JScrollPane();
        connectionList = new javax.swing.JList();
        leftFlank = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addableElementList = new AddableList(addableListModel, edit);
        addableElementListLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        //treeModel.addTreeModelListener(new MyTreeModelListener());
        dynamicTree = dt;//dt must be initialized before here to be passed in to EditElement edit;
        dynamicTreeLabel = new javax.swing.JLabel();
        topBar = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();
        addEmpty = new javax.swing.JMenuItem();
        removeElement = new javax.swing.JMenuItem();
        makeConnectionMenuItem = new javax.swing.JMenuItem();
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

        imageOpacity.setMaximum(255);
        imageOpacity.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                imageOpacityStateChanged(evt);
            }
        });

        gridcontrolLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gridcontrolLabel.setText("Grid Controls");

        jLabel1.setText("Image Opacity");

        editMode.setSelected(true);
        editMode.setText("Edit Mode");
        editMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editModeActionPerformed(evt);
            }
        });

        genMode.setText("Gen Mode");
        genMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genModeActionPerformed(evt);
            }
        });

        gridToggleButton.setText("Toggle Grid");
        gridToggleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gridToggleButtonActionPerformed(evt);
            }
        });

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
                                .addComponent(moduleSize)
                                .addGap(174, 174, 174)
                                .addComponent(jLabel1))
                            .addGroup(bottomBarLayout.createSequentialGroup()
                                .addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(gridToggleButton)
                                .addGap(48, 48, 48)
                                .addComponent(imageOpacity, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(gridcontrolLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genMode, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hereXr, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(hereYr, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        bottomBarLayout.setVerticalGroup(
            bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomBarLayout.createSequentialGroup()
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gridY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gridX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gridSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gridToggleButton))
                        .addGap(7, 7, 7)
                        .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(gridXlabel)
                            .addComponent(gridYlabel)
                            .addComponent(moduleSize)))
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(imageOpacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gridcontrolLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(bottomBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editMode)
                .addGap(11, 11, 11)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hereXr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hereYr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        verticalSplit.setDividerLocation(0);
        verticalSplit.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        centerPanels.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        centerPanels.setDividerLocation(170);

        centerRightPanels.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        centerRightPanels.setDividerLocation(496);

        displayArea.setBackground(new java.awt.Color(210, 210, 210));
        displayArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        displayArea.setBackground( new Color( 130, 130, 130 ) );

        javax.swing.GroupLayout displayAreaLayout = new javax.swing.GroupLayout(displayArea);
        displayArea.setLayout(displayAreaLayout);
        displayAreaLayout.setHorizontalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        displayAreaLayout.setVerticalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 537, Short.MAX_VALUE)
        );

        centerRightPanels.setLeftComponent(displayArea);

        elementTabs.setBackground(new java.awt.Color(180, 180, 180));
        elementTabs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        makeElementButton.setText(" Make Element");
        makeElementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeElementButtonActionPerformed(evt);
            }
        });

        resetRootButton.setText("Reset Elem");
        resetRootButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetRootButtonActionPerformed(evt);
            }
        });

        viewEmptiesButton.setText("Toggle View");
        viewEmptiesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEmptiesButtonActionPerformed(evt);
            }
        });

        renameAddable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameAddableActionPerformed(evt);
            }
        });

        renameAddableButton.setText("Rename Elem");
        renameAddableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameAddableButtonActionPerformed(evt);
            }
        });

        makeConnectionButton.setText("Connect Elems");
        makeConnectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeConnectionButtonActionPerformed(evt);
            }
        });

        rotateRightButton.setText("Rotate R");
        rotateRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotateRightButtonActionPerformed(evt);
            }
        });

        rotateLeftButton.setText("Rotate L");
        rotateLeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rotateLeftButtonActionPerformed(evt);
            }
        });

        reflectXButton.setText("Reflect X");
        reflectXButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reflectXButtonActionPerformed(evt);
            }
        });

        reflectYButton.setText("Reflect Y");
        reflectYButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reflectYButtonActionPerformed(evt);
            }
        });

        scaleElementButton.setText("Scale");
        scaleElementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleElementButtonActionPerformed(evt);
            }
        });

        translateButton.setText("Translate");
        translateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateButtonActionPerformed(evt);
            }
        });

        labelX.setText("X");

        labelY.setText("Y");

        javax.swing.GroupLayout editControlsLayout = new javax.swing.GroupLayout(editControls);
        editControls.setLayout(editControlsLayout);
        editControlsLayout.setHorizontalGroup(
            editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editControlsLayout.createSequentialGroup()
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(editControlsLayout.createSequentialGroup()
                        .addComponent(viewEmptiesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(makeConnectionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editControlsLayout.createSequentialGroup()
                        .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(makeElementButton, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(renameAddableButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(renameAddable)
                            .addComponent(resetRootButton, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editControlsLayout.createSequentialGroup()
                        .addComponent(rotateRightButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rotateLeftButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editControlsLayout.createSequentialGroup()
                        .addComponent(reflectXButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reflectYButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editControlsLayout.createSequentialGroup()
                        .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editControlsLayout.createSequentialGroup()
                                .addComponent(translateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(readX, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelX)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(readY, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editControlsLayout.createSequentialGroup()
                                .addComponent(scaleElementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scaleField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelY)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        editControlsLayout.setVerticalGroup(
            editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editControlsLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeElementButton)
                    .addComponent(resetRootButton))
                .addGap(18, 18, 18)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(renameAddableButton)
                    .addComponent(renameAddable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(makeConnectionButton)
                    .addComponent(viewEmptiesButton))
                .addGap(176, 176, 176)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotateRightButton)
                    .addComponent(rotateLeftButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reflectXButton)
                    .addComponent(reflectYButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scaleElementButton)
                    .addComponent(scaleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(translateButton)
                    .addComponent(readX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelX)
                    .addComponent(readY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelY))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        elementTabs.addTab("Edit", editControls);

        childScroll.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ((ChildrenList)childList).setEditElem( edit );
        ((ChildrenList)childList).setGrid( grid );
        ((ChildrenList)childList).setPanel(globalDisplayArea);
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

        edit.setAddableList( (AddableList) addableElementList );
        addableElementList.setBackground(new java.awt.Color(180, 180, 180));
        addableElementList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setViewportView(addableElementList);

        addableElementListLabel.setText("Select  Addable");

        dynamicTree.setBackground(new java.awt.Color(180, 180, 180));
        dynamicTree.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setViewportView(dynamicTree);
        ((DynamicTree)dynamicTree).setEditElement( edit );
        ((DynamicTree)dynamicTree).setDisplayArea( globalDisplayArea );

        dynamicTreeLabel.setText("Element Tree");

        javax.swing.GroupLayout leftFlankLayout = new javax.swing.GroupLayout(leftFlank);
        leftFlank.setLayout(leftFlankLayout);
        leftFlankLayout.setHorizontalGroup(
            leftFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
            .addComponent(dynamicTreeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addableElementListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftFlankLayout.setVerticalGroup(
            leftFlankLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftFlankLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dynamicTreeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addableElementListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
        );

        centerPanels.setLeftComponent(leftFlank);

        verticalSplit.setBottomComponent(centerPanels);

        topBar.setBackground(new java.awt.Color(180, 180, 180));
        topBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField1.setText("jTextField1");
        jTextField1.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap(418, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(425, Short.MAX_VALUE))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        verticalSplit.setLeftComponent(topBar);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        editMenu.setText("Edit");
        editMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editMenuActionPerformed(evt);
            }
        });

        addEmpty.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        addEmpty.setText("Add Empty");
        addEmpty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmptyActionPerformed(evt);
            }
        });
        editMenu.add(addEmpty);

        removeElement.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        removeElement.setText("Remove Element");
        removeElement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeElementActionPerformed(evt);
            }
        });
        editMenu.add(removeElement);

        makeConnectionMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        makeConnectionMenuItem.setText("Make Connection");
        makeConnectionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeConnectionMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(makeConnectionMenuItem);

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
            .addComponent(verticalSplit, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(verticalSplit, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
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
        Location l = new Location( grid.currentX(), grid.currentY() );
        edit.addChild( new Child( new Element(), l ));
    }//GEN-LAST:event_addEmptyActionPerformed

    private void imageOpacityStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_imageOpacityStateChanged
        int op = imageOpacity.getValue();
        grid.setOpacity( op );
        ((MyPanel)displayArea).repaint();
        hereXr.setText( grid.opacity+"" );
    }//GEN-LAST:event_imageOpacityStateChanged

    private void removeElementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeElementActionPerformed
        Location l = new Location( grid.currentX(), grid.currentY() );
        edit.removeChild(l);
    }//GEN-LAST:event_removeElementActionPerformed

    private void resetRootButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetRootButtonActionPerformed
        edit.resetRoot();
    }//GEN-LAST:event_resetRootButtonActionPerformed

    private void makeElementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeElementButtonActionPerformed
        edit.makeElement();
        edit.renameAddable( renameAddable.getText() );
        addableElementList.updateUI();
    }//GEN-LAST:event_makeElementButtonActionPerformed

    private void viewEmptiesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEmptiesButtonActionPerformed
        edit.togglePaintEmpty();
        globalDisplayArea.repaint();
    }//GEN-LAST:event_viewEmptiesButtonActionPerformed

    private void makeConnectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeConnectionButtonActionPerformed
        edit.makeConnection();
    }//GEN-LAST:event_makeConnectionButtonActionPerformed

    private void renameAddableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameAddableButtonActionPerformed
        edit.renameAddable( renameAddable.getText() );
        addableElementList.updateUI();
    }//GEN-LAST:event_renameAddableButtonActionPerformed

    private void makeConnectionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeConnectionMenuItemActionPerformed
        edit.makeConnection();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_makeConnectionMenuItemActionPerformed

    private void rotateRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotateRightButtonActionPerformed
        edit.rotateRight();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_rotateRightButtonActionPerformed

    private void rotateLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotateLeftButtonActionPerformed
        edit.rotateLeft();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_rotateLeftButtonActionPerformed

    private void reflectXButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reflectXButtonActionPerformed
        edit.reflectX();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_reflectXButtonActionPerformed

    private void reflectYButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reflectYButtonActionPerformed
        edit.reflectY();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_reflectYButtonActionPerformed

    private void scaleElementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleElementButtonActionPerformed
        edit.scale(Integer.parseInt(scaleField.getText()));
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_scaleElementButtonActionPerformed

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editMenuActionPerformed

    private void gridToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gridToggleButtonActionPerformed
        grid.toggleGrid();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_gridToggleButtonActionPerformed

    private void renameAddableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameAddableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_renameAddableActionPerformed

    private void translateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateButtonActionPerformed
        int x, y;
        try{
            x = Integer.parseInt(readX.getText());
            y = Integer.parseInt(readY.getText());
            edit.translate(x, y);
            ((MyPanel)displayArea).repaint();
        }catch(NumberFormatException nfe) {}
        
        
    }//GEN-LAST:event_translateButtonActionPerformed

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
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
            super.paintComponent(g);
            backgroundImage.paintImage( g );
            grid.paintGrid( g, getWidth( ), getHeight( ) );
            edit.paintAddable(g);
            edit.paintEdit( g );
            edit.paintHighlighted(g);
            childrenList.paintSelections(g);
            
        }
    }

    class Mode extends MouseInputAdapter { //implements MouseMotionListener, MouseListener {
        State mode = State.Edit;
        State image = State.Off;
        State editElem = State.Add;
        State elementClone = State.On;
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
                        Location l = new Location( grid.currentX(), grid.currentY() );
                        Child c;
                        if ( button == MouseEvent.BUTTON1 ){
                            if ( elementClone == State.On )
                                c = new Child( edit.addable().clone(), l );
                            else c = new Child( edit.addable(), l );
                            edit.addChild( c );
                            mp.repaint();
                        }
                        else if ( button == MouseEvent.BUTTON2 ) {
                            edit.removeChild( l );
                            ((MyPanel)displayArea).repaint();
                        }
                        else if ( button == MouseEvent.BUTTON3 ) {
                            edit.highlight(l);
                            ((MyPanel)displayArea).repaint();
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
    private javax.swing.JPanel editControls;
    private javax.swing.JMenu editMenu;
    private javax.swing.JToggleButton editMode;
    private javax.swing.JTabbedPane elementTabs;
    private javax.swing.JFileChooser gds;
    private javax.swing.JToggleButton genMode;
    private javax.swing.JSpinner gridSize;
    private javax.swing.JButton gridToggleButton;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JPanel leftFlank;
    private javax.swing.JButton makeConnectionButton;
    private javax.swing.JMenuItem makeConnectionMenuItem;
    private javax.swing.JButton makeElementButton;
    private javax.swing.JLabel moduleSize;
    private javax.swing.JTextField readX;
    private javax.swing.JTextField readY;
    private javax.swing.JButton reflectXButton;
    private javax.swing.JButton reflectYButton;
    private javax.swing.JMenuItem removeElement;
    private javax.swing.JTextField renameAddable;
    private javax.swing.JButton renameAddableButton;
    private javax.swing.JButton resetRootButton;
    private javax.swing.JButton rotateLeftButton;
    private javax.swing.JButton rotateRightButton;
    private javax.swing.JButton scaleElementButton;
    private javax.swing.JTextField scaleField;
    private javax.swing.JMenuItem scaleImage;
    private javax.swing.JPanel topBar;
    private javax.swing.JButton translateButton;
    private javax.swing.JMenuItem translateImage;
    private javax.swing.JSplitPane verticalSplit;
    private javax.swing.JButton viewEmptiesButton;
    // End of variables declaration//GEN-END:variables
    private Mode mode = new Mode( );
    Grid grid = new Grid();
    BackgroundImage backgroundImage = new BackgroundImage();
    MyPanel globalDisplayArea = new MyPanel();
    //the root of elementTree
    DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode( new Child( ) );
    //the elementTree is modified by methods on treeModel
    DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
    DefaultListModel addableListModel = new DefaultListModel();
    DefaultListModel childrenListModel = new DefaultListModel();
    ChildrenList childrenList = new ChildrenList( childrenListModel );//for childList(global)
    DefaultListModel connectionsModel = new DefaultListModel();
    ConnectionsList cnList = new ConnectionsList ( connectionsModel );
    DynamicTree dt = new DynamicTree( rootNode, treeModel );
    EditElement edit = new EditElement( dt, (ChildrenList)childrenList, (ConnectionsList)cnList, grid );
}


