package com.example.guiltyspark.model;

import java.math.BigDecimal;
import java.util.Date;

public class Empleado2 {
    private int empleadoId;
    private String nombre;
    private String apellido;
    private String dui;
    private int departamentoId;
    private BigDecimal salario;
    private String email;
    private String telefono;
    private Date fechaContratacion;
    private int estadoEmpleado;

    // Constructor
    public Empleado2(int empleadoId, String nombre, String apellido, String dui, int departamentoId, BigDecimal salario, String email, String telefono, Date fechaContratacion, int estadoEmpleado) {
        this.empleadoId = empleadoId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dui = dui;
        this.departamentoId = departamentoId;
        this.salario = salario;
        this.email = email;
        this.telefono = telefono;
        this.fechaContratacion = fechaContratacion;
        this.estadoEmpleado = estadoEmpleado;
    }

    public Empleado2(int empleadoId, String nombre, String apellido, String dui, int departamentoId, BigDecimal salario, String email, String telefono, java.sql.Date fechaContratacion, int estadoEmpleado) {

    }

    // Getters y setters
    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public int getEstadoEmpleado() {
        return estadoEmpleado;
    }

    public void setEstadoEmpleado(int estadoEmpleado) {
        this.estadoEmpleado = estadoEmpleado;
    }
}
