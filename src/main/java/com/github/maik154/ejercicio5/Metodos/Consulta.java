package com.github.maik154.ejercicio5.Metodos;

import com.github.maik154.ejercicio5.Pojos.Cliente;
import com.github.maik154.ejercicio5.Pojos.Cuenta;
import com.github.maik154.ejercicio5.Pojos.CuentaCorriente;
import com.github.maik154.ejercicio5.Pojos.CuentaPlazo;
import com.github.maik154.ejercicio5.dao.ClienteDAO;

import java.util.Scanner;
import java.util.Set;

public class Consulta {

    public static void cuentasDeCliente(Scanner sc) {
        System.out.println("Dame dni del cliente");
        String dni = sc.nextLine();
        Cliente cliente = ClienteDAO.buscarPorDni(dni);
        Set<Cuenta> cuentas = cliente.getCuentas();
        for (Cuenta c : cuentas) {
            if (c instanceof CuentaCorriente) {
                System.out.printf("Cuenta corriente : ---------------" +
                        "\nNúmero: %s" +
                        "\nSucursal: %s" +
                        "\nSaldo actual: %f", c.getNumero(), c.getSucursal(), ((CuentaCorriente) c).getSaldoActual());
            } else {
                CuentaPlazo cuentaPlazo = (CuentaPlazo) c;
                System.out.printf("Cuenta a plazo: ------------------" +
                        "\nNúmero: %s" +
                        "\nSucursal: %s" +
                        "\nIntereses: %f%" +
                        "\nFecha de vencimiento: %s" +
                        "\nDepósito a plazo: %d", cuentaPlazo.getNumero(), cuentaPlazo.getSucursal(), cuentaPlazo.getIntereses(), cuentaPlazo.getFechaVencimiento().toString(), cuentaPlazo.getDepositoPlazo());
            }
        }
    }
    //todo consultar movimientos de una fecha a otra
}





