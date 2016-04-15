package com.app.form.cont.json;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class jsonInformante {

    String nombre;
    String Dv;
    String nombreFantasia;
    String domicilioEmision;
    String telefono;
    String ruc;
    String codigoEstablecimiento;
    String timbradoFactura;
    String puntoExpedicionFactura;
    Date inicioVigenciaFactura;
    String timbradoComprobante;
    String puntoExpedicionComprobante;
    Date inicioVigenciaComprobante;
    String establecimiento;

    public jsonInformante(String nombre, String Dv, String nombreFantasia, String domicilioEmision, String telefono, String ruc, String codigoEstablecimiento, String timbradoFactura, String puntoExpedicionFactura, Date inicioVigenciaFactura, String timbradoComprobante, String puntoExpedicionComprobante, Date inicioVigenciaComprobante, String establecimiento) {
        this.nombre = nombre;
        this.Dv = Dv;
        this.nombreFantasia = nombreFantasia;
        this.domicilioEmision = domicilioEmision;
        this.telefono = telefono;
        this.ruc = ruc;
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.timbradoFactura = timbradoFactura;
        this.puntoExpedicionFactura = puntoExpedicionFactura;
        this.inicioVigenciaFactura = inicioVigenciaFactura;
        this.timbradoComprobante = timbradoComprobante;
        this.puntoExpedicionComprobante = puntoExpedicionComprobante;
        this.inicioVigenciaComprobante = inicioVigenciaComprobante;
        this.establecimiento = establecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDv() {
        return Dv;
    }

    public void setDv(String Dv) {
        this.Dv = Dv;
    }

    public String getNombreFantasia() {
        return nombreFantasia;
    }

    public void setNombreFantasia(String nombreFantasia) {
        this.nombreFantasia = nombreFantasia;
    }

    public String getDomicilioEmision() {
        return domicilioEmision;
    }

    public void setDomicilioEmision(String domicilioEmision) {
        this.domicilioEmision = domicilioEmision;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(String codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public String getTimbradoFactura() {
        return timbradoFactura;
    }

    public void setTimbradoFactura(String timbradoFactura) {
        this.timbradoFactura = timbradoFactura;
    }

    public String getPuntoExpedicionFactura() {
        return puntoExpedicionFactura;
    }

    public void setPuntoExpedicionFactura(String puntoExpedicionFactura) {
        this.puntoExpedicionFactura = puntoExpedicionFactura;
    }

    public Date getInicioVigenciaFactura() {
        return inicioVigenciaFactura;
    }

    public void setInicioVigenciaFactura(Date inicioVigenciaFactura) {
        this.inicioVigenciaFactura = inicioVigenciaFactura;
    }

    public String getTimbradoComprobante() {
        return timbradoComprobante;
    }

    public void setTimbradoComprobante(String timbradoComprobante) {
        this.timbradoComprobante = timbradoComprobante;
    }

    public String getPuntoExpedicionComprobante() {
        return puntoExpedicionComprobante;
    }

    public void setPuntoExpedicionComprobante(String puntoExpedicionComprobante) {
        this.puntoExpedicionComprobante = puntoExpedicionComprobante;
    }

    public Date getInicioVigenciaComprobante() {
        return inicioVigenciaComprobante;
    }

    public void setInicioVigenciaComprobante(Date inicioVigenciaComprobante) {
        this.inicioVigenciaComprobante = inicioVigenciaComprobante;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }
}
