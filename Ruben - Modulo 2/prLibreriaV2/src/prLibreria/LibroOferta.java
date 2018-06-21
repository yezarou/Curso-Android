package prLibreria;

public class LibroOferta extends Libro {
    double porDescuento;

    public LibroOferta(String autor, String titulo, double precio, double oferta){
        super(autor, titulo, precio);
        oferta = oferta;
    }

    public double getPorDescuento() { return porDescuento; }

    @Override
    public double getPrecioFinal() {
        double pf = super.getPrecioFinal();
        return pf - pf * getPorDescuento()/100;
    }

    @Override
    public String toString() {
        return "(" + getAutor()
                + "; " + getTitulo()
                + "; " + getPrecioBase()
                + "; " + getIVA() + "%; "
                + "; " + (getPrecioBase() - getPrecioBase()*porDescuento/100)
                + "; " + porDescuento
                + "; " + getPrecioFinal()
                + ")";
    }
}
