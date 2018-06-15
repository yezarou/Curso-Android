import java.util.Scanner;

public class Ej03_MatrizMayor {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[][] matriz = Leer(teclado);
        int mayor = MayorElemento(matriz), fila = FilaValor(matriz, mayor), columna = ColumaValor(matriz, mayor);

        // Resultado.
        System.out.println("El mayor valor de la matriz es: " + mayor);
        System.out.printf("Fila (empieza en 0): %d, Columna(empieza en 0): %d.",fila,columna);
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

    // Método que devuelve el mayor elemento de una matriz.
    private static int MayorElemento(int[][] matriz){
        int mayor = matriz[0][0];
        final int MAXFILAS = matriz.length, MAXCOL = matriz[0].length;

        for (int fi = 0; fi < MAXFILAS; fi++) {
            for (int co = 0; co < MAXCOL; co++) {
                if (matriz[fi][co] > mayor) {
                    mayor = matriz[fi][co];
                }
            }
        }

        return mayor;
    }

    // Método que devuelve la columna de la ultima ocurrencia de un valor.
    private static int ColumaValor(int[][] matriz, int n){
        int col = 0;
        final int MAXFILAS = matriz.length, MAXCOL = matriz[0].length;

        for (int fi = 0; fi < MAXFILAS; fi++) {
            for (int co = 0; co < MAXCOL; co++) {
                if (matriz[fi][co] == n) {
                    col = co;
                }
            }
        }

        return col;
    }

    // Método que devuelve la fila de la ultima ocurrencia de un valor.
    private static int FilaValor(int[][] matriz, int n){
        int filas = 0;
        final int MAXFILAS = matriz.length, MAXCOL = matriz[0].length;

        for (int fi = 0; fi < MAXFILAS; fi++) {
            for (int co = 0; co < MAXCOL; co++) {
                if (matriz[fi][co] == n) {
                    filas = fi;
                }
            }
        }

        return filas;
    }
}
