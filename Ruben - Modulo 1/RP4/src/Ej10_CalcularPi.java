import java.util.Scanner;

public class Ej10_CalcularPi {
    public static void main(String[] args) {
        // Declaración de variables.
        int n;
        double resultado = 4, dividendo = 2, divisor = 1;
        Scanner entrada = new Scanner(System.in);

        // Escribir el nivel de precisión.
        do {
            System.out.print("Escribe un numero natural para el nivel de precisión N: ");
            n = entrada.nextInt();
        } while (n < 0);

        // Calcular pi.
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                divisor += 2;
            else
                dividendo += 2;

            resultado *= (dividendo / divisor);
        }

        // Resultado de pi.
        System.out.println("El valor de pi es: " + resultado);
        entrada.close();
    }
}
