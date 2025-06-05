package gametechstock; // Paquete principal del sistema

/**
 * Clase que representa un movimiento de tipo Ingreso en el sistema de stock.
 * Hereda de la clase abstracta Movimiento.
 * Un ingreso implica la entrada de unidades al stock de un producto.
 */
public class Ingreso extends Movimiento {

    /**
     * Constructor del ingreso.
     * @param cantidad  cantidad a agregar al stock
     * @param producto  producto al que se le suma stock
     * @param usuario   usuario que registra el ingreso
     *
     * El campo 'justificación' no se utiliza en ingresos, por eso se pasa como null.
     */
    public Ingreso(int cantidad, Producto producto, Usuario usuario) {
        super(cantidad, producto, usuario, null); // Llama al constructor de Movimiento
    }

    /**
     * Aplica el ingreso al producto.
     * Llama al método registrarIngreso del producto para aumentar el stock.
     */
    public void aplicar() {
        producto.registrarIngreso(cantidad);
    }
}
