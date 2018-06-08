public class Ej09_TableroAjedrez {
    public static void main(String[] args) {
        // Dibujar un tablero de ajedrez.
        System.out.println("Tablero de ajedrez:\n");

        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                if ((i + j) % 2 == 0)
                    System.out.print("B ");
                else
                    System.out.print("N ");
            }
            System.out.println();
        }
    }
}
