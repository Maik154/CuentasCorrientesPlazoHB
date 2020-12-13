package com.github.maik154.ejercicio5.Pojos;

import java.sql.Date;
import java.sql.Time;

public class Movimiento {
    private String numeroCta;
    private float cantidad;
    private Date fechaOperacion;
    private Time hora;
    private double saldoActual;
    private char operacion;


    public Movimiento(String numeroCta, float cantidad) {
        this.numeroCta = numeroCta;
        this.cantidad = cantidad;
    }

    public String getNumeroCta() {
        return numeroCta;
    }

    public void setNumeroCta(String numeroCta) {
        this.numeroCta = numeroCta;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
}