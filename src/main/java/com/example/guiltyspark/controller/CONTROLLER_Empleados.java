package com.example.guiltyspark.controller;

import com.example.guiltyspark.HelloApplication;
import com.example.guiltyspark.database.EmpleadoDAO;
import com.example.guiltyspark.model.Empleado;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.SQLException;

public class CONTROLLER_Empleados {

    @FXML
    private Label Apellido_Empleado;

    @FXML
    private Label Contrato_Empleado;

    @FXML
    private Label Departamento_Empleado;

    @FXML
    private Label Nombre_empleado;

    @FXML
    private Label UP_Empleado;

    @FXML
    private ImageView btn_agregar;

    @FXML
    private ImageView btn_cerrar;

    @FXML
    private ImageView btn_regresar;

    @FXML
    private TableView<Empleado> tbl_Empleados;

    @FXML
    private TableColumn<Empleado, String> colNombre;

    private EmpleadoDAO empleadoDAO;

    @FXML
    void Agregar_empleado(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Agregar_Empleado.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) btn_agregar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar el menú principal.");
        }
    }

    @FXML
    void cerrar(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de que deseas cerrar esta app?");
        alert.setTitle("Confirmar Regreso");
        alert.setHeaderText(null);

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });
    }

    @FXML
    void regresar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) btn_regresar.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar el menú principal.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    private void initialize() throws SQLException {
        // Inicializar el DAO
        empleadoDAO = new EmpleadoDAO();

        // Configurar la columna para mostrar solo los nombres de los empleados
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));

        // Cargar los empleados
        cargarEmpleados();

        // Detectar la selección de una fila en la TableView
        tbl_Empleados.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarDetallesEmpleado(newValue));
    }

    private void cargarEmpleados() throws SQLException {
        // Obtener la lista de empleados desde el DAO y establecerla en el TableView
        tbl_Empleados.setItems(empleadoDAO.obtenerEmpleados());
    }

    private void mostrarDetallesEmpleado(Empleado empleado) {
        if (empleado != null) {
            // Mostrar los detalles del empleado seleccionado
            // Aquí puedes actualizar las etiquetas u otros componentes de la UI con los datos del empleado
            System.out.println("Empleado seleccionado: " + empleado.getNombre());
        } else {
            // Si no se selecciona ningún empleado, limpiar los detalles mostrados
            System.out.println("No hay empleado seleccionado.");
        }
    }
}
