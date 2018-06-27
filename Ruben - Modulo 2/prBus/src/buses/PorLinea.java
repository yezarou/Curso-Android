package buses;

public class PorLinea implements Criterio {
    int linea;

    public PorLinea (int linea){
        this.linea = linea;
    }

    @Override
    public boolean esSeleccionable(Bus bus) {
        return linea == bus.codLinea;
    }

    @Override
    public String toString() {
        return "Autobuses de la linea " + linea;
    }
}
