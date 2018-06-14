import java.util.Arrays;
import java.util.Scanner;

public class Ej08_Erastotenes {
    public static void main(String[] args) {
        // Declaración de variables.
        int n;
        Scanner teclado = new Scanner(System.in);

        // Mostrar resultado.
        System.out.print("Introduce un valor N: ");
        System.out.println(MostrarArray(Erastotenes(teclado.nextInt())));
        teclado.close();
    }

    // Método que devuelve un array con los números primos.
    private static int[] Erastotenes (int n){
        int[] numerosNaturales = new int[n];
        int[] erastotenes = new int[0];

        for (int i = 1; i <= numerosNaturales.length; i++){
            numerosNaturales[i - 1] = i;
        }

        for (int tmp : numerosNaturales){
            if (tmp == 2 || tmp == 2 || tmp == 3 || tmp == 5 || tmp == 7 ||
                    (tmp % 2 != 0 && tmp % 3 != 0 && tmp % 5 != 0 && tmp % 7 != 0)){
                erastotenes = Arrays.copyOf(erastotenes, erastotenes.length + 1);
                erastotenes[erastotenes.length - 1] = tmp;
            }
        }

        return erastotenes;
    }

    // Método que muestra un array.
    private static String MostrarArray (int[] array){
        String txt = "";

        for (int tmp: array)
            txt += (tmp + " ");

        return txt;
    }
}
