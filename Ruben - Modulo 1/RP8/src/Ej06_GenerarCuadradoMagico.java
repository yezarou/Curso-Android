import java.util.Scanner;

public class Ej06_GenerarCuadradoMagico {
    public static void main(String[] args) {
        // Declaración de variables.
        int[][] cuadradoMagico = GenerarCuadradoMagico();

        // Mostrar el cuadrado mágico.
        for (int[] fi : cuadradoMagico){
            for (int celda : fi){
                System.out.printf("%2d ", celda);
            }
            System.out.println();
        }
    }

    // Método que genera un cuadrado mágico.
    private static int[][] GenerarCuadradoMagico(){
        final int MAXFILASCOLUMNAS = 5; // Debe ser impar.
        int[][] matriz = new int[MAXFILASCOLUMNAS][MAXFILASCOLUMNAS];
        int fi = 0, co = matriz.length/2, contador = 0;

        while (matriz[fi][co] == 0){
            matriz[fi][co] = ++contador;

            if (matriz[(fi + matriz.length - 1) % matriz.length][(co + matriz.length - 1) % matriz.length] == 0) {
                fi = (fi + matriz.length - 1) % matriz.length;
                co = (co + matriz.length - 1) % matriz.length;
            }
            else {
                fi = (fi + 1) % matriz.length;
            }

        }

        return matriz;
    }
}
