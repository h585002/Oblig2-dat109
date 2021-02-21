package no.hvl.dat109;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	//Later som vi henter eksisterende kunder, kontorer og biler fra database, istedenfor å implementere det.
	static Database database = new Database(); 
	static Bilutleieselskap bilutleieselskap = database.hentInfo();;
	static Reservasjon reservasjon = new Reservasjon();
	static Validator validator = new Validator();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean running = true;
		
		while (running) {
			
			System.out.println("Velkommen til Bonanza Bilutleie!\n");
			System.out.println("Velg hva du ønsker å gjøre: (Skriv tallet)\n1 - Reserver\n2 "
								+ "- NOT IMPLEMENTED\n3 - NOT IMPLEMENTED\n4 - Avslutt");
			switch (sc.nextLine()) {
			case "1": 
				reserver();
				break;
			case "4": 
				running = false;
				break;	
			default: System.out.println("Ugyldig input");
			}
			
		}	
		
		sc.close();

	}

	public static void reserver() {
		
		System.out.println("Registrer dine personopplysninger her:\n");
		reservasjon.setKunde(nyKunde());
		System.out.println("\n" + "Vi har kontorer i disse byene: " + bilutleieselskap.getKontorer());
		reservasjon.setUtleiekontor(utleiested());
		reservasjon.setReturkontor(retursted());
		reservasjon.setUtleiedato(utleiedato());
		reservasjon.setAntallDager(antallDager());
		reservasjon.setPris(pris());

	}
	
	public static Kunde nyKunde() {
			
		String fornavn = null;
		while(!validator.navnSjekk(fornavn)) {
			if(fornavn != null) {
				System.out.println("Ugyldig fornavn, prøv igjen:");
			}
		System.out.println("Fornavn:");
		fornavn = sc.nextLine();
	}
		String etternavn = null;
		while(!validator.navnSjekk(etternavn)) {
			if(etternavn != null) {
				System.out.println("Ugyldig etternavn, prøv igjen:");
			}
		System.out.println("Etternavn:");
		etternavn = sc.nextLine();
	}	
		String adresse = null;
		while(!validator.adresseSjekk(adresse)) {
			if(adresse != null) {
				System.out.println("Ugyldig adresse, prøv igjen:");
			}
		System.out.println("Adresse:");
		adresse = sc.nextLine();
	}	
		String telefonNr = null;
		while(!validator.telefonNrSjekk(telefonNr)) {
			if(etternavn != null) {
				System.out.println("Ugyldig telefonNummer, må inneholde 8 siffer:");
			}
		System.out.println("TelefonNummer:");
		telefonNr = sc.nextLine();	
	}
		int tlf = Integer.parseInt(telefonNr);
		
		Kunde kunde = new Kunde(fornavn, etternavn, adresse, tlf, reservasjon);
		System.out.println("Opplysningene du har gitt:" + "\n" + kunde.toString());
		return kunde;
	}

	public static Utleiekontor utleiested() {

		System.out.println("Skriv inn hvor du vil leie bil fra: ");
		String by = sc.nextLine();
		Utleiekontor utleiekontor = bilutleieselskap.KontorEtterNavn(by);
		System.out.println(utleiekontor);

		return utleiekontor;
	}

	public static Utleiekontor retursted() {

		System.out.println("Skriv inn hvor du vil returnere bilen: ");
		String by = sc.nextLine();
		Utleiekontor returkontor = bilutleieselskap.KontorEtterNavn(by);
		System.out.println(returkontor);

		return returkontor;
	}

	public static LocalDateTime utleiedato() {

		System.out.println("Skriv inn når du vil hente bilen... (Skriv med tall)\nÅr:");
		int år = Integer.parseInt(sc.nextLine());
		System.out.println("Måned: ");
		int måned = Integer.parseInt(sc.nextLine());
		System.out.println("Dag: ");
		int dag = Integer.parseInt(sc.nextLine());
		System.out.println("Time: ");
		int time = Integer.parseInt(sc.nextLine());
		System.out.println("Minutt: ");
		int minutt = Integer.parseInt(sc.nextLine());
		LocalDateTime tid = LocalDateTime.of(år, måned, dag, time, minutt);
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
		System.out.println("Skriv hvilken kategori du skal bestille: (Bare bokstaven)");
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

	public static Kunde lagreKunde() {

		return null;
	}

}
