package it.michele.beans;

import java.util.List;

public class Biografia {

	private List<Opere> operes;
	private List<Premiazioni> premiazionis;
	
	public Biografia() {
		super();
	}
	public Biografia(List<Opere> operes, List<Premiazioni> premiazionis) {
		super();
		this.operes = operes;
		this.premiazionis = premiazionis;
	}
	public List<Opere> getOperes() {
		return operes;
	}
	public void setOperes(List<Opere> operes) {
		this.operes = operes;
	}
	public List<Premiazioni> getPremiazionis() {
		return premiazionis;
	}
	public void setPremiazionis(List<Premiazioni> premiazionis) {
		this.premiazionis = premiazionis;
	}
	@Override
	public String toString() {
		return "Biografia [operes=" + operes + ", premiazionis=" + premiazionis + "]";
	}
	
}
