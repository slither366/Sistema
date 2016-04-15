/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.form.Practicas;

import com.app.clases.ClaseTeclas;
import com.app.config.BackupBD;
import com.app.config.ConexionBD;
import com.app.config.ConsultaSQL;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.Buscar;
import com.app.form.herramientas.backup;
import com.app.form.herramientas.frm_Configuracion;
import com.app.form.herramientas.frm_ping;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Color;

/**
 *
 * @author Diego
 */
public class prueba_form extends javax.swing.JFrame {

    ConexionBD conexion = new ConexionBD("localhost","3306","root","secreto","bd_sistemas");

    public prueba_form() {
        initComponents();
        String sql = ConsultaSQL.getSelect("cont_cotizacion_set",
                new String[]{"Mon_Codigo", "venta"},
                new String[]{"codigo", "descripcion"},
                new String[]{},
                new String[]{});
        //this.tbl1.cargarDatos(new ConexionBD(), "SELECT Mon_Codigo as codigo,venta as descripcion FROM cont_cotizacion_set LIMIT 10");
        //this.tbl1.cargarDatos(conexion, sql);
        this.txtCodigo1.setBdTabla("ref_drogas");
        this.txtCodigo1.setBdCodigo("Dro_Codigo");
        this.txtCodigo1.setBdDescrip("Dro_Descrip");
        this.txtCodigo1.setBdTitulo("Drogas");
        frm_Configuracion ven = new frm_Configuracion(true, false);
        this.Escritorio.add(ven);
        ven.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        Escritorio = new javax.swing.JDesktopPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new com.app.paleta.tbl();
        jButton1 = new javax.swing.JButton();
        txtCodigo1 = new com.app.paleta.txtCodigo();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo2 = new com.app.paleta.txtCodigo();
        jLabel2 = new javax.swing.JLabel();
        txtNumeros1 = new com.app.paleta.txtNumeros();

        jMenuItem2.setText("jMenuItem2");
        jPopupMenu1.add(jMenuItem2);

        jMenuItem1.setText("jMenuItem1");
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escritorio.setBackground(new java.awt.Color(204, 204, 204));

        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo", "descripcion"
            }
        ));
        jScrollPane1.setViewportView(tbl1);

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtCodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigo1ActionPerformed(evt);
            }
        });
        txtCodigo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigo1KeyPressed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EscritorioLayout.createSequentialGroup()
                        .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(EscritorioLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(26, 26, 26)
                                .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNumeros1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(txtCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNumeros1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
        );
        Escritorio.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(txtCodigo1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(txtCodigo2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(txtNumeros1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Escritorio)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Object[] arreglo = new Object[]{
            new Color(150, 150, 150),
            new Color(255, 255, 255),
            new Color(255, 255, 255),
            new Color(0, 0, 0),
            "Arial",
            15};
//"Times New Roman",
        //new Dialogo(arreglo,this).Mensaje(Dialogo.Info, "Mensaje del Sistema", "Mensaje de abajo");
        //new Dialogo(arreglo,this).Calendario(this);
        //new Dialogo(arreglo,this).Confirmacion("Confirma guardar?", "Guardar", "Cancelar");
        //new Dialogo(arreglo,this).Lista("Palabras con A",new Object[]{"Arandano","Azul","Arturo","Amarillo","Arthemis","Agua","Amar","Azar","Atras","Arechiga","Amor"},false);

        //new GenerarReportes().mostrarReporteVentana(this.tbl1.getModel(), "/Reportes/listadosDosCampos.jasper", "1", "100", 'I', "Cotizacion");
        this.tbl1.print("Cotizaciones");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigo1ActionPerformed
        int valor = txtCodigo1.verificarVacioConMsj();
        if (valor == 0) {
            String descri = conexion.getDescripcion(this.txtCodigo1.getBdTabla(),
                    this.txtCodigo1.getBdDescrip(),
                    new String[]{this.txtCodigo1.getBdCodigo()},
                    new String[]{this.txtCodigo1.getText()});
            if (descri != null) {
                this.jLabel1.setText(descri);
                this.txtCodigo2.grabFocus();
            } else {
                if (MensajeSistema.ConsultaSQLVacio(this)) {
                    this.txtCodigo1.setText("");
                    this.jLabel1.setText("");
                    this.txtCodigo1.grabFocus();
                } else {
                    System.out.println("inicializar campos");
                }
            }
        } else if (valor == 1) {
            System.out.println("inicializar campos");
        } else {
            this.txtCodigo1.setText("");
            this.jLabel1.setText("");
            this.txtCodigo1.grabFocus();
        }
    }//GEN-LAST:event_txtCodigo1ActionPerformed

    private void txtCodigo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigo1KeyPressed
        if (evt.getKeyCode() == ClaseTeclas.VK_F5()) {
            Buscar buscar = new Buscar(null, true, this.txtCodigo1.getBdTabla(), true, false, txtCodigo1.getBdCodigo(), txtCodigo1.getBdDescrip(), txtCodigo1.getBdTitulo(), conexion);
            buscar.setVisible(true);
        }
    }//GEN-LAST:event_txtCodigo1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(prueba_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(prueba_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(prueba_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(prueba_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                }
                new prueba_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.app.paleta.tbl tbl1;
    private com.app.paleta.txtCodigo txtCodigo1;
    private com.app.paleta.txtCodigo txtCodigo2;
    private com.app.paleta.txtNumeros txtNumeros1;
    // End of variables declaration//GEN-END:variables
}
