import java.util.Scanner;

public class Ej07_DescomponerNumero {
    public static void main(String[] args) {
        // Declaración de variables.
        int valor;
        Scanner teclado = new Scanner(System.in);

        // Introducción del valor.
        System.out.print("Introduce un número (>1): ");
        do {
            valor = teclado.nextInt();
        } while (valor <= 1);

        // Mostrar divisores.
        DivisoresPrimosNumeros(valor);
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

    // Método que devuelve el siguiente número primo.
    private static int SiguientePrimo(int n){
        n++;

        while (!EsPrimo(n))
            n++;

        return n;
    }

    // Método que muestra los divisores primos de un número.
    private static void DivisoresPrimosNumeros(int n){
        int divisor = 2;

        System.out.print("Los primos divisores de 40 son: ");
        while (n != 1){
            if (n % divisor == 0) {
                System.out.print(divisor + " ");
                n /= divisor;
            }
            else
                divisor = SiguientePrimo(divisor);
        }
    }
}
