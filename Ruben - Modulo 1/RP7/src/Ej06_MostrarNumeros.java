import java.util.Arrays;
import java.util.Scanner;

public class Ej06_MostrarNumeros {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[] array = Leer(teclado);

        // Resultado.
        System.out.println("El número de valores es: ");
        System.out.println(MostrarArray(ContadorValores(array)));
    }

    // Método que muestra un array.
    private static String MostrarArray (int[] array){
        String txt = "";
        int contador = 0;

        for (int tmp: array)
            if (contador < array.length -1)
                txt += (tmp + ": " + contador++ + ", ");
            else
                txt += (tmp + ": " + contador++ + ".");

        return txt;
    }

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[] Leer(Scanner teclado){
        int[] array = new int[0];
        int entrada;

        System.out.println("Introduce valores para el array (0-9). Número negativo para terminar.");

        do {
            entrada = teclado.nextInt();

            if (entrada >= 0 && entrada < 10) {
                array = Arrays.copyOf(array, array.length + 1);
                array[array.length-1] = entrada;
            }
        } while (entrada >= 0);

        return array;
    }

    // Programa que devuelve un array con el número de valores que hay en otro array.
    private static int[] ContadorValores(int[] array){
        int[] resultado = new int[10];

        for (int tmp : array){
            resultado[tmp]++;
        }

        return resultado;
    }
}
