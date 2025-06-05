package gametechstock; // Paquete principal del sistema

import java.time.LocalDateTime;

/**
 * Clase abstracta que representa un movimiento de stock.
 * Puede ser de tipo Ingreso, Egreso o Ajuste.
 * Define los atributos y comportamientos comunes a todos los tipos de movimientos.
 */
public abstract class Movimiento {

    // Fecha y hora en que se registró el movimiento
    protected LocalDateTime fecha = LocalDateTime.now();

    // Cantidad de unidades implicadas en el movimiento
    protected int cantidad;

    // Producto sobre el cual se aplica el movimiento
    protected Producto producto;

    // Usuario que realiza el movimiento
    protected Usuario usuario;

    // Justificación (usada en Ajuste; puede ser null en Ingreso o Egreso)
    protected String justificacion;

    /**
     * Devuelve la fecha y hora del movimiento.
     * @return fecha del movimiento como LocalDateTime
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * Constructor del movimiento.
     * Se llama desde las subclases (Ingreso, Egreso, Ajuste).
     *
     * @param cantidad       cantidad implicada en el movimiento
     * @param producto       producto afectado
     * @param usuario        usuario que lo realiza
     * @param justificacion  motivo (solo para ajustes; null en otros casos)
     */
    public Movimiento(int cantidad, Producto producto, Usuario usuario, String justificacion) {
        this.fecha = LocalDateTime.now();      // Registra la fecha actual
        this.cantidad = cantidad;
        this.producto = producto;
        this.usuario = usuario;
        this.justificacion = justificacion;
    }

    /**
     * Método abstracto que debe implementar cada subclase.
     * Define cómo aplicar el movimiento al producto (ingresar, egresar, ajustar).
     *
     * @throws Exception si ocurre un error al aplicar el movimiento
     */
    public abstract void aplicar() throws Exception;

    /**
     * Devuelve una cadena que representa el movimiento en formato de auditoría.
     * @return String con resumen del movimiento.
     */
    public String auditar() {
        return String.format("[%s] %s - Producto: %s - Cant: %d - Usuario: %s",
                fecha, this.getClass().getSimpleName(), producto.getCodigo(), cantidad, usuario.getNombre());
    }

    /**
     * Devuelve el producto sobre el cual se aplicó el movimiento.
     * @return producto afectado
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Devuelve el usuario que realizó el movimiento.
     * @return usuario responsable
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Devuelve la cantidad implicada en el movimiento.
     * @return cantidad positiva o negativa según el tipo de movimiento
     */
    public int getCantidad() {
        return cantidad;
    }
}
