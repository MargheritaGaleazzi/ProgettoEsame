package gf2.progettoOOP.SpringBootApp.Model;

/**
 * Classe che modella i metadati
 * 
 * @author Margherita Galeazzi
 *
 */
public class Metadata {
	String nome;
	String descrizione;
	String tipo;

	/**
	 * Costruttore della classe
	 * 
	 * @param nome        nome del metadato
	 * @param descrizione descrizione del metadato
	 * @param tipo        tipologia del metadato
	 */
	public Metadata(String nome, String descrizione, String tipo) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.tipo = tipo;
	}

	/**
	 * Getter che restituisce il nome del metadato
	 * 
	 * @return nome nome del metadato
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Getter che restituisce la descrizione del metadato
	 * 
	 * @return descrizione descrizione del metadato
	 */
	public String getDescrizione() {
		return descrizione;
	}

	/**
	 * Getter che restituisce la tipologia del metadato
	 * 
	 * @return tipologia del metadato
	 */
	public String getTipo() {
		return tipo;
	}
}
