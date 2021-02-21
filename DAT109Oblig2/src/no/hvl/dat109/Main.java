package no.hvl.dat109;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	static Bilutleieselskap bilutleieselskap;
	static Reservasjon reservasjon;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// Later som vi henter eksisterende kunder, kontorer og biler fra database,
		// istedenfor å implementere det.
		Database database = new Database();
		bilutleieselskap = database.hentInfo();
		reservasjon = new Reservasjon();

		System.out.println("\n" + "Vi har kontorer i disse byene: " + bilutleieselskap.getKontorer());
		reservasjon.setUtleiekontor(utleiested());
		reservasjon.setReturkontor(retursted());
		reservasjon.setUtleiedato(utleiedato());
		reservasjon.setAntallDager(antallDager());
		reservasjon.setPris(pris());

		sc.close();
		
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
			System.out.println("A - Liten: " + (Priser.getA()*reservasjon.getAntallDager() + pris) + "kr for " + reservasjon.getAntallDager() + " dager");
		}
		if (b) {
			System.out.println("B - Mellomstor: " + (Priser.getB()*reservasjon.getAntallDager() + pris) + "kr for " + reservasjon.getAntallDager() + " dager");
		}
		if (c) {
			System.out.println("C - Stor: " + (Priser.getC()*reservasjon.getAntallDager() + pris) + "kr for " + reservasjon.getAntallDager() + " dager");
		}
		if (d) {
			System.out.println("D - Stasjonsvogn: " + (Priser.getD()*reservasjon.getAntallDager() + pris) + "kr for " + reservasjon.getAntallDager() + " dager");
		}
		System.out.println("Skriv hvilken kategori du skal bestille: (Bare bokstaven)");
		switch (sc.nextLine().toUpperCase()) {
			case "A":
				pris += Priser.getA();
			case "B":
				pris += Priser.getB();
			case "C":
				pris += Priser.getC();
			case "D":
				pris += Priser.getD();
			default:;
		}		

		return pris;
	}

	public static Kunde lagreKunde() {

		return null;
	}

}
