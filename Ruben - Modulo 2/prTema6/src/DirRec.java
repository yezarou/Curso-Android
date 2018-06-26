import java.io.File;

public class DirRec {
	public static void main(String args[]) {
		if (args.length == 0)
			System.err.println("Uso DirRec <directorio>");
		else
			new DirRec(new File(args[0]));
	}

	public DirRec(File entrada) {
		dir(entrada, 0);
	}

	private void dir(File entrada, int n) {
		if (!entrada.exists()) {
			muestra(n, entrada.getName() + " no encontrado.");
		} else if (entrada.isFile()) {
			muestra(n, entrada.getName());
		} else if (entrada.isDirectory()) {
			File[] files = entrada.listFiles();
			muestra(n, "DIRECTORIO: " + entrada);
			for (File f : files)
				dir(f, n + 1);
		}
	}

	private void muestra(int n, String s) {
		for (int i = 0; i < n; i++)
			System.out.print("\t");
		System.out.println(s);
	}
}
