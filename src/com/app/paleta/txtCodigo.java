package com.app.paleta;

import com.app.clases.ClaseTeclas;
import com.app.config.Configuracion;
import com.app.config.MensajeSistema;
import com.app.form.Especiales.Buscar;
import com.app.form.Especiales.frm_Padre;
import static com.app.form.Especiales.frm_Padre.EMP_CODIGO;
import static com.app.form.Especiales.frm_Padre.SUC_CODIGO;
import static com.app.form.Especiales.frm_Padre.getConexion;
import java.awt.event.KeyEvent;

/**
 *
 * @author Diego
 */
public class txtCodigo extends textoPadre {

    public txtCodigo() {
        this.setText("txtCodigo");
        this.setToolTipText("Ingrese el código del Registro...");
        this.addKeyListener(new java.awt.event.KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == ClaseTeclas.VK_F5()) {
                    Buscar();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (!Configuracion.getCODIGO_BUSCAR().isEmpty()) {
                    setText(Configuracion.getCODIGO_BUSCAR());
                    Configuracion.setCODIGO_BUSCAR("");
                }
                setSeleccionarCampo();
            }
        });
        this.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soloNumero(evt);
            }
        });
    }

    /**
     * Metodo que recupera el Codigo que se busco con el Formulario de Busqueda
     */
    public void recuperarCodigo() {
        if (!Configuracion.getCODIGO_BUSCAR().isEmpty()) {
            this.setText(Configuracion.getCODIGO_BUSCAR());
            Configuracion.setCODIGO_BUSCAR("");
        }
    }

    /**
     * Metodo que retorna el valor del campo formateado en Integer
     *
     * @return
     */
    public int getCodigo() {
        return this.getText().trim().isEmpty() ? 0 : Integer.parseInt(this.getText());
    }

    /**
     * Metodo que recibe el valor numerico para el campo de codigo
     *
     * @param valor
     */
    public void setCodigo(int valor) {
        this.setText(valor + "");
    }

    @Override
    public boolean isEmpty() {
        return this.getCodigo() == 0 ? true : "".equals(this.getText().trim());
    }

    /**
     * Variables en donde se va a guardar los parametros de tabla, codigo,
     * descripcion y titulo a cual va a representar
     */
    private String bdTabla, bdCodigo, bdDescrip, bdTitulo;
    private boolean UsarEmpresa = false, UsarSucursal = false, Buscar = true;

    /**
     * Metodo que retorna el nombre de la Tabla del campo
     *
     * @return
     */
    public String getBdTabla() {
        return bdTabla;
    }

    /**
     * Metodo que recibe el nombre de la Tabla del campo
     *
     * @param bdTabla
     */
    public void setBdTabla(String bdTabla) {
        this.bdTabla = bdTabla;
    }

    /**
     * Metodo que retorna el nombre del campo Codigo de la Tabla
     *
     * @return
     */
    public String getBdCodigo() {
        return bdCodigo;
    }

    /**
     * Metodo que recibe el nombre de la Codigo de la Tabla
     *
     * @param bdCodigo
     */
    public void setBdCodigo(String bdCodigo) {
        this.bdCodigo = bdCodigo;
    }

    /**
     * Metodo que retorna el nombre del campo Descripcion de la Tabla
     *
     * @return
     */
    public String getBdDescrip() {
        return bdDescrip;
    }

    /**
     * Metodo que recibe el nombre de la descripcion de la Tabla
     *
     * @param bdDescrip
     */
    public void setBdDescrip(String bdDescrip) {
        this.bdDescrip = bdDescrip;
    }

    /**
     * Metodo que retorna el Titulo que se va a poner en el Buscador
     *
     * @return
     */
    public String getBdTitulo() {
        return bdTitulo;
    }

    /**
     * Metodo que recibe el nombre de la descripcion de la Tabla
     *
     * @param bdTitulo
     */
    public void setBdTitulo(String bdTitulo) {
        this.bdTitulo = bdTitulo;
    }

    public void setUsarEmpresa(boolean UsarEmpresa) {
        this.UsarEmpresa = UsarEmpresa;
    }

    public boolean isUsarEmpresa() {
        return this.UsarEmpresa;
    }

    public void setUsarSucursal(boolean UsarSucursal) {
        this.UsarSucursal = UsarSucursal;
    }

    public boolean isUsarSucursal() {
        return this.UsarSucursal;
    }

    public boolean isBuscar() {
        return Buscar;
    }

    public void setBuscar(boolean Buscar) {
        this.Buscar = Buscar;
    }

    /**
     * Metodo que retorna la descripcion del codigo que se carga en el campo
     *
     * @return
     */
    public String getDescripcion() {
        String[] condicion, valores;
        if (this.isUsarEmpresa() && this.isUsarSucursal()) {
            condicion = new String[]{frm_Padre.EMP_CODIGO, frm_Padre.SUC_CODIGO, getBdCodigo()};
            valores = new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), this.getText()};
        } else if (this.isUsarEmpresa()) {
            condicion = new String[]{frm_Padre.EMP_CODIGO, getBdCodigo()};
            valores = new String[]{Configuracion.getEMP_CODIGO(), this.getText()};
        } else {
            condicion = new String[]{getBdCodigo()};
            valores = new String[]{this.getText()};
        }
        return getConexion.getDescripcion(this.getBdTabla(), this.getBdDescrip(), condicion, valores);
    }

    /**
     * Metodo que es para mostrar el formulario de busqueda
     */
    public void Buscar() {
        if (isBuscar()) {
            Buscar buscar = new Buscar(null, true, getBdTabla(), isUsarEmpresa(), isUsarSucursal(),
                    getBdCodigo(), getBdDescrip(), getBdTitulo(), frm_Padre.getConexion);
            buscar.setVisible(true);
            this.requestFocus();
        }
    }

    /**
     * Metodo para obtener el ultimo nro mas uno de una tabla e insertar el
     * valor devuelto en un JTextField que recibe como parametro.
     *
     * @return
     */
    public boolean autoNumerico() {
        String[] condicion, valores;
        if (this.isUsarEmpresa() && this.isUsarSucursal()) {
            condicion = new String[]{frm_Padre.EMP_CODIGO, frm_Padre.SUC_CODIGO};
            valores = new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO()};
        } else if (this.isUsarEmpresa()) {
            condicion = new String[]{frm_Padre.EMP_CODIGO};
            valores = new String[]{Configuracion.getEMP_CODIGO()};
        } else {
            condicion = new String[]{null};
            valores = new String[]{null};
        }
        int valor = frm_Padre.getConexion.getMAX(this.getBdTabla(), this.getBdCodigo(), condicion, valores);
        if (valor >= 0) {
            this.setCodigo(valor + 1);
            return true;
        }
        return false;
    }

    /**
     * Metodo que sirve para borrar el registro actual del campo txtCodigo
     *
     * @return
     */
    public boolean Borrar() {
        if (MensajeSistema.Eliminar()) {
            if (UsarEmpresa && UsarSucursal) {
                return getConexion.eliminar(getBdTabla(),
                        new String[]{EMP_CODIGO, SUC_CODIGO, getBdCodigo()},
                        new String[]{Configuracion.getEMP_CODIGO(), Configuracion.getSUC_CODIGO(), this.getText()});
            } else if (UsarEmpresa) {
                return getConexion.eliminar(getBdTabla(),
                        new String[]{EMP_CODIGO, getBdCodigo()},
                        new String[]{Configuracion.getEMP_CODIGO(), this.getText()});
            } else {
                return getConexion.eliminar(getBdTabla(), getBdCodigo(), this.getText());
            }
        }
        return false;
    }
}
