package hu.neuron.java.ejb.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.NoSerializabledVO;
import hu.schonherz.jee.SerializabledVO;
import hu.schonherz.jee.StatelessLocal;
import hu.schonherz.jee.StatelessRemote;

@ManagedBean(name = "statelessBeanExample")
@ViewScoped
public class StatelessBeanExample implements Serializable {

	private static final long serialVersionUID = -2574198067399430161L;

	private static Log logger = LogFactory.getLog(StatelessBeanExample.class);

	@EJB
	private StatelessLocal statelessLocal;

	@EJB
	private StatelessRemote statelessRemote;

	@PostConstruct
	public void init() {
		a = 0.0;
		b = 0.0;
	}

	private Double a;
	private Double b;

	private String text;

	public void add() {
		a = statelessLocal.add(a, b);
	}

	public void addRemote() {
		a = statelessRemote.add(a, b);
	}

	public void upperCaseSerializabled() {
		SerializabledVO serializabledVO = new SerializabledVO();
		serializabledVO.setText(text);
		text = statelessLocal.upperCase(serializabledVO).getText();
	}

	public void upperCaseNoSerializabled() {
		NoSerializabledVO serializabledVO = new NoSerializabledVO();
		serializabledVO.setText(text);
		text = statelessLocal.upperCase(serializabledVO).getText();
	}

	public void upperCaseSerializabledRemote() {
		SerializabledVO serializabledVO = new SerializabledVO();
		serializabledVO.setText(text);
		text = statelessRemote.upperCase(serializabledVO).getText();
	}

	public void upperCaseNoSerializabledRemote() {
		NoSerializabledVO serializabledVO = new NoSerializabledVO();
		serializabledVO.setText(text);
		text = statelessRemote.upperCase(serializabledVO).getText();
	}

	public Double getA() {
		return a;
	}

	public void setA(Double a) {
		this.a = a;
	}

	public Double getB() {
		return b;
	}

	public void setB(Double b) {
		this.b = b;
	}

	public StatelessLocal getStatelessLocal() {
		return statelessLocal;
	}

	public void setStatelessLocal(StatelessLocal statelessLocal) {
		this.statelessLocal = statelessLocal;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
