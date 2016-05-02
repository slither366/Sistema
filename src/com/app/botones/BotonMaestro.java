package com.app.botones;

import java.awt.Color;

/**
 *
 * @author Diego
 */
public class BotonMaestro extends javax.swing.JButton {

    public BotonMaestro() {
        this.setText("Boton Maestro");
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setMargin(new java.awt.Insets(1, 1, 1, 1));
        this.setMinimumSize(new java.awt.Dimension(80, 30));
        this.setMaximumSize(new java.awt.Dimension(80, 30));
        this.setPreferredSize(new java.awt.Dimension(80, 30));       
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                setForeground(new Color(0, 0, 255));
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                setForeground(Color.BLACK);
            }
        });
    }
}
