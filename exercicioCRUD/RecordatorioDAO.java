package exercicioCRUD;

/**
 *
 * @author camilla
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordatorioDAO {

    // Insert nuevo Recordatorio
    public static void insertRecordatorio(Timestamp fecha_recordatorio, int tipo_recordatorio, int id_usuario, int id_reserva) {
        String query = "INSERT INTO recordatorios(fecha_recordatorio, tipo_recordatorio, id_usuario, id_reserva) VALUES (?, ?, ?, ?);";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setTimestamp(1, fecha_recordatorio);
            pstmt.setInt(2, tipo_recordatorio);
            pstmt.setInt(3, id_usuario);
            pstmt.setInt(4, id_reserva);
            pstmt.executeUpdate();
            System.out.println("Nuevo recordatorio insertado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Print todos Recordatorios
    public static void printRecordatorioDetails() {
        String query = "SELECT * FROM recordatorios;";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                int id_recordatorio = rs.getInt("id_recordatorio");
                Timestamp fecha_recordatorio = rs.getTimestamp("fecha_recordatorio");
                int tipo_recordatorio = rs.getInt("tipo_recordatorio");
                int id_usuario = rs.getInt("id_usuario");
                int id_reserva = rs.getInt("id_reserva");
                System.out.println("ID Recordatorio: " + id_recordatorio + ", Fecha: " + fecha_recordatorio + ", Tipo: " + tipo_recordatorio + ", ID Usuario: " + id_usuario + ", ID Reserva: " + id_reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Recordatorio
    public static void deleteRecordatorio(int id_recordatorio) {
        String query = "DELETE FROM recordatorios WHERE id_recordatorio = ?;";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_recordatorio);
            pstmt.executeUpdate();
            System.out.println("Recordatorio eliminado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Recordatorio
    public static void updateRecordatorio(int id_recordatorio, Timestamp fecha_recordatorio, int tipo_recordatorio, int id_usuario, int id_reserva) {
        String query = "UPDATE recordatorios SET fecha_recordatorio = ?, tipo_recordatorio = ?, id_usuario = ?, id_reserva = ? WHERE id_recordatorio = ?;";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setTimestamp(1, fecha_recordatorio);
            pstmt.setInt(2, tipo_recordatorio);
            pstmt.setInt(3, id_usuario);
            pstmt.setInt(4, id_reserva);
            pstmt.setInt(5, id_recordatorio);
            pstmt.executeUpdate();
            System.out.println("Recordatorio actualizado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

