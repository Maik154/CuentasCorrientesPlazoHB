package com.github.maik154.ejercicio5.Metodos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Consulta {

//    public static void consultarClientesPorCuenta(Scanner sc) {
//        System.out.println("Cuál es el número de cuenta?: ");
//        String numeroCuenta = sc.nextLine();
//        Cuenta cuenta = CuentaDAO.buscarCuentaPorNumero(numeroCuenta);
////        for (Cuenta c : cuentas) {
////            if (numeroCuenta.equals(c.getNumero())) {
//                System.out.println("La cuenta existe.");
////                Iterator<Cliente> it = c.getClientes().iterator();
////                while (it.hasNext()) {
////                    Cliente cliente = it.next();
//
////                    System.out.println("Nombre del cliente: " + cliente.getNombre() +
////                            "\nDni del cliente: " + cliente.getDni() +
////                            "\nDirección del cliente: " + cliente.getDireccion());
//                }
//            }
//        }
//    }


    public static void consultarCuentaPorCliente(ArrayList<Cliente> clientes) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println("Nombre del los clientes: " + clientes.get(i).getNombre() +
                    "\nDni del cliente:  " + clientes.get(i).getDni());
        }
        System.out.println("Cuál es el DNI del cliente que quieres?: ");
        String dniBuscado = sc.nextLine();
        for (int i = 0; i < clientes.size(); i++) {
            if (dniBuscado.equals(clientes.get(i).getDni())) {
                System.out.println("El cliente con el DNI que pusiste existe.");
                Iterator<Cuenta> it = clientes.get(i).getCuentas().iterator();
                while (it.hasNext()) {
                    Cuenta cuenta = it.next();
                    if (cuenta instanceof CuentaCorriente) {
                        CuentaCorriente cuentaCorriente = (CuentaCorriente) cuenta;
                        System.out.println("com.github.maik154.ejercicio5.pojo.Cuenta corriente");
                        System.out.println("----------------");
                        System.out.println("Número de la cuenta: " + cuenta.getNumero() +
                                "\nSucursal de la cuenta: " + cuenta.getSucursal() +
                                "\nSaldo actual de la cuenta: " + cuentaCorriente.getSaldoActual() + "\n");
                    } else {
                        CuentaPlazo cuentaPlazo = (CuentaPlazo) cuenta;
                        System.out.println("com.github.maik154.ejercicio5.pojo.Cuenta a plazo");
                        System.out.println("--------------");
                        System.out.println("Número de la cuenta: " + cuenta.getNumero() +
                                "\nSucursal de la cuenta: " + cuenta.getSucursal() +
                                "\nIntereses de la cuenta a plazo: " + cuentaPlazo.getIntereses() +
                                "\nDepósito a plazo de la cuenta a plazo: " + cuentaPlazo.getDepositoPlazo() + "\n");

                    }
                }
            }
        }
    }

    public static void consultarMovimientosPorCuentaCorriente(ArrayList<Cuenta> cuentas) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println("Número de cuenta: " + cuentas.get(i).getNumero());
        }
        System.out.println("Dame número de tu cuenta corriente: ");
        String numCuenta = sc.nextLine();
        for (int i = 0; i < cuentas.size(); i++) {
            if (numCuenta.equals(cuentas.get(i).getNumero())) {
                if (cuentas.get(i) instanceof CuentaCorriente) {
                    CuentaCorriente cuentaCorriente = (CuentaCorriente) cuentas.get(i);
                    System.out.println("Tu cuenta es una cuenta corriente" +
                            "\nAquí están sus movimientos:");
                    Iterator<Movimiento> it = cuentaCorriente.getMovimientos().iterator();
                    while (it.hasNext()) {
                        Movimiento movimiento = it.next();
                        float cantidad = movimiento.getCantidad();
                        System.out.println("Número de la cuenta: " + cuentaCorriente.getNumero() +
                                "\nCantidad del movimiento: " + cantidad);
                    }
                }
                return;
            }
        }
    }

    public static void consultarCuentasCorrientes(ArrayList<Cuenta> cuentas) {
        for (Cuenta c : cuentas) {
            if (c instanceof CuentaCorriente) {
                CuentaCorriente cuentaCorriente = (CuentaCorriente) c;
                System.out.println("Número de la cuenta: " + cuentaCorriente.getNumero() +
                        "\nSucursal de la cuenta: " + cuentaCorriente.getSucursal() +
                        "\nSaldo actual de la cuenta corriente: " + cuentaCorriente.getSaldoActual());
            }
        }
    }

    public static void consultarCuentasPlazo(ArrayList<Cuenta> cuentas) {
        for (Cuenta c : cuentas) {
            if (c instanceof CuentaPlazo) {
                CuentaPlazo cuentaPlazo = (CuentaPlazo) c;
                System.out.println("Número de la cuenta: " + cuentaPlazo.getNumero() +
                        "\nSucursal de la cuenta: " + cuentaPlazo.getSucursal() +
                        "\nDepósito a plazo de la cuenta corriente: " + cuentaPlazo.getDepositoPlazo());
            }
        }
    }
}





