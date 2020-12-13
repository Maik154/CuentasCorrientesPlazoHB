package com.github.maik154.ejercicio5.Metodos;

import com.github.maik154.ejercicio5.Pojos.Cliente;
import com.github.maik154.ejercicio5.Pojos.CuentaPlazo;
import com.github.maik154.ejercicio5.dao.ClienteDAO;
import com.github.maik154.ejercicio5.dao.CuentaPlazoDAO;

import java.util.Scanner;

public class Modificacion {
    public static void modificarDireccion(Scanner sc) {
        System.out.println("Dame dni: ");
        String dni = sc.nextLine();
        Cliente cliente = ClienteDAO.buscarPorDni(dni);
        if (cliente != null) {
            System.out.println("Dame nueva dirección");
            String direccion = sc.nextLine();
            cliente.setDireccion(direccion);
            ClienteDAO.actualizar(cliente);
        } else {
            System.out.println("Este cliente no existe");
        }
    }

    public static void modificarIntereses(Scanner sc) {
        System.out.println("Dame número de cuenta:");
        String numero = sc.nextLine();
        CuentaPlazo cuenta = CuentaPlazoDAO.buscarPorNumero(numero);
        if (cuenta != null) {
            System.out.println("Nuevo interés: ");
            float interes = Float.parseFloat(sc.nextLine());
            cuenta.setIntereses(interes);
            CuentaPlazoDAO.actualizar(cuenta);
        } else {
            System.out.println("Esta cuenta no existe");
        }
    }
}
