package test;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import object.Bilutleieselskap;

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
	public boolean telefonNrSjekk(String s, Bilutleieselskap b) {
		if (s != null && s.matches("^[0-9]{8}$")) {
			List<Integer> nummre = b.getKunder().stream()
					.map(k -> k.getTelefonNr())
					.collect(Collectors.toList());
			if (nummre.contains(Integer.parseInt(s)))
				System.out.println("Kunde med dette telefonnummeret er allerede registrert.");
			else
				return true;
		} else if (s != null)
			System.out.println("Ugyldig input. Prøv igjen. (8 siffer)");
		return false;
	}
	
	public boolean kredittkortNrSjekk(String s) {
		return (s != null && s.matches("^[0-9]{16}$"));
	}

	public boolean kontorSjekk(String s, Bilutleieselskap b) {
		List<String> kontorer = b.getKontorer().stream()
				.map(a -> a.getBy())
				.collect(Collectors.toList());
		if (!kontorer.contains(s.toUpperCase())) {
			System.out.println("Ugyldig input. Prøv igjen. (Skriv en aktuell by)");
			return false;
		}
		return true;
	}
	
	public boolean aarSjekk(String s) {
		int i;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
			return false;
		}
		if (LocalDateTime.now().getYear() > i) {
			System.out.println("Ugyldig input. Prøv igjen. (Kan ikke bestille til en tid som er passert)");
			return false;
		}
		return true;
	}
	
	public boolean maanedSjekk(String s, int aar) {
		int i;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
			return false;
		}
		try {
			LocalDateTime.of(aar, i, 1, 1, 1);
		} catch (DateTimeException e) {
			System.out.println("Ugyldig input. Prøv igjen. (Må være en reell måned)");
			return false;
		}
		if (LocalDateTime.now().getYear() == aar) {
			if (LocalDateTime.now().getMonthValue() > i) {
				System.out.println("Ugyldig input. Prøv igjen. (Kan ikke bestille til en tid som er passert)");
				return false;
			}
		}				
		return true;

	}

	public boolean dagSjekk(String s, int aar, int maaned) {
		int i;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
			return false;
		}
		try {
			LocalDateTime.of(aar, maaned, i, 1, 1);
		} catch (DateTimeException e) {
			System.out.println("Ugyldig input. Prøv igjen. (Må være en reell dag)");
			return false;
		}
		if (LocalDateTime.now().getYear() == aar) {
			if (LocalDateTime.now().getMonthValue() == maaned) {
				if (LocalDateTime.now().getDayOfMonth() > i) {
					System.out.println("Ugyldig input. Prøv igjen. (Kan ikke bestille til en tid som er passert)");
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean timeSjekk(String s) {
		int i;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
			return false;
		}
		if (i < 0 || i > 23) {
			System.out.println("Ugyldig input. Prøv igjen. (Må være et reelt tall for timer)");
			return false;
		}
		return true;
	}
	
	public boolean minuttSjekk(String s) {
		int i;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
			return false;
		}
		if (i < 0 || i > 59) {
			System.out.println("Ugyldig input. Prøv igjen. (Må være et reelt tall for minutt)");
			return false;
		}
		return true;
	}
	
	public boolean dagerSjekk(String s) {
		int i;
		try {
			i = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			System.out.println("Ugyldig input. Prøv igjen. (Bare tall)");
			return false;
		}
		if (i < 1) {
			System.out.println("Ugyldig input. Prøv igjen. (Kan ikke leie for mindre enn 1 dag)");
			return false;
		}
		return true;
	}
	
	public boolean kategoriSjekk(String s, boolean a, boolean b, boolean c, boolean d) {
		if (a)
			if (s.toUpperCase().equals("A"))
				return true;
		if (b)
			if (s.toUpperCase().equals("B"))
				return true;
		if (c)
			if (s.toUpperCase().equals("C"))
				return true;
		if (d)
			if (s.toUpperCase().equals("D"))
				return true;
		System.out.println("Ugyldig input. Prøv igjen. (Skriv en tilgjengelig bokstav)");
		return false;
	}
	
}
