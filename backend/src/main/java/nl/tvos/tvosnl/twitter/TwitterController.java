package nl.tvos.tvosnl.twitter;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Controller for retrieving the tweets for a specific user and return it as JSON.
 * Returns an empty collection if an error occurs to access twitter.
 *
 */
@RestController
@RequestMapping("/social/twitter")
public class TwitterController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TwitterController.class);
	
	private final static String CKEY = "TTFSnrLuxxOeK3DayOxqFpC1u";
	private final static String CSECRET = "nUuXHWUva5pJeyJ74byHi3rfNrYpK4pDR35v0CgN7WtLdnCMWN";
	private final static String ATOKEN = "7676142-UcGlAHNrFxQH8XQvPEM576zsROLmyNb9b9RNG3RMB6";
	private final static String ATOKENSECRET = "IGs1ms88d9aIKIMJS9pBYvfrTi3lvhv2zx7cnUcZgw";
 
	/**
	 * @param name the name of the user.
	 * @return the collection of tweets for the specified user.
	 */
	@RequestMapping(value="{name}", method = RequestMethod.GET)
	public @ResponseBody List<Status> getUserTimeline(@PathVariable String name) {
		LOGGER.info("Retrieving twitter feed for {}.", name);
		Twitter twitter = new TwitterFactory(createTwitterConfiguration()).getInstance();
		try {
			LOGGER.debug("Initiated twitter instance.");
			ResponseList<Status> userTimeline = twitter.getUserTimeline();
			LOGGER.info("Retrieved twitter feed for {}: {} entries.", name, userTimeline.size());
			return userTimeline;
		} catch (TwitterException e) {
			LOGGER.error("Retrieving twitter feed failed for {}.", name, e);
		}
		return Collections.emptyList();
	}
	
	/**
	 * @return the Twitter configuration.
	 */
	private Configuration createTwitterConfiguration() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		return cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(CKEY)
		  .setOAuthConsumerSecret(CSECRET)
		  .setOAuthAccessToken(ATOKEN)
		  .setOAuthAccessTokenSecret(ATOKENSECRET)
		  .build();
	}

}
