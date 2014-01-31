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

    

public class AddableList extends JList implements ListSelectionListener {
    private DefaultListModel listModel;
    private EditElement editElem;
    
    public AddableList( DefaultListModel lm, EditElement ee ) {
        super( lm );
        
        listModel = lm;
        listModel.addElement( new Element() );
 
        editElem = ee;
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        addListSelectionListener(this);
        setSelectedIndex(0);
    }
    
    public void removeSelection() {
        int index = getSelectedIndex();
        listModel.remove( index );
    }
    
    public void addElement(Element add) {
        if (alreadyInList(add)) {
            return;
        }
        int index = getSelectedIndex(); //get selected index
        if (index == -1) { //no selection, so insert at beginning
            index = 0;
        } else {           //add after the selected item
            index++;
        }
        listModel.insertElementAt(add, index);
        setSelectedIndex(index);
        ensureIndexIsVisible(index);
    }

    protected boolean alreadyInList(Element e) {
        return listModel.contains(e);
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        int index = getSelectedIndex();
        Element elem = (Element)listModel.getElementAt( index );
        editElem.setAddable( elem );
//        if (e.getValueIsAdjusting() == false) {
// 
//            if (getSelectedIndex() == -1) {
//            //No selection, disable fire button.
//                editElem.setAddable(Element.empty());
// 
//            } else {
//            //Selection, enable the fire button.
//                int index = getSelectedIndex();
//                Element elem = (Element)listModel.getElementAt( index );
//                editElem.setAddable( elem );
//            }
//        }
    }
}
 