package no.hvl.dat109;

public class Validator {

	//Godtar alle bokstaver, lengde på 2-20
	//bruker samme for fornavn og etternavn
	public boolean navnSjekk(String s) {
		
	return s != null && s.matches("^[-a-zA-ZæøåÆØÅ_ ]{2,20}$");		
	}
	
	//Godtar alt, minimumlengde på 5
	public boolean adresseSjekk(String s) {
		
	return s != null && s.matches("^.{5,}$");	
	}
	
	//Skal være 8 siffer
	public boolean telefonNrSjekk(String s) {
		
	return s != null && s.matches("^[0-9]{8}$");
	}
	
	
	
}

