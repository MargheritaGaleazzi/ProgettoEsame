package gf.progettoesame.SpringBootApp.model;

import java.util.*;

import org.json.Tweet;

/**
 * Classe che ragruppa tutti gli oggetti {@link Tweet} in una collezione, dando la possibilità di
 * avere funzioni aggiuntive, quali le statistiche sulla timeline e il filtraggio
 * @author mgale
 *
 */
public class Timeline implements Filtri<Tweet, Object[]> {
	private ArrayList<Tweet> timeline;
	private Filtriut<Tweet> utils;
/**
 * Costruttore dell'oggetto timeline
 * @param timeline è un Arraylist di {@link Tweet}
 * @param utils si istanzia per poter usare i metodi della classe Filtriut
 */
	public Timeline(ArrayList<Tweet> timeline, Filtriut<Tweet> utils) {
		this.timeline=timeline;
		this.utils=utils;
	}
	/**
	 * Costruttore dell'oggetto
	 * @param timeline è un Arraylist di {@link Tweet}
	 */
public Timeline(ArrayList<Tweet> timeline) {
	this.timeline=timeline;
	this.utils=new Filtriut<Tweet>();
}
/**
 * Metodo che restituisce il contenuto della timeline
 * @return Timeline contenente i vari tweet {@link Tweet}
 */
public ArrayList<Tweet> getTimeline(){
	return timeline;
}
/**
 * Metodo capace di settare una nuova collezione di {@link Tweet} per la classe
 * @param timeline Oggetti {@link Tweet} da immettere
 */
public void setTimeline(ArrayList<Tweet> timeline) {
	this.timeline=timeline;
}
/**
 * Metodo che restituisce le statistiche sui luoghi dei tweet
 * @param geo Luogo di cui si vogliono conoscere le statistiche
 * @return Restituisce le statistiche
 */
//megghy studia bene questa parte oscura
//
//
//
//ricordatelo!!!!
/**
 * Metodo che calcola il numero di volte che un tweet
 * è stato fatto in quel luogo
 * @param geo Indica il luogo del quale si vuole sapere il numero di tweet
 * @return Restituisce il numero di tweet fatti in quel luogo
 */
public int getfrequenzageo(String geo) {
	int tweetgeo=0;
	for (Tweet t: timeline) {
		if(t.getGeo()==geo)
		{tweetgeo++;}
		return tweetgeo;
	}
}
/**
 * Metodo che calcola il numero di tweet che sono localizzati
 * @return Restituisce il numero di tweet fatti in quel luogo
 */
public int getTweetlocati() {
	int tweetloc=0;
	for (Tweet t: timeline) {
		if(t.getGeo()!=null)
		{tweetloc++;}
		return tweetloc;
	}
}
/**
* Metodo che calcola la frequnza di un determinato luogo
* per un determinato utente
* @param geo Indica il luogo del quale si vuole sapere la frequenza
* @param user Indica l'utente a cui fa riferimento la frequenza
* @return Restituisce il numero di tweet fatti in quel luogo
*/
public int getfrequenzaus(String geo, String user) {
	int cont=0;
	for (Tweet t: timeline) {
		if(t.getUser()==user && t.getGeo()==geo)
		{cont++;}
		return cont;
	}
}
/**
 * Metodo che permette di applicare i filtri specificati sulla timeline
 * @param 
 * @return La timeline (collezione di tweet) filtrata
 */
@Override
public ArrayList<Tweet> campoFiltro(String nomeCampo, String operatoreLogico, Object...value){
	return (ArrayList<Tweet>) utils.select(this.getTimeline(), nomeCampo, operatoreLogico, value);
}
/**
 * Metodo che inserisce il tweet passato come argomento nella timeline
 * @param t tweet da inserire
 */
public void inseriscitweet(Tweet t) {
		timeline.add(t);
	}

/**
 * Costruttore della classe senza passaggio di parametri.
 */
public Timeline() {
	timeline= new ArrayList<Tweet>();
}
}


