package no.hvl.dat109;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// Later som vi henter eksisterende kunder, kontorer og biler fra database,
	// istedenfor å implementere det.
	static Database database = new Database();
	static Bilutleieselskap bilutleieselskap = database.hentInfo();;
	static Reservasjon reservasjon;
	static Validator validator = new Validator();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean running = true;

		while (running) {

			System.out.println("Velkommen til Bonanza Bilutleie!\n");
			System.out.println("Velg hva du ønsker å gjøre: (Skriv tallet)\n1 - Reservasjon\n2 "
					+ "- NOT IMPLEMENTED\n3 - NOT IMPLEMENTED\n4 - Avslutt");
			switch (sc.nextLine()) {
			case "1":
				reservasjon();
				break;
			case "2":
				utleie();
				break;
			case "3":
				retur();
				break;
			case "4":
				running = false;
				break;
			default:
				System.out.println("Ugyldig input, prøv igjen");
			}

		}

		sc.close();

	}

	public static void reservasjon() {

		reservasjon = new Reservasjon();
		System.out.println("\n" + "Vi har kontorer i disse byene: " + bilutleieselskap.getKontorer());
		reservasjon.setUtleiekontor(utleiested());
		reservasjon.setReturkontor(retursted());
		reservasjon.setUtleiedato(utleiedato());
		reservasjon.setAntallDager(antallDager());
		reservasjon.setPris(pris());
		System.out.println("Vennligst velg med tall: \n1 - Allerede registrert\n2 - Ny kunde\n3 - Avbryt reservasjon");
		Kunde k;
		switch (sc.nextLine()) {
			case "1":
				System.out.println("Vennligst skriv inn telefonnummeret ditt: ");
				break;
			case "2":
				 = nyKunde();
				break;
			case "3":
				break;
			default:;
		}
		
		bilutleieselskap.leggTilKunde(nyKunde);
		

			

	}

	public static Utleiekontor utleiested() {

		String input;

		System.out.println("Skriv inn hvor du vil leie bil fra: ");
		do {
			input = sc.nextLine();
		} while (!validator.kontorSjekk(input, bilutleieselskap));
		Utleiekontor utleiekontor = bilutleieselskap.KontorEtterNavn(input);
		System.out.println(utleiekontor);

		return utleiekontor;
	}

	public static Utleiekontor retursted() {

		String input;

		System.out.println("Skriv inn hvor du vil returnere bilen: ");
		do {
			input = sc.nextLine();
		} while (!validator.kontorSjekk(input, bilutleieselskap));
		Utleiekontor returkontor = bilutleieselskap.KontorEtterNavn(input);
		System.out.println(returkontor);

		return returkontor;
	}

	public static LocalDateTime utleiedato() {

		String input;

		System.out.println("Skriv inn når du vil hente bilen... (Skriv med tall)\nÅr:");
		do {
			input = sc.nextLine();
		} while (!validator.aarSjekk(input));
		int aar = Integer.parseInt(input);

		System.out.println("Måned: ");
		do {
			input = sc.nextLine();
		} while (!validator.maanedSjekk(input, aar));
		int maaned = Integer.parseInt(input);

		System.out.println("Dag: ");
		do {
			input = sc.nextLine();
		} while (!validator.dagSjekk(input, aar, maaned));
		int dag = Integer.parseInt(input);

		System.out.println("Time: ");
		do {
			input = sc.nextLine();
		} while (!validator.timeSjekk(input));
		int time = Integer.parseInt(input);

		System.out.println("Minutt: ");
		do {
			input = sc.nextLine();
		} while (!validator.minuttSjekk(input));
		int minutt = Integer.parseInt(input);

		LocalDateTime tid = LocalDateTime.of(aar, maaned, dag, time, minutt);
		System.out.println(tid);

		return tid;
	}

	public static int antallDager() {

		System.out.println("Hvor mange dager skal du leie bilen? ");
		int dager = Integer.parseInt(sc.nextLine());
		System.out.println(dager);

		return dager;
	}

	public static int pris() {

		System.out.println("Ledige kategorier: ");
		Utleiekontor kontor = reservasjon.getUtleiekontor();
		boolean a, b, c, d;
		a = b = c = d = false;
		for (int i = 0; i < kontor.getLeiebiler().size(); i++) {
			if (kontor.getLeiebiler().get(i).getUtleiegruppe() == BilgruppeEnum.LITEN)
				a = true;
			else if (kontor.getLeiebiler().get(i).getUtleiegruppe() == BilgruppeEnum.MELLOMSTOR)
				b = true;
			else if (kontor.getLeiebiler().get(i).getUtleiegruppe() == BilgruppeEnum.STOR)
				c = true;
			else if (kontor.getLeiebiler().get(i).getUtleiegruppe() == BilgruppeEnum.STASJONSVOGN)
				d = true;
		}
		int pris = 0;
		if (!kontor.equals(reservasjon.getReturkontor()))
			pris = 100;
		if (a) {
			System.out.println("A - Liten: " + (Priser.A_PRIS * reservasjon.getAntallDager() + pris) + "kr for "
					+ reservasjon.getAntallDager() + " dager");
		}
		if (b) {
			System.out.println("B - Mellomstor: " + (Priser.B_PRIS * reservasjon.getAntallDager() + pris) + "kr for "
					+ reservasjon.getAntallDager() + " dager");
		}
		if (c) {
			System.out.println("C - Stor: " + (Priser.C_PRIS * reservasjon.getAntallDager() + pris) + "kr for "
					+ reservasjon.getAntallDager() + " dager");
		}
		if (d) {
			System.out.println("D - Stasjonsvogn: " + (Priser.D_PRIS * reservasjon.getAntallDager() + pris) + "kr for "
					+ reservasjon.getAntallDager() + " dager");
		}
		String input;
		System.out.println("Skriv hvilken kategori du skal bestille: (Bare bokstaven)");
		do {
			input = sc.nextLine();
		} while (validator.kategoriSjekk(input, a, b, c, d));
		switch (sc.nextLine().toUpperCase()) {
		case "A":
			pris += Priser.A_PRIS;
		case "B":
			pris += Priser.B_PRIS;
		case "C":
			pris += Priser.C_PRIS;
		case "D":
			pris += Priser.D_PRIS;
		default:
			;
		}

		return pris;
	}

	public static Kunde nyKunde() {
		System.out.println("Registrer dine personopplysninger her:\n");

		String fornavn = null;
		while (!validator.navnSjekk(fornavn)) {
			if (fornavn != null) {
				System.out.println("Ugyldig fornavn, prøv igjen:");
			}
			System.out.println("Fornavn:");
			fornavn = sc.nextLine();
		}
		String etternavn = null;
		while (!validator.navnSjekk(etternavn)) {
			if (etternavn != null) {
				System.out.println("Ugyldig etternavn, prøv igjen:");
			}
			System.out.println("Etternavn:");
			etternavn = sc.nextLine();
		}
		String adresse = null;
		while (!validator.adresseSjekk(adresse)) {
			if (adresse != null) {
				System.out.println("Ugyldig adresse, prøv igjen:");
			}
			System.out.println("Adresse:");
			adresse = sc.nextLine();
		}
		String telefonNr = null;
		while (!validator.telefonNrSjekk(telefonNr, bilutleieselskap)) {
			System.out.println("TelefonNummer:");
			telefonNr = sc.nextLine();
		}
		int tlf = Integer.parseInt(telefonNr);

		Kunde kunde = new Kunde(fornavn, etternavn, adresse, tlf, new ArrayList<Reservasjon>());
		System.out.println("Opplysningene du har gitt:" + "\n" + kunde.toString());
		return kunde;
	}

	public static Kunde lagreKunde() {

		return null;
	}

	private static void utleie() {
		// TODO Auto-generated method stub

	}

	private static void retur() {
		// TODO Auto-generated method stub

	}

}
