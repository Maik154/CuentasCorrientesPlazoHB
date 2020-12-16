package com.github.maik154.ejercicio5.Metodos;

import java.util.Scanner;

public class Menu {

    public static int menuPrincipal(Scanner sc) {
        System.out.println("Menú principal: --------------------\n" +
                           "1 - Añadir cliente\n" +
                           "2 - Añadir cuenta corriente\n" +
                           "3 - Añadir cuenta a plazo\n" +
                           "4 - Añadir movimiento\n" +
                           "5 - Modificar intereses de una cuenta a plazo\n" +
                           "6 - Modificar dirección de un cliente\n" +
                           "7 - Borrar cuenta de un cliente\n" +
                           "8 - Consultar cuentas de un cliente por dni\n" +
                           "9 - Consultar movimientos de una cuenta en una fecha\n");
        return Integer.parseInt(sc.nextLine());
    }


    public static int menuCliente(Scanner sc) {
        int op = 0;
        do {
            System.out.println("Tienes ya un cliente creado o quieres crear uno ahora?: " +
                    "\n1 = Usar un cliente existente" +
                    "\n2 = Crear uno");
            op = Integer.parseInt(sc.nextLine());
        } while (op < 1 || op > 2);
        return op;
    }

    public static int menuConsulta(Scanner sc) {
        int op = 0;
        do {
            System.out.println("1= Quieres ver clientes a partir de una cuenta?" +
                    "\n2 = Ver cuentas a partir de un cliente" +
                    "\n3=  Ver movimientos a partir de una cuenta corriente" +
                    "\n4= Consultar todas las cuentas");
            op = sc.nextInt();
        } while (op < 1 || op > 4);
        return op;
    }
}

