package no.hvl.dat109;

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
		
		System.out.println("\n" + "Vi har kontorer i disse byene: " +
		bilutleieselskap.getKontorer() + "\n" + "Skriv inn hvor du vil leie bil fra: ");
		
		String by = sc.nextLine();		
		Utleiekontor utleiekontor = bilutleieselskap.KontorEtterNavn(by);
		System.out.println(utleiekontor);
		System.out.println("Hvor vil du returnere leiebilen?");
		String by2 = sc.nextLine();
		Utleiekontor returkontor = bilutleieselskap.KontorEtterNavn(by2);
		System.out.println(returkontor);
		
	}

}
