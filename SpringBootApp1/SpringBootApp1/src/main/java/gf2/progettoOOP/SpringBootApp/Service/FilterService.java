package gf2.progettoOOP.SpringBootApp.Service;

import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import gf2.progettoOOP.SpringBootApp.Exception.*;
import gf2.progettoOOP.SpringBootApp.Model.*;
import gf2.progettoOOP.SpringBootApp.Utils.*;

public class FilterService {
	private final static String path = "gf2.progettoOOP.SpringBootApp.Filter.";

	private static ArrayList<Tweet> timeline = JSONParser.parsaJson(JSONDownloader.JSONDownloadato());

	/**
	 * Permette di istanziare un oggetto Filter indicando i paramatri di filtraggio
	 * desiderati.
	 * 
	 * @param column   campo da filtrare
	 * @param operator tipo di filtraggio desiderato
	 * @param param    parametro ingresso necessario al filro selezionato
	 * @return un oggetto che rappresenta filtro desiderato
	 * @throws Exception
	 * @throws FiltroInesistenteException il filtro richiesto non esiste
	 * @throws ArgomentoErratoException   il parametro d'ingresso al filtro non e'
	 *                                    valido per il filro selezionato.
	 * @throws Exception                  errori interni
	 */

	public static Filter instanceFilter(String column, String operator, Object param) throws Exception {

		Filter filtro;
		String filterName = new String("Filter" + column + operator);
		String ClassFilterName = path.concat(filterName);

		try {

			Class<?> cls = Class.forName(ClassFilterName); // seleziona la classe

			Constructor<?> ct = cls.getDeclaredConstructor(Object.class); // seleziona il costruttore

			filtro = (Filter) ct.newInstance(param); // istanzia oggetto filtro
		}

		// entra qui se il nome filtro non e' corretto
		catch (ClassNotFoundException e) {
			throw new FiltroInesistenteException(
					"Il filtro nel campo: '" + column + "' con l'operatore: '" + operator + "' non esiste");
		}

		// entra qui se il costruttore chiamato da newInstance lancia un eccezione
		catch (InvocationTargetException e) {
			// genera una nuova eccezione
			throw new ArgomentoErratoException(e.getTargetException().getMessage() + " Atteso in: '" + column + "'");
		}

		catch (LinkageError | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException e) {

			e.printStackTrace();
			throw new Exception("try later");
		}

		return filtro;

	}

	/**
	 * Questo metodo scorre i tweet (contenuti in un'Array) e restitusce un nuovo
	 * ArrayList composto da soli record che risultano positivi al filtro.
	 * 
	 * @param filtro        desiderato
	 * @param previousArray ArrayList di Tweet da filtrare
	 * @return ArrayList di Tweet filtrati
	 */

	public static ArrayList<Tweet> FilterAND(Filter filtro, ArrayList<Tweet> previousArray) {

		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();

		for (Tweet tweet : previousArray) {

			if (filtro.filter(tweet))
				filteredArray.add(tweet);
		}

		return filteredArray;
	}

	/**
	 * Questo metodo restitusce un ArrayList di Tweet che contiene i tweet
	 * precedenti con in aggiunta quelli che rispettano il filtro
	 * 
	 * @param filtro        desiderato
	 * @param previousArray ArrayList di Tweet iniziale
	 * @return ArrayList di Tweet filtrati
	 */

	public static ArrayList<Tweet> FilterOR(Filter filtro, ArrayList<Tweet> previousArray) {

		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();

		for (Tweet tweet : timeline) {

			if (filtro.filter(tweet))
				filteredArray.add(tweet);
		}

		previousArray.removeAll(filteredArray);
		previousArray.addAll(filteredArray);
		return previousArray;
	}
}
