import java.util.*;

public class FrecuenciasMOd {
	public static void main(String[] args) {
		Map<String, List<Integer>> frecs = new TreeMap<>(new SatString().reversed());
		int i = 0;
		for (String arg : args) {
			List<Integer> lista = frecs.get(arg);
			if (lista == null) {
				lista = new ArrayList<>();
				frecs.put(arg, lista);
			}
			// PD: Seguro que lista esta asociado a arg en frecs
			lista.add(i);
			i++;
		}

		System.out.println(frecs);

	}	
}
