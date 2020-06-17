package gf2.progettoOOP.SpringBootApp.Model;

/**
 * Classe che modella i tweet
 * @author Margherita Galeazzi
 *
 */
public class Tweet {
	private String created_at;
	private String text;
	private long id;
	private String name_user;
	private String screen_name;
	private String location_user;
	private String id_user;
	
	
	/**
	 * Costruttore della classe senza parametri
	 */
	public Tweet() {
		super();
	}

/**
 * Costruttore della classe con passaggio dei parametri
 * @param created_at indica la data di creazione del tweet
 * @param text corrisponde al testo del tweet
 * @param id corrisponde all'id del tweet
 * @param user contiene i dati riguardanti l'utente
 * @param name_user   nome dell'utente
 * @param screen_name nome nome dell'utente "a video"
 * @param id_user     id dell'utente
 * @param location_user     location del post
 */
	public Tweet(String created_at, String text, int id, String name_user, String screen_name, String id_user,String location_user) {
		super();
		this.created_at = created_at;
		this.text = text;
		this.id = id;
		this.name_user = name_user;
		this.screen_name = screen_name;
		this.id_user = id_user;
		this.location_user=location_user;
			}

/**
 * Getter che restituisce la data di creazione
 * @return created_at data di creazione
 */
	public String getCreated_at() {
		return created_at;
	}

/**
 * Setter che permette di settare la data di creazione
 * @param created_at data di creazione
 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

/**
 * Getter che restituisce il testo del tweet
 * @return text testo del tweet
 */
	public String getText() {
		return text;
	}

/**
 * Setter che permette di settare il testo del tweeet
 * @param text testo del tweet
 */
	public void setText(String text) {
		this.text = text;
	}

/**
 * Getter che restituisce l'id del tweet
 * @return id id del tweet
 */
	public long getId() {
		return id;
	}

/**
 * Setter che permette di settare l'id del tweet
 * @param l id del tweet
 */
	public void setId(long l) {
		this.id = l;
	}

	/**
	 * Getter che restituisce il nome dell'utente
	 * 
	 * @return name_user nome dell'utente
	 */
	public String getName_user() {
		return name_user;
	}

	/**
	 * Setter che permette di settare il nome dell'utente
	 * 
	 * @param name_user nome dell'utente
	 */
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}

	/**
	 * Getter che restituisce il nome "a video" dell'utente
	 * 
	 * @return screen_name nome "a video" dell'utente
	 */
	public String getScreen_name() {
		return screen_name;
	}

	/**
	 * Setter che permette di settare il nome "a video" dell'utente
	 * 
	 * @param screen_name nome "a video" dell'utente
	 */
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	/**
	 * Getter che restituisce l'id dell'utente
	 * 
	 * @return id_user id dell'utente
	 */
	public String getId_user() {
		return id_user;
	}

	/**
	 * Setter che permette di settare l'id dell'utente
	 * 
	 * @param id_user id dell'utente
	 */
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	/**
	 * Getter che restituisce la location dell'utente
	 * 
	 * @return location_user location dell'utente
	 */
	public String getLocation_user() {
		return location_user;
	}

	/**
	 * Setter che permette di settare la location dell'utente
	 * 
	 * @param location_user location dell'utente
	 */
	public void setLocation_user(String location_user) {
		this.location_user = location_user;
	}

}


	


