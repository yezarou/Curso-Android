import java.util.Scanner;

public class Ej03_ConjeturaPalindromo {
    public static void main(String[] args) {
        // Declaración de variables.
        int valor, iteraciones;
        Scanner teclado = new Scanner(System.in);

        // Introducir datos.
        System.out.println("Programa para comprobar la conjetura del palíndromo.");
        System.out.print("Introduce un número natural: ");
        do {
            valor = teclado.nextInt();
        } while (valor < 0);

        System.out.print("Introduce el número de iteraciones (x>0): ");
        do {
            iteraciones = teclado.nextInt();
        } while (iteraciones <= 0);

        // Calcular la conjetura.
        valor = Conjetura(valor, iteraciones);

        // Mostrar si se cumple o no.
        if (valor != -1)
            System.out.println("SI se cumple la Conjetura del Palíndromo. El Palíndromo es: " + valor);
        else
            System.out.println("NO se cumple la Conjetura del Palíndromo tras hacer " + iteraciones + " iteraciones");

        teclado.close();
    }

    // Método que calcula el reverso de un número.
    private static int Reverso(int n){
        int reverso = 0;

        while (n != 0){
            reverso = (reverso * 10) + (n%10);
            n /= 10;
        }
        return reverso;
    }

    // Método que devuelve true cuando es Palíndromo.
    private static boolean EsPalindromo(int n){
        return n == Reverso(n);
    }

    // Método que devuelve el valor de la conjetura.
    // Si no se encuentra un palíndromo en X iteraciones, devuelve -1.
    private static int Conjetura(int n, int iteraciones){
        while (iteraciones-- != 0 && !EsPalindromo(n))
            n = n + Reverso(n);

        if (EsPalindromo(n))
            return n;
        else
            return -1;
    }
}
