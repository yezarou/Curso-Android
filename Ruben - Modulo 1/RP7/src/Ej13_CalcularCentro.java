import java.util.Arrays;
import java.util.Scanner;

public class Ej13_CalcularCentro {
    public static void main(String[] args) {
        // Declarar variables.
        Scanner teclado = new Scanner(System.in);
        int[] array = Leer(teclado);
        int centro = CalcularCentroVector(array);

        // Mostrar resultado.
        System.out.println(centro==-1?"El vector no tiene centro.":("El centro del vector es: " + centro));
        teclado.close();
    }

    // Método que devuelve el centro de un vector. Devuelve -1 si no tiene.
    private static int CalcularCentroVector(int[] array){
        int centro = -1;
        int sumatorioIzquierda;
        int sumatorioDerecha;


        for (int i = 1; i < array.length - 1; i++) {
            sumatorioDerecha = 0;
            sumatorioIzquierda = 0;

            for (int j = 0; j < array.length; j++){
                if (j < i)
                    sumatorioIzquierda += ((i-j)*array[j]);
                else if (j > i)
                    sumatorioDerecha += ((j-i)*array[j]);
            }

            if (sumatorioDerecha == sumatorioIzquierda)
                centro = i;
        }

        return centro;
    }

    // Método que lee del teclado una serie de valores y devuelve un array.
    private static int[] Leer(Scanner teclado){
        int[] array;

        System.out.println("Introduce el número máximo de valores del vector: ");
        array = new int[teclado.nextInt()];

        System.out.println("Introduce " + array.length + " valores para el vector.");

        for (int i = 0; i < array.length; i++)
            array[i] = teclado.nextInt();

        return array;
    }
}
