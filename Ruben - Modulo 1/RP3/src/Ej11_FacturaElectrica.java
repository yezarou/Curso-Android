import java.util.Scanner;

public class Ej11_FacturaElectrica {

    // Declaración de constantes.
    static final double GASTO_FIJO = 1;
    static final double GASTO_PRIMEROS_100 = 0.5;
    static final double GASTO_SIGUIENTES_150 = 0.35;
    static final double GASTO_RESTO = 0.25;

    public static void main(String[] args) {
        // Declaración de variables.
        double primerValor, segundoValor, consumo, recibo;
        Scanner entrada = new Scanner(System.in);

        // Información y entrada de datos.
        System.out.println("Calcular el recibo del gasto eléctrico.");
        System.out.print("Pon el primer valor del contador de la luz: ");
        primerValor = entrada.nextDouble();

        System.out.print("Pon el segundo valor del contador de la luz: ");
        segundoValor = entrada.nextDouble();

        // Calcular recibo.
        consumo = primerValor - segundoValor;
        recibo = GASTO_FIJO;

        if (consumo > 0) {
            recibo += GASTO_PRIMEROS_100;
            consumo -= 100;

            if (consumo > 0) {
                recibo += GASTO_SIGUIENTES_150;
                consumo -= 150;

                if (consumo > 0)
                    recibo += (consumo * GASTO_RESTO);
            }
        }

        // Mostrar recibo.
        System.out.println("El importe total es de: " + recibo + " euros.");
        entrada.close();
    }
}
