import java.util.*;
// {a=5, b=4, c=4, d=1, e=2, f=2}
public class FrecuenciasSM {
	public static void main(String[] args) {
		SortedMap<String,Integer> mFrecs = new TreeMap<>();
		for (String arg : args) {
			// Incr. la frec. de argd., o la pone a 1 si es la 1ª
			int frec = mFrecs.getOrDefault(arg, 0);
			mFrecs.put(arg, frec + 1);
		}
		System.out.println(mFrecs);
		// Muestra frecs. de subrango iterando sobre conj. ordenado de entradas
		Map<String, Integer> sm = mFrecs.subMap("e", "l");
		for (Map.Entry<String, Integer> par : sm.entrySet()) {
			String key = par.getKey();
			int val = par.getValue();
			char[] barra = new char[val];
			Arrays.fill(barra, '*');
			System.out.println(key+ ":\t" + new String(barra));
		}
	}	
}
