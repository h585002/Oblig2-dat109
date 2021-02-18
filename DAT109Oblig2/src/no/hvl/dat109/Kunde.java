package no.hvl.dat109;

import java.util.List;

public class Kunde {

	private String fornavn;
	private String etternavn;
	private String adresse;
	private int telefonNr;
	private List<Reservasjon> reservasjoner;

	public Kunde(String fornavn, String etternavn, String adresse, int telefonNr) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.telefonNr = telefonNr;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(int telefonNr) {
		this.telefonNr = telefonNr;
	}

	public List<Reservasjon> getReservasjoner() {
		return reservasjoner;
	}

	public void setReservasjoner(List<Reservasjon> reservasjoner) {
		this.reservasjoner = reservasjoner;
	}

	@Override
	public String toString() {
		return "[fornavn: " + fornavn + ", etternavn: " + etternavn + ", adresse: " + adresse + ", telefonNr: "
				+ telefonNr + "]";
	}

}
