package gametechstock;  // Declaración del paquete al que pertenece la clase

// Clase que representa un depósito donde se almacenan productos
public class Deposito {
    // Atributo que almacena la ubicación física del depósito
    private String ubicacion;
    
    // Atributo que indica la capacidad máxima del depósito
    private int capacidad;

    /**
     * Constructor de la clase Deposito.
     * Inicializa la ubicación y la capacidad del depósito con los valores proporcionados.
     * 
     * @param ubicacion La ubicación física del depósito
     * @param capacidad La capacidad máxima del depósito
     */
    public Deposito(String ubicacion, int capacidad) {
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    /**
     * Método getter para obtener la ubicación del depósito.
     * 
     * @return La ubicación del depósito como cadena de texto
     */
    public String getUbicacion() { 
        return ubicacion; 
    }

    /**
     * Método getter para obtener la capacidad del depósito.
     * 
     * @return La capacidad máxima del depósito como entero
     */
    public int getCapacidad() { 
        return capacidad; 
    }
}

