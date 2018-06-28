package musculacion;

import java.util.Set;
import java.util.TreeSet;

public class Zona implements Comparable<Zona> {
    private int zonaId;
    private String nombre;
    private double longitud;
    private double latitud;
    private String urlImagen;
    private Set<Maquina> maquinas;

    public Zona(int id, String n) {
        zonaId = id;
        nombre = n;
        maquinas = new TreeSet<>();
    }

    public int getZonaId() { return zonaId; }
    public String getNombre() { return nombre; }
    public double getLongitud() { return longitud; }
    public void setLongitud(double longitud) { this.longitud = longitud; }
    public double getLatitud() { return latitud; }
    public void setLatitud(double latitud) { this.latitud = latitud; }
    public String getUrlImagen() { return urlImagen; }
    public void setUrlImagen(String urlImagen) { this.urlImagen = urlImagen; }
    public Set<Maquina> getMaquinas() { return maquinas; }

    public void agrega(Maquina mq){
        maquinas.add(mq);
    }

    @Override
    public int compareTo(Zona o) {
        return Integer.compare(zonaId, o.zonaId);
    }

    @Override
    public String toString() {
        return "Zona(" + zonaId + ", " + nombre + ")";
    }
}
