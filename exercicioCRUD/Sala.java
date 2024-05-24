package exercicioCRUD;

public class Sala {
    private int idSala;
    private int superficie;
    private int capacidad;
    private boolean disponibilidad;
    private String ubicacion;
    private String descripcion;

    public Sala(int idSala, int superficie, int capacidad, boolean disponibilidad, String ubicacion,
                 String descripcion) {
        this.idSala = idSala;
        this.superficie = superficie;
        this.capacidad = capacidad;
        this.disponibilidad = disponibilidad;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }


}
