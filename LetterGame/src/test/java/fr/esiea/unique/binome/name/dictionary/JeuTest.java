package fr.esiea.unique.binome.name.dictionary;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 
 * @author Florent
 *
 */

public class JeuTest {
	private Joueur j1 = new Joueur();
	private Joueur j2 = new Joueur();
	private Joueur ia = new Joueur();
	private Jeu jeu = new Jeu();
	
	@Test
	public void testInitPseudos() {
		jeu.initPseudos();
		assertNotEquals(j1.getPseudo(), null);
		assertNotEquals(j2.getPseudo(), null);
	}

	@Test
	public void testInitPseudo() {
		jeu.initPseudo();
		assertNotEquals(j1.getPseudo(), null);
		assertNotEquals(ia.getPseudo(), null);
		assertNotEquals(ia.getPseudo(), null);
	}
	
	@Test
	public void testFaitUnMotIA() {
		
	}

	@Test
	public void testMotAvecUnMotIA() {
		
	}

	@Test
	public void testMotAvecDeuxMotsIA() {
		
	}

	@Test
	public void testPioche() {
		jeu.pioche();
		assertTrue(jeu.getLettreSurTable().size() >= 1);
	}

	@Test
	public void testFaitUnMot() {
		jeu.faitUnMot(j1, j2);
		assertTrue(jeu.getLettreSurTable().size() >= 1);
	}

	@Test
	public void testMotPossible() {
		jeu.getLettreSurTable().add('t');
		jeu.getLettreSurTable().add('e');
		jeu.getLettreSurTable().add('s');
		jeu.getLettreSurTable().add('t');
		jeu.motPossible("test");
		assertTrue(true);
	}

	@Test
	public void testFaitUnMotAvecUnMot() {
		jeu.getLettreSurTable().add('a');
		jeu.getLettreSurTable().add('b');
		jeu.getLettreSurTable().add('e');
		jeu.getLettreSurTable().add('r');
		j1.getJoueurMots().add("ration");
		jeu.faitUnMotAvecUnMot(j1, j2);
		assertTrue(jeu.getLettreSurTable().size() >= 1);
	}

	@Test
	public void testFaitUnMotAvecDeuxMot() {
		j1.getJoueurMots().add("aber");
		j1.getJoueurMots().add("ration");
		jeu.faitUnMotAvecUnMot(j1, j2);
		assertTrue(jeu.getLettreSurTable().size() >= 1);
	}

	@Test
	public void testRemoveUnMot() {
		j1.getJoueurMots().add("test");
		jeu.removeUnMot(j1, j2, "test");
		assertTrue(j1.getJoueurMots().size() == 0);
	}

	@Test
	public void testTestGagnant() {
		for(int i = 0; i < 9; i++) {
			j1.getJoueurMots().add("test"+i);
		}
		assertTrue(j1.getGagnant());
	}
}
