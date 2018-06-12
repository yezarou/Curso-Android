import java.util.Scanner;

public class Ej04_SeleccionarDigito {
    public static void main(String[] args) {
        // Declaración de variables.
        int valor, pos;
        Scanner teclado = new Scanner(System.in);

        // Introducción de datos.
        System.out.print("Introduce un número (Mayor que 0): ");
        do {
            valor = teclado.nextInt();
        } while (valor < 1);

        System.out.print("Introduce la posición del dígito (Mayor que 0): ");
        do {
            pos = teclado.nextInt();
        } while (valor < 1);

        // Mostrar el resultado.
        System.out.println("El digito seleccionado es: " + SeleccionarDigito(valor, pos));
    }

    // Método que selecciona el dígito en una posicion determinada.
    // Si la posición es mayor al número de dígitos, devuelve -1.
    private static int SeleccionarDigito(int v, int pos){
        int digito = 0;

        while (pos-- != 0){
            if (v != 0) {
                digito = v % 10;
                v /= 10;
            }
            else
                digito = -1;
        }

        return digito;
    }
}
