package com.github.maik154.ejercicio5.Metodos;

import com.github.maik154.ejercicio5.Pojos.Cliente;
import com.github.maik154.ejercicio5.Pojos.CuentaCorriente;
import com.github.maik154.ejercicio5.Pojos.CuentaPlazo;
import com.github.maik154.ejercicio5.Pojos.Movimiento;
import com.github.maik154.ejercicio5.dao.ClienteDAO;
import com.github.maik154.ejercicio5.dao.CuentaPlazoDAO;
import com.github.maik154.ejercicio5.dao.MovimientoDAO;

import java.time.LocalDate;
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
        System.out.println("Dame número de cuenta corriente: ");
        String numero = sc.nextLine();
        CuentaCorriente cuentaCorriente = CuentaPlazoDAO.buscarCuentaCorriente(numero);
        // CuentaCorriente cuentaCorriente = Busqueda.buscarCuentaCorriente(cuentas, numero);
        CuentaPlazoDAO.añadirCuentaCorrienteHB(cuentaCorriente);
        if (cuentaCorriente != null) {
            System.out.println("Dame cantidad del movimiento: ");
            float cantidad = Float.parseFloat(sc.nextLine());
            MovimientoDAO.añadirMovimientoHB(new Movimiento(numero, cantidad));
        } else {
            System.out.println("esa cuenta no existe.");
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
                ClienteDAO.buscarTodos();
                System.out.println("Dame dni");
                String dni = sc.nextLine();
                cliente = ClienteDAO.buscarPorDni(dni);
                while (cliente == null) {
                    cliente = ClienteDAO.buscarPorDni(dni);
                }
            } else {
                cliente = añadirCliente(clientes);
                // todo no entiendo este añadir cliente

            }
            CuentaPlazoDAO.añadirCuentaHB(new CuentaCorriente(numero, sucursal, saldoActual));
        } else {
            System.out.println("Este número de cuenta ya existe");
        }
    }
}