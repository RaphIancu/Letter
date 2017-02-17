package fr.esiea.unique.binome.name.dictionary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author Florent
 *
 */

public class JeuTest {
	private Pioche pioche = new Pioche();
	private List<Character> lettreSurTable = new LinkedList<Character>();
	private Joueur j1 = new Joueur();
	private Joueur j2 = new Joueur();
	private Joueur ia = new Joueur();
	private Dico dico = new Dico();
	private boolean aJouer = false;
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
		
	}

	@Test
	public void testMotPossible() {
		
	}

	@Test
	public void testFaitUnMotAvecUnMot() {
		
	}

	@Test
	public void testFaitUnMotAvecDeuxMot() {
		
	}

	@Test
	public void testRemoveUnMot() {
		
	}

	@Test
	public void testTestGagnant() {
		
	}
}
