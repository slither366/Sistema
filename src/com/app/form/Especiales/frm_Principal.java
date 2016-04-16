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
        jMenu1111.setEnabled(Configuracion.BuscarMenu(1111));
        jMenu1112.setEnabled(Configuracion.BuscarMenu(1112));
        jMenu1120.setEnabled(Configuracion.BuscarMenu(1120));
        jMenu1121.setEnabled(Configuracion.BuscarMenu(1121));
        jMenu1122.setEnabled(Configuracion.BuscarMenu(1122));
        jMenu1130.setEnabled(Configuracion.BuscarMenu(1130));
        jMenu1131.setEnabled(Configuracion.BuscarMenu(1131));
        jMenu1132.setEnabled(Configuracion.BuscarMenu(1132));
        jMenu1140.setEnabled(Configuracion.BuscarMenu(1140));
        jMenu1141.setEnabled(Configuracion.BuscarMenu(1141));
        jMenu1142.setEnabled(Configuracion.BuscarMenu(1141));

        jMenu1200.setEnabled(Configuracion.BuscarMenu(1200));
        jMenu1210.setEnabled(Configuracion.BuscarMenu(1210));
        jMenu1211.setEnabled(Configuracion.BuscarMenu(1211));
        jMenu1212.setEnabled(Configuracion.BuscarMenu(1212));
        jMenu1220.setEnabled(Configuracion.BuscarMenu(1220));
        jMenu1221.setEnabled(Configuracion.BuscarMenu(1221));
        jMenu1222.setEnabled(Configuracion.BuscarMenu(1222));
        jMenu1230.setEnabled(Configuracion.BuscarMenu(1230));
        jMenu1231.setEnabled(Configuracion.BuscarMenu(1231));
        jMenu1232.setEnabled(Configuracion.BuscarMenu(1232));
        jMenu1240.setEnabled(Configuracion.BuscarMenu(1240));
        jMenu1241.setEnabled(Configuracion.BuscarMenu(1241));
        jMenu1242.setEnabled(Configuracion.BuscarMenu(1242));
        jMenu1250.setEnabled(Configuracion.BuscarMenu(1250));
        jMenu1251.setEnabled(Configuracion.BuscarMenu(1251));
        jMenu1252.setEnabled(Configuracion.BuscarMenu(1252));
        jMenu1260.setEnabled(Configuracion.BuscarMenu(1260));
        jMenu1261.setEnabled(Configuracion.BuscarMenu(1261));
        jMenu1262.setEnabled(Configuracion.BuscarMenu(1262));
        jMenu1271.setEnabled(Configuracion.BuscarMenu(1270));
        jMenu1271.setEnabled(Configuracion.BuscarMenu(1271));
        jMenu1272.setEnabled(Configuracion.BuscarMenu(1272));

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
        jMenu1110 = new javax.swing.JMenu();
        jMenu1111 = new javax.swing.JMenuItem();
        jMenu1112 = new javax.swing.JMenuItem();
        jMenu1120 = new javax.swing.JMenu();
        jMenu1121 = new javax.swing.JMenuItem();
        jMenu1122 = new javax.swing.JMenuItem();
        jMenu1130 = new javax.swing.JMenu();
        jMenu1131 = new javax.swing.JMenuItem();
        jMenu1132 = new javax.swing.JMenuItem();
        jMenu1140 = new javax.swing.JMenu();
        jMenu1141 = new javax.swing.JMenuItem();
        jMenu1142 = new javax.swing.JMenuItem();
        jMenu1200 = new javax.swing.JMenu();
        jMenu1210 = new javax.swing.JMenu();
        jMenu1211 = new javax.swing.JMenuItem();
        jMenu1212 = new javax.swing.JMenuItem();
        jMenu1220 = new javax.swing.JMenu();
        jMenu1221 = new javax.swing.JMenuItem();
        jMenu1222 = new javax.swing.JMenuItem();
        jMenu1230 = new javax.swing.JMenu();
        jMenu1231 = new javax.swing.JMenuItem();
        jMenu1232 = new javax.swing.JMenuItem();
        jMenu1240 = new javax.swing.JMenu();
        jMenu1241 = new javax.swing.JMenuItem();
        jMenu1242 = new javax.swing.JMenuItem();
        jMenu1250 = new javax.swing.JMenu();
        jMenu1251 = new javax.swing.JMenuItem();
        jMenu1252 = new javax.swing.JMenuItem();
        jMenu1260 = new javax.swing.JMenu();
        jMenu1261 = new javax.swing.JMenuItem();
        jMenu1262 = new javax.swing.JMenuItem();
        jMenu1270 = new javax.swing.JMenu();
        jMenu1271 = new javax.swing.JMenuItem();
        jMenu1272 = new javax.swing.JMenuItem();
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

        jMenu1111.setMnemonic('1');
        jMenu1111.setText("1.1.1.1- Mantenimiento");
        jMenu1111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1111ActionPerformed(evt);
            }
        });
        jMenu1110.add(jMenu1111);

        jMenu1112.setMnemonic('2');
        jMenu1112.setText("1.1.1.2- Consulta & Listado");
        jMenu1110.add(jMenu1112);

        jMenu1100.add(jMenu1110);

        jMenu1120.setMnemonic('2');
        jMenu1120.setText("1.1.2- Lineas");

        jMenu1121.setMnemonic('1');
        jMenu1121.setText("1.1.2.1- Matenimiento");
        jMenu1121.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1121ActionPerformed(evt);
            }
        });
        jMenu1120.add(jMenu1121);

        jMenu1122.setMnemonic('2');
        jMenu1122.setText("1.1.2.2- Consulta & Listado");
        jMenu1120.add(jMenu1122);

        jMenu1100.add(jMenu1120);

        jMenu1130.setMnemonic('3');
        jMenu1130.setText("1.1.3- Envaces");

        jMenu1131.setMnemonic('1');
        jMenu1131.setText("1.1.3.1- Matenimiento");
        jMenu1131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1131ActionPerformed(evt);
            }
        });
        jMenu1130.add(jMenu1131);

        jMenu1132.setMnemonic('2');
        jMenu1132.setText("1.1.3.2- Consulta & Listado");
        jMenu1130.add(jMenu1132);

        jMenu1100.add(jMenu1130);

        jMenu1140.setMnemonic('4');
        jMenu1140.setText("1.1.4- Productos");

        jMenu1141.setMnemonic('1');
        jMenu1141.setText("1.1.4.1- Matenimiento");
        jMenu1141.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1141ActionPerformed(evt);
            }
        });
        jMenu1140.add(jMenu1141);

        jMenu1142.setMnemonic('2');
        jMenu1142.setText("1.1.4.2- Consulta & Listado");
        jMenu1140.add(jMenu1142);

        jMenu1100.add(jMenu1140);

        jMenu1000.add(jMenu1100);

        jMenu1200.setMnemonic('2');
        jMenu1200.setText("1.2- Farmacia");

        jMenu1210.setMnemonic('1');
        jMenu1210.setText("1.2.1- Drogas");

        jMenu1211.setMnemonic('1');
        jMenu1211.setText("1.2.1.1- Mantenimiento");
        jMenu1211.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1211ActionPerformed(evt);
            }
        });
        jMenu1210.add(jMenu1211);

        jMenu1212.setMnemonic('2');
        jMenu1212.setText("1.2.1.2- Consulta & Listado");
        jMenu1212.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1212ActionPerformed(evt);
            }
        });
        jMenu1210.add(jMenu1212);

        jMenu1200.add(jMenu1210);

        jMenu1220.setMnemonic('2');
        jMenu1220.setText("1.2.2- Sintomas");

        jMenu1221.setMnemonic('1');
        jMenu1221.setText("1.2.2.1- Mantenimiento");
        jMenu1221.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1221ActionPerformed(evt);
            }
        });
        jMenu1220.add(jMenu1221);

        jMenu1222.setMnemonic('2');
        jMenu1222.setText("1.2.2.2- Consulta & Listado");
        jMenu1220.add(jMenu1222);

        jMenu1200.add(jMenu1220);

        jMenu1230.setMnemonic('3');
        jMenu1230.setText("1.2.3- Enfermedades");

        jMenu1231.setMnemonic('1');
        jMenu1231.setText("1.2.3.1- Matenimiento");
        jMenu1231.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1231ActionPerformed(evt);
            }
        });
        jMenu1230.add(jMenu1231);

        jMenu1232.setMnemonic('2');
        jMenu1232.setText("1.2.3.2- Consulta & Listado");
        jMenu1230.add(jMenu1232);

        jMenu1200.add(jMenu1230);

        jMenu1240.setMnemonic('4');
        jMenu1240.setText("1.2.4- Tratamientos");

        jMenu1241.setMnemonic('1');
        jMenu1241.setText("1.2.4.1- Matenimiento");
        jMenu1241.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1241ActionPerformed(evt);
            }
        });
        jMenu1240.add(jMenu1241);

        jMenu1242.setMnemonic('2');
        jMenu1242.setText("1.2.4.2- Consulta & Listado");
        jMenu1240.add(jMenu1242);

        jMenu1200.add(jMenu1240);

        jMenu1250.setMnemonic('5');
        jMenu1250.setText("1.2.5- Diagnosticos");

        jMenu1251.setMnemonic('1');
        jMenu1251.setText("1.2.5.1- Matenimiento");
        jMenu1251.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1251ActionPerformed(evt);
            }
        });
        jMenu1250.add(jMenu1251);

        jMenu1252.setMnemonic('2');
        jMenu1252.setText("1.2.5.2- Consulta & Listado");
        jMenu1250.add(jMenu1252);

        jMenu1200.add(jMenu1250);

        jMenu1260.setMnemonic('6');
        jMenu1260.setText("1.2.6- Componentes");

        jMenu1261.setMnemonic('1');
        jMenu1261.setText("1.2.6.1- Componentes");
        jMenu1261.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1261ActionPerformed(evt);
            }
        });
        jMenu1260.add(jMenu1261);

        jMenu1262.setMnemonic('2');
        jMenu1262.setText("1.2.6.2- Consulta & Listado");
        jMenu1260.add(jMenu1262);

        jMenu1200.add(jMenu1260);

        jMenu1270.setMnemonic('7');
        jMenu1270.setText("1.2.7- Contraindicaciones");

        jMenu1271.setMnemonic('1');
        jMenu1271.setText("1.2.7.1- Contraindicaciones");
        jMenu1271.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1271ActionPerformed(evt);
            }
        });
        jMenu1270.add(jMenu1271);

        jMenu1272.setMnemonic('2');
        jMenu1272.setText("1.2.7.2- Consulta & Listado");
        jMenu1270.add(jMenu1272);

        jMenu1200.add(jMenu1270);

        jMenu1000.add(jMenu1200);

        jMenu1700.setMnemonic('3');
        jMenu1700.setText("1.3- Contactos");
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

    private void jMenu1141ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1141ActionPerformed
        llamarFormulario.llamarInternalFrame(new Productos(1140), escritorio);
    }//GEN-LAST:event_jMenu1141ActionPerformed

    private void jMenu1111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1111ActionPerformed
//        callMenus.Marcas(1111);
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("Ref_Marcas", 1110, true, false,
                        "Mar_Codigo", "Mar_Descrip", "Marcas"), escritorio);
    }//GEN-LAST:event_jMenu1111ActionPerformed

    private void jMenu1121ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1121ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("Ref_Lineas", 1120, true, false,
                        "Lin_Codigo", "Lin_Descrip", "Lineas"), escritorio);
    }//GEN-LAST:event_jMenu1121ActionPerformed

    private void jMenu1131ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1131ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("Ref_Envaces", 1130, true, false,
                        "Env_Codigo", "Env_Descrip", "Envaces"), escritorio);
    }//GEN-LAST:event_jMenu1131ActionPerformed

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

    private void jMenu1221ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1221ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMTresCampos("Ref_Sintomas", 1300, true, false,
                        "Sint_Codigo", "Sint_Descrip", "observacion", "Sintomas"), escritorio);
    }//GEN-LAST:event_jMenu1221ActionPerformed

    private void jMenu1231ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1231ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMTresCampos("Ref_Enfermedades", 1400, true, false,
                        "Enf_Codigo", "Enf_Descrip", "observacion", "Enfermedades"), escritorio);
    }//GEN-LAST:event_jMenu1231ActionPerformed

    private void jMenu1241ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1241ActionPerformed
        llamarFormulario.llamarInternalFrame(new Productos_Farm("Farm_Tratamientos", 1500, true, false, "Trat_Codigo",
                "Ref_Enfermedades", "Enf_Codigo", "Enf_Descrip", "Enfermedades",
                "Ref_Drogas", "Dro_Codigo", "Dro_Descrip", "Drogas",
                "observacion", "Tratamientos"), escritorio);
    }//GEN-LAST:event_jMenu1241ActionPerformed

    private void jMenu1261ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1261ActionPerformed
        llamarFormulario.llamarInternalFrame(new Productos_Farm("Farm_Componentes", 1150, true, false, "Comp_Codigo",
                "Mant_Productos", "Prod_Codigo", "Prod_Descrip", "Productos",
                "Ref_Drogas", "Dro_Codigo", "Dro_Descrip", "Drogas", "observacion",
                "Componentes"), escritorio);
    }//GEN-LAST:event_jMenu1261ActionPerformed

    private void jMenu1251ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1251ActionPerformed
        llamarFormulario.llamarInternalFrame(new Productos_Farm("Farm_Diagnosticos", 1600, true, false, "Diag_Codigo",
                "ref_enfermedades", "cod_enfermedad", "nom_enfermedad", "Enfermedades",
                "ref_sintomas", "cod_sintoma", "nom_sintoma", "Sintomas",
                "observacion", "Diagnosticos"), escritorio);
    }//GEN-LAST:event_jMenu1251ActionPerformed

    private void jMenu1271ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1271ActionPerformed
        llamarFormulario.llamarInternalFrame(new Productos_Farm("farm_contraindicaciones", 1160, true, false, "Cont_Codigo",
                "mant_productos", "cod_producto", "nombre_producto", "Productos",
                "ref_enfermedades", "cod_enfermedad", "nom_enfermedad", "Enfermedades",
                "observacion", "Contraindicaciones"), escritorio);
    }//GEN-LAST:event_jMenu1271ActionPerformed

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

    private void jMenu1211ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1211ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new ABMDosCampos("ref_drogas", 1210, true, false,
                        "Dro_Codigo", "Dro_Descrip", "Drogas"), escritorio);
    }//GEN-LAST:event_jMenu1211ActionPerformed

    private void jMenu1212ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1212ActionPerformed
        llamarFormulario.llamarInternalFrame(
                new Listar("ref_drogas", true, false,
                        "Dro_Codigo", "Dro_Descrip", "Drogas"), escritorio);
    }//GEN-LAST:event_jMenu1212ActionPerformed
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
    public static javax.swing.JMenu jMenu1110;
    public static javax.swing.JMenuItem jMenu1111;
    public static javax.swing.JMenuItem jMenu1112;
    public static javax.swing.JMenu jMenu1120;
    public static javax.swing.JMenuItem jMenu1121;
    public static javax.swing.JMenuItem jMenu1122;
    public static javax.swing.JMenu jMenu1130;
    public static javax.swing.JMenuItem jMenu1131;
    public static javax.swing.JMenuItem jMenu1132;
    public static javax.swing.JMenu jMenu1140;
    public static javax.swing.JMenuItem jMenu1141;
    public static javax.swing.JMenuItem jMenu1142;
    public static javax.swing.JMenu jMenu1200;
    private static javax.swing.JMenu jMenu1210;
    private static javax.swing.JMenuItem jMenu1211;
    private static javax.swing.JMenuItem jMenu1212;
    public static javax.swing.JMenu jMenu1220;
    public static javax.swing.JMenuItem jMenu1221;
    public static javax.swing.JMenuItem jMenu1222;
    public static javax.swing.JMenu jMenu1230;
    public static javax.swing.JMenuItem jMenu1231;
    public static javax.swing.JMenuItem jMenu1232;
    public static javax.swing.JMenu jMenu1240;
    public static javax.swing.JMenuItem jMenu1241;
    public static javax.swing.JMenuItem jMenu1242;
    public static javax.swing.JMenu jMenu1250;
    public static javax.swing.JMenuItem jMenu1251;
    public static javax.swing.JMenuItem jMenu1252;
    public static javax.swing.JMenu jMenu1260;
    public static javax.swing.JMenuItem jMenu1261;
    public static javax.swing.JMenuItem jMenu1262;
    public static javax.swing.JMenu jMenu1270;
    public static javax.swing.JMenuItem jMenu1271;
    public static javax.swing.JMenuItem jMenu1272;
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
