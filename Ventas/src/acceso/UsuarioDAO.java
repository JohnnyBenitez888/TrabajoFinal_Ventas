package acceso;

import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;
    Conexion conexion = new Conexion();

    public boolean ingresoLogin(String usuario, String password) {

        try {
            conn = conexion.conexionDB();
            sql = "SELECT * FROM usuario WHERE usuario =  ? AND contraseña = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al loguearse");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return false;

    }

}
