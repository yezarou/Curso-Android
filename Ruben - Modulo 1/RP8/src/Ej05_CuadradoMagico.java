import java.util.Scanner;

public class Ej05_CuadradoMagico {
    public static void main(String[] args) {
        // Declaración de variables.
        Scanner teclado = new Scanner(System.in);
        int[][] matriz = Leer(teclado);

        // Resultado.
        System.out.println("La matriz insertada " + (CuadradoMagico(matriz)?"es":"no es") + " un cuadrado mágico.");
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

    // Método que devuelve la suma de la diagonal de una matriz.
    private static int SumaDiagonal(int[][] matriz, boolean sentido){
        int suma = 0;
        int nValores = matriz.length>matriz[0].length?matriz[0].length:matriz.length;

        if (sentido)
            for (int i = 0; i < nValores; i++)
                suma += matriz[i][i];
        else
            for (int i = 0; i < nValores; i++)
                suma += matriz[nValores - i - 1][i];

        return suma;
    }

    // Comprobar si es un cuadrado mágico.
    private static boolean CuadradoMagico (int[][] matriz){
        final int sumaNecesaria = SumaDiagonal(matriz, true);
        int sumaColumna = 0, sumaFila = 0;

        if (sumaNecesaria != SumaDiagonal(matriz, false))
            return false;
        else if (matriz.length != matriz[0].length)
            return false;

        for (int i = 0; i < matriz.length; i++){
            sumaColumna = 0;
            sumaFila = 0;

            for (int j = 0; j < matriz.length; j++) {
                sumaColumna += matriz[i][j];
                sumaFila += matriz[j][i];
            }

            if (sumaColumna != sumaFila || sumaColumna != sumaNecesaria)
                return false;
        }

        return true;
    }
}
