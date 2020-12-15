package com.github.maik154.ejercicio5.Metodos;

import com.github.maik154.ejercicio5.Pojos.*;
import com.github.maik154.ejercicio5.dao.ClienteDAO;
import com.github.maik154.ejercicio5.dao.CuentaCorrienteDAO;

import java.time.LocalDate;
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

    public static void movimientosDeUnaFecha(Scanner sc) {
        System.out.println("Dame número de cuenta: ");
        String numero = sc.nextLine();
        System.out.println("Primera fecha: " +
                "\nDame año: ");
        int año1 = Integer.parseInt(sc.nextLine());
        System.out.println("Dame mes(número): ");
        int mes1 = Integer.parseInt(sc.nextLine());
        System.out.println("Dame día: ");
        int dia1 = Integer.parseInt(sc.nextLine());
        System.out.println("Segunda fecha: " +
                "\nDame año: ");
        int año2 = Integer.parseInt(sc.nextLine());
        System.out.println("Dame mes(número): ");
        int mes2 = Integer.parseInt(sc.nextLine());
        System.out.println("Dame día: ");
        int dia2 = Integer.parseInt(sc.nextLine());
        LocalDate primeraFecha = LocalDate.of(año1, mes1, dia1);
        LocalDate segundaFecha = LocalDate.of(año2, mes2, dia2);
        if (primeraFecha.isBefore(segundaFecha)) {
            CuentaCorriente cuentaCorriente = CuentaCorrienteDAO.buscarPorNumero(numero);
            for (Movimiento m : cuentaCorriente.getMovimientos()) {
                if (m.getFechaOperacion().isAfter(primeraFecha) && m.getFechaOperacion().isBefore(segundaFecha)) {
                    String tipoDeOperacion;
                    if(m.getOperacion() == 'R'){
                        tipoDeOperacion = "Retiro";
                    }else{
                        tipoDeOperacion = "Ingreso";
                    }
                    System.out.printf("Movimiento:---------------" +
                            "\nCantidad: %f" +
                            "\nFecha de la operación: %s" +
                            "\nHora: %s" +
                            "\nTipo de operación: %s", m.getCantidad(), m.getFechaOperacion().toString(), m.getHora().toString(), tipoDeOperacion);
                }
            }
        } else {
            System.out.println("La primera fecha es más tarde que la segunda.");
        }
    }
}
//todo consultar movimientos de una fecha a otra