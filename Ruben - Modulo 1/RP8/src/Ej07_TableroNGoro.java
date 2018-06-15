import java.util.Scanner;

public class Ej07_TableroNGoro {
    public static void main(String[] args) {
        // Declaración de variables.
        int[][] tablero;
        Scanner teclado = new Scanner(System.in);

        // Generar tablero.
        System.out.print("Escribe el valor n del que quieres el tablero: ");
        tablero = GenerarTablero(teclado.nextInt());
        teclado.close();

        // Mostrar el tablero n-goro.
        for (int[] fi : tablero){
            for (int celda : fi){
                System.out.printf("%2d ", celda);
            }
            System.out.println();
        }
    }

    // Método que genera un tablero n-goro.
    private static int[][] GenerarTablero(int n){
        int[][] tablero = new int[n][n+1];
        int fi = 0, co = 0, contador = 0;

        while (tablero[fi][co] == 0){
            tablero[fi][co] = ++contador;

            fi = (fi + 1) % tablero.length;
            co = (co + 1) % tablero[0].length;
        }

        return tablero;
    }
}
