package object;

import java.time.LocalDateTime;

/**
 * Definerer en retur, basert på en reservasjon.
 * 
 * @author Vebjoern Vaardal
 *
 */
public class Retur {

	private int kilometer;
	private LocalDateTime returdato;

	/**
	 * @param kilometer Kilometer-tallet til bilen etter retur.
	 * @param returdato Datoen for når bilen ble returnert.
	 */
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
