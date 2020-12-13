package com.github.maik154.ejercicio5;

import com.github.maik154.ejercicio5.Metodos.Alta;
import com.github.maik154.ejercicio5.Metodos.Baja;
import com.github.maik154.ejercicio5.Metodos.Menu;
import com.github.maik154.ejercicio5.Metodos.Modificacion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            op = Menu.menuPrincipal(sc);
            switch (op) {
                case 1:
                    Alta.añadirCliente(sc);
                    break;
                case 2:
                    Alta.añadirCuentaCorriente(sc);
                    break;
                case 3:
                    Baja.borrarCuentaPlazo(sc);
                    break;
                case 4:
                    //Añadir movimiento
                    Alta.añadirMovimiento(sc);
                    break;
                case 5:
                    Modificacion.modificarIntereses(sc);
                    break;
                case 6:
                    Modificacion.modificarDireccion(sc);
                    break;
                case 7:
                    //Borrar cuenta de un cliente
                    break;
                case 8:
//Consultar cliente por dni
                    break;
                case 9:
//Consultar todos los movimientos de una cuenta de un día
                    break;
                case 10:

                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            //todo Baja = done Alta = undone

        } while (op != 8);
    }
}


