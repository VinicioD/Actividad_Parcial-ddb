package com.example.guiltyspark.controller;

import com.example.guiltyspark.HelloApplication;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CONTROLLER_Agregar_Empleado {

    @FXML
    private Button Btn_Ingresar;

    @FXML
    private DatePicker Calend_Fecha;

    @FXML
    private ComboBox<String> Cb_Departamento;

    @FXML
    private RadioButton Rdb_Activo;

    @FXML
    private RadioButton Rdb_Inactivo;

    private ToggleGroup estadoGroup;

    @FXML
    private ImageView btn_cerrar;

    @FXML
    private ImageView btn_regresar;

    @FXML
    private TextField txt_Apellido;

    @FXML
    private TextField txt_DUI;

    @FXML
    private TextField txt_Email;

    @FXML
    private TextField txt_Nombre;

    @FXML
    private TextField txt_Salario;

    @FXML
    private TextField txt_Telefono;

    @FXML
    private void initialize() {
        // Configurar ComboBox
        Cb_Departamento.setItems(FXCollections.observableArrayList("Opción 1", "Opción 2", "Opción 3"));

        // Configurar ToggleGroup para RadioButtons
        estadoGroup = new ToggleGroup();
        Rdb_Activo.setToggleGroup(estadoGroup);
        Rdb_Inactivo.setToggleGroup(estadoGroup);

        // Validar que TextField solo permitan letras
        setTextFieldToLettersOnly(txt_Nombre);
        setTextFieldToLettersOnly(txt_Apellido);

        // Validar que TextField solo permitan números
        setTextFieldToNumbersOnly(txt_DUI);
        setTextFieldToNumbersOnly(txt_Telefono);
        setTextFieldToNumbersOnly(txt_Salario);

        // Manejar el evento del botón Ingresar
        Btn_Ingresar.setOnAction(this::handleIngresar);
    }

    private void setTextFieldToLettersOnly(TextField textField) {
        textField.setTextFormatter(new TextFormatter<String>((TextFormatter.Change change) -> {
            String newText = change.getControlNewText();
            if (newText.matches("[a-zA-Z]*")) {
                return change;
            }
            return null;
        }));
    }

    private void setTextFieldToNumbersOnly(TextField textField) {
        textField.setTextFormatter(new TextFormatter<String>((TextFormatter.Change change) -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*")) {
                return change;
            }
            return null;
        }));
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
    void Btn_Ingresar(ActionEvent event) {
        handleIngresar(event);
    }

    @FXML
    void regresar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) btn_cerrar.getScene().getWindow();
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


    private void handleIngresar(ActionEvent event) {
        if (areAllFieldsFilled()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("Usuario creado correctamente");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, complete todos los campos");
            alert.showAndWait();
        }
    }

    private boolean areAllFieldsFilled() {
        return !txt_Nombre.getText().isEmpty() &&
                !txt_Apellido.getText().isEmpty() &&
                !txt_DUI.getText().isEmpty() &&
                !txt_Email.getText().isEmpty() &&
                !txt_Salario.getText().isEmpty() &&
                !txt_Telefono.getText().isEmpty() &&
                Calend_Fecha.getValue() != null &&
                Cb_Departamento.getValue() != null &&
                estadoGroup.getSelectedToggle() != null;
    }

}
