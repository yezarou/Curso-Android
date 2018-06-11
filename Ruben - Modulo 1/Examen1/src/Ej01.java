// Rubén Zúñiga García

import java.util.Scanner;

public class Ej01 {
    public static void main(String[] args) {
        int multiplicando, multiplicador, resultado = 0;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el multiplicando: ");
        do {
            multiplicando = teclado.nextInt();
        } while (multiplicando < 0);
        System.out.print("Introduce el multiplicador: ");
        do {
            multiplicador = teclado.nextInt();
        } while (multiplicador < 0);

        if (multiplicador != 0 && multiplicando != 0) {
            do {
                if (multiplicador % 2 != 0)
                    resultado += multiplicando;

                multiplicador /= 2;
                multiplicando *= 2;
            } while (multiplicador > 0);
        }

        System.out.println("\nEl resultado de la operación es: " + resultado);
        teclado.close();
    }
}
