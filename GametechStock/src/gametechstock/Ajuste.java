package gametechstock; // Paquete principal del sistema

/**
 * Clase que representa un movimiento de tipo Ajuste en el sistema de stock.
 * Hereda de la clase abstracta Movimiento.
 * El ajuste puede ser positivo (aumenta stock) o negativo (disminuye stock).
 */
public class Ajuste extends Movimiento {

    /**
     * Constructor del ajuste.
     * @param cantidad        cantidad a ajustar (puede ser positiva o negativa)
     * @param producto        producto sobre el cual se aplica el ajuste
     * @param usuario         usuario que realiza el ajuste
     * @param justificacion   motivo por el cual se realiza el ajuste
     */
    public Ajuste(int cantidad, Producto producto, Usuario usuario, String justificacion) {
        // Llama al constructor de la superclase Movimiento
        super(cantidad, producto, usuario, justificacion);
    }

    /**
     * Aplica el ajuste al producto correspondiente.
     * Utiliza el método ajustarStock del producto, que suma o resta la cantidad indicada.
     */
    public void aplicar() {
        producto.ajustarStock(cantidad);
    }

    /**
     * Devuelve la justificación del ajuste.
     * Este dato es relevante para el historial.
     * @return texto con el motivo del ajuste
     */
    public String getJustificacion() {
        return justificacion;
    }
}
