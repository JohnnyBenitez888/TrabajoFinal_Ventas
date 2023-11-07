package entidades;

/**
 *
 * @author johan
 */
public class DetalleVenta {

    private int idDetalle;
    private Venta venta;
    private Producto producto;
    private int cantidad;
    private double precioTotal;

    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public DetalleVenta(Venta venta, Producto producto) {
        this.venta = venta;
        this.producto = producto;
    }

    public DetalleVenta(Venta venta, Producto producto, int cantidad, double precioTotal) {
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioTotal = precioTotal;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalle=" + idDetalle + ", venta=" + venta.getIdVenta() + ", producto=" + producto.getIdProducto() + ", cantidad=" + cantidad + ", precioTotal=" + precioTotal + '}';
    }

    

}
