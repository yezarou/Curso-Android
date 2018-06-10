import java.util.Random;
import java.util.Scanner;

public class Ej17_JuegoRetirarValor {
    public static void main(String[] args) {
        // Declaración de variables.
        int nObjetos, nRetirado = 0;
        boolean turno, terminado = false;
        Random rnd = new Random();
        Scanner entrada = new Scanner(System.in);

        // Instrucciones del juego.
        System.out.println("Este juego consiste en declarar un número de objetos y jugar contra la máquina." +
                "\nSe pueden retirar de 1 a 3 objetos, y quien retire el último pierde.");

        // Inicializar número de objetos.
        do {
            System.out.print("Escriba el número de objetos que habrá (min = 6)");
            nObjetos = entrada.nextInt();
        } while (nObjetos < 6);

        // Turno aleatorio.
        turno = rnd.nextBoolean();

        do {
            if (turno) { // Contempla las posibilidades de derrota y elige la mejor opción.
                System.out.println("\nTurno de la máquina.");

                if (nObjetos > 8)
                    nRetirado = 3;
                else if (nObjetos > 5)
                    for (int i = 1; i <= 3; i++) {
                        if (nObjetos - i == 5) nRetirado = i;
                    }
                else
                    for (int i = 1; i <= 3; i++) {
                        if (nObjetos - i == 1) nRetirado = i;
                    }
                System.out.println("La máquina retira " + nRetirado);
            } else { // El jugador elige un número.
                System.out.println("\nTurno del jugador.");
                do {
                    System.out.print("Seleccione un número a retirar (1-3): ");
                    nRetirado = entrada.nextInt();
                } while (nRetirado <= 0 || nRetirado >= 4);
            }

            // Se retiran los objetos y se dice cuantos hay.
            nObjetos -= nRetirado;
            System.out.println("Hay " + nObjetos + " objetos.");

            // Si hay menos de 0, finaliza.
            if (nObjetos <= 0)
                terminado = true;
            else
                turno = !turno;
        } while (!terminado);

        // Resultado final.
        if (!turno)
            System.out.println("El ordenador ha ganado.");
        else
            System.out.println("El jugador ha ganado.");

        entrada.close();
    }
}
