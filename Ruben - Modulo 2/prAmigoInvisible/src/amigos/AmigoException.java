// Rubén Zúñiga García

package amigos;
public class AmigoException extends RuntimeException {

    public AmigoException(){
        super();
    }

	public AmigoException(String mensaje){
	    super(mensaje);
    }
}