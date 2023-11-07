package acceso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
public class Conexion {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String DB = "fravemax_1";
    private static final String USER = "root";
    private static final String PASS = "5872";
    private final String DRIVER = "org.mariadb.jdbc.Driver";

    public Connection conexionDB() throws SQLException {

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL + DB, USER, PASS);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Drivers");
        }
        return conn;
    }


    protected void desconectar() throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al desconectar Base");
            throw e;
        }
    }
}
