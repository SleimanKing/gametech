package gametechstock; // Paquete principal del sistema

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación JavaFX.
 * Hereda de javafx.application.Application, punto de entrada para aplicaciones JavaFX.
 */
public class GametechStock extends Application {

    // Instancia del sistema de stock (modelo principal del sistema)
    private SistemaStock sistema;

    /**
     * Método llamado automáticamente por JavaFX al iniciar la aplicación.
     * Es el punto de partida de la interfaz gráfica.
     *
     * @param primaryStage ventana principal de la aplicación
     */
    @Override
    public void start(Stage primaryStage) {
        sistema = new SistemaStock();           // Se crea la lógica del sistema
        sistema.cargarDatosSimulados();         // Se cargan productos y usuarios predefinidos

        // Se lanza la ventana de login como primer pantalla
        VentanaLogin login = new VentanaLogin(sistema);
        login.mostrar(primaryStage);
    }

    /**
     * Método main: entrada estándar de cualquier aplicación Java.
     * Llama a launch() que inicia el ciclo de vida de JavaFX.
     *
     * @param args argumentos desde la línea de comandos
     */
    public static void main(String[] args) {
        launch(args); // Inicia la aplicación JavaFX
    }
}
