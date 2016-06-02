package com.app.paleta;

/**
 *
 * @author Diego
 */
public final class txtNumerosFormato extends txtNumeros {

    public txtNumerosFormato() {
        setFormatear(false);
        setInicializar(getFormatoCantidad(), 0);
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (isEmpty() == false) {
                    int valor = Integer.parseInt(getText().trim());
                    if (valor > 0) {
                        setText(String.valueOf(valor));
                        selectAll();
                    }
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (isEmpty() == false) {
                    try {
                        String valor = getText().trim();
                        int num = Integer.parseInt(valor);
                        if (num > 0 && valor.length() < FormatoCantidad) {
                            for (int i = 0; i < FormatoCantidad; i++) {
                                valor = "0" + valor;
                                if (valor.length() == FormatoCantidad) {
                                    break;
                                }
                            }
                            setText(valor);
                        }
                    } catch (NumberFormatException ex) {
                    }
                }
            }
        });
    }

    @Override
    public boolean isEmpty() {
        try {
            return Integer.parseInt(this.getText()) <= 0;
        } catch (NumberFormatException ex) {
            return true;
        }
    }

    public void setNumero(int num) {
        setText(String.valueOf(num));
    }

    @Override
    public int getNumeroInt() {
        try {
            return Integer.parseInt(this.getText().trim());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }

    private int FormatoCantidad = 3;

    public int getFormatoCantidad() {
        return FormatoCantidad;
    }

    public void setFormatoCantidad(int FormatoCantidad) {
        this.FormatoCantidad = FormatoCantidad;
        this.setInicializar(FormatoCantidad, 0);
    }
}
