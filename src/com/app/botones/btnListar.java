package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnListar extends BotonMaestro {

    public btnListar() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/document-preview.png")));
        this.setText("Listar");
        this.setToolTipText("Listar los Registros según los Parametros Desde Hasta...");        
        this.setMnemonic('L');
    }
}
