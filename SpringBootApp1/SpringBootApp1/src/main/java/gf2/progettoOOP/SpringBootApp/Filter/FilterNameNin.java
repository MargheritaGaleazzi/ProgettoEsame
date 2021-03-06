package gf2.progettoOOP.SpringBootApp.Filter;

import gf2.progettoOOP.SpringBootApp.Model.Tweet;
import gf2.progettoOOP.SpringBootApp.Utils.Filter;
import gf2.progettoOOP.SpringBootApp.Utils.FiltroArrayDiString;

/**
 * Classe che implementa il filtro per verificare se un utente NON e' contenuto
 * nei tweet 
 * Implementa l'interfaccia Filter ed estende la classe
 * FiltroArrayDiString
 * 
 * @see Filter
 * @see FiltroArrayDiString
 * @author Margherita Galeazzi
 *
 */
public class FilterNameNin extends FiltroArrayDiString implements Filter {
	/**
	 * Costruttore della classe, che richiama il costruttore della super classe
	 * 
	 * @param parametri
	 */
	public FilterNameNin(Object parametri) {
		super(parametri);

	}

	/**
	 * Override del metodo filter, dell'interfaccia Filter che restituisce true se
	 * l'utente NON e' presente, false altrimenti
	 * 
	 * @see Filter
	 */
	@Override
	public boolean filter(Tweet tweet) {
		for (String p : param) {
			if (tweet.getName_user().equals(p)) {
				return false;
			}
		}
		return true;
	}

}
