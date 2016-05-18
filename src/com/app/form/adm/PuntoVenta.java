package com.app.form.adm;

import com.app.config.MensajeSistema;
import com.app.form.Especiales.frm_Padre;
import com.app.form.Especiales.frm_Padre.Metodos;
import java.awt.event.ActionEvent;

/**
 *
 * @author dramosort
 */
public final class PuntoVenta extends frm_Padre implements Metodos {

    public PuntoVenta(int cod_ventana) {
        initComponents();
        this.setName("PtoVta");

        this.getPermisos(cod_ventana);
        this.pnlABM.addListener(this);
        this.Inicializar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String Orden = e.getActionCommand();
        if (Orden.compareTo("btn1") == 0) {
            Agregar();
        } else if (Orden.compareTo("btn2") == 0) {
            Editar('M');
        } else if (Orden.compareTo("btn3") == 0) {
            Editar('E');
        } else if (Orden.compareTo("btn4") == 0) {
            Grabar();
        } else if (Orden.compareTo("btn5") == 0) {
            if (MensajeSistema.Cancelar(this)) {
                this.Inicializar();
            }
        } else if (Orden.compareTo("btn6") == 0) {
            Salir(this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlTitulo = new com.app.paleta.panelTitulo();
        pnlDatos = new com.app.paleta.panel();
        pnlABM = new com.app.botones.pnlABM();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlABM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlABM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private com.app.botones.pnlABM pnlABM;
    private com.app.paleta.panel pnlDatos;
    private com.app.paleta.panelTitulo pnlTitulo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Inicializar() {
        this.pnlDatos.setTextNull();
        this.pnlDatos.setEnabled(false);
        this.pnlABM.btnNuevo.setEnabled(Agrega_OK);
        this.pnlABM.btnModificar.setEnabled(Modifica_OK);
        this.pnlABM.btnBorrar.setEnabled(Borra_OK);
        this.pnlABM.btnGrabar.setEnabled(false);
        this.pnlABM.btnCancelar.setEnabled(false);
        this.pnlABM.btnSalir.setEnabled(true);
        if (this.pnlABM.btnNuevo.isEnabled()) {
            this.pnlABM.btnNuevo.grabFocus();
        } else if (this.pnlABM.btnModificar.isEnabled()) {
            this.pnlABM.btnModificar.grabFocus();
        } else if (this.pnlABM.btnBorrar.isEnabled()) {
            this.pnlABM.btnBorrar.grabFocus();
        } else {
            this.pnlABM.btnSalir.grabFocus();
        }
    }

    @Override
    public void Grabar() {
        
    }

    @Override
    public void Agregar() {
        
    }

    @Override
    public void Editar(char c) {
        
    }

    @Override
    public void RecuperarDatos(String codigo) {
        
    }
}
