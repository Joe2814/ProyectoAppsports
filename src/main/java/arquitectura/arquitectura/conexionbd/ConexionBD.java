package arquitectura.arquitectura.conexionbd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:arquitectura://localhost:5432/arquitectura";
    private static final String USER = "postgres";
    private static final String PASSWORD = "joseph2814";  // Reemplaza con tu contraseña

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a PostgreSQL");
            return conexion;
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
            return null;
        }
    }
}
