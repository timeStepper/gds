/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author owenpaulmeyer
 */
public class ConnectionsList extends JList
                      implements ListSelectionListener {
    
    //private JList list;
    private DefaultListModel listModel;
    private EditElement editElem;
    ArrayList< Connection > selections = new ArrayList<>();
    
    ConnectionsList( DefaultListModel lm ) {
        super( lm );
        listModel = lm;
        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        addListSelectionListener(this);
    }
    public void setEditElem( EditElement ee ) {
        editElem = ee;
    }
    public void removeConnection( Connection c ) {
        if ( listModel.contains(c)){
            int index = listModel.indexOf( c );
            listModel.remove(index);
        }
    }
    public void addConnection( Connection add ) {
        if (alreadyInList(add)) {
            return;
        } else {
            listModel.addElement(add);
        }
    }
    @Override
    public void removeAll(){
        listModel.removeAllElements();
    }
    public boolean alreadyInList(Connection e) {
        return listModel.contains(e);
    }
    //This method is required by ListSelectionListener.
    @Override
    public void valueChanged(ListSelectionEvent e) {
        
    }
}
 
