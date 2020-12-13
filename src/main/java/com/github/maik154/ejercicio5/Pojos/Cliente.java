package com.github.maik154.ejercicio5.Pojos;

import java.util.HashSet;
import java.util.Set;

public class Cliente {
    private String dni;
    private String nombre;
    private String direccion;
    private Set<Cuenta> cuentas;
    private int id;

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(HashSet<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void addCuenta(Cuenta cuenta) {
        this.cuentas.add(cuenta);
    }
}