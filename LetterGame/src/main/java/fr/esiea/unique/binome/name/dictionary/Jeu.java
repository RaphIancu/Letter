package fr.esiea.unique.binome.name.dictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Raphael
 *
 */

public class Jeu {
	private Pioche pioche;
	private List<Character> lettreSurTable;
	private Joueur j1;
	private Joueur j2;
	private Joueur ia;
	private Scanner sc;
	private Dico dico;
	private boolean aJouer;
	
	/**
	 * Initialisation de la classe
	 */
	public Jeu() {
		pioche = new Pioche();
		lettreSurTable = new ArrayList<Character>();
		j1 = new Joueur();
		j2 = new Joueur();
		ia = new Joueur();
		sc = new Scanner(System.in);
		dico = new Dico();
		aJouer = false;
	}
	
	/**
	 * Initialisation de du jeu
	 */
	public void initJeu() {
		System.out.println("Bienvenu au LettreGame !");
		System.out.println("---------------------------------------------------------------");
		choixTypeJeu();		
	}
	
	/**
	 * Choix de l'adversaire (IA ou ami)
	 */
	public void choixTypeJeu() {
		System.out.println("[1] Jouer contre un ami");
		System.out.println("[2] Jouer contre l'ordinateur");
		String choix = sc.next();
		if(choix.length() > 0)
		{
			switch (choix.charAt(0))
			{
			case '1':
				initPseudos();
				quiCommence();
			case '2':
				ia.setIsIA(true);
				initPseudo();
				quiCommence();
			default:
				System.out.println("Mauvais choix !");
				choixTypeJeu();
			}
		}
	}
	
	/**
	 * Initialisation des pseudos avec un ami
	 */
	public void initPseudos() {
		System.out.println("Indiquez le pseudo du joueur 1:");
		j1.setPseudo(sc.next());
		System.out.println("Indiquez le pseudo du joueur 2:");
		j2.setPseudo(sc.next());
	}
	
	/**
	 * Initialisation des pseudos avec une IA
	 */
	public void initPseudo() {
		System.out.println("Indiquez votre pseudo:");
		j1.setPseudo(sc.next());
		ia.setPseudo("IA");
		j2 = ia;
	}
	
	/**
	 * Détermine qui commence à jouer
	 */
	public void quiCommence() {
		System.out.println("-------------------- Le jeu commence -------------------");
		char letterJ1 = pioche.letterRandom();
		char letterJ2 = pioche.letterRandom();
		System.out.println(j1.getPseudo()+" a pioché un :"+letterJ1);
		System.out.println(j2.getPseudo()+" a pioché un :"+letterJ2);
		lettreSurTable.add(letterJ1);
		lettreSurTable.add(letterJ2);
		if(pioche.meilleurLettre(letterJ1,letterJ2)){
			System.out.println(j1.getPseudo()+" commence !");
			actionMenu(j1, j2);
		}else{
			System.out.println(j2.getPseudo()+" commence !");
			actionMenu(j2, j1);
		}
	}
	
	/**
	 * Début du tour d'un joueur, test s'il a gagné
	 * @param joueur
	 * @param joueurAdv
	 */
	public void runJeu(Joueur joueur, Joueur joueurAdv) {
		if(joueur.getGagnant()) {
			System.out.println("Bravo vous avez fait 10 mots !");
			System.out.println(joueur.getPseudo()+" gagne ! \\o/");
			System.exit(0);
		}
		if(joueur.getIsIA()) {
			System.out.println("--------------------------------------------------------");
			System.out.println("                   Tour du joueur "+joueur.getPseudo());
			System.out.println("--------------------------------------------------------");
		} else {
			System.out.println("--------------------------------------------------------");
			System.out.println("                   Tour du joueur "+joueur.getPseudo());
			System.out.println("--------------------------------------------------------");
			System.out.println("Lettres disponibles:"+lettreSurTable);
			System.out.println("Les mots de votre adversaire: "+joueurAdv.getJoueurMots());
			System.out.println("Liste de vos mots"+joueur.getJoueurMots());
		}		
	}
	
	/**
	 * Menu avec choix des actions à effectuer
	 * @param joueur
	 * @param joueurAdv
	 */
	public void actionMenu(Joueur joueur, Joueur joueurAdv) {
		runJeu(joueur, joueurAdv);
		if(joueur.getIsIA()) {
			actionIA(joueur, joueurAdv);
		} else {
			System.out.println("--------------- Que souhaites tu faire? ----------------");
			System.out.println("[1] Passe ton tour");
			System.out.println("[2] Faire un mot");
			System.out.println("[3] Faire un autre mot à partir d'un mot");
			System.out.println("[4] Faire un autre mot à partir de deux mots");
			System.out.println("[5] Abandonner");
			System.out.println("--------------------------------------------------------");
	
			String choix = sc.next();
			if(choix.length() > 0)
			{
				switch (choix.charAt(0))
				{
				case '1':
					passe(joueur, joueurAdv);
					break;
				case '2':
					faitUnMot(joueur, joueurAdv);
					break;
				case '3':
					faitUnMotAvecUnMot(joueur, joueurAdv);
					break;
				case '4':
					faitUnMotAvecDeuxMot(joueur, joueurAdv);
					break;
				case '5':
					abandon(joueur, joueurAdv);
					break;
				default:
					System.out.println("Mauvais choix, recommencez !");
					actionMenu(joueur, joueurAdv);
					break;
				}
			}
		}
	}
	
	/**
	 * Détermine le meilleur choix de jeu IA
	 * @param joueur
	 * @param joueurAdv
	 */
	public void actionIA(Joueur joueur, Joueur joueurAdv) {
		motAvecUnMotIA(joueur, joueurAdv);
		if(aJouer) {
			aJouer = false;
			actionMenu(joueurAdv, joueur);
		} else {
			faitUnMotIA(joueur, joueurAdv);
			if(aJouer) {
				aJouer = false;
				actionMenu(joueurAdv, joueur);
			} else {
				motAvecDeuxMotsIA(joueur, joueurAdv);
				if(aJouer) {
					aJouer = false;
					actionMenu(joueurAdv, joueur);
				} else {
					passe(joueur, joueurAdv);
					actionMenu(joueurAdv, joueur);
				}
			}
		}
	}
	
	/**
	 * L'IA fait un mot
	 * @param joueur
	 * @param joueurAdv
	 */
	public void faitUnMotIA(Joueur joueur, Joueur joueurAdv) {

		
	}

	/**
	 * L'IA fait un mot avec un mot déjà fait
	 * @param joueur
	 * @param joueurAdv
	 */
	public void motAvecUnMotIA(Joueur joueur, Joueur joueurAdv) {
		
	}
	
	/**
	 * L'IA fait un mot avec deux mots déjà fait
	 * @param joueur
	 * @param joueurAdv
	 */
	public void motAvecDeuxMotsIA(Joueur joueur, Joueur joueurAdv) {
		
	}
	
	/**
	 * Le joueur passe son tour, pioche 2 lettres
	 * @param joueur
	 * @param joueurAdv
	 */
	public void passe(Joueur joueur, Joueur joueurAdv) {
		char l1 = pioche.letterRandom();
		char l2 = pioche.letterRandom();
		if(joueur.getIsIA()) {
			System.out.println("L'IA a pioché un "+l1+" et un "+l2);
		} else {
			System.out.println("Vous avez pioché un "+l1+" et un "+l2);
		}
		lettreSurTable.add(l1);
		lettreSurTable.add(l2);
		actionMenu(joueurAdv, joueur);
	}
	
	/**
	 * On pioche une lettre
	 */
	public void pioche() {
		char l1 = pioche.letterRandom();
		System.out.println("Vous avez pioché un "+l1);
		lettreSurTable.add(l1);
	}
	
	/**
	 * On fait un mot
	 * @param joueur
	 * @param joueurAdv
	 */
	public void faitUnMot(Joueur joueur, Joueur joueurAdv) {
		System.out.println("Entrez votre mot: ");
		String mot = sc.next();
		
		if(dico.motExiste(mot) && motPossible(mot)){
			joueur.setJoueurMots(mot);
			testGagnant(joueur);
			pioche();
		}
		actionMenu(joueur, joueurAdv);
	}
	
	/**
	 * Détermine si le mot est possible avec les lettres du pot commun
	 * @param mot
	 * @return
	 */
	public boolean motPossible(String mot) {
		boolean bool = true;
		List<Character> lettreARemove = new ArrayList<Character>();
		
		for(int i = 0; i < mot.length(); i++) {
			Character charMot = mot.charAt(i);
			if(!lettreSurTable.contains(charMot)){
				System.out.println("Vous pouvez pas faire ce mot avec les lettres disponibles");
				bool = false;
				break;
			} else {
				lettreARemove.add(charMot);
			}
		}
		
		if(bool) {
			for (int j = 0; j < lettreARemove.size(); j++) {
				lettreSurTable.remove(lettreARemove.get(j));
			}
		}
		return bool;
	}
	
	/**
	 * On fait un mot avec un autre mot
	 * @param joueur
	 * @param joueurAdv
	 */
	public void faitUnMotAvecUnMot(Joueur joueur, Joueur joueurAdv) {
		System.out.println("Quel mot souhaitez vous compléter: ");
		String motACompleter = sc.next();
		
		if(joueur.getJoueurMots().contains(motACompleter) || joueurAdv.getJoueurMots().contains(motACompleter)) {
			for(int i = 0; i < motACompleter.length(); i++) {
				Character lettre = motACompleter.charAt(i);
				lettreSurTable.add(lettre);
			}
			System.out.println("Quel est votre nouveau mot?");
			String nouveauMot = sc.next();
			
			if(nouveauMot.contains(motACompleter) && motPossible(nouveauMot)) {
				removeUnMot(joueur, joueurAdv, motACompleter);
				joueur.getJoueurMots().add(nouveauMot);
				testGagnant(joueur);
				pioche();
			} else {
				for(int i = 0; i < motACompleter.length(); i++) {
					Character lettre = motACompleter.charAt(i);
					lettreSurTable.remove(lettre);
				}
				System.out.println("C'est le même mot, petit tricheur ;)");
			}
		} else {
			System.out.println("Ce mot n'a pas encore été fait");
		}
		actionMenu(joueur, joueurAdv);
	}
	
	/**
	 * On fait un mot avec deux mots existants
	 * @param joueur
	 * @param joueurAdv
	 */
	public void faitUnMotAvecDeuxMot(Joueur joueur, Joueur joueurAdv) {
		System.out.println("Quel est le premier mot à utiliser: ");
		String premierMot = sc.next();
		
		if(joueur.getJoueurMots().contains(premierMot) || joueurAdv.getJoueurMots().contains(premierMot)) {
			System.out.println("Quel est le deuxième mot à utiliser: ");
			String deuxiemeMot = sc.next();
			if(joueur.getJoueurMots().contains(deuxiemeMot) || joueurAdv.getJoueurMots().contains(deuxiemeMot)) {
				String nouveauMot = premierMot.concat(deuxiemeMot);
				if(dico.motExiste(nouveauMot)) {
					removeUnMot(joueur, joueurAdv, premierMot);
					removeUnMot(joueur, joueurAdv, deuxiemeMot);
					joueur.getJoueurMots().add(nouveauMot);
					testGagnant(joueur);
					pioche();
				}
			} else {
				System.out.println("Ce mot n'a pas encore été fait");
			}
		} else {
			System.out.println("Ce mot n'a pas encore été fait");
		}
		actionMenu(joueur, joueurAdv);
	}
	
	/**
	 * Retire un mot déjà réaliser par un joueur
	 * @param joueur
	 * @param joueurAdv
	 * @param mot
	 */
	public void removeUnMot(Joueur joueur, Joueur joueurAdv, String mot) {
		if(joueur.getJoueurMots().contains(mot)) {
			joueur.getJoueurMots().remove(mot);
		} else {
			joueurAdv.getJoueurMots().remove(mot);
		}
	}
	
	/**
	 * Le joueur abandonne
	 * @param joueur
	 * @param joueurAdv
	 */
	public void abandon(Joueur joueur, Joueur joueurAdv) {
		System.out.println(joueur.getPseudo()+" a abandonné, "+joueurAdv.getPseudo()+" a gagné !!!");
		System.out.println("Merci d'avoir joué, à la prochaine !");
		System.exit(0);
	}
	
	/**
	 * Détermine si on a fait 10 mots
	 * @param joueur
	 */
	public void testGagnant(Joueur joueur) {
		if(joueur.getJoueurMots().size() >= 10) {
			joueur.setGagnant(true);
		}
	}
}