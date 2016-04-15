package com.app.paleta;

import com.app.config.Configuracion;

/**
 *
 * @author Diego
 */
public class txtCodigo extends textoPadre {

    public txtCodigo() {
        this.setText("txtCodigo");
        this.setToolTipText("Ingrese el código del Registro...");
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

    public void setCodigo(int valor) {
        this.setText(valor + "");
    }

    @Override
    public boolean isEmpty() {
        return this.getCodigo() == 0 ? true : "".equals(this.getText().trim());
    }

    /*
     * Variables en donde se va a guardar los parametros de tabla, codigo, 
     descripcion y titulo a cual va a representar
     */
    private String bdTabla, bdCodigo, bdDescrip, bdTitulo;

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
}
