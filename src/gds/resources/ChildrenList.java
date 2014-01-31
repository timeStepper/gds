/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gds.resources;

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
public class ChildrenList extends JList
                      implements ListSelectionListener {
    
    //private JList list;
    private DefaultListModel listModel;
    private EditElement editElem;
    ArrayList< Child > selections = new ArrayList<>();
    
    public ChildrenList( DefaultListModel lm, EditElement ee ) {
        super( lm );
        
        listModel = lm;
 
        editElem = ee;
        setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        addListSelectionListener(this);
    }
    public void removeChild() {
        int index = getSelectedIndex();
        listModel.remove(index);
    }
    public void addChild( Child add ) {
        if (alreadyInList(add)) {
            return;
        } else {
            listModel.addElement(add);
        }
        editElem.addChild(add);
    }
    protected boolean alreadyInList(Child e) {
        return listModel.contains(e);
    }
    //This method is required by ListSelectionListener.
    @Override
    public void valueChanged(ListSelectionEvent e) {
    }
}
 
