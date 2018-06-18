/*
 * NOMBRE: Rubén Zúñiga García
 * POSICIÓN: 5.1
 */

import java.util.Scanner;

public class Ej1B {
    public static void main(String[] args) {
        int a, b;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Programa que te dice si las familias entre dos intervalo.");
        System.out.print("Escriba los dos valores del intervalo separados por un espacio: ");
        a = teclado.nextInt();
        b = teclado.nextInt();

        System.out.println("\nLas familias que hay entre estos dos valores son: ");
        if (a < b)
            FamiliaEnIntervalo(a, b);
        else
            FamiliaEnIntervalo(b, a);
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
        return SumaDivisores(a) == b && SumaDivisores(b) == a && a != b;
    }

    private static void FamiliaEnIntervalo(int a, int b){
        while (a < b){
            if (SumaDivisores(a) >= a && SumaDivisores(a) <= b)
                if (EsFamilia(a, SumaDivisores(a)))
                    System.out.println(a + " y " + SumaDivisores(a));
            a++;
        }
    }
}
