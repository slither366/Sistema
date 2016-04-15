package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnModificar extends BotonMaestro {

    public btnModificar() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/editar.png")));
        this.setText("Modificar");
        this.setToolTipText("Modificar Registros Exitentes...");
        this.setMnemonic('M');
    }
}
