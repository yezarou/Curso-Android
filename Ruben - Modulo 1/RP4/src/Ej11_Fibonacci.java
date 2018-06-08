import java.util.Scanner;

public class Ej11_Fibonacci {
    public static void main(String[] args) {
        // Declaración de variables.
        int primerValor = 0, segundoValor = 1, n;
        Scanner entrada = new Scanner(System.in);

        // Introducir nivel.
        System.out.println("Calcular número de fibonacci.");
        do {
            System.out.print("Escribe el valor de N: ");
            n = entrada.nextInt();
        } while (n <= 0);

        // Calcular el número de Fibonacci.
        for (int i = 0; i < n; i++){
            int suma = 0;
            suma = primerValor + segundoValor;
            primerValor = segundoValor;
            segundoValor = suma;
        }

        // Mostrar el resultado.
        System.out.println("El valor " + n + " de Fibonacci es: " + primerValor);
        entrada.close();
    }
}
