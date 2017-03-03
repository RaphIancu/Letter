# Projet Architecture Logicielle - LetterGame - 03-03-2017

Bienvenue sur le dépôt du groupe `IANCU Raphaël` et `COULON Florent` - `4A-UFA`.


## Projet réalisé
Nous avons décidé de réaliser un LetterGame où nous pouvons jouer contre une IA via la console.
Le menu console se veut le plus clair possible en proposant des choix simples à l'utilisateur ([1],[2],[3]...).
Pour plus de détails sur les règles du jeu, veuiller suivre ce lien: 
[Consignes](https://github.com/MLabusquiere/TP_4A_2017_Letter_Game)

## Compilation du projet
Aller dans le dossier LetterGame de notre projet via une console:
```
cd /LetterGame-IANCU-COULON/LetterGame/
```

Puis exécuter cette commande où se trouve le pom.xml:
```
mvn exec:java -Dexec.mainClass="fr.esiea.unique.binome.name.dictionary.MainConsole"
```

## Description de l'architecture
Nous avons découpé notre code selon plusieurs classes:

- **Joueur**

Cette classe nous permet de gérer tout ce qui concerne un joueur (IA comprise) comme son pseudo, ses mots réalisés...

- **Pioche**

Cette classe nous permet de piocher une lettre aléatoire ou de savoir qui commence son tour.

- **Jeu**

Cette classe englobe les fonctionnalités du jeu comme les tours des joueurs et de pouvoir faire un mot seul ou avec d'autre(s) mot(s).
L'affichage en console est également gérée dans cette classe.

- **Dico**

Cette classe nous permet de savoir si un mot existe ou non dans le dictionnaire.

- **MainConsole**

Cette classe nous permet de lancer le jeu grâce à la méthode main().

Nous avons utilisé le CMD Findbugs et avons fait en sorte qu'il y ai le moins d'avertissements possibles (2 warnings en tout, hors classe dictionnary qui était fournise et qu'il n'a pas été utilisée).

## Fonctionnement de l'IA
Il est possible de jouer et peut être de gagner contre notre IA. A chacun de ses tours, l'IA teste si elle peut faire un mot avec les lettres du pot commun, avec un autre mot (uniquement les siens pour laisser une chance au joueur de gagner) ou avec deux mots.
Lorsqu'elle fait un mot, celle-ci prend le mot le plus long à réaliser pour laisser le moins de chances au joueur.

## Illustration de trois Design Pattern
Nous n'avons utilisé aucun design pattern dans notre projet, M. Ledoyen nous a indiqué qu'il n'était pas obligatoire d'en utiliser dans notre code.
Nous allons donc expliquer trois Design Pattern, un de création, un structurel et un de comportement.

###Le pattern Singleton:
Le singleton est peut être le design pattern le plus simple mais également le plus utile.
Il nous permet de pouvoir créer qu'un seule instance pour une classe. La classe fournit donc un moyen d'accèder à son seul objet qui peut être utilisé sans avoir à instancier l'objet de la classe.
	
	public class unSeulObjet {
		private static unSeulObjet instance = new unSeulObjet();
		private unSeulObjet() {}
		public static unSeulObjet getInstance() {
			return instance;
		}

		public void testMessage() {
			System.out.println("Le singleton marche !");
		}
	}
	public class SingletonPatternDemo {
		public static void main(String[] args) {
			unSeulObjet objet = unSeulObjet.getInstance();
			objet.testMessage();
		}
	}
	
Nous aurions pu utiliser un Singleton pour la classe Dico afin de parser le dictionnaire qu'une seule fois et d'appeler son instance.

###Le pattern Adapter:
Avec un pattern Adapter, c'est comme un pont entre deux interfaces incompatibles. Il permet de combiner la capacité de deux interfaces indépendantes.
Ce modèle implique une seule classe qui est responsable de se joindre à des fonctionnalités d'interfaces indépendantes.
Cela permet que les classes puissent interagir ensemble tandis qu'elles étaient incapables avant.

Comme par exemple, les prises anglaises et françaises sont différentes, mais on peut recharger son portable grâce à un adapteur. 
C'est exactement ce que permet de faire le pattern Adapter entre nos interfaces.


###Le pattern Iterator:
Il fourni un moyen d'accéder aux éléments d'un objet de manière séquentielle sans avoir à en connaitre la structure interne.

Il se positionne au début d'un objet, par exemple une liste, et d'avancer pas à pas.
Iterator permettent d'itérer toutes sortes de données mais en étant plus robuste qu'une boucle "for" même en cas de changement dans la structure des données.

Nous aurions pu utiliser ce design pattern pour parcourir la liste des lettres du pot commun ou les mots des joueurs.

## Commentaires
Nous avons été deux à travailler sur le projet mais github n'affiche qu'un seul contributeur malgré que ce soit Florent Coulon qui ai fait certains push.
Ci-dessous un lien avec une capture d'écran montrant ces push:
[http://imgur.com/D8kmKsp](http://imgur.com/D8kmKsp)







