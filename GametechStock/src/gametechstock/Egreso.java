package gametechstock; // Paquete del proyecto

/**
 * Clase que representa un movimiento de tipo Egreso en el sistema de stock.
 * Hereda de la clase abstracta Movimiento.
 * Un egreso representa la salida de stock de un producto.
 */
public class Egreso extends Movimiento {

    /**
     * Constructor del egreso.
     * @param cantidad   cantidad a retirar del stock
     * @param producto   producto sobre el cual se realiza el egreso
     * @param usuario    usuario que realiza el egreso
     *
     * Se pasa 'null' como justificación porque los egresos no la requieren.
     */
    public Egreso(int cantidad, Producto producto, Usuario usuario) {
        super(cantidad, producto, usuario, null);
    }

    /**
     * Aplica el egreso al producto.
     * Llama al método registrarEgreso del producto, que valida si hay suficiente stock.
     * @throws Exception si no hay suficiente stock disponible
     */
    public void aplicar() throws Exception {
        producto.registrarEgreso(cantidad);
    }
}
