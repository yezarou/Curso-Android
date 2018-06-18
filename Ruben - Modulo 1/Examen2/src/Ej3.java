/*
 * NOMBRE: Rubén Zúñiga García
 * POSICIÓN: 5.1
 */

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        String patron, entrada, salida = "";
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduzca el patrón: ");
        patron = teclado.next().toUpperCase();

        System.out.println("\nIntroduzca el texto (FIN para terminar): ");
        do{
            entrada = teclado.next();
            if (CumplePatron(patron, entrada))
                salida += (entrada + " ");
        } while (!entrada.equals("FIN"));

        System.out.println("\nSALIDA:\n" + salida);
    }

    private static boolean CumplePatron(String a, String b) {
        char[] patron = a.toUpperCase().toCharArray();
        char[] palabra = b.toUpperCase().toCharArray();
        int contador = 0, letrasCorrectas = 0;

        while (contador < palabra.length && letrasCorrectas < patron.length)
            if (patron[letrasCorrectas] == palabra[contador++])
                letrasCorrectas++;

        return letrasCorrectas == patron.length;
    }
}
