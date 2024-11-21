package com.example.guiltyspark.database;

import com.example.guiltyspark.model.Proyecto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Agregar_ProyectosDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/GestionEmpleados";
    private static final String USER = "root"; // Tu usuario de base de datos
    private static final String PASSWORD = "omega&alpha7"; // Tu contraseña de base de datos

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insertarProyecto(Proyecto proyecto) throws SQLException {
        String sql = "INSERT INTO Proyectos (Nombre, FechaInicio, FechaFin) VALUES (?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, proyecto.getNombre());
            pstmt.setDate(2, new java.sql.Date(proyecto.getFechaInicio().getTime()));
            pstmt.setDate(3, proyecto.getFechaFin() != null ? new java.sql.Date(proyecto.getFechaFin().getTime()) : null);

            pstmt.executeUpdate();
        }
    }
}
