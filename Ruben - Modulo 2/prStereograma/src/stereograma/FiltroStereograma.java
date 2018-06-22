package stereograma;

import stereograma.FiltroImagen;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;
public class FiltroStereograma implements FiltroImagen {
	
	protected int tamTrama;
	protected int maxCapa;
	static final int TAM_TRAMA = 60;
	static final int MAX_CAPA = 16;
	static final Random aleatorio = new Random();
	
	public FiltroStereograma() {
		this(TAM_TRAMA, MAX_CAPA);
	}
	
	public FiltroStereograma( int tamTrama, int capas) {
		this.tamTrama = tamTrama;
		this.maxCapa  = capas;
	}
	
	public void filtra(BufferedImage imagen) {
		int fWidth  = imagen.getWidth();
		int fHeight = imagen.getHeight();
		
		// Creamos una trama inicial a la izquierda
			// COMPLETAR
		// Completamos siguiendo el algoritmo
			// COMPLETAR
	}
}
