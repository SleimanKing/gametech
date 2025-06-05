package gametechstock;

import java.util.*;

/**
 * Clase que representa la lógica central del sistema de gestión de stock.
 * Contiene y administra productos, movimientos, usuarios y la sesión activa.
 */
public class SistemaStock {

    // Lista de productos registrados en el sistema
    private ArrayList<Producto> productos = new ArrayList<>();

    // Cola de movimientos históricos (FIFO)
    private Queue<Movimiento> movimientos = new LinkedList<>();

    // Lista de usuarios disponibles en el sistema
    private List<Usuario> usuarios = new ArrayList<>();

    // Usuario actualmente logueado en el sistema
    private Usuario usuarioActual;

    // Último número de código generado para productos (para mantener secuencia)
    private int ultimoCodigo = 6;

    /**
     * Establece el usuario que está actualmente logueado.
     * @param usuario objeto Usuario activo
     */
    public void setUsuarioActual(Usuario usuario) {
        this.usuarioActual = usuario;
    }

    /**
     * Genera un nuevo código automático para un producto.
     * Formato: P007, P008, etc.
     * @return nuevo código como cadena
     */
    public String generarCodigo() {
        ultimoCodigo++;
        return String.format("P%03d", ultimoCodigo);
    }

    /**
     * Carga datos simulados iniciales en el sistema.
     * Incluye 6 productos reales y 3 usuarios con distintos roles.
     */
    public void cargarDatosSimulados() {
        Deposito d1 = new Deposito("Depósito Central Junín - Av. Libertad 1234", 2000);

        // Productos precargados
        productos.add(new Producto("P001", "Mouse Logitech G502 HERO", "Periférico", 10, 25, d1));
        productos.add(new Producto("P002", "Teclado Redragon Kumara K552", "Periférico", 15, 30, d1));
        productos.add(new Producto("P003", "Monitor Samsung 24\" Curvo FHD", "Pantalla", 5, 12, d1));
        productos.add(new Producto("P004", "Placa de Video NVIDIA RTX 3060", "Hardware", 3, 5, d1));
        productos.add(new Producto("P005", "Auriculares HyperX Cloud II", "Audio", 10, 18, d1));
        productos.add(new Producto("P006", "Disco SSD Kingston A2000 1TB", "Almacenamiento", 8, 20, d1));

        // Usuarios precargados
        usuarios.add(new Usuario("admin", "admin123", RolUsuario.ADMINISTRADOR));
        usuarios.add(new Usuario("lucia", "clave123", RolUsuario.ENCARGADO));
        usuarios.add(new Usuario("marcos", "log123", RolUsuario.LOGISTICA));
    }

    /**
     * Valida si un usuario existe en la lista y su contraseña coincide.
     * @param nombre nombre de usuario ingresado
     * @param clave contraseña ingresada
     * @return el objeto Usuario si es válido, o null si no se encuentra
     */
    public Usuario validarUsuario(String nombre, String clave) {
        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.autenticar(clave)) {
                return u;
            }
        }
        return null; // Usuario no encontrado o clave incorrecta
    }

    /**
     * Devuelve la lista de productos del sistema.
     * @return lista de productos
     */
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * Devuelve la cola de movimientos registrados.
     * @return movimientos en orden cronológico (FIFO)
     */
    public Queue<Movimiento> getMovimientos() {
        return movimientos;
    }

    /**
     * Devuelve el usuario actualmente autenticado.
     * @return usuario logueado
     */
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }
}
