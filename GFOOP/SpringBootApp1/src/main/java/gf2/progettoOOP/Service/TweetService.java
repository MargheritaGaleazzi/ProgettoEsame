package gf2.progettoOOP.Service;
import java.util.Collection;
import gf2.progettoOOP.Model.Tweet;
import gf2.progettoOOP.Utils.Filtro;
public interface TweetService {
		public abstract void creaTweet(Tweet tweet);
		public abstract Collection<Tweet> getTweets();
		public abstract int getfrequenzageo(Collection<Tweet> twe, String geo);
		public abstract int getTweetlocati(Collection<Tweet> twe);
		public abstract int getfrequenzaus(Collection<Tweet> twe,String geo, String user);
		public abstract Collection<Tweet> tweetFiltrati(Collection<Tweet> twe,Filtro filtro);
	}
