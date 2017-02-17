package fr.esiea.unique.binome.name.dictionary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author Florent
 *
 */

public class PiocheTest {
	private Pioche pioche = new Pioche();
	
	@Test
	public void testMeilleurLettre() {
		char l1 = 'a';
		char l2 = 'b';
		assertTrue(pioche.meilleurLettre(l1, l2));
		assertFalse(pioche.meilleurLettre(l2, l1));
		assertTrue(pioche.meilleurLettre(l1, l1));
	}
	
	@Test
	public void testLetterRandom() {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
	    char c = pioche.letterRandom();
	    assertNotEquals(alphabet.lastIndexOf(c), -1);
	}
}
