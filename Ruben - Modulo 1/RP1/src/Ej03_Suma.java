import java.util.Scanner;

public class Ej03_Suma {
    public static void main(String[] args) {
        // Declaración de variables.
        int primerValor, segundoValor, resultado;
        Scanner entrada = new Scanner(System.in);

        // Introducción de datos.
        System.out.println("Programa que suma dos valores.");
        System.out.print("Introduzca un primer valor: ");
        primerValor = entrada.nextInt();

        System.out.print("Introduzca un segundo valor: ");
        segundoValor = entrada.nextInt();

        // Resultado.
        resultado = primerValor + segundoValor;
        System.out.println("El resultado de la suma es: " + resultado);
        entrada.close();

        // Si ponemos los valores indicados en el enunciado, no funciona porque el número es demasiado grande para un int.
    }
}
