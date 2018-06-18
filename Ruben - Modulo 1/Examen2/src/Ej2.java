/*
 * NOMBRE: Rubén Zúñiga García
 * POSICIÓN: 5.1
 */

import java.util.Arrays;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        int[] array;
        int x;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Escriba el número de repeticiones que debe haber en la secuencia (x >= 1): ");
        do {
            x = teclado.nextInt();
        } while (x < 1);

        array = Leer(teclado);
        System.out.println("El contenido del array es: " + ArrayToString(Criba(array, x)));
    }

    private static int[] Leer(Scanner teclado){
        int[] array = new int[0];
        int entrada;

        System.out.println("Escriba una secuencia de números. Introduce un negativo para acabar.");
        do {
            entrada = teclado.nextInt();

            if (entrada >= 0) {
                array = Arrays.copyOf(array, array.length + 1);
                array[array.length-1] = entrada;
            }
        } while (entrada >= 0);
        return array;
    }

    private static int[] Criba(int[] array, int x){
        int[] resultado = new int[0];

        for (int n: array) {
            if (!Contiene(resultado, n)) {
                if (ValoresEncontrados(array, n) == x) {
                    resultado = Arrays.copyOf(resultado, resultado.length + 1);
                    resultado[resultado.length - 1] = n;
                }
            }
        }

        return resultado;
    }

    private static int ValoresEncontrados(int[] array, int n){
        int repeticiones = 0;

        for (int m : array)
            if (m == n) repeticiones++;

        return repeticiones;
    }

    private static boolean Contiene(int[] array, int n){
        boolean res = false;

        for (int x : array){
            if (x == n)
                res = true;
        }

        return res;
    }

    private static String ArrayToString(int[] array) {
        String res = "";
        int contador = 0;

        while (contador < array.length) {
            res += array[contador++];
            if (contador < array.length)
                res += ", ";
            else
                res += ".";
        }

        return res;
    }
}
