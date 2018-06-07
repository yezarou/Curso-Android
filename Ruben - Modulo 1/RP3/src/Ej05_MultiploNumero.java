import java.util.Scanner;

public class Ej05_MultiploNumero {
    public static void main(String[] args) {
        // Declaración de variables.
        boolean divisorEncontrado = false;
        int valor;
        Scanner entrada = new Scanner(System.in);

        // Introducir valor.
        System.out.println("Programa que determina si el número introducido es múltiplo de 3, 4 o 5");
        System.out.print("Introduce un valor: ");
        valor = entrada.nextInt();

        // Comprobar múltiplos.
        for (int i = 3; i <= 5; i++)
            if (valor % i == 0) {
                divisorEncontrado = true;
                System.out.println("El valor " + valor + " es múltiplo de " + i);
            }

        if (!divisorEncontrado)
            System.out.println("No es múltiplo de 3, 4 o 5.");
        entrada.close();
    }
}
