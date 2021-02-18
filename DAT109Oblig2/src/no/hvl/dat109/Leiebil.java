package no.hvl.dat109;

public class Leiebil {

	private int regNr;
	private String merke;
	private String modell;
	private String farge;
	private String utleiegruppe;
	private boolean erLedig;

	public Leiebil(int regNr, String merke, String modell, String farge, String utleiegruppe, boolean erLedig) {
		this.regNr = regNr;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.utleiegruppe = utleiegruppe;
		this.erLedig = erLedig;
	}

	public int getRegNr() {
		return regNr;
	}

	public void setRegNr(int regNr) {
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

	public String getUtleiegruppe() {
		return utleiegruppe;
	}

	public void setUtleiegruppe(String utleiegruppe) {
		this.utleiegruppe = utleiegruppe;
	}

	public boolean isErLedig() {
		return erLedig;
	}

	public void setErLedig(boolean erLedig) {
		this.erLedig = erLedig;
	}

}
