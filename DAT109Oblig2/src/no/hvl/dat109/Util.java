package no.hvl.dat109;

import java.util.ArrayList;
import java.util.Scanner;

public class Util {

	Scanner sc = new Scanner(System.in);
	
	
	public void VelkommenMelding() {	
		
	System.out.println("Velkommen til Bonanza Bilutleie!" + "\n" + 
	"\n" + "Skriv inn dine brukeropplysninger:");
	}
	
	//Oppretter en ny kunde fra brukerinput
	public Kunde nyKunde() {
		
	System.out.println("Fornavn:");
	String fornavn = sc.nextLine();
	System.out.println("Etternavn:");
	String etternavn = sc.nextLine();
	System.out.println("Adresse:");
	String adresse = sc.nextLine();
	System.out.println("TelefonNummer:");
	int telefonNr = sc.nextInt();	
	
	Kunde kunde = new Kunde(fornavn, etternavn, adresse, telefonNr, new ArrayList<Reservasjon>());
	System.out.println("Opplysningene du har gitt:" + "\n" + kunde.toString());
	
	return kunde;	
	}
	
}
