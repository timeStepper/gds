/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import gds.resources.GDS.MyPanel;
import java.util.ArrayList;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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
                if ( getSelectionCount() == 0 )
                    setSelectionPath( new TreePath(rootNode.getPath()));
                DefaultMutableTreeNode selected = (DefaultMutableTreeNode)
                        getSelectionPath().getLastPathComponent();
                Child c = (Child)selected.getUserObject();
                edit.changeSelected( c );
                displayArea.repaint();
            }
        });
    }
    public void selectRoot(){
        setSelectionPath( new TreePath(rootNode.getPath()));
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
    public void removeChild( Child c ) {
        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)
                        getSelectionPath().getLastPathComponent();
            DefaultMutableTreeNode childNode = (DefaultMutableTreeNode)currentNode.getFirstChild();
            
            DefaultMutableTreeNode lastChild = (DefaultMutableTreeNode)currentNode.getLastChild();
            
            do {
                Child node = (Child)childNode.getUserObject();
                if( node.equals(c)){
                    //childNode.removeAllChildren();
                    treeModel.removeNodeFromParent(childNode);
                    return;
                }
                else childNode = childNode.getNextSibling();
                
//            System.out.println( "childNode "+childNode);
//            System.out.println( "lastNode "+lastChild);
//            System.out.println();
            if (childNode==null)return;
        } while ( !childNode.equals(lastChild));
        Child last = (Child)childNode.getUserObject();
        if ( last.equals(c)){
            //lastChild.removeAllChildren();
            treeModel.removeNodeFromParent(lastChild);
        }   
    }

    /** Add child to the currently selected node.
     * @param child */
    public DefaultMutableTreeNode addChild(Child child) {
        DefaultMutableTreeNode parentNode = null;
            TreePath parentPath = getSelectionPath();
            if (parentPath == null) {
                parentNode = rootNode;
            } else {
                parentNode = (DefaultMutableTreeNode)
                             (parentPath.getLastPathComponent());
            }
            return addChild(child, parentNode);//parentNode is selected or root
    }
    public DefaultMutableTreeNode addChild(Child child, DefaultMutableTreeNode parentNode ){
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
            if ( child.isEmpty())return addChild(childNode, parentNode, true );
            else {
                for ( Child c : child.childElement().children() ) {
                    childNode = addChild( c, childNode);
                }
                addChild(childNode,parentNode,true);
            }
            return parentNode;
    }
    //parent <- selected or root, child <- child object
    public DefaultMutableTreeNode addChild( DefaultMutableTreeNode childNode,
        DefaultMutableTreeNode parentNode, boolean shouldBeVisible ){
        
            //DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);
            if (parentNode == null) {
                parentNode = rootNode;
            }
            //It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
            treeModel.insertNodeInto(childNode, parentNode, parentNode.getChildCount() );
            //Make sure the user can see the lovely new node.
            if (shouldBeVisible) {
                scrollPathToVisible(new TreePath(childNode.getPath()));
            }
            return parentNode;
    }
    public void setRoot(Child c){
        clear();
        DefaultMutableTreeNode dmt = new DefaultMutableTreeNode(c);
        treeModel.setRoot(dmt);
        rootNode = dmt;
        setSelectionPath( new TreePath(rootNode.getPath()));
        for( Child ch : c.childElement().children() )
            addChild(ch);
        setSelectionPath( new TreePath(rootNode.getPath()));
    }
}
