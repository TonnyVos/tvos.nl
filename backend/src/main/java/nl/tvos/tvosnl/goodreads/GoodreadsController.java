package nl.tvos.tvosnl.goodreads;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Controller for retrieving the books from goodreads for a specific user and return it as JSON.
 * Returns an empty collection if an error occurs to access goodreads.
 *
 */
@RestController
@RequestMapping("/social/goodreads")
public class GoodreadsController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(GoodreadsController.class);
	
	private final static String URL = "https://www.goodreads.com/review/list/11202216.xml?key=2RavjJc7KPhEVObKyRASIg&v=2&shelf=currently-reading";
 
	/**
	 * @param name the name of the user.
	 * @return the collection of books for the specified user.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Review> getUserTimeline() {
		LOGGER.info("Retrieving goodreads feed.");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<GoodreadsResponse> response = restTemplate.getForEntity(URL, GoodreadsResponse.class);
		LOGGER.info("Received: " + response.getBody());
		return response.getBody().getReviews();
	}

}
