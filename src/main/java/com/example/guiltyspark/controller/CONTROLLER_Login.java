package com.example.guiltyspark.controller;

import com.example.guiltyspark.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;



public class CONTROLLER_Login {

    @FXML
    private Button btn_AceptarLogin;

    @FXML
    private ImageView imb_close;

    @FXML
    private TextField txt_Usuario;

    @FXML
    private PasswordField txt_contraseña;

    @FXML
    void Logind(ActionEvent event) {
        String username = txt_Usuario.getText();
        String password = txt_contraseña.getText();


        if (isValidLogin(username, password)) {

            showMainMenu();
        } else {
            showAlert("Credenciales incorrectas", "Por favor, verifica tu usuario y contraseña.");
        }
    }

    private boolean isValidLogin(String username, String password) {

        String validUsername = "daniel";
        String validPassword = "1234";
        return validUsername.equals(username) && validPassword.equals(password);
    }

    private void showMainMenu() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) btn_AceptarLogin.getScene().getWindow();
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
