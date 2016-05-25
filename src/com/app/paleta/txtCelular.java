package com.app.paleta;

import com.app.config.MensajeSistema;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Diego
 */
public class txtCelular extends javax.swing.JFormattedTextField {

    private final Dimension d = new Dimension(75, 20);

    public txtCelular() {
        this.setToolTipText("Ingrese el número de celular...");
        this.setMinimumSize(d);
        this.setMaximumSize(d);
        this.setPreferredSize(d);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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

    public boolean isEmpty() {
        return "0900-000-000".equals(this.getText());
    }

    public boolean verificarVacioSinMsj() {
        return !this.isEmpty();
    }

    public int verificarVacioConMsj() {
        if (isEmpty()) {
            int msn = MensajeSistema.MensajeOpciones("No se puede dejar este campo vacio!!!\nDesea Cancelar la operación?...",
                    new Object[]{"Si, Cancelar.", "No, Reintentar."}, 1);
            if (msn == 0) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 0;
        }
    }
}
