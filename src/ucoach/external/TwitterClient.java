package ucoach.external;

import twitter4j.*;
import twitter4j.auth.AccessToken;

import java.io.IOException;

public class TwitterClient {
	
   static Twitter twitter;
   private static String CONSUMER_KEY = "twitter_consumer_key";
   private static String CONSUMER_SECRET = "twitter_consumer_secret";
   private static String ACCESS_TOKEN = "twitter_access_token";
   private static String ACCESS_TOKEN_SECRET = "twitter_access_token_secret";
	
   public TwitterClient(){
  	 setDependencies();

		//Create the twitter factory
		TwitterFactory twitterFactory = new TwitterFactory();
		
		//Create a new twitter service instance
		twitter = twitterFactory.getInstance();
		
		//setup credentials for user
		twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		
		//setup Access Token
		twitter.setOAuthAccessToken(new AccessToken(ACCESS_TOKEN, ACCESS_TOKEN_SECRET));
   }
   
	 public static void sendTweet(String tweet) throws IOException, TwitterException {     
		 //Instantiate and initialize a new twitter status update
		 StatusUpdate statusUpdate = new StatusUpdate(tweet);

		 /*   statusUpdate.setMedia(
		            //title of media
		            "http://h1b-work-visa-usa.blogspot.com"
		            , new URL("http://lh6.ggpht.com/-NiYLR6SkOmc/Uen_M8CpB7I/AAAAAAAAEQ8/tO7fufmK0Zg/h-1b%252520transfer%252520jobs%25255B4%25255D.png?imgmax=800").openStream());
		 */
		 // Tweet or update status
		 Status status = twitter.updateStatus(statusUpdate);        
	 }

	/**
	 * Set needed dependencies
	 */
	 private void setDependencies() {
		 if (String.valueOf(System.getenv("TWITTER_CONSUMER_KEY")) != "null"){
			 CONSUMER_KEY = String.valueOf(System.getenv("TWITTER_CONSUMER_KEY"));
		 }
		
		 if (String.valueOf(System.getenv("TWITTER_CONSUMER_SECRET")) != "null"){
			 CONSUMER_SECRET = String.valueOf(System.getenv("TWITTER_CONSUMER_SECRET"));
		 }
		
		 if (String.valueOf(System.getenv("TWITTER_ACCESS_TOKEN")) != "null"){
			 ACCESS_TOKEN = String.valueOf(System.getenv("TWITTER_ACCESS_TOKEN"));
		 }

		 if (String.valueOf(System.getenv("TWITTER_ACCESS_TOKEN_SECRET")) != "null"){
			 ACCESS_TOKEN_SECRET = String.valueOf(System.getenv("TWITTER_ACCESS_TOKEN_SECRET"));
		 }
	 }
}