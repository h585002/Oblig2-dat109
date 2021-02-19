package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {

	public static void main(String[] args) {

		// Later som vi henter eksisterende kunder, kontorer og biler fra database,
		// istedenfor � implementere det.
		Database database = new Database();
		Bilutleieselskap bilutleieselskap = database.hentInfo();
		Util util = new Util();
				
		// B�r kanskje ha validering p� alt
		util.VelkommenMelding();
		util.nyKunde();
		
		System.out.println("\n" + "Hvor �nsker du � leie bil fra?" + "\n" +
		"Vi har kontorer i disse byene: " + bilutleieselskap.getKontorer());

		
	}

}
