package prCoche;

public class Coche {
    private String nombre;
    private double precio;
    private static double PIVA = 0.16;

    public Coche(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public static void setPiva(double PIVA){
        Coche.PIVA = PIVA;
    }

    public double precioTotal(){
        return precio + (precio * PIVA);
    }

    @Override
    public String toString() {
        return nombre + " -> " + precioTotal();
    }
}
