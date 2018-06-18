/*
 * NOMBRE: Rubén Zúñiga García
 * POSICIÓN: 5.1
 */

import java.util.Scanner;

public class Ej1A {
    public static void main(String[] args) {
        int a, b;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Programa que te dice si dos valores son familia.");
        System.out.print("Introduce el primer valor: ");
        a = teclado.nextInt();

        System.out.print("Introduce el segundo valor: ");
        b = teclado.nextInt();

        System.out.println("Los valores " + a + " y " + b + (EsFamilia(a, b)?" son familia":" no son familia."));
        teclado.close();
    }

    private static int SumaDivisores(int n){
        int suma = 1;

        if (n < 2)
            return 0;

        for(int i = 2; i <= n/2; i++) {
            if (n % i == 0)
                suma += i;
        }

        return suma;
    }

    private static boolean EsFamilia(int a, int b){
        return SumaDivisores(a) == b && SumaDivisores(b) == a;
    }
}
