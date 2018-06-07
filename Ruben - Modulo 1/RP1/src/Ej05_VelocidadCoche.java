import java.util.Scanner;

public class Ej05_VelocidadCoche {
    public static void main(String[] args) {
        // Declaración de variables
        double velocidad, tiempo, distancia;
        Scanner entrada = new Scanner(System.in);

        // Entrada de datos.
        System.out.println("Programa que dado una velocidad y un tiempo, calcula la distancia recorrida.");
        System.out.print("Introduce la velocidad del coche (kmh): ");
        velocidad = entrada.nextDouble();

        System.out.print("Introduce el tiempo que tarda (horas): ");
        tiempo = entrada.nextDouble();

        // Resultado.
        distancia = velocidad * tiempo;
        System.out.println("El coche ha recorrido " + distancia + " km");
        entrada.close();
    }
}
