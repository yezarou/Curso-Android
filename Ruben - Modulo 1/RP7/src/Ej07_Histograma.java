import java.util.Arrays;
import java.util.Scanner;

public class Ej07_Histograma {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[] array = Leer(teclado);

        // Resultado.
        MostrarHistograma(ContadorValores(array));
    }

    // Método que muestra un histograma de un array.
    private static void MostrarHistograma (int[] array) {
        int mayor = Mayor(array);

        while (mayor > 0){
            for (int tmp : array) {
                if (tmp >= mayor)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }

            System.out.println();
            mayor--;
        }

        for (int i = 0; i < array.length; i++){
            System.out.print(i + " ");
        }
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

    // Método que devuelve el mayor valor que contiene un array.
    private static int Mayor (int[] array){
        int mayor = array[0];

        for (int tmp:array) {
            if (tmp > mayor)
                mayor = tmp;
        }

        return mayor;
    }
}
