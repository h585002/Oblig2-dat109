package object;

import java.time.LocalDateTime;

/**
 * Definerer en reservasjon for en kunde som er registrert i bilutleieselskapet.
 * 
 * @author Vebjoern Vaardal
 *
 */
public class Reservasjon {

	private LocalDateTime utleiedato;
	private int antallDager;
	private int pris;
	private Utleiekontor utleiekontor;
	private Utleiekontor returkontor;
	private Utleie utleie;
	private Retur retur;

	public Reservasjon() {
		this.utleiedato = null;
		this.antallDager = 0;
		this.pris = 0;
		this.utleiekontor = null;
		this.returkontor = null;
		this.utleie = null;
		this.retur = null;
	}

	/**
	 * @param utleiedato   Datoen bilen skal leies ut.
	 * @param antallDager  Antall dager bilen skal leies.
	 * @param pris         Prisen til utleien.
	 * @param utleiekontor Kontoret bilen skal hentes ved.
	 * @param returkontor  Kontoret bilen skal leveres ved.
	 * @param utleie       Utleien, som blir opprettet ved henting.
	 * @param retur        Returen, som blir opprettet ved retur.
	 */
	public Reservasjon(LocalDateTime utleiedato, int antallDager, int pris, Utleiekontor utleiekontor,
			Utleiekontor returkontor, Utleie utleie, Retur retur) {
		this.utleiedato = utleiedato;
		this.antallDager = antallDager;
		this.pris = pris;
		this.utleiekontor = utleiekontor;
		this.returkontor = returkontor;
		this.utleie = utleie;
		this.retur = retur;
	}

	public LocalDateTime getUtleiedato() {
		return utleiedato;
	}

	public void setUtleiedato(LocalDateTime utleiedato) {
		this.utleiedato = utleiedato;
	}

	public int getAntallDager() {
		return antallDager;
	}

	public void setAntallDager(int antallDager) {
		this.antallDager = antallDager;
	}

	public int getPris() {
		return pris;
	}

	public void setPris(int pris) {
		this.pris = pris;
	}

	public Utleiekontor getUtleiekontor() {
		return utleiekontor;
	}

	public void setUtleiekontor(Utleiekontor utleiekontor) {
		this.utleiekontor = utleiekontor;
	}

	public Utleiekontor getReturkontor() {
		return returkontor;
	}

	public void setReturkontor(Utleiekontor returkontor) {
		this.returkontor = returkontor;
	}

	public Utleie getUtleie() {
		return utleie;
	}

	public void setUtleie(Utleie utleie) {
		this.utleie = utleie;
	}

	public Retur getRetur() {
		return retur;
	}

	public void setRetur(Retur retur) {
		this.retur = retur;
	}

	/**
	 * @return Returnerer bilgruppen som er reservert, basert på prisen.
	 */
	public BilgruppeEnum getBilgruppe() {
		int kPris = pris;
		if (!utleiekontor.equals(returkontor))
			kPris -= 100;
		kPris = kPris / antallDager;
		if (kPris == Priser.A_PRIS)
			return BilgruppeEnum.LITEN;
		if (kPris == Priser.B_PRIS)
			return BilgruppeEnum.MELLOMSTOR;
		if (kPris == Priser.C_PRIS)
			return BilgruppeEnum.STOR;
		if (kPris == Priser.D_PRIS)
			return BilgruppeEnum.STASJONSVOGN;
		return null;
	}

	@Override
	public String toString() {
		return "Reservasjon [utleiedato=" + utleiedato + ", antallDager=" + antallDager + ", pris=" + pris
				+ ", utleiekontor=" + utleiekontor + ", returkontor=" + returkontor + ", utleie=" + utleie + ", retur="
				+ retur + "]";
	}

}
