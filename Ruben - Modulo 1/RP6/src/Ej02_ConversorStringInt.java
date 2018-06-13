import java.util.Scanner;

public class Ej02_ConversorStringInt {
    public static void main(String[] args) {
        // Declaración de variables.
        String entrada;
        Scanner teclado = new Scanner(System.in);

        // Introducir dato.
        System.out.println("Transformar de string a int.");
        System.out.print("Entrada: ");
        entrada = teclado.next();

        // Mostrar resultado.
        System.out.println("Salida: " + IntParse(entrada));
        teclado.close();
    }

    // Pasar de String a Integer.
    private static int IntParse(String text){
        int n = 0;

        for (int i = 0; i < text.length(); i++){
            n = (n * 10) + (text.charAt(i) - '0');
        }

        return n;
    }
}
