package no.hvl.dat109;

import java.util.List;

/**
 * Definerer en registrert kunde i et bilutleieselskap.
 * 
 * @author Vebjoern Vaardal
 *
 */
public class Kunde {

	private String fornavn;
	private String etternavn;
	private String adresse;
	private int telefonNr;
	private List<Reservasjon> reservasjoner;

	/**
	 * @param fornavn       Fornavnet til kunden.
	 * @param etternavn     Etternavnet til kunden.
	 * @param adresse       Adressen til kunden.
	 * @param telefonNr     Telefonnummeret til kunden.
	 * @param reservasjoner Reservasjonene til kunden.
	 */
	public Kunde(String fornavn, String etternavn, String adresse, int telefonNr, List<Reservasjon> reservasjoner) {
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.telefonNr = telefonNr;
		this.reservasjoner = reservasjoner;
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

	public void setReservasjoner(List<Reservasjon> reservasjon) {
		this.reservasjoner = reservasjon;
	}

	/**
	 * @param reservasjon Reservasjonen som legges listen av reservasjonene til
	 *                    kunden.
	 */
	public void leggTilReservasjon(Reservasjon reservasjon) {
		reservasjoner.add(reservasjon);
	}

	@Override
	public String toString() {
		return "[fornavn: " + fornavn + ", etternavn: " + etternavn + ", adresse: " + adresse + ", telefonNr: "
				+ telefonNr + "]";
	}

}
