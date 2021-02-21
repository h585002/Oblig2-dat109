package no.hvl.dat109;

public class Validator {

	//Godtar alle bokstaver, lengde p� 2-20
	//bruker samme for fornavn og etternavn
	public boolean navnSjekk(String s) {
		
	return s != null && s.matches("^[-a-zA-Z������_ ]{2,20}$");		
	}
	
	//Godtar alt, minimumlengde p� 5
	public boolean adresseSjekk(String s) {
		
	return s != null && s.matches("^.{5,}$");	
	}
	
	//Skal v�re 8 siffer
	public boolean telefonNrSjekk(String s) {
		
	return s != null && s.matches("^[0-9]{8}$");
	}
	
	
	
}

