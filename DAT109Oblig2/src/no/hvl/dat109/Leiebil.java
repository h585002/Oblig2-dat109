package no.hvl.dat109;

/**
 * Definerer en leiebil ved et utleiekontor eller under leie.
 * 
 * @author Vebjoern Vaardal
 *
 */
public class Leiebil {

	private String regNr;
	private String merke;
	private String modell;
	private String farge;
	private BilgruppeEnum utleiegruppe;
	private boolean ledig;

	/**
	 * @param regNr        Registreringsnummeret til bilen.
	 * @param merke        Merket til bilen.
	 * @param modell       Modellen til bilen.
	 * @param farge        Fargen på bilen.
	 * @param utleiegruppe Utleiegruppen til bilen.
	 * @param ledig        Om bilen er ledig eller ikke.
	 */
	public Leiebil(String regNr, String merke, String modell, String farge, BilgruppeEnum utleiegruppe,
			boolean ledig) {
		this.regNr = regNr;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.utleiegruppe = utleiegruppe;
		this.ledig = ledig;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public String getMerke() {
		return merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public BilgruppeEnum getUtleiegruppe() {
		return utleiegruppe;
	}

	public void setUtleiegruppe(BilgruppeEnum utleiegruppe) {
		this.utleiegruppe = utleiegruppe;
	}

	public boolean isLedig() {
		return ledig;
	}

	public void setLedig(boolean ledig) {
		this.ledig = ledig;
	}

	@Override
	public String toString() {
		return "[" + merke + " , Modell=" + modell + ", " + farge + ", " + utleiegruppe + ", erLedig= " + ledig + "]";
	}

}
