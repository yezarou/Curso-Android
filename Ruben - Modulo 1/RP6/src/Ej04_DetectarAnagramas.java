import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Ej04_DetectarAnagramas {
    public static void main(String[] args) {
        // Declaración de variables.
        String palabraInicial, entrada, texto = "";
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce la palabra inicial: ");
        palabraInicial = teclado.next();

        System.out.println("Introduce una serie de anagramas: ");
        do {
            entrada = teclado.next();
            if (Anagrama(palabraInicial, entrada)){
                texto += (entrada + "\n");
            }
        } while (!entrada.equals("FIN"));

        System.out.println("Anagramas: \n" + texto);
        teclado.close();
    }

    // Palabra que detecta si una palabra una es anagrama.
    private static boolean Anagrama (String primeraPalabra, String palabra) {
        StringBuilder copia = new StringBuilder(palabra);

        if (primeraPalabra.length() == palabra.length())
            for (int i = 0; i < primeraPalabra.length(); i++)
                if (palabra.indexOf(primeraPalabra.charAt(i)) != -1)
                    copia.deleteCharAt(copia.toString().indexOf(primeraPalabra.charAt(i)));

        palabra = copia.toString();

        return palabra.equals("");
    }
}
