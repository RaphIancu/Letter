/**
 * 
 * @author Raphael
 *
 */

package fr.esiea.unique.binome.name.dictionary;

import java.util.LinkedList;

public class Joueur {
	private String pseudo;
	private int nbMot;
	private LinkedList<String> joueurMots;
	private boolean gagnant;
	private boolean isIA;
	
	public Joueur() {
		this.pseudo = "";
		this.nbMot = 0;
		this.joueurMots = new LinkedList<String>();
		this.gagnant = false;
		this.isIA = false;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public int getNbMot() {
		return nbMot;
	}
	
	public void setNbMot() {
		this.nbMot = joueurMots.size();
	}
	
	public LinkedList<String> getJoueurMots() {
		return joueurMots;
	}
	
	public String getJoueurMotsToString() {
		return joueurMots.toString();
	}
	
	public void setJoueurMots(String unMot) {
		this.joueurMots.add(unMot);
	}
	
	public boolean getGagnant() {
		return gagnant;
	}
	
	public void setGagnant(boolean gagne) {
		this.gagnant = gagne;
	}
	
	public boolean getIsIA() {
		return isIA;
	}
	
	public void setIsIA(boolean isIA) {
		this.isIA = isIA;
	}
}