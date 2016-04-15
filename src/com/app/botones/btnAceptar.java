package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnAceptar extends BotonMaestro {

    public btnAceptar() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/dialog-ok-5.png"))); 
        this.setText("Aceptar");
        this.setToolTipText("Clic para aceptar...");  
        this.setMnemonic('A');
    }
}
