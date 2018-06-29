package musculacion;

public class Maquina implements Comparable<Maquina> {
    private int maquinaId;
    private String nombre;
    private String urlImagen;
    private int nivel;
    private String funcion;
    private String descripcion;

    public Maquina(int id, String n){
        maquinaId = id;
        nombre = n;
    }

    public int getMaquinaId() { return maquinaId; }

    public String getNombre() { return nombre; }

    public String getUrlImagen() { return urlImagen; }

    public void setUrlImagen(String urlImagen) { this.urlImagen = urlImagen; }

    public int getNivel() { return nivel; }

    public void setNivel(int nivel) { this.nivel = nivel; }

    public String getFuncion() { return funcion; }

    public void setFuncion(String funcion) { this.funcion = funcion; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public int compareTo(Maquina o) {
        return Integer.compare(maquinaId, o.maquinaId);
    }

    @Override
    public String toString() {
        return "Maquina(" + maquinaId + ", " + nombre + ")";
    }
}
