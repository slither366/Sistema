package com.app.form.Especiales;

import com.app.clases.ClaseTeclas;
import com.app.clases.ClaseCampos;
import com.app.clases.ClaseTable;
import com.app.config.MensajeSistema;
import com.app.config.Configuracion;
import com.app.config.ConexionBD;
import com.app.config.ConsultaSQL;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Buscar extends javax.swing.JDialog {

    String ConsultaBase;

    public Buscar(javax.swing.JFrame ventana, boolean modal,
            String tabla, boolean Empresa, boolean Sucursal, String codigo, String descripcion, String titulo, ConexionBD conexion) {
        super(ventana, modal);
        initComponents();
        this.setResizable(false);
        this.setName("Buscar");
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });
        this.textTitulo.setText("Busqueda de " + titulo + "...");
        String[] campo = {"UPPER(" + descripcion + ")", codigo};
        String[] nombres = {"Descripción", "Código"};
        String[] orderBy = {descripcion, codigo};
        if (Empresa && Sucursal) {
            String[] condicion = {frm_Padre.EMP_CODIGO, frm_Padre.SUC_CODIGO};
            String[] valor = {Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO()};
            ConsultaBase = ConsultaSQL.getSelect(tabla, campo, nombres, condicion, valor, orderBy);
        } else if (Empresa) {
            String[] condicion = {frm_Padre.EMP_CODIGO};
            String[] valor = {Configuracion.getEMP_CODIGO()};
            ConsultaBase = ConsultaSQL.getSelect(tabla, campo, nombres, condicion, valor, orderBy);
        } else {
            ConsultaBase = ConsultaSQL.getSelect(tabla, campo, nombres, orderBy);
        }
        this.jTableConsulta.cargarDatos(conexion, ConsultaBase);
        ClaseTable.ordernar(jTableConsulta);
        this.CambiarTamañoColumnas();
        this.txtNombreConsulta.setText("");
        this.txtNombreConsulta.setTextTransparente("Ingrese algún texto");        
        this.txtNombreConsulta.grabFocus();
    }

    public Buscar(javax.swing.JFrame ventana, boolean modal,
            String consulta, String titulo, ConexionBD conexion) {
        super(ventana, modal);
        initComponents();
        this.setResizable(false);
        this.setName("Buscar");
        this.setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
            }
        });
        ConsultaBase = consulta;
        this.jTableConsulta.cargarDatos(conexion, ConsultaBase);
        this.CambiarTamañoColumnas();
        this.txtNombreConsulta.setText("");
        this.txtNombreConsulta.setTextTransparente("Ingrese algún texto");       
        this.txtNombreConsulta.grabFocus();
    }

    /**
     * Cambia el ancho de las columnas de la tabla jtblDatos
     */
    private void CambiarTamañoColumnas() {
        jTableConsulta.setAncho(0, 140);
        jTableConsulta.setAncho(1, 10);
    }

    private void cantidadRegistro() {
        this.textCantidad.setText(jTableConsulta.getRowCount() + " registros encontrados...");
    }

    private boolean cargarCuadrosConsulta() {
        String codigo = jTableConsulta.getValorSeleccionado(1);
        String descri = jTableConsulta.getValorSeleccionado(0);
        if (jCheckCodigo.isSelected()) {
            this.txtNombreConsulta.setText(codigo);
        } else {
            this.txtNombreConsulta.setText(descri);
        }
        Configuracion.setCODIGO_BUSCAR(codigo);
        return !codigo.isEmpty();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jPanelTitulo = new javax.swing.JPanel();
        textTitulo = new javax.swing.JLabel();
        jPanelDatos = new javax.swing.JPanel();
        btnElegir = new javax.swing.JButton();
        txtNombreConsulta = new com.app.paleta.txtTexto();
        jCheckCodigo = new javax.swing.JCheckBox();
        jPanelCantidad = new javax.swing.JPanel();
        textCantidad = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableConsulta = new com.app.paleta.tabla();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("..:: " + Configuracion.getTITULO_VENTANA() + " - Busqueda ::..");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Configuracion.getLogo())));

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelTitulo.setMaximumSize(new java.awt.Dimension(482, 60));
        jPanelTitulo.setMinimumSize(new java.awt.Dimension(482, 60));
        jPanelTitulo.setName(""); // NOI18N

        textTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        textTitulo.setText("TITULO...");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnElegir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/buscar.png"))); // NOI18N
        btnElegir.setText("ELEGIR");
        btnElegir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirActionPerformed(evt);
            }
        });
        btnElegir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnElegirKeyPressed(evt);
            }
        });

        txtNombreConsulta.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtNombreConsultaCaretUpdate(evt);
            }
        });
        txtNombreConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreConsultaMouseClicked(evt);
            }
        });
        txtNombreConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreConsultaKeyPressed(evt);
            }
        });

        jCheckCodigo.setText("Código");
        jCheckCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCodigoActionPerformed(evt);
            }
        });
        jCheckCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jCheckCodigoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnElegir)
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnElegir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNombreConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckCodigo))
                .addContainerGap())
        );

        jPanelCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        textCantidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        textCantidad.setText("jLabel1");

        javax.swing.GroupLayout jPanelCantidadLayout = new javax.swing.GroupLayout(jPanelCantidad);
        jPanelCantidad.setLayout(jPanelCantidadLayout);
        jPanelCantidadLayout.setHorizontalGroup(
            jPanelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCantidadLayout.createSequentialGroup()
                .addContainerGap(231, Short.MAX_VALUE)
                .addComponent(textCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelCantidadLayout.setVerticalGroup(
            jPanelCantidadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCantidadLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textCantidad)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTableConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Código"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableConsultaMouseClicked(evt);
            }
        });
        jTableConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableConsultaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableConsulta);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addComponent(jPanelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreConsultaKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_ENTER()) {
            this.jTableConsulta.grabFocus();
        } else if (evt.getKeyCode() == ClaseTeclas.VK_ABAJO()) {
            this.jTableConsulta.grabFocus();
        } else if (evt.getKeyCode() == ClaseTeclas.VK_SIGUIENTE()) {
            this.btnElegir.grabFocus();
        } else if (evt.getKeyCode() == ClaseTeclas.VK_ESC()) {
            Configuracion.setCODIGO_BUSCAR("");
            this.dispose();
        }
    }//GEN-LAST:event_txtNombreConsultaKeyPressed

    private void txtNombreConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreConsultaMouseClicked
        this.txtNombreConsulta.setText("");
    }//GEN-LAST:event_txtNombreConsultaMouseClicked

    private void btnElegirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnElegirKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_ENTER()) {
            this.dispose();
        } else if (evt.getKeyCode() == ClaseTeclas.VK_ESC()) {
            Configuracion.setCODIGO_BUSCAR("");
            this.dispose();
        }
    }//GEN-LAST:event_btnElegirKeyPressed

    private void btnElegirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirActionPerformed
        if (!ClaseCampos.validarVacioSinMsj(txtNombreConsulta)) {
            MensajeSistema.MensajeVarios("Seleccione un Registro...", MensajeSistema.ERROR_MESSAGE());
            this.jTableConsulta.setFocusable(true);
            this.jTableConsulta.grabFocus();
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnElegirActionPerformed

    private void txtNombreConsultaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtNombreConsultaCaretUpdate
        if (jCheckCodigo.isSelected()) {
            ClaseTable.filtrar(jTableConsulta, this.txtNombreConsulta.getText(), 1);
        } else {
            ClaseTable.filtrar(jTableConsulta, this.txtNombreConsulta.getText(), 0);
        }
        this.cantidadRegistro();
    }//GEN-LAST:event_txtNombreConsultaCaretUpdate

    private void jTableConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableConsultaKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_ENTER()) {
            if (this.cargarCuadrosConsulta()) {
                this.btnElegir.doClick();
            }
        } else if (evt.getKeyCode() == ClaseTeclas.VK_ESC()) {
            Configuracion.setCODIGO_BUSCAR("");
            this.dispose();
        }
    }//GEN-LAST:event_jTableConsultaKeyPressed

    private void jTableConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableConsultaMouseClicked
        this.cargarCuadrosConsulta();
    }//GEN-LAST:event_jTableConsultaMouseClicked

    private void jCheckCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCodigoActionPerformed
        this.txtNombreConsulta.grabFocus();
    }//GEN-LAST:event_jCheckCodigoActionPerformed

    private void jCheckCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jCheckCodigoKeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_ESC()) {
            Configuracion.setCODIGO_BUSCAR("");
            this.dispose();
        }
    }//GEN-LAST:event_jCheckCodigoKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElegir;
    private javax.swing.JCheckBox jCheckCodigo;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanelCantidad;
    private javax.swing.JPanel jPanelDatos;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private com.app.paleta.tabla jTableConsulta;
    private javax.swing.JLabel textCantidad;
    private javax.swing.JLabel textTitulo;
    private com.app.paleta.txtTexto txtNombreConsulta;
    // End of variables declaration//GEN-END:variables
}
