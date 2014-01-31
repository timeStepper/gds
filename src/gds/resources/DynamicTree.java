/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import gds.resources.GDS.MyPanel;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author owenpaulmeyer
 */
public class DynamicTree extends JTree{
    DefaultMutableTreeNode rootNode;
    DefaultTreeModel treeModel;
    EditElement edit;
    MyPanel displayArea;
    
    DynamicTree( DefaultMutableTreeNode dmt, DefaultTreeModel tm ) {
        super( tm );
        rootNode = dmt;
        treeModel = tm;
        getSelectionModel().setSelectionMode
            (TreeSelectionModel.SINGLE_TREE_SELECTION);
        setSelectionPath( new TreePath(rootNode.getPath()));
        //addTreeModelListener(new MyTreeModelListener());
        addTreeSelectionListener( new TreeSelectionListener(){
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selected = (DefaultMutableTreeNode)
                        getSelectionPath().getLastPathComponent();
                Child c = (Child)selected.getUserObject();
                edit.changeSelected( c );
                displayArea.repaint();
            }
        });
    }
    
    public void setDisplayArea( MyPanel dp ){
        displayArea = dp;
    }
    public void setEditElement( EditElement ed ){
        edit = ed;
    }
    
    public Child root() {
        Child c = (Child)rootNode.getUserObject();
        return c;
    }
    
    /** Remove all nodes except the root node. */
    public void clear() {
        rootNode.removeAllChildren();
        treeModel.reload();
    }

    /** Remove the currently selected node. */
    public void removeCurrentNode() {
        TreePath currentSelection = getSelectionPath();
        if (currentSelection != null) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)
                         (currentSelection.getLastPathComponent());
            MutableTreeNode parent = (MutableTreeNode)(currentNode.getParent());
            if (parent != null) {
                treeModel.removeNodeFromParent(currentNode);
                return;
            }
        } 

        // Either there was no selection, or the root was selected.
        //toolkit.beep();
    }

    /** Add child to the currently selected node.
     * @param child */
    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode)
                         (parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                            Object child) {
        return addObject(parent, child, false);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                            Object child, 
                                            boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode = 
                new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }
	
	//It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        treeModel.insertNodeInto(childNode, parent, 
                                 parent.getChildCount());

        //Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }
}
