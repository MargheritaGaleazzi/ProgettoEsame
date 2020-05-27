package gf.progettoesame.SpringBootApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gf.progettoesame.SpringBootApp.model.Tweet;
import gf.progettoesame.SpringBootApp.service.TweetService;

@RestController
public class TweetController {
	@Autowired
	TweetService tweetService;

	// ottieni tutti i tweet
	@RequestMapping(value = "/tweets")
	public ResponseEntity<Object> getTweet() {
		return new ResponseEntity<>(tweetService.getTweets(), HttpStatus.OK);
	}

	// modifica un tweet
	@RequestMapping(value = "/tweets/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> aggiornaTweet(@PathVariable("id") int id, @RequestBody Tweet tweet) {
		tweetService.aggiornaTweet(id, tweet);
		return new ResponseEntity<>("Il tweet è stato correttamente aggiornato", HttpStatus.OK);
	}

	// cancella un tweet
	@RequestMapping(value = "/tweets/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
		tweetService.cancellaTweet(id);
		return new ResponseEntity<>("Il tweet è stato cancellato", HttpStatus.OK);
	}

	// crea un nuovo tweet
	@RequestMapping(value = "/tweets", method = RequestMethod.POST)
	public ResponseEntity<Object> creaTweet(@RequestBody Tweet tweet) {
		tweetService.creaTweet(tweet);
		return new ResponseEntity<>("Il tweet è stato creato con successo", HttpStatus.CREATED);
	}
}
	
	
