package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import object.Bilutleieselskap;
import object.Database;

public class ValidatorTest {
	
	static Database database = new Database();
	static Bilutleieselskap bilutleieselskap = database.hentInfo();

	public Validator validator = new Validator();
	
	
	@Test
	public void etternavnFalse() {
		assertFalse(validator.navnSjekk("Øystein3"));
	}
	
	@Test
	public void etternavnTrue() {
		assertTrue(validator.navnSjekk("Øystein "));
	}
	
	@Test
	public void adresseFalse() {
		assertFalse(validator.adresseSjekk(""));
	}
	
	@Test
	public void adresseTrue() {
		assertTrue(validator.adresseSjekk("Eikelandsbakken 23"));
	}
	
	@Test
	public void TelefonNrTrue() {
		assertTrue(validator.telefonNrSjekk("34343434", bilutleieselskap));
	}
	
	@Test
	public void TelefonNrFalse() {
		assertFalse(validator.telefonNrSjekk("23", bilutleieselskap));
	}
	
	@Test
	public void kredittkortTrue() {
		assertTrue(validator.kredittkortNrSjekk("1122334455667788"));
	}
	
	@Test
	public void kontorTrue() {
		assertTrue(validator.kontorSjekk("Oslo", bilutleieselskap));
	}
	
	@Test
	public void kontorFalse() {
		assertFalse(validator.kontorSjekk("Osl", bilutleieselskap));
	}
	
	@Test
	public void aarTrue() {
		assertTrue(validator.aarSjekk("2021"));
	}
	
	@Test
	public void maanedTrue() {
		assertTrue(validator.maanedSjekk("02", 2021));
	}
	
	@Test
	public void dagFalse() {
		assertFalse(validator.dagSjekk("88", 2021, 02));
	}
	
	@Test
	public void timeFalse() {
		assertFalse(validator.timeSjekk("34"));
	}
	
	@Test
	public void minuttTrue() {
		assertTrue(validator.minuttSjekk("15"));
	}
	
	@Test
	public void dagerFalse() {
		assertFalse(validator.dagerSjekk("-1"));
	}
	
	@Test
	public void kategoriTrue() {
		assertTrue(validator.kategoriSjekk("A", true, false, false, false));
	}
	
	@Test
	public void kategoriFalse() {
		assertFalse(validator.kategoriSjekk("b", true, false, false, false));
	}
}
