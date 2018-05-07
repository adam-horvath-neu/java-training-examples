package hu.neuron.java.ejb.web;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import hu.schonherz.jee.StatelessLocal;

@SessionScoped
@Named("cDIStatelessBeanExample")
public class CDIStatelessBeanExample implements Serializable {

	private static final long serialVersionUID = -2574198067399430161L;

	@Inject
	private StatelessLocal statelessLocal;

	private Double a;
	private Double b;

	@PostConstruct
	public void init() {
		a = 0.0;
		b = 0.0;
	}

	public void add() {
		a = statelessLocal.add(a, b);
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

}
