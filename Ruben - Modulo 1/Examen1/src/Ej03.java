// Rubén Zúñiga García

import java.util.Scanner;

public class Ej03 {
    public static void main(String[] args) {
        int num, n, producto, resultado = 0, contador = 0;
        boolean terminado = false;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el número: ");
        do {
            num = teclado.nextInt();
        } while (num < 0);

        System.out.print("Introduce el valor de la raiz: ");
        do {
            n = teclado.nextInt();
        } while (num < 1);

        while (!terminado){
            producto = contador;

            for (int i = 1; i < n; i++)
                producto *= contador;

            if (producto <= num)
                resultado = contador;
            if (producto >= num)
                terminado = true;

            contador++;
        }

        System.out.println("\nEl resultado (x) de la raiz es: " + resultado);
        teclado.close();
    }
}
