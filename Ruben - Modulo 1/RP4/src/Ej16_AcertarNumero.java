import java.util.Scanner;

public class Ej16_AcertarNumero {
    public static void main(String[] args) {
        // Declaración de variables.
        int limiteSuperior, limiteInferior, valorMaquina, respuesta;
        boolean correcto = false;
        Scanner entrada = new Scanner(System.in);

        // Introducir límites.
        System.out.print("Introduce el limite superior: ");
        limiteSuperior = entrada.nextInt();
        do {
            System.out.print("Introduce el limite inferior: ");
            limiteInferior = entrada.nextInt();
        } while (limiteInferior > limiteSuperior);

        // Generar numero aleatorio.
        do {
            valorMaquina = (int) (Math.random() * (limiteSuperior - limiteInferior)) + limiteInferior + 1;
            if (limiteInferior == limiteSuperior) valorMaquina = limiteInferior;
            System.out.print("¿Es " + valorMaquina + " el valor?: ");

            // Respuesta.
            do {
                System.out.println("Introduce la respuesta (0 correcto, -1 está por debajo, 1 está por encima): ");
                respuesta = entrada.nextInt();
                switch (respuesta) {
                    case -1:
                        limiteSuperior = valorMaquina - 1;
                        break;
                    case 1:
                        limiteInferior = valorMaquina + 1;
                        break;
                    case 0:
                        correcto = true;
                        break;
                }
            } while (respuesta != 0 && respuesta != -1 && respuesta != 1);
        } while (!correcto);

        entrada.close();
    }
}
