package no.hvl.dat109;

public class Utleie {

	private int kredittkortNr;
	private String regNr;
	private int kilometer;
	private String utleiedato;
	private String returdato;

	public Utleie(int kredittkortNr, String regNr, int kilometer, String utleiedato, String returdato) {
		super();
		this.kredittkortNr = kredittkortNr;
		this.regNr = regNr;
		this.kilometer = kilometer;
		this.utleiedato = utleiedato;
		this.returdato = returdato;
	}

	public int getKredittkortNr() {
		return kredittkortNr;
	}

	public void setKredittkortNr(int kredittkortNr) {
		this.kredittkortNr = kredittkortNr;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public int getKilometer() {
		return kilometer;
	}

	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	public String getUtleiedato() {
		return utleiedato;
	}

	public void setUtleiedato(String utleiedato) {
		this.utleiedato = utleiedato;
	}

	public String getReturdato() {
		return returdato;
	}

	public void setReturdato(String returdato) {
		this.returdato = returdato;
	}

}
