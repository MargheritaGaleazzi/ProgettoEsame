package gf.progettoesame.SpringBootApp.utility;

import java.util.*;

/**
 * Interfaccia per il filtraggio
 * @param <T> Tipo del valore utilizzato per il filtraggio
 * @param <G> Tipo dell'oggetto da filtrare
 * @author mgale
 *
 */
public interface Filtri <G,T> {
/**
 * Metodo astratto la cui implementazione filtrerà la timeline
 * @param nomeCampo Nome del campo da filtrare
 * @param operatoreLogico Operatore mediante il quale verrà effettuato il filtraggio
 * @param value Valori da filtrare
 * @return Timeline filtrata
 */
	abstract Collection<G> campoFiltro(String campoNome, String operatoreLogico, T valore);
}
