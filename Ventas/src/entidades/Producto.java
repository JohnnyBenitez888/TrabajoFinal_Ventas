package entidades;

/**
 *
 * @author johan
 */
public class Producto {

    private int idProducto;
    private String nombreProducto;
    private String descripcion;
    private double precioActual;
    private int stock;
    private boolean estado;

    public Producto() {
    }

    public Producto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(String nombreProducto, String descripcion, double precioActual, int stock, boolean estado) {
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(int idProducto, String nombreProducto, String descripcion, double precioActual, int stock, boolean estado) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String m = "";
        if (stock > 0) {
                m = "En Stock";
            } else {
                m = "Agotado";
            }
        return "ID= " + idProducto + ", Nombre= " + nombreProducto + ", Descripción= " + descripcion 
                + ", Precio= $ " + precioActual + ", Stock= " + stock+ ", Estado= "+m;
    }
    
}
