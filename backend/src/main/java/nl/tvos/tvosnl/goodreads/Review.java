package nl.tvos.tvosnl.goodreads;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Review implements Serializable {
	
	private static final long serialVersionUID = 2819258471249544666L;

	@XmlElement(name="id", nillable = false)
	private String id;
	
	@XmlElement(name="book", nillable = false)
	private Book book;
	
	@XmlElement(name="date_updated", nillable = false)
	private String dateUpdated;
	
	@XmlElement(name="rating", nillable = false)
	private int rating;

	public String getId() {
		return id;
	}

	public Book getBook() {
		return book;
	}

	public String getDateUpdated() {
		return dateUpdated;
	}

	public int getRating() {
		return rating;
	}
	
	
}
