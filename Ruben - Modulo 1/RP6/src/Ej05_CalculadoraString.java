import java.util.Scanner;

public class Ej05_CalculadoraString {
    public static void main(String[] args) {
        // Declaración de variables.
        String primerOperando, segundoOperando, operador;
        Scanner entrada = new Scanner(System.in);

        // Introducir datos.
        do {
            System.out.print("Operación = ");
            operador = entrada.next();

            if (!operador.equals("&")){
                System.out.print("Operando1 = ");
                primerOperando = entrada.next();

                System.out.print("Operando2 = ");
                segundoOperando = entrada.next();

                // Calcular resultado.
                switch (operador) {
                    case "+":
                        System.out.println("Resultado = " + (primerOperando + segundoOperando));
                        break;
                    case "-":
                        System.out.println("Resultado = " + Resta(primerOperando, segundoOperando));
                        break;
                    case "*":
                        System.out.println("Resultado = " + Interseccion(primerOperando, segundoOperando));
                        break;
                    default:
                        System.out.println("Operación no valida.");
                        break;
                }
            }
        } while (!operador.equals("&"));
        System.out.println("FIN");
    }

    // Método que resta dos strings.
    public static String Resta (String st1, String st2){
        String res = "";
        StringBuilder copia = new StringBuilder(st1);

        while (st1.length() != 0 && st2.length() != 0) {
            if (st2.indexOf(st1.charAt(0)) == -1)
                res += st1.charAt(0);
            st1 = copia.deleteCharAt(0).toString();
        }

        return res;
    }

    // Método que calcula la intersección de dos strings.
    public static String Interseccion (String st1, String st2){
        String res = "";
        StringBuilder copia = new StringBuilder(st1);

        while (st1.length() != 0 && st2.length() != 0) {
            if (st2.indexOf(st1.charAt(0)) != -1)
                res += st1.charAt(0);
            st1 = copia.deleteCharAt(0).toString();
        }

        return res;
    }
}
