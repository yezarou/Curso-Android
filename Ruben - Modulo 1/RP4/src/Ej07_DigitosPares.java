import java.util.Scanner;

public class Ej07_DigitosPares {
    public static void main(String[] args) {
        // Declaración de variables.
        int valor, nPares = 0;
        Scanner entrada = new Scanner(System.in);

        // Introducción del valor.
        System.out.println("Programa que cuenta el número de digitos pares.");

        System.out.print("Introduce un número natural: ");
        valor = entrada.nextInt();

        // Error si no es natural.
        if (valor < 0 )
            System.out.println("El valor no es natural");

        // Contar dígitos.
        else {
            do {
                if ((valor % 10) % 2 == 0)
                    nPares++;
                valor /= 10;
            } while (valor > 1);

            System.out.println("El valor introducido tiene " + nPares + " digitos pares.");
            entrada.close();
        }
    }
}
