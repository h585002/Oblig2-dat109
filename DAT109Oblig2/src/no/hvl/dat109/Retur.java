package no.hvl.dat109;

public class Retur {

	private int kilometer;
	private String returdato;

	public Retur(int kilometer, String returdato) {
		super();
		this.kilometer = kilometer;
		this.returdato = returdato;
	}

	public int getKilometer() {
		return kilometer;
	}

	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	public String getReturdato() {
		return returdato;
	}

	public void setReturdato(String returdato) {
		this.returdato = returdato;
	}

}
