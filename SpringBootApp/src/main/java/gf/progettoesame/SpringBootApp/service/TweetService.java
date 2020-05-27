package gf.progettoesame.SpringBootApp.service;

import java.util.Collection;

import gf.progettoesame.SpringBootApp.model.Tweet;
public interface TweetService {
	public abstract void creaTweet(Tweet tweet);
	public abstract void aggiornaTweet(Integer id, Tweet tweet);
	public abstract void cancellaTweet(Integer id);
	public abstract Collection<Tweet> getTweets();
}
