package no.hvl.dat109;

import java.time.LocalDateTime;

public class Retur {

	private int kilometer;
	private LocalDateTime returdato;

	public Retur(int kilometer, LocalDateTime returdato) {
		this.kilometer = kilometer;
		this.returdato = returdato;
	}

	public int getKilometer() {
		return kilometer;
	}

	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	public LocalDateTime getReturdato() {
		return returdato;
	}

	public void setReturdato(LocalDateTime returdato) {
		this.returdato = returdato;
	}

}
