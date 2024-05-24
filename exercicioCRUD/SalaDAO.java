package exercicioCRUD;

import java.sql.*;
import java.util.*;

/**
 *
 * @author camilla
 */

public class SalaDAO {


    public static void printUserDetails() {

        String query = "SELECT * FROM salas;";
        try(Connection conn = DatabaseConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){

            while(rs.next()){
                int id_sala = rs.getInt("id_sala");
                int capacidad = rs.getInt("capacidad");
                int superficie = rs.getInt("superficie");
                boolean disponibilidad = rs.getBoolean("disponibilidad");
                String ubicacion = rs.getString("ubicacion");
                String descripcion = rs.getString("descripcion");
                System.out.println(" ID: " + id_sala + " , ubicacion: " + ubicacion + " , descripcion: " + descripcion
                + " , disponibilidad: " + disponibilidad + " , capacidad: " + capacidad + ", superficie: " + superficie);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public static void insertSala(int id_sala, int capacidad, int superficie, Boolean disponibilidad, String ubicacion,
                                  String descripcion){
        String query = "INSERT INTO salas(id_sala, capacidad, superficie, disponibilidad, ubicacion, descripcion ) VALUES (?,?,?,?,?,?);";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, id_sala);
            pstmt.setInt(2, capacidad);
            pstmt.setInt(3, superficie);
            pstmt.setBoolean(4, disponibilidad);
            pstmt.setString(5, ubicacion);
            pstmt.setString(6, descripcion);
            pstmt.executeUpdate();
            System.out.println("Nueva sala insertada!");

        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    public static void deleteSala(int id_sala, String descripcion){
        String query = "DELETE FROM usuario where id_sala = ? and descripcion = ? ;";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, id_sala);
            pstmt.setString(2, descripcion);
            pstmt.executeUpdate();
            System.out.println("Sala eliminada!");

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public List<Sala> getAllSalas() throws SQLException {
        List<Sala> salaList = new ArrayList<>();
        String sql = "SELECT * FROM salas";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Sala sala = new Sala(
                        rs.getInt("id_sala"),
                        rs.getInt("capacidad"),
                        rs.getInt("superficie"),
                        rs.getBoolean("disponibilidad"),
                        rs.getString("ubicacion"),
                        rs.getString("descripcion")
                );
                salaList.add(sala);
            }
        }
        return salaList;
    }

}

