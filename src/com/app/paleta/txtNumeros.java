package com.app.paleta;

import com.app.clases.ClaseNumeros;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;

/**
 *
 * @author Diego
 */
public class txtNumeros extends textoPadre {

    private int CantNumero = 10;
    private boolean ConDecimal = false;
    private int CantDecimal = 0;

    public txtNumeros() {
        this.setText("0");
        this.setToolTipText("Ingrese solo Números...");
        this.setHorizontalAlignment(RIGHT);
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                char valor = evt.getKeyChar();
                // para no permitir escribir mas de una ves el guion, 
                if (valor == '-' && getCaretPosition() > 0) {
                    evt.consume();
                }
                soloNumero(evt);
                if (ConDecimal) {// solamente va a entrar esta parte si es con decimal
                    // para no permitir escribir punto en la posicion cero
                    if ((valor == '.' && getCaretPosition() == 0)) {
                        evt.consume();
                    }
                    // para no permitir escribir dos veces el punto,
                    // si ya existe el punto envia el cursor en la posicion en donde esta el punto
                    if (valor == '.' && getText().contains(".")) {
                        evt.consume();
                        setCaretPosition(getText().indexOf(".") + 1);
                    }
                } else {// si es Sin decimal, elimina el punto
                    if (valor == '.') {
                        evt.consume();
                    }
                }
                // 59656.569

                int punto = getText().contains(".") ? getText().indexOf(".") + 1 : getText().length();
                String ParteEntera = getText().substring(0, punto < 0 ? getText().length() : punto);
                String ParteDecimal = punto < 0 ? "" : getText().substring(punto);
                int posicion = getCaretPosition();
                if (getText().replaceAll(",", "").length() >= CantNumero) {
                    String numero = ParteEntera.substring(0, punto);
                    if (getCaretPosition() == getText().length()) {
                        evt.consume();
                        Toolkit.getDefaultToolkit().beep();
                    } else {
                        evt.consume();
                        numero = numero.substring(0, posicion) + evt.getKeyChar() + ParteEntera.substring(posicion);
                        try {
                            setText(numero.substring(0, CantNumero - CantDecimal) + ParteDecimal);
                        } catch (Exception e) {
                            setText(numero.substring(0, numero.length()) + ParteDecimal);
                        }
                        try {
                            setCaretPosition(posicion + 1);
                        } catch (Exception ex) {
                            setCaretPosition(posicion);
                        }
                    }
                }
            }
        });
        this.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                String valor = getText().replaceAll(",", "");
                int punto = valor.indexOf(".");
                if (punto > 0) {
                    String decimal = valor.substring(punto + 1);
                    int dec;
                    try {
                        dec = Integer.parseInt(decimal);
                    } catch (Exception ex) {
                        dec = 0;
                    }
                    if (dec <= 0) {
                        valor = valor.substring(0, punto);
                    }
                }
                setText(valor);
                setSeleccionarCampo();
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (isEmpty()) {
                    setText("0");
                } else {
                    if (isFormatear()) {
                        setText(ClaseNumeros.formatoMiles(getText().replaceAll(",", ""), ConDecimal ? CantDecimal : 0));
                    }
                }
            }
        });
    }

    public double getNumeroDouble() {
        return this.getText().trim().isEmpty() ? 0 : Double.parseDouble(this.getText().replaceAll(",", ""));
    }

    public int getNumeroInt() {
        return this.getText().trim().isEmpty() ? 0 : Integer.parseInt(this.getText().replaceAll(",", ""));
    }

    public void setNumero(double valor) {
        this.setText(ClaseNumeros.formatoMiles(String.valueOf(valor), ConDecimal ? CantDecimal : 0));
    }

    public void setNumero(String valor) {
        this.setText(ClaseNumeros.formatoMiles(valor, ConDecimal ? CantDecimal : 0));
    }

    @Override
    public boolean isEmpty() {
        return this.getText().trim().length() < 0 ? true : "".equals(this.getText().replaceAll(",", "").trim());
    }

    /**
     * Metodo que inicializa las variables
     * <>CantNumero<> es la cantidad de caracteres que va aceptar el campo
     * <>CantDecimal<> es la cantidad de caracteres decimales
     *
     * @param cantidad El total de Numeros
     * @param decimal El total de la Parte decimal
     */
    public void setInicializar(int cantidad, int decimal) {
        this.CantNumero = cantidad;
        this.CantDecimal = decimal;
        this.ConDecimal = decimal > 0;
    }

    private boolean formato = false;

    public boolean isFormatear() {
        return formato;
    }

    public void setFormatear(boolean formato) {
        this.formato = formato;
    }
}
