package gf.progettoesame.SpringBootApp.utility;

import java.lang.*;
import java.util.*;

/**
 * Classe che permette di interrogare la timeline e ottenere un risultato unico
 * usando una logica AND/OR
 * @param <T> ovvero di tipo generico
 * @author mgale
 *
 */
public class AndOr {
	
	/**
	 * Implementazione della logica AND
	 * @param items Contiene il gruppo di insiemi di oggetti
	 * @return Restituisce quelli comuni
	 */
	public ArrayList<t> intersection (ArrayList<ArrayList<T>> items) {
		for(int i=0; i<items.size(); i++) {
			for(T t: items.get(i)) {
				boolean included=true;
				for(ArrayList<T> itemToCompare : items) {
                    if(!itemToCompare.contains(t)) {
                        included = false;
                        break;
                    }
                }
                if(included && !list.contains(t))
                    list.add(t);
            }
        }
        return list;
	}
	
	 /**
     * Implementazione della logica OR
     * @param items Argomento che contiene il gruppo di insiemi di oggetti
     * @return Restituisce l'insieme ottenuto con logica OR
     */
    public ArrayList<T> union (ArrayList<ArrayList<T>> items) {
        Set<T> set = new HashSet<T>();

        for (ArrayList<T> item : items)
            set.addAll(item);

        return new ArrayList<T>(set);
    }
}
