package gf2.progettoOOP.SpringBootApp.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import gf2.progettoOOP.SpringBootApp.Model.*;
import gf2.progettoOOP.SpringBootApp.Utils.*;

/**
 * Classe che implementa i metodi dell'interfaccia TweetService
 * 
 * @see TweetService
 * @author Margherita Galeazzi
 *
 */
@Service
public class TweetServiceImpl implements TweetService {
	private Map<Long, Tweet> timeline = new HashMap<>();
	private Map<String, Metadata> metadata = new HashMap<>();
	private ModelloStatistiche mod = caricatoreStatistiche.getStats();

	public TweetServiceImpl() {
		try {
			ArrayList<Tweet> twe = JSONParser.parsaJson(JSONDownloader.JSONDownloadato());
			for (int i = 0; i < twe.size(); i++) {
				Tweet tw = twe.get(i);
				timeline.put((long) tw.getId(), tw);
			}
			ArrayList<Metadata> data = caricatoreMetadati.getMetadata();
			for (int i = 0; i < data.size(); i++) {
				Metadata met = data.get(i);
				metadata.put(met.getNome(), met);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Collection<Tweet> getTweet() {
		return timeline.values();
	}

	@Override
	public Collection<Metadata> getMetada() {
		return metadata.values();
	}

	@Override
	public ModelloStatistiche getStats() {
		return mod;
	}

}
