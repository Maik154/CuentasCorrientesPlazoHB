package com.github.maik154.ejercicio5.Metodos;

import com.github.maik154.ejercicio5.dao.ClienteDAO;
import com.github.maik154.ejercicio5.dao.CuentaDAO;

import java.util.Scanner;

public class Baja {
    public static void borrarCuentaPlazo(Scanner sc) {
        System.out.println("Cuál es el número de la cuenta que deseas borrar?: ");
        CuentaDAO.borrarCuentaPlazoHB(sc.nextLine());
    }

    public static void borrarCuentaCorriente(Scanner sc) {
        System.out.println("Cuál es el número de la cuenta que deseas borrar?: ");
        CuentaDAO.borrarCuentaCorrienteHB(sc.nextLine());
    }

    public static void borrarCliente(Scanner sc) {
        System.out.println("Dame dni del cliente que quieres eliminar: ");
        ClienteDAO.borrarCliente(sc.nextLine());
    }
}




