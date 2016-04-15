package com.app.form.cont.json;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class jsonRetencion {

    Date fecha;
    String moneda;
    double tipoCambio;
    boolean retencionRenta;
    String conceptoRenta;
    boolean retencionIva;
    String conceptoIva;
    int rentaPorcentaje;
    int rentaCabezasBase;
    int rentaCabezasCantidad;
    int rentaToneladasBase;
    int rentaToneladasCantidad;
    String ivaPorcentaje5;
    String ivaPorcentaje10;

    public jsonRetencion(Date fecha, String moneda, boolean retencionRenta, String conceptoRenta, boolean retencionIva, String conceptoIva, int rentaPorcentaje, int rentaCabezasBase, int rentaCabezasCantidad, int rentaToneladasBase, int rentaToneladasCantidad, String ivaPorcentaje5, String ivaPorcentaje10) {
        this.fecha = fecha;
        this.moneda = moneda;
        this.retencionRenta = retencionRenta;
        this.conceptoRenta = conceptoRenta;
        this.retencionIva = retencionIva;
        this.conceptoIva = conceptoIva;
        this.rentaPorcentaje = rentaPorcentaje;
        this.rentaCabezasBase = rentaCabezasBase;
        this.rentaCabezasCantidad = rentaCabezasCantidad;
        this.rentaToneladasBase = rentaToneladasBase;
        this.rentaToneladasCantidad = rentaToneladasCantidad;
        this.ivaPorcentaje5 = ivaPorcentaje5;
        this.ivaPorcentaje10 = ivaPorcentaje10;
    }
}
