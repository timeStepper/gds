/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author owenpaulmeyer
 */

    

public class AddableList extends JList
                      implements ListSelectionListener {
    
    //private JList list;
    private DefaultListModel listModel;
    private EditElement editElem;
    private Element addable = null;
    
    public AddableList( DefaultListModel lm, EditElement ee ) {
        super( lm );
        
        listModel = lm;
        listModel.addElement( new Element() );
 
        editElem = ee;
        //Create the list and put it in a scroll pane.
        //list = new JList(listModel);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //setSelectedIndex(0);
        addListSelectionListener(this);
        //setVisibleRowCount(5);
        //JScrollPane listScrollPane = new JScrollPane(list);
    }
 
    public void setAddable( Element e ){
        addable = e;
    }
 
    class RemoveSelection implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int index = getSelectedIndex();
            listModel.remove(index);
        }
    }
 
    //This listener is shared by the text field and the hire button.
    class AddChild implements ActionListener {// {
        private boolean alreadyEnabled = false;
//        private JButton button;
// 
//        public AddChild(JButton button) {
//            this.button = button;
//        }
 
        //Required by ActionListener.
        @Override
        public void actionPerformed(ActionEvent e) {
            
 
            //User didn't type in a unique name...
            if (alreadyInList(addable)) {
                return;
            }
 
            int index = getSelectedIndex(); //get selected index
            if (index == -1) { //no selection, so insert at beginning
                index = 0;
            } else {           //add after the selected item
                index++;
            }
 
            listModel.insertElementAt(addable, index);
            //If we just wanted to add to the end, we'd do this:
            //listModel.addElement(employeeName.getText());
 
            
 
            //Select the new item and make it visible.
            setSelectedIndex(index);
            ensureIndexIsVisible(index);
        }
 
        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(Element e) {
            return listModel.contains(e);
        }
    }
 
    //This method is required by ListSelectionListener.
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (getSelectedIndex() == -1) {
            //No selection, disable fire button.
                editElem.setAddable(Element.empty());
 
            } else {
            //Selection, enable the fire button.
                int index = getSelectedIndex();
                Element add = (Element)listModel.getElementAt( index );
                editElem.setAddable( add );
            }
        }
    }
}
 