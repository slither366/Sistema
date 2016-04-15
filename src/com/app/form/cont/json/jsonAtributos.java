package com.app.form.cont.json;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class jsonAtributos {

    private Date fechaCreacion;
    private String fechaHoraCreacion;
    private String uuid;

    public jsonAtributos(Date fechaCreacion, String fechaHoraCreacion, String uuid) {
        this.fechaCreacion = fechaCreacion;
        this.fechaHoraCreacion = fechaHoraCreacion;
        this.uuid = uuid;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(String fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
