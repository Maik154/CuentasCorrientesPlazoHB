package com.github.maik154.ejercicio5.Metodos;

import com.github.maik154.ejercicio5.dao.ClienteDAO;
import com.github.maik154.ejercicio5.dao.CuentaDAO;
import com.github.maik154.ejercicio5.Pojos.Cliente;
import com.github.maik154.ejercicio5.Pojos.Cuenta;

import java.util.Scanner;

public class Modificacion {
    public static void modificarDireccion(Scanner sc) {
        System.out.println("Dame dni: ");
        String dni = sc.nextLine();
        Cliente cliente = ClienteDAO.buscarClientePorDni(dni);
        if (cliente != null) {
            System.out.println("Dame nueva dirección");
            String direccion = sc.nextLine();
            cliente.setDireccion(direccion);
        } else {
            System.out.println("Este cliente no existe");
        }
    }

    public static void modificarIntereses(Scanner sc) {
        System.out.println("Dame número de cuenta:");
        String numero = sc.nextLine();
        Cuenta cuenta = CuentaDAO.buscarCuentaPorNumero(numero);
        CuentaDAO.modificarIntereses(cuenta);
    }
    //todo arreglar esto
}
