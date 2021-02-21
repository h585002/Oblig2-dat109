package no.hvl.dat109;

import java.time.LocalDateTime;

public class Reservasjon {

	private LocalDateTime utleiedato;
	private int antallDager;
	private int pris;
	private Utleiekontor utleiekontor;
	private Utleiekontor returkontor;
	private Utleie utleie;
	private Retur retur;

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

}
