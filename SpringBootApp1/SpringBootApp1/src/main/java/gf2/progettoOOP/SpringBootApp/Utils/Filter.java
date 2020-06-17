package gf2.progettoOOP.SpringBootApp.Utils;

import gf2.progettoOOP.SpringBootApp.Model.Tweet;

/**
 * Interfaccia per i filtri
 * 
 * @author Margherita Galeazzi
 *
 */
public interface Filter {
	/**
	 * Il valore booleano di risposta e' true, se il tweet rispetta le richieste del
	 * filtro che implementera'  l'interfaccia
	 * 
	 * @param tweet, che e' il tweet da "controllare"
	 * @return risultato.
	 */
	public boolean filter(Tweet tweet);
}
