package com.app.form.cont.json;

/**
 *
 * @author Diego
 */
public class jsonTOTALES {

    double impuestoTotalExento;
    double impuestoTotalAl5;
    double impuestoTotalAl10;
    double valorTotalExento;
    double valorTotalAl5;
    double valorTotalAl10;
    double impuestoTotal;
    double valorTotal;

    public jsonTOTALES(double impuestoTotalExento, double impuestoTotalAl5, double impuestoTotalAl10, double valorTotalExento, double valorTotalAl5, double valorTotalAl10, double impuestoTotal, double valorTotal) {
        this.impuestoTotalExento = impuestoTotalExento;
        this.impuestoTotalAl5 = impuestoTotalAl5;
        this.impuestoTotalAl10 = impuestoTotalAl10;
        this.valorTotalExento = valorTotalExento;
        this.valorTotalAl5 = valorTotalAl5;
        this.valorTotalAl10 = valorTotalAl10;
        this.impuestoTotal = impuestoTotal;
        this.valorTotal = valorTotal;
    }

    public double getImpuestoTotalExento() {
        return impuestoTotalExento;
    }

    public void setImpuestoTotalExento(double impuestoTotalExento) {
        this.impuestoTotalExento = impuestoTotalExento;
    }

    public double getImpuestoTotalAl5() {
        return impuestoTotalAl5;
    }

    public void setImpuestoTotalAl5(double impuestoTotalAl5) {
        this.impuestoTotalAl5 = impuestoTotalAl5;
    }

    public double getImpuestoTotalAl10() {
        return impuestoTotalAl10;
    }

    public void setImpuestoTotalAl10(double impuestoTotalAl10) {
        this.impuestoTotalAl10 = impuestoTotalAl10;
    }

    public double getValorTotalExento() {
        return valorTotalExento;
    }

    public void setValorTotalExento(double valorTotalExento) {
        this.valorTotalExento = valorTotalExento;
    }

    public double getValorTotalAl5() {
        return valorTotalAl5;
    }

    public void setValorTotalAl5(double valorTotalAl5) {
        this.valorTotalAl5 = valorTotalAl5;
    }

    public double getValorTotalAl10() {
        return valorTotalAl10;
    }

    public void setValorTotalAl10(double valorTotalAl10) {
        this.valorTotalAl10 = valorTotalAl10;
    }

    public double getImpuestoTotal() {
        return impuestoTotal;
    }

    public void setImpuestoTotal(double impuestoTotal) {
        this.impuestoTotal = impuestoTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
