package no.hvl.dat109;

import java.util.ArrayList;
import java.util.List;

public class Database {

	public Bilutleieselskap hentInfo() {

		List<Leiebil> leiebiler1 = new ArrayList<Leiebil>();
		leiebiler1.add(new Leiebil("AB12345", "Toyota", "Big", "Grønn", BilgruppeEnum.STOR, true));
		leiebiler1.add(new Leiebil("EL12345", "Mercedes", "Mini", "Blå", BilgruppeEnum.LITEN, true));
		leiebiler1.add(new Leiebil("AC12345", "Volvo", "Mellow", "Hvit", BilgruppeEnum.MELLOMSTOR, true));

		List<Leiebil> leiebiler2 = new ArrayList<Leiebil>();
		leiebiler2.add(new Leiebil("EL54321", "Toyota", "Small", "Gul", BilgruppeEnum.LITEN, true));
		leiebiler2.add(new Leiebil("AB54321", "BMW", "Truck", "Blå", BilgruppeEnum.STOR, true));

		List<Leiebil> leiebiler3 = new ArrayList<Leiebil>();
		leiebiler3.add(new Leiebil("EL54321", "Toyota", "Small", "Gul", BilgruppeEnum.LITEN, true));
		leiebiler3.add(new Leiebil("AB54321", "BMW", "Truck", "Blå", BilgruppeEnum.STOR, true));

		List<Leiebil> leiebiler4 = new ArrayList<Leiebil>();
		leiebiler4.add(new Leiebil("EL54321", "Toyota", "Small", "Gul", BilgruppeEnum.LITEN, true));
		leiebiler4.add(new Leiebil("AB54321", "BMW", "Truck", "Blå", BilgruppeEnum.STOR, true));

		// Endret adresse til by
		List<Utleiekontor> kontorer = new ArrayList<Utleiekontor>();
		kontorer.add(new Utleiekontor(1, 12341234, "Bergen", "Flyplassvegen 555, 5258 BERGEN", leiebiler1));
		kontorer.add(new Utleiekontor(2, 12121212, "Stavanger", "Flyplassvegen 230, 4055 SOLA", leiebiler2));
		kontorer.add(
				new Utleiekontor(3, 45345676, "Trondheim", "Trondheim lufthavn Værnes, 7502 STJØRDAL", leiebiler3));
		kontorer.add(new Utleiekontor(4, 12343234, "Oslo", "Edvard Munchs veg, 2061 GARDEMOEN", leiebiler4));

		List<Kunde> kunder = new ArrayList<Kunde>();
		kunder.add(
				new Kunde("Ola", "Nordmann", "Gråbakken 7, 1234, Gråfossen", 88888888, new ArrayList<Reservasjon>()));

		return new Bilutleieselskap("Bonanza Bilutleie", 12345678, "Bortegaten 1, 7309, Langtvekke", kontorer, kunder);

	}

}
