import java.util.Scanner;

public class Ej04_MatrizSimetrica {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[][] matriz = Leer(teclado);

        // Resultado.
        System.out.println("La matriz introducida " + (MatrizSimetrica(matriz)?"es":"no es") + " simetrica.");
    }

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[][] Leer(Scanner teclado){
        final int MAXFILASCOLUMNAS = 5;

        int[][] matriz = new int[MAXFILASCOLUMNAS][MAXFILASCOLUMNAS];

        for (int i = 0; i < MAXFILASCOLUMNAS; i++) {
            System.out.print("Introduce una fila de " + MAXFILASCOLUMNAS + " valores separados por un espacio: ");
            for (int j = 0; j < MAXFILASCOLUMNAS; j++)
                matriz[i][j] = teclado.nextInt();
        }

        return matriz;
    }

    // Método que devuelve true si una matriz es simétrica.
    private static boolean MatrizSimetrica(int[][] matriz) {
        boolean res = true;
        final int MAXFILAS = matriz.length, MAXCOL = matriz[0].length;

        for (int fi = 0; fi < MAXFILAS; fi++) {
            for (int co = 0; co < MAXCOL; co++) {
                if (matriz[fi][co] != matriz[co][fi]) {
                    res = false;
                }
            }
        }

        return res;
    }
}
