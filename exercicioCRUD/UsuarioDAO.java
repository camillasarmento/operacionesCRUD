package exercicioCRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camilla
 */

public class UsuarioDAO {


    public static void printUserDetails() {

        String query = "SELECT * FROM usuario;";
        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){

            while(rs.next()){
                int id_usuario = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String correo = rs.getString("correo");
                System.out.println(" ID: " + id_usuario + " , nombre usuario: " + nombre + apellidos + " , email: " + correo);


            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public static void insertUsuario(String nombre, String apellidos, String contrasenya, String correo){
        String query = "INSERT INTO usuario(nombre, apellidos,contrasenya,correo) VALUES (?,?,?,?);";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, contrasenya);
            pstmt.setString(4, correo);
            pstmt.executeUpdate();
            System.out.println("Nuevo usuario insertado!");

        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    public static void deleteUsuario(int id_usuario, String nombre, String apellidos){
        String query = "DELETE FROM usuario where id_usuario = ? and nombre = ? and apellidos = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, id_usuario);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellidos);
            pstmt.executeUpdate();
            System.out.println("Usuario eliminado!");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public static void updateUsuarioCorreo(String nombre, String apellidos, String newCorreo){
        String query = "UPDATE usuario SET correo = ? WHERE nombre = ? and apellidos = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){

            pstmt.setString(1, newCorreo);
            pstmt.setString(2, nombre);
            pstmt.setString(3, apellidos);
            pstmt.executeUpdate();

            System.out.println("Email actualizado!");

        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    public static String getUsuarioCorreo(String nombre, String apellidos){
        String correo = "";
        String query = "SELECT correo FROM usuario where nombre = ? and apellidos = ?;";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){

            pstmt.setString(1,nombre);
            pstmt.setString(2, apellidos);

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                correo = rs.getString("correo");
                System.out.println(" email: " + correo );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return correo;
    }

    public List<Usuario> getAllUsuario() throws SQLException {
        List<Usuario> usuarioList = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("contrasenya"),
                        rs.getString("correo"),
                        rs.getString("rol")
                );
                usuarioList.add(usuario);
            }
        }
        return usuarioList;
    }

        // Inserir nuevo administrador
        public static void insertAdministrador(String nombre, String apellidos, String contrasenya, String correo, int id_administrador) {
            String query = "INSERT INTO usuario(nombre, apellidos, contrasenya, correo, rol) VALUES (?, ?, ?, ?, 'admin');";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setString(1, nombre);
                pstmt.setString(2, apellidos);
                pstmt.setString(3, contrasenya);
                pstmt.setString(4, correo);
                pstmt.executeUpdate();
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int id_usuario = rs.getInt(1);
                    insertAdministradorDetalles(id_usuario, id_administrador);
                }
                System.out.println("Nuevo administrador insertado!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Insert Administrador tabla
        private static void insertAdministradorDetalles(int id_usuario, int id_administrador) {
            String query = "INSERT INTO administrador(id_administrador, id_usuario) VALUES (?, ?);";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, id_administrador);
                pstmt.setInt(2, id_usuario);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Print Administradores
        public static void printAdministradorDetalles() {
            String query = "SELECT u.id_usuario, u.nombre, u.apellidos, u.correo, a.id_administrador FROM usuario u JOIN administrador a ON u.id_usuario = a.id_usuario;";
            try (Connection conn = DatabaseConnection.getConnection();
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    int id_usuario = rs.getInt("id_usuario");
                    String nombre = rs.getString("nombre");
                    String apellidos = rs.getString("apellidos");
                    String correo = rs.getString("correo");
                    int id_administrador = rs.getInt("id_administrador");
                    System.out.println("ID Usuario: " + id_usuario + ", Nombre: " + nombre + " " + apellidos + ", Correo: " + correo + ", ID Administrador: " + id_administrador);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Delete Administrador
        public static void deleteAdministrador(int id_administrador) {
            String query = "DELETE FROM administrador WHERE id_administrador = ?";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setInt(1, id_administrador);
                pstmt.executeUpdate();
                System.out.println("Administrador eliminado!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Update Administrador Correo
        public static void updateAdministradorCorreo(int id_administrador, String newCorreo) {
            String query = "UPDATE usuario SET correo = ? WHERE id_usuario = (SELECT id_usuario FROM administrador WHERE id_administrador = ?);";
            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, newCorreo);
                pstmt.setInt(2, id_administrador);
                pstmt.executeUpdate();
                System.out.println("Correo de administrador actualizado!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }




