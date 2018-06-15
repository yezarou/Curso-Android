import java.util.Scanner;

public class Ej02_MatrizSumarDiagonal {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[][] matriz = Leer(teclado);

        // Resultado.
        System.out.println("La suma de la diagonal de la matriz es de: " + SumaDiagonal(matriz));
    }

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[][] Leer(Scanner teclado){
        final int MAXFILAS = 5;
        final int MAXCOLUMNAS = 5;

        int[][] matriz = new int[MAXFILAS][MAXCOLUMNAS];

        for (int i = 0; i < MAXFILAS; i++) {
            System.out.print("Introduce una fila de " + MAXCOLUMNAS + " valores separados por un espacio: ");
            for (int j = 0; j < MAXCOLUMNAS; j++)
                matriz[i][j] = teclado.nextInt();
        }

        return matriz;
    }

    // Método que devuelve la suma de la diagonal de una matriz.
    private static int SumaDiagonal(int[][] matriz){
        int suma = 0;
        int nValores = matriz.length>matriz[0].length?matriz[0].length:matriz.length;

        for (int i = 0; i < nValores; i++)
            suma += matriz[i][i];

        return suma;
    }
}
