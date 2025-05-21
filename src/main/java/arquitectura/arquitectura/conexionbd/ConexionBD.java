package arquitectura.arquitectura.conexionbd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:postgresql://dpg-d0af9luuk2gs73aq8t80-a.oregon-postgres.render.com/db_estu";
    private static final String USER = "user";
    private static final String PASSWORD = "48m0nZxPouclO5Yv7SXFxvqudjOMtH9w";  // Reemplaza con tu contraseña

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
