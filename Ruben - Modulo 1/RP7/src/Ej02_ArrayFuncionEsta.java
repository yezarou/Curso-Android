import java.util.Scanner;

public class Ej02_ArrayFuncionEsta {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[] array = Leer(teclado);
        int num;

        // Introducir número a buscar.
        System.out.println("Escribe el valor a buscar: ");
        num = teclado.nextInt();

        // Resultado.
        System.out.println("El valor " + num + " " + (Esta(array, num)?"está":"no está") + " en la secuencia.");
        teclado.close();
    }

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[] Leer(Scanner teclado){
        int[] array;

        System.out.println("Introduce el número máximo de valores del array: ");
        array = new int[teclado.nextInt()];

        System.out.println("Introduce " + array.length + " valores para el array.");

        for (int i = 0; i < array.length; i++)
            array[i] = teclado.nextInt();

        return array;
    }

    // Método que devuelve true si el valor se encuentra en un array.
    private static boolean Esta(int[] array, int num){
        boolean res = false;

        for (int tmp: array){
            if (tmp == num)
                res = true;
        }

        return res;
    }
}
