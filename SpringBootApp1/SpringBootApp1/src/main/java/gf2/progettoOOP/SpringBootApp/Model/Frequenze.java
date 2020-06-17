package gf2.progettoOOP.SpringBootApp.Model;

/**
 * Classe che modella le frequenze
 * 
 * @author Margherita Galeazzi
 *
 */
public class Frequenze {
	int nvisite = 0;
	String citta;

	/**
	 * Costruttore della classe
	 * 
	 * @param nvisite numero delle volte che si ha twittato dalla citta
	 * @param citta   citta dalla quale e' stato eseguito il tweet
	 */
	public Frequenze(int nvisite, String citta) {
		super();
		this.nvisite = nvisite;
		this.citta = citta;
	}

	/**
	 * Costruttore della classe senza parametri
	 */
	public Frequenze() {
		super();
	}

	/**
	 * Getter che restituisce il numero delle visite
	 * 
	 * @return nvisite numero delle visite
	 */
	public int getNvisite() {
		return nvisite;
	}

	/**
	 * Setter del numero delle visite
	 * 
	 * @param nvisite numero delle visite
	 */
	public void setNvisite(int nvisite) {
		this.nvisite = nvisite;
	}

	/**
	 * Getter che restituisce il nome della citta
	 * 
	 * @return citta nome della citta
	 */
	public String getCitta() {
		return citta;
	}

	/**
	 * Setter del nome della citta
	 * 
	 * @param citta nome della citta
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}

	/**
	 * Metodo che confronta l'uguaglianza tra due frequenze
	 * 
	 * @param f
	 */
	public boolean equals(Frequenze f) {
		if (f == this) {
			return true;
		}
		if (!(f instanceof Frequenze)) {
			return false;
		}
		Frequenze fr = (Frequenze) f;
		return this.citta.equals(fr.citta);
	}
	
	/**
	 * Metodo incrementa di 1 il numero delle visite
	 *
	 */
	public void incrementaNvisite() {
		nvisite++;
		return;		
	}

	public int hashCode() {
		return citta.hashCode();
	}




}