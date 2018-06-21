package prLibreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
    private String[] autores;
    private double porDescuento;

    public LibreriaOferta (int pd, String[] autores){
        this(TAM_DEFECTO, pd, autores);
    }

    public LibreriaOferta(int tam, double pd, String[] autores){
        super(tam);
        setOferta(pd, autores);
    }

    public void setOferta(double pd, String[] autores){
        porDescuento = pd;
        this.autores = autores;
    }

    public String[] getOferta() { return autores; }
    public double getPorDescuento() { return porDescuento; }

    @Override
    public void addLibro(String autor, String titulo, double precio) {
        Libro libro = null;
        if (esAutorOferta(autor))
            libro = new LibroOferta(autor, titulo, precio, porDescuento);
        else
            libro = new Libro(autor, titulo, precio);

        addLibro(libro);
    }

    private boolean esAutorOferta(String autor) {
        int i = 0;
        while (i < autores.length && !(autor.equalsIgnoreCase(autores[i])))
            i++;
        return i < autores.length;
    }

    @Override
    public String toString() {
        return porDescuento + "%" + Arrays.toString(autores) + super.toString();
    }
}
