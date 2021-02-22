package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class ValidatorTest {

	public Validator validator = new Validator();
	
	
	@Test
	public void etternavnFalse() {
		assertFalse(validator.navnSjekk("�ystein3"));
	}
	
	@Test
	public void etternavnTrue() {
		assertTrue(validator.navnSjekk("�ystein "));
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
