package nl.tvos.tvosnl.goodreads;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Reviews implements Serializable {

	private static final long serialVersionUID = 7196678605007491969L;
	
	@XmlElement(name="review", nillable = true)
	private List<Review> reviews;

	public List<Review> getReviews() {
		return reviews;
	}

}
