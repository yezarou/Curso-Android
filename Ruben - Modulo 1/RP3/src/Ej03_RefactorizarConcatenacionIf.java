import java.util.Scanner;

public class Ej03_RefactorizarConcatenacionIf {
    public static void main(String[] args) {
        int edad;
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce una edad: ");
        edad = teclado.nextInt();

        /*
        if (edad >= 65) {
            System.out.println("Jubilado");
        } else {
            if (edad < 18) {
                System.out.println("Menor de edad");
            } else {
                if ((edad >= 18) && (edad < 65)) {
                    System.out.println("Activo");
                }
            }
        }
        */

        if (edad >= 65)
            System.out.println("Jubilado");
        else if (edad < 18)
            System.out.println("Menor de edad");
        else
            System.out.println("Activo");

        teclado.close();
    }
}
