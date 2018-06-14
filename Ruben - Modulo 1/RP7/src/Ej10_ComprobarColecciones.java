import java.util.Scanner;

public class Ej10_ComprobarColecciones {
    public static void main(String[] args) {
        // Declaración de variables.
        int[] a1;
        int[] a2;
        int max;
        Scanner teclado = new Scanner(System.in);

        // Introducir datos.
        System.out.print("Introduce el número máximo de valores del array: ");
        max = teclado.nextInt();

        a1 = Leer(teclado, max);
        a2 = Leer(teclado, max);

        // Mostrar el resultado.
        System.out.println(CompararColeccion(a1, a2));

        teclado.close();
    }

    static private boolean CompararColeccion(int[] a1, int[] a2){
        boolean res = true;
        int dif = 0;

        if (a1.length != a2.length)
            return false;

        for (int i = 0; i < a1.length; i++){
            if (a1[0] == a2[i])
                dif = i;
        }

        for (int i = 0; i < a1.length; i++){
            if (a1[i] != a2[(i + dif) % a1.length])
                res = false;
        }

        return res;
    }

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[] Leer(Scanner teclado, int max){
        int[] array = new int[max];

        System.out.println("Introduce " + max + " valores para el array.");

        for (int i = 0; i < array.length; i++)
            array[i] = teclado.nextInt();

        return array;
    }
}
