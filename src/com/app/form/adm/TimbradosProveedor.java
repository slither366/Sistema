package com.app.form.adm;

import com.app.clases.ClaseFecha;
import com.app.clases.ClaseTeclas;
import com.app.config.Configuracion;
import com.app.config.ConsultaSQL;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.frm_Padre;
import com.app.form.Especiales.frm_Padre.Metodos;
import java.awt.event.ActionEvent;

/**
 *
 * @author dramosort
 */
public final class TimbradosProveedor extends frm_Padre implements Metodos {

    String tablaConsultada, idConsultada, TituloVentanaActual;
    String Prov_Codigo = "Prov_Codigo";

    public TimbradosProveedor(int cod_ventana) {
        initComponents();
        this.setName("timbradosProv");
        this.txtCod_Proveedor.setBdTabla("mant_contactos");
        this.txtCod_Proveedor.setBdCodigo("Cont_Codigo");
        this.txtCod_Proveedor.setBdDescrip("razon_social");
        this.txtCod_Proveedor.setBdTitulo("Proveedores");
        this.txtCod_Proveedor.setUsarEmpresa(true);
        this.txtCod_Proveedor.setUsarSucursal(false);

        this.tablaConsultada = "adm_timbrado_proveedor";
        this.idConsultada = "num_tim";
        this.TituloVentanaActual = "Timbrados de Proveedor";

        this.txtNumTim.setInicializar(8, 0);
        this.txtNumDesde.setFormatoCantidad(3);
        this.txtNumHasta.setFormatoCantidad(3);
        this.txtTexto1.setEnMayuscula(true);
        this.txtTexto1.setEditable(false);
        this.pnlTitulo.setTextTitulo("Mantenimiento de " + TituloVentanaActual + "...");
        this.pnlABM.addListener(this);
        this.getPermisos(cod_ventana);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCod_Proveedor = new com.app.paleta.txtCodigo();
        txtNumTim = new com.app.paleta.txtNumeros();
        txtFecDesde = new com.app.paleta.txtFecha();
        txtFecHasta = new com.app.paleta.txtFecha();
        jLabel5 = new javax.swing.JLabel();
        txtNumDesde = new com.app.paleta.txtNumerosFormato();
        txtNumHasta = new com.app.paleta.txtNumerosFormato();
        jLabel6 = new javax.swing.JLabel();
        txtTexto1 = new com.app.paleta.txtTexto();
        pnlABM = new com.app.botones.pnlABM();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Proveedor:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Timbrado:");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Hasta:");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Fecha Desde:");

        txtCod_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_ProveedorActionPerformed(evt);
            }
        });

        txtNumTim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumTimFocusGained(evt);
            }
        });
        txtNumTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumTimActionPerformed(evt);
            }
        });
        txtNumTim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNumTimKeyPressed(evt);
            }
        });

        txtFecDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFecDesdeKeyPressed(evt);
            }
        });

        txtFecHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFecHastaKeyPressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nro Desde:");

        txtNumDesde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumDesdeActionPerformed(evt);
            }
        });

        txtNumHasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumHastaActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Hasta:");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCod_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTexto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCod_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTexto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtFecHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtNumHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtNumDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(pnlABM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCod_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_ProveedorActionPerformed
        int valor = this.txtCod_Proveedor.verificarVacioConMsj();
        if (valor == 0) {
            String rs = this.txtCod_Proveedor.getDescripcion();
            if (rs != null) {
                this.txtTexto1.setText(rs);
                this.txtNumTim.setEnabled(true);
                this.txtNumTim.grabFocus();
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Proveedor.setText("");
                    this.txtTexto1.setText("");
                    this.txtCod_Proveedor.grabFocus();
                } else {
                    this.Inicializar();
                }
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCod_ProveedorActionPerformed

    private void txtNumTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumTimActionPerformed
        int valor = this.txtCod_Proveedor.verificarVacioConMsj();
        if (valor == 0) {
            if (this.txtNumTim.getText().length() != 8) {
                int msn = MensajeSistema.MensajeOpciones(this, "La longitud debe de ser 8 Números.\nDesea Reintentar?",
                        new Object[]{"Reintentar", "Cancelar"}, 0);
                if (msn == 0) {
                    this.requestFocus();
                } else {
                    this.Inicializar();
                }
            } else {
                if (Operacion == 'A') {
                    this.txtFecDesde.setEnabled(true);
                    this.txtFecDesde.grabFocus();
                } else {
                    this.RecuperarDatos(this.txtNumTim.getText());
                }
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtNumTimActionPerformed

    private void txtFecDesdeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecDesdeKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_ENTER()) {
            int valor = this.txtFecDesde.verificarVacioConMsj();
            if (valor == 0) {
                this.txtFecHasta.setEnabled(true);
                this.txtFecHasta.grabFocus();
            } else if (valor == 1) {
                this.Inicializar();
            }
        }
    }//GEN-LAST:event_txtFecDesdeKeyPressed

    private void txtFecHastaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFecHastaKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_ENTER()) {
            int valor = this.txtFecDesde.verificarVacioConMsj();
            if (valor == 0) {
                long dif = ClaseFecha.getDiferenciasDeFechas(this.txtFecDesde.getFechaD(), this.txtFecHasta.getFechaD());
                if (dif > 0) {
                    this.txtNumDesde.setEnabled(true);
                    this.txtNumDesde.grabFocus();
                } else {
                    int msn = MensajeSistema.MensajeOpciones(this, "La Fecha Hasta debe ser Mayor a la Fecha Desde.\nDesea Reintentar?",
                            new Object[]{"Reintentar", "Cancelar"}, 0);
                    if (msn == 0) {
                        this.txtFecHasta.setText("");
                        this.txtFecHasta.grabFocus();
                    } else {
                        this.Inicializar();
                    }
                }
            } else if (valor == 1) {
                this.Inicializar();
            }
        }
    }//GEN-LAST:event_txtFecHastaKeyPressed

    private void txtNumDesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumDesdeActionPerformed
        int valor = this.txtNumDesde.verificarVacioConMsj();
        if (valor == 0) {
            if (this.txtNumDesde.getNumeroInt() > 0) {
                this.txtNumHasta.setEnabled(true);
                this.txtNumHasta.grabFocus();
            } else {
                int msn = MensajeSistema.MensajeOpciones(this, "Debe ser mayor a Cero.\nDesea Reintentar?",
                        new Object[]{"Reintentar", "Cancelar"}, 0);
                if (msn == 0) {
                    this.txtNumDesde.setText("");
                    this.txtNumDesde.grabFocus();
                } else {
                    this.Inicializar();
                }
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtNumDesdeActionPerformed

    private void txtNumHastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumHastaActionPerformed
        int valor = this.txtNumHasta.verificarVacioConMsj();
        if (valor == 0) {
            if (this.txtNumHasta.getNumeroInt() > 0) {
                if (this.txtNumHasta.getNumeroInt() <= this.txtNumDesde.getNumeroInt()) {
                    int msn = MensajeSistema.MensajeOpciones(this, "El Hasta debe ser Mayor al Desde.\nDesea Reintentar?",
                            new Object[]{"Reintentar", "Cancelar"}, 0);
                    if (msn == 0) {
                        this.txtNumHasta.setText("");
                        this.txtNumHasta.grabFocus();
                    } else {
                        this.Inicializar();
                    }
                } else {
                    this.pnlABM.btnGrabar.setEnabled(true);
                    this.pnlABM.btnGrabar.grabFocus();
                }
            } else {
                int msn = MensajeSistema.MensajeOpciones(this, "Debe ser mayor a Cero.\nDesea Reintentar?",
                        new Object[]{"Reintentar", "Cancelar"}, 0);
                if (msn == 0) {
                    this.txtNumHasta.setText("");
                    this.txtNumHasta.grabFocus();
                } else {
                    this.Inicializar();
                }
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtNumHastaActionPerformed

    private void txtNumTimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumTimKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            if (Operacion != 'A') {
                String sql = ConsultaSQL.getSelect(tablaConsultada,
                        new String[]{"fec_hasta", idConsultada},
                        new String[]{"Vencimiento", "Timbrado"},
                        new String[]{EMP_CODIGO, Prov_Codigo},
                        new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Proveedor.getText()},
                        new String[]{"fec_hasta"});
                this.Buscar(sql, TituloVentanaActual);
                this.txtNumTim.requestFocus();
            }
        }
    }//GEN-LAST:event_txtNumTimKeyPressed

    private void txtNumTimFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumTimFocusGained
        if (Operacion != 'A') {
            if (!Configuracion.getCODIGO_BUSCAR().isEmpty()) {
                this.txtNumTim.setText(Configuracion.getCODIGO_BUSCAR());
                Configuracion.setCODIGO_BUSCAR("");
            }
            this.txtNumTim.selectAll();
        }
    }//GEN-LAST:event_txtNumTimFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private com.app.botones.pnlABM pnlABM;
    private com.app.paleta.panel pnlDatos;
    private com.app.paleta.panelTitulo pnlTitulo;
    private com.app.paleta.txtCodigo txtCod_Proveedor;
    private com.app.paleta.txtFecha txtFecDesde;
    private com.app.paleta.txtFecha txtFecHasta;
    private com.app.paleta.txtNumerosFormato txtNumDesde;
    private com.app.paleta.txtNumerosFormato txtNumHasta;
    private com.app.paleta.txtNumeros txtNumTim;
    private com.app.paleta.txtTexto txtTexto1;
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
        this.txtCod_Proveedor.setBuscar(true);
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
        String vProv = this.txtCod_Proveedor.getText();
        String vTim = this.txtNumTim.getText().trim();
        String vFDes = this.txtFecDesde.getFecha();
        String vFHas = this.txtFecHasta.getFecha();
        String vNDes = this.txtNumDesde.getNumeroString();
        String vNHas = this.txtNumHasta.getNumeroString();
        if (Operacion == 'A') {
            getConexion.insertar(this.tablaConsultada,
                    new String[]{EMP_CODIGO, Prov_Codigo,
                        idConsultada, "fec_desde", "fec_hasta", "nro_desde", "nro_hasta", "Usu_Codigo"},
                    new String[]{Configuracion.getEMP_CODIGO(),
                        vProv, vTim, vFDes, vFHas, vNDes, vNHas, Configuracion.getUSU_CODIGO()});
        } else if (Operacion == 'M') {
            getConexion.actualizar(this.tablaConsultada,
                    new String[]{"fec_desde", "fec_hasta", "nro_desde", "nro_hasta"},
                    new String[]{vFDes, vFHas, vNDes, vNHas},
                    new String[]{EMP_CODIGO, Prov_Codigo, idConsultada},
                    new String[]{Configuracion.getEMP_CODIGO(), vProv, vTim});
        }
        Inicializar();
    }

    @Override
    public void Agregar() {
        Operacion = 'A';
        this.pnlABM.ModoEdicion(false);
        this.txtCod_Proveedor.setEnabled(true);
        this.pnlABM.btnGrabar.setEnabled(false);
        this.txtCod_Proveedor.grabFocus();
    }

    @Override
    public void Editar(char c) {
        Operacion = c;
        this.pnlABM.ModoEdicion(false);
        this.txtCod_Proveedor.setEnabled(true);
        this.pnlABM.btnGrabar.setEnabled(false);
        this.txtCod_Proveedor.grabFocus();
    }

    @Override
    public void RecuperarDatos(String codigo) {
        String[] resultado = getConexion.getDescripciones(this.tablaConsultada,
                new String[]{"fec_desde", "fec_hasta", "nro_desde", "nro_hasta"},
                new String[]{EMP_CODIGO, Prov_Codigo, idConsultada},
                new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Proveedor.getText(), codigo});
        if (resultado[0] != null) {
            txtFecDesde.setFecha(resultado[0]);
            txtFecHasta.setFecha(resultado[1]);
            txtNumDesde.setNumero(resultado[2]);
            txtNumHasta.setNumero(resultado[3]);
            if (Operacion == 'E') {
                this.Borrar(this, tablaConsultada,
                        new String[]{EMP_CODIGO, Prov_Codigo, idConsultada},
                        new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Proveedor.getText(), codigo});
                Inicializar();
            } else {
                this.txtFecDesde.setEnabled(true);
                this.txtFecDesde.grabFocus();
            }
        } else {
            if (MensajeSistema.ConsultaSQLVacio(this)) {
                this.txtNumTim.setText("");
                this.txtNumTim.setEnabled(true);
                this.txtNumTim.grabFocus();
            } else {
                this.Inicializar();
            }
        }
    }
}