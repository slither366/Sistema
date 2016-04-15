package com.app.paleta;

/**
 *
 * @author Diego
 */
public final class txtNumerosFormato extends txtNumeros {

    public txtNumerosFormato() {
        setFormato(false);
        setInicializar(getCantFormato(), 0);
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (isEmpty() == false) {                    
                    int valor=Integer.parseInt(getText().trim());
                    if (valor > 0) {
                        setText(String.valueOf(valor));
                        selectAll();
                    }
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (isEmpty() == false) {
                    String valor = getText().trim();
                    int num;
                    try {
                        num = Integer.parseInt(valor);
                    } catch (NumberFormatException ex) {
                        num = 0;
                    }
                    if (num > 0 && valor.length() < CantFormato) {
                        for (int i = 0; i < CantFormato; i++) {
                            valor = "0" + valor;
                            if (valor.length() == CantFormato) {
                                break;
                            }
                        }
                        setText(valor);
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

    private int CantFormato = 3;

    public int getCantFormato() {
        return CantFormato;
    }

    public void setCantFormato(int CantFormato) {
        this.CantFormato = CantFormato;
        this.setInicializar(CantFormato, 0);
    }
}
