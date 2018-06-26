public class Persona implements Comparable<Persona> {
	private String nombre;
	private int edad;

	public Persona(String n, int e) {
		nombre = n;
		edad = e;
	}

	public String nombre() {
		return nombre;
	}
	
	public int edad() {
		return edad;
	}
	
	public boolean equals(Object o) {
		return (o instanceof Persona) && (edad == ((Persona) o).edad)
				&& ((Persona) o).nombre.equalsIgnoreCase(nombre);
	}

	public int hashCode() {
		return nombre.toLowerCase().hashCode() + Integer.hashCode(edad);
	}

	// Se comparan por edad, y a igualdad de edad, por nombres
	public int compareTo(Persona p) {
		int resultado = Integer.compare(edad, p.edad) ;
		if (resultado == 0) {
			resultado = nombre.compareTo(p.nombre);
		}
		return resultado;
	}

	public String toString() {
		return "Persona(" + nombre + "," + edad + ")";
	}
}
