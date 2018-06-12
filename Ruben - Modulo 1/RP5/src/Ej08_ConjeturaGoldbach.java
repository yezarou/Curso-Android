import java.util.Scanner;

public class Ej08_ConjeturaGoldbach {
    public static void main(String[] args) {
        // Declaración de variables.
        int limiteInferior, limiteSuperior;
        Scanner teclado = new Scanner(System.in);

        // Introducción de datos.
        do {
            System.out.print("Introduzca el límite inferior: ");
            limiteInferior = teclado.nextInt();
            System.out.print("Introduzca el límite superior: ");
            limiteSuperior = teclado.nextInt();
        } while (limiteInferior <= 2 && limiteInferior > limiteSuperior);

        // Mostrar resultado
        System.out.println(ConjeturaGoldbach(limiteInferior, limiteSuperior)?"Se cumple":"No se cumple");
        teclado.close();
    }

    // Método que pregunta si un número es par.
    private static boolean EsPar (int n) {
        return n % 2 == 0;
    }

    // Método que pregunta si un número es primo.
    private static boolean EsPrimo(int n){
        boolean esPrimo = true;

        if (n < 2)
            esPrimo = false;
        else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0)
                    esPrimo = false;
            }
        }

        return esPrimo;
    }

    // Método que devuelve el siguiente número primo.
    private static int SiguientePrimo(int n){
        n++;

        while (!EsPrimo(n))
            n++;

        return n;
    }

    // Método que devuelve true si se cumple la Conjetura de Goldbach
    private static boolean TieneSumandosPrimos(int n){
        int primerSumando = 1, segundoSumando;

        do {
            primerSumando = SiguientePrimo(primerSumando);
            segundoSumando = n - primerSumando;
        } while (!EsPrimo(segundoSumando) && primerSumando < n);

        return EsPrimo(segundoSumando);
    }

    // Método que muestra si se cumple la conjetura entre dos limites.
    private static boolean ConjeturaGoldbach (int limiteInferior, int limiteSuperior){
        boolean res = true;
        int contador;

        if (EsPar(limiteInferior))
            contador = limiteInferior;
        else
            contador = limiteInferior + 1;

        while (contador <= limiteSuperior && res){
            if (!TieneSumandosPrimos(contador))
                res = false;

            contador += 2;
        }

        return res;
    }
}
