import java.util.Arrays;
import java.util.Scanner;

public class Ej04_MediaClase {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[] alturaClase = Leer(teclado);
        double media = MediaArray(alturaClase);

        // Mostrar resultados.
        System.out.println("La media es de: " + media);
        System.out.println("Hay " + CantidadAlumnosMenores(alturaClase, media) + " alumnos menores que la media.");
        System.out.println("Hay " + CantidadAlumnosMayores(alturaClase, media) + " alumnos mayores que la media.");

        teclado.close();
    }

    private static double MediaArray(int[] array) {
        double media, suma = 0;

        for (int tmp : array)
            suma += tmp;

        media = suma / array.length;

        return media;
    }

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[] Leer(Scanner teclado){
        int[] array = new int[0];
        int entrada;

        System.out.println("Introduce las alturas de los alumnos en cms. 0 para terminar.");

        do {
            entrada = teclado.nextInt();

            if (entrada != 0) {
                array = Arrays.copyOf(array, array.length + 1);
                array[array.length-1] = entrada;
            }
        } while (entrada != 0);

        return array;
    }

    // Método que devuelve la cantidad de alumnos menores que la media.
    private static int CantidadAlumnosMenores(int[] array, double media){
        int cantidad = 0;

        for (int tmp : array)
            if (tmp < media)
                cantidad++;

        return cantidad;
    }

    // Método que devuelve la cantidad de alumnos mayores que la media.
    private static int CantidadAlumnosMayores(int[] array, double media){
        int cantidad = 0;

        for (int tmp : array)
            if (tmp > media)
                cantidad++;

        return cantidad;
    }
}
