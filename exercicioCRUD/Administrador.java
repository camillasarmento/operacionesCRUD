package exercicioCRUD;


public class Administrador extends Usuario {
    private int id_administrador;

    public Administrador(int id_usuario, String nombre, String apellidos, String contrasenya, String correo,
                         String rol, int id_administrador) {
        super(id_usuario, nombre, apellidos, contrasenya, correo, rol);
        this.id_administrador = id_administrador;
    }

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
    }
}

