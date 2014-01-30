/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author owenpaulmeyer
 */
class MyTreeModelListener implements TreeModelListener {
        @Override
        public void treeNodesChanged(TreeModelEvent e) {
//            DefaultMutableTreeNode node;
//            node = (DefaultMutableTreeNode)(e.getTreePath().getLastPathComponent());
//
//            /*
//             * If the event lists children, then the changed
//             * node is the child of the node we've already
//             * gotten.  Otherwise, the changed node and the
//             * specified node are the same.
//             */
//
//                int index = e.getChildIndices()[0];
//                node = (DefaultMutableTreeNode)(node.getChildAt(index));
//
//            System.out.println("The user has finished editing the node.");
//            System.out.println("New value: " + node.getUserObject());
        }
        @Override
        public void treeNodesInserted(TreeModelEvent e) {
        }
        @Override
        public void treeNodesRemoved(TreeModelEvent e) {
        }
        @Override
        public void treeStructureChanged(TreeModelEvent e) {
        }
    }