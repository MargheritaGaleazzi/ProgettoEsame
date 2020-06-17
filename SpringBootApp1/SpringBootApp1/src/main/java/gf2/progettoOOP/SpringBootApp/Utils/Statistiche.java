package gf2.progettoOOP.SpringBootApp.Utils;

import java.util.ArrayList;

import gf2.progettoOOP.SpringBootApp.Model.*;

/**
 * Classe con i metodi per fare i calcoli necessari per restituire le
 * statistiche
 * 
 * @author Margherita Galeazzi
 *
 */
public class Statistiche {

	 
	/**
	 * Metodo che conta i tweet che hanno location diversa da null
	 * 
	 * @param twe ArrayList contenente i tweet da "controllare"
	 * @return numero dei tweet con location
	 */
	static public int contaLocation(ArrayList<Tweet> twe) {
		int contatore_location=0;
		for (Tweet t : twe) {
			if (!t.getLocation_user().equals("Location Ignota")) {
				contatore_location++;
			}
		}
		return contatore_location;
	}

	/**
	 * Metodo che conta la frequenza per ogni citta' 
	 * 
	 * @param twe Array di tweet da "controllare"
	 * @return un Array di frequenze
	 * @see Frequenze
	 */
	static public ArrayList<Frequenze> freqLocUt(ArrayList<Tweet> twe) {
		ArrayList<Frequenze> arrayfrequenze = new ArrayList<Frequenze>();
		
		
		for (Tweet t : twe) {
			Frequenze f = new Frequenze();
			f.setNvisite(0);
			f.setCitta(t.getLocation_user());
			if (arrayfrequenze.isEmpty()) {
				f.incrementaNvisite();
				arrayfrequenze.add(f);
			}
			
			else {

				boolean flag=true;
				int i=0;
				while (i<arrayfrequenze.size()&&flag) {
					
					if (f.getCitta().equals(arrayfrequenze.get(i).getCitta()))
					{
						arrayfrequenze.get(i).incrementaNvisite(); 
						flag=false;
						}
					
					else if (i<arrayfrequenze.size()-1) {i++;}
					else {arrayfrequenze.add(f);}
						
					
				}}}	
				
	

		return arrayfrequenze;
	
}}