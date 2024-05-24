package exercicioCRUD;

/**
 *
 * @author camilla
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO {

    // Insert nuevo Reporte
    public static void insertReporte(Timestamp fecha_reporte, String descripcion) {
        String query = "INSERT INTO reportes(fecha_reporte, descripcion) VALUES (?, ?);";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setTimestamp(1, fecha_reporte);
            pstmt.setString(2, descripcion);
            pstmt.executeUpdate();
            System.out.println("Nuevo reporte insertado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Print todos Reportes
    public static void printReporteDetails() {
        String query = "SELECT * FROM reportes;";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id_reporte = rs.getInt("id_reporte");
                Timestamp fecha_reporte = rs.getTimestamp("fecha_reporte");
                String descripcion = rs.getString("descripcion");
                System.out.println("ID Reporte: " + id_reporte + ", Fecha: " + fecha_reporte + ", Descripción: " + descripcion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Reporte
    public static void deleteReporte(int id_reporte) {
        String query = "DELETE FROM reportes WHERE id_reporte = ?;";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_reporte);
            pstmt.executeUpdate();
            System.out.println("Reporte eliminado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Reporte
    public static void updateReporte(int id_reporte, Timestamp fecha_reporte, String descripcion) {
        String query = "UPDATE reportes SET fecha_reporte = ?, descripcion = ? WHERE id_reporte = ?;";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setTimestamp(1, fecha_reporte);
            pstmt.setString(2, descripcion);
            pstmt.setInt(3, id_reporte);
            pstmt.executeUpdate();
            System.out.println("Reporte actualizado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
