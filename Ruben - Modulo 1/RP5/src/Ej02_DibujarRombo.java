import java.util.Scanner;

public class Ej02_DibujarRombo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int n;
        System.out.print("Introduzca n: ");
        n = teclado.nextInt();
        for (int linea = 1; linea <= n; linea++){
            dibujarLinea(linea,n);
        }
        for (int linea = n - 1; linea >= 1; linea--){
            dibujarLinea(linea,n);
        }
        teclado.close();
    }

    private static void dibujarLinea(int linea,
                                     int n) {
        dibujarBlancos(n-linea);
        dibujarAsteriscos(linea);
        System.out.println();
    }

    private static void dibujarBlancos(int blancos) {
        for (int cont = 1; cont <= blancos; cont++) {
            System.out.print(" ");
        }
    }

    private static void dibujarAsteriscos(int aster) {
        for (int cont = 1; cont <= aster; cont++) {
            System.out.print("* ");
        }
    }
}
