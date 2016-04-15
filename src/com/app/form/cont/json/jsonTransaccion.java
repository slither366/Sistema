package com.app.form.cont.json;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class jsonTransaccion {

    String condicionCompra;
    int cuotas;
    int tipoComprobante;
    String numeroComprobanteVenta;
    Date fecha;
    String numeroTimbrado;
    String tipoComprobanteNombre;
    

    public jsonTransaccion(String condicionCompra, int cuotas, int tipoComprobante, String numeroComprobanteVenta, Date fecha, String numeroTimbrado) {
        this.condicionCompra = condicionCompra;
        this.cuotas = cuotas;
        this.tipoComprobante = tipoComprobante;
        this.numeroComprobanteVenta = numeroComprobanteVenta;
        this.fecha = fecha;
        this.numeroTimbrado = numeroTimbrado;
    }

    public String getCondicionCompra() {
        return condicionCompra;
    }

    public void setCondicionCompra(String condicionCompra) {
        this.condicionCompra = condicionCompra;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public int getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(int tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getNumeroComprobanteVenta() {
        return numeroComprobanteVenta;
    }

    public void setNumeroComprobanteVenta(String numeroComprobanteVenta) {
        this.numeroComprobanteVenta = numeroComprobanteVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroTimbrado() {
        return numeroTimbrado;
    }

    public void setNumeroTimbrado(String numeroTimbrado) {
        this.numeroTimbrado = numeroTimbrado;
    }
}
