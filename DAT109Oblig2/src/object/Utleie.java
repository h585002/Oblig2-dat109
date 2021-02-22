package object;

import java.time.LocalDateTime;

/**
 * Definerer et utleie, basert på en reservasjon.
 * 
 * @author Vebjoern Vaardal
 *
 */
public class Utleie {

	private int kredittkortNr;
	private String regNr;
	private int kilometer;
	private LocalDateTime utleiedato;
	private LocalDateTime returdato;

	/**
	 * @param kredittkortNr Kredittkortnummeret til kunden som leier.
	 * @param regNr         Registreringsnummeret til bilen som leies.
	 * @param kilometer     Kilometer-tallet til bilen før leie.
	 * @param utleiedato    Datoen for når bilen ble hentet.
	 * @param returdato     Datoen for når bilen forventes returnert.
	 */
	public Utleie(int kredittkortNr, String regNr, int kilometer, LocalDateTime utleiedato, LocalDateTime returdato) {
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

	public LocalDateTime getUtleiedato() {
		return utleiedato;
	}

	public void setUtleiedato(LocalDateTime utleiedato) {
		this.utleiedato = utleiedato;
	}

	public LocalDateTime getReturdato() {
		return returdato;
	}

	public void setReturdato(LocalDateTime returdato) {
		this.returdato = returdato;
	}

}
