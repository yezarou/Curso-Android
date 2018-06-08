import java.util.Scanner;

public class Ej15_BuscarNumero {

    // Declaración de constante.
    static final int NUMERO_BUSCADO = 12;

    public static void main(String[] args) {
        // Declaración de variables.
        int contador = 0, primeraOcurrencia = 0, ultimaOcurrencia = 0, valor;
        Scanner entrada = new Scanner(System.in);

        // Introducir dato y comprobar ocurrencia.
        do {
            System.out.print("Introduce el siguiente valor (0 para terminar): ");
            valor = entrada.nextInt();
            contador++;

            if (NUMERO_BUSCADO == valor) {
                if (primeraOcurrencia == 0)
                    primeraOcurrencia = contador;
                ultimaOcurrencia = contador;
            }
        } while (valor != 0);

        // Mostrar resultado.
        System.out.println("El número " + NUMERO_BUSCADO + " tiene su primera ocurrencia en "
                + primeraOcurrencia + " y su última ocurrencia en " + ultimaOcurrencia );
        entrada.close();
    }
}
