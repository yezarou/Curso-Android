// Rubén Zúñiga García

package amigos;
class Persona implements Comparable<Persona> {
	private String nombre;
	private Persona amigo;
		
	public Persona(String n) {
		nombre = n;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Persona getAmigo() {
		return amigo;
	}
	
	public void setAmigo(Persona a) {
		amigo = a;
	}

	@Override
	public boolean equals(Object o) {
		boolean res = o instanceof Persona;
		Persona p = res ? (Persona) o : null;
		return res && p.nombre.equalsIgnoreCase(nombre);
	}
	
	@Override
	public int hashCode() {
		return nombre.toUpperCase().hashCode();
	}

	@Override
	public int compareTo(Persona obj) {
		return nombre.compareTo(obj.nombre);
	}
	
	@Override
	public String toString() {
		String res = nombre + " --> " + (amigo == null?"sin amigo":amigo.nombre);
		return res;
	}
	
}
