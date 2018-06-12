import java.util.Scanner;

public class Ej10_DibujarFigura {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n;
        System.out.print("Introduzca n: ");
        do {
            n = teclado.nextInt();
        } while (n <= 0 || n % 2 != 0 || n >= 20);
        for (int linea = 1; linea <= n; linea++){
            dibujarLinea(linea,n);
        }
        for (int linea = n; linea >= 1; linea--){
            dibujarLinea(linea,n);
        }
        teclado.close();
    }

    private static void dibujarLinea(int linea,
                                     int n) {
        dibujarBlancos(linea);
        dibujarTriangulo(linea, n);
        System.out.println();
    }

    private static void dibujarBlancos(int blancos) {
        for (int cont = 1; cont <= blancos; cont++) {
            System.out.print("  ");
        }
    }

    private static void dibujarTriangulo(int aster, int linea) {
        for (int cont = aster; cont <= linea; cont++) {
            System.out.print(cont + " ");
        }
        for (int cont = linea - 1; cont >= aster; cont--) {
            System.out.print(cont + " ");
        }
    }
}
