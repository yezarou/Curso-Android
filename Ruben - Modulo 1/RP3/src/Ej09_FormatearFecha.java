import java.util.Scanner;

public class Ej09_FormatearFecha {
    public static void main(String[] args) {
        // Declaración de variables.
        int dia, mes, anualidad;
        String mesEscrito;
        Scanner teclado = new Scanner(System.in);

        // Introducir datos.
        System.out.println("Introduce una fecha.");
        System.out.print("Dia: ");
        dia = teclado.nextInt();

        System.out.print("Mes: ");
        mes = teclado.nextInt();

        System.out.print("Año: ");
        anualidad = teclado.nextInt();

        // Detectar mes
        switch (mes) {
            case 1:
                mesEscrito = "Enero";
                break;
            case 2:
                mesEscrito = "Febrero";
                break;
            case 3:
                mesEscrito = "Marzo";
                break;
            case 4:
                mesEscrito = "Abril";
                break;
            case 5:
                mesEscrito = "Mayo";
                break;
            case 6:
                mesEscrito = "Junio";
                break;
            case 7:
                mesEscrito = "Julio";
                break;
            case 8:
                mesEscrito = "Agosto";
                break;
            case 9:
                mesEscrito = "Septiembre";
                break;
            case 10:
                mesEscrito = "Octubre";
                break;
            case 11:
                mesEscrito = "Noviembre";
                break;
            case 12:
                mesEscrito = "Diciembre";
                break;
            default:
                mesEscrito = "No encontrado";
                break;
        }

        // Mostrar mes
        System.out.println("\nFecha formateada:");
        System.out.println("Dia: " + dia);
        System.out.println("Mes: " + mesEscrito);
        System.out.println("Año: " + anualidad);
        teclado.close();
    }
}
