package com.app.form.cont.json;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Diego
 */
public class main {

    public static void main(String[] args) {
        List<json> json = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            Date fechaCreacion = new Date();
            String fechaHoraCreacion = "2016-02-25 16:30:00";

            List<jsonDetalle> det = new ArrayList<>();
            det.add(new jsonDetalle(25.25, 100, 15.5, "detalle"));            

            json.add(new json(
                    new jsonAtributos(fechaCreacion, fechaHoraCreacion,"uuid"),
                    new jsonInformado(fechaHoraCreacion, fechaHoraCreacion, fechaHoraCreacion, fechaHoraCreacion, "", fechaHoraCreacion, fechaHoraCreacion, fechaHoraCreacion, fechaHoraCreacion, fechaHoraCreacion, fechaHoraCreacion, fechaHoraCreacion, fechaHoraCreacion),
                    new jsonTransaccion(fechaHoraCreacion, i, i, fechaHoraCreacion, fechaCreacion, fechaHoraCreacion),
                    (ArrayList<jsonDetalle>) det,
                    new jsonRetencion(fechaCreacion, fechaHoraCreacion, true, fechaHoraCreacion, true, fechaHoraCreacion, i, i, i, i, i, fechaHoraCreacion, fechaHoraCreacion)
            ));
        }
        Gson gson = new Gson();

        String valor = gson.toJson(json);

        System.out.println(valor);
    }
}
