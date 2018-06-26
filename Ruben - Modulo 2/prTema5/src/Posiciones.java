import java.util.*;

public class Posiciones{
	public static void main(String[] args) {
		SortedMap<String,List<Integer>> mPos = new TreeMap<>();
		for (int i = 0; i < args.length; i++) {
			// Buscamos la lista asociada a args[i] en mPos
			List<Integer> lPos = mPos.getOrDefault(args[i], new ArrayList<>());
			lPos.add(i);
			mPos.putIfAbsent(args[i], lPos);
//			mPos.computeIfAbsent(args[i], k -> new ArrayList<>()).add(i);
		}
		for (Map.Entry<String,List<Integer>> entrada : mPos.entrySet()) {
			String clave= entrada.getKey();
			List<Integer> lPos = entrada.getValue();
			System.out.println(clave + ":\t" + lPos);
		}
	}	
}