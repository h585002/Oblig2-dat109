package no.hvl.dat109;

import java.util.List;
import java.util.stream.Collectors;

public class Validator {

	// Godtar alle bokstaver, lengde på 2-20
	// bruker samme for fornavn og etternavn
	public boolean navnSjekk(String s) {
		return s != null && s.matches("^[-a-zA-ZæøåÆØÅ_ ]{2,20}$");
	}

	// Godtar alt, minimumlengde på 5
	public boolean adresseSjekk(String s) {
		return s != null && s.matches("^.{5,}$");
	}

	// Skal være 8 siffer
	public boolean telefonNrSjekk(String s) {
		return s != null && s.matches("^[0-9]{8}$");
	}

	public boolean kontorSjekk(String s, Bilutleieselskap b) {
		List<String> kontorer = b.getKontorer().stream()
				.map(a -> a.getBy())
				.collect(Collectors.toList());
		if (kontorer.contains(s.toUpperCase()))
			return true;
		return false;
	}
	
	public boolean aarSjekk(String s) {
		
	}
	
	public boolean maanedSjekk(String s) {
		
	}

	public boolean dagSjekkSjekk(String s) {
	
	}
	
	public boolean timeSjekk(String s) {
		
	}
	
	public boolean minuttSjekk(String s) {
		
	}
	
}
