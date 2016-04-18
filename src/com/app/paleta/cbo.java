package com.app.paleta;

import com.app.config.MensajeSistema;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class cbo extends javax.swing.JComboBox {

    public cbo() {

    }

    /**
     * Metodo que cargar datos en el combo desde un ResultSet
     *
     * @param rs
     */
    public void addItem(ResultSet rs) {
        try {
            if (rs.next()) {
                do {
                    this.addItem(new ClassComboBox(rs.getString(1), rs.getString(2)));
                } while (rs.next());
            }
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
        }
    }

    public void addItem(String item) {
        this.addItem(new ClassComboBox("", item));
    }

    public void addItem(String[] item) {
        for (String item1 : item) {
            this.addItem(new ClassComboBox("", item1));
        }
    }

    /**
     * Metodo que retorna el valor del codigo del registro seleccionado
     *
     * @return
     */
    public String getSelecCodigo() {
        ClassComboBox model = (ClassComboBox) this.getSelectedItem();
        return model.getCodigo();
    }

    /**
     * Metodo que selecciona el valor del registro si existe en la lista
     *
     * @param valor
     */
    public void setSelecCodigo(String valor) {
        for (int i = 0; i < this.getItemCount(); i++) {
            if (this.getCodigo(i).equals(valor)) {
                this.setSelectedIndex(i);
            }
        }
    }

    /**
     * Metodo que retorna el valor del descri del registro seleccionado
     *
     * @return
     */
    public String getSelecDescri() {
        ClassComboBox model = (ClassComboBox) this.getSelectedItem();
        return model.getDescri();
    }

    /**
     * Metodo que selecciona el valor del registro si existe en la lista
     *
     * @param valor
     */
    public void setSelecDescri(String valor) {
        for (int i = 0; i < this.getItemCount(); i++) {
            if (this.getDescri(i).equals(valor)) {
                this.setSelectedIndex(i);
            }
        }
    }

    /**
     * Metodo que retonra el valor del codigo de la posicion proporcionada
     *
     * @param posicion
     * @return
     */
    public String getCodigo(int posicion) {
        try {
            ClassComboBox model = (ClassComboBox) this.getItemAt(posicion);
            return model.getDescri();
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * Metodo que retorna el valor del descri de la posicion proporcionada
     *
     * @param posicion
     * @return
     */
    public String getDescri(int posicion) {
        try {
            ClassComboBox model = (ClassComboBox) this.getItemAt(posicion);
            return model.getDescri();
        } catch (Exception ex) {
            return "";
        }
    }

    /**
     * Metodo que muestra el contenido del comboBox<br>
     * setPopupVisible(true)
     */
    public void MostrarContenido() {
        this.setPopupVisible(true);
    }

    public class ClassComboBox {

        private String codigo;
        private String descri;

        public ClassComboBox(String codigo, String descri) {
            this.codigo = codigo;
            this.descri = descri;
        }

        @Override
        public String toString() {
            return this.getCodigo().isEmpty() ? this.getDescri() : this.getCodigo() + " - " + this.getDescri();
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
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
