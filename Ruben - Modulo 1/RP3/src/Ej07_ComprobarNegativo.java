import java.util.Scanner;

public class Ej07_ComprobarNegativo {
    public static void main(String[] args) {
        // Declaración de variables.
        int valor;
        Scanner entrada = new Scanner(System.in);

        // Introducir un valor.
        System.out.println("Programa que determina si un número es positivo o negativo.");
        System.out.print("Escribe un valor: ");
        valor = entrada.nextInt();

        // Comprobar valor.
        if (valor >= 0)
            System.out.println("El valor es positivo");
        else
            System.out.println("El valor es negativo");
        entrada.close();
    }
}
