package entidades;

/**
 *
 * @author johan
 */
public class Usuario extends Persona{

    private String contraseña;

    public Usuario() {
    }

    public Usuario(String contraseña, String nombre) {
        super(nombre);
        this.contraseña = contraseña;
    }

    public Usuario(String contraseña, String nombre, String apellido, String domicilio, String telefono, Persona clase) {
        super(nombre, apellido, domicilio, telefono, clase);
        this.contraseña = contraseña;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario: " +super.getNombre() +" Contraseña: "+ contraseña;
    }

    
    
}
