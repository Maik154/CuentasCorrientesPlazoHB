package com.github.maik154.ejercicio5.Pojos;

import java.sql.Date;

public class CuentaPlazo extends Cuenta {
    private float intereses;
    private Date fechaVencimiento;
    private long depositoPlazo;

    public CuentaPlazo(String sucursal, String numero, float intereses, long depositoPlazo, Date fechaVencimiento) {
        super(numero, sucursal);
        this.intereses = intereses;
        this.depositoPlazo = depositoPlazo;
        this.fechaVencimiento = fechaVencimiento;
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

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
