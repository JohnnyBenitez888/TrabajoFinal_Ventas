package acceso;

import entidades.Cliente;
import entidades.DetalleVenta;
import entidades.Producto;
import entidades.Venta;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentaDAO {

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql;
    Conexion conexion = new Conexion();
    DetalleVentaDAO detadao = new DetalleVentaDAO();

    public void insertarVenta(Venta venta) {//USADO EN VISTA VENTAVIEW
        DetalleVenta detaventa = null;
        try {
            conn = conexion.conexionDB();
            sql = "INSERT INTO venta(id_cliente, fechadeVenta) VALUES (?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, venta.getCliente().getIdCliente());
            ps.setDate(2, (Date) venta.getFechaVenta());
            int r = ps.executeUpdate();
            if (r == 1) {

            }
            System.out.println("Venta insertada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al insertar una venta");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }

    }

    public Venta buscarVenta(int id) {//traigo una venta con id venta
        Venta venta = null;
        Cliente cliente = null;
        Date fecha2 = new Date(0, 0, 0);
        try {
            conn = conexion.conexionDB();
            sql = "SELECT * FROM venta WHERE id_venta = " + id;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                venta = new Venta(cliente, fecha2);
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.getCliente().setIdCliente(rs.getInt("id_cliente"));
                venta.setFechaVenta(rs.getDate("fechadeVenta"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer la Venta");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return venta;
    }

    public List<Venta> listarVentas() {//augusto
        Venta venta = null;
        Cliente cliente = null;
        Date fecha = new Date(0, 0, 0);
        List<Venta> ventas = new ArrayList<>();

        try {
            conn = conexion.conexionDB();
            sql = "SELECT * FROM venta";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                venta = new Venta(cliente, fecha);
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.getCliente().setIdCliente(rs.getInt("id_cliente"));
                venta.setFechaVenta(rs.getDate("fechadeVenta"));
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las Ventas");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return ventas;
    }

    public void modificarVenta(Venta venta) {//augusto

        if (venta == null) {
            JOptionPane.showMessageDialog(null, "Debe indicar una venta");
        } else {

            try {
                conn = conexion.conexionDB();
                sql = "UPDATE venta SET id_cliente = ?, "
                        + "fechadeVenta = ? WHERE id_venta = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, venta.getCliente().getIdCliente());
                ps.setDate(2, (Date) venta.getFechaVenta());
                ps.setInt(3, venta.getIdVenta());
                ps.executeUpdate();
                System.out.println("Venta modificada");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al modificar la Venta");
            } finally {
                try {
                    conexion.desconectar();
                } catch (Exception ex) {
                    System.out.println("Error al desconectar");
                }
            }
        }

    }

     public void eliminarVenta(int id) {

        try {
            conn = conexion.conexionDB();
            sql = "DELETE FROM venta WHERE id_venta = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Venta eliminada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la Venta");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }

    }

    public List<Venta> obtenerVentasPorIDCliente(int id) {  //(IMPORTANTE)(3)--//LISTO

        Venta venta = null;
        Cliente cliente = null;
        Date fecha = new Date(0, 0, 0);
        List<Venta> ventas = new ArrayList<>();

        try {
            conn = conexion.conexionDB();
            sql = "SELECT * FROM venta v JOIN cliente c ON v.id_cliente = c.id_cliente WHERE v.id_cliente = " + id;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                venta = new Venta(cliente, fecha);
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.getCliente().setIdCliente(rs.getInt("id_cliente"));
                venta.setFechaVenta(rs.getDate("fechadeVenta"));
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las Ventas por ID");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return ventas;

    }

    public List<Venta> obtenerVentasPorFecha(java.util.Date fecha) {  //(IMPORTANTE)(2)--//LISTO

        Venta venta = null;
        Cliente cliente = null;
        Date fe = new Date(0, 0, 0);
        List<Venta> ventas = new ArrayList<>();

        try {
            conn = conexion.conexionDB();
            sql = "SELECT * "
                    + "FROM venta "
                    + "WHERE DATE(fechadeVenta) = ?";
            ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(fecha.getTime()));
            rs = ps.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                venta = new Venta(cliente, fe);
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.getCliente().setIdCliente(rs.getInt("id_cliente"));
                venta.setFechaVenta(rs.getDate("fechadeVenta"));
                ventas.add(venta);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las Ventas por Fecha");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return ventas;

    }

    public List<Cliente> obtenerClientesporProducto(int idProducto) {//(IMPORTANTE)----(4)..//Johana
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = conexion.conexionDB();
            sql = "SELECT DISTINCT c.id_cliente, c.apellido, c.nombre, c.domicilio, c.telefono "
                    + "FROM cliente c "
                    + "INNER JOIN venta v ON c.id_cliente = v.id_cliente "
                    + "INNER JOIN detalleventa dv ON v.id_venta = dv.id_venta "
                    + "WHERE dv.id_producto = " + idProducto;
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
            JOptionPane.showMessageDialog(null, "Error al listar los clientes por Productos");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return clientes;
    }

    //------------------------------------------------------------------------------
    public Venta traerVenta(Venta ve) {//Método para la Vista VentaView-----(No necesario)---------------------------
        Venta venta = null;
        Cliente cliente = null;
        Date fecha2 = new Date(0, 0, 0);
        try {
            conn = conexion.conexionDB();
            sql = "SELECT * FROM venta WHERE id_cliente = " + ve.getCliente().getIdCliente();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                venta = new Venta(cliente, fecha2);
                venta.setIdVenta(rs.getInt("id_venta"));
                venta.getCliente().setIdCliente(rs.getInt("id_cliente"));
                venta.setFechaVenta(rs.getDate("fechadeVenta"));
                System.out.println("venta aqui");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al traer la Venta");
        } finally {
            try {
                conexion.desconectar();
            } catch (Exception ex) {
                System.out.println("Error al desconectar");
            }
        }
        return venta;
    }
}
