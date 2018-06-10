import java.util.Scanner;

public class Ej14_SegundoMayor {
    public static void main(String[] args) {
        int valor, primerMayor = 0, segundoMayor = 0, nNumeros = 0;
        Scanner entrada = new Scanner(System.in);

        // Información.
        System.out.println("Programa que calcula cual es el segundo número mayor de una secuencia.");

        // Introducir valores.
        do {
            System.out.print("Introduce un valor natural (0 para terminar): ");
            valor = entrada.nextInt();

            // Detectar si es el segundo mayor.
            if (valor > 0) {
                if (valor > primerMayor) {
                    segundoMayor = primerMayor;
                    primerMayor = valor;
                } else if (valor < primerMayor && valor > segundoMayor)
                    segundoMayor = valor;

                nNumeros++;
            }
        } while (valor != 0);

        // Mostrar resultado.
        if (nNumeros < 2)
            System.out.println("Se han introducido menos de 2 números en la secuencia.");
        else if (segundoMayor == 0)
            System.out.println("Todos los números introducidos eran iguales.");
        else
            System.out.println("El segundo mayor de esta secuencia es: " + segundoMayor);

        entrada.close();
    }
}
