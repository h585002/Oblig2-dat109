package no.hvl.dat109;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

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
	public void telefonNrFalse() {
		assertFalse(validator.telefonNrSjekk("45"));
	}
	
	@Test
	public void telefonNrTrue() {
		assertTrue(validator.telefonNrSjekk("45453423"));
	}
	
	@Test
	public void adresseFalse() {
		assertFalse(validator.adresseSjekk(""));
	}
	
	@Test
	public void adresseTrue() {
		assertTrue(validator.adresseSjekk("Eikelandsbakken 23"));
	}
}
