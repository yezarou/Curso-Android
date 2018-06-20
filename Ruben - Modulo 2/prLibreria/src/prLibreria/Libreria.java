package prLibreria;

public class Libreria {
    private int numLibros;
    static final int TAM_DEFECTO = 16;
    private Libro[] libros;

    public Libreria(){
        libros = new Libro[TAM_DEFECTO];
        numLibros = 0;
    }

    public Libreria(int tam){
        libros = new Libro[tam];
        numLibros = 0;
    }

    public void addLibro(String autor, String titulo, double precio){
        if (numLibros < libros.length)
            libros[numLibros++] = new Libro(autor, titulo, precio);
    }

    public void remLibro(String autor, String titulo){

    }
}
