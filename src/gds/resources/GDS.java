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
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        importImage = new javax.swing.JFileChooser();
        saveElement = new javax.swing.JFileChooser();
        loadElement = new javax.swing.JFileChooser();
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
        readX = new javax.swing.JTextField();
        labelX = new javax.swing.JLabel();
        readY = new javax.swing.JTextField();
        labelY = new javax.swing.JLabel();
        vizMode = new javax.swing.JToggleButton();
        verticalSplit = new javax.swing.JSplitPane();
        centerPanels = new javax.swing.JSplitPane();
        centerRightPanels = new javax.swing.JSplitPane();
        displayArea = globalDisplayArea;
        elementTabs = new javax.swing.JTabbedPane();
        editControls = new javax.swing.JPanel();
        rotateRightButton = new javax.swing.JButton();
        rotateLeftButton = new javax.swing.JButton();
        reflectXButton = new javax.swing.JButton();
        reflectYButton = new javax.swing.JButton();
        scaleElementButton = new javax.swing.JButton();
        scaleField = new javax.swing.JTextField();
        xLeftButton = new javax.swing.JButton();
        xRightButton = new javax.swing.JButton();
        yUpButton = new javax.swing.JButton();
        yDownButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        viewLocalButton = new javax.swing.JButton();
        renameAddable = new javax.swing.JTextField();
        resetRootButton = new javax.swing.JButton();
        makeElementButton = new javax.swing.JButton();
        renameAddableButton = new javax.swing.JButton();
        viewGlobalButton = new javax.swing.JButton();
        setSeedButton = new javax.swing.JButton();
        setSourceButton = new javax.swing.JButton();
        generationButton = new javax.swing.JButton();
        setThresholdButton = new javax.swing.JButton();
        thresholdField = new javax.swing.JTextField();
        differenceButton = new javax.swing.JButton();
        diffThresholdButton = new javax.swing.JButton();
        diffThreshField = new javax.swing.JTextField();
        childScroll = new javax.swing.JScrollPane();
        childList = childrenList;
        connectionScroll = new javax.swing.JScrollPane();
        connectionList = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        displayChButton = new javax.swing.JButton();
        displayCNButton = new javax.swing.JButton();
        displayLocateButton = new javax.swing.JButton();
        displayBoundsButton = new javax.swing.JButton();
        toJsonButton = new javax.swing.JButton();
        displayFlattenedEdges = new javax.swing.JButton();
        displayFlattenedChildren = new javax.swing.JButton();
        boundTestButton = new javax.swing.JButton();
        intersectionTestButton = new javax.swing.JButton();
        viztoolzPanel = new javax.swing.JPanel();
        viewButtons = new javax.swing.JToolBar();
        viewSeedButton = new javax.swing.JToggleButton();
        viewIntersectButton = new javax.swing.JToggleButton();
        viewApplicatesButton = new javax.swing.JToggleButton();
        viewSourceButton = new javax.swing.JToggleButton();
        jToolBar2 = new javax.swing.JToolBar();
        seedLeftButton = new javax.swing.JButton();
        seedRightButton = new javax.swing.JButton();
        seedUpButton = new javax.swing.JButton();
        seedDownButton = new javax.swing.JButton();
        vizSetSeedButton = new javax.swing.JButton();
        vizBufferButton = new javax.swing.JButton();
        vizSetSourceButton = new javax.swing.JButton();
        decideBufferButton = new javax.swing.JButton();
        thresholdAdjust = new javax.swing.JSlider();
        generateButton = new javax.swing.JButton();
        viewBufferButton = new javax.swing.JToggleButton();
        adjustAdjustButton = new javax.swing.JButton();
        adjustAdjust = new javax.swing.JTextField();
        viewIntersectBufferButton = new javax.swing.JToggleButton();
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
        saveOutElementMenu = new javax.swing.JMenuItem();
        loadElementMenu = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        addEmpty = new javax.swing.JMenuItem();
        removeElement = new javax.swing.JMenuItem();
        makeConnectionMenuItem = new javax.swing.JMenuItem();
        imageMenu = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Close = new javax.swing.JMenuItem();
        scaleImage = new javax.swing.JMenuItem();
        translateImage = new javax.swing.JMenuItem();

        importImage.setDialogTitle("Select Image");

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

        labelX.setText("X");

        labelY.setText("Y");

        vizMode.setText("Viz Mode");
        vizMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vizModeActionPerformed(evt);
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
                .addComponent(vizMode, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editMode, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(genMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hereXr, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addComponent(readX, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelX)))
                .addGap(41, 41, 41)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bottomBarLayout.createSequentialGroup()
                        .addComponent(readY, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelY))
                    .addComponent(hereYr, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editMode)
                    .addComponent(readX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelX)
                    .addComponent(readY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelY))
                .addGap(11, 11, 11)
                .addGroup(bottomBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hereXr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hereYr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vizMode))
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
            .addGap(0, 492, Short.MAX_VALUE)
        );
        displayAreaLayout.setVerticalGroup(
            displayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        centerRightPanels.setLeftComponent(displayArea);

        elementTabs.setBackground(new java.awt.Color(180, 180, 180));
        elementTabs.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        xLeftButton.setText("Left");
        xLeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xLeftButtonActionPerformed(evt);
            }
        });

        xRightButton.setText("Right");
        xRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xRightButtonActionPerformed(evt);
            }
        });

        yUpButton.setText("Up");
        yUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yUpButtonActionPerformed(evt);
            }
        });

        yDownButton.setText("Down");
        yDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yDownButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Translate Element");

        viewLocalButton.setText(" View Local");
        viewLocalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLocalButtonActionPerformed(evt);
            }
        });

        renameAddable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameAddableActionPerformed(evt);
            }
        });

        resetRootButton.setText("Reset Elem");
        resetRootButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetRootButtonActionPerformed(evt);
            }
        });

        makeElementButton.setText(" Make Elem");
        makeElementButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeElementButtonActionPerformed(evt);
            }
        });

        renameAddableButton.setText("Rename Elem");
        renameAddableButton.setMaximumSize(new java.awt.Dimension(101, 23));
        renameAddableButton.setMinimumSize(new java.awt.Dimension(101, 23));
        renameAddableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameAddableButtonActionPerformed(evt);
            }
        });

        viewGlobalButton.setText("View Global");
        viewGlobalButton.setMaximumSize(new java.awt.Dimension(101, 23));
        viewGlobalButton.setMinimumSize(new java.awt.Dimension(101, 23));
        viewGlobalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewGlobalButtonActionPerformed(evt);
            }
        });

        setSeedButton.setText("Set Seed");
        setSeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setSeedButtonActionPerformed(evt);
            }
        });

        setSourceButton.setText("Set Source");
        setSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setSourceButtonActionPerformed(evt);
            }
        });

        generationButton.setText("Generation");
        generationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generationButtonActionPerformed(evt);
            }
        });

        setThresholdButton.setText("threshold");
        setThresholdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setThresholdButtonActionPerformed(evt);
            }
        });

        differenceButton.setText("Difference");
        differenceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                differenceButtonActionPerformed(evt);
            }
        });

        diffThresholdButton.setText("diffThrsh");
        diffThresholdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diffThresholdButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editControlsLayout = new javax.swing.GroupLayout(editControls);
        editControls.setLayout(editControlsLayout);
        editControlsLayout.setHorizontalGroup(
            editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editControlsLayout.createSequentialGroup()
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editControlsLayout.createSequentialGroup()
                        .addComponent(rotateRightButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rotateLeftButton))
                    .addGroup(editControlsLayout.createSequentialGroup()
                        .addComponent(reflectXButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reflectYButton))
                    .addGroup(editControlsLayout.createSequentialGroup()
                        .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(xLeftButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yUpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(xRightButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(yDownButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(editControlsLayout.createSequentialGroup()
                        .addComponent(scaleElementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scaleField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editControlsLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2))
                    .addGroup(editControlsLayout.createSequentialGroup()
                        .addComponent(renameAddableButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(renameAddable, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editControlsLayout.createSequentialGroup()
                        .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewGlobalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(setSeedButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(setSourceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(viewLocalButton))
                    .addGroup(editControlsLayout.createSequentialGroup()
                        .addComponent(makeElementButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(resetRootButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editControlsLayout.createSequentialGroup()
                        .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editControlsLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(generationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(differenceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editControlsLayout.createSequentialGroup()
                                .addComponent(setThresholdButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thresholdField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editControlsLayout.createSequentialGroup()
                                .addComponent(diffThresholdButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(diffThreshField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        editControlsLayout.setVerticalGroup(
            editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editControlsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetRootButton)
                    .addComponent(makeElementButton))
                .addGap(18, 18, 18)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(renameAddable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(renameAddableButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewLocalButton)
                    .addComponent(viewGlobalButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(generationButton)
                    .addComponent(setThresholdButton)
                    .addComponent(thresholdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(differenceButton)
                    .addComponent(diffThresholdButton)
                    .addComponent(diffThreshField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(setSeedButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setSourceButton)
                .addGap(18, 18, 18)
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
                    .addComponent(xLeftButton)
                    .addComponent(xRightButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(editControlsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yUpButton)
                    .addComponent(yDownButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        displayChButton.setText("displayCH");
        displayChButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayChButtonActionPerformed(evt);
            }
        });

        displayCNButton.setText("display CN");
        displayCNButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayCNButtonActionPerformed(evt);
            }
        });

        displayLocateButton.setText("displaylocate");
        displayLocateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayLocateButtonActionPerformed(evt);
            }
        });

        displayBoundsButton.setText("displaybounds");
        displayBoundsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBoundsButtonActionPerformed(evt);
            }
        });

        toJsonButton.setText("printJson");
        toJsonButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toJsonButtonActionPerformed(evt);
            }
        });

        displayFlattenedEdges.setText("flattended edges");
        displayFlattenedEdges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayFlattenedEdgesActionPerformed(evt);
            }
        });

        displayFlattenedChildren.setText(" flattened childs");
        displayFlattenedChildren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayFlattenedChildrenActionPerformed(evt);
            }
        });

        boundTestButton.setText("boundTest");
        boundTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boundTestButtonActionPerformed(evt);
            }
        });

        intersectionTestButton.setText("intersectionTest");
        intersectionTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intersectionTestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(displayChButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayCNButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(displayLocateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayBoundsButton))
                    .addComponent(toJsonButton)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(displayFlattenedEdges)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayFlattenedChildren)))
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(intersectionTestButton)
                    .addComponent(boundTestButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayChButton)
                    .addComponent(displayCNButton))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayLocateButton)
                    .addComponent(displayBoundsButton))
                .addGap(60, 60, 60)
                .addComponent(toJsonButton)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayFlattenedEdges)
                    .addComponent(displayFlattenedChildren))
                .addGap(48, 48, 48)
                .addComponent(boundTestButton)
                .addGap(18, 18, 18)
                .addComponent(intersectionTestButton)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        elementTabs.addTab("test", jPanel1);

        viewButtons.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        viewButtons.setOrientation(javax.swing.SwingConstants.VERTICAL);
        viewButtons.setRollover(true);

        viewSeedButton.setText("Seed / Design");
        viewSeedButton.setFocusable(false);
        viewSeedButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewSeedButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewSeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSeedButtonActionPerformed(evt);
            }
        });
        viewButtons.add(viewSeedButton);

        viewIntersectButton.setText("Intersect");
        viewIntersectButton.setFocusable(false);
        viewIntersectButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewIntersectButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewIntersectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewIntersectButtonActionPerformed(evt);
            }
        });
        viewButtons.add(viewIntersectButton);

        viewApplicatesButton.setText("Applicates");
        viewApplicatesButton.setFocusable(false);
        viewApplicatesButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewApplicatesButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewApplicatesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewApplicatesButtonActionPerformed(evt);
            }
        });
        viewButtons.add(viewApplicatesButton);

        viewSourceButton.setText("Source");
        viewSourceButton.setFocusable(false);
        viewSourceButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewSourceButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSourceButtonActionPerformed(evt);
            }
        });
        viewButtons.add(viewSourceButton);

        jToolBar2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jToolBar2.setRollover(true);

        seedLeftButton.setText("Left");
        seedLeftButton.setMnemonic(KeyEvent.VK_LEFT);
        seedLeftButton.setFocusable(false);
        seedLeftButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seedLeftButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        seedLeftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedLeftButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(seedLeftButton);

        seedRightButton.setText("Right");
        seedRightButton.setMnemonic(KeyEvent.VK_RIGHT);
        seedRightButton.setFocusable(false);
        seedRightButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seedRightButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        seedRightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedRightButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(seedRightButton);

        seedUpButton.setText("Up");
        seedUpButton.setMnemonic(KeyEvent.VK_UP);
        seedUpButton.setFocusable(false);
        seedUpButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seedUpButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        seedUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedUpButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(seedUpButton);

        seedDownButton.setText("Down");
        seedDownButton.setMnemonic(KeyEvent.VK_DOWN);
        seedDownButton.setFocusable(false);
        seedDownButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        seedDownButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        seedDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seedDownButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(seedDownButton);

        vizSetSeedButton.setText("Set Seed");
        vizSetSeedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vizSetSeedButtonActionPerformed(evt);
            }
        });

        vizBufferButton.setText("Buffer");
        vizBufferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vizBufferButtonActionPerformed(evt);
            }
        });

        vizSetSourceButton.setText("Set Source");
        vizSetSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vizSetSourceButtonActionPerformed(evt);
            }
        });

        decideBufferButton.setText("Decide");
        decideBufferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decideBufferButtonActionPerformed(evt);
            }
        });

        thresholdAdjust.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                thresholdAdjustStateChanged(evt);
            }
        });

        generateButton.setText("Generate");
        generateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateButtonActionPerformed(evt);
            }
        });

        viewBufferButton.setText("View Buffer");
        viewBufferButton.setFocusable(false);
        viewBufferButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewBufferButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewBufferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBufferButtonActionPerformed(evt);
            }
        });

        adjustAdjustButton.setText("Adjust");
        adjustAdjustButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adjustAdjustButtonActionPerformed(evt);
            }
        });

        adjustAdjust.setText(".01");

        viewIntersectBufferButton.setText("IntersectBuffer");
        viewIntersectBufferButton.setFocusable(false);
        viewIntersectBufferButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        viewIntersectBufferButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewIntersectBufferButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewIntersectBufferButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viztoolzPanelLayout = new javax.swing.GroupLayout(viztoolzPanel);
        viztoolzPanel.setLayout(viztoolzPanelLayout);
        viztoolzPanelLayout.setHorizontalGroup(
            viztoolzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viztoolzPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viztoolzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thresholdAdjust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(viztoolzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(viztoolzPanelLayout.createSequentialGroup()
                            .addComponent(vizBufferButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                            .addComponent(generateButton))
                        .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(decideBufferButton)
                    .addGroup(viztoolzPanelLayout.createSequentialGroup()
                        .addComponent(viewBufferButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viewIntersectBufferButton))
                    .addGroup(viztoolzPanelLayout.createSequentialGroup()
                        .addComponent(viewButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(viztoolzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vizSetSeedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(vizSetSourceButton)))
                    .addGroup(viztoolzPanelLayout.createSequentialGroup()
                        .addComponent(adjustAdjustButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adjustAdjust, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        viztoolzPanelLayout.setVerticalGroup(
            viztoolzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viztoolzPanelLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(viztoolzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viztoolzPanelLayout.createSequentialGroup()
                        .addComponent(vizSetSeedButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vizSetSourceButton))
                    .addComponent(viewButtons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viztoolzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(viewBufferButton)
                    .addComponent(viewIntersectBufferButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(viztoolzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vizBufferButton)
                    .addComponent(generateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(decideBufferButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thresholdAdjust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(viztoolzPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adjustAdjustButton)
                    .addComponent(adjustAdjust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(198, Short.MAX_VALUE))
        );

        elementTabs.addTab("Viz", viztoolzPanel);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dynamicTreeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addableElementListLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(443, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(443, Short.MAX_VALUE))
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
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        saveOutElementMenu.setText("Save Element");
        saveOutElementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOutElementMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveOutElementMenu);

        loadElementMenu.setText("Load Element");
        loadElementMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadElementMenuActionPerformed(evt);
            }
        });
        jMenu1.add(loadElementMenu);

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
                .addComponent(verticalSplit, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottomBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        int returnVal = importImage.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = importImage.getSelectedFile();
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
        globalDisplayArea.repaint();
    }//GEN-LAST:event_gridSizeStateChanged

    private void editModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editModeActionPerformed
        if ( genMode.isSelected( ) ) genMode.setSelected( false );
        else if ( vizMode.isSelected() ) vizMode.setSelected( false);
        mode.setEdit();
        globalDisplayArea.repaint();
    }//GEN-LAST:event_editModeActionPerformed

    private void genModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genModeActionPerformed
        if ( editMode.isSelected( ) ) editMode.setSelected( false );
        else if ( vizMode.isSelected() ) vizMode.setSelected( false);
        mode.setGen();
        globalDisplayArea.repaint();
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

    private void makeConnectionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeConnectionMenuItemActionPerformed
        edit.makeConnection();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_makeConnectionMenuItemActionPerformed

    private void editMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editMenuActionPerformed

    private void gridToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gridToggleButtonActionPerformed
        grid.toggleGrid();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_gridToggleButtonActionPerformed

    private void toJsonButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toJsonButtonActionPerformed
        System.out.println("Json: ");
        System.out.println(edit.toJson());
    }//GEN-LAST:event_toJsonButtonActionPerformed

    private void saveOutElementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOutElementMenuActionPerformed
        int saveVal = saveElement.showSaveDialog(this);
        if (saveVal == JFileChooser.APPROVE_OPTION) {
            FileWriter fileWriter = null;
            try{
                File fileToSave = saveElement.getSelectedFile();
                fileWriter = new FileWriter(fileToSave);
                fileWriter.write(edit.toJson());
                fileWriter.close();
            }catch(IOException ioe){ioe.printStackTrace();}
            finally {
            try {
                fileWriter.close();
                } catch (IOException ex) {ex.printStackTrace();}
            }
        } else {
            System.out.println("File save cancelled by user.");
        }
    }//GEN-LAST:event_saveOutElementMenuActionPerformed

    private void loadElementMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadElementMenuActionPerformed
        int loadVal = loadElement.showOpenDialog(this);
        if (loadVal == JFileChooser.APPROVE_OPTION) {
            BufferedReader read = null;
            try{ 
		read = new BufferedReader(new FileReader(loadElement.getSelectedFile()));
                try {
                    edit.fromJson(read.readLine());
                } catch (IOException ex) {
                    Logger.getLogger(GDS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }catch(FileNotFoundException fnf){System.out.println(fnf+": fileLoad trouble");}
            finally {
            try {
                read.close();
                } catch (IOException ex) {}
            }
        } else {
            System.out.println("File load cancelled by user.");
        }
    }//GEN-LAST:event_loadElementMenuActionPerformed

    private void displayBoundsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBoundsButtonActionPerformed
        Child located = Child.locate(edit.selected, new Location(0,0));
        System.out.println(Source.bounds(located));
    }//GEN-LAST:event_displayBoundsButtonActionPerformed

    private void displayLocateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayLocateButtonActionPerformed
        Child located = Child.locate(edit.selected, new Location(2,2));//edit.selected.location());
        located.displayChildren();
    }//GEN-LAST:event_displayLocateButtonActionPerformed

    private void displayChButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayChButtonActionPerformed
        edit.selected.displayChildren();
        //        System.out.println("empties:");
        //        System.out.println(Child.flattenChildren(edit.selected));
    }//GEN-LAST:event_displayChButtonActionPerformed

    private void viewGlobalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewGlobalButtonActionPerformed
        edit.paintGlobal();
        globalDisplayArea.repaint();
    }//GEN-LAST:event_viewGlobalButtonActionPerformed

    private void renameAddableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameAddableButtonActionPerformed
        edit.renameAddable( renameAddable.getText() );
        addableElementList.updateUI();
    }//GEN-LAST:event_renameAddableButtonActionPerformed

    private void makeElementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeElementButtonActionPerformed
        edit.makeElement();
        edit.renameAddable( renameAddable.getText() );
        addableElementList.updateUI();
    }//GEN-LAST:event_makeElementButtonActionPerformed

    private void resetRootButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetRootButtonActionPerformed
        edit.resetRoot();
    }//GEN-LAST:event_resetRootButtonActionPerformed

    private void renameAddableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameAddableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_renameAddableActionPerformed

    private void viewLocalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLocalButtonActionPerformed
        edit.paintLocal();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_viewLocalButtonActionPerformed

    private void displayCNButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayCNButtonActionPerformed
        edit.selected.displayConnections();
        //        System.out.println("edges:");
        //        System.out.println(Child.flattenConnections(edit.selected));
    }//GEN-LAST:event_displayCNButtonActionPerformed

    private void yDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yDownButtonActionPerformed
        edit.translate(0,1);
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_yDownButtonActionPerformed

    private void yUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yUpButtonActionPerformed
        edit.translate(0,-1);
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_yUpButtonActionPerformed

    private void xRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xRightButtonActionPerformed
        edit.translate(1, 0);
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_xRightButtonActionPerformed

    private void xLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xLeftButtonActionPerformed
        edit.translate(-1, 0);
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_xLeftButtonActionPerformed

    private void scaleElementButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleElementButtonActionPerformed
        edit.scale(Integer.parseInt(scaleField.getText()));
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_scaleElementButtonActionPerformed

    private void reflectYButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reflectYButtonActionPerformed
        edit.reflectY();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_reflectYButtonActionPerformed

    private void reflectXButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reflectXButtonActionPerformed
        edit.reflectX();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_reflectXButtonActionPerformed

    private void rotateLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotateLeftButtonActionPerformed
        edit.rotateLeft();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_rotateLeftButtonActionPerformed

    private void rotateRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rotateRightButtonActionPerformed
        edit.rotateRight();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_rotateRightButtonActionPerformed

    private void setSeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setSeedButtonActionPerformed
        Child c = edit.selected;
        genit.setSeed(c);
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_setSeedButtonActionPerformed

    private void displayFlattenedEdgesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayFlattenedEdgesActionPerformed
        System.out.println("Flattened Edges:");
        System.out.println(Child.flattenEdges(edit.selected));
        System.out.println("size: "+Child.flattenEdges(edit.selected).size());
    }//GEN-LAST:event_displayFlattenedEdgesActionPerformed

    private void displayFlattenedChildrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayFlattenedChildrenActionPerformed
        System.out.println("Flattened Childs:");
        System.out.println(Child.flattenChildren(edit.selected));
    }//GEN-LAST:event_displayFlattenedChildrenActionPerformed

    private void boundTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boundTestButtonActionPerformed
        Bounds bs = new Bounds(0,3,0,3);
        genit.boundTest(bs);
        //globalDisplayArea.repaint();
    }//GEN-LAST:event_boundTestButtonActionPerformed

    private void intersectionTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intersectionTestButtonActionPerformed
        Location l = new Location( 0, 0 );
        genit.intersectionTest(l);
    }//GEN-LAST:event_intersectionTestButtonActionPerformed

    private void setSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setSourceButtonActionPerformed
        genit.setSource(edit.selected);
        System.out.println("source set!");
    }//GEN-LAST:event_setSourceButtonActionPerformed

    private void generationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generationButtonActionPerformed
//        System.out.println("bounds: " + genit.design.bounds);
        genit.generation();
        ((MyPanel)displayArea).repaint();
//        System.out.println("bounds: " + genit.design.bounds);
    }//GEN-LAST:event_generationButtonActionPerformed

    private void setThresholdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setThresholdButtonActionPerformed
        genit.setThreshold(Double.parseDouble(thresholdField.getText()));
    }//GEN-LAST:event_setThresholdButtonActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void differenceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_differenceButtonActionPerformed
//        genit.differentiate();
//        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_differenceButtonActionPerformed

    private void diffThresholdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diffThresholdButtonActionPerformed
        genit.setDiffThreshold(Double.parseDouble(diffThreshField.getText()));
    }//GEN-LAST:event_diffThresholdButtonActionPerformed

    private void vizBufferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vizBufferButtonActionPerformed
        viz.buffer();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_vizBufferButtonActionPerformed

    private void viewBufferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBufferButtonActionPerformed
        if ( viewIntersectBufferButton.isSelected( ) ) {
            viz.togglePaintIntersectBuffer();
            viewIntersectBufferButton.setSelected( false );
        }
        viz.togglePaintBuffer();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_viewBufferButtonActionPerformed

    private void viewSeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSeedButtonActionPerformed
        viz.togglePaintSeed();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_viewSeedButtonActionPerformed

    private void viewIntersectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewIntersectButtonActionPerformed
        viz.togglePaintIntersect();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_viewIntersectButtonActionPerformed

    private void viewApplicatesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewApplicatesButtonActionPerformed
        viz.togglePaintApplicates();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_viewApplicatesButtonActionPerformed

    private void seedUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seedUpButtonActionPerformed
        viz.up();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_seedUpButtonActionPerformed

    private void seedDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seedDownButtonActionPerformed
        viz.down();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_seedDownButtonActionPerformed

    private void seedLeftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seedLeftButtonActionPerformed
        viz.left();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_seedLeftButtonActionPerformed

    private void seedRightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seedRightButtonActionPerformed
        viz.right();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_seedRightButtonActionPerformed

    private void vizSetSeedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vizSetSeedButtonActionPerformed
        viz.setSeed(edit.selected);
        globalDisplayArea.repaint();
    }//GEN-LAST:event_vizSetSeedButtonActionPerformed

    private void vizSetSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vizSetSourceButtonActionPerformed
        viz.setSource(edit.selected);
        globalDisplayArea.repaint();
    }//GEN-LAST:event_vizSetSourceButtonActionPerformed

    private void vizModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vizModeActionPerformed
        if ( genMode.isSelected( ) ) genMode.setSelected( false );
        else if ( editMode.isSelected() ) editMode.setSelected( false);
        mode.setViz();
        globalDisplayArea.repaint();
    }//GEN-LAST:event_vizModeActionPerformed

    private void viewSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSourceButtonActionPerformed
        viz.togglePaintSource();
        ((MyPanel)displayArea).repaint();
    }//GEN-LAST:event_viewSourceButtonActionPerformed

    private void decideBufferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decideBufferButtonActionPerformed
        viz.decide();
        globalDisplayArea.repaint();
    }//GEN-LAST:event_decideBufferButtonActionPerformed

    private void thresholdAdjustStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_thresholdAdjustStateChanged
        viz.setAdjust(thresholdAdjust.getValue());
        globalDisplayArea.repaint();
    }//GEN-LAST:event_thresholdAdjustStateChanged

    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateButtonActionPerformed
        viz.generation();
        globalDisplayArea.repaint();
    }//GEN-LAST:event_generateButtonActionPerformed

    private void adjustAdjustButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adjustAdjustButtonActionPerformed
        viz.setAdjustAdjust(Double.parseDouble(adjustAdjust.getText()));
        globalDisplayArea.repaint();
    }//GEN-LAST:event_adjustAdjustButtonActionPerformed

    private void viewIntersectBufferButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewIntersectBufferButtonActionPerformed
        if ( viewBufferButton.isSelected( ) ) {
            viz.togglePaintBuffer();
            viewBufferButton.setSelected( false );
        }
        viz.togglePaintIntersectBuffer();
        globalDisplayArea.repaint();
    }//GEN-LAST:event_viewIntersectBufferButtonActionPerformed

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
    
    public class MyPanel extends JPanel{
        public MyPanel ( ) {
            
            addMouseMotionListener ( mode );
            addMouseListener ( mode );
            addMouseWheelListener ( mode );
            
        }
        
        @Override
        protected void paintComponent(Graphics g1) {
            Graphics2D g = (Graphics2D)g1;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            //g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
            super.paintComponent(g);
            backgroundImage.paintImage( g );
//            grid.paintGrid( g, getWidth( ), getHeight( ) );
//            edit.paintAddable(g);
//            edit.paintEdit( g );
//            edit.paintHighlighted(g);
            mode.paint(g);
            childrenList.paintSelections(g);
            
        }
    }

    class Mode extends MouseInputAdapter implements MouseWheelListener{ //implements MouseMotionListener, MouseListener {
        
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
        public void setViz(){
            mode = State.Viz;
        }
        @Override
        public void mouseWheelMoved(MouseWheelEvent e){
            int m = e.getWheelRotation()*(-1);
            int n = grid.mouseWheel(m);
            edit.setModule( n );
            globalDisplayArea.repaint();
            gridSize.setValue(n);
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
            grid.setOriginX(x);
            grid.setOriginY(y);
            edit.setX(x);
            edit.setY(y);
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
//            setCursor(Cursor.DEFAULT_CURSOR);
        }
        @Override
        public void mousePressed(MouseEvent e) {
            
        }
        @Override
        public void mouseReleased(MouseEvent e) {
        }
        public void paint(Graphics2D g){
            if (mode==State.Edit) {
                grid.paintGrid( g, globalDisplayArea.getWidth( ), globalDisplayArea.getHeight( ) );
                edit.paintAddable(g);
                edit.paintEdit( g );
                edit.paintHighlighted(g);
            }
            else if (mode==State.Gen){
                genit.paint(g);
            }
            else if (mode==State.Viz){
                viz.paintViz(g);
            }
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
    private javax.swing.JTextField adjustAdjust;
    private javax.swing.JButton adjustAdjustButton;
    private javax.swing.JPanel bottomBar;
    private javax.swing.JButton boundTestButton;
    private javax.swing.JSplitPane centerPanels;
    private javax.swing.JSplitPane centerRightPanels;
    private javax.swing.JList childList;
    private javax.swing.JScrollPane childScroll;
    private javax.swing.JList connectionList;
    private javax.swing.JScrollPane connectionScroll;
    private javax.swing.JButton decideBufferButton;
    private javax.swing.JTextField diffThreshField;
    private javax.swing.JButton diffThresholdButton;
    private javax.swing.JButton differenceButton;
    private javax.swing.JPanel displayArea;
    private javax.swing.JButton displayBoundsButton;
    private javax.swing.JButton displayCNButton;
    private javax.swing.JButton displayChButton;
    private javax.swing.JButton displayFlattenedChildren;
    private javax.swing.JButton displayFlattenedEdges;
    private javax.swing.JButton displayLocateButton;
    private javax.swing.JTree dynamicTree;
    private javax.swing.JLabel dynamicTreeLabel;
    private javax.swing.JPanel editControls;
    private javax.swing.JMenu editMenu;
    private javax.swing.JToggleButton editMode;
    private javax.swing.JTabbedPane elementTabs;
    private javax.swing.JToggleButton genMode;
    private javax.swing.JButton generateButton;
    private javax.swing.JButton generationButton;
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
    private javax.swing.JFileChooser importImage;
    private javax.swing.JButton intersectionTestButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JPanel leftFlank;
    private javax.swing.JFileChooser loadElement;
    private javax.swing.JMenuItem loadElementMenu;
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
    private javax.swing.JFileChooser saveElement;
    private javax.swing.JMenuItem saveOutElementMenu;
    private javax.swing.JButton scaleElementButton;
    private javax.swing.JTextField scaleField;
    private javax.swing.JMenuItem scaleImage;
    private javax.swing.JButton seedDownButton;
    private javax.swing.JButton seedLeftButton;
    private javax.swing.JButton seedRightButton;
    private javax.swing.JButton seedUpButton;
    private javax.swing.JButton setSeedButton;
    private javax.swing.JButton setSourceButton;
    private javax.swing.JButton setThresholdButton;
    private javax.swing.JSlider thresholdAdjust;
    private javax.swing.JTextField thresholdField;
    private javax.swing.JButton toJsonButton;
    private javax.swing.JPanel topBar;
    private javax.swing.JMenuItem translateImage;
    private javax.swing.JSplitPane verticalSplit;
    private javax.swing.JToggleButton viewApplicatesButton;
    private javax.swing.JToggleButton viewBufferButton;
    private javax.swing.JToolBar viewButtons;
    private javax.swing.JButton viewGlobalButton;
    private javax.swing.JToggleButton viewIntersectBufferButton;
    private javax.swing.JToggleButton viewIntersectButton;
    private javax.swing.JButton viewLocalButton;
    private javax.swing.JToggleButton viewSeedButton;
    private javax.swing.JToggleButton viewSourceButton;
    private javax.swing.JButton vizBufferButton;
    private javax.swing.JToggleButton vizMode;
    private javax.swing.JButton vizSetSeedButton;
    private javax.swing.JButton vizSetSourceButton;
    private javax.swing.JPanel viztoolzPanel;
    private javax.swing.JButton xLeftButton;
    private javax.swing.JButton xRightButton;
    private javax.swing.JButton yDownButton;
    private javax.swing.JButton yUpButton;
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
    Generate genit = new Generate(32,32, grid);
    VisToolz viz = new VisToolz(grid);
    
}


