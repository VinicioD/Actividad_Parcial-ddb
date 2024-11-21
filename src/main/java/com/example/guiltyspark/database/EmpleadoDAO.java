package com.example.guiltyspark.database;

import com.example.guiltyspark.model.Empleado;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;

import java.sql.*;

public class EmpleadoDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/tu_basededatos";
    private static final String USER = "tu_usuario";
    private static final String PASSWORD = "tu_contraseña";

    public ObservableList<Empleado> obtenerEmpleados() {
        ObservableList<Empleado> empleados = FXCollections.observableArrayList();
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM empleados")) {

            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(resultSet.getInt("id"));
                empleado.setNombre(resultSet.getString("nombre"));
                // Completa con otros campos necesarios
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}