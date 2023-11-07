package entidades;

/**
 *
 * @author johan
 */
public class Cliente extends Persona {

    private int idCliente;

    public Cliente() {
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    
    public Cliente(int idCliente, String apellido, String nombre, String domicilio, String telefono) {
        super(apellido, nombre, domicilio, telefono);
        this.idCliente = idCliente;
    }

    public Cliente(String apellido, String nombre, String domicilio, String telefono) {
        super(apellido, nombre, domicilio, telefono);
    }

    public Cliente(int idCliente, String nombre, String apellido, String domicilio, String telefono, Persona clase) {
        super(nombre, apellido, domicilio, telefono, clase);
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "Id= " + idCliente +", Nombre= "+ super.getNombre()+", Apellido= "+super.getApellido()
                +", Domicilio= "+super.getDomicilio()+", Teléfono= "+super.getTelefono();
    }

    
}
