import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // URL koneksi ke database MySQL
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/toko_dimsum";

    // Username dan password MySQL
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Method untuk mendapatkan koneksi database
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Koneksi ke database berhasil.");
        } catch (SQLException e) {
            System.out.println("Koneksi ke database gagal: " + e.getMessage());
        }

        return conn;
    }
}
