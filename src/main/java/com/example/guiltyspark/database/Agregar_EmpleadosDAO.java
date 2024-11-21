package com.example.guiltyspark.database;

import com.example.guiltyspark.model.Empleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Agregar_EmpleadosDAO {

        private static final String URL = "jdbc:mysql://localhost:3306/GestionEmpleados";
        private static final String USER = "root";
        private static final String PASSWORD = "omega&alpha7";

        private Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }

        public void insertarEmpleado(Empleado empleado) throws SQLException {
            String sql = "INSERT INTO Empleados (Nombre, Apellido, DUI, DepartamentoId, Salario, Email, Telefono, FechaContratacion, Estado_empleado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection con = getConnection();
                 PreparedStatement pstmt = con.prepareStatement(sql)) {
                pstmt.setString(1, empleado.getNombre());
                pstmt.setString(2, empleado.getApellido());
                pstmt.setString(3, empleado.getDUI());
                pstmt.setInt(4, empleado.getDepartamentoId());
                pstmt.setBigDecimal(5, empleado.getSalario());
                pstmt.setString(6, empleado.getEmail());
                pstmt.setString(7, empleado.getTelefono());
                pstmt.setDate(8, new java.sql.Date(empleado.getFechaContratacion().getTime()));
                pstmt.setInt(9, empleado.getEstadoEmpleado());

                pstmt.executeUpdate();
            }
        }

}
