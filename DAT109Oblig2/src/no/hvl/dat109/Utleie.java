package no.hvl.dat109;

import java.time.LocalDateTime;

public class Utleie {

	private int kredittkortNr;
	private String regNr;
	private int kilometer;
	private LocalDateTime utleiedato;
	private LocalDateTime returdato;

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
