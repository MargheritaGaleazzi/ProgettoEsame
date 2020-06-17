package gf2.progettoOOP.SpringBootApp.Service;

import gf2.progettoOOP.SpringBootApp.Model.*;
import gf2.progettoOOP.SpringBootApp.Utils.*;

/**
 * Classe che funge da caricatore per le statistiche
 * 
 * @author Margherita Galeazzi
 *
 */
public class caricatoreStatistiche {
	static ModelloStatistiche stat = new ModelloStatistiche();
	static Statistiche statistica = new Statistiche();

	/**
	 * Metodo che carica tutte le statistiche in un oggetto di tipo
	 * ModelloStatistiche
	 * 
	 * @see ModelloStatistiche
	 * @return un oggetto di tipo ModelloStatistiche
	 */
	public static ModelloStatistiche getStats() {
		stat.setTweloc(Statistiche.contaLocation(JSONParser.parsaJson(JSONDownloader.JSONDownloadato())));
		return stat;
	}

}
