package fr.esiea.unique.binome.name.dictionary;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author Florent
 *
 */

public class DicoTest {
	
	private Dico dico = new Dico();

	@Test
	public void testMotExiste() {
		assertTrue(dico.motExiste("maman"));
		assertFalse(dico.motExiste("naman"));
	}
}


