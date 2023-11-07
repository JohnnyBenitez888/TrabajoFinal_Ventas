package acceso;

import entidades.Cliente;
import entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;
    Conexion conexion = new Conexion();

    public boolean nuevoCliente(Persona c) {//joha

        try {
            conn = conexion.conexionDB();
            sql = "INSERT INTO cliente(apellido, nombre, domicilio, telefono) VALUES (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getApellido());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getDomicilio());
            ps.setString(4, c.getTelefono());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar un cliente");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return false;
    }

    public List<Persona> buscarNombre(String nombre) throws Exception {//joha
        Persona p;
        List<Persona> listaClientes = new ArrayList<>();
        try {
            conn = conexion.conexionDB();
            sql = "SELECT * FROM cliente WHERE nombre LIKE '%" + nombre + "%'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Persona();
                p.setApellido(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setDomicilio(rs.getString(4));
                p.setTelefono(rs.getString(5));
                listaClientes.add(p);
            }
            return listaClientes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return null;
    }

    public List<Persona> buscarApellido(String apellido) throws Exception {//joha
        Persona p;
        List<Persona> listaClientes = new ArrayList<>();
        try {
            conn = conexion.conexionDB();
            sql = "SELECT * FROM cliente WHERE apellido LIKE '%" + apellido + "%'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Persona();
                p.setApellido(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setDomicilio(rs.getString(4));
                p.setTelefono(rs.getString(5));
                listaClientes.add(p);
            }
            return listaClientes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return null;
    }

    public List<Persona> buscarNombreApellido(String nombre, String apellido) throws Exception {//joha
        Persona p;
        List<Persona> listaClientes = new ArrayList<>();
        try {
            conn = conexion.conexionDB();
            sql = "SELECT * FROM cliente WHERE (apellido LIKE '" + apellido + "') AND (nombre LIKE '" + nombre + "')";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Persona();
                p.setApellido(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setDomicilio(rs.getString(4));
                p.setTelefono(rs.getString(5));
                listaClientes.add(p);
            }
            return listaClientes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return null;
    }

    public List<Persona> listarClientes2() throws Exception {//Joha
        Persona p;
        List<Persona> listaClientes = new ArrayList<>();
        try {
            conn = conexion.conexionDB();
            String sql = "SELECT * FROM cliente ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p = new Persona();
                p.setApellido(rs.getString(2));
                p.setNombre(rs.getString(3));
                p.setDomicilio(rs.getString(4));
                p.setTelefono(rs.getString(5));
                listaClientes.add(p);
            }
            return listaClientes;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return null;
    }

    public void actualizar(Persona c) throws Exception {//joha
        if (c == null) {
            System.out.println("El Cliente es nulo");
        } else {
            try {
                conn = conexion.conexionDB();
                sql = "UPDATE cliente SET apellido= '" + c.getApellido() + "' , nombre= '" + c.getNombre()
                        + "', domicilio = '" + c.getDomicilio() + "', telefono = '" + c.getTelefono()
                        + "'  WHERE id_cliente = " + c.getId();
                ps = conn.prepareStatement(sql);
                ps.executeUpdate();
                System.out.println("El Cliente ha sido modificado");
            } catch (Exception e) {
                System.out.println("Error al modificar el Cliente");
                System.out.println(e.getMessage());
            } finally {
                try {
                    conexion.desconectar();
                } catch (Exception ex) {
                    System.out.println("Error al desconectar");
                }
            }
        }
    }

    public int obtenerID(String nombre, String apellido, String domicilio, String telefono) throws Exception {//joha
        try {
            conn = conexion.conexionDB();
            String sql = "SELECT id_cliente FROM cliente WHERE nombre LIKE '" + nombre + "' AND apellido LIKE '" + apellido
                    + "' AND domicilio LIKE '" + domicilio + "' AND telefono LIKE '" + telefono + "' ";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_cliente");
                System.out.println(id);
                return id;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return 0;
    }

    public Persona buscarId(int id) {//joha
        Persona c = null;

        try {
            conn = conexion.conexionDB();
            sql = "SELECT * FROM cliente WHERE id_cliente = " + id + ";";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                c = new Persona();
                c.setId(id);
                c.setApellido(rs.getString("apellido"));
                c.setNombre(rs.getString("nombre"));
                c.setDomicilio(rs.getString("domicilio"));
                c.setTelefono(rs.getString("telefono"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println("El Cliente no se encuentra en el Sistema");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return c;
    }

    public boolean eliminar(Persona c) throws Exception {//joha
        boolean eliminado = false;
        try {
            conn = conexion.conexionDB();
            sql = "SELECT COUNT(*) FROM detalleventa AS d JOIN venta AS v ON d.id_venta = v.id_venta"
                    + " JOIN cliente AS c ON c.id_cliente = v.id_cliente WHERE c.id_cliente =" + c.getId();

            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            int consulta = 0;
            if (rs.next()) {
                consulta = rs.getInt(1);
            }
            if (consulta == 0) {
                String sql2 = "DELETE FROM cliente WHERE id_cliente =" + c.getId();
                ps = conn.prepareStatement(sql2);
                ps.executeUpdate();
                eliminado = true;
                System.out.println("Cliente eliminado");
            } else {
                System.out.println("El cliente posee registro de ventas");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return eliminado;
    }

    public List<Cliente> listarClientes() {//johnny
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = conexion.conexionDB();
            sql = "SELECT * FROM cliente";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setTelefono(rs.getString("telefono"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar los clientes");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return clientes;
    }

}
