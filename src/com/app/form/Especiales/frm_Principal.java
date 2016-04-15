package com.app.form.Especiales;

import com.app.clases.ClaseEncriptacion;
import com.app.form.herramientas.frm_Configuracion;
import com.app.clases.ClaseFecha;
import com.app.config.Configuracion;
import com.app.config.Decoracion;
import com.app.config.MensajeSistema;
import com.app.config.ConexionBD;
import com.app.config.Propiedades;
import com.app.form.cont.json.GenTesaka;
import com.app.form.Contactos;
import com.app.form.Productos;
import com.app.form.Productos_Farm;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Diego
 */
public class frm_Principal extends javax.swing.JFrame implements Runnable {

    public ConexionBD Conexion;// = new ConexionBD();
    public static LlamarFormulario llamarFormulario = new LlamarFormulario();

    public frm_Principal() {
        initComponents();
//        Decoracion.setLookAndFeel(2, Propiedades.getDecoracion2());
//        Decoracion.getLookAndFeel();
        this.setLocationRelativeTo(null);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                if (new MensajeSistema().Salir()) {
                    System.exit(0);
                }
            }
        });
        frm_Principal.jLabelTitulo.setText(Configuracion.getTITULO_VENTANA() + "...");
        frm_Principal.jLabelTitulo.setVisible(false);
        frm_Principal.btnCerrarSecion.setVisible(false);
        frm_Principal.jPanelLateral.setVisible(false);
        frm_Principal.jPanelDatos.setVisible(false);
        llamarFormulario.CloseAllFrame(escritorio);
        frm_Principal.MenuBar.setVisible(false);
        this.jLabelInfo.setText("");
        hilo hilo = new hilo(this.jProgressBar1, this.jLabelInfo);
    }

    public static void habilitarMenus() {
        jMenu1000.setEnabled(Configuracion.BuscarMenu(1000));
        jMenu1100.setEnabled(Configuracion.BuscarMenu(1100));
        jMenu1110.setEnabled(Configuracion.BuscarMenu(1110));
        jMenu1120.setEnabled(Configuracion.BuscarMenu(1120));
        jMenu1130.setEnabled(Configuracion.BuscarMenu(1130));
        jMenu1140.setEnabled(Configuracion.BuscarMenu(1140));
        jMenu1150.setEnabled(Configuracion.BuscarMenu(1150));
        jMenu1160.setEnabled(Configuracion.BuscarMenu(1160));
        jMenu1200.setEnabled(Configuracion.BuscarMenu(1200));
        jMenu1210.setEnabled(Configuracion.BuscarMenu(1210));
        jMenu1220.setEnabled(Configuracion.BuscarMenu(1220));
        jMenu1300.setEnabled(Configuracion.BuscarMenu(1300));
        jMenu1400.setEnabled(Configuracion.BuscarMenu(1400));
        jMenu1500.setEnabled(Configuracion.BuscarMenu(1500));
        jMenu1600.setEnabled(Configuracion.BuscarMenu(1600));
        jMenu1700.setEnabled(Configuracion.BuscarMenu(1700));
        jMenu2000.setEnabled(Configuracion.BuscarMenu(2000));
        jMenu3000.setEnabled(Configuracion.BuscarMenu(3000));
        jMenu3100.setEnabled(Configuracion.BuscarMenu(3100));
        jMenu4000.setEnabled(Configuracion.BuscarMenu(4000));
        jMenu5000.setEnabled(Configuracion.BuscarMenu(5000));
        jMenu5100.setEnabled(Configuracion.BuscarMenu(5100));
        jMenu5110.setEnabled(Configuracion.BuscarMenu(5110));
        jMenu5120.setEnabled(Configuracion.BuscarMenu(5120));
        jMenu5130.setEnabled(Configuracion.BuscarMenu(5130));
        jMenu5200.setEnabled(Configuracion.BuscarMenu(5200));
        jMenu5210.setEnabled(Configuracion.BuscarMenu(5210));
        jMenu5220.setEnabled(Configuracion.BuscarMenu(5220));
        jMenu5230.setEnabled(Configuracion.BuscarMenu(5230));
        jMenu5240.setEnabled(Configuracion.BuscarMenu(5240));
        jMenu5250.setEnabled(Configuracion.BuscarMenu(5250));
        jMenu5300.setEnabled(Configuracion.BuscarMenu(5300));
        jMenu5310.setEnabled(Configuracion.BuscarMenu(5310));
        jMenu5320.setEnabled(Configuracion.BuscarMenu(5320));
        jMenu5400.setEnabled(Configuracion.BuscarMenu(5400));
    }

    public static void ubicarBotones() {
        frm_Principal.jLabelTitulo.setVisible(true);
        frm_Principal.jPanelDatos.setVisible(true);
        frm_Principal.jPanelLateral.setVisible(true);
        frm_Principal.jLabelFecha.setText("Fecha: " + ClaseFecha.getFechaActualLargaCompleta());
        frm_Principal.jLabelUsuario.setText(Configuracion.getNOM_USUARIO() + " - " + Configuracion.getNOM_PERFIL());
        frm_Principal.jLabelEmpresa.setText("Empresa: " + Configuracion.getNOM_EMPRESA() + "       Sucursal: " + Configuracion.getNOM_SUCURSAL());
        frm_Principal.btnCerrarSecion.setVisible(true);
    }

    private void iniciarSecion() {
        frm_Principal.jLabelTitulo.setVisible(false);
        frm_Principal.btnCerrarSecion.setVisible(false);
        frm_Principal.jPanelLateral.setVisible(false);
        frm_Principal.jPanelDatos.setVisible(false);
        llamarFormulario.CloseAllFrame(escritorio);
        frm_Principal.MenuBar.setVisible(false);
        Acceso acceso = new Acceso();
        acceso.setLocation((escritorio.getSize().width - acceso.getSize().width) / 2,
                (escritorio.getSize().height - acceso.getSize().height) / 2);
        escritorio.add(acceso);
        try {
            acceso.toFront();
            acceso.setSelected(true);
        } catch (Exception ex) {
        }
    }

    private void Salir() {
        if (new MensajeSistema().Salir()) {
            System.exit(0);
        }
    }

    private void Acerca_de() {
        new Acerca_de(this, true).setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        btnCerrarSecion = new javax.swing.JButton();
        jPanelDatos = new javax.swing.JPanel();
        jLabelFecha = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelEmpresa = new javax.swing.JLabel();
        jLabelHoraAMPM1 = new com.app.paleta.JLabelHoraAMPM();
        jPanelLateral = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabelInfo = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        jMenu1000 = new javax.swing.JMenu();
        jMenu1100 = new javax.swing.JMenu();
        jMenu1110 = new javax.swing.JMenuItem();
        jMenu1120 = new javax.swing.JMenuItem();
        jMenu1130 = new javax.swing.JMenuItem();
        jMenu1140 = new javax.swing.JMenuItem();
        jMenu1150 = new javax.swing.JMenuItem();
        jMenu1160 = new javax.swing.JMenuItem();
        jMenu1200 = new javax.swing.JMenu();
        jMenu1210 = new javax.swing.JMenuItem();
        jMenu1220 = new javax.swing.JMenuItem();
        jMenu1300 = new javax.swing.JMenuItem();
        jMenu1400 = new javax.swing.JMenuItem();
        jMenu1500 = new javax.swing.JMenuItem();
        jMenu1600 = new javax.swing.JMenuItem();
        jMenu1700 = new javax.swing.JMenuItem();
        jMenu2000 = new javax.swing.JMenu();
        jMenu3000 = new javax.swing.JMenu();
        jMenu3100 = new javax.swing.JMenuItem();
        jMenu4000 = new javax.swing.JMenu();
        jMenu5000 = new javax.swing.JMenu();
        jMenu5100 = new javax.swing.JMenu();
        jMenu5110 = new javax.swing.JMenuItem();
        jMenu5120 = new javax.swing.JMenuItem();
        jMenu5130 = new javax.swing.JMenuItem();
        jMenu5200 = new javax.swing.JMenu();
        jMenu5210 = new javax.swing.JMenuItem();
        jMenu5220 = new javax.swing.JMenuItem();
        jMenu5230 = new javax.swing.JMenuItem();
        jMenu5240 = new javax.swing.JMenuItem();
        jMenu5250 = new javax.swing.JMenuItem();
        jMenu5300 = new javax.swing.JMenu();
        jMenu5310 = new javax.swing.JMenuItem();
        jMenu5320 = new javax.swing.JMenuItem();
        jMenu5400 = new javax.swing.JMenuItem();
        jMenu6000 = new javax.swing.JMenu();
        jMenu7000 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("..:: " + Configuracion.getTITULO_VENTANA() + " ::..");
        setExtendedState(6);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(Configuracion.getLogo())));
        setMinimumSize(new java.awt.Dimension(800, 600));

        escritorio.setBackground(new java.awt.Color(204, 204, 204));

        btnCerrarSecion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/iconos/cerrar.png"))); // NOI18N
        btnCerrarSecion.setText("Cerrar Sesión");
        btnCerrarSecion.setToolTipText("Clic para Cerrar la Sesión Actual...");
        btnCerrarSecion.setMaximumSize(new java.awt.Dimension(150, 90));
        btnCerrarSecion.setMinimumSize(new java.awt.Dimension(150, 90));
        btnCerrarSecion.setPreferredSize(new java.awt.Dimension(150, 90));
        btnCerrarSecion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSecionActionPerformed(evt);
            }
        });

        jPanelDatos.setBackground(new java.awt.Color(204, 204, 204));
        jPanelDatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelFecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelFecha.setText("Fecha");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Usuario:");

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelUsuario.setText("jLabel3");

        jLabelEmpresa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmpresa.setText("Empresa");

        jLabelHoraAMPM1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelHoraAMPM1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanelDatosLayout = new javax.swing.GroupLayout(jPanelDatos);
        jPanelDatos.setLayout(jPanelDatosLayout);
        jPanelDatosLayout.setHorizontalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabelEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDatosLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelHoraAMPM1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDatosLayout.setVerticalGroup(
            jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmpresa)
                    .addComponent(jLabelFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jLabel3)
                    .addComponent(jLabelHoraAMPM1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelLateral.setBackground(new java.awt.Color(204, 204, 204));
        jPanelLateral.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelLateralLayout = new javax.swing.GroupLayout(jPanelLateral);
        jPanelLateral.setLayout(jPanelLateralLayout);
        jPanelLateralLayout.setHorizontalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 196, Short.MAX_VALUE)
        );
        jPanelLateralLayout.setVerticalGroup(
            jPanelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelTitulo.setText("Sistema...");

        jLabelInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInfo.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                .addComponent(jLabelInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(jPanelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(escritorioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnCerrarSecion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanelDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrarSecion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        escritorio.setLayer(btnCerrarSecion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jPanelDatos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jPanelLateral, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        MenuBar.setBorder(null);
        MenuBar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenu1000.setMnemonic('1');
        jMenu1000.setText("1- Mantenimientos");

        jMenu1100.setMnemonic('3');
        jMenu1100.setText("1.1- Productos");

        jMenu1110.setMnemonic('1');
        jMenu1110.setText("1.1.1- Marcas");
        jMenu1110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1110ActionPerformed(evt);
            }
        });
        jMenu1100.add(jMenu1110);

        jMenu1120.setMnemonic('2');
        jMenu1120.setText("1.1.2- Lineas");
        jMenu1120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1120ActionPerformed(evt);
            }
        });
        jMenu1100.add(jMenu1120);

        jMenu1130.setMnemonic('3');
        jMenu1130.setText("1.1.3- Envaces");
        jMenu1130.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1130ActionPerformed(evt);
            }
        });
        jMenu1100.add(jMenu1130);

        jMenu1140.setMnemonic('4');
        jMenu1140.setText("1.1.4- Productos");
        jMenu1140.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1140ActionPerformed(evt);
            }
        });
        jMenu1100.add(jMenu1140);

        jMenu1150.setText("1.1.5- Componentes");
        jMenu1150.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1150ActionPerformed(evt);
            }
        });
        jMenu1100.add(jMenu1150);

        jMenu1160.setText("1.1.6- Contraindicaciones");
        jMenu1160.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1160ActionPerformed(evt);
            }
        });
        jMenu1100.add(jMenu1160);

        jMenu1000.add(jMenu1100);

        jMenu1200.setText("1.2- Drogas");

        jMenu1210.setText("1.2.1- Mantenimiento");
        jMenu1210.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1210ActionPerformed(evt);
            }
        });
        jMenu1200.add(jMenu1210);

        jMenu1220.setText("1.2.2- Consulta & Listado");
        jMenu1220.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1220ActionPerformed(evt);
            }
        });
        jMenu1200.add(jMenu1220);

        jMenu1000.add(jMenu1200);

        jMenu1300.setMnemonic('5');
        jMenu1300.setText("1.3- Sintomas");
        jMenu1300.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1300ActionPerformed(evt);
            }
        });
        jMenu1000.add(jMenu1300);

        jMenu1400.setMnemonic('6');
        jMenu1400.setText("1.4- Enfermedades");
        jMenu1400.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1400ActionPerformed(evt);
            }
        });
        jMenu1000.add(jMenu1400);

        jMenu1500.setMnemonic('7');
        jMenu1500.setText("1.5- Tratamientos");
        jMenu1500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1500ActionPerformed(evt);
            }
        });
        jMenu1000.add(jMenu1500);

        jMenu1600.setText("1.6- Diagnosticos");
        jMenu1600.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1600ActionPerformed(evt);
            }
        });
        jMenu1000.add(jMenu1600);

        jMenu1700.setText("1.7- Contactos");
        jMenu1700.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1700ActionPerformed(evt);
            }
        });
        jMenu1000.add(jMenu1700);

        MenuBar.add(jMenu1000);

        jMenu2000.setMnemonic('2');
        jMenu2000.setText("2- Movimientos");
        MenuBar.add(jMenu2000);

        jMenu3000.setMnemonic('3');
        jMenu3000.setText("3- Informes");

        jMenu3100.setText("3.1- Listado Referenciales");
        jMenu3100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3100ActionPerformed(evt);
            }
        });
        jMenu3000.add(jMenu3100);

        MenuBar.add(jMenu3000);

        jMenu4000.setMnemonic('4');
        jMenu4000.setText("4- Consultas");
        MenuBar.add(jMenu4000);

        jMenu5000.setMnemonic('5');
        jMenu5000.setText("5 - Administrativo");

        jMenu5100.setMnemonic('1');
        jMenu5100.setText("5.1- Administración de Sistema");

        jMenu5110.setMnemonic('1');
        jMenu5110.setText("5.1.1- Mantenimiento de Menú");
        jMenu5110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5110ActionPerformed(evt);
            }
        });
        jMenu5100.add(jMenu5110);

        jMenu5120.setMnemonic('2');
        jMenu5120.setText("5.1.2- Mantenimiento de Permisos");
        jMenu5120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5120ActionPerformed(evt);
            }
        });
        jMenu5100.add(jMenu5120);

        jMenu5130.setMnemonic('3');
        jMenu5130.setText("5.1.3- Mantenimiento de Usuarios");
        jMenu5130.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5130ActionPerformed(evt);
            }
        });
        jMenu5100.add(jMenu5130);

        jMenu5000.add(jMenu5100);

        jMenu5200.setMnemonic('2');
        jMenu5200.setText("5.2- Parametros iniciales");

        jMenu5210.setMnemonic('1');
        jMenu5210.setText("5.2.1- Empresas");
        jMenu5210.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5210ActionPerformed(evt);
            }
        });
        jMenu5200.add(jMenu5210);

        jMenu5220.setMnemonic('2');
        jMenu5220.setText("5.2.2- Sucursales");
        jMenu5200.add(jMenu5220);

        jMenu5230.setMnemonic('3');
        jMenu5230.setText("5.2.3- Bancos");
        jMenu5230.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5230ActionPerformed(evt);
            }
        });
        jMenu5200.add(jMenu5230);

        jMenu5240.setMnemonic('4');
        jMenu5240.setText("5.2.4- Ciudades");
        jMenu5240.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5240ActionPerformed(evt);
            }
        });
        jMenu5200.add(jMenu5240);

        jMenu5250.setMnemonic('5');
        jMenu5250.setText("5.2.5- Nacionalidades");
        jMenu5250.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5250ActionPerformed(evt);
            }
        });
        jMenu5200.add(jMenu5250);

        jMenu5000.add(jMenu5200);

        jMenu5300.setMnemonic('3');
        jMenu5300.setText("5.3- Contribuyentes");

        jMenu5310.setText("5.3.1- Mantener Contribuyentes");
        jMenu5310.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5310ActionPerformed(evt);
            }
        });
        jMenu5300.add(jMenu5310);

        jMenu5320.setText("5.3.2- Cargar Contribuyentes");
        jMenu5320.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5320ActionPerformed(evt);
            }
        });
        jMenu5300.add(jMenu5320);

        jMenu5000.add(jMenu5300);

        jMenu5400.setText("5.4- Generar Tesaka");
        jMenu5400.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu5400ActionPerformed(evt);
            }
        });
        jMenu5000.add(jMenu5400);

        MenuBar.add(jMenu5000);

        jMenu6000.setMnemonic('6');
        jMenu6000.setText("6- Acerca de.");
        jMenu6000.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu6000MouseClicked(evt);
            }
        });
        MenuBar.add(jMenu6000);

        jMenu7000.setMnemonic('7');
        jMenu7000.setText("7- Salir");
        jMenu7000.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7000MouseClicked(evt);
            }
        });
        MenuBar.add(jMenu7000);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu5130ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5130ActionPerformed
        llamarFormulario.llamarInternalFrame(new frm_Usuarios(5130), escritorio);
    }//GEN-LAST:event_jMenu5130ActionPerformed

    private void jMenu3100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3100ActionPerformed
        llamarFormulario.llamarInternalFrame(new frm_listados(3100), escritorio);
    }//GEN-LAST:event_jMenu3100ActionPerformed

    private void jMenu5240ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5240ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("ref_ciudades", 5240, false, false,
                        "cod_ciudad", "nom_ciudad", "Ciudades"), escritorio);
    }//GEN-LAST:event_jMenu5240ActionPerformed

    private void jMenu5110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5110ActionPerformed
        llamarFormulario.llamarInternalFrame(new MantenimientoMenu(), escritorio);
    }//GEN-LAST:event_jMenu5110ActionPerformed

    private void jMenu5250ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5250ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("ref_nacionalidades", 5250, true, false,
                        "cod_nacionalidad", "nom_nacionalidad", "Nacionalidades"), escritorio);
    }//GEN-LAST:event_jMenu5250ActionPerformed

    private void jMenu5230ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5230ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("ref_bancos", 5230, true, false,
                        "cod_banco", "nom_banco", "Bancos"), escritorio);
    }//GEN-LAST:event_jMenu5230ActionPerformed

    private void jMenu5120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5120ActionPerformed
        llamarFormulario.llamarInternalFrame(new Mantenimiento_Permisos(), escritorio);
    }//GEN-LAST:event_jMenu5120ActionPerformed

    private void jMenu1140ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1140ActionPerformed
        llamarFormulario.llamarInternalFrame(new Productos(1140), escritorio);
    }//GEN-LAST:event_jMenu1140ActionPerformed

    private void jMenu1110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1110ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("Ref_Marcas", 1110, true, false,
                        "Mar_Codigo", "Mar_Descrip", "Marcas"), escritorio);
    }//GEN-LAST:event_jMenu1110ActionPerformed

    private void jMenu1120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1120ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("Ref_Lineas", 1120, true, false,
                        "Lin_Codigo", "Lin_Descrip", "Lineas"), escritorio);
    }//GEN-LAST:event_jMenu1120ActionPerformed

    private void jMenu1130ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1130ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("Ref_Envaces", 1130, true, false,
                        "Env_Codigo", "Env_Descrip", "Envaces"), escritorio);
    }//GEN-LAST:event_jMenu1130ActionPerformed

    private void jMenu5320ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5320ActionPerformed
        llamarFormulario.llamarInternalFrame(new Contribuyentes_frm(Conexion), escritorio);
    }//GEN-LAST:event_jMenu5320ActionPerformed

    private void jMenu5310ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5310ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMTresCampos("contribuyentes", 5310, false, false,
                        "ruc", "razon_social", "dv", "Contribuyentes"), escritorio);
    }//GEN-LAST:event_jMenu5310ActionPerformed

    private void btnCerrarSecionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSecionActionPerformed
        this.iniciarSecion();
    }//GEN-LAST:event_btnCerrarSecionActionPerformed

    private void jMenu1300ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1300ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMTresCampos("Ref_Sintomas", 1300, true, false,
                        "Sint_Codigo", "Sint_Descrip", "observacion", "Sintomas"), escritorio);
    }//GEN-LAST:event_jMenu1300ActionPerformed

    private void jMenu1400ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1400ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMTresCampos("Ref_Enfermedades", 1400, true, false,
                        "Enf_Codigo", "Enf_Descrip", "observacion", "Enfermedades"), escritorio);
    }//GEN-LAST:event_jMenu1400ActionPerformed

    private void jMenu1500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1500ActionPerformed
        llamarFormulario.llamarInternalFrame(new Productos_Farm("Farm_Tratamientos", 1500, true, false, "Trat_Codigo",
                "Ref_Enfermedades", "Enf_Codigo", "Enf_Descrip", "Enfermedades",
                "Ref_Drogas", "Dro_Codigo", "Dro_Descrip", "Drogas",
                "observacion", "Tratamientos"), escritorio);
    }//GEN-LAST:event_jMenu1500ActionPerformed

    private void jMenu1150ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1150ActionPerformed
        llamarFormulario.llamarInternalFrame(new Productos_Farm("Farm_Componentes", 1150, true, false, "Comp_Codigo",
                "Mant_Productos", "Prod_Codigo", "Prod_Descrip", "Productos",
                "Ref_Drogas", "Dro_Codigo", "Dro_Descrip", "Drogas", "observacion",
                "Componentes"), escritorio);
    }//GEN-LAST:event_jMenu1150ActionPerformed

    private void jMenu1600ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1600ActionPerformed
        llamarFormulario.llamarInternalFrame(new Productos_Farm("Farm_Diagnosticos", 1600, true, false, "Diag_Codigo",
                "ref_enfermedades", "cod_enfermedad", "nom_enfermedad", "Enfermedades",
                "ref_sintomas", "cod_sintoma", "nom_sintoma", "Sintomas",
                "observacion", "Diagnosticos"), escritorio);
    }//GEN-LAST:event_jMenu1600ActionPerformed

    private void jMenu1160ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1160ActionPerformed
        llamarFormulario.llamarInternalFrame(new Productos_Farm("farm_contraindicaciones", 1160, true, false, "Cont_Codigo",
                "mant_productos", "cod_producto", "nombre_producto", "Productos",
                "ref_enfermedades", "cod_enfermedad", "nom_enfermedad", "Enfermedades",
                "observacion", "Contraindicaciones"), escritorio);
    }//GEN-LAST:event_jMenu1160ActionPerformed

    private void jMenu5210ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5210ActionPerformed
        llamarFormulario.llamarInternalFrame(new Empresas(5210), escritorio);
    }//GEN-LAST:event_jMenu5210ActionPerformed

    private void jMenu1700ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1700ActionPerformed
        llamarFormulario.llamarInternalFrame(new Contactos(1700), escritorio);
    }//GEN-LAST:event_jMenu1700ActionPerformed

    private void jMenu6000MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6000MouseClicked
        this.Acerca_de();
    }//GEN-LAST:event_jMenu6000MouseClicked

    private void jMenu7000MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7000MouseClicked
        this.Salir();
    }//GEN-LAST:event_jMenu7000MouseClicked

    private void jMenu5400ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu5400ActionPerformed
        llamarFormulario.llamarInternalFrame(new GenTesaka(Conexion), escritorio);
    }//GEN-LAST:event_jMenu5400ActionPerformed

    private void jMenu1210ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1210ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("ref_drogas", 1210, true, false, 
                        "Dro_Codigo", "Dro_Descrip", "Drogas"), escritorio);
    }//GEN-LAST:event_jMenu1210ActionPerformed

    private void jMenu1220ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1220ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new Listar("ref_drogas", true, false, 
                        "Dro_Codigo", "Dro_Descrip", "Drogas"), escritorio);
    }//GEN-LAST:event_jMenu1220ActionPerformed
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            // Decoracion.setLookAndFeel(2, Propiedades.getDecoracion2());
            Decoracion.getLookAndFeel();
            new frm_Principal().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuBar MenuBar;
    private static javax.swing.JButton btnCerrarSecion;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabelEmpresa;
    private static javax.swing.JLabel jLabelFecha;
    private com.app.paleta.JLabelHoraAMPM jLabelHoraAMPM1;
    private javax.swing.JLabel jLabelInfo;
    private static javax.swing.JLabel jLabelTitulo;
    private static javax.swing.JLabel jLabelUsuario;
    public static javax.swing.JMenu jMenu1000;
    public static javax.swing.JMenu jMenu1100;
    public static javax.swing.JMenuItem jMenu1110;
    public static javax.swing.JMenuItem jMenu1120;
    public static javax.swing.JMenuItem jMenu1130;
    public static javax.swing.JMenuItem jMenu1140;
    public static javax.swing.JMenuItem jMenu1150;
    public static javax.swing.JMenuItem jMenu1160;
    private static javax.swing.JMenu jMenu1200;
    private static javax.swing.JMenuItem jMenu1210;
    private static javax.swing.JMenuItem jMenu1220;
    public static javax.swing.JMenuItem jMenu1300;
    public static javax.swing.JMenuItem jMenu1400;
    public static javax.swing.JMenuItem jMenu1500;
    public static javax.swing.JMenuItem jMenu1600;
    public static javax.swing.JMenuItem jMenu1700;
    public static javax.swing.JMenu jMenu2000;
    public static javax.swing.JMenu jMenu3000;
    public static javax.swing.JMenuItem jMenu3100;
    public static javax.swing.JMenu jMenu4000;
    public static javax.swing.JMenu jMenu5000;
    public static javax.swing.JMenu jMenu5100;
    public static javax.swing.JMenuItem jMenu5110;
    public static javax.swing.JMenuItem jMenu5120;
    public static javax.swing.JMenuItem jMenu5130;
    public static javax.swing.JMenu jMenu5200;
    public static javax.swing.JMenuItem jMenu5210;
    public static javax.swing.JMenuItem jMenu5220;
    public static javax.swing.JMenuItem jMenu5230;
    public static javax.swing.JMenuItem jMenu5240;
    public static javax.swing.JMenuItem jMenu5250;
    public static javax.swing.JMenu jMenu5300;
    public static javax.swing.JMenuItem jMenu5310;
    public static javax.swing.JMenuItem jMenu5320;
    public static javax.swing.JMenuItem jMenu5400;
    private javax.swing.JMenu jMenu6000;
    private javax.swing.JMenu jMenu7000;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JPanel jPanelDatos;
    private static javax.swing.JPanel jPanelLateral;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {

    }

    private class hilo extends Thread {

        JProgressBar barra;
        JLabel texto;

        public hilo(JProgressBar barra, JLabel text) {
            this.barra = barra;
            this.texto = text;
            this.start();
        }

        @Override
        public void run() {
            boolean correcto = false;
            boolean archivo = false;
            boolean conex = false;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            Propiedades Pro = null;
            for (int i = 1; i <= 100; i++) {
                this.barra.setValue(i);
                if (i <= 20) {
                    this.texto.setText("Iniciando el Programa");
                }
                if (i > 20 && i <= 35) {
                    this.texto.setText("Buscando el archivo de Configuración");
                }
                if (i == 25) {
                    try {
                        Pro = new Propiedades();
                    } catch (IOException ex) {
                        correcto = false;
                        break;
                    }
                    archivo = true;
                    correcto = true;
                }
                if (i > 35 && i <= 60) {
                    this.texto.setText("Intetando Conectar al Servidor " + Pro.getHost());
                }
                if (i == 50) {
                    try {
                        Conexion = new ConexionBD(Pro.getHost(), Pro.getPort(),
                                Pro.getUser(), ClaseEncriptacion.descifrarTexto(Pro.getPass()), Pro.getBD());
                    } catch (Exception ex) {
                        correcto = false;
                        break;
                    }
                    conex = true;
                    correcto = true;
                }
                if (i > 60 && i <= 70) {
                    this.texto.setText("Conectado al Servidor " + Pro.getHost());
                }
                if (i > 70) {
                    this.texto.setText("Cargando archivos adicionales...");
                }
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                }
            }
            if (correcto) {
                Acceso_Empresa ven = new Acceso_Empresa(Conexion, Pro);
                ven.setLocation((frm_Principal.escritorio.getSize().width - ven.getSize().width) / 2,
                        (frm_Principal.escritorio.getSize().height - ven.getSize().height) / 2);
                frm_Principal.escritorio.add(ven);
                jProgressBar1.setVisible(false);
                texto.setVisible(false);
                try {
                    ven.toFront();
                    ven.setSelected(true);
                } catch (Exception ex) {
                }
            } else {
                frm_Configuracion ven = new frm_Configuracion(archivo, conex);
                ven.setLocation((frm_Principal.escritorio.getSize().width - ven.getSize().width) / 2,
                        (frm_Principal.escritorio.getSize().height - ven.getSize().height) / 2);
                frm_Principal.escritorio.add(ven);
                jProgressBar1.setVisible(false);
                texto.setVisible(false);
                try {
                    ven.toFront();
                    ven.setSelected(true);
                } catch (Exception ex) {
                }
            }
        }
    }
}
/*
 * AutumnSkin
 * BusinessSkin
 * BusinessBlueSteelSkin
 * BusinessBlackSteelSkin
 * ChallengerDeepSkin
 * CremeCoffeeSkin
 * CremeSkin
 * EmeraldDuskSkin
 * FieldOfWheatSkin
 * FindingNemoSkin
 * GreenMagicSkin
 * MagmaSkin
 * MangoSkin
 * MistAquaSkin
 * MistSilverSkin
 * ModerateSkin
 * NebulaSkin
 * OfficeBlue2007Skin
 * OfficeSilver2007Skin
 * RavenSkin
 * SaharaSkin*
 * SubstanceSkin
 * 
 */
