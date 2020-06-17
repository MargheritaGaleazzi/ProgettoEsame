package gf2.progettoOOP.SpringBootApp.Exception;

/**
 * Rappresenta un'eccezione personalizzata del tipo "ClassNotFoundException"
 * 
 * @see ClassNotFoundException
 * @author Margherita Galeazzi
 *
 */
public class FiltroInesistenteException extends ClassNotFoundException {
	private static final long serialVersionUID = 1L;

	public FiltroInesistenteException() {
		super();
	}

	public FiltroInesistenteException(String message) {
		super(message);
	}
}
