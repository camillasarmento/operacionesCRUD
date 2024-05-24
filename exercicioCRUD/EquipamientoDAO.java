package exercicioCRUD;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EquipamientoDAO {

    // Insert Equipamiento nuevo
    public static void insertEquipamiento(int id_equipamiento, String tipo_equipamiento, String estado,
                                          int cantidad, int id_administrador) {
        String query = "INSERT INTO equipamiento(id_equipamiento, tipo_equipamiento, estado, cantidad, id_administrador) VALUES (?,?, ?, ?, ?);";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_equipamiento);
            pstmt.setString(2, tipo_equipamiento);
            pstmt.setString(3, estado);
            pstmt.setInt(4, cantidad);
            pstmt.setInt(5, id_administrador);
            pstmt.executeUpdate();
            System.out.println("Nuevo equipamiento insertado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Print Equipamientos
    public static void printEquipamientoDetalles() {
        String query = "SELECT * FROM equipamiento;";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id_equipamiento = rs.getInt("id_equipamiento");
                String tipo_equipamiento = rs.getString("tipo_equipamiento");
                String estado = rs.getString("estado");
                int cantidad = rs.getInt("cantidad");
                int id_administrador = rs.getInt("id_administrador");
                System.out.println("ID Equipamiento: " + id_equipamiento + ", Tipo: " + tipo_equipamiento + ", Estado: " + estado + ", Cantidad: " + cantidad + ", ID Administrador: " + id_administrador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Equipamiento
    public static void deleteEquipamiento(int id_equipamiento) {
        String query = "DELETE FROM equipamiento WHERE id_equipamiento = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_equipamiento);
            pstmt.executeUpdate();
            System.out.println("Equipamiento eliminado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Equipamiento
    public static void updateEquipamiento(int id_equipamiento, String tipo_equipamiento, String estado, int cantidad) {
        String query = "UPDATE equipamiento SET tipo_equipamiento = ?, estado = ?, cantidad = ? WHERE id_equipamiento = ?;";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tipo_equipamiento);
            pstmt.setString(2, estado);
            pstmt.setInt(3, cantidad);
            pstmt.setInt(4, id_equipamiento);
            pstmt.executeUpdate();
            System.out.println("Equipamiento actualizado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
