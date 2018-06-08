import java.util.Scanner;

public class Ej08_PrecioMedioCoche {
    public static void main(String[] args) {
        // Declaración de variables.
        int nCoches, precio, suma = 0;
        Scanner entrada = new Scanner(System.in);

        // Introducción de numeros de coches.
        System.out.println("Calcular la media de una serie de coches.");
        System.out.print("Introduzca número de modelos de coches: ");
        nCoches = entrada.nextInt();

        // Introducción de precios.
        for (int i = 1; i <= nCoches; i++) {
            System.out.print("Precio modelo " + i + ": ");
            precio = entrada.nextInt();
            suma += precio;
        }

        // Calcular media y mostrarlo.
        precio = suma / 4;
        System.out.println("El valor medio de los " + nCoches + " modelos de coche asciende a: " + precio + " €");
        entrada.close();
    }
}
