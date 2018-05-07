package hu.schonherz.jee;

import java.io.Serializable;

public class SerializabledVO implements Serializable {

	
	private static final long serialVersionUID = 7239830436602190282L;

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
