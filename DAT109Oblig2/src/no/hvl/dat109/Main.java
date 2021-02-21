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

	public static void main(String[] args) {

		// Later som vi henter eksisterende kunder, kontorer og biler fra database,
		// istedenfor å implementere det.
		Database database = new Database();
		bilutleieselskap = database.hentInfo();
		List<Utleiekontor> kontorer = bilutleieselskap.getKontorer();
		reservasjon = new Reservasjon();

		System.out.println("\n" + "Vi har kontorer i disse byene: " + bilutleieselskap.getKontorer());

	}

	public Utleiekontor utleiested() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Skriv inn hvor du vil leie bil fra: ");
		String by = sc.nextLine();
		Utleiekontor utleiekontor = bilutleieselskap.KontorEtterNavn(by);
		System.out.println(utleiekontor);

		sc.close();
		return utleiekontor;
	}

	public Utleiekontor retursted() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Skriv inn hvor du vil returnere bilen: ");
		String by = sc.nextLine();
		Utleiekontor returkontor = bilutleieselskap.KontorEtterNavn(by);
		System.out.println(returkontor);

		sc.close();
		return returkontor;
	}

	public LocalDateTime utleiedato() {
		Scanner sc = new Scanner(System.in);

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
		
		sc.close();
		return tid;
	}

	public int antallDager() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Hvor mange dager skal du leie bilen? ");
		int dager = Integer.parseInt(sc.nextLine());
		System.out.println(dager);
		
		sc.close();
		return dager;
	}

	public String kategori() {
		Scanner sc = new Scanner(System.in);
		
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
		int gebyr = 0;
		if (!kontor.equals(retur))
			gebyr = 100;
		if (a) {
			System.out.println("A - Liten");
		}
		if (b) {
			System.out.println("B - Mellomstor");
		}
		if (c) {
			System.out.println("C - Stor");
		}
		if (d) {
			System.out.println("D - Stasjonsvogn");
		}
		System.out.println("Skriv hvilken kategori du skal bestille: (Bare bokstaven)");
		BilgruppeEnum kat;
		switch (sc.nextLine().toUpperCase()) {
			case "A":
				;
			case "B":;
			case "C":;
			case "D":;
			default:;
		}		

		sc.close();
		return null;
	}

	public Kunde lagreKunde() {
		Scanner sc = new Scanner(System.in);

		sc.close();
		return null;
	}

}
