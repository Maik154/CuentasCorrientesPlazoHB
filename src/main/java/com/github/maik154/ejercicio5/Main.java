package com.github.maik154.ejercicio5;

import com.github.maik154.ejercicio5.Metodos.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            op = Menu.menuPrincipal(sc);
            switch (op) {
                case 1:
                    Alta.anadirCliente(sc);
                    break;
                case 2:
                    Alta.anadirCuentaCorriente(sc);
                    break;
                case 3:
                    Baja.borrarCuentaPlazo(sc);
                    break;
                case 4:
                    Alta.anadirMovimiento(sc);
                    break;
                case 5:
                    Modificacion.modificarIntereses(sc);
                    break;
                case 6:
                    Modificacion.modificarDireccion(sc);
                    break;
                case 7:
                    Baja.borrarCuentaDeUnCliente(sc);
                    //Borrar cuenta de un cliente
                    break;
                case 8:
                    Consulta.cuentasDeCliente(sc);
                    break;
                case 9:
                    Consulta.movimientosDeUnaFecha(sc);
//Consultar todos los movimientos de una cuenta de un día
                    break;
                case 10:

                    break;
                default:
                    System.out.println("Opción inválida.");
            }
            //todo Baja = yo diría que sí o que
        } while (op != 8);
    }
}


