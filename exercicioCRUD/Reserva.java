package exercicioCRUD;

/**
 *
 * @author camilla
 */

import java.sql.Timestamp;

public class Reserva {
    private int id_reserva;
    private String codigo_reserva;
    private Timestamp fecha_inicio_reserva;
    private Timestamp fecha_fin_reserva;
    private float precio;
    private String estado_reserva;
    private boolean pago;
    private int id_usuario;

    public Reserva(int id_reserva, String codigo_reserva, Timestamp fecha_inicio_reserva, Timestamp fecha_fin_reserva,
                   float precio, String estado_reserva, boolean pago, int id_usuario) {
        this.id_reserva = id_reserva;
        this.codigo_reserva = codigo_reserva;
        this.fecha_inicio_reserva = fecha_inicio_reserva;
        this.fecha_fin_reserva = fecha_fin_reserva;
        this.precio = precio;
        this.estado_reserva = estado_reserva;
        this.pago = pago;
        this.id_usuario = id_usuario;
    }

}
