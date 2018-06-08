import java.util.Scanner;

public class Ej06_SumaRestos {

    static final int DIVISOR = 8;

    public static void main(String[] args) {
        // Declaración de variables.
        int suma = 0, nIntroducido;
        Scanner teclado = new Scanner(System.in);

        // Introducir secuencia y detectar sumar el resto de 8.
        do {
            System.out.print("Introduce números para la secuencia (0 para acabar): ");
            nIntroducido = teclado.nextInt();
            suma += (nIntroducido % DIVISOR);
        } while (nIntroducido != 0);

        // Resultado.
        System.out.println("El resultado de la suma del resto entre " + DIVISOR + " de la secuencia es: " + suma);
        teclado.close();
    }
}
