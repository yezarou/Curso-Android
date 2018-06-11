// Rubén Zúñiga García

import java.util.Scanner;

public class Ej02 {
    public static void main(String[] args) {
        int entrada, nImpares, nConsecutivos = 0, ultimoImpar = 0;
        boolean terminado = false;
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuantos negativos consecutivos deben haber?: ");
        do {
            nImpares = teclado.nextInt();
        } while (nImpares < 0);

        System.out.println("Introduzca una secuencia de números (0 para acabar).");

        do {
            do {
                entrada = teclado.nextInt();
            } while (entrada < 0);

            if (entrada % 2 != 0) {
                if (ultimoImpar + 2 == entrada)
                    nConsecutivos++;
                else
                    nConsecutivos = 1;
                ultimoImpar = entrada;

            }
            else
                nConsecutivos = 0;

            if (nConsecutivos == nImpares)
                terminado = true;

        } while (entrada != 0 && !terminado);

        System.out.println();
        System.out.print(terminado?"Hay una ":"No hay ");
        System.out.println("una secuencia de " + nImpares + " impares en la secuencia introducida.");
        teclado.close();
    }
}
