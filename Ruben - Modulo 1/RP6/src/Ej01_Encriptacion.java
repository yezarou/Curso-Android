import java.util.Scanner;

public class Ej01_Encriptacion {
    public static void main(String[] args) {
        // Declaración de variables.
        String texto;
        Scanner teclado = new Scanner(System.in);

        // Introducción de datos.
        System.out.println("Programa que encripta un texto, sumando en 1 su ASCII.");
        System.out.print("Introduzca un texto: ");
        texto = teclado.nextLine();

        // Resultado.
        System.out.printf("El texto sin encriptar es: %s\n", texto);
        System.out.printf("El texto encriptado es: %s\n", Encriptar(texto));
        teclado.close();
    }

    // Método que encripta.
    private static String Encriptar(String txt){
        String encriptado = "";

        for (int i = 0; i< txt.length(); i++){
            encriptado += (char)(((int)txt.charAt(i)) + 1);
        }

        return encriptado;
    }
}
