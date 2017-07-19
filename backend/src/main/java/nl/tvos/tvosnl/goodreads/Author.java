package nl.tvos.tvosnl.goodreads;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Author implements Serializable {

	private static final long serialVersionUID = -8535446518250161890L;
	
	@XmlElement(name="name", nillable = false)
	private String name;

	public String getName() {
		return name;
	}
	
}
