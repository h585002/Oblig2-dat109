package object;

import java.util.ArrayList;
import java.util.List;

/**
 * En fake database.
 * 
 * @author Vebjoern Vaardal
 *
 */
public class Database {

	public Bilutleieselskap hentInfo() {

		List<Leiebil> leiebiler1 = new ArrayList<Leiebil>();
		leiebiler1.add(new Leiebil("AB12345", "Toyota", "Big", "Gr�nn", BilgruppeEnum.STOR, true));
		leiebiler1.add(new Leiebil("EL12345", "Mercedes", "Mini", "Bl�", BilgruppeEnum.LITEN, true));
		leiebiler1.add(new Leiebil("AC12345", "Volvo", "Mellow", "Hvit", BilgruppeEnum.MELLOMSTOR, true));

		List<Leiebil> leiebiler2 = new ArrayList<Leiebil>();
		leiebiler2.add(new Leiebil("EL54321", "Toyota", "Small", "Gul", BilgruppeEnum.LITEN, true));
		leiebiler2.add(new Leiebil("AB54321", "BMW", "Truck", "Bl�", BilgruppeEnum.STASJONSVOGN, true));

		List<Leiebil> leiebiler3 = new ArrayList<Leiebil>();
		leiebiler3.add(new Leiebil("EL54321", "Toyota", "Small", "Gul", BilgruppeEnum.LITEN, true));
		leiebiler3.add(new Leiebil("AB54321", "BMW", "Truck", "Bl�", BilgruppeEnum.STASJONSVOGN, true));

		List<Leiebil> leiebiler4 = new ArrayList<Leiebil>();
		leiebiler4.add(new Leiebil("EL54321", "Toyota", "Small", "Gul", BilgruppeEnum.LITEN, true));
		leiebiler4.add(new Leiebil("AB54321", "BMW", "Truck", "Bl�", BilgruppeEnum.STASJONSVOGN, true));

		// Endret adresse til by
		List<Utleiekontor> kontorer = new ArrayList<Utleiekontor>();
		kontorer.add(new Utleiekontor(1, 12341234, "BERGEN", "Flyplassvegen 555, 5258 BERGEN", leiebiler1));
		kontorer.add(new Utleiekontor(2, 12121212, "STAVANGER", "Flyplassvegen 230, 4055 SOLA", leiebiler2));
		kontorer.add(
				new Utleiekontor(3, 45345676, "TRONDHEIM", "Trondheim lufthavn V�rnes, 7502 STJ�RDAL", leiebiler3));
		kontorer.add(new Utleiekontor(4, 12343234, "OSLO", "Edvard Munchs veg, 2061 GARDEMOEN", leiebiler4));

		return new Bilutleieselskap("Bonanza Bilutleie", 12345678, "Bortegaten 1, 7309, Langtvekke", kontorer, new ArrayList<Kunde>());

	}

	public void lagreInfo() {
		// Gj�r ingenting
	}

}
