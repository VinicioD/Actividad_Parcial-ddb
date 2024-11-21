package com.example.guiltyspark.model;

import java.math.BigDecimal;
import java.util.Date;

public class Empleado {
    private int id;
    private String nombre;
    private String apellido;
    private String DUI;
    private int departamentoId;
    private BigDecimal salario;
    private String email;
    private String telefono;
    private Date fechaContratacion;
    private int estadoEmpleado;

    // Constructor
    public Empleado() {
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
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
