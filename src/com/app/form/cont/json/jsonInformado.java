package com.app.form.cont.json;

/**
 *
 * @author Diego
 */
public class jsonInformado {

    String situacion;
    String ruc;
    String dv;
    String tipoIdentificacion;
    String identificacion;
    String nombre;
    String domicilio;
    String direccion;
    String correoElectronico;
    String pais;
    String telefono;
    String tipoIdentificacionNombre;
    String paisNombre;

    public jsonInformado(String situacion, String ruc, String dv, String tipoIdentificacion, String identificacion, String nombre, String domicilio, String direccion, String correoElectronico, String pais, String telefono, String tipoIdentificacionNombre, String paisNombre) {
        this.situacion = situacion;
        this.ruc = ruc;
        this.dv = dv;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.pais = pais;
        this.telefono = telefono;
        this.tipoIdentificacionNombre = tipoIdentificacionNombre;
        this.paisNombre = paisNombre;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoIdentificacionNombre() {
        return tipoIdentificacionNombre;
    }

    public void setTipoIdentificacionNombre(String tipoIdentificacionNombre) {
        this.tipoIdentificacionNombre = tipoIdentificacionNombre;
    }

    public String getPaisNombre() {
        return paisNombre;
    }

    public void setPaisNombre(String paisNombre) {
        this.paisNombre = paisNombre;
    }
}
