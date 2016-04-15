package com.app.form.cont.json;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class json {

    private final jsonAtributos atributos;
    private final jsonInformado informado;
    private final jsonTransaccion transaccion;
    private final ArrayList detalle;
    private final jsonRetencion retencion;

    public json(jsonAtributos atributos, jsonInformado informado, jsonTransaccion transaccion, ArrayList<jsonDetalle> detalle, jsonRetencion retencion) {
        this.atributos = atributos;
        this.informado = informado;
        this.transaccion = transaccion;
        this.detalle = detalle;
        this.retencion = retencion;
    }

    public jsonAtributos getAtributos() {
        return atributos;
    }

    public jsonInformado getInformado() {
        return informado;
    }

    public jsonTransaccion getTransaccion() {
        return transaccion;
    }

    public ArrayList getDetalle() {
        return detalle;
    }

    public jsonRetencion getRetencion() {
        return retencion;
    }
}
