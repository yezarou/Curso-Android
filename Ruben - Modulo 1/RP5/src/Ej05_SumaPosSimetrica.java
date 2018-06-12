import java.util.Scanner;

public class Ej05_SumaPosSimetrica {
    public static void main(String[] args) {
        // Declaración de variables.
        int valor;
        Scanner teclado = new Scanner(System.in);

        // Información del programa e introducción de datos.
        System.out.println("Programa que escribe la suma de los extremos de un valor introducido.");
        System.out.println("Escribe un valor distinto de 0: ");
        do {
            valor = teclado.nextInt();
        } while (valor == 0);

        // Mostrar el resultado.
        System.out.println("\nEl resultado es: ");
        SumarExtremos(valor);
        teclado.close();
    }

    // Método que devuelve el número de dígitos que tiene un número.
    private static int Digitos(int v){
        int digito = 0;

        while (v != 0){
            digito++;
            v /= 10;
        }

        return digito;
    }

    // Método que selecciona un dígito en una posición determinada.
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

    // Método que devuelve una linea con la suma de los extremos de un valor.
    private static void SumarExtremos(int n){
        int primerValor = 1, ultimoValor = Digitos(n), primerDigito, ultimoDigito;

        while (primerValor <= ultimoValor){
            primerDigito = SeleccionarDigito(n, ultimoValor);
            ultimoDigito = SeleccionarDigito(n, primerValor);

            if (primerValor++ == ultimoValor--)
                System.out.print(primerDigito + " ");
            else
                System.out.print(primerDigito + " + " + ultimoDigito + " = " + (primerDigito + ultimoDigito));

            if (primerValor <= ultimoValor)
                System.out.print(", ");
        }
    }
}
