package gf2.progettoOOP.Service;
import org.springframework.stereotype.Service;

import gf2.progettoOOP.Model.Tweet;
import gf2.progettoOOP.Utils.Filtro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


@Service
public abstract class TweetServiceImpl implements TweetService {
	private static Map<Integer, Tweet> timeline=new HashMap<>();	

@Override
public void creaTweet(Tweet tweet) {
	timeline.put(tweet.getId(),tweet);	
}

@Override
public Collection<Tweet> getTweets() {
return timeline.values();
}
@Override
public int getfrequenzageo(Collection<Tweet> twe,String geo){
	ArrayList<Tweet> mytweets=(ArrayList<Tweet>) twe;
	int tweetgeo=0;
	for (Tweet t: mytweets) {
		if(t.getGeo()==geo)
		{tweetgeo++;}
	}
	return tweetgeo;
}

@Override
public int getTweetlocati(Collection<Tweet> twe) {
	ArrayList<Tweet> mytweets=(ArrayList<Tweet>) twe;
	int tweetloc=0;
	for (Tweet t: mytweets) {
		if(t.getGeo()!=null)
		{tweetloc++;}}
	return tweetloc;
}
@Override
public int getfrequenzaus(Collection<Tweet> twe,String geo, String user) {
	ArrayList<Tweet> mytweets=(ArrayList<Tweet>) twe;
	int cont=0;
	for (Tweet t: mytweets) {
		if(t.getUser()==user && t.getGeo()==geo)
		{cont++;}
	}
	return cont;
}
@Override
public Collection<Tweet> tweetFiltrati(Collection<Tweet> twe,Filtro filtro) {
	// TODO Auto-generated method stub
	return null;
}
}

