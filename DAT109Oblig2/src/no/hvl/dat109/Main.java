package no.hvl.dat109;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {

		// Later som vi henter eksisterende kunder, kontorer og biler fra database,
		// istedenfor å implementere det.
		Database database = new Database();
		Bilutleieselskap bilutleieselskap = database.hentInfo();
		List<Utleiekontor> kontorer = bilutleieselskap.getKontorer();
		Util util = new Util();
		Scanner sc = new Scanner(System.in);
			
		// Bør kanskje ha validering på alt
		//util.VelkommenMelding();
		//util.nyKunde();
		
		DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
		
		System.out.println("\n" + "Vi har kontorer i disse byene: " +
		bilutleieselskap.getKontorer() + "\n" + "Skriv inn hvor du vil leie bil fra: ");
		
		String by = sc.nextLine();		
		Utleiekontor utleiekontor = bilutleieselskap.KontorEtterNavn(by);
		System.out.println(utleiekontor);
		System.out.println("Hvor vil du returnere leiebilen?");
		String by2 = sc.nextLine();
		Utleiekontor returkontor = bilutleieselskap.KontorEtterNavn(by2);
		System.out.println(returkontor);
		
		System.out.println("Skriv inn dato du ønsker å leie fra. (dd/MM/yyyy)");
		String stringdato = sc.nextLine();
		System.out.println();
		
		dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dato = LocalDate.parse(stringdato, dtf);
		System.out.println(dato);
		
		System.out.println("Skriv inn ønsket klokkeslett for utleie. (HH:mm)");
		String klokke = sc.nextLine();
		dtf = DateTimeFormatter.ofPattern("hh:mm");
		LocalTime tidspunkt = LocalTime.parse(klokke);
		System.out.println(tidspunkt);
		
		System.out.println("Skriv inn hvor mange dager du vil leie bilen: ");
		int dager = sc.nextInt();
		System.out.println(dager);
	}
	
	public Utleiekontor utleiested() {
		return null;
	}
	
	public Utleiekontor retursted() {
		return null;
	}

	public LocalDateTime utleiedato() {
		return null;
	}
}
