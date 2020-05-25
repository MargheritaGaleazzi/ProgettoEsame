package gf.progettoesame.SpringBootApp.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Service;

import gf.progettoesame.SpringBootApp.model.Tweet;
@Service
public class TweetServiceImpl implements TweetService {
	private static Map<Integer, Tweet> timeline=new HashMap<>();
	
	
@Override
public void aggiornaTweet(Integer id, Tweet tweet) {
	timeline.remove(id);
	tweet.setId(id);
	timeline.put(id, tweet);
}

@Override
public void creaTweet(Tweet tweet) {
	timeline.put(tweet.getId(),tweet);	
}

@Override
public void cancellaTweet(Integer id) {
	timeline.remove(id);	
}

@Override
public Collection<Tweet> getTweets() {
return timeline.values();
}
}
