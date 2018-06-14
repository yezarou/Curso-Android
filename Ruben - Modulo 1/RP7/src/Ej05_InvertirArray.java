public class Ej05_InvertirArray {
    public static void main(String[] args) {
        // Declaración de variables.
        int[] arrayOriginal = {24, 12, 45, 90, 7, 9, 15};
        int[] arrayInvertido = InvertirArray(arrayOriginal);

        // Mostrar los arrays.
        System.out.println("El array original: " + MostrarArray(arrayOriginal));
        System.out.println("El array invertido: " + MostrarArray(arrayInvertido));
    }

    // Método que invierte un array.
    private static int[] InvertirArray(int[] array){
        int[] invertido = new int[array.length];

        for (int i = 0; i < array.length; i++)
            invertido[i] = array[array.length - i - 1];

        return invertido;
    }

    // Método que muestra un array.
    private static String MostrarArray (int[] array){
        String txt = "";

        for (int tmp: array)
            txt += (tmp + " ");

        return txt;
    }
}
