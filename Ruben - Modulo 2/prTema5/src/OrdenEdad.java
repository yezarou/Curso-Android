import java.util.Comparator;

/**
 * Created by pacog on 7/3/15.
 */
public class OrdenEdad implements Comparator<Persona> {
    // Se comparan por edad
    public int compare(Persona p1, Persona p2) {
        return Integer.compare(p1.edad(),p2.edad());
    }
}