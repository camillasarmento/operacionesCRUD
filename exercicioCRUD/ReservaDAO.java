package exercicioCRUD;

/**
 *
 * @author camilla
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    // Insert Reserva nueva
    public static void insertReserva(String codigo_reserva, Timestamp fecha_inicio_reserva, Timestamp fecha_fin_reserva, float precio, String estado_reserva, boolean pago, int id_usuario) {
        String query = "INSERT INTO reserva(codigo_reserva, fecha_inicio_reserva, fecha_fin_reserva, precio, estado_reserva, pago, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, codigo_reserva);
            pstmt.setTimestamp(2, fecha_inicio_reserva);
            pstmt.setTimestamp(3, fecha_fin_reserva);
            pstmt.setFloat(4, precio);
            pstmt.setString(5, estado_reserva);
            pstmt.setBoolean(6, pago);
            pstmt.setInt(7, id_usuario);
            pstmt.executeUpdate();
            System.out.println("Nueva reserva insertada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Print todas Reservas
    public static void printReservaDetails() {
        String query = "SELECT * FROM reserva;";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String codigo_reserva = rs.getString("codigo_reserva");
                Timestamp fecha_inicio_reserva = rs.getTimestamp("fecha_inicio_reserva");
                Timestamp fecha_fin_reserva = rs.getTimestamp("fecha_fin_reserva");
                float precio = rs.getFloat("precio");
                String estado_reserva = rs.getString("estado_reserva");
                boolean pago = rs.getBoolean("pago");
                int id_usuario = rs.getInt("id_usuario");
                System.out.println(" Código: " + codigo_reserva + ", Fecha Inicio: " + fecha_inicio_reserva + ", Fecha Fin: " + fecha_fin_reserva + ", Precio: " + precio + ", Estado: " + estado_reserva + ", Pago: " + pago + ", ID Usuario: " + id_usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Reserva
    public static void deleteReserva(int id_reserva) {
        String query = "DELETE FROM reserva WHERE id_reserva = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id_reserva);
            pstmt.executeUpdate();
            System.out.println("Reserva eliminada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Reserva
    public static void updateReserva(int id_reserva, String codigo_reserva, Timestamp fecha_inicio_reserva, Timestamp fecha_fin_reserva, float precio, String estado_reserva, boolean pago) {
        String query = "UPDATE reserva SET codigo_reserva = ?, fecha_inicio_reserva = ?, fecha_fin_reserva = ?, precio = ?, estado_reserva = ?, pago = ? WHERE id_reserva = ?;";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, codigo_reserva);
            pstmt.setTimestamp(2, fecha_inicio_reserva);
            pstmt.setTimestamp(3, fecha_fin_reserva);
            pstmt.setFloat(4, precio);
            pstmt.setString(5, estado_reserva);
            pstmt.setBoolean(6, pago);
            pstmt.setInt(7, id_reserva);
            pstmt.executeUpdate();
            System.out.println("Reserva actualizada!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
