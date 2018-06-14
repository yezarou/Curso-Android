import java.util.Arrays;
import java.util.Scanner;

public class Ej09_CambiarBaseNumero {
    public static void main(String[] args) {
        // Declaración de variables.
        int n, base;
        Scanner teclado = new Scanner(System.in);

        // Introducción de datos.
        do{
            System.out.print("Introduce un número en base 10: ");
            n = teclado.nextInt();

            System.out.print("Introduce la base del número: ");
            base = teclado.nextInt();
        }while (n < 0 || base < 2 || base > 10);

        // Resultado.
        System.out.println(MostrarArray(CambiarBase(26, 2)));
        teclado.close();
    }

    private static int[] CambiarBase (int n, int base){
        int[] res = new int[0];

        while (n != 0){
            res = Arrays.copyOf(res, res.length + 1);
            res[res.length - 1] = (n%base);
            n /= base;
        }

        return InvertirArray(res);
    }

    // Método que invierte un array.
    private static int[] InvertirArray(int[] array){
        int[] invertido = new int[array.length];

        for (int i = 0; i < array.length; i++)
            invertido[i] = array[array.length - i - 1];

        return invertido;
    }

    // Método que muestra un array.
    private static String MostrarArray (int[] array){
        String txt = "";

        for (int tmp: array)
            txt += (tmp);

        return txt;
    }
}
