package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import object.BilgruppeEnum;
import object.Bilutleieselskap;
import object.Database;
import object.Kunde;
import object.Leiebil;
import object.Priser;
import object.Reservasjon;
import object.Retur;
import object.Utleie;
import object.Utleiekontor;
import test.Validator;

/**
 * Definerer logikken til Utleieprogrammet.
 * 
 * @author Vebjoern Vaardal
 *
 */
public class Klient {

	// Later som vi henter eksisterende kunder, kontorer og biler fra database,
	// istedenfor å implementere det.
	static Database database = new Database();
	static Bilutleieselskap bilutleieselskap = database.hentInfo();
	static Reservasjon reservasjon;
	static Validator validator = new Validator();
	static Scanner sc = new Scanner(System.in);

	/**
	 * Hovedmeny for valg av reservasjon, utleie og retur.
	 * 
	 * @param args Ikke i bruk.
	 */
	public static void main(String[] args) {

		boolean running = true;

		while (running) {

			System.out.println("Velkommen til Bonanza Bilutleie!\n");
			System.out.println("Velg hva du ønsker å gjøre: (Skriv tallet)\n1 - Reservasjon\n2 "
					+ "- Utleie\n3 - Retur\n4 - Avslutt");
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
			// Later som vi lagrer ny info i databasen.
			database.lagreInfo();
		}

		sc.close();

	}

	/**
	 * Reservering av bil.
	 */
	public static void reservasjon() {

		reservasjon = new Reservasjon();
		System.out.println("\n" + "Vi har kontorer i disse byene: " + bilutleieselskap.getKontorer());
		reservasjon.setUtleiekontor(utleiested());
		reservasjon.setReturkontor(retursted());
		reservasjon.setUtleiedato(utleiedato());
		reservasjon.setAntallDager(antallDager());
		reservasjon.setPris(pris());
		Kunde k = null;
		while (k == null) {
			System.out.println(
					"Vennligst velg med tall: \n1 - Allerede registrert\n2 - Ny kunde\n3 - Avbryt reservasjon");
			switch (sc.nextLine()) {
			case "1":
				System.out.println("Vennligst skriv inn telefonnummeret ditt: ");
				int input;
				try {
					input = Integer.parseInt(sc.nextLine());
					List<Kunde> kunden = bilutleieselskap.getKunder().stream().filter(a -> a.getTelefonNr() == input)
							.collect(Collectors.toList());
					if (kunden.size() == 1) {
						if (kunden.get(0).getReservasjoner().size() < 1)
							k = kunden.get(0);
						else {
							if (kunden.get(0).getReservasjoner().get(kunden.get(0).getReservasjoner().size() - 1).getRetur() != null)
								k = kunden.get(0);
							else
								System.out.println("Oops! Kan ikke reservere samtidig som en annen reservasjon er pågående.");
						}
					}											
					else
						System.out.println("Ingen kunde registrert med det nummeret.");
				} catch (NumberFormatException e) {
					System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
				}
				break;
			case "2":
				bilutleieselskap.leggTilKunde(nyKunde());
				k = bilutleieselskap.getKunder().get(bilutleieselskap.getKunder().size() - 1);
				break;
			case "3":
				return;
			default:
				;
			}
		}
		k.leggTilReservasjon(reservasjon);
		List<Leiebil> reservertBil = reservasjon.getUtleiekontor().getLeiebiler().stream()
				.filter(a -> a.getUtleiegruppe() == reservasjon.getBilgruppe()).collect(Collectors.toList());
		reservertBil.get(0).setLedig(false);
		System.out.println("Reservasjon fullført! Reservert under navnet: " + k.toString());
	}

	/**
	 * @return Returnerer ønsket utleiekontor for kunden.
	 */
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

	/**
	 * @return Returnerer ønsket returkontor for kunden.
	 */
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

	/**
	 * @return Returnerer ønsket utleiedato for kunden.
	 */
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

	/**
	 * @return Returnerer øsnket antall dager leie for kunden.
	 */
	public static int antallDager() {

		System.out.println("Hvor mange dager skal du leie bilen? ");
		int dager = Integer.parseInt(sc.nextLine());
		System.out.println(dager);

		return dager;
	}

	/**
	 * @return Returnerer pris på ønsket kategori for kunden, basert på pris av
	 *         tilgjengelige kategorier og antall dager utleie.
	 */
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
		} while (!validator.kategoriSjekk(input, a, b, c, d));
		switch (input.toUpperCase()) {
		case "A":
			pris += Priser.A_PRIS * reservasjon.getAntallDager();
			break;
		case "B":
			pris += Priser.B_PRIS * reservasjon.getAntallDager();
			break;
		case "C":
			pris += Priser.C_PRIS * reservasjon.getAntallDager();
			break;
		case "D":
			pris += Priser.D_PRIS * reservasjon.getAntallDager();
			break;
		default:
			;
		}

		return pris;
	}

	/**
	 * @return Returnerer en ny kunde som skal registreres.
	 */
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

	/**
	 * 
	 */
	private static void utleie() {
		System.out.println("Skriv inn telefonnummret ditt: ");
		Kunde k = null;
		while (k == null) {
			try {
				int input = Integer.parseInt(sc.nextLine());
				List<Kunde> kunden = bilutleieselskap.getKunder().stream().filter(a -> a.getTelefonNr() == input)
						.collect(Collectors.toList());
				if (kunden.size() == 1)
					k = kunden.get(0);
				else {
					System.out.println("Ingen kunde registrert med det nummeret.");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
			}
		}
		Reservasjon reservasjonen = k.getReservasjoner().get(k.getReservasjoner().size() - 1);
		if (reservasjonen.getUtleie() != null) {
			System.out.println("Ingen aktiv reservasjon. Utleie umulig.");
			return;
		}
		String kredNrString = null;
		System.out.println("Skriv inn kredittkort-nummer: ");
		while (!validator.kredittkortNrSjekk(kredNrString)) {
			kredNrString = sc.nextLine();
			if (!validator.kredittkortNrSjekk(kredNrString))
				System.out.println("Ugyldig input. Prøv igjen. (Bare tall, 16 siffer)");
		}
		Long kredNr = Long.parseLong(kredNrString);
		List<Leiebil> leiebiler = reservasjon.getUtleiekontor().getLeiebiler().stream()
				.filter(a -> a.getUtleiegruppe() == reservasjonen.getBilgruppe() && !a.isLedig())
				.collect(Collectors.toList());
		Leiebil leiebilen = leiebiler.get(0);
		reservasjonen.getUtleiekontor().getLeiebiler().remove(leiebilen);
		reservasjonen.getReturkontor().getLeiebiler().add(leiebilen);
		String regNr = leiebilen.getRegNr();
		System.out.println("Skriv inn nåværende kilometer-tall: ");
		int km = -1;
		while (km < 0) {
			try {
				km = Integer.parseInt(sc.nextLine());
				if (km < 0)
					System.out.println("Ugyldig input. Prøv igjen. (Kan ikke være mindre enn 0)");
			}
			catch (NumberFormatException e) {	
				System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
			}
		}
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime retur = now.plusDays(reservasjonen.getAntallDager());
		Utleie utleie = new Utleie(kredNr, regNr, km, now, retur);
		reservasjon.setUtleie(utleie);
		System.out.println("Utleie fullført!");
		
	}

	/**
	 * 
	 */
	private static void retur() {
		
		System.out.println("Skriv inn telefonnummret ditt: ");
		Kunde k = null;
		while (k == null) {
			try {
				int input = Integer.parseInt(sc.nextLine());
				List<Kunde> kunden = bilutleieselskap.getKunder().stream().filter(a -> a.getTelefonNr() == input)
						.collect(Collectors.toList());
				if (kunden.size() == 1)
					k = kunden.get(0);
				else {
					System.out.println("Ingen kunde registrert med det nummeret.");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
			}
		}
		
		Reservasjon reservasjonen = k.getReservasjoner().get(k.getReservasjoner().size() - 1);
		if (reservasjonen.getRetur() != null || reservasjonen.getUtleie() == null) {
			System.out.println("Ingen aktiv utleie. Retur umulig.");
			return;
		}
		System.out.println("Skriv inn nåværende kilometer-tall: ");
		int km = -1;
		while (km < reservasjonen.getUtleie().getKilometer()) {
			try {
				km = Integer.parseInt(sc.nextLine());
				if (km < reservasjonen.getUtleie().getKilometer())
					System.out.println("Ugyldig input. Prøv igjen. (Kan ikke være mindre enn tidligere kilometer-tall)");
			}
			catch (NumberFormatException e) {	
				System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
			}
		}
		LocalDateTime returdato = LocalDateTime.now();
		Retur retur = new Retur(km, returdato);
		reservasjon.setRetur(retur);
		List<Leiebil> leiebilen = reservasjon.getReturkontor().getLeiebiler().stream()
				.filter(a -> a.getRegNr() == reservasjon.getUtleie().getRegNr())
				.collect(Collectors.toList());
		leiebilen.get(0).setLedig(true);
		System.out.println("Retur fullført! Faktura blir sendt i posten, med mindre du betaler i skranken.");
		
	}
}
