package gf2.progettoOOP.SpringBootApp.Service;

import java.util.ArrayList;

import gf2.progettoOOP.SpringBootApp.Model.*;

/**
 * Classe che funge da caricatore per i metadati
 * 
 * @author Margherita Galeazzi
 *
 */
public class caricatoreMetadati {
	public static ArrayList<Metadata> metadata = new ArrayList<Metadata>();

	/**
	 * Metodo che carica tutti i metadati in un ArrayList di metadati
	 * 
	 * @return un ArrayList di metadati
	 */
	public static ArrayList<Metadata> getMetadata() {
		metadata.add(new Metadata("created_at", "Data e ora di creazione del Tweet", "String"));
		metadata.add(new Metadata("text", "Testo del Tweet", "String"));
		metadata.add(new Metadata("id", "Numero identificativo del Tweet", "long"));
		metadata.add(new Metadata("name_user", "Nome dell'utente che ha twittato", "String"));
		metadata.add(new Metadata("screen_name", "Nome,su schermo, dell'utente che ha twittato", "String"));
		metadata.add(new Metadata("location_user", "Luogo dell'utente", "String"));
		metadata.add(new Metadata("id_user", "Numero identificativo dell'utente", "String"));

		return metadata;
	}
}
