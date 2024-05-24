package exercicioCRUD;

/**
 *
 * @author camilla
 */

import java.sql.Timestamp;

public class Recordatorio {
    private int id_recordatorio;
    private Timestamp fecha_recordatorio;
    private int tipo_recordatorio;
    private int id_usuario;
    private int id_reserva;

    public Recordatorio(int id_recordatorio, Timestamp fecha_recordatorio, int tipo_recordatorio, int id_usuario, int id_reserva) {
        this.id_recordatorio = id_recordatorio;
        this.fecha_recordatorio = fecha_recordatorio;
        this.tipo_recordatorio = tipo_recordatorio;
        this.id_usuario = id_usuario;
        this.id_reserva = id_reserva;
    }


}
