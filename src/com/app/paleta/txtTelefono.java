package com.app.paleta;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

/**
 *
 * @author Diego
 */
public class txtTelefono extends textoPadre {

    public txtTelefono() {
        this.setText("txtTelefono");
        this.setToolTipText("Ingrese el número de teléfono...");
        this.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent evt) {
                if ("0123456789-()".contains(String.valueOf(evt.getKeyChar())) == false) {
                    evt.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (getText().length() == 15) {
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }
}
