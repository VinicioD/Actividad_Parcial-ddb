package com.example.guiltyspark.controller;

import com.example.guiltyspark.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CONTROLLER_Agregar_Proyecto {

    @FXML
    private DatePicker Date_FechaFin;

    @FXML
    private DatePicker Date_FechaInicio;

    @FXML
    private Button btn_Ingresar;

    @FXML
    private ImageView btn_cerrar;

    @FXML
    private ImageView btn_regresar;

    @FXML
    private TextField txt_NombreProyecto;

    @FXML
    void Btn_Ingresar(ActionEvent event) {
        handleIngresar(event);
    }

    @FXML
    private void initialize() {
        // Validar que TextField solo permita letras
        setTextFieldToLettersOnly(txt_NombreProyecto);

        // Manejar el evento del botón Ingresar
        btn_Ingresar.setOnAction(this::handleIngresar);
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
            alert.setContentText("Proyecto creado correctamente");
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
        return !txt_NombreProyecto.getText().isEmpty() &&
                Date_FechaInicio.getValue() != null &&
                Date_FechaFin.getValue() != null;
    }

}
