package gf.progettoesame.SpringBootApp.model;

import com.fasterxml.jackson.annotation.*;

/**
 * La classe tweet modella un singolo tweet della timeline
 * @author mgale
 *
 */
public class Tweet {
	/**
	 * Data di creazione del tweet
	 */
	@JsonPropertyDescription("Data di pubblicazione del tweet")
	private String created_at;
	
	/**
	 * id del tweet considerato
	 */
	@JsonPropertyDescription("id del tweet")
	private int id;
	
	/**
	 * localizzazione del tweet(luogo nel quale è stato fatto)
	 */
	@JsonPropertyDescription ("Localizzazione del tweet")
	private Object geo;
	
	/**
	 * nome dell'utente
	 */
	@JsonPropertyDescription ("nome dell'utente")
	private Object user;
	
	/**
	 * Costruttore della classe che inizializza l'oggetto.
	 * @param created_at
	 * @param id
	 * @param geo
	 * @param user
	 */
	public Tweet(String created_at, int id, String geo, String user) {
		this.created_at = created_at;
		this.id = id;
		this.geo = geo;
		this.user=user;
	}

	/**
	 * Costruttore della classe senza passaggio di parametri.
	 */
	public Tweet() {
	}
	
/**
 * Metodo che restituisce la data di creazione
 * @return data di crazione del tweet
 */
	public String getCreated_at() {
		return created_at;
	}

/**
 * Metodo che ti permette di settare la data di creazione
 * @param created_at
 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

/**
 * Metodo che restituisce l'id del tweet
 * @return id del tweet
 */
	public int getId() {
		return id;
	}

/**
 * Metodo che ti permette di settare l'id del tweet
 * @param id
 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Metodo che restituisce la localizzazione del tweet
	 * @return localizzazione del tweet
	 */
	public Object getGeo() {
		return geo;
	}

	/**
	 * Metodo che ti permette di settare la localizzazione del tweet
	 * @param geo
	 */
	public void setGeo(Object geo) {
		this.geo = geo;
	}
	
	/**
	 * Metodo che restituisce il nome dell'utente che ha fatto il tweet
	 * @return nome dell'utente
	 */
	public Object getUser() {
		return user;
	}

	/**
	 * Metodo che ti permette di settare il nome dell'utente che ha fatto il tweet
	 * @param user
	 */
	public void setUser(Object user) {
		this.user = user;
	}
	
	public void stampaInfoTweet(){
		System.out.println(this.getCreated_at());
		System.out.println(this.getId());
		System.out.println(this.getGeo());
	}

}
