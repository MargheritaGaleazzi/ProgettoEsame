package gf2.progettoOOP.Controller;
import java.util.HashMap;

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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

import gf2.progettoOOP.Model.Tweet;
import gf2.progettoOOP.Service.TweetService;

@RestController
public class TweetController {
	@Autowired
	TweetService tweetService;

	// ottieni tutti i tweet
	@RequestMapping(value = "/tweets")
	public ResponseEntity<Object> getTweet() {
		return new ResponseEntity<>(tweetService.getTweets(), HttpStatus.OK);
	}
	
	/**
     * Rotta che mostra i metadati relativi ad ogni oggetto presente nel dataset
     * @return Restituisce i metadati sotto forma di JSON
     */
    @RequestMapping(value = "/metadata", method = RequestMethod.GET, produces="application/json")
    String getMetadata(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonSchemaGenerator schemaGen = new JsonSchemaGenerator(mapper);
            JsonSchema schema = schemaGen.generateSchema(Tweet.class);
            return mapper.writeValueAsString(schema);
        } catch (Exception e){
        	return makeErrorMessage("Si è verificato un errore imprevisto");
        }
    }
    /**
     * Metodo che consente di mostrare un messaggio di errore personalizzato sotto forma di JSON
     * @param message Testo da mostrare nel messaggio di errore
     * @return Restituisce il JSON contenente l'errore
     */
 private String makeErrorMessage(String message) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, String> result = new HashMap<>();
          result.put("error", message);
            return mapper.writeValueAsString(result);
       } catch (Exception e) {
            e.printStackTrace();
       }
        return null;
    }


	// modifica un tweet
//	@RequestMapping(value = "/tweets/{id}", method = RequestMethod.PUT)
//	public ResponseEntity<Object> aggiornaTweet(@PathVariable("id") int id, @RequestBody Tweet tweet) {
//		tweetService.aggiornaTweet(id, tweet);
//		return new ResponseEntity<>("Il tweet è stato correttamente aggiornato", HttpStatus.OK);
//	}

	// cancella un tweet
//	@RequestMapping(value = "/tweets/{id}", method = RequestMethod.DELETE)
//	public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
	//	tweetService.cancellaTweet(id);
//		return new ResponseEntity<>("Il tweet è stato cancellato", HttpStatus.OK);
	//}

	// carica i tweet un nuovo tweet
//	@RequestMapping(value = "/tweets", method = RequestMethod.POST)
	//public ResponseEntity<Object> creaTweet(@RequestBody Tweet tweet) {
	//	tweetService.creaTweet(tweet);
	//	return new ResponseEntity<>("Il tweet è stato creato con successo", HttpStatus.CREATED);
	//}
}