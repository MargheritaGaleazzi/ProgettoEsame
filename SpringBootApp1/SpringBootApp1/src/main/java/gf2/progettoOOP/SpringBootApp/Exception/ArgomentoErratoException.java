package gf2.progettoOOP.SpringBootApp.Exception;

/**
 * Rappresenta un'eccezione personalizzata del tipo "IllegalArgumentException"
 * 
 * @see IllegalArgumentException
 * @author Margherita Galeazzi
 *
 */
public class ArgomentoErratoException extends IllegalArgumentException {
	private static final long serialVersionUID = 1L;

	public ArgomentoErratoException() {
		super();
	}

	public ArgomentoErratoException(String message) {
		super(message);
	}

}
