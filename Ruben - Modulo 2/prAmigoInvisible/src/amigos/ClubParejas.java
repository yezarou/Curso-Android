// Rubén Zúñiga García

package amigos;

import java.io.*;
import java.util.*;

public class ClubParejas extends Club {
	private Set<Pareja> parejas;

	public ClubParejas()  {
		super();
		parejas = new TreeSet<>(parejas);
	}

	@Override
	public void crearSocioDesdeString(String nombreSocioOPareja) {
		if (nombreSocioOPareja.contains("-")) {
			String[] pareja = nombreSocioOPareja.split("-");
			Persona p1 = new Persona(pareja[0]);
			Persona p2 = new Persona(pareja[1]);

			parejas.add(new Pareja(p1, p2));
			socios.add(p1);
			socios.add(p2);
		} else
			super.crearSocioDesdeString(nombreSocioOPareja);
	}

	@Override
	public void hacerAmigos() {
		Boolean res;
		do {
			res = true;
			super.hacerAmigos();

			for (Persona persona : socios)
				if (parejas.contains(new Pareja(persona, persona.getAmigo())))
					res = false;
		} while (!res);
	}
}
