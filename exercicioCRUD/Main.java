package exercicioCRUD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camilla
 */
public class Main {

    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();

        //USUARIO

        // Inserir usuarios nuevos
        usuarioDAO.insertUsuario("Juan", "Pérez", "contrasena123", "juan.perez@newexample.com");
        usuarioDAO.insertUsuario("María", "García", "contrasena456", "maria.garcia@newexample.com");

        // Print todos usuarios
        System.out.println("Lista de usuarios:");
        usuarioDAO.printUserDetails();

        // Update email usuario
        usuarioDAO.updateUsuarioCorreo("Juan", "Pérez", "juan.perez@nuevoemail.com");

        // Print todos usuarios despues de update
        System.out.println("Lista de usuarios después de actualizar el correo:");
        usuarioDAO.printUserDetails();

        // Get usuario correo
        String email = usuarioDAO.getUsuarioCorreo("María", "García");
        System.out.println("Correo de María García: " + email);

        // Delete usuario
        //usuarioDAO.deleteUsuario(1);

        // Print todos usuarios despues delete
        System.out.println("Lista de usuarios después de eliminar un usuario:");
        usuarioDAO.printUserDetails();


        //ADMINISTRADOR

        // Insert administradores nuevos
        usuarioDAO.insertAdministrador("Carlos", "Hernandez", "contrasena789", "carlos.hernandez@newexample.com", 1);
        usuarioDAO.insertAdministrador("Laura", "Martinez", "contrasena101", "laura.martinez@newexample.com", 2);

        // Print administradores
        System.out.println("Lista de administradores:");
        usuarioDAO.printAdministradorDetalles();

        // Update correo administrador
        usuarioDAO.updateAdministradorCorreo(1, "carlos.hernandez@newemail.com");

        // Print todos administradores despues update
        System.out.println("Lista de administradores después de actualizar el correo:");
        usuarioDAO.printAdministradorDetalles();

        // Delete administrador
        usuarioDAO.deleteAdministrador(2);

        // Print todos administradores despues delete
        System.out.println("Lista de administradores después de eliminar un administrador:");
        usuarioDAO.printAdministradorDetalles();


        //EQUIPAMIENTO

        // Insert equipamiento nuevo
        EquipamientoDAO.insertEquipamiento(10,"Proyector", "Bueno",10, 1);
        EquipamientoDAO.insertEquipamiento(20,"Micrófono", "Regular", 5, 2);

        // Print equipamiento
        System.out.println("Lista de equipamientos:");
        EquipamientoDAO.printEquipamientoDetalles();

        // Update equipamiento
      EquipamientoDAO.updateEquipamiento(1, "Proyector", "Excelente", 5);

        // Print todos equipamiento despues update
        System.out.println("Lista de equipamientos después de actualizar:");
        EquipamientoDAO.printEquipamientoDetalles();

        // Delete equipamiento
        //usuarioDAO.deleteEquipamiento(2);

        // Print todos equipamiento despues delete
        System.out.println("Lista de equipamientos después de eliminar:");
        EquipamientoDAO.printEquipamientoDetalles();


        //RESERVA

        ReservaDAO reservaDAO = new ReservaDAO();

        // Insert nueva reserva
        reservaDAO.insertReserva("RES123", Timestamp.valueOf("2024-06-01 10:00:00"),
                Timestamp.valueOf("2024-06-05 18:00:00"), 500.0f, "Pendiente", true, 1);
        reservaDAO.insertReserva("RES456", Timestamp.valueOf("2024-07-01 12:00:00"),
                Timestamp.valueOf("2024-07-10 15:00:00"), 700.0f, "Confirmada", false, 2);

        // Print todas reservas
        System.out.println("Lista de reservas:");
        reservaDAO.printReservaDetails();

        // Update reserva
        reservaDAO.updateReserva(1, "RES123", Timestamp.valueOf("2024-06-01 10:00:00"), Timestamp.valueOf("2024-06-05 18:00:00"), 550.0f, "Confirmada", true);

        // Print todas reservas despues update
        System.out.println("Lista de reservas después de actualizar:");
        reservaDAO.printReservaDetails();



        //RECORDATORIO

        RecordatorioDAO recordatorioDAO = new RecordatorioDAO();

        // Insert NUEVO recordatorio
        recordatorioDAO.insertRecordatorio(Timestamp.valueOf("2024-06-01 10:00:00"), 1, 1, 1);
        recordatorioDAO.insertRecordatorio(Timestamp.valueOf("2024-07-01 12:00:00"), 2, 2, 2);

        // Print TODOS recordatorios
        System.out.println("Lista de recordatorios:");
        recordatorioDAO.printRecordatorioDetails();

        // Update recordatorio
        recordatorioDAO.updateRecordatorio(1, Timestamp.valueOf("2024-06-02 11:00:00"), 3, 1, 1);

        // Print TODOS recordatorios DESPUES update
        System.out.println("Lista de recordatorios después de actualizar:");
        recordatorioDAO.printRecordatorioDetails();


        //REPORTE

        ReporteDAO reporteDAO = new ReporteDAO();

        // Insert nuevo reporte
        reporteDAO.insertReporte(Timestamp.valueOf("2024-06-01 10:00:00"), "Initial system check.");
        reporteDAO.insertReporte(Timestamp.valueOf("2024-07-01 12:00:00"), "Monthly performance report.");

        // Print todos reportes
        System.out.println("Lista de reportes:");
        reporteDAO.printReporteDetails();

        // Update reporte
        reporteDAO.updateReporte(1, Timestamp.valueOf("2024-06-02 11:00:00"), "Updated system check.");

        // Print todos reportes despues update
        System.out.println("Lista de reportes después de actualizar:");
        reporteDAO.printReporteDetails();

    }
}





