package com.app.form.Practicas;

import com.app.config.ConsultaSQL;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Diego
 */
public class prueba_form extends javax.swing.JFrame implements ActionListener{

    //ConexionBD conexion = new ConexionBD("localhost", "3306", "root", "secreto", "bd_sistemas");
    public prueba_form() {
        initComponents();
        String sql = ConsultaSQL.getSelect("cont_cotizacion_set",
                new String[]{"Mon_Codigo", "venta"},
                new String[]{"codigo", "descripcion"},
                new String[]{},
                new String[]{});
    }

    public void agregar() {
        System.out.println("Agregar");
    }

    public void Editar(char t) {
        System.out.println(t == 'M' ? "Modificar" : "Borrar");
    }

    public void Grabar() {
        System.out.println("Grabar");
    }

    public void Cancelar() {
        System.out.println("Cancelar");
    }

    public void Salir() {
        System.out.println("Salir");
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 676, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        String Orden = e.getActionCommand();
        if (Orden.compareTo("primero") == 0) {
            System.out.println("primero");
        } else if (Orden.compareTo("anterior") == 0) {
            System.out.println("anterior");
        } else if (Orden.compareTo("siguiente") == 0) {
            System.out.println("siguiente");
        } else if (Orden.compareTo("ultimo") == 0) {
            System.out.println("ultimo");
        } 
    }

//    public class Oyente implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//            String Orden = e.getActionCommand();
//            if (Orden.compareTo("agregar") == 0) {
//                agregar();
//            } else if (Orden.compareTo("modificar") == 0) {
//                Editar('M');
//            } else if (Orden.compareTo("borrar") == 0) {
//                Editar('B');
//            } else if (Orden.compareTo("grabar") == 0) {
//                Grabar();
//            } else if (Orden.compareTo("cancelar") == 0) {
//                Cancelar();
//            } else if (Orden.compareTo("salir") == 0) {
//                Salir();
//            }
//        }
//    }
}
