public class Ej01_RefactorizarIf {
    public static void main(String[] args) {
        boolean b = true;

        /*
        if (b) {
            System.out.println("Hola.");
            System.out.println("¿Qué tal?");
        } else {
            System.out.println("Hola.");
            System.out.println("Adios.");
        }
        */

        System.out.println("Hola.");
        if (b)
            System.out.println("¿Qué tal?");
        else
            System.out.println("Adios.");
    }
}
