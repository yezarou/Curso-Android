import java.util.Arrays;
import java.util.Scanner;

public class Ej03_ArrayFuncionMayorMinimo {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[] array = Leer(teclado);
        int num;

        // Resultado.
        try {
            System.out.println("El valor " + MayorMinimo(array) + " es un mayor mínimo.");
        }
        catch(Exception e) {
            System.out.println("El array no tiene un mayor mínimo.");
        }

        teclado.close();
    }

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[] Leer(Scanner teclado){
        int[] array = new int[0];
        int entrada;

        System.out.println("Introduce valores para el array. 0 para terminar.");

        do {
            entrada = teclado.nextInt();

            if (entrada != 0) {
                array = Arrays.copyOf(array, array.length + 1);
                array[array.length-1] = entrada;
            }
        } while (entrada != 0);

        return array;
    }

    // Método que busca un valor mayor que el mínimo.
    private static int MayorMinimo(int[] array) throws Exception {
        int n1 = array[0], n2, contador = 1;

        while (n1 == (n2 = array[contador++]) );

        if (n1 > n2)
            return n1;
        else if (n2 > n1)
            return n2;
        else
            throw new Exception("No hay un mayor mínimo.");
    }
}
