package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnEditar extends BotonMaestro {

    public btnEditar() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/editar.png")));
        this.setText("Editar");
        this.setToolTipText("Editar Registros Exitentes...");
        this.setMnemonic('E');
    }
}
