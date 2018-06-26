import java.io.FileNotFoundException;

public class MainSPersona {

	public static void main(String [] args) throws FileNotFoundException {
		SPersona sp = new SPersona();
		sp.leePersonas("prTemas/src/prTema6/personas.txt");
		System.out.println(sp.getPersonas());
	}
}
