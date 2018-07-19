package example.android9ed.appinfo;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Permisos implements Serializable {
    private String name;
    private String descripcion;
    public Permisos (String namep, String descripcionp){
        name = namep;
        descripcion = descripcionp;
    }
    public String getName (){
        return name;
    }
    public String getDescripcion (){
        return descripcion;
    }
    public String toString (){
        String[] nombre = name.split(Pattern.quote("."));
        int length = nombre.length;
        String res = nombre[length-1].replace('_', ' ').toLowerCase();
        res = res.substring(0, 1).toUpperCase() + res.substring(1);
        return res;
    }
}