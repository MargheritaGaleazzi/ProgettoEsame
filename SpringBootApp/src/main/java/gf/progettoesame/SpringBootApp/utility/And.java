package gf.progettoesame.SpringBootApp.utility;

import java.util.ArrayList;
import gf.progettoesame.SpringBootApp.model.Tweet;
/**
 * Classe che permette di interrogare la timeline e ottenere un risultato unico
 * usando una logica AND
 * @author mgale
 *
 */
public class And {
	
	/**
	 * Implementazione della logica AND
	 * @param items Contiene il gruppo di insiemi di oggetti
	 * @return Restituisce quelli comuni
	 */
	public ArrayList<Tweet> intersection (ArrayList<ArrayList<Tweet>> items) {
		ArrayList<Tweet> list=new ArrayList<Tweet>();
		for(int i=0; i<items.size(); i++) {
			for(Tweet t: items.get(i)) {
				boolean included=true;
				for(ArrayList<Tweet> itemToCompare : items) {
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

}}
