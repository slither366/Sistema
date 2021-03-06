package com.app.form.cont;

import com.app.clases.ClaseTeclas;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.frm_Padre;
import com.app.form.Especiales.frm_Padre.Metodos;
import java.awt.event.ActionEvent;

/**
 *
 * @author Diego
 */
public final class CotizacionSet extends frm_Padre implements Metodos {

    private String tablaConsutada, tituloVentanaActual;

    public CotizacionSet(int cod_ventana) {
        initComponents();
        this.setName("ContizacionSet");
        this.tablaConsutada = "cont_cotizacion_set";
        this.Cod_Ventana = cod_ventana;
        
        this.txtCod_Moneda.setBdTabla("ref_monedas");
        this.txtCod_Moneda.setBdCodigo("Mon_Codigo");
        this.txtCod_Moneda.setBdDescrip("Mon_Descrip");
        this.txtCod_Moneda.setBdTitulo("Monedas");
        this.txtCod_Moneda.setUsarEmpresa(true);
        this.txtCod_Moneda.setUsarSucursal(false);
        
        this.pnlTitulo.setTextTitulo("Mantenimiento de " + tituloVentanaActual + "...");
        this.txtCod_Moneda.setBdTabla("ref_monedas");
        this.txtCod_Moneda.setBdCodigo("Mon_Codigo");
        this.txtCod_Moneda.setBdDescrip("Mon_Descrip");
        this.txtCod_Moneda.setBdTitulo("Monedas");
        this.txtCompra.setFormatear(true);
        this.txtVenta.setFormatear(true);
        this.txtCompra.setInicializar(11, 2);
        this.txtVenta.setInicializar(11, 2);
        this.getPermisos(this.Cod_Ventana);
        this.pnlBotones.addListener(this);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlTitulo = new com.app.paleta.panelTitulo();
        pnlDatos = new com.app.paleta.panel();
        txtCod_Moneda = new com.app.paleta.txtCodigo();
        jLabel2 = new javax.swing.JLabel();
        lblMoneda = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new com.app.paleta.txtFecha();
        jLabel5 = new javax.swing.JLabel();
        txtCompra = new com.app.paleta.txtNumeros();
        jLabel6 = new javax.swing.JLabel();
        txtVenta = new com.app.paleta.txtNumeros();
        pnlBotones = new com.app.botones.pnlABM();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtCod_Moneda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_MonedaActionPerformed(evt);
            }
        });
        txtCod_Moneda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCod_MonedaKeyPressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Moneda");

        lblMoneda.setText("text");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha");

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Compra");

        txtCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCompraActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Venta");

        txtVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(txtCod_Moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMoneda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCod_Moneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(lblMoneda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCod_MonedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_MonedaActionPerformed
        int valor = this.txtCod_Moneda.verificarVacioConMsj();
        if (valor == 0) {
            String rs = getConexion.getDescripcion(this.txtCod_Moneda.getBdTabla(), this.txtCod_Moneda.getBdDescrip(),
                    new String[]{EMP_CODIGO, this.txtCod_Moneda.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Moneda.getText()});
            if (rs != null) {
                this.lblMoneda.setText(rs);
                this.txtFecha.setEnabled(true);
                this.txtFecha.grabFocus();
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCod_MonedaActionPerformed

    private void txtCod_MonedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_MonedaKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(txtCod_Moneda.getBdTabla(), true, false, txtCod_Moneda.getBdCodigo(), txtCod_Moneda.getBdDescrip(), txtCod_Moneda.getBdTitulo());
            this.txtCod_Moneda.requestFocus();
        }
    }//GEN-LAST:event_txtCod_MonedaKeyPressed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        int valor = this.txtFecha.verificarVacioConMsj();
        if (valor == 0) {
            this.txtFecha.setEnabled(false);
            if (Operacion == 'M' || Operacion == 'E') {
                this.RecuperarDatos(this.txtCod_Moneda.getText());
            } else {
                this.txtCompra.setEnabled(true);
                this.txtCompra.grabFocus();
            }
        } else {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCompraActionPerformed
        int valor = this.txtCompra.verificarVacioConMsj();
        if (valor == 0) {
            this.txtVenta.setEnabled(true);
            this.txtVenta.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCompraActionPerformed

    private void txtVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVentaActionPerformed
        int valor = this.txtVenta.verificarVacioConMsj();
        if (valor == 0) {
            this.pnlBotones.btnGrabar.setEnabled(true);
            this.pnlBotones.btnGrabar.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtVentaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMoneda;
    private com.app.botones.pnlABM pnlBotones;
    private com.app.paleta.panel pnlDatos;
    private com.app.paleta.panelTitulo pnlTitulo;
    private com.app.paleta.txtCodigo txtCod_Moneda;
    private com.app.paleta.txtNumeros txtCompra;
    private com.app.paleta.txtFecha txtFecha;
    private com.app.paleta.txtNumeros txtVenta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void Inicializar() {
        this.pnlDatos.setTextNull();
        this.lblMoneda.setText("");
        this.pnlDatos.setEnabled(false);
        this.pnlBotones.btnNuevo.setEnabled(Agrega_OK);
        this.pnlBotones.btnModificar.setEnabled(Modifica_OK);
        this.pnlBotones.btnBorrar.setEnabled(Borra_OK);
        this.pnlBotones.btnGrabar.setEnabled(false);
        this.pnlBotones.btnCancelar.setEnabled(false);
        this.pnlBotones.btnSalir.setEnabled(true);
        this.txtCod_Moneda.setBuscar(true);
        if (this.pnlBotones.btnNuevo.isEnabled()) {
            this.pnlBotones.btnNuevo.grabFocus();
        } else if (this.pnlBotones.btnModificar.isEnabled()) {
            this.pnlBotones.btnModificar.grabFocus();
        } else if (this.pnlBotones.btnBorrar.isEnabled()) {
            this.pnlBotones.btnBorrar.grabFocus();
        } else {
            this.pnlBotones.btnSalir.grabFocus();
        }
    }

    @Override
    public void Grabar() {
        if (this.pnlDatos.setValidate()) {
            MensajeSistema.validarVacio(this);
        } else {
            if (Operacion == 'A') {
                if (MensajeSistema.Guardar(this)) {
                    getConexion.insertar(tablaConsutada,
                            new String[]{EMP_CODIGO, this.txtCod_Moneda.getBdCodigo(), "fecha", "compra", "venta"},
                            new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Moneda.getText(),
                                this.txtFecha.getFecha(), this.txtCompra.getNumeroString(), this.txtVenta.getNumeroString()});
                }
            } else {
                if (MensajeSistema.Modificar(this)) {
                    getConexion.actualizar(tablaConsutada,
                            new String[]{EMP_CODIGO, this.txtCod_Moneda.getBdCodigo(), "fecha", "compra", "venta"},
                            new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Moneda.getText(),
                                this.txtFecha.getFecha(), this.txtCompra.getNumeroString(), this.txtVenta.getNumeroString()},
                            new String[]{EMP_CODIGO, this.txtCod_Moneda.getBdCodigo(), "fecha"},
                            new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Moneda.getText(), this.txtFecha.getFecha()});
                }
            }
            Inicializar();
        }
    }

    @Override
    public void Agregar() {
        this.pnlBotones.ModoEdicion(false);
        this.pnlBotones.btnGrabar.setEnabled(false);
        this.txtCod_Moneda.setEnabled(true);
        Operacion='A';
        this.txtCod_Moneda.grabFocus();
    }

    @Override
    public void Editar(char c) {
        Operacion=c;
        this.pnlBotones.ModoEdicion(false);
        this.txtCod_Moneda.setEnabled(true);
        this.pnlBotones.btnGrabar.setEnabled(false);
        this.txtCod_Moneda.grabFocus();
    }

    @Override
    public void RecuperarDatos(String codigo) {
        String[] rs = getConexion.getDescripciones("vst_" + tablaConsutada,
                new String[]{"compra", "venta"},
                new String[]{EMP_CODIGO, this.txtCod_Moneda.getBdCodigo(), "fecha"},
                new String[]{Configuracion.getEMP_CODIGO(), codigo, this.txtFecha.getFecha()});
        if (rs[0] != null) {
            txtCompra.setNumero(rs[0]);
            txtVenta.setNumero(rs[1]);
            if (Operacion == 'E') {
                this.Borrar(this, tablaConsutada,
                        new String[]{EMP_CODIGO, this.txtCod_Moneda.getBdCodigo(), "fecha"},
                        new String[]{Configuracion.getEMP_CODIGO(), codigo, this.txtFecha.getFecha()});
                Inicializar();
            } else {
                this.txtCompra.setEnabled(true);
                this.txtCompra.grabFocus();
            }
        } else {
            if (MensajeSistema.ConsultaSQLVacio(this)) {
                this.txtCod_Moneda.setText("");
                this.txtCod_Moneda.setEnabled(true);
                this.lblMoneda.setText("");
                this.txtFecha.setText("");
                this.txtCod_Moneda.grabFocus();
            } else {
                this.Inicializar();
            }
        }
    }
}
