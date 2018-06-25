package prMasterMind;
import java.util.*;

public class MasterMindMemoria extends MasterMind {
	private Movimiento[] movimientos;
	private int primeraPosicionLibre;
	private static final int TAMARRAYMOV = 10;

	public MasterMindMemoria() {
		super();
        movimientos = new Movimiento[TAMARRAYMOV];
        primeraPosicionLibre = 0;
    }
	
	public MasterMindMemoria(int tam) {
		super(tam);
        movimientos = new Movimiento[TAMARRAYMOV];
        primeraPosicionLibre = 0;
	}

	public Movimiento intento(String cifraStr) {
		boolean existente = true;
        Movimiento mvto = super.intento(cifraStr);

        for (int i = 0; i < primeraPosicionLibre; i++)
            if (movimientos[i].equals(mvto))
                existente = false;

        if (!existente)
            throw new MasterMindException("Movimiento ya hecho");

        if (primeraPosicionLibre == movimientos.length)
            movimientos = Arrays.copyOf(movimientos, movimientos.length + TAMARRAYMOV);
		
		return (movimientos[primeraPosicionLibre++] = mvto);
	}

	public Movimiento[] movimientos() {
		return movimientos;
	}
}
