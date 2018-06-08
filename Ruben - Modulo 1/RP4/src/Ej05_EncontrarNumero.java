import java.util.Scanner;

public class Ej05_EncontrarNumero {

    public static void main(String[] args) {
        // Declaración de variables.
        boolean nEncontrado = false;
        int numeroABuscar, nIntroducido;
        Scanner teclado = new Scanner(System.in);

        // Introducción del número a buscar.
        System.out.println("Buscar número en una secuencia (Introducir 0 para acabar la secuencia)");

        do {
            System.out.print("Introduce el número que quieres buscar (diferente de 0): ");
            numeroABuscar = teclado.nextInt();
        } while (numeroABuscar == 0);

        // Introducir secuencia y detectar si el número es el que hay que buscar.
        do {
            System.out.print("Introduce un número a la secuencia: ");
            if (numeroABuscar == (nIntroducido = teclado.nextInt()))
                nEncontrado = true;
        } while (nIntroducido != 0 && !nEncontrado);

        // Resultado.
        if (nEncontrado)
            System.out.println("Número encontrado.");
        else
            System.out.println("Número no encontrado.");
        teclado.close();
    }
}
