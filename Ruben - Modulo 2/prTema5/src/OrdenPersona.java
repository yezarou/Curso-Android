import java.util.Comparator;

public class OrdenPersona implements Comparator<Persona> {
	// Se comparan por nombres, y a igualdad de nombres, por edad
	public int compare(Persona p1, Persona p2) {
		int resultado = p1.nombre().compareTo(p2.nombre());
		if (resultado == 0) {
			resultado = Integer.compare(p1.edad(), p2.edad());
		} 
		return resultado;
	}
}
