package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

public class Database {

	public Bilutleieselskap hentInfo() {

		List<Leiebil> leiebiler1 = new ArrayList<Leiebil>();
		leiebiler1.add(new Leiebil("AB12345", "Toyota", "Big", "Gr�nn", "C", true));
		leiebiler1.add(new Leiebil("EL12345", "Mercedes", "Mini", "Bl�", "A", true));
		leiebiler1.add(new Leiebil("AC12345", "Volvo", "Mellow", "Hvit", "B", true));

		List<Leiebil> leiebiler2 = new ArrayList<Leiebil>();
		leiebiler2.add(new Leiebil("EL54321", "Toyota", "Small", "Gul", "A", true));
		leiebiler2.add(new Leiebil("AB54321", "BMW", "Truck", "Bl�", "D", true));

		List<Utleiekontor> kontorer = new ArrayList<Utleiekontor>();
		kontorer.add(new Utleiekontor(1, 12341234, "Gr�gaten 14, 1234, Gr�fossen", leiebiler1));
		kontorer.add(new Utleiekontor(2, 12121212, "Bakkegaten 32, 4321, Bakkestedet", leiebiler2));

		List<Kunde> kunder = new ArrayList<Kunde>();
		kunder.add(
				new Kunde("Ola", "Nordmann", "Gr�bakken 7, 1234, Gr�fossen", 88888888, new ArrayList<Reservasjon>()));

		return new Bilutleieselskap("Bonanza Bilutleie", 12345678, "Bortegaten 1, 7309, Langtvekke", kontorer, kunder);

	}

}
