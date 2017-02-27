package fr.esiea.unique.binome.name.dictionary;

import java.util.Random;

/**
 * 
 * @author Raphael
 *
 */

public class Pioche {
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * Appelle la methodé lettreRandom
	 */
	public void piocher() {
		letterRandom();
	}
	
	/**
	 * Tire une lettre au hasard
	 * @return
	 */
	public char letterRandom() {
		Random r = new Random();
		int val = r.nextInt(alphabet.length());
		char lettreRandom = alphabet.charAt(val);
		return lettreRandom;
	}
	
	/**
	 * Détermine la meilleure lettre piochée
	 * @param l1
	 * @param l2
	 * @return
	 */
	public boolean meilleurLettre(char l1, char l2) {
		if((int)l1<=(int)l2){
			return true;
		}else{
			return false;
		}
	}
}
