package prLibreria;

public class LibreriaOfertaFlexible extends Libreria {
    private OfertaFlex ofertaFlexible;

    public LibreriaOfertaFlexible(OfertaFlex of) {
        ofertaFlexible = of;
    }

    public LibreriaOfertaFlexible(int tam, OfertaFlex of){
        super(tam);
        ofertaFlexible = of;
    }

    public OfertaFlex getOfertaFlexible() {
        return ofertaFlexible;
    }

    public void setOfertaFlexible(OfertaFlex of) {
        ofertaFlexible = of;
    }

    @Override
    public void addLibro(String autor, String titulo, double precio) {
        Libro libro = new Libro(autor, titulo, precio);
        double pd = ofertaFlexible.getDescuento(libro);
        if (pd != 0)
            libro = new LibroOferta(autor, titulo, precio, pd);
        addLibro(libro);
    }

    @Override
    public String toString() {
        return "";
    }
}
