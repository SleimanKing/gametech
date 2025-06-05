package gametechstock; // Paquete principal del sistema

/**
 * Clase que representa un producto del stock.
 * Contiene información como código, nombre, categoría, stock mínimo, stock actual y el depósito asignado.
 */
public class Producto {

    // Código único del producto (ej: P001)
    private String codigo;

    // Nombre descriptivo del producto
    private String nombre;

    // Categoría a la que pertenece (Ej: Hardware, Periférico)
    private String categoria;

    // Cantidad mínima recomendada para mantener en stock
    private int stockMinimo;

    // Cantidad actual en stock
    private int stockActual;

    // Depósito donde se encuentra almacenado el producto
    private Deposito deposito;

    /**
     * Constructor de producto.
     *
     * @param codigo        identificador único del producto
     * @param nombre        nombre descriptivo
     * @param categoria     categoría del producto
     * @param stockMinimo   cantidad mínima sugerida
     * @param stockActual   cantidad actual disponible
     * @param deposito      depósito donde está almacenado
     */
    public Producto(String codigo, String nombre, String categoria, int stockMinimo, int stockActual, Deposito deposito) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stockMinimo = stockMinimo;
        this.stockActual = stockActual;
        this.deposito = deposito;
    }

    /**
     * Registra un ingreso de stock (entrada de unidades).
     * @param cantidad cantidad a sumar al stock actual
     */
    public void registrarIngreso(int cantidad) {
        stockActual += cantidad;
    }

    /**
     * Registra un egreso de stock (salida de unidades).
     * @param cantidad cantidad a restar del stock actual
     * @throws Exception si no hay suficiente stock disponible
     */
    public void registrarEgreso(int cantidad) throws Exception {
        if (cantidad > stockActual) throw new Exception("Stock insuficiente.");
        stockActual -= cantidad;
    }

    /**
     * Aplica un ajuste al stock, sumando o restando según el valor recibido.
     * @param ajuste cantidad positiva o negativa a aplicar
     */
    public void ajustarStock(int ajuste) {
        stockActual += ajuste;
    }

    /**
     * Indica si el stock actual está por debajo del mínimo recomendado.
     * @return true si es crítico, false si está en nivel normal
     */
    public boolean esCritico() {
        return stockActual < stockMinimo;
    }

    // Métodos getter para acceder a los atributos encapsulados

    public String getCodigo() { return codigo; }

    public String getNombre() { return nombre; }

    public int getStockActual() { return stockActual; }

    public String getCategoria() { return categoria; }

    public int getStockMinimo() { return stockMinimo; }

    public Deposito getDeposito() { return deposito; }

    /**
     * Devuelve una descripción completa del producto.
     * Ejemplo: "P001 - Mouse Gamer (Periférico)"
     * @return cadena con el código, nombre y categoría
     */
    public String getDescripcion() {
        return String.format("%s - %s (%s)", codigo, nombre, categoria);
    }
}
