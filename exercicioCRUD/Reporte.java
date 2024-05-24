package exercicioCRUD;

/**
 *
 * @author camilla
 */

import java.sql.Timestamp;

public class Reporte {
    private int id_reporte;
    private Timestamp fecha_reporte;
    private String descripcion;

    public Reporte(int id_reporte, Timestamp fecha_reporte, String descripcion) {
        this.id_reporte = id_reporte;
        this.fecha_reporte = fecha_reporte;
        this.descripcion = descripcion;
    }

}