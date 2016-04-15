package com.app.paleta;

import java.awt.Toolkit;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Diego
 */
public class txtCelular extends textoPadre {

    public txtCelular() {       
        this.setText("txtCelular");
        this.setToolTipText("Ingrese el número de celular...");
        try {
            MaskFormatter mascara = new MaskFormatter("(09##)-###-###");
            mascara.setPlaceholderCharacter('0');
            this.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascara));
        } catch (ParseException ex) {
        }
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
    }

    @Override
    public boolean isEmpty() {
        return "0900-000-000".equals(this.getText());
    }
}
