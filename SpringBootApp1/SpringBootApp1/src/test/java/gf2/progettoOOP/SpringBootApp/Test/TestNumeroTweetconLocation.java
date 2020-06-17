package gf2.progettoOOP.SpringBootApp.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gf2.progettoOOP.SpringBootApp.Utils.*;
import gf2.progettoOOP.SpringBootApp.Model.*;

/**
 * Classe di test per verificare il corretto funzionamento 
 * del metodo per calcolare il numero di tweet con location
 * 
 * @author Margherita Galeazzi
 *
 */

class TestNumeroTweetconLocation {
	
	ArrayList<Tweet> tmln = new ArrayList<Tweet>();
	String s1 = new String();
	Frequenze freq = new Frequenze();

	@BeforeEach
	void setUp() throws Exception {
		s1="[{\"created_at\":\"01.01.2020\",\"CAMPO INUTILE 1\":99999,\"text\":\"prova testo 1\",\"id\":11111,\"CAMPO INUTILE 2\":\"99999\",\"user\":{\"name\":\"Guido Bianchi\",\"screen_name\":\"gbianchi11\",\"CAMPO INUTILE 3\":99999,\"id_str\":\"11111\",\"location\":\"Ancona\"}},{\"text\":\"prova testo 2\",\"id\":22222,\"user\":{\"name\":\"Mario Rossi\",\"location\":\"Falconara\"}},{\"created_at\":\"03.03.2020\",\"text\":\"prova testo 3\",\"id\":33333,\"user\":{\"name\":\"Luigi Verdi\",\"screen_name\":\"lverdi33\",\"id_str\":\"33333\",\"location\":\"\"}}]";
	
		 tmln= JSONParser.parsaJson((JSONArray) JSONValue.parse(s1));
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertEquals(2,Statistiche.contaLocation(tmln));
	}

}
