package com.app.paleta;

import com.app.form.Especiales.Calendario;
import com.app.clases.ClaseFecha;
import com.app.clases.ClaseTeclas;
import com.app.config.MensajeSistema;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.text.ParseException;
import java.util.Date;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Diego
 */
public class txtFecha extends textoPadre {

    public txtFecha() {  
        this.setToolTipText("Ingrese la fecha...");
        try {
            MaskFormatter mascara = new MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('0');
            this.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(mascara));
        } catch (ParseException ex) {
        }
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
                    Calendario cal = new Calendario(new Frame(), true);
                    cal.setVisible(true);
                    setText(ClaseFecha.deDateToString(Calendario.getFecha()));
                    requestFocus();
                }
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
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (isEmpty() == false) {
                    selectAll();
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (isEmpty() == false) {
                    if (getText().matches("[0-9]{2}/[0]{2}/[0]{4}")) {
                        // cuando se completo el dia solamente
                        String valor = getText().substring(0, 3) + ClaseFecha.getMonth() + "/" + ClaseFecha.getYear();
                        if (ClaseFecha.esFechaValida(valor) == false) {
                            MensajeSistema.MensajeVarios("La fecha ingresada no es Válida!...", MensajeSistema.ERROR_MESSAGE());
                            setCaretPosition(0);
                            requestFocus();
                        } else {
                            setText(valor);
                        }
                    } else if (getText().matches("[0-9]{2}/[0-9]{2}/[0]{4}")) {
                        // cuando se completo el dia y el mes solamente
                        String valor = getText().substring(0, 6) + ClaseFecha.getYear();
                        if (ClaseFecha.esFechaValida(valor) == false) {
                            MensajeSistema.MensajeVarios("La fecha ingresada no es Válida!...", MensajeSistema.ERROR_MESSAGE());
                            setCaretPosition(0);
                            requestFocus();
                        } else {
                            setText(valor);
                        }
                    } else {
                        if (getText().matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
                            // cuando se completo bien el dia, el mes y el año
                            if (ClaseFecha.esFechaValida(getText()) == false) {
                                MensajeSistema.MensajeVarios("La fecha ingresada no es Válida!...", MensajeSistema.ERROR_MESSAGE());
                                grabFocus();
                            }
                        } else {
                            setText("");
                        }
                    }
                }
            }
        }
        );
    }

    /**
     * Metodo que retorna la fecha en formato AAAA-MM-DD para poder guardar en
     * la Base de Datos, valida la fecha antes de retornar, si esta correcto
     * retorna la fecha en caso contrario retorna null
     *
     * @return
     */
    public String getFecha() {
        String valor = this.getText();
        if (valor.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            String dia = valor.substring(0, 2);
            String mes = valor.substring(3, 5);
            String anho = valor.substring(6, 10);
            if (ClaseFecha.esFechaValida(dia + "/" + mes + "/" + anho)) {
                return (anho + "-" + mes + "-" + dia);
            }
        }
        return "";
    }

    /**
     * Metodo que retorna la fecha contenida en el campo en Date
     *
     * @return
     */
    public Date getFechaD() {
        return ClaseFecha.deStringToDate(getText());
    }

    /**
     * Recibe como parametro la fecha recibida de la Base de Datos en formato
     * AAAA-MM-DD, verifica si esta correcto la fecha y lo pone como valor en
     * formato DD/MM/AAAA sino
     *
     * @param valor
     */
    public void setFecha(String valor) {
        if (valor.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
            try {
                String dia = valor.substring(0, 2);
                String mes = valor.substring(3, 5);
                String anho = valor.substring(6, 10);
                String vFecha = dia + "/" + mes + "/" + anho;
                if (ClaseFecha.esFechaValida(vFecha)) {
                    this.setText(dia + "/" + mes + "/" + anho);
                }
            } catch (HeadlessException ex) {
                MensajeSistema.setException("El formato de la fecha debe ser DD/MM/AAAA", ex);
            }
        } else if (valor.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
            try {
                String dia = valor.substring(8, 10);
                String mes = valor.substring(5, 7);
                String anho = valor.substring(0, 4);
                String vFecha = dia + "/" + mes + "/" + anho;
                if (ClaseFecha.esFechaValida(vFecha)) {
                    this.setText(dia + "/" + mes + "/" + anho);
                }
            } catch (HeadlessException ex) {
                MensajeSistema.setException("El formato de la fecha debe ser AAAA-DD-DD", ex);
            }
        } else {
            this.setText("");
        }
    }

    @Override
    public boolean isEmpty() {
        return this.getText().matches("[0]{2}/[0]{2}/[0]{4}");
    }

    public void setFechaActual() {
        this.setText(ClaseFecha.getFechaActual());
    }

    public String getFechaActual() {
        return ClaseFecha.getFechaActual();
    }
}
