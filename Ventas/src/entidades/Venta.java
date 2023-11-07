package entidades;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author johan
 */
public class Venta {

    private int idVenta;
    private Cliente cliente;
    private Date fechaVenta;

    public Venta() {
    }

    public Venta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(Cliente cliente) {
        this.cliente = cliente;
    }

    public Venta(Cliente cliente, Date fechaVenta) {
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
    }

    public Venta(int idVenta, Cliente cliente, Date fechaVenta) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.fechaVenta = fechaVenta;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    @Override
    public String toString() {
        return "Venta: " + "Id Venta= " + idVenta + ", Cliente= " + cliente.getIdCliente() + ", Fecha Venta= " + fechaVenta;
    }

}
