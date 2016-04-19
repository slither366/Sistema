package com.app.clases;

import com.app.botones.btnBorrar;
import com.app.botones.btnBuscarAnterior;
import com.app.botones.btnBuscarPrimero;
import com.app.botones.btnBuscarSiguiente;
import com.app.botones.btnBuscarUltimo;
import com.app.botones.btnCancelar;
import com.app.botones.btnExportar;
import com.app.botones.btnGrabar;
import com.app.botones.btnImpresora;
import com.app.botones.btnEditar;
import com.app.botones.btnNuevo;
import com.app.botones.btnPantalla;
import com.app.botones.btnSalir;

/**
 *
 * @author Diego
 */
public class ClaseBotones {

    /**
     * Metodo para habilitar botonesABM
     * <>Recibe como parametro los botones y el estado Booleano (true, false)
     *
     * @param Nuevo
     * @param Modificar
     * @param Borrar
     * @param Grabar
     * @param Cancelar
     * @param Salir
     * @param bl
     */
    public static final void modoEdicionABM(btnNuevo Nuevo, btnEditar Modificar, btnBorrar Borrar,
            btnGrabar Grabar, btnCancelar Cancelar, btnSalir Salir, boolean bl) {
        Nuevo.setEnabled(bl);
        Modificar.setEnabled(bl);
        Borrar.setEnabled(bl);
        Grabar.setEnabled(!bl);
        Cancelar.setEnabled(!bl);
        Salir.setEnabled(bl);
    }

    /**
     * Metodo para habilidar botones Buscar
     * <>Recibe como parametro los botones y el estado Booleano (true, false)
     *
     * @param primero
     * @param anterior
     * @param siguiente
     * @param ultimo
     * @param bl
     */
    public static final void modoEdicionBuscar(btnBuscarPrimero primero, btnBuscarAnterior anterior,
            btnBuscarSiguiente siguiente, btnBuscarUltimo ultimo, boolean bl) {
        primero.setEnabled(bl);
        anterior.setEnabled(bl);
        siguiente.setEnabled(bl);
        ultimo.setEnabled(bl);
    }

    /**
     * Metodo para fijar el KeyPressed a los botonesABM
     * <>Recibe como parametros los botones
     * <>Este metodo es para que los botones se comporten mas amigable al
     * usuario para poder moverse por los botones usando las teclas de direccion
     *
     * @param Nuevo
     * @param Modificar
     * @param Borrar
     * @param Grabar
     * @param Cancelar
     * @param Salir
     */
    public static void botonesABMKeyPressed(final btnNuevo Nuevo, final btnEditar Modificar, final btnBorrar Borrar,
            final btnGrabar Grabar, final btnCancelar Cancelar, final btnSalir Salir) {
        Nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        Salir.grabFocus();
                        break;
                    case 39://siguiente
                        if (Modificar.isEnabled()) {
                            Modificar.grabFocus();
                        } else if (Borrar.isEnabled()) {
                            Borrar.grabFocus();
                        } else {
                            Salir.grabFocus();
                        }
                        break;
                    case 10://Enter
                        Nuevo.doClick();
                        break;
                }
            }
        });

        Modificar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        if (Nuevo.isEnabled()) {
                            Nuevo.grabFocus();
                        } else {
                            Salir.grabFocus();
                        }
                        break;
                    case 39://siguiente
                        if (Borrar.isEnabled()) {
                            Borrar.grabFocus();
                        } else {
                            Salir.grabFocus();
                        }
                        break;
                    case 10://Enter
                        Modificar.doClick();
                        break;
                }
            }
        });

        Borrar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        if (Modificar.isEnabled()) {
                            Modificar.grabFocus();
                        } else if (Nuevo.isEnabled()) {
                            Nuevo.grabFocus();
                        } else {
                            Salir.grabFocus();
                        }
                        break;
                    case 39://siguiente                        
                            Salir.grabFocus();                        
                        break;
                    case 10://Enter
                        Borrar.doClick();
                        break;
                }
            }
        });

        Grabar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        Cancelar.grabFocus();
                        break;
                    case 39://siguiente
                        Cancelar.grabFocus();
                        break;
                    case 10://Enter
                        Grabar.doClick();
                        break;
                }
            }
        });

        Cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        Grabar.grabFocus();
                        break;
                    case 39://siguiente                        
                        Grabar.grabFocus();
                        break;
                    case 10://Enter
                        Cancelar.doClick();
                        break;
                }
            }
        });

        Salir.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        if (Borrar.isEnabled()) {
                            Borrar.grabFocus();
                        } else if (Modificar.isEnabled()) {
                            Modificar.grabFocus();
                        } else if (Nuevo.isEnabled()) {
                            Nuevo.grabFocus();
                        } else {
                            Salir.grabFocus();
                        }
                        break;
                    case 39://siguiente
                        if (Nuevo.isEnabled()) {
                            Nuevo.grabFocus();
                        } else if (Modificar.isEnabled()) {
                            Modificar.grabFocus();
                        } else if (Borrar.isEnabled()) {
                            Borrar.grabFocus();
                        } else {
                            Salir.grabFocus();
                        }
                        break;
                    case 10://Enter
                        Salir.doClick();
                        break;
                }
            }
        });
    }

    /**
     * Metodo para fijar el KeyPressed a los Botones Buscar
     * <>Recibe como parametros los botones
     * <>Este metodo es para que los botones se comporten mas amigable al
     * usuario para poder moverse por los botones usando las teclas de direccion
     *
     * @param primero
     * @param anterior
     * @param siguiente
     * @param ultimo
     */
    public static void botonesBUSCARKeyPressed(final btnBuscarPrimero primero, final btnBuscarAnterior anterior,
            final btnBuscarSiguiente siguiente, final btnBuscarUltimo ultimo) {
        primero.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        ultimo.grabFocus();
                        break;
                    case 39://siguiente
                        anterior.grabFocus();
                        break;
                    case 10://Enter
                        primero.doClick();
                        break;
                }
            }
        });

        anterior.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        primero.grabFocus();
                        break;
                    case 39://siguiente
                        siguiente.grabFocus();
                        break;
                    case 10://Enter
                        anterior.doClick();
                        break;
                }
            }
        });

        siguiente.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        anterior.grabFocus();
                        break;
                    case 39://siguiente
                        ultimo.grabFocus();
                        break;
                    case 10://Enter
                        siguiente.doClick();
                        break;
                }
            }
        });

        ultimo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        siguiente.grabFocus();
                        break;
                    case 39://siguiente
                        primero.grabFocus();
                        break;
                    case 10://Enter
                        ultimo.doClick();
                        break;
                }
            }
        });
    }

    /**
     * Metodo para fijar el KeyPressed a los botonesReporte
     * <>Recibe como parametros los botones
     * <>Este metodo es para que los botones se comporten mas amigable al
     * usuario para poder moverse por los botones usando las teclas de direccion
     *
     * @param Nuevo
     * @param Pantalla
     * @param Cancelar
     * @param Exportar
     * @param Impresora
     * @param Salir
     */
    public static void botonesReporte(final btnNuevo Nuevo, final btnPantalla Pantalla, final btnImpresora Impresora,
            final btnExportar Exportar, final btnCancelar Cancelar, final btnSalir Salir) {
        Nuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        Salir.grabFocus();
                        break;
                    case 39://siguiente
                        Salir.grabFocus();
                        break;
                    case 10://Enter
                        Nuevo.doClick();
                        break;
                }
            }
        });
        Salir.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        Nuevo.grabFocus();
                        break;
                    case 39://siguiente
                        Nuevo.grabFocus();
                        break;
                    case 10://Enter
                        Salir.doClick();
                        break;
                }
            }
        });
        Pantalla.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        Cancelar.grabFocus();
                        break;
                    case 39://siguiente
                        Impresora.grabFocus();
                        break;
                    case 10://Enter
                        Pantalla.doClick();
                        break;
                }
            }
        });
        Impresora.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        Pantalla.grabFocus();
                        break;
                    case 39://siguiente
                        Exportar.grabFocus();
                        break;
                    case 10://Enter
                        Impresora.doClick();
                        break;
                }
            }
        });
        Exportar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        Impresora.grabFocus();
                        break;
                    case 39://siguiente
                        Cancelar.grabFocus();
                        break;
                    case 10://Enter
                        Exportar.doClick();
                        break;
                }
            }
        });
        Cancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case 37://Atras
                        if (Exportar.isEnabled()) {
                            Exportar.grabFocus();
                        }
                        break;
                    case 39://siguiente
                        if (Pantalla.isEnabled()) {
                            Pantalla.grabFocus();
                        }
                        break;
                    case 10://Enter
                        Cancelar.doClick();
                        break;
                }
            }
        });
    }
}
