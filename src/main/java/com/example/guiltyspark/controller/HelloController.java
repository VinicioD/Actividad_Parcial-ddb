package com.example.guiltyspark.controller;

import com.example.guiltyspark.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;


public class HelloController {
    @FXML
    private Button btn_Empleados;

    @FXML
    private Button btn_Estadisticas;

    @FXML
    private Button btn_proyectos;

    @FXML
    private ImageView img_salida;

    @FXML
    private ImageView img_usuario;

    @FXML
    private AnchorPane main_pain;

    @FXML
    private Pane pane_decoration;

    @FXML
    private VBox pane_menu;

    @FXML
    void Usuarios_in(MouseEvent event) {

    }

    @FXML
    void btn_Empleados(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Empleados.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) btn_Empleados.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar el menú principal.");
        }
    }

    @FXML
    void btn_Estadisticas(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Estadisticas.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) btn_Empleados.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar el menú principal.");
        }
    }

    @FXML
    void btn_Proyectos(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Proyectos.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = (Stage) btn_Empleados.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "No se pudo cargar el menú principal.");
        }
    }

    @FXML
    void regresar(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "¿Estás seguro de que deseas cerrar esta app?");
        alert.setTitle("Confirmar Regreso");
        alert.setHeaderText(null);

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                // Cerrar la ventana actual
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
            // Si se presiona "Cancelar", no se hace nada
        });
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}