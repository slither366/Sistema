package com.app.paleta;

import com.app.clases.ClaseCampos;

/**
 * Componente JPanel que ya implemente algunos metodos de la ClaseCampos <br>
 * para funcionar mas personalizado
 *
 * @author Diego
 */
public class panel extends javax.swing.JPanel {

    public panel() {
        this.setBorder(javax.swing.BorderFactory.createEtchedBorder());
    }

    /**
     * Todos los jTextField contenidas en un jPanel pone en null. Funciona con
     * JTextField, JPasswordField, JFormattedTextField, JComboBox, txtCelular,
     * txtCodigo, txtFecha, txtHoraHMS, txtNumeros, txtPassword, txtTexto,
     * JRadioButton, JCheckBox, JComboBox,txtNroGs, txtNroUs, JButton
     */
    public void setTextNull() {
        ClaseCampos.setTextNull(this);
    }

    /**
     * Todos los componentes contenidas en un jPanel coloca en verdadero o
     * falso, funciona con JTextField, JPasswordField, JFormattedTextField,
     * JComboBox, txtCelular, txtCodigo, txtFecha, txtHoraHMS, txtNumeros,
     * txtPassword, txtTexto, JRadioButton, JCheckBox, JComboBox,txtNroGs,
     * txtNroUs, JButton
     *
     * @param b
     */
    @Override
    public void setEnabled(boolean b) {
        ClaseCampos.setEnabled(this, b);
    }

    /**
     * Metodo que coloca Visible(true o false) todos los componentes que
     * contiene el JPanel
     *
     * @param b
     */
    @Override
    public void setVisible(boolean b) {
        ClaseCampos.setVisible(this, b);
    }

    /**
     * Metodo que pone NULL o vacio todos los camponentes que contiene el JPanel
     */
    public void setAllNullComponents() {
        ClaseCampos.setAllNullComponents(this);
    }

    /**
     * Metodo que valida que no queden vacios ningun componente del JPanel
     *
     * @return
     */
    public boolean setValidate() {
        return ClaseCampos.setValidate(this);
    }
}
