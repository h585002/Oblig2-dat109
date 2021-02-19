package no.hvl.dat109;

import java.util.List;

public class Utleiekontor {

	private int nummer;
	private int telefonNr;
	private String by;
	private List<Leiebil> leiebiler;

	public Utleiekontor(int nummer, int telefonNr, String by, List<Leiebil> leiebiler) {
		this.nummer = nummer;
		this.telefonNr = telefonNr;
		this.by = by;
		this.leiebiler = leiebiler;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(int telefonNr) {
		this.telefonNr = telefonNr;
	}

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public List<Leiebil> getLeiebiler() {
		return leiebiler;
	}

	public void setLeiebiler(List<Leiebil> leiebiler) {
		this.leiebiler = leiebiler;
	}

}
