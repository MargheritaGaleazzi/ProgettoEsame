package gf2.progettoOOP.SpringBootApp.Utils;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import gf2.progettoOOP.SpringBootApp.Model.Tweet;


/**
 * Classe che permette di trasformare il JSON scaricato in un oggetto di tipo
 * Tweet
 * 
 * @see Tweet
 * @author Margherita Galeazzi
 *
 */
public class JSONParser {
	/**
	 * Metodo che parsa il JSON in un oggetto di tipo Tweet
	 * 
	 * @see Tweet
	 * @param jsonArray JSON array da parsare
	 * @return un Array di oggetti di tipo Tweet
	 */
	public static ArrayList<Tweet> parsaJson(JSONArray jsonArray) {

		ArrayList<Tweet> ttt = new ArrayList<Tweet>();

		for (int i = 0; i < jsonArray.size(); i++) {
			Tweet t = new Tweet();
			JSONObject ogg = (JSONObject) jsonArray.get(i);
			t.setCreated_at((String) ogg.get("created_at"));
			t.setText((String) ogg.get("text"));
			t.setId((long) ogg.get("id"));

			JSONObject ut = (JSONObject) ogg.get("user");
			t.setId_user((String) ut.get("id_str"));
			t.setName_user((String) ut.get("name"));
			t.setScreen_name((String) ut.get("screen_name"));
		
			
			if (ut.get("location").equals("")) {
				t.setLocation_user("Location Ignota");
				}
			else {t.setLocation_user((String) ut.get("location"));
				}

			ttt.add(t);
		}

		return ttt;
	}
}
