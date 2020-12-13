package com.github.maik154.ejercicio5.Metodos;

import com.github.maik154.ejercicio5.Pojos.Cliente;
import com.github.maik154.ejercicio5.Pojos.CuentaCorriente;
import com.github.maik154.ejercicio5.Pojos.CuentaPlazo;
import com.github.maik154.ejercicio5.Pojos.Movimiento;
import com.github.maik154.ejercicio5.dao.ClienteDAO;
import com.github.maik154.ejercicio5.dao.CuentaCorrienteDAO;
import com.github.maik154.ejercicio5.dao.CuentaPlazoDAO;
import com.github.maik154.ejercicio5.dao.MovimientoDAO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Alta {
    public static Cliente añadirCliente(Scanner sc) {
        System.out.println("Dni del cliente:");
        String dni = sc.nextLine();
        System.out.println("Nombre del cliente");
        String nombre = sc.nextLine();
        System.out.println("Direccion del cliente:");
        String direccion = sc.nextLine();
        Cliente cliente = new Cliente(dni, nombre, direccion);
        ClienteDAO.guardar(cliente);
        return ClienteDAO.buscarPorDni(dni);
    }

    public static void añadirMovimiento(Scanner sc) {
        System.out.println("Dame dni del cliente: ");
        String dni = sc.nextLine();
        System.out.println("Dame número de cuenta corriente: ");
        String numero = sc.nextLine();
        Cliente cliente = ClienteDAO.buscarPorDni(dni);
        CuentaCorriente cuentaCorriente = CuentaCorrienteDAO.buscarPorNumero(numero);
        if (cuentaCorriente != null && cliente != null) {
            System.out.println("Quieres ingresar o retirar?" +
                    "\nI = Ingresar" +
                    "\nR = Retirar");
            char op = sc.nextLine().charAt(0);
            if (op == 'I') {
                System.out.println("Dame cantidad del movimiento: ");
                float cantidad = Float.parseFloat(sc.nextLine());
                Movimiento movimiento = new Movimiento(cuentaCorriente, cliente, cantidad, LocalDate.now(), LocalTime.now(), op);
                MovimientoDAO.guardar(movimiento);
                cuentaCorriente.setSaldoActual(cuentaCorriente.getSaldoActual() + cantidad);
                cuentaCorriente.addMovimiento(movimiento);
                CuentaCorrienteDAO.actualizar(cuentaCorriente);
            } else if (op == 'R') {
                System.out.println("Dame cantidad del movimiento: ");
                float cantidad = Float.parseFloat(sc.nextLine());
                Movimiento movimiento = new Movimiento(cuentaCorriente, cliente, cantidad, LocalDate.now(), LocalTime.now(), op);
                MovimientoDAO.guardar(movimiento);
                if (cuentaCorriente.getSaldoActual() > cantidad) {
                    cuentaCorriente.setSaldoActual(cuentaCorriente.getSaldoActual() - cantidad);
                    MovimientoDAO.guardar(movimiento);
                    cuentaCorriente.addMovimiento(movimiento);
                    CuentaCorrienteDAO.actualizar(cuentaCorriente);
                } else {
                    System.out.println("jaja bro eres pobre");
                }
            }

        } else {
            System.out.println("La cuenta o el cliente no existen.");
        }
    }

    public static void añadirCuentaPlazo(Scanner sc) {
        System.out.println("Nombre de la sucursal: ");
        String sucursal = sc.nextLine();
        System.out.println("Numero de la cuenta: ");
        String numero = sc.nextLine();
        if (CuentaPlazoDAO.buscarPorNumero(numero) != null) {
            System.out.println("Intereses de la cuenta: ");
            float saldoActual = Float.parseFloat(sc.nextLine());
            System.out.println("Cuál es el depósito plazo?: ");
            long depositoPlazo = Long.parseLong(sc.nextLine());
            if (ClienteDAO.buscarTodos().isEmpty()) {
                Cliente cliente = añadirCliente(sc);
                CuentaPlazo cuenta = new CuentaPlazo(sucursal, numero, saldoActual, depositoPlazo, LocalDate.of(2022, 8, 23));
                cuenta.addCliente(cliente);
                cliente.addCuenta(cuenta);
                CuentaPlazoDAO.guardar(cuenta);
                ClienteDAO.actualizar(cliente);
            } else {
                System.out.println("""
                        Crear un cliente nuevo o usar uno existente?
                        1 - Usar uno existente
                        2 - Crear uno nuevo
                        """);
                int op = Integer.parseInt(sc.nextLine());
                if (op == 1) {
                    System.out.println("Dame dni");
                    Cliente cliente = ClienteDAO.buscarPorDni(sc.nextLine());
                    if (cliente != null) {
                        CuentaPlazo cuenta = new CuentaPlazo(sucursal, numero, saldoActual, depositoPlazo, LocalDate.of(2022, 8, 23));
                        cuenta.addCliente(cliente);
                        cliente.addCuenta(cuenta);
                        CuentaPlazoDAO.guardar(cuenta);
                        ClienteDAO.actualizar(cliente);
                    } else {
                        System.out.println("El cliente no existe.");
                    }
                } else if (op == 2) {
                    Cliente cliente = añadirCliente(sc);
                    CuentaPlazo cuenta = new CuentaPlazo(sucursal, numero, saldoActual, depositoPlazo, LocalDate.of(2022, 8, 23));
                    cuenta.addCliente(cliente);
                    cliente.addCuenta(cuenta);
                    CuentaPlazoDAO.guardar(cuenta);
                    ClienteDAO.actualizar(cliente);
                } else {
                    System.out.println("Opción inválida.");
                }
            }
        } else {
            System.out.println("Ese numero de cuenta ya existe");
        }
    }

    public static void añadirCuentaCorriente(Scanner sc) {
        System.out.println("Dame el número de la cuenta: ");
        String numero = sc.nextLine();
        if (CuentaPlazoDAO.buscarPorNumero(numero) == null) {
            System.out.println("Dame nombre de sucursal: ");
            String sucursal = sc.nextLine();
            System.out.println("Dame el saldo actual de la cuenta: ");
            double saldoActual = Double.parseDouble(sc.nextLine());
            int op = Menu.menuCliente(sc);
            Cliente cliente;
            if (op == 1) {
                System.out.println("Dame dni");
                String dni = sc.nextLine();
                cliente = ClienteDAO.buscarPorDni(dni);
                if (cliente != null) {
                    CuentaCorriente cuenta = new CuentaCorriente(numero, sucursal, saldoActual);
                    cuenta.addCliente(cliente);
                    cliente.addCuenta(cuenta);
                    CuentaCorrienteDAO.guardar(cuenta);
                    ClienteDAO.actualizar(cliente);
                } else {
                    System.out.println("El cliente no existe.");
                }
            } else if (op == 2) {
                cliente = añadirCliente(sc);
                CuentaCorriente cuenta = new CuentaCorriente(numero, sucursal, saldoActual);
                cuenta.addCliente(cliente);
                cliente.addCuenta(cuenta);
                CuentaCorrienteDAO.guardar(cuenta);
                ClienteDAO.actualizar(cliente);
            } else {
                System.out.println("Opción inválida.");
            }
        } else {
            System.out.println("Este número de cuenta ya existe");
        }
    }
}