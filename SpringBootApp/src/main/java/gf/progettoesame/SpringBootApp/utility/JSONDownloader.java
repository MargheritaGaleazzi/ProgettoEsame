package gf.progettoesame.SpringBootApp.utility;

import java.io.*;
import java.net.*;
import org.json.*;

import gf.progettoesame.SpringBootApp.model.Timeline;
import gf.progettoesame.SpringBootApp.model.Tweet;

/**
 * Classe che mette a disposizione i metodi per recuperare le infomazioni da un JSON
 * scaricato da un URL
 */
public class JSONDownloader {
	
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
	 */
	public static Timeline parsaJson(JSONObject json) {
		Timeline timelinee = new Timeline();
		if(json!=null){
			 
			  JSONArray dataset = json.optJSONArray("timeline");
			  if(dataset!=null){
				  
				  
				  
			   for(int i=0; i<dataset.length(); i++){
				JSONObject tweet = dataset.optJSONObject(i);
				
			 
			    Tweet tw1=new Tweet();
			    tw1.setCreated_at(tweet.optString("created_at"));
			    tw1.setId(tweet.optInt("id"));
			    tw1.setGeo(tweet.opt("geo"));
			    tw1.setUser(tweet.opt("user"));
			    timelinee.inseriscitweet(tw1);
			   }
			   }}
		return timelinee;
	}
}
