package no.hvl.dat109;

import java.util.List;
import java.util.stream.Collectors;

public class Bilutleieselskap {

	private String navn;
	private int telefonNr;
	private String adresse;
	private List<Utleiekontor> kontorer;
	private List<Kunde> kunder;

	public Bilutleieselskap(String navn, int telefonNr, String adresse, List<Utleiekontor> kontorer,
			List<Kunde> kunder) {
		this.navn = navn;
		this.telefonNr = telefonNr;
		this.adresse = adresse;
		this.kontorer = kontorer;
		this.kunder = kunder;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(int telefonNr) {
		this.telefonNr = telefonNr;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public List<Utleiekontor> getKontorer() {
		return kontorer;
	}

	public void setKontorer(List<Utleiekontor> kontorer) {
		this.kontorer = kontorer;
	}

	public List<Kunde> getKunder() {
		return kunder;
	}

	public void setKunder(List<Kunde> kunder) {
		this.kunder = kunder;
	}
	
	//returnerer kontorer som bruker skriver inn
	public Utleiekontor KontorEtterNavn(String by) {		
		Utleiekontor sok = null;
		for(int i = 0; i < kontorer.size(); i++) {			
			if(kontorer.get(i).getBy().equalsIgnoreCase(by)) {	
				sok = kontorer.get(i);
			}
		}
		return sok;
	}

}
