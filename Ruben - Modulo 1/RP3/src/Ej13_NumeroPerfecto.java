public class Ej13_NumeroPerfecto {
    public static void main(String[] args) {
        // Declaración de variables.
        int num = 29, suma;
        boolean encontrado = false;

        // Buscar valor.
        while (!encontrado){
            suma = 0;

            for (int i = 1; i <= num / 2; i++)
                if (num % i == 0)
                    suma += i;
            
            if (suma == num)
                encontrado = true;
            else
                num++;
        }

        // Mostrar valor.
        System.out.println(num);
    }
}
