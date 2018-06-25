package prMasterMind;

import java.util.Random;

public class MasterMind {

	public static final int TAMANO_POR_DEFECTO = 4;
	private static Random alea = new Random();
	
	protected String combinacionSecreta;

	public MasterMind() {
		this(TAMANO_POR_DEFECTO);
	}

	public MasterMind(int tam) {
		generaCombinacionSecreta(tam);
	}

	public MasterMind(String secreto) {
		if (validaCombinacion(secreto))
			combinacionSecreta = secreto;
		else
		    throw new MasterMindException();
	}

	private void generaCombinacionSecreta(int tam) {
		int i = 0;
		combinacionSecreta = "";

		while (i < tam){
		    int n = alea.nextInt(10);
		    String ns = Integer.toString(n);

            if (combinacionSecreta.indexOf(ns) < 0) {
                combinacionSecreta += ns;
                i++;
            }
        }
	}

	public int longitud() {
		return combinacionSecreta.length();
	}

    private boolean validaCombinacion(String cifrasStr) {
        // La longitud debe ser la adecuada
        boolean valida = cifrasStr.length() == longitud();

        if (valida)  {
            for (char c : cifrasStr.toCharArray())
                if (!Character.isDigit(c))
                    valida = false;
        }
        // valida = cifrasStr.matches("[0-9]{" + longitud() + "}");
        
        if (valida) {
            for (char c : cifrasStr.toCharArray()) {
                if (cifrasStr.indexOf(c) != cifrasStr.lastIndexOf(c))
                    valida = false;
            }
        }
        // while (i < longitud() - 1 && valida) {
        //     valida = cifrasStr.substring[i + 1].indexOf(cifrasStr.charAt(i)) == -1;
        //     i++;
        // }

        return valida;
    }
    
/*
    private boolean validaCombinacion(String cifrasStr) {
		if (cifrasStr.length() != longitud()) {
			return false;
		}
		String patron = "[0-9]";
		for (int i = 1; i < combinacionSecreta.length(); i++) {
			patron += "[0-9&&[^" + cifrasStr.substring(0,i) + "]]";
		}
		return cifrasStr.matches(patron);
	}
*/
	public Movimiento intento(String cifrasStr) {
		if (!validaCombinacion(cifrasStr))
		    throw new MasterMindException();

		// Si todo va bien,
		// calculamos las cifras colocadas y descolocadas
		// y creamos un Movimiento con esos datos
		int colocadas = 0;
		int descolocadas = 0;

		for (int i = 0; i < longitud(); i++){
		    if (cifrasStr.charAt(i) == combinacionSecreta.charAt(i))
		        colocadas++;
		    else if (cifrasStr.indexOf(combinacionSecreta.charAt(i)) > -1)
		        descolocadas++;
        }

		// COMPLETAR

        return new Movimiento(cifrasStr, colocadas, descolocadas);
	}

	public String secreto() {
		return combinacionSecreta;
	}
}
