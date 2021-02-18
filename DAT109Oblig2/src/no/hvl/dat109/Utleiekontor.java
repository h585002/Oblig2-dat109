package no.hvl.dat109;

import java.util.List;

public class Utleiekontor {

	private int nummer;
	private int telefonNr;
	private String adresse;
	private List<Leiebil> leiebiler;

	public Utleiekontor(int nummer, int telefonNr, String adresse, List<Leiebil> leiebiler) {
		this.nummer = nummer;
		this.telefonNr = telefonNr;
		this.adresse = adresse;
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

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Leiebil> getLeiebiler() {
		return leiebiler;
	}

	public void setLeiebiler(List<Leiebil> leiebiler) {
		this.leiebiler = leiebiler;
	}

}
