import java.util.Scanner;

public class Ej13_SumaPrimos {
    // Declaración de variables.
    public static void main(String[] args) {
        int divisor, valorIntroducido, suma = 0;
        boolean divisorEncontrado;
        Scanner entrada = new Scanner(System.in);

        // Introducción de datos.
        do {
            System.out.print("Introduce un valor natural (0 para terminar): ");
            valorIntroducido = entrada.nextInt();

            // Comprobar si es primo.
            if (valorIntroducido > 1) {
                divisorEncontrado = false;
                divisor = 2;
                while (divisor < valorIntroducido && !divisorEncontrado) {
                    if (valorIntroducido % divisor++ == 0)
                        divisorEncontrado = true;
                }
                if (!divisorEncontrado)
                    suma += valorIntroducido;
            }
        } while (valorIntroducido != 0);

        // Mostrar resultado.
        System.out.println("La suma de todos los números primos introducidos es: " + suma);

        entrada.close();
    }
}
