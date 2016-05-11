package com.app.form;

import com.app.clases.ClaseTeclas;
import com.app.config.Configuracion;
import com.app.config.ConsultaSQL;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.frm_Padre;
import static com.app.form.Especiales.frm_Padre.EMP_CODIGO;
import com.app.form.Especiales.frm_Padre.Metodos;
import static com.app.form.Especiales.frm_Padre.getConexion;
import java.awt.event.ActionEvent;

/**
 *
 * @author dramosort
 */
public class Stock_Ajuste extends frm_Padre implements Metodos {

    public Stock_Ajuste(int cod_ventana) {
        initComponents();
        this.setName("Stock_Ajuste");
        this.UsarEmpresa = true;
        this.UsarSucursal = false;
        this.tablaConsutada = "stock_ajuste";
        this.idConsultada = "Ajus_Codigo";
        this.descripcionConsultada = "observacion";
        this.tituloVentanaActual = "Ajuste de Stock";
        this.pnlTitulo.setTextTitulo(tituloVentanaActual + "...");
        this.pnlTitulo.AlinearCentro();
        this.txtCod_Producto.setBdTabla("mant_productos");
        this.txtCod_Producto.setBdCodigo("Prod_Codigo");
        this.txtCod_Producto.setBdDescrip("Prod_Descrip");
        this.txtCod_Producto.setBdTitulo("Productos");
        this.txtCod_Lote.setBdTabla("mant_productos_lote");
        this.txtCod_Lote.setBdCodigo("Lot_Codigo");
        this.txtCod_Lote.setBdDescrip("nro_lote");
        this.txtCod_Lote.setBdTitulo("Lotes");
        this.tblAjuste.setAncho(new int[]{0, 1, 2, 3, 4, 5, 6}, new int[]{60, 0, 200, 0, 60, 60, 50});
        this.tblAjuste.setOcultar(new int[]{1,3});
        this.tblAjuste.formatearColumna(0, 0);
        this.tblAjuste.formatearColumna(4, 2);
        this.tblAjuste.setAlinearDerecha(new int[]{0, 4});
        this.txtCantidad.setInicializar(11, 2);
        this.txtCantidad.setFormatear(true);
        this.cboTipo.addItem("Entrada");
        this.cboTipo.addItem("Salida");
        this.getPermisosTransaccional(cod_ventana);
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

        jPanel1 = new javax.swing.JPanel();
        pnlTitulo = new com.app.paleta.panelTitulo();
        pnlDatos = new com.app.paleta.panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAjuste = new com.app.paleta.tabla();
        jLabel1 = new javax.swing.JLabel();
        txtCod_Ajuste = new com.app.paleta.txtCodigo();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new com.app.paleta.txtFecha();
        jLabel3 = new javax.swing.JLabel();
        txtObservacion = new com.app.paleta.txtTexto();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtNro_Reg = new com.app.paleta.txtCodigo();
        jLabel5 = new javax.swing.JLabel();
        txtCod_Producto = new com.app.paleta.txtCodigo();
        lblProducto = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCod_Lote = new com.app.paleta.txtCodigo();
        lblLote = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCantidad = new com.app.paleta.txtNumeros();
        jLabel10 = new javax.swing.JLabel();
        cboTipo = new com.app.paleta.combo();
        PanelADD = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnAgregar = new com.app.botones.btnAgregar();
        jLabel15 = new javax.swing.JLabel();
        pnlBotones = new com.app.botones.pnlTransacional();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblAjuste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nro Reg", "Producto", "Descripción", "Lote", "NroLote", "Cantidad", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAjuste);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Código");

        txtCod_Ajuste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_AjusteActionPerformed(evt);
            }
        });
        txtCod_Ajuste.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCod_AjusteKeyPressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Fecha");

        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Observación");

        txtObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservacionActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Nro Reg:");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Producto:");

        txtCod_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_ProductoActionPerformed(evt);
            }
        });
        txtCod_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCod_ProductoKeyPressed(evt);
            }
        });

        lblProducto.setText("jLabel6");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Lote:");

        txtCod_Lote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_LoteActionPerformed(evt);
            }
        });
        txtCod_Lote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCod_LoteKeyPressed(evt);
            }
        });

        lblLote.setText("jLabel6");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Cantidad:");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Tipo:");

        cboTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cboTipoKeyPressed(evt);
            }
        });

        PanelADD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setText("Enter para Agregar Nvo Asto");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setText("F5 para Grabar ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("F8 para Borrar");

        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setText("ESC para Cancelar");

        javax.swing.GroupLayout PanelADDLayout = new javax.swing.GroupLayout(PanelADD);
        PanelADD.setLayout(PanelADDLayout);
        PanelADDLayout.setHorizontalGroup(
            PanelADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelADDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelADDLayout.setVerticalGroup(
            PanelADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelADDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelADDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelADDLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15))
                    .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(txtCod_Ajuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNro_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlDatosLayout.createSequentialGroup()
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addComponent(txtCod_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblLote, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlDatosLayout.createSequentialGroup()
                                        .addComponent(txtCod_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addComponent(PanelADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCod_Ajuste, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNro_Reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtCod_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProducto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCod_Lote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLote))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(PanelADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(pnlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void txtCod_AjusteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_AjusteActionPerformed
        int valor = this.txtCod_Ajuste.verificarVacioConMsj();
        if (valor == 0) {
            if (operacion == 'M' || operacion == 'E') {
                this.RecuperarDatos(this.txtCod_Ajuste.getText());
            } else {
                this.txtObservacion.grabFocus();
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCod_AjusteActionPerformed

    private void txtCod_AjusteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_AjusteKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada, descripcionConsultada, tituloVentanaActual);
            this.txtCod_Ajuste.requestFocus();
        }
    }//GEN-LAST:event_txtCod_AjusteKeyPressed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        this.txtObservacion.grabFocus();
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservacionActionPerformed
        int valor = this.txtObservacion.verificarVacioConMsj();
        if (valor == 0) {
            this.btnAgregar.setEnabled(true);
            this.btnAgregar.grabFocus();
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtObservacionActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        this.NvoAsto();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyPressed
        int tecla = evt.getKeyCode();
        if (tecla == ClaseTeclas.VK_ENTER()) {
            this.NvoAsto();
        } else if (tecla == ClaseTeclas.VK_ESC()) {
            this.pnlBotones.btnCancelar.doClick();
        } else if (tecla == ClaseTeclas.VK_F5()) {
            this.pnlBotones.btnGrabar.setEnabled(this.tblAjuste.getRowCount() > 0);
        } else if (tecla == ClaseTeclas.VK_F8()) {
            this.BorrarAsto();
        }
    }//GEN-LAST:event_btnAgregarKeyPressed

    private void txtCod_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_ProductoActionPerformed
        int valor = this.txtCod_Producto.verificarVacioConMsj();
        if (valor == 0) {
            String rs = getConexion.getDescripcion(txtCod_Producto.getBdTabla(), txtCod_Producto.getBdDescrip(),
                    new String[]{EMP_CODIGO, txtCod_Producto.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), txtCod_Producto.getText()});
            if (rs != null) {
                this.lblProducto.setText(rs);
                this.txtCod_Lote.setEnabled(true);
                this.txtCod_Lote.grabFocus();
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Producto.setText("");
                    this.lblProducto.setText("");
                    this.txtCod_Producto.grabFocus();
                } else {
                    this.InicializarAsto();
                }
            }
        } else if (valor == 1) {
            this.InicializarAsto();
        }
    }//GEN-LAST:event_txtCod_ProductoActionPerformed

    private void txtCod_ProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_ProductoKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            this.Buscar(this.txtCod_Producto.getBdTabla(), true, false, this.txtCod_Producto.getBdCodigo(),
                    this.txtCod_Producto.getBdDescrip(), this.txtCod_Producto.getBdTitulo());
            this.txtCod_Producto.requestFocus();
        }
    }//GEN-LAST:event_txtCod_ProductoKeyPressed

    private void txtCod_LoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_LoteActionPerformed
        int valor = this.txtCod_Lote.verificarVacioConMsj();
        if (valor == 0) {
            String rs = getConexion.getDescripcion(txtCod_Lote.getBdTabla(), txtCod_Lote.getBdDescrip(),
                    new String[]{EMP_CODIGO, txtCod_Producto.getBdCodigo(), txtCod_Lote.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), txtCod_Producto.getText(), txtCod_Lote.getText()});
            if (rs != null) {
                this.lblLote.setText(rs);
                this.txtCantidad.setEnabled(true);
                this.txtCantidad.grabFocus();
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Lote.setText("");
                    this.lblLote.setText("");
                    this.txtCod_Lote.grabFocus();
                } else {
                    this.InicializarAsto();
                }
            }
        } else if (valor == 1) {
            this.InicializarAsto();
        }
    }//GEN-LAST:event_txtCod_LoteActionPerformed

    private void txtCod_LoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_LoteKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            String consulta = ConsultaSQL.getSelect(this.txtCod_Lote.getBdTabla(),
                    new String[]{this.txtCod_Lote.getBdDescrip(), this.txtCod_Lote.getBdCodigo()},
                    new String[]{"Descripción", "Código"},
                    new String[]{EMP_CODIGO, this.txtCod_Producto.getBdCodigo()},
                    new String[]{Configuracion.getEMP_CODIGO(), this.txtCod_Producto.getText()});
            Buscar(consulta, this.txtCod_Lote.getBdTitulo());
            this.txtCod_Lote.requestFocus();
        }
    }//GEN-LAST:event_txtCod_LoteKeyPressed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        if (this.txtCantidad.getNumeroDouble() > 0) {
            this.cboTipo.setEnabled(true);
            this.cboTipo.grabFocus();
        } else {
            int preg = MensajeSistema.Pregunta_YES_NO(this, "El valor debe ser mayor a cero...\nDesea reintentar?");
            if (preg == MensajeSistema.YES_OPTION()) {
                this.txtCantidad.setText("");
                this.txtCantidad.grabFocus();
            } else {
                this.InicializarAsto();
            }
        }
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void cboTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cboTipoKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_ENTER()) {
            this.AgregarAsto();
        }
    }//GEN-LAST:event_cboTipoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelADD;
    private com.app.botones.btnAgregar btnAgregar;
    private com.app.paleta.combo cboTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblLote;
    private javax.swing.JLabel lblProducto;
    private com.app.botones.pnlTransacional pnlBotones;
    private com.app.paleta.panel pnlDatos;
    private com.app.paleta.panelTitulo pnlTitulo;
    private com.app.paleta.tabla tblAjuste;
    private com.app.paleta.txtNumeros txtCantidad;
    private com.app.paleta.txtCodigo txtCod_Ajuste;
    private com.app.paleta.txtCodigo txtCod_Lote;
    private com.app.paleta.txtCodigo txtCod_Producto;
    private com.app.paleta.txtFecha txtFecha;
    private com.app.paleta.txtCodigo txtNro_Reg;
    private com.app.paleta.txtTexto txtObservacion;
    // End of variables declaration//GEN-END:variables

    @Override
    public final void Inicializar() {
        this.pnlDatos.setTextNull();
        this.pnlDatos.setEnabled(false);
        this.tblAjuste.vaciar();
        this.lblLote.setText("");
        this.lblProducto.setText("");
        this.btnAgregar.setEnabled(false);
        this.pnlBotones.btnNuevo.setEnabled(Agrega_OK);
        this.pnlBotones.btnConsultar.setEnabled(Listar_OK);
        this.pnlBotones.btnBorrar.setEnabled(Borra_OK);
        this.pnlBotones.btnGrabar.setEnabled(false);
        this.pnlBotones.btnCancelar.setEnabled(false);
        this.pnlBotones.btnSalir.setEnabled(true);
        if (this.pnlBotones.btnNuevo.isEnabled()) {
            this.pnlBotones.btnNuevo.grabFocus();
        } else if (this.pnlBotones.btnConsultar.isEnabled()) {
            this.pnlBotones.btnConsultar.grabFocus();
        } else if (this.pnlBotones.btnBorrar.isEnabled()) {
            this.pnlBotones.btnBorrar.grabFocus();
        } else {
            this.pnlBotones.btnSalir.grabFocus();
        }
    }

    @Override
    public void Grabar() {
        if (operacion == 'A') {
            if (MensajeSistema.Guardar(this)) {
                int cantidadRow = this.tblAjuste.getRowCount();
                this.getConexion.Begin();
                boolean correcto = getConexion.insertar(tablaConsutada,
                        new String[]{EMP_CODIGO, SUC_CODIGO, idConsultada, "fecha_emi", descripcionConsultada, "Usu_Codigo"},
                        new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), this.txtCod_Ajuste.getText(),
                            this.txtFecha.getFecha(), txtObservacion.getText().trim(), Configuracion.getUSU_CODIGO()});
                if (correcto) {
                    String[][] registros = new String[cantidadRow][8];
                    for (int i = 0; i < cantidadRow; i++) {
                        registros[i][0] = Configuracion.getEMP_CODIGO();
                        registros[i][1] = Configuracion.getSUC_CODIGO();
                        registros[i][2] = this.txtCod_Ajuste.getText();
                        registros[i][3] = this.tblAjuste.getValueAt(i, 0).toString();
                        registros[i][4] = this.tblAjuste.getValueAt(i, 1).toString();
                        registros[i][5] = this.tblAjuste.getValueAt(i, 3).toString();                       
                        registros[i][6] = this.tblAjuste.getValueAt(i, 5).toString();
                        registros[i][7] = this.tblAjuste.getValueAt(i, 6).toString().equals("Entrada") ? "1" : "2";
                    }
                    if (this.getConexion.insertar(tablaConsutada + "_det",
                            new String[]{EMP_CODIGO, SUC_CODIGO, idConsultada, "Nro_reg",
                                this.txtCod_Producto.getBdCodigo(), this.txtCod_Lote.getBdCodigo(), "cantidad", "tipo_Mov"},
                            registros, cantidadRow, 8) == false) {
                        this.getConexion.RollBack();
                    }
                }
                this.getConexion.Commit();
            }
        }
        Inicializar();
    }

    @Override
    public void Agregar() {
        if (getConexion.autoNumerico(tablaConsutada, idConsultada,
                new String[]{EMP_CODIGO, SUC_CODIGO},
                new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO()}, this.txtCod_Ajuste)) {
            this.pnlBotones.ModoEdicion(false);
            this.pnlBotones.btnGrabar.setEnabled(false);
            operacion = 'A';
            this.txtCod_Ajuste.setEnabled(false);
            this.txtFecha.setEnabled(true);
            this.txtObservacion.setEnabled(true);
            this.txtFecha.setFechaActual();
            this.txtObservacion.grabFocus();
        } else {
            Inicializar();
        }
    }

    public void AgregarAsto() {
        Object[] valores = new Object[7];
        valores[0] = this.txtNro_Reg.getText();
        valores[1] = this.txtCod_Producto.getText();
        valores[2] = this.lblProducto.getText();
        valores[3] = this.txtCod_Lote.getText();
        valores[4] = this.lblLote.getText();
        valores[5] = this.txtCantidad.getNumeroString();
        valores[6] = this.cboTipo.getSelectDescri();
        this.tblAjuste.cargarDatos(valores);
        this.InicializarAsto();
    }

    public void NvoAsto() {
        this.txtNro_Reg.setCodigo((int) this.tblAjuste.getMAX(0) + 1);
        this.txtCod_Lote.setText("");
        this.lblProducto.setText("");
        this.lblLote.setText("");
        this.txtCantidad.setText("");
        this.cboTipo.setSelectedIndex(0);
        this.txtNro_Reg.setEnabled(false);
        this.txtCod_Producto.setEnabled(true);
        this.txtCod_Producto.grabFocus();
    }

    public void BorrarAsto() {
        int seleccion = this.tblAjuste.getSelectedRow();
        if (seleccion > 0) {
            int preg = MensajeSistema.Pregunta_YES_NO(this, "Esta seguro que quiere quitar este registro?");
            if (preg == MensajeSistema.YES_OPTION()) {
                this.tblAjuste.remover();
            }
        }
    }

    public void InicializarAsto() {
        this.txtNro_Reg.setText("");
        this.txtCod_Producto.setText("");
        this.txtCod_Lote.setText("");
        this.lblProducto.setText("");
        this.lblLote.setText("");
        this.txtCantidad.setText("");
        this.cboTipo.setSelectedIndex(0);
        this.txtNro_Reg.setEnabled(false);
        this.txtCod_Producto.setEnabled(false);
        this.txtCod_Lote.setEnabled(false);
        this.txtCantidad.setEnabled(false);
        this.cboTipo.setEnabled(false);
        this.btnAgregar.setEnabled(true);
        this.btnAgregar.grabFocus();
    }

    @Override
    public void Editar(char c) {
        operacion = c;
        this.pnlBotones.ModoEdicion(false);
        this.txtCod_Ajuste.setEnabled(true);
        this.pnlBotones.btnGrabar.setEnabled(false);
        this.txtCod_Ajuste.grabFocus();
    }

    @Override
    public void RecuperarDatos(String codigo) {

    }
}
