package com.app.paleta;

import com.app.clases.ClaseHora;
import com.app.config.MensajeSistema;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Diego
 */
public class txtHoraHMS extends javax.swing.JFormattedTextField {

    public txtHoraHMS() {
        this.setText("txtHora");
        this.setToolTipText("Ingrese la hora...");
        try {
            MaskFormatter mascara = new MaskFormatter("##:##:##");
            mascara.setPlaceholderCharacter('0');
            this.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascara));
        } catch (ParseException ex) {
        }
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                verificar();
            }
        });
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

    /**
     * Retorna la hora en formato HH:MM:SS para poder guardar en la Base de
     * Datos, valida la hora antes de retornar, si esta correcto retorna la
     * fecha en caso contrario retorna null
     *
     * @return
     */
    public String getHora() {
        String hora = this.getText();
        if (ClaseHora.esHoraValida(hora)) {
            return hora;
        } else {
            return null;
        }
    }

    /**
     * Recibe como parametro la hora recibida de la Base de Datos en formato
     * HH:MM:SS, verifica si esta correcto la hora y lo pone como valor
     *
     * @param hora
     */
    public void setHora(String hora) {
        try {
            if (ClaseHora.esHoraValida(hora)) {
                this.setText(hora);
            } else {
                MensajeSistema.MensajeVarios("La Hora ingresada no es Válida!", MensajeSistema.ERROR_MESSAGE());
            }
        } catch (Exception ex) {
            MensajeSistema.setException("El formato de fecha debe ser HH:MM:SS", ex);
        }
    }

    public String getMinuto() {
        return this.getText().substring(3, 5);
    }

    public long getHoraToMinuto() {
        return ClaseHora.getHoraToMinuto(this.getText());
    }

    public long getHoraToSegundo() {
        return ClaseHora.getHoraToSegundo(this.getText());
    }

    private void verificar() {
        if (!"00:00:00".equals(this.getText())) {
            if (ClaseHora.esHoraValida(this.getText()) == false) {
                MensajeSistema.MensajeVarios("La Hora ingresada no es Válida!", MensajeSistema.ERROR_MESSAGE());
                this.grabFocus();
            }
        }
    }

    public void setHoraActual() {
        Date fechaSistema = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("HH:mm:ss");
        this.setText(formateador.format(fechaSistema));
    }

    public boolean isEmpty() {
        return "00:00:00".equals(this.getText());
    }
}
