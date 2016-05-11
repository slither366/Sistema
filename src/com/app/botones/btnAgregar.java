package com.app.botones;

/**
 *
 * @author Diego
 */
public class btnAgregar extends BotonMaestro {

    public btnAgregar() {
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/lista_add.png"))); 
        this.setText("Agregar");
        this.setToolTipText("Clic para Agregar nuevo Registro...");  
        this.setMnemonic('A');
    }
}
