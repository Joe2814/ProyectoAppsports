package arquitectura.arquitectura.Servicio;

import arquitectura.arquitectura.conexionbd.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Intenta conectar a la base de datos usando la clase ConexionBD
        Connection conexion = ConexionBD.conectar();

        if (conexion != null) {
            System.out.println("La conexión se ha realizado correctamente.");

            // Es una buena práctica cerrar la conexión después de usarla
            try {
                conexion.close();
                System.out.println("La conexión ha sido cerrada exitosamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }
}
