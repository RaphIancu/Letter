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
	private Scanner sc;
	private Dico dico;
	
	public Jeu() {
		pioche = new Pioche();
		lettreSurTable = new ArrayList<Character>();
		j1 = new Joueur();
		j2 = new Joueur();
		sc = new Scanner(System.in);
		dico = new Dico();
	}
	
	public void initJeu() {
		System.out.println("Bienvenu au LettreGame !");
		System.out.println("---------------------------------------------------------------");
		initPseudos();
		quiCommence();
		
	}
	
	public void initPseudos() {
		System.out.println("Indiquez le pseudo du joueur 1:");
		j1.setPseudo(sc.next());
		System.out.println("Indiquez le pseudo du joueur 2:");
		j2.setPseudo(sc.next());
	}
	
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
	
	public void runJeu(Joueur joueur, Joueur joueurAdv) {
		System.out.println("--------------------------------------------------------");
		System.out.println("                   Tour du joueur "+joueur.getPseudo());
		System.out.println("--------------------------------------------------------");
		System.out.println("Lettres disponibles:"+lettreSurTable);
		System.out.println("Les mots de votre adversaire: "+joueurAdv.getJoueurMots());
		System.out.println("Liste de vos mots"+joueur.getJoueurMots());
	}
	
	public void actionMenu(Joueur joueur, Joueur joueurAdv) {
		runJeu(joueur, joueurAdv);
		System.out.println("--------------- Que souhaites tu faire? ----------------");
		System.out.println("[1] Passe ton tour");
		System.out.println("[2] Faire un mot");
		System.out.println("[3] Faire un autre mot à partir d'un mot");
		System.out.println("[4] Abandonner");
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
				abandon(joueur, joueurAdv);
				break;
			default:
				System.out.println("Mauvais choix, recommencez !");
				actionMenu(joueur, joueurAdv);
				break;
			}
		}
	}
	
	public void passe(Joueur joueur, Joueur joueurAdv) {
		char l1 = pioche.letterRandom();
		char l2 = pioche.letterRandom();
		System.out.println("Vous avez pioché un "+l1+" et un "+l2);
		lettreSurTable.add(l1);
		lettreSurTable.add(l2);
		actionMenu(joueurAdv, joueur);
	}
	
	public void faitUnMot(Joueur joueur, Joueur joueurAdv) {
		System.out.println("Entrez votre mot: ");
		String mot = sc.next();
		
		if(dico.motExiste(mot) && motPossible(mot)){
			joueur.setJoueurMots(mot);
		}
		
		actionMenu(joueur, joueurAdv);
	}
	
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
				if(joueur.getJoueurMots().contains(motACompleter)) {
					joueur.getJoueurMots().remove(motACompleter);
					joueur.getJoueurMots().add(nouveauMot);
				} else {
					joueurAdv.getJoueurMots().remove(motACompleter);
					joueur.getJoueurMots().add(nouveauMot);
				}
			}
		} else {
			System.out.println("Ce mot n'a pas encore été fait");
		}
		actionMenu(joueur, joueurAdv);
	}
	
	public void abandon(Joueur joueur, Joueur joueurAdv) {
		System.out.println(joueur.getPseudo()+" a abandonné, "+joueurAdv.getPseudo()+" a gagné !!!");
		System.out.println("Merci d'avoir joué, à la prochaine !");
		System.exit(0);
	}
}