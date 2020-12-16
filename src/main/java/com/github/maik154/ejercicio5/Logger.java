package com.github.maik154.ejercicio5;

import com.github.maik154.ejercicio5.Pojos.Cliente;
import com.github.maik154.ejercicio5.Pojos.Cuenta;
import com.github.maik154.ejercicio5.Pojos.CuentaCorriente;
import com.github.maik154.ejercicio5.Pojos.CuentaPlazo;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private Logger() {

    }

    public static void clientes(List<Cliente> clientes) {
        String info = "Dni: %s\n" +
                      "Nombre: %s\n" +
                      "Dirección: %s\n";
        for (Cliente c : clientes) {
            System.out.println(String.format(info, c.getDni(), c.getNombre(), c.getDireccion()));
        }
    }

    public static void cuentasPlazo(ArrayList<Cuenta> cuentas) {
        String info = "Sucursal: %s\n" +
                      "Numero: %s\n" +
                      "Intereses: %f\n" +
                      "Depósito a plazo: %l\n";
        for (Cuenta c : cuentas) {
            if (c instanceof CuentaPlazo) {
                System.out.println(String.format(info, c.getSucursal(), c.getNumero(), ((CuentaPlazo) c).getIntereses(), ((CuentaPlazo) c).getDepositoPlazo()));
            }
        }
    }

    public static void cuentasCorrientes(ArrayList<Cuenta> cuentas) {
        String info = "Sucursal: %s\n" +
                      "Numero: %s\n" +
                      "Saldo actual: %s\n";
        for (Cuenta c : cuentas) {
            if (c instanceof CuentaCorriente) {
                System.out.println(String.format(info, c.getSucursal(), c.getNumero(), (((CuentaCorriente) c).getSaldoActual())));
            }
        }
    }
}
