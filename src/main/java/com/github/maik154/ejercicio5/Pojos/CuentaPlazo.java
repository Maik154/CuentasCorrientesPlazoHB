package com.github.maik154.ejercicio5.Pojos;

import java.time.LocalDate;

public class CuentaPlazo extends Cuenta {
    private float intereses;
    private LocalDate fechaVencimiento;
    private long depositoPlazo;
    private int id;

    public CuentaPlazo(String sucursal, String numero, float intereses, long depositoPlazo, LocalDate fechaVencimiento) {
        super(numero, sucursal);
        this.intereses = intereses;
        this.depositoPlazo = depositoPlazo;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getId() {
        return id;
    }

    public float getIntereses() {
        return intereses;
    }

    public void setIntereses(float intereses) {
        this.intereses = intereses;
    }

    public long getDepositoPlazo() {
        return depositoPlazo;
    }

    public void setDepositoPlazo(long depositoPlazo) {
        this.depositoPlazo = depositoPlazo;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
