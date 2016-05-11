package com.app.clases;

import com.app.paleta.txtCelular;
import com.app.paleta.txtCodigo;
import com.app.paleta.txtFecha;
import com.app.paleta.txtHoraHMS;
import com.app.paleta.txtNumeros;
import com.app.paleta.txtPassword;
import com.app.paleta.txtTelefono;
import com.app.paleta.txtTexto;
import com.app.config.MensajeSistema;
import com.app.paleta.combo;
import com.app.paleta.txtNumerosFormato;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Diego
 */
public class ClaseCampos {

    /**
     * Verifica si algun cuadro de texto esta vacio, recibe como parametro el
     * nombre del jPanel donde se quiere validar los campos
     *
     * @param jpanel
     * @return
     */
    public static boolean setValidate(JPanel jpanel) {
        boolean retorna = false;
        Component[] panel = jpanel.getComponents();
        for (int i = 0; i < jpanel.getComponentCount(); i++) {
            if (panel[i].getClass().equals(txtTexto.class)) {
                txtTexto jTextox = (txtTexto) jpanel.getComponent(i);
                if (jTextox.getText().trim().isEmpty()) {
                    retorna = true;
                    break;
                } else {
                    retorna = false;
                    continue;
                }
            }
            if (panel[i].getClass().equals(txtCodigo.class)) {
                txtCodigo jTextox = (txtCodigo) jpanel.getComponent(i);
                if (jTextox.getText().trim().isEmpty()) {
                    retorna = true;
                    break;
                } else {
                    retorna = false;
                    continue;
                }
            }
            if (panel[i].getClass().equals(txtNumeros.class)) {
                txtNumeros jTextox = (txtNumeros) jpanel.getComponent(i);
                if (jTextox.getText().trim().isEmpty()) {
                    retorna = true;
                    break;
                } else {
                    retorna = false;
                    continue;
                }
            }
            if (panel[i].getClass().equals(txtFecha.class)) {
                txtFecha jfTextox = (txtFecha) jpanel.getComponent(i);
                if (jfTextox.getText().trim().isEmpty()) {
                    retorna = true;
                    break;
                } else {
                    retorna = false;
                    continue;
                }
            }
            if (panel[i].getClass().equals(txtCelular.class)) {
                txtCelular jfTextox = (txtCelular) jpanel.getComponent(i);
                if (jfTextox.getText().trim().isEmpty()) {
                    retorna = true;
                    break;
                } else {
                    retorna = false;
                    continue;
                }
            }
            if (panel[i].getClass().equals(txtTelefono.class)) {
                txtTelefono jfTextox = (txtTelefono) jpanel.getComponent(i);
                if (jfTextox.getText().trim().isEmpty()) {
                    retorna = true;
                    break;
                } else {
                    retorna = false;
                    continue;
                }
            }
            if (panel[i].getClass().equals(txtPassword.class)) {
                txtPassword jPassx = (txtPassword) jpanel.getComponent(i);
                if (jPassx.getText().trim().isEmpty()) {
                    retorna = true;
                    break;
                } else {
                    retorna = false;
                    continue;
                }
            }
            if (panel[i].getClass().equals(JTextField.class)) {
                JTextField jTexto = (JTextField) jpanel.getComponent(i);
                if (jTexto.getText().trim().isEmpty()) {
                    retorna = true;
                    break;
                } else {
                    retorna = false;
                    continue;
                }
            }
            if (panel[i].getClass().equals(JFormattedTextField.class)) {
                JFormattedTextField jfTexto = (JFormattedTextField) jpanel.getComponent(i);
                if (jfTexto.getText().trim().isEmpty()) {
                    retorna = true;
                    break;
                } else {
                    retorna = false;
                }
            }
        }
        return retorna;
    }

    /**
     * Metodo que valida si el JTextField que se le envia como parametro esta
     * vacio, si es asi retorna false sino, retorna true, si es false muestra un
     * mensaje de error
     *
     * @param text
     * @return
     */
    public static boolean validarVacio(JTextField text) {
        String vText = text.getText().trim();
        if ("".equals(vText)) {
            MensajeSistema.MensajeVarios("Este campo no se puede vacio!!!", MensajeSistema.ERROR_MESSAGE());
            text.setText(null);
            text.grabFocus();
            return false;
        } else {
            text.setText(vText);
            return true;
        }
    }

    /**
     * Metodo que valida si el JTextField que se le envia como parametro esta
     * vacio, si es asi retorna false sino, retorna true
     *
     * @param text
     * @return
     */
    public static boolean validarVacioSinMsj(JTextField text) {
        String vText = text.getText().trim();
        if ("".equals(vText)) {
            text.setText(null);
            return false;
        } else {
            text.setText(vText);
            return true;
        }
    }

    /**
     * Metodo para validar que un campo solamente pueda aceptar numeros
     * <>Se utiliza en el evento KeyTyped del Campo de Texto
     *
     * @param evt
     */
    public static void SoloNumero(KeyEvent evt) {
        if ("0123456789.-,".contains(String.valueOf(evt.getKeyChar())) == false) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Metodo para validar que un campo solamente pueda aceptar Letras
     * <>Se utiliza en el evento KeyTyped del Campo de Texto
     *
     * @param evt
     */
    public static void SoloLetras(KeyEvent evt) {
        if ("0123456789".contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /**
     * Metodo que valida la cantidad de letras que se puede ingresar en un campo
     * de texto
     * <>Se utiliza en el evento KeyTyped del JTextField
     *
     * @param evt
     * @param text
     * @param Cantidad
     * @return
     */
    public static boolean CantidadLetras(KeyEvent evt, JTextField text, int Cantidad) {
        if (text.getText().length() == Cantidad) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            return true;
        }
        return false;
    }

    /**
     * Coloca visible o invisible lo que contiene un jPanel
     *
     * @param jpanel
     * @param boo
     */
    public static void setVisible(JPanel jpanel, boolean boo) {
        for (int i = 0; i < jpanel.getComponentCount(); i++) {
            jpanel.getComponent(i).setVisible(boo);
        }
    }

    /**
     * Todos los componentes contenidas en un jPanel coloca en verdadero o
     * falso, funciona con JTextField, JPasswordField, JFormattedTextField,
     * JComboBox, txtCelular, txtCodigo, txtFecha, txtHoraHMS, txtNumeros,
     * txtPassword, txtTexto, JRadioButton, JCheckBox, JComboBox,txtNroGs,
     * txtNroUs, JButton
     *
     * @param jpanel
     * @param boo
     */
    public static void setEnabled(JPanel jpanel, boolean boo) {
        for (int i = 0; i < jpanel.getComponentCount(); i++) {
            if (jpanel.getComponent(i).getClass().equals(txtTexto.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(txtCodigo.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(txtNumeros.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(txtFecha.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(txtCelular.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(txtTelefono.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(txtNumerosFormato.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(combo.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(JComboBox.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(JRadioButton.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(JCheckBox.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(txtHoraHMS.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(txtPassword.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }

            if (jpanel.getComponent(i).getClass().equals(JButton.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(JTextField.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(JPasswordField.class)) {
                jpanel.getComponent(i).setEnabled(boo);
                continue;
            }
            if (jpanel.getComponent(i).getClass().equals(JFormattedTextField.class)) {
                jpanel.getComponent(i).setEnabled(boo);
            }
        }
    }

    /**
     * Todos los componentes contenidas en un jPanel coloca en verdadero o
     * falso, funciona con JTextField, JPasswordField, JFormattedTextField,
     * JComboBox, txtCelular, txtCodigo, txtFecha, txtHoraHMS, txtNumeros,
     * txtPassword, txtTexto, JRadioButton, JCheckBox, JComboBox,txtNroGs,
     * txtNroUs, JButton
     *
     * @param jpanel
     */
    public static void setAllNullComponents(JPanel jpanel) {
        Component[] panel = jpanel.getComponents();
        for (int i = 0; i < jpanel.getComponentCount(); i++) {
            if (panel[i].getClass().equals(txtTexto.class)) {
                txtTexto jTexto = (txtTexto) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtCodigo.class)) {
                txtCodigo jTexto = (txtCodigo) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtNumeros.class)) {
                txtNumeros jTexto = (txtNumeros) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtFecha.class)) {
                txtFecha jTexto = (txtFecha) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(combo.class)) {
                combo jCombo = (combo) jpanel.getComponent(i);
                jCombo.removeAllItems();
                continue;
            }
            if (panel[i].getClass().equals(JComboBox.class)) {
                JComboBox jCombo = (JComboBox) jpanel.getComponent(i);
                jCombo.removeAllItems();
                continue;
            }
            if (panel[i].getClass().equals(txtHoraHMS.class)) {
                txtHoraHMS jTexto = (txtHoraHMS) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtCelular.class)) {
                txtCelular jTexto = (txtCelular) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtTelefono.class)) {
                txtTelefono jTexto = (txtTelefono) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtNumerosFormato.class)) {
                txtNumerosFormato jTexto = (txtNumerosFormato) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtPassword.class)) {
                txtPassword jTexto = (txtPassword) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(JRadioButton.class)) {
                JRadioButton jRadio = (JRadioButton) jpanel.getComponent(i);
                jRadio.setSelected(false);
                continue;
            }
            if (panel[i].getClass().equals(JCheckBox.class)) {
                JCheckBox jCheck = (JCheckBox) jpanel.getComponent(i);
                jCheck.setSelected(false);
                continue;
            }
            if (panel[i].getClass().equals(JTextField.class)) {
                JTextField jTexto = (JTextField) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(JFormattedTextField.class)) {
                JFormattedTextField jTexto = (JFormattedTextField) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(JPasswordField.class)) {
                JPasswordField jTexto = (JPasswordField) jpanel.getComponent(i);
                jTexto.setText("");
            }
        }
    }

    /**
     * Recibe un grupo de panels para colocarles nulo siempre y cuando se
     * encuentre dentro de los rangos validos entre: JTextField, JPasswordField,
     * JFormattedTextField, JComboBox, txtCelular, txtCodigo, txtFecha,
     * txtHoraHMS, txtNumeros, txtPassword, txtTexto, JRadioButton, JCheckBox,
     * JComboBox,txtNroGs, txtNroUs, JButton
     *
     * @param jpanel
     */
    public static void setAllNullComponents(JPanel[] jpanel) {
        for (JPanel jpanel1 : jpanel) {
            setAllNullComponents(jpanel1);
        }
    }

    /**
     * Todos los jTextField contenidas en un jPanel pone en null. Funciona con
     * JTextField, JPasswordField, JFormattedTextField, JComboBox, txtCelular,
     * txtCodigo, txtFecha, txtHoraHMS, txtNumeros, txtPassword, txtTexto,
     * JRadioButton, JCheckBox, JComboBox,txtNroGs, txtNroUs, JButton
     *
     * @param jpanel
     */
    public static void setTextNull(JPanel jpanel) {
        Component[] panel = jpanel.getComponents();
        for (int i = 0; i < jpanel.getComponentCount(); i++) {
            if (panel[i].getClass().equals(txtTexto.class)) {
                txtTexto jTexto = (txtTexto) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtCodigo.class)) {
                txtCodigo jTexto = (txtCodigo) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtNumeros.class)) {
                txtNumeros jTexto = (txtNumeros) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtFecha.class)) {
                txtFecha jTexto = (txtFecha) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtCelular.class)) {
                txtCelular jTexto = (txtCelular) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtTelefono.class)) {
                txtTelefono jTexto = (txtTelefono) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtNumerosFormato.class)) {
                txtNumerosFormato jTexto = (txtNumerosFormato) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtPassword.class)) {
                txtPassword jTexto = (txtPassword) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(txtHoraHMS.class)) {
                txtHoraHMS jTexto = (txtHoraHMS) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(JTextField.class)) {
                JTextField jTexto = (JTextField) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(JFormattedTextField.class)) {
                JFormattedTextField jTexto = (JFormattedTextField) jpanel.getComponent(i);
                jTexto.setText("");
                continue;
            }
            if (panel[i].getClass().equals(JPasswordField.class)) {
                JPasswordField jTexto = (JPasswordField) jpanel.getComponent(i);
                jTexto.setText("");
            }
        }
    }
}
