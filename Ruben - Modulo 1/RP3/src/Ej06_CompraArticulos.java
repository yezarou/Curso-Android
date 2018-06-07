import java.util.Scanner;

public class Ej06_CompraArticulos {

    // Declaración de constantes.
    static final double PRECIO_UNO = 100;
    static final double PRECIO_DOS = 95;
    static final double PRECIO_TRES = 90;
    static final double PRECIO_CUATRO = 85;

    public static void main(String[] args) {
        // Declaración de variables.
        int cantidadProductos;
        Scanner entrada = new Scanner(System.in);

        // Introducir dato
        System.out.println("Comprar una serie de productos.");
        System.out.print("Selecciona una cantidad: ");
        cantidadProductos = entrada.nextInt();

        // Resultado
        if (cantidadProductos <= 0)
            System.out.println("No has comprado ningún producto.");
        else if (cantidadProductos == 1)
            System.out.println("El precio es de " + PRECIO_UNO);
        else if (cantidadProductos == 2)
            System.out.println("El precio es de " + PRECIO_DOS * cantidadProductos);
        else if (cantidadProductos == 3)
            System.out.println("El precio es de " + PRECIO_TRES * cantidadProductos);
        else
            System.out.println("El precio es de " + PRECIO_CUATRO * cantidadProductos);
        entrada.close();
    }
}
