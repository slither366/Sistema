package com.app.form.cont.json;

/**
 *
 * @author Diego
 */
public class jsonDetalle {

    double cantidad;
    int tasaAplica;
    double precioUnitario;
    String descripcion;

    public jsonDetalle(double cantidad, int tasaAplica, double precioUnitario, String descripcion) {
        this.cantidad = cantidad;
        this.tasaAplica = tasaAplica;
        this.precioUnitario = precioUnitario;
        this.descripcion = descripcion;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTasaAplica() {
        return tasaAplica;
    }

    public void setTasaAplica(int tasaAplica) {
        this.tasaAplica = tasaAplica;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
