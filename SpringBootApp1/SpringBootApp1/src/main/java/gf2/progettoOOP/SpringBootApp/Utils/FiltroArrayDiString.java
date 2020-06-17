package gf2.progettoOOP.SpringBootApp.Utils;

import java.util.ArrayList;

import gf2.progettoOOP.SpringBootApp.Exception.ArgomentoErratoException;

/**
 * Superclasse per i filtri che lavorano sulle stringhe
 * 
 * @author Margherita Galeazzi
 *
 */

public class FiltroArrayDiString {
	protected ArrayList<String> param = new ArrayList<String>();

	/**
	 * Costruttore della classe
	 * 
	 * @param parametri , deve essere un Array di stringhe
	 */
	public FiltroArrayDiString(Object parametri) {
		if (parametri instanceof ArrayList<?>) { // controlla che parametri sia un Array

			for (Object obj : (ArrayList<?>) parametri) {
				if (obj instanceof String) { // controlla che obj sia una stringa
					param.add((String) obj); // se lo e' la aggiunge all'array
				} else {
					throw new ArgomentoErratoException("Deve essere di tipo Stringa!!!"); // altrimenti lancia un
																							// messaggio di errore
				}
			}
		} else {
			throw new ArgomentoErratoException("Deve essere un Array!!!"); // se parametri non e' un Array lancia un
																			// messaggio di errore
		}
	}

	/**
	 * Setter dei parametri
	 * 
	 * @param parametri sara'  un Array di stringhe contenente i parametri per il
	 *                  filtraggio
	 * @throw ArgomentoErratoException se gli viene passato un argomento non
	 *        conforme al tipo
	 */
	public void SetParametriPerFiltro(Object parametri) {
		if (parametri instanceof ArrayList<?>) {
			for (Object obj : (ArrayList<?>) parametri) {
				if (obj instanceof String) { // controlla che obj sia una stringa
					param.add((String) obj); // se lo e' la aggiunge all'array
				} else {
					throw new ArgomentoErratoException("Deve essere una Stringa!!!"); // altrimenti lancia un messaggio
																						// di errore
				}
			}
		} else {
			throw new ArgomentoErratoException("Deve essere un Array!!!"); // se parametri non e' un Array lancia un
																			// messaggio di errore
		}
	}

}
