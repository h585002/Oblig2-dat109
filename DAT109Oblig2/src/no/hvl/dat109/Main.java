package no.hvl.dat109;

import java.util.Scanner;

public class Main {

	//Midlertidig main, bare � endre p� ting
	//Vil vi gj�re alt med scanner?
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);	
		System.out.println("Velkommen til Bonanza Bilutleie!" + "\n" + "\n" + "Skriv inn dine brukeropplysninger:");
		
		//B�r kanskje ha validering p� alt
		System.out.println("Fornavn:");
		String fornavn = sc.nextLine();
		System.out.println("Etternavn:");
		String etternavn = sc.nextLine();
		System.out.println("Adresse:");
		String adresse = sc.nextLine();
		System.out.println("TelefonNummer:");
		int telefonNr = sc.nextInt();
		
		Kunde kunde = new Kunde(fornavn, etternavn, adresse, telefonNr);
		System.out.println("Stemmer disse opplysningene om deg?" + "\n" + kunde.toString());
		
	}

}
