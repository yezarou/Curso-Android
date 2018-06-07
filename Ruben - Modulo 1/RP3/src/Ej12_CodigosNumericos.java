import java.util.Scanner;

public class Ej12_CodigosNumericos {
    public static void main(String[] args) {
        // Declaración de variables.
        int codigo, provincia, operacion, digito;
        Scanner entrada = new Scanner(System.in);

        // Introducción de datos.
        System.out.println("Manejador de códigos numéricos.");
        System.out.print("Introduce el código: ");
        codigo = entrada.nextInt();

        // Comprobar código.
        if (codigo < 1000 || codigo > 9999)
            System.out.println("ERROR: CODIGO INVALIDO.");
        else
        {
            provincia = codigo/1000;
            codigo -= provincia * 1000;

            operacion = codigo/10;
            codigo -= operacion * 10;

            digito = codigo;

            System.out.println("PROVINCIA: " + provincia);
            System.out.println("NUMERO DE OPERACION: " + operacion);
            System.out.println("DIGITO DE CONTROL: " + digito);
        }

        entrada.close();
    }
}
