package example.android9ed.gridview;

import java.io.Serializable;

public class Pais implements Serializable {
    String pais;
    int recursoId;

    public Pais(String _pais, int _recursoId){
        pais = _pais;
        recursoId = _recursoId;
    }

    public int getRecursoId() {
        return recursoId;
    }

    public String getPais() {
        String nombrePais = pais.replace("_", " ");
        nombrePais = nombrePais.substring(0,1).toUpperCase() + nombrePais.substring(1);
        return nombrePais;
    }

    @Override
    public String toString() {
        return getPais();
    }
}
