package nl.tvos.tvosnl.goodreads;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class Authors implements Serializable {

	private static final long serialVersionUID = 7196678605007491969L;
	
	@XmlElement(name="author", nillable = true)
	private List<Author> authors;

	public List<Author> getAuthors() {
		return authors;
	}

}
