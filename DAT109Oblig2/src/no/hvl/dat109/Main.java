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
		util.VelkommenMelding();
		util.nyKunde();
		
		System.out.println("\n" + "Vi har kontorer i disse byene: " +
		bilutleieselskap.visKontorer() + "\n" + "Skriv inn tallet på hvor du vil leie bil fra: ");
		
		//Sikkert en bedre måte for at bruker kan velge utleiekontor/bil
		int byIndex = sc.nextInt();		
		Utleiekontor by = kontorer.get(byIndex);
		System.out.println(by);
		
	}

}
