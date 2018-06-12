import java.util.Scanner;

public class Ej09_DibujarTriangulo2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n;
        System.out.print("Introduzca n: ");
        do {
            n = teclado.nextInt();
        } while (n <= 0);
        for (int linea = 1; linea <= n; linea++){
            dibujarLinea(linea,n);
        }
        teclado.close();
    }

    private static void dibujarLinea(int linea,
                                     int n) {
        dibujarBlancos(n-linea);
        dibujarTriangulo(linea);
        System.out.println();
    }

    private static void dibujarBlancos(int blancos) {
        for (int cont = 1; cont <= blancos; cont++) {
            System.out.print("  ");
        }
    }

    private static void dibujarTriangulo(int aster) {
        for (int cont = aster; cont <= aster+aster - 1; cont++) {
            System.out.print(cont%10 + " ");
        }
        for (int cont = aster + aster - 2; cont >= aster; cont--) {
            System.out.print(cont%10 + " ");
        }
    }
}
