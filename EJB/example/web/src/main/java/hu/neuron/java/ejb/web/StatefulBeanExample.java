package hu.neuron.java.ejb.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import hu.schonherz.jee.StatefulLocal;
import hu.schonherz.jee.StatefulRemote;

@ManagedBean(name = "statefulBeanExample")
@ViewScoped
public class StatefulBeanExample implements Serializable {

	private static final long serialVersionUID = -2574198067399430161L;

	private static Log logger = LogFactory.getLog(StatefulBeanExample.class);

	@EJB
	private StatefulLocal statefulLocal;

	@EJB
	private StatefulRemote statefulRemote;

	@PostConstruct
	public void init() {
		a = 0.0;
		b = 0.0;
	}

	private Double a;
	private Double b;

	private String text;

	public void add() {
		a = statefulLocal.add(b);
	}

	public void addRemote() {
		a = statefulRemote.add(b);
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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public StatefulLocal getStatefulLocal() {
		return statefulLocal;
	}

	public void setStatefulLocal(StatefulLocal statefulLocal) {
		this.statefulLocal = statefulLocal;
	}

	public StatefulRemote getStatefulRemote() {
		return statefulRemote;
	}

	public void setStatefulRemote(StatefulRemote statefulRemote) {
		this.statefulRemote = statefulRemote;
	}

}
