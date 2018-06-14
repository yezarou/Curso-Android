import java.util.Scanner;

public class Ej01_ArrayFuncionMayor {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[] array = Leer(teclado);

        // Resultado.
        System.out.println("El mayor número del array es: " + Mayor(array));
        teclado.close();
    }

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[] Leer(Scanner teclado){
        final int MAX = 10;
        int[] array = new int[MAX];

        System.out.println("Introduce " + MAX + " valores para el array.");

        for (int i = 0; i < array.length; i++)
            array[i] = teclado.nextInt();

        return array;
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
