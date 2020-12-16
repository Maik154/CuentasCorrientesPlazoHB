package com.github.maik154.ejercicio5.Pojos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Movimiento {
    private CuentaCorriente cuentaCorriente;
    private Cliente cliente;
    private float cantidad;
    private LocalDate fechaOperacion;
    private LocalTime hora;
    private char operacion;


    public Movimiento(CuentaCorriente cuentaCorriente, Cliente cliente, float cantidad, LocalDate fechaOperacion, LocalTime hora, char operacion) {
        this.cuentaCorriente = cuentaCorriente;
        this.cantidad = cantidad;
        this.cliente = cliente;
        this.cantidad = cantidad;
        this.fechaOperacion = fechaOperacion;
        this.hora = hora;
        this.operacion = operacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(LocalDate fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public char getOperacion() {
        return operacion;
    }

    public void setOperacion(char operacion) {
        this.operacion = operacion;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
}