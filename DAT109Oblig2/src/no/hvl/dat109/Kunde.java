package no.hvl.dat109;

public class Kunde {

	private String fornavn;
	private String etternavn;
	private String adresse;
	private int telefonNr;
	private Reservasjon reservasjon;

	public Kunde(String fornavn, String etternavn, String adresse, int telefonNr, Reservasjon reservasjon) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.telefonNr = telefonNr;
		this.reservasjon = reservasjon;
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

	public Reservasjon getReservasjon() {
		return reservasjon;
	}

	public void setReservasjon(Reservasjon reservasjon) {
		this.reservasjon = reservasjon;
	}
	
	@Override
	public String toString() {
		return "[fornavn: " + fornavn + ", etternavn: " + etternavn + ", adresse: " + adresse + ", telefonNr: "
				+ telefonNr + "]";
	}

}
