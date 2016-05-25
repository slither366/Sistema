package com.app.paleta;

import com.app.config.MensajeSistema;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Diego
 */
public class textoPadre extends javax.swing.JTextField {

    private final Dimension d = new Dimension(75, 20);
    private String placeHolder = "";
    private Color phColor = new Color(0, 0, 0);
    private boolean band = true;

    public textoPadre() {
        this.setToolTipText("Ingrese el registro...");
        this.setText("textoMaestro");
        this.setMinimumSize(d);
        this.setMaximumSize(d);
        this.setPreferredSize(d);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        this.addKeyListener(new java.awt.event.KeyAdapter() {

            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                if (getText().trim().length() == getCantCaracter()) {
                    evt.consume();
                    Toolkit.getDefaultToolkit().beep();
                }
            }

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
        this.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void removeUpdate(DocumentEvent e) {
                band = getText().length() <= 0;
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                band = false;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });          
    }

    /**
     *
     * @param evt
     */
    public void soloNumero(KeyEvent evt) {
        if ("0123456789.-".contains(String.valueOf(evt.getKeyChar())) == false) {
            evt.consume();
        }
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {
        return this.getText().trim().length() <= 0;
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

    /**
     * Metodo para ubicar el indice en un lugar determindo.
     *
     * @param index
     */
    public void setPosicionCursor(int index) {
        this.setCaretPosition(index);
    }

    /**
     * Metodo para seleccionar el contenido de campo de texto
     */
    public void setSeleccionarCampo() {
        this.selectAll();
    }

    /**
     * Metodo para seleccionar el contenido de campo de texto
     *
     * @param inicio
     * @param fin
     */
    public void setSeleccionarCampo(int inicio, int fin) {
        this.setSelectionStart(inicio);
        this.setSelectionEnd(fin);
    }

    /**
     * Metodo para poner el texto en mayuscula
     */
    public void setTextMayuscula() {
        this.setText(getText().trim().toUpperCase());
    }

    /**
     * Metodo que valida la cantidad de caractes que se puede escribir en un
     * campo
     *
     * @param evt
     * @param cantidad
     */
    public void CantidadLetras(java.awt.event.KeyEvent evt, int cantidad) {
        if (this.getText().length() == cantidad) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private int cantCaracter = 150;

    public int getCantCaracter() {
        return cantCaracter;
    }

    public void setCantCaracter(int cantCaracter) {
        this.cantCaracter = cantCaracter;
    }

    /**
     * Metodo para agregar el texto que va aparecer en un campo de forma
     * transparente
     *
     * @param placeholder
     */
    public void setTextTransparente(String placeholder) {
        this.placeHolder = " " + placeholder;
    }

    public String getTextTransparente() {
        return placeHolder;
    }

    public Color getColor() {
        return phColor;
    }

    public void setColor(Color phColor) {
        this.phColor = phColor;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //color de placeholder 
        g.setColor(new Color(phColor.getRed(), phColor.getGreen(), phColor.getBlue(), 90));
        //dibuja texto
        g.drawString((band) ? placeHolder : "", getMargin().left, (getSize().height) / 2 + getFont().getSize() / 2);
    }
}
