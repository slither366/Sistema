package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnCancelar extends BotonMaestro {

    public btnCancelar() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/dialog-cancel-2.png"))); 
        this.setText("Cancelar");
        this.setToolTipText("Clic para Cancelar el Proceso Actual..."); 
        this.setMnemonic('C');
    }
}
