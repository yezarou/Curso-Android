import java.util.Scanner;

public class Ej06_NPrimerosPrimos {
    public static void main(String[] args) {
        // Declaración de variables.
        int n;
        Scanner teclado = new Scanner(System.in);

        // Introducir dato.
        System.out.println("Programa que muestra los n primeros números primos.");
        System.out.print("Escribe el valor de n: ");
        do {
            n = teclado.nextInt();
        } while (n <= 0);

        // Mostrar primos.
        PrimerosNPrimos(n);

        teclado.close();
    }

    // Método que pregunta si un número es primo.
    private static boolean EsPrimo(int n){
        boolean esPrimo = true;

        if (n < 2)
            esPrimo = false;
        else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0)
                    esPrimo = false;
            }
        }

        return esPrimo;
    }

    // Método que muestra una linea de números primos.
    private static void PrimerosNPrimos(int n){
        int valor = 1;

        System.out.print("Los " + n + " primeros primos son: ");
        while (n != 0){
            if (EsPrimo(valor)) {
                System.out.print(valor);
                n--;

                if (n != 0)
                    System.out.print(", ");
            }
            valor++;
        }
    }
}
