package com.app.paleta;

import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author Diego
 */
public class txtTexto extends textoPadre {

    public txtTexto() {
        this.setText("txtTexto");
        this.setToolTipText("Ingrese alguna descripción...");
        this.addKeyListener(new java.awt.event.KeyListener() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (isEnMayuscula()) {
                    Character c = evt.getKeyChar();
                    if (Character.isLetter(c)) {
                        evt.setKeyChar(Character.toUpperCase(c));
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setCaretPosition(0);
                selectAll();
            }

            @Override
            public void focusLost(FocusEvent e) {
            }
        });
    }

    private boolean EnMayuscula = false;

    /**
     * Metodo para saber si esta activo para escribir solo en mayuscula
     * <>Por defecto está en false<>
     *
     * @return
     */
    public boolean isEnMayuscula() {
        return EnMayuscula;
    }

    /**
     * Metodo para activar o desactivar para que se puede escribir solo en
     * mayuscula
     *
     * <>Por defecto está en false<>
     *
     * @param EnMayuscula
     */
    public void setEnMayuscula(boolean EnMayuscula) {
        this.EnMayuscula = EnMayuscula;
    }    
}
