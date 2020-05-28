package gf2.progettoOOP.Utils;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.*;

import gf2.progettoOOP.Model.Tweet;

/**
 * Classe che mette a disposizione i metodi per recuperare le infomazioni da un JSON
 * scaricato da un URL, elaborarle, creare altri JSON che ci servono...
 */


public class JSONHelper {
	
	/**
     * Metodo che riceve un URL che si riferisce ad un JSON
     * lo scarica e lo "trasforma" in un JSONObject
     * @param url URL dell JSON
     * @return Restituisce il JSON object
	 * @throws JSONException 
     * @throws IOException Errore che viene lanciato per problemi nell'I/O
     */
	public static JSONObject JSONDownloadato() throws JSONException {
		
		String data="";
		String line="";
		String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/statuses/home_timeline.json?count=100";
		
		try {
	        //establishes a connection
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			
			InputStream in= openConnection.getInputStream();
			

			try {
				InputStreamReader inR=new InputStreamReader(in);
				BufferedReader buf= new BufferedReader(inR);
				
				while ((line=buf.readLine())!= null) {
					data+=line;
				}
			}finally {
				in.close();
			}
			
	} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	JSONObject json=new JSONObject("{\"timeline\":"+data.toString()+"}");
	return json;
	}
	
	/**
	 * Metodo che parsa il JSON che gli viene passato
	 * @param json Oggetto JSON da parsare
	 * @return timelinee che è un array di tweet
	 */
	public static ArrayList<Tweet> parsaJson(JSONObject json) {
		ArrayList<Tweet> timelinee = new ArrayList<Tweet>();
		if(json!=null){
			 
			  JSONArray dataset = json.optJSONArray("timeline");
			  if(dataset!=null){
				    
			   for(int i=0; i<dataset.length(); i++){
				JSONObject tweet = dataset.optJSONObject(i);
				JSONObject user = tweet.getJSONObject("user");//è un sottoggetto del tweet
				
			    Tweet tw1=new Tweet();
			    tw1.setCreated_at(tweet.optString("created_at"));
			    tw1.setId(tweet.optInt("id"));
			    tw1.setGeo(tweet.opt("geo"));
			    tw1.setUser(user.opt("screen_name"));
			    timelinee.add(tw1);
			   }
			   }}
		return timelinee;
	}
	/**
	 * Metodo che stampa su file JSON appena ottenuto
	 */
	public void toJsonData(JSONArray dataset) {
		final String stampa1="datasetinizio.json";
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter(stampa1));
			for(int i=0; i<dataset.length(); i++){
				JSONObject tweet = dataset.optJSONObject(i);
				w.write(tweet.toString());

			}
			w.newLine();
			w.close(); // close the BuffreWriter

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * Metodo che stampa su file JSON il tipo dei dati
	 */
	public void toJsonMetaData(JSONObject obj) {
		final String stampa2="metadata.json";
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter(stampa2));
			w.write("{\n");
			String type=" ";
			Iterator<String> keys = obj.keys();//tutte le chiavi
			while (keys.hasNext()) {                      //finchè c'è un altra chiave
			      String key = keys.next();               //prendo il nome della chiave
			      Object value = obj.get(key);           
			      if (value.getClass()==Integer.class) 
			    	  type="Integer";
			      else type="String";
			      System.out.println(key + " : " + value);//print key : value
		
				w.write("\""+key+"\":"+" "+"\""+type+"\", \n");
			w.newLine();
			w.close(); // close the BuffreWriter

		}}catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
