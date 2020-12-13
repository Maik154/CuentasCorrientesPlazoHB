package com.github.maik154.ejercicio5.Pojos;

import java.util.HashSet;
import java.util.Set;

public class CuentaCorriente extends Cuenta {
    private double saldoActual;
    private Set<Movimiento> movimientos;

    public CuentaCorriente(String numero, String sucursal, double saldoActual) {
        super(numero, sucursal);
        this.saldoActual = saldoActual;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public Set<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(HashSet<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public void addMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }
}
