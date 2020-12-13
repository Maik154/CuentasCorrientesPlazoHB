package com.github.maik154.ejercicio5.Pojos;

import java.util.HashSet;
import java.util.Set;

public abstract class Cuenta {
    private String numero;
    private String sucursal;
    private Set<Cliente> clientes;

    public Cuenta(String numero, String sucursal) {
        this.numero = numero;
        this.sucursal = sucursal;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashSet<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

}