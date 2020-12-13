package com.github.maik154.ejercicio5.Metodos;

import java.util.Scanner;

public class Menu {

    public static int menuPrincipal(Scanner sc) {
        System.out.println("""
                Menú principal: --------------------
                1 - Añadir cliente
                2 - Añadir cuenta corriente
                3 - Añadir cuenta a plazo
                4 - Añadir movimiento
                5 - Modificar intereses de una cuenta a plazo
                6 - Modificar dirección de un cliente       
                7 - Borrar cuenta de un cliente             
                8 - Consultar cliente por dni
                9 - Consultar movimientos de una cuenta en una fecha 
                """);
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

