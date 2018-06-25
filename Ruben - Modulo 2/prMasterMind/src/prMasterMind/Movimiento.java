package prMasterMind;

/**
 * Clase que guarda un intento del juego Mastermind.
 * 
 */
public class Movimiento {
	// COMPLETAR LA CLASE

    private String cifras;
    private int colocadas;
    private int descolocadas;

	public Movimiento(String c, int col, int desc) {
        cifras = c;
        colocadas = col;
        descolocadas = desc;
	}

	public int colocadas(){ return colocadas; }
    public int descolocadas(){ return descolocadas; }
    public String cifras(){ return cifras; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Movimiento) {
            Movimiento movto = (Movimiento) obj;
            return cifras.equals(movto.cifras);
        } else{
          return false;
        }
    }

    @Override
    public int hashCode() {
        return cifras.hashCode();
    }

    @Override
    public String toString() {
        return "[" + cifras + ", " + colocadas + ", " + descolocadas + "]";
    }
}
