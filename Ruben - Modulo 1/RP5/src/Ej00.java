import java.util.Scanner;

public class Ej00 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int m,n,comb;
        do {
            System.out.print("Introduzca m y n (m >= n): ");
            m = teclado.nextInt();
            n = teclado.nextInt();
        } while ((m < n) || (m < 0) || (n < 0));
        comb = combinatorio(m,n);
        System.out.println("El numero combinatorio de "
                + m + " sobre " + n + " es: " + comb);
        teclado.close();
    }

    private static int combinatorio(int m, int n){
        int res;
        if (m-n > n)
            res = producto(m - n + 1, m) /
                    (factorial(n));
        else
            res = producto(m, n + 1) /
                    factorial(m - n);

        return res;
    }

    private static int factorial(int x) {
        int fact = 1;
        for (int i = 2; i <= x; i++) {
            fact = fact * i;
        }
        return fact;
    }

    private static int producto(int m, int n) {
        int prod = 1;
        for (int i = n; i <= m; i++) {
            prod = prod * i;
        }
        return prod;
    }
}
