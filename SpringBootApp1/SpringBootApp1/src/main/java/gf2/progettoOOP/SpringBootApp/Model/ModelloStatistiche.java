package gf2.progettoOOP.SpringBootApp.Model;

/**
 * Classe che modella le statistiche
 * 
 * @author Margherita Galeazzi
 *
 */
public class ModelloStatistiche {
	private int tweloc;

	/**
	 * Costruttore della classe senza parametri
	 */
	public ModelloStatistiche() {
		super();
	}

	/**
	 * Getter che restituisce il numero di tweet con location diversa da null
	 * 
	 * @return tweloc numero di tweet con location
	 */
	public int getTweloc() {
		return tweloc;
	}

	/**
	 * Setter che permette di settare il numero di tweet con location
	 * 
	 * @param tweloc
	 */
	public void setTweloc(int tweloc) {
		this.tweloc = tweloc;
	}

}
