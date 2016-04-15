package com.app.form.Practicas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 *
 * @author Diego
 */
public class ResultSetComboBoxMode implements ComboBoxModel {

    private final Vector<ResultSetComboBoxModelObject> data = new Vector<ResultSetComboBoxModelObject>();
    private final Vector<ListDataListener> list = new Vector<ListDataListener>();
    private ResultSetComboBoxModelObject selectedItem;

    public ResultSetComboBoxMode(ResultSet r, String codigo, String descri) throws SQLException {
        r.beforeFirst();
        while (r.next()) {
            data.add(new ResultSetComboBoxModelObject(r.getInt(codigo), r.getString(descri)));
        }
    }

    public ResultSetComboBoxModelObject searchSelectedItem(Integer i) {
        for (ResultSetComboBoxModelObject o : data) {
            if (i.equals(o.getCodigo())) {
                return o;
            }
        }
        return null;
    }

    public ResultSetComboBoxModelObject searchSelectedItem(String s) {
        for (ResultSetComboBoxModelObject o : data) {
            if (s.equals(o.getDescri())) {
                return o;
            }
        }
        return null;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem = anItem instanceof ResultSetComboBoxModelObject ? (ResultSetComboBoxModelObject) anItem : null;
        for (ListDataListener l : list) {
            l.contentsChanged(new ListDataEvent(this, javax.swing.event.ListDataEvent.CONTENTS_CHANGED, 0, 0));
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public Object getElementAt(int index) {
        return data.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        list.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        list.remove(l);
    }

    public Integer getSelectedCodigo() {
        return selectedItem == null ? null : selectedItem.getCodigo();
    }

    public String getSelectedDescri() {
        return selectedItem == null ? null : selectedItem.getDescri();
    }

    public class ResultSetComboBoxModelObject {

        private Integer codigo;
        private String descri;

        public ResultSetComboBoxModelObject(Integer codigo, String descri) {
            this.codigo = codigo;
            this.descri = descri;
        }

        @Override
        public String toString() {
            return this.getDescri();
        }

        public Integer getCodigo() {
            return codigo;
        }

        public void setCodigo(Integer codigo) {
            this.codigo = codigo;
        }

        public String getDescri() {
            return descri;
        }

        public void setDescri(String descri) {
            this.descri = descri;
        }

    }
}
