import java.util.Scanner;

public class Ej12_InformacionSecuencia {
    public static void main(String[] args) {
        // Declaración de variables.
        int valor, largoSecuencia, mayor, menor, suma;
        Scanner entrada = new Scanner(System.in);

        // Introducción del primer dato.
        System.out.println("Obtener máximo, mínimo y media de una secuencia.");

        do {
            System.out.print("Introduce un valor mayor o igual que 0: ");
            largoSecuencia = entrada.nextInt();
        } while (largoSecuencia <= 0);

        // Inicializar variables.
        mayor = largoSecuencia;
        menor = largoSecuencia;
        suma = largoSecuencia;

        // Introducción de los siguientes valores de la secuencia.
        for (int i = 1; i < largoSecuencia; i++) {
            System.out.print("Introduce el siguiente valor de la secuencia (0 para terminar): ");
            valor = entrada.nextInt();
            if (valor > mayor)
                mayor = valor;
            if (valor < menor)
                menor = valor;

            suma += valor;
        }

        // Mostrar resultado.
        System.out.println("El mayor número introducido ha sido: " + mayor);
        System.out.println("El menor número introducido ha sido: " + menor);
        System.out.println("La media de la secuencia es de: " + (suma/largoSecuencia));

        entrada.close();
    }
}
