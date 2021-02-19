package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {

		// Later som vi henter eksisterende kunder, kontorer og biler fra database,
		// istedenfor å implementere det.
		Database database = new Database();
		Bilutleieselskap bilutleieselskap = database.hentInfo();
		Util util = new Util();
				
		// Bør kanskje ha validering på alt
		util.VelkommenMelding();
		util.nyKunde();
		
		System.out.println("\n" + "Hvor ønsker du å leie bil fra?" + "\n" +
		"Vi har kontorer i disse byene: " + bilutleieselskap.getKontorer());

		
	}

}
