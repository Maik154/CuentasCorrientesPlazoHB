package com.github.maik154.ejercicio5.Metodos;

import com.github.maik154.ejercicio5.Pojos.Cliente;
import com.github.maik154.ejercicio5.Pojos.Cuenta;
import com.github.maik154.ejercicio5.Pojos.CuentaCorriente;
import com.github.maik154.ejercicio5.Pojos.CuentaPlazo;
import com.github.maik154.ejercicio5.dao.ClienteDAO;
import com.github.maik154.ejercicio5.dao.CuentaCorrienteDAO;
import com.github.maik154.ejercicio5.dao.CuentaPlazoDAO;

import java.util.Scanner;

public class Baja {
    public static void borrarCuentaPlazo(Scanner sc) {
        // pedir DNI cliente
        // listar cuentas plazo cliente
        // if (instanceof)
        System.out.println("Cuál es el número de la cuenta que deseas borrar?: ");
        CuentaPlazoDAO.borrar(sc.nextLine());
    }

    public static void borrarCuentaCorriente(Scanner sc) {
        System.out.println("Cuál es el número de la cuenta que deseas borrar?: ");
        CuentaPlazoDAO.borrar(sc.nextLine());
    }

    public static void borrarCliente(Scanner sc) {
        System.out.println("Dame dni del cliente que quieres eliminar: ");
        ClienteDAO.borrar(sc.nextLine());
    }

    public static void borrarCuentaDeUnCliente(Scanner sc) {
        System.out.println("Dame DNI del cliente: ");
        String dni = sc.nextLine();
        Cliente cliente = ClienteDAO.buscarPorDni(dni);


        for (Cuenta c : cliente.getCuentas()) {
            if (c instanceof CuentaPlazo) {
                System.out.printf("Cuenta a plazo: ------" +
                                "\nNúmero: %s" +
                                "\nSucursal: %s" +
                                "\nIntereses: %f" +
                                "\nFecha de vencimiento: %s" +
                                "\nDepósito a plazo: %d",
                        c.getNumero(), c.getSucursal(), ((CuentaPlazo) c).getIntereses(), ((CuentaPlazo) c).getFechaVencimiento().toString(), ((CuentaPlazo) c).getDepositoPlazo());

            } else if (c instanceof CuentaCorriente) {
                System.out.printf("Cuenta a plazo: ------" +
                                "\nNúmero: %s" +
                                "\nSucursal: %s" +
                                "\nSaldo actual: %f",
                        c.getNumero(), c.getSucursal(), ((CuentaCorriente) c).getSaldoActual());
            }
        }
        System.out.println("Dame número de la cuenta que quieres eliminar: ");
        String numero = sc.nextLine();
        for (Cuenta c : cliente.getCuentas()) {
            if (c.getNumero().compareToIgnoreCase(numero) == 0) {
                if (c instanceof CuentaCorriente) {
                    CuentaCorrienteDAO.borrar(numero);
                } else if (c instanceof CuentaPlazo) {
                    CuentaPlazoDAO.borrar(numero);
                }
            } else {
                System.out.println("Esa cuenta no existe o no es de este cliente.");
            }
        }
    }
}
//todo borrar cuenta de un cliente DONEEEEEEEEEEEEEEE