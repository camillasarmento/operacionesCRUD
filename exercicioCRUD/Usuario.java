package exercicioCRUD;


/**
 *
 * @author camilla
 */
public class Usuario {
    protected int id_usuario;
    protected String nombre;
    protected String apellidos;
    protected String correo;
    protected String contrasenya;
    protected String rol;


public Usuario(int id_usuario, String nombre, String apellidos, String correo, String contrasenya,
               String rol) {
    this.id_usuario = id_usuario;
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.correo = correo;
    this.contrasenya = contrasenya;
    this.rol = rol;
    }


}


   /* public String getEmail(){
        return UserDAO.getUserEmail(this.userName);
    }

    public void setEmail(String newEmail){
        UserDAO.updateUserEmail(this.userName, newEmail);
    }



}*/