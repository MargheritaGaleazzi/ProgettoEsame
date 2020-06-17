package gf2.progettoOOP.SpringBootApp.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import gf2.progettoOOP.SpringBootApp.Model.*;

/**
 * Classe di test per verificare il corretto funzionamento 
 * della classe Tweet
 * 
 * @author Margherita Galeazzi
 *
 */
class TestTweet {
	
	private Tweet t1, t2;
    
	@BeforeEach
void setUp() throws Exception {
		
		t1=new Tweet("01.01.2020","prova testo 1",1223334444, "Mario Rossi","m_rossi45","1234","Fano");
		t2=new Tweet("02.02.2020","prova testo 2",1020304050, "Guido Bianchi","gbianchi98","12345","Pesaro");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		assertEquals("01.01.2020",t1.getCreated_at());
		assertEquals("prova testo 1",t1.getText());
		assertEquals(1223334444,t1.getId());
		assertEquals("Mario Rossi",t1.getName_user());
		assertEquals("m_rossi45",t1.getScreen_name());
		assertEquals("1234",t1.getId_user());
		assertEquals("Fano",t1.getLocation_user());

	}
	
	@Test
	void test2() {
		assertAll("valori", ()->assertEquals("02.02.2020",t2.getCreated_at()),
		()->assertEquals("prova testo 2",t2.getText()),
		()->assertEquals(1020304050,t2.getId()),
		()->assertEquals("Guido Bianchi",t2.getName_user()),
		()->assertEquals("gbianchi98",t2.getScreen_name()),
		()->assertEquals("12345",t2.getId_user()),
		()->assertEquals("Pesaro",t2.getLocation_user()));

	}
}

