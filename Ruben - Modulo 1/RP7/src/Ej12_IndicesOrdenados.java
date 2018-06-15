import java.util.Arrays;

public class Ej12_IndicesOrdenados {
    public static void main(String[] args) {
        // Declarar array.
        int[] array = {10, 5, -7, 0, 13};

        // Comprobar resultado.
        System.out.println("Array original: " + MostrarArray(array));
        System.out.println("Índices ordenados: " + MostrarArray(IndicesOrdenados(array)));
    }

    // Método que devuelve un array con los índices ordenados de un vector.
    private static int[] IndicesOrdenados(int[] array){
        int[] orden = new int[array.length];
        int[] copiaOrdenada = new int[array.length];

        System.arraycopy(array,0,copiaOrdenada,0,array.length);
        Arrays.sort(copiaOrdenada);

        for (int i = 0; i < array.length; i++){
            orden[i] = Esta(array, copiaOrdenada[i]);
        }

        return orden;
    }

    // Método que devuelve el índice del valor si se encuentra en un array.
    private static int Esta(int[] array, int num){
        int res = -1;

        for (int i = 0; i < array.length; i++){
            if (array[i] == num)
                res = i;
        }

        return res;
    }

    // Método que muestra un array.
    private static String MostrarArray (int[] array){
        String txt = "";

        for (int tmp: array)
            txt += (tmp + " ");

        return txt;
    }
}
