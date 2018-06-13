import java.util.Scanner;

public class Ej03_InicialesTexto {
    public static void main(String[] args) {
        // Declaración de variables.
        String textoConIniciales = "", primeraPalabra;
        Scanner teclado = new Scanner(System.in);

        // Introducir la primera palabra.
        System.out.println("Introduce un texto: ");
        primeraPalabra = teclado.next();

        // Mostrar el texto.
        System.out.println("Listado: \n" + PalabrasEmpezadasPorString(primeraPalabra, teclado));
        teclado.close();
    }

    // Método que devuelve un string con las palabras empezadas por uno de los caracteres de un string.
    private static String PalabrasEmpezadasPorString(String primeraPalabra, Scanner teclado){
        String entrada, textoConIniciales = "";

        do {
            entrada = teclado.next();

            for (int i = 0; i < primeraPalabra.length(); i++)
                if (entrada.charAt(0) == primeraPalabra.charAt(i)){
                    textoConIniciales += (entrada + "\n");
                }
        } while (!entrada.equals("FIN"));

        return textoConIniciales;
    }
}
