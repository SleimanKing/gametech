package gametechstock; // Paquete principal del sistema

/**
 * Clase que representa un usuario del sistema.
 * Cada usuario tiene un nombre, una contraseña y un rol asignado (administrador, encargado, logística).
 */
public class Usuario {

    // Nombre de usuario (identificador único)
    private String nombre;

    // Contraseña del usuario (se valida al iniciar sesión)
    private String clave;

    // Rol que determina los permisos del usuario en el sistema
    private RolUsuario rol;

    /**
     * Constructor de Usuario.
     * @param nombre nombre del usuario
     * @param clave contraseña del usuario
     * @param rol rol asignado al usuario (ADMINISTRADOR, ENCARGADO, LOGISTICA)
     */
    public Usuario(String nombre, String clave, RolUsuario rol) {
        this.nombre = nombre;
        this.clave = clave;
        this.rol = rol;
    }

    /**
     * Devuelve el nombre del usuario.
     * @return nombre como String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el rol del usuario.
     * @return enum RolUsuario (ADMINISTRADOR, ENCARGADO o LOGISTICA)
     */
    public RolUsuario getRol() {
        return this.rol;
    }

    /**
     * Verifica si la contraseña ingresada coincide con la almacenada.
     * @param claveIngresada contraseña que el usuario ingresó
     * @return true si la clave es correcta, false si es incorrecta
     */
    public boolean autenticar(String claveIngresada) {
        return this.clave.equals(claveIngresada);
    }
}