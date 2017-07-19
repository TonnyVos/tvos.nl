package nl.tvos.tvosnl.goodreads;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 3319189464518271257L;

	@XmlElement(name="id", nillable = false)
	private String id;
	
	@XmlElement(name="isbn", nillable = true)
	private String isbn;
	
	@XmlElement(name="isbn13", nillable = true)
	private String isbn13;
	
	@XmlElement(name="title", nillable = true)
	private String title;
	
	@XmlElement(name="title_without_series", nillable = true)
	private String titleWithoutSeries;
	
	@XmlElement(name="authors", nillable = true)
	private Authors authors;

	public String getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getIsbn13() {
		return isbn13;
	}

	public String getTitle() {
		return title;
	}

	public String getTitleWithoutSeries() {
		return titleWithoutSeries;
	}

	public List<Author> getAuthors() {
		return authors.getAuthors();
	}
	
}
