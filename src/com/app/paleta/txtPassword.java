package com.app.paleta;

import com.app.clases.ClaseEncriptacion;
import com.app.config.MensajeSistema;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

/**
 * txtPassword
 *
 * @author Diego
 */
public class txtPassword extends javax.swing.JPasswordField {

    private final Dimension d = new Dimension(75, 20);

    public txtPassword() {
        this.setText("");
        this.setToolTipText("Escriba su contraseña...");
        this.setEchoChar('*');
        this.setMinimumSize(d);
        this.setMaximumSize(d);
        this.setPreferredSize(d);
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (27 == evt.getKeyCode()) {
                    setText("");
                    Toolkit.getDefaultToolkit().beep();
                }
                if (113 == evt.getKeyCode()) {
                    selectAll();
                }
            }
        });
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                setCaretPosition(0);
                selectAll();
            }            
        });

    }

    public boolean isEmpty() {
        return this.getText().trim().length() == 0;
    }

    /**
     * Verifica si está vacio el campo, si esta vacio muestra un mensaje de
     * vacio y envía a si mismo el focus y retorna true sino retorna false
     *
     * @return
     */
    public int verificarVacioConMsj() {
        if (isEmpty()) {
            int msn = MensajeSistema.MensajeOpciones("No se puede dejar este campo vacio!!!\nDesea Cancelar la operación?...",
                    new Object[]{"SI", "NO"}, 1);
            if (msn == 0) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }

    /**
     * Verifica si está vacio el campo, si esta vacio envía a si mismo el focus
     * y retorna true sino retorna false
     *
     * @return
     */
    public boolean verificarVacioSinMsj() {
        if (isEmpty()) {
            this.grabFocus();
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarCantidadMinima() {
        if (this.getText().length() < 5) {
            MensajeSistema.MensajeVarios("La contraseña tiene que ser como minimo 5 caracteres", MensajeSistema.QUESTION_MESSAGE());
            this.setText("");
            this.grabFocus();
            return false;
        } else {
            return true;
        }
    }

    public void CantidadLetras(KeyEvent evt, int cantidad) {
        if (this.getText().length() == cantidad) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
