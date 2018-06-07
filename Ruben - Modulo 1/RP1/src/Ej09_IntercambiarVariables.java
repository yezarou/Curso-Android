import java.util.Scanner;

public class Ej09_IntercambiarVariables {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int a = 6, b = 14;
        int auxiliar;

        System.out.println("a vale " + a + " y b vale "+ b);

        // ¿Qué hacen estas tres sentencias?
        /*
        auxiliar = a;
        a = b;
        b = auxiliar;
        */

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a vale " + a + " y b vale "+ b);

        teclado.close();
    }
}

// Lo que hace este código es intercambiar el valor de a por b.
// El método comentado hace uso de una variable auxiliar, mientras
// que la otra forma solo requiere de una simple operación aritmética.