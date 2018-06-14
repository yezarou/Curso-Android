import java.util.Arrays;
import java.util.Scanner;

public class Ej11_DiasConcordantes {
    public static void main(String[] args) {
        int[] diasConcordantes;
        int nAlumnos;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el número de alumnos: ");
        nAlumnos = teclado.nextInt();

        diasConcordantes = Leer(teclado);

        for (int i = 1; i < nAlumnos; i++){
            diasConcordantes = DiasConcordantes(diasConcordantes, Leer(teclado));
        }

        System.out.println("Los días concordantes son: " + MostrarArray(diasConcordantes));

    }

    // Método que muestra los días que concuerdan entre dos alumnos.
    private static int[] DiasConcordantes (int[] alumno1, int[] alumno2){
        int[] dias = new int[0];

        for (int tmp : alumno1) {
            if (Esta(alumno2, tmp)) {
                dias = Arrays.copyOf(dias, dias.length + 1);
                dias[dias.length-1] = tmp;
            }
        }

        return dias;
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

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[] Leer(Scanner teclado){
        int[] array = new int[0];
        int entrada;

        System.out.println("Introduce valores para el array. 0 para terminar.");

        do {
            entrada = teclado.nextInt();

            if (entrada != 0 && entrada > 0 && entrada <= 31) {
                array = Arrays.copyOf(array, array.length + 1);
                array[array.length-1] = entrada;
            }
        } while (entrada != 0);

        return array;
    }

    // Método que muestra un array.
    private static String MostrarArray (int[] array){
        String txt = "";

        for (int tmp: array)
            txt += (tmp + " ");

        return txt;
    }
}
