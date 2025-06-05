package gametechstock;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Ventana de la interfaz gráfica que permite registrar ajustes de stock.
 * Un ajuste puede sumar o restar unidades a un producto, e incluye una justificación.
 */
public class VentanaAjuste {

    // Referencia al sistema central de stock
    private final SistemaStock sistema;

    /**
     * Constructor que recibe el sistema de stock activo.
     * @param sistema instancia de SistemaStock para acceder a productos, usuario y movimientos
     */
    public VentanaAjuste(SistemaStock sistema) {
        this.sistema = sistema;
    }

    /**
     * Muestra la ventana de ajuste de stock.
     * @param stage la ventana principal (Stage) proporcionada por JavaFX
     */
    public void mostrar(Stage stage) {
        stage.setTitle("Ajuste de Stock");

        // --- Tabla que muestra los productos disponibles ---
        TableView<Producto> tablaProductos = new TableView<>();

        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Producto, String> colCodigo = new TableColumn<>("Código");
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));

        TableColumn<Producto, Integer> colStock = new TableColumn<>("Stock");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stockActual"));

        // Agrega columnas a la tabla
        tablaProductos.getColumns().addAll(colNombre, colCodigo, colStock);

        // Carga la lista de productos del sistema
        tablaProductos.setItems(FXCollections.observableArrayList(sistema.getProductos()));
        tablaProductos.setPrefHeight(200);

        // --- Campos de entrada de datos ---
        TextField txtCantidad = new TextField();
        txtCantidad.setPromptText("Cantidad (+ o -)"); // puede ser positivo o negativo

        TextField txtJustificacion = new TextField();
        txtJustificacion.setPromptText("Justificación"); // motivo del ajuste

        Label mensaje = new Label(); // etiqueta para mostrar mensajes al usuario

        Button btnAplicar = new Button("Aplicar ajuste");

        // --- Acción al hacer clic en "Aplicar ajuste" ---
        btnAplicar.setOnAction(e -> {
            Producto producto = tablaProductos.getSelectionModel().getSelectedItem();
            String inputCantidad = txtCantidad.getText();
            String justificacion = txtJustificacion.getText();

            // Validación: todos los campos deben estar completos
            if (producto == null || inputCantidad.isEmpty() || justificacion.isEmpty()) {
                mensaje.setStyle("-fx-text-fill: red;");
                mensaje.setText("Debe completar todos los campos.");
                return;
            }

            try {
                int cantidad = Integer.parseInt(inputCantidad);

                // Crea un nuevo movimiento tipo Ajuste y lo aplica
                Movimiento ajuste = new Ajuste(cantidad, producto, sistema.getUsuarioActual(), justificacion);
                ajuste.aplicar();

                // Agrega el ajuste al historial
                sistema.getMovimientos().add(ajuste);

                mensaje.setStyle("-fx-text-fill: green;");
                mensaje.setText("Ajuste aplicado correctamente.");

                tablaProductos.refresh(); // actualiza la vista de stock

                // Alerta si el stock queda en nivel crítico
                if (producto.esCritico()) {
                    Alert alerta = new Alert(Alert.AlertType.WARNING);
                    alerta.setTitle("Advertencia");
                    alerta.setHeaderText("Stock crítico");
                    alerta.setContentText("El stock actual está por debajo del mínimo.");
                    alerta.showAndWait();
                }

            } catch (NumberFormatException ex) {
                mensaje.setStyle("-fx-text-fill: red;");
                mensaje.setText("La cantidad debe ser un número válido.");
            } catch (Exception ex) {
                mensaje.setStyle("-fx-text-fill: red;");
                mensaje.setText("Error: " + ex.getMessage());
            }
        });

        // --- Organiza todos los componentes en un contenedor vertical ---
        VBox layout = new VBox(10, tablaProductos, txtCantidad, txtJustificacion, btnAplicar, mensaje);
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-alignment: center;");

        // Establece la escena y muestra la ventana
        stage.setScene(new Scene(layout, 500, 400));
        stage.show();
    }
}


