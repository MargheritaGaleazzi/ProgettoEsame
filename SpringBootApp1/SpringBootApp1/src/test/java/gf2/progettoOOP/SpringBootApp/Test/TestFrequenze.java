package gf2.progettoOOP.SpringBootApp.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gf2.progettoOOP.SpringBootApp.Model.Frequenze;
import gf2.progettoOOP.SpringBootApp.Model.Tweet;
import gf2.progettoOOP.SpringBootApp.Utils.JSONParser;
import gf2.progettoOOP.SpringBootApp.Utils.Statistiche;

/**
 * Classe di test per verificare il corretto funzionamento 
 * del metodo per calcolare le frequenze 
 * 
 * @author Margherita Galeazzi
 *
 */

class TestFrequenze {
	
	ArrayList<Tweet> tmln = new ArrayList<Tweet>();
	String s1 = new String();

	@BeforeEach
	void setUp() throws Exception {
		
		s1="[{\"created_at\":\"01.01.2020\",\"text\":\"prova testo 1\",\"id\":11111,\"user\":{\"name\":\"Guido Bianchi\",\"screen_name\":\"gbianchi11\",\"id_str\":\"11111\",\"location\":\"Ancona\"}},{\"text\":\"prova testo 2\",\"id\":22222,\"user\":{\"name\":\"Mario Rossi\",\"location\":\"Falconara\"}},{\"created_at\":\"03.03.2020\",\"text\":\"prova testo 3\",\"id\":33333,\"user\":{\"name\":\"Luigi Verdi\",\"screen_name\":\"lverdi33\",\"id_str\":\"33333\",\"location\":\"Ancona\"}},{\"created_at\":\"01.01.2020\",\"text\":\"prova testo 1\",\"id\":11111,\"user\":{\"name\":\"Guido Bianchi\",\"screen_name\":\"gbianchi11\",\"id_str\":\"11111\",\"location\":\"\"}}]";
		 tmln= JSONParser.parsaJson((JSONArray) JSONValue.parse(s1));
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		ArrayList<Frequenze> arrayfreq = new ArrayList<Frequenze>();
		arrayfreq = Statistiche.freqLocUt(tmln);
		
		Frequenze f1= arrayfreq.get(0);
		assertEquals(2,f1.getNvisite());
		assertEquals("Ancona",f1.getCitta());
		
	    Frequenze f2= arrayfreq.get(1);
		assertEquals(1,f2.getNvisite());
		assertEquals("Falconara",f2.getCitta());
		
		Frequenze f3= arrayfreq.get(2);
		assertEquals(1,f3.getNvisite());
		assertEquals("Location Ignota",f3.getCitta());

	}

}
