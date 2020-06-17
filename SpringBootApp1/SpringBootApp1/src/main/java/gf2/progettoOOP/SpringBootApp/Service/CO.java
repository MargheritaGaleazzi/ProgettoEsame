package gf2.progettoOOP.SpringBootApp.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import gf2.progettoOOP.SpringBootApp.Exception.*;
import gf2.progettoOOP.SpringBootApp.Model.Tweet;
import gf2.progettoOOP.SpringBootApp.Utils.Filter;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Classe che effettua il parsing ricorsivo su un oggetto di tipo JSON
 * 
 * @author Margherita Galeazzi
 *
 */
public class CO {
	/**
	 * Effettua il parsing piu esterno, selezionando il valore colonna e un oggetto
	 * valore, che contiene il filtro da applicare ai tweet ed eventualmente il modo
	 * con cui aggiungere il filtro ai precedenti.
	 * 
	 * @param filter contiene il JSON con le informazioni sul filtraggio
	 * @return l'Array list di tweet filtrati
	 * @throws Exception
	 * @throws FiltroInesistenteException viene lanciato se il filtro non viene
	 *                                    trovato trovato.
	 * @throws ArgomentoErratoException   viene lanciato se viene passato un
	 *                                    parametro di tipo errato al filtro.
	 */
	public static ArrayList<Tweet> COColumn(Object filter)
			throws Exception, FiltroInesistenteException, ArgomentoErratoException {

		ArrayList<Tweet> previousArray = new ArrayList<Tweet>();
		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
		HashMap<String, Object> result = new ObjectMapper().convertValue(filter, HashMap.class);

		for (Map.Entry<String, Object> entry : result.entrySet()) {

			// ad ogni ciclo ripulisce l array "filteredArray"
			// il vecchio filteredArray diventa Garbage (oggetto senza riferimento)
			String column = entry.getKey();
			Object filterParam = entry.getValue();
			try {
				filteredArray = COOperator(column, filterParam, previousArray);
			} catch (SecurityException e) {

				throw new Exception("Error in parsing I/O operation");

			}
			// ripulisce "previousArray" prima di riempirlo con "filteredArray"
			// il previousArray precedente diventa Garbage (oggetto senza riferimento)
			previousArray = new ArrayList<Tweet>();
			previousArray.addAll(filteredArray);
		}
		return filteredArray;
	}

	/**
	 * Effettua il parsing piu interno, selezionando l operatore e il parametro per
	 * il filtraggio e lancia il filtro corrispondente alla richiesta.
	 * 
	 * @param column        rappresenta il campo su cui si vuole effettuare il
	 *                      filtraggio.
	 * @param filterParam   contiene i parametri di filtraggio.
	 * @param previousArray rappresenta l'ArrayList ottenuto dai filtraggi
	 *                      precedenti relativi ad altre colonne.
	 * @return l'ArrayList di Tweet filtrati
	 * @throws Exception
	 * @throws FiltroInesistenteException viene lanciato se il filtro non viene
	 *                                    trovato trovato.
	 * @throws ArgomentoErratoException   viene lanciato se viene passato un
	 *                                    parametro di tipo errato al filtro.
	 */

	public static ArrayList<Tweet> COOperator(String column, Object filterParam, ArrayList<Tweet> previousArray)
			throws Exception, FiltroInesistenteException, ArgomentoErratoException {

		String type = "";
		Filter filter;
		ArrayList<Tweet> filteredArray = new ArrayList<Tweet>();
		HashMap<String, Object> result = new ObjectMapper().convertValue(filterParam, HashMap.class);

		for (Map.Entry<String, Object> entry : result.entrySet()) {

			String operator = entry.getKey();
			Object value = entry.getValue();
			// Se operatore e' type allora guarda se il valore e' 'and' o 'or'
			// lancia il metodo runfilter corrispondente
			if (operator.equals("type") || operator.equals("Type")) {
				type = (String) value;
				if (!(value.equals("and")) && !(value.equals("or"))) {
					throw new ArgomentoErratoException("'and' o 'or' sono ammessi dopo 'type'");
				}
				continue;
			}

			filter = FilterService.instanceFilter(column, operator, value);
			switch (type) {

			case "and":
				filteredArray = FilterService.FilterAND(filter, previousArray);
				break;
			case "or":
				filteredArray = FilterService.FilterOR(filter, previousArray);
				break;
			default:
				filteredArray = FilterService.FilterOR(filter, previousArray);
			}
		}
		return filteredArray;
	}
}
