package nl.tvos.tvosnl.goodreads;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="GoodreadsResponse")
public class GoodreadsResponse implements Serializable {
	
	private static final long serialVersionUID = 4874370825880092289L;

	@XmlElement(name="reviews", nillable = true)
	private Reviews reviews;
	
	public List<Review> getReviews() {
		return reviews.getReviews();
	}

}
