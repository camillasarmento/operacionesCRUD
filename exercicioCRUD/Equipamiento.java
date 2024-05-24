package exercicioCRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Equipamiento {
    private int id_equipamiento;
    private String tipo_equipamiento;
    private String estado;
    private Date fecha_recepcion;
    private int cantidad;
    private int id_administrador;

    public Equipamiento(int id_equipamiento, String tipo_equipamiento, String estado,int cantidad, int id_administrador) {
        this.id_equipamiento = id_equipamiento;
        this.tipo_equipamiento = tipo_equipamiento;
        this.estado = estado;
        this.cantidad = cantidad;
        this.id_administrador = id_administrador;
    }


}

