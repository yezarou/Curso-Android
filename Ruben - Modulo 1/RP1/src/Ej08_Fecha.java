import java.util.Scanner;

public class Ej08_Fecha {

    // Declaración de constantes.
    static  final int SEMANA_DIA = 7;
    static  final int DIA_HORA = 24;
    static  final int HORA_MINUTO = 60;
    static  final int MINUTO_SEGUNDO = 60;

    public static void main(String[] args) {
        // Declaración de variables.
        int segundos, minutos = 0, horas = 0, dias = 0, semanas = 0;
        Scanner entrada = new Scanner(System.in);

        // Introducción de segundos.
        System.out.println("Formatear una fecha.");
        System.out.print("Introduce el número de segundos: ");
        segundos = entrada.nextInt();

        // Calcular las variables.
        while (segundos >= MINUTO_SEGUNDO){
            segundos -= MINUTO_SEGUNDO;
            minutos++;

            while (minutos >= HORA_MINUTO){
                minutos -= HORA_MINUTO;
                horas++;

                while (horas >= DIA_HORA) {
                    horas -= DIA_HORA;
                    dias++;

                    while (dias >= SEMANA_DIA) {
                        dias -= SEMANA_DIA;
                        semanas++;
                    }
                }
            }
        }

        // Mostrar fecha.
        System.out.println(semanas + " semanas, " + dias + " dias, "
                + horas + " horas, " + minutos + " minutos, " + segundos + " segundos.");
        entrada.close();
    }
}
