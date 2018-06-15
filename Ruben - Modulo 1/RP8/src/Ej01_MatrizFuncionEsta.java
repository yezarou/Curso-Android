import java.util.Scanner;

public class Ej01_MatrizFuncionEsta {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[][] matriz = Leer(teclado);
        int num;

        // Introducir número a buscar.
        System.out.println("Escribe el valor a buscar: ");
        num = teclado.nextInt();

        // Resultado.
        System.out.println("El valor " + num + " " + (Esta(matriz, num)?"está":"no está") + " en la matriz.");
        teclado.close();
    }

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[][] Leer(Scanner teclado){
        final int MAXFILAS = 3;
        final int MAXCOLUMNAS = 4;

        int[][] matriz = new int[MAXFILAS][MAXCOLUMNAS];

        for (int i = 0; i < MAXFILAS; i++) {
            System.out.print("Introduce una fila de " + MAXCOLUMNAS + " valores separados por un espacio: ");
            for (int j = 0; j < MAXCOLUMNAS; j++)
                matriz[i][j] = teclado.nextInt();
        }

        return matriz;
    }

    // Método que devuelve true si el valor se encuentra en un array.
    private static boolean Esta(int[][] matriz, int num){
        boolean res = false;

        for (int[] fila: matriz){
            for (int celda: fila)
                if (celda == num)
                    res = true;
        }

        return res;
    }
}
