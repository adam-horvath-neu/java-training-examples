package hu.neuron.java.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CustomTagWithAttribute extends SimpleTagSupport {

	private String text;

	public void doTag() throws JspException, IOException {

		JspWriter out = getJspContext().getOut();

		out.println(getText());
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
