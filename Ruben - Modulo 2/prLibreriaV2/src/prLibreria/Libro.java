package prLibreria;

public class Libro {
    private String autor, titulo;
    private double precioBase;
    private static double IVA = 21;

    public Libro(String autor, String titulo, double precio){
        this.autor = autor;
        this.titulo = titulo;
        precioBase = precio;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public double getPrecioFinal() {
        return precioBase + (precioBase * IVA) / 100;
    }

    @Override
    public String toString() {
        return "(" + autor + "; " + titulo + "; " + precioBase + "; " + IVA + "%; " + getPrecioFinal() + ")";
    }

    public static double getIVA() {
        return IVA;
    }

    public static void setIVA(double iva){
        IVA = iva;
    }
}
