import java.util.Locale;
import java.util.Scanner;

public class Ej06_NumeroReal {
    public static void main(String[] args) {
        // Declaración de variables.
        double valor,decimal;
        int entero;
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);

        // Información del programa.
        System.out.println("Este programa separa la parte decimal de la entera de un double.");
        System.out.print("Introduce el número con decimales: ");
        valor = entrada.nextDouble();

        // Calcular resultado.
        entero = (int) valor;
        decimal = valor - entero;

        // Mostrar resultado.
        System.out.println("Parte decimal: " + decimal);
        System.out.println("Parte entera: " + entero);
        entrada.close();
    }
}
