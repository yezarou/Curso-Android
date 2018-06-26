package alturas;

public class Pais {
    private String nombre;
    private String continente;
    private double altura;

    public Pais(String nombre, String continente, double alturaMedia){
        this.nombre = nombre;
        this.continente = continente;
        altura = alturaMedia;
    }

    public String getNombre() { return nombre; }

    public String getContinente() { return continente; }

    public double getAltura() { return altura; }

    @Override
    public boolean equals(Object obj) {
        return ((Pais) obj).nombre == nombre;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    @Override
    public String toString() {
        return "Pais(" + nombre + ", " + continente + ", " + altura + ")";
    }
}
