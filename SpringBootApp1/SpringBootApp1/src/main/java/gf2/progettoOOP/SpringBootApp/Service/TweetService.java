package gf2.progettoOOP.SpringBootApp.Service;

import java.util.Collection;
import gf2.progettoOOP.SpringBootApp.Model.*;

/**
 * Interfaccia che contiene i metodi che saranno implementati in
 * TweetServiceImpl
 * 
 * @see TweetServiceImpl
 * @author Margherita Galeazzi
 *
 */
public interface TweetService {
	/**
	 * Metodo che restituisce l'insieme dei tweet
	 * 
	 * @return una Collection di Tweet
	 */
	public static Collection<Tweet> getTweet() {
		return null;
	}

	/**
	 * Metodo che restituisce l'insieme dei metadati
	 * 
	 * @return una Collection di metadati
	 */
	public abstract Collection<Metadata> getMetada();

	/**
	 * Metodo che restituisce il numero dei tweet con location
	 * 
	 * @return un oggetto di tipo ModelloStatistiche
	 */
	public abstract ModelloStatistiche getStats();

}
