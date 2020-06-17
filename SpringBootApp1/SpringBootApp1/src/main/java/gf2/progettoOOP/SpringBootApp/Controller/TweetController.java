package gf2.progettoOOP.SpringBootApp.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import gf2.progettoOOP.SpringBootApp.Exception.ArgomentoErratoException;
import gf2.progettoOOP.SpringBootApp.Exception.FiltroInesistenteException;
import gf2.progettoOOP.SpringBootApp.Model.Frequenze;
import gf2.progettoOOP.SpringBootApp.Model.Tweet;
import gf2.progettoOOP.SpringBootApp.Service.*;
import gf2.progettoOOP.SpringBootApp.Utils.Statistiche;

/**
 * Classe che garantisce la gestione di tutte le chiamate al Server permesse al
 * Client
 * 
 * @author Margherita Galeazzi
 *
 */
@RestController
public class TweetController {
	@Autowired
	private TweetServiceImpl tweetService;

	
	/**
	 * Rotta che mostra tutti i tweet presenti nel JSON scaricato
	 * 
	 * @return Restituisce tutti i tweet scaricati in formato JSON
	 */
	@RequestMapping(value = "/data", method = RequestMethod.GET)
	public ResponseEntity<Object> getTweets() {
		
		return new ResponseEntity<>(tweetService.getTweet(), HttpStatus.OK);
	}

	/**
	 * Rotta che mostra i metadati relativi ad ogni tweet presente nella timeline
	 * 
	 * @return Restituisce i metadati sotto forma di JSON
	 */
	@RequestMapping(value = "/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata() {
		return new ResponseEntity<>(tweetService.getMetada(), HttpStatus.OK);
	}

	/**
	 * Rotta che permette di calcolare il numero di tweet che hanno la location
	 * 
	 * @return Restituisce il numero di tweet con location sotto forma di JSON
	 */
	@RequestMapping(value = "/stat", method = RequestMethod.GET)
	public ResponseEntity<Object> getStats() {
		return new ResponseEntity<>(tweetService.getStats(), HttpStatus.OK);
	}

	/**
	 * Rotta che permette di calcolare la frequenza dei luoghi
	 * 
	 * @param filter Filtri eventuali che si vogliono applicare sull'insieme dei
	 *               tweet prima di calcolare le statistiche
	 * @return Restituisce la frequenza delle varie location
	 * @throws FiltroInesistenteException eccezione lanciata se il filtro non esiste
	 * @throws ArgomentoErratoException   eccezione lanciata se l'argomento passato
	 *                                    e' errato
	 * @throws Exception
	 */
	@RequestMapping(value = "/stat", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Frequenze>> getStats(@RequestBody Object filter)
			throws FiltroInesistenteException, ArgomentoErratoException, Exception {
		ArrayList<Frequenze> fre = new ArrayList<Frequenze>();
		ArrayList<Tweet> filteredArray = CO.COColumn(filter);
		

		fre = Statistiche.freqLocUt(filteredArray);

		return new ResponseEntity<>(fre, HttpStatus.CREATED);
	}

	/**
	 * Rotta che permette di filtrare la timeline
	 * 
	 * @param filter filtro che si vuole applicare
	 * @returnun ArrayList di tweet filtrato
	 * @throws FiltroInesistenteException eccezione lanciata se il filtro non esiste
	 * @throws ArgomentoErratoException   eccezione lanciata se l'argomento passato
	 *                                    e' errato
	 * @throws Exception
	 */
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public ResponseEntity<ArrayList<Tweet>> getFilteredTweets(@RequestBody Object filter)
			throws FiltroInesistenteException, ArgomentoErratoException, Exception {
		return new ResponseEntity<>(CO.COColumn(filter), HttpStatus.CREATED);
	}
}
