package com.app.form.Especiales;

import com.app.clases.utilidades.Excel;
import com.app.clases.ClaseBotones;
import com.app.clases.ClaseTeclas;
import com.app.clases.GenerarReportes;
import com.app.config.Configuracion;
import com.app.config.ConsultaSQL;
import com.app.config.MensajeSistema;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Diego
 */
public class Listar extends frm_Padre {

    String desde, hasta;
    String descripcionForaneo, tituloVentanaForaneo;
    GenerarReportes reportes = new GenerarReportes();
    String Reporte;
    int foraneo;//0:listado cualquiera, 1: dos campos, 2: tres campos sin FK, 3:tres campos con FK        
    private String[] Campos;
    private String[] Nombres;

    /**
     * Listar para dos campos
     *
     * @param tabla
     * @param Empresa
     * @param cod_ventana
     * @param Sucursal
     * @param codigo
     * @param descripcion
     * @param titulo
     */
    public Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal, String codigo,
            String descripcion, String titulo) {
        initComponents();
        this.setName("listar" + titulo);
        this.tablaConsutada = tabla;
        this.UsarEmpresa = Empresa;
        this.UsarSucursal = Sucursal;
        this.idConsultada = codigo;
        this.descripcionConsultada = descripcion;
        this.tituloVentanaActual = titulo;
        this.Reporte = "";
        this.textTitulo.setText("Listado de " + tituloVentanaActual + "...");
        foraneo = 1;
        ClaseBotones.botonesReporte(btnReporNuevo, btnReporPantalla, btnReporImpresora, btnReporExportar, btnReporCancelar, btnReporSalir);
        this.getPermisosListar(cod_ventana);
        this.Inicializar();
    }

    /**
     * Listar para tres campos SIN Campos Foraneos
     *
     * @param tabla
     * @param cod_ventana
     * @param Empresa
     * @param Sucursal
     * @param codigo
     * @param descripcion
     * @param titulo
     * @param descripcion2
     * @param tituloDescri2
     */
    public Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal, String codigo, String descripcion, String titulo,
            String descripcion2, String tituloDescri2) {
        initComponents();
        this.setName("listar" + titulo);
        this.tablaConsutada = tabla;
        this.UsarEmpresa = Empresa;
        this.UsarSucursal = Sucursal;
        this.idConsultada = codigo;
        this.descripcionConsultada = descripcion;
        this.tituloVentanaActual = titulo;
        this.Reporte = "";
        this.descripcionForaneo = descripcion2;
        this.tituloVentanaForaneo = tituloDescri2;
        this.textTitulo.setText("Listado de " + tituloVentanaActual + "...");
        foraneo = 2;
        ClaseBotones.botonesReporte(btnReporNuevo, btnReporPantalla, btnReporImpresora, btnReporExportar, btnReporCancelar, btnReporSalir);
        this.getPermisosListar(cod_ventana);
        this.Inicializar();
    }

    /**
     * Listar para tres campos
     *
     * @param cod_ventana CON Campo Foraneo
     *
     * @param tabla
     * @param Empresa
     * @param Sucursal
     * @param codigo
     * @param descripcion
     * @param titulo
     * @param idForaneo
     * @param descripcionForaneo
     * @param tituloForaneo
     */
    public Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal, String codigo, String descripcion, String titulo,
            String idForaneo, String descripcionForaneo, String tituloForaneo) {
        initComponents();
        this.setName("listar" + titulo);
        this.tablaConsutada = tabla;
        this.UsarEmpresa = Empresa;
        this.UsarSucursal = Sucursal;
        this.idConsultada = codigo;
        this.tituloVentanaActual = titulo;
        this.Reporte = "";
        this.descripcionConsultada = descripcion;
        this.descripcionForaneo = descripcionForaneo;
        this.tituloVentanaForaneo = tituloForaneo;
        this.textTitulo.setText("Listado de " + tituloVentanaActual + "...");
        foraneo = 3;
        ClaseBotones.botonesReporte(btnReporNuevo, btnReporPantalla, btnReporImpresora, btnReporExportar, btnReporCancelar, btnReporSalir);
        this.getPermisosListar(cod_ventana);
        this.Inicializar();
    }

    /**
     * Listar para tres campos
     *
     * @param cod_ventana CON Campo Foraneo
     *
     * @param tabla
     * @param Empresa
     * @param Sucursal
     * @param codigo
     * @param descripcion
     * @param titulo
     * @param reporte
     * @param campos
     * @param nombres
     */
    public Listar(String tabla, int cod_ventana, boolean Empresa, boolean Sucursal, String codigo, String descripcion, String titulo,
            String reporte, String[] campos, String[] nombres) {
        initComponents();
        this.setName("listar" + titulo);
        this.tablaConsutada = tabla;
        this.UsarEmpresa = Empresa;
        this.UsarSucursal = Sucursal;
        this.idConsultada = codigo;
        this.descripcionConsultada = descripcion;
        this.tituloVentanaActual = titulo;
        this.Reporte = reporte;
        this.Campos = campos;
        this.Nombres = nombres;
        this.textTitulo.setText("Listado de " + tituloVentanaActual + "...");
        foraneo = 0;
        ClaseBotones.botonesReporte(btnReporNuevo, btnReporPantalla, btnReporImpresora, btnReporExportar, btnReporCancelar, btnReporSalir);
        this.getPermisosListar(cod_ventana);
        this.Inicializar();
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
        jPanelTitulo = new javax.swing.JPanel();
        textTitulo = new javax.swing.JLabel();
        jPanelDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textDesde = new javax.swing.JLabel();
        textHasta = new javax.swing.JLabel();
        txtCod_Desde = new com.app.paleta.txtCodigo();
        txtCod_Hasta = new com.app.paleta.txtCodigo();
        jPanelBotones = new javax.swing.JPanel();
        btnReporNuevo = new com.app.botones.btnNuevo();
        btnReporPantalla = new com.app.botones.btnPantalla();
        btnReporImpresora = new com.app.botones.btnImpresora();
        btnReporExportar = new com.app.botones.btnExportar();
        btnReporCancelar = new com.app.botones.btnCancelar();
        btnReporSalir = new com.app.botones.btnSalir();

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTitulo.setMaximumSize(new java.awt.Dimension(552, 60));
        jPanelTitulo.setMinimumSize(new java.awt.Dimension(552, 60));
        jPanelTitulo.setName(""); // NOI18N
        jPanelTitulo.setPreferredSize(new java.awt.Dimension(552, 60));

        textTitulo.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        textTitulo.setText("TITULO...");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Desde:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Hasta:");

        textDesde.setText("desde");

        textHasta.setText("hasta");

        txtCod_Desde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_DesdeActionPerformed(evt);
            }
        });
        txtCod_Desde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCod_DesdeKeyPressed(evt);
            }
        });

        txtCod_Hasta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCod_HastaActionPerformed(evt);
            }
        });
        txtCod_Hasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCod_HastaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCod_Desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCod_Hasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCod_Desde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textDesde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtCod_Hasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelBotones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnReporNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporNuevoActionPerformed(evt);
            }
        });

        btnReporPantalla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporPantallaActionPerformed(evt);
            }
        });

        btnReporImpresora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporImpresoraActionPerformed(evt);
            }
        });

        btnReporExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporExportarActionPerformed(evt);
            }
        });

        btnReporCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporCancelarActionPerformed(evt);
            }
        });

        btnReporSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBotonesLayout = new javax.swing.GroupLayout(jPanelBotones);
        jPanelBotones.setLayout(jPanelBotonesLayout);
        jPanelBotonesLayout.setHorizontalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnReporNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReporSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBotonesLayout.setVerticalGroup(
            jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporPantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporImpresora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporExportar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBotones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void txtCod_DesdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_DesdeActionPerformed
        int valor = this.txtCod_Desde.verificarVacioConMsj();
        if (valor == 0) {
            String registro;
            if (UsarEmpresa && UsarSucursal) {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{cod_empresa, cod_sucursal, idConsultada},
                        new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), this.txtCod_Desde.getText()});
            } else if (UsarEmpresa) {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{cod_empresa, idConsultada},
                        new String[]{Configuracion.getCOD_EMPRESA(), this.txtCod_Desde.getText()});
            } else {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{idConsultada}, new String[]{this.txtCod_Desde.getText()});
            }
            if (registro == null) {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Desde.setText("");
                    this.txtCod_Desde.grabFocus();
                } else {
                    this.Inicializar();
                }
            } else {
                this.textDesde.setText(registro);
                this.txtCod_Hasta.setText(hasta);
                this.txtCod_Hasta.grabFocus();
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCod_DesdeActionPerformed

    private void btnReporNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporNuevoActionPerformed
        this.Agregar();
    }//GEN-LAST:event_btnReporNuevoActionPerformed

    private void btnReporPantallaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporPantallaActionPerformed
        this.Reporte('P');
    }//GEN-LAST:event_btnReporPantallaActionPerformed

    private void btnReporImpresoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporImpresoraActionPerformed
        this.Reporte('I');
    }//GEN-LAST:event_btnReporImpresoraActionPerformed

    private void txtCod_HastaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCod_HastaActionPerformed
        int valor = this.txtCod_Hasta.verificarVacioConMsj();
        if (valor == 0) {
            String registro;
            if (UsarEmpresa && UsarSucursal) {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{cod_empresa, cod_sucursal, idConsultada},
                        new String[]{Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), this.txtCod_Hasta.getText()});
            } else if (UsarEmpresa) {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{cod_empresa, idConsultada},
                        new String[]{Configuracion.getCOD_EMPRESA(), this.txtCod_Hasta.getText()});
            } else {
                registro = getConexion.getDescripcion(tablaConsutada, descripcionConsultada,
                        new String[]{idConsultada}, new String[]{this.txtCod_Hasta.getText()});
            }
            if (registro == null) {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Hasta.setText("");
                    this.txtCod_Hasta.grabFocus();
                } else {
                    this.Inicializar();
                }
            } else {
                this.textHasta.setText(registro);
                this.btnReporPantalla.setEnabled(true);
                this.btnReporImpresora.setEnabled(true);
                this.btnReporPantalla.grabFocus();
            }
        } else if (valor == 1) {
            this.Inicializar();
        }
    }//GEN-LAST:event_txtCod_HastaActionPerformed

    private void btnReporCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporCancelarActionPerformed
        if (MensajeSistema.Cancelar()) {
            this.Inicializar();
        }
    }//GEN-LAST:event_btnReporCancelarActionPerformed

    private void btnReporSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporSalirActionPerformed
        this.Salir(this);
    }//GEN-LAST:event_btnReporSalirActionPerformed

    private void txtCod_DesdeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_DesdeKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada, descripcionConsultada, tituloVentanaActual);
            this.txtCod_Desde.requestFocus();
        }
    }//GEN-LAST:event_txtCod_DesdeKeyPressed

    private void txtCod_HastaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCod_HastaKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar(tablaConsutada, UsarEmpresa, UsarSucursal, idConsultada, descripcionConsultada, tituloVentanaActual);
            this.txtCod_Hasta.requestFocus();
        }
    }//GEN-LAST:event_txtCod_HastaKeyPressed

    private void btnReporExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporExportarActionPerformed
        this.Reporte('E');
    }//GEN-LAST:event_btnReporExportarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.botones.btnCancelar btnReporCancelar;
    private com.app.botones.btnExportar btnReporExportar;
    private com.app.botones.btnImpresora btnReporImpresora;
    private com.app.botones.btnNuevo btnReporNuevo;
    private com.app.botones.btnPantalla btnReporPantalla;
    private com.app.botones.btnSalir btnReporSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBotones;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JLabel textDesde;
    private javax.swing.JLabel textHasta;
    private javax.swing.JLabel textTitulo;
    private com.app.paleta.txtCodigo txtCod_Desde;
    private com.app.paleta.txtCodigo txtCod_Hasta;
    // End of variables declaration//GEN-END:variables

    private void Inicializar() {
        this.txtCod_Desde.setText("");
        this.txtCod_Hasta.setText("");
        this.textDesde.setText("");
        this.textHasta.setText("");
        ModoEdicion(false);
        if (this.Listar_OK == false) {
            this.btnReporNuevo.setEnabled(Listar_OK);
        }
        desde = "";
        hasta = "";
        this.btnReporNuevo.grabFocus();
    }

    private void ModoEdicion(boolean x) {
        this.txtCod_Desde.setEnabled(x);
        this.txtCod_Hasta.setEnabled(x);
        this.btnReporNuevo.setEnabled(!x);
        this.btnReporPantalla.setEnabled(x);
        this.btnReporImpresora.setEnabled(x);
        this.btnReporExportar.setEnabled(x);
        this.btnReporCancelar.setEnabled(x);
        this.btnReporSalir.setEnabled(!x);
    }

    public void Agregar() {
        operacion = 'A';
        int x = getConexion.getMIN(tablaConsutada, idConsultada, null, null);
        if (x >= 0) {
            int y = getConexion.getMAX(tablaConsutada, idConsultada, null, null);
            if (y >= 0) {
                desde = String.valueOf(x);
                hasta = String.valueOf(y);
                this.ModoEdicion(true);
                this.btnReporPantalla.setEnabled(false);
                this.btnReporImpresora.setEnabled(false);
                this.txtCod_Desde.setText(desde);
                this.txtCod_Desde.grabFocus();
            }
        }
    }

    public void Reporte(char modalidad) {
        try {
            ResultSet resu = traerDatos();
            if (resu.next()) {
                if (modalidad == 'E') {//Exportar
                    resu.beforeFirst();
                    Excel excel = new Excel();
                    excel.export(getConexion.getDefaultTableModel(resu), this.tituloVentanaActual);
                    if (MensajeSistema.Pregunta_YES_NO(this, "Desea abrir el archivo exportado???") == 0) {
                        excel.AbrirUltimo();
                    }
                    this.Inicializar();
                } else {
                    String xdesde = this.textDesde.getText().trim() + " (" + desde + ")";
                    String xhasta = this.textHasta.getText().trim() + " (" + hasta + ")";
                    Inicializar();
                    if (foraneo == 0) {//Reporte especiales, donde se envia la ubicacion del reporte
                        reportes.mostrarReporteVentana(resu, frm_Padre.ubicacionReport + this.Reporte, xdesde, xhasta, modalidad, tituloVentanaActual);
                    } else {// Reportes predetermiandos de campos predefinidos
                        if (foraneo == 1) {
                            reportes.listadoDosCampos(resu, tituloVentanaActual, xdesde, xhasta, modalidad);
                        } else {
                            reportes.listadoTresCampos(resu, tituloVentanaActual, xdesde, xhasta, modalidad, tituloVentanaForaneo);
                        }
                    }
                }
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCod_Desde.setText("");
                    this.txtCod_Hasta.setText("");
                    this.textDesde.setText("");
                    this.textHasta.setText("");
                    this.txtCod_Desde.grabFocus();
                } else {
                    Inicializar();
                }
            }
        } catch (SQLException ex) {
            MensajeSistema.setSQLException(ex);
        }
    }

    private ResultSet traerDatos() {
        String[] campo, nombre;
        String tabla;
        if (foraneo == 1) {
            campo = new String[]{idConsultada, descripcionConsultada};
            nombre = new String[]{"codigo", "descripcion"};
            tabla = tablaConsutada;
        } else if (foraneo == 2) {
            campo = new String[]{idConsultada, descripcionConsultada, descripcionForaneo};
            nombre = new String[]{"codigo", "descripcion", "referencia"};
            tabla = tablaConsutada;
        } else if (foraneo == 3) {
            campo = new String[]{idConsultada, descripcionConsultada, descripcionForaneo};
            nombre = new String[]{"codigo", "descripcion", "referencia"};
            tabla = "vst_" + tablaConsutada;
        } else {
            campo = this.Campos;
            nombre = this.Nombres;
            tabla = tablaConsutada;
        }
        String consulta;
        if (UsarEmpresa && UsarSucursal) {
            String[] campoCondicion = {cod_empresa, cod_sucursal, idConsultada, idConsultada};
            String[] igual = {"=", "=", ">=", "<="};
            String[] valores = {Configuracion.getCOD_EMPRESA(), Configuracion.getCOD_SUCURSAL(), this.txtCod_Desde.getText(), this.txtCod_Hasta.getText()};
            String[] ordenBy = {idConsultada, descripcionConsultada};
            consulta = ConsultaSQL.getSelect(tabla, campo, nombre, campoCondicion,
                    igual, valores, ordenBy);
        } else if (UsarEmpresa) {
            String[] campoCondicion = {cod_empresa, idConsultada, idConsultada};
            String[] igual = {"=", ">=", "<="};
            String[] valores = {Configuracion.getCOD_EMPRESA(), this.txtCod_Desde.getText(), this.txtCod_Hasta.getText()};
            String[] ordenBy = {idConsultada, descripcionConsultada};
            consulta = ConsultaSQL.getSelect(tabla, campo, nombre, campoCondicion,
                    igual, valores, ordenBy);
        } else {
            String[] campoCondicion = {idConsultada, idConsultada};
            String[] igual = {">=", "<="};
            String[] valores = {this.txtCod_Desde.getText(), this.txtCod_Hasta.getText()};
            String[] ordenBy = {idConsultada, descripcionConsultada};
            consulta = ConsultaSQL.getSelect(tabla, campo, nombre, campoCondicion,
                    igual, valores, ordenBy);
        }
        return getConexion.ejecutaQuery(consulta);
    }
}
