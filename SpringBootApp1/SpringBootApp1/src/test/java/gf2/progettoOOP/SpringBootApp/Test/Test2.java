package gf2.progettoOOP.SpringBootApp.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.json.simple.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gf2.progettoOOP.SpringBootApp.Model.*;
import gf2.progettoOOP.SpringBootApp.Utils.*;

/**
 * Classe di test per verificare il corretto funzionamento 
 * del parser di Json 
 * 
 * @author Margherita Galeazzi
 *
 */
class Test2 {
	

	ArrayList<Tweet> tmln = new ArrayList<Tweet>();
	String s1 = new String();

	@BeforeEach
	void setUp() throws Exception {
		s1="[{\"created_at\":\"01.01.2020\",\"CAMPO INUTILE 1\":99999,\"text\":\"prova testo 1\",\"id\":11111,\"CAMPO INUTILE 2\":\"99999\",\"user\":{\"name\":\"Guido Bianchi\",\"screen_name\":\"gbianchi11\",\"CAMPO INUTILE 3\":99999,\"id_str\":\"11111\",\"location\":\"Ancona\"}},{\"text\":\"prova testo 2\",\"id\":22222,\"user\":{\"name\":\"Mario Rossi\",\"location\":\"Falconara\"}},{\"created_at\":\"03.03.2020\",\"text\":\"prova testo 3\",\"id\":33333,\"user\":{\"name\":\"Luigi Verdi\",\"screen_name\":\"lverdi33\",\"id_str\":\"33333\",\"location\":\"\"}}]";
		
		 tmln= JSONParser.parsaJson((JSONArray) JSONValue.parse(s1));
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	
	@Test
	void test1() {
		
		
		Tweet t1=tmln.get(0);
				
		assertAll("valori", ()->assertEquals("01.01.2020",t1.getCreated_at()),
		()->assertEquals("prova testo 1",t1.getText()),
		()->assertEquals(11111,t1.getId()),
		()->assertEquals("Guido Bianchi",t1.getName_user()),
		()->assertEquals("gbianchi11",t1.getScreen_name()),
		()->assertEquals("11111",t1.getId_user()),
		()->assertEquals("Ancona",t1.getLocation_user()));
		}

	
		@Test
	void test2() {
		
		
		Tweet t2=tmln.get(1);
				
		assertAll("valori", ()->assertEquals(null,t2.getCreated_at()),
		()->assertEquals("prova testo 2",t2.getText()),
		()->assertEquals(22222,t2.getId()),
		()->assertEquals("Mario Rossi",t2.getName_user()),
		()->assertEquals(null,t2.getScreen_name()),
		()->assertEquals(null,t2.getId_user()),
		()->assertEquals("Falconara",t2.getLocation_user()));

	
	}
@Test
void test3() {
	
	
	Tweet t3=tmln.get(2);
			
	assertAll("valori", ()->assertEquals("03.03.2020",t3.getCreated_at()),
	()->assertEquals("prova testo 3",t3.getText()),
	()->assertEquals(33333,t3.getId()),
	()->assertEquals("Luigi Verdi",t3.getName_user()),
	()->assertEquals("lverdi33",t3.getScreen_name()),
	()->assertEquals("33333",t3.getId_user()),
	()->assertEquals("Location Ignota",t3.getLocation_user()));
}}


