package no.hvl.dat109;

public class Kunde {

	String fornavn;
	String etternavn;
	String adresse;
	int telefonNr;
	
	public Kunde(String fornavn, String etternavn, String adresse, int telefonNr) {
		super();
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

	@Override
	public String toString() {
		return "[fornavn: " + fornavn + ", etternavn: " + etternavn + ", adresse: " + adresse + ", telefonNr: "
				+ telefonNr + "]";
	}
	
	
}
