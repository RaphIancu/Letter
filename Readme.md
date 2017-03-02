# Projet Architecture Logicielle - LetterGame - 03-03-2017

Bienvenue sur le dépôt du groupe `IANCU Raphaël` et `COULON Florent`.


## Projet réalisé
Nous avons décidé de réaliser un LetterGame où nous pouvons jouer contre une IA via la console.
Le menu console se veut le plus clair possible en proposant des choix à l'utilisateur (1,2,3...).
Pour plus de détails sur les règles du jeu, veuillez suivre ce lien: 
[Consignes](https://github.com/MLabusquiere/TP_4A_2017_Letter_Game)

## Description de l'architecture
Nous avons découpé notre code selon plusieurs classes:

- **Joueur**

Cette classe nous permet de gérer tout ce qui concerne un joueur (IA comprise) comme son pseudo, ses mots réalisés...

- **Pioche**

Cette classe nous permet de piocher une lettre aléatoire ou de savoir qui commence son tour.

- **Jeu**

Cette classe englobe les fonctionnalités du jeu comme les tours des joueurs et de pouvoir faire un mot seul ou avec d'autre(s) mot(s).

- **Dico**

Cette classe nous permet de savoir si un mot existe ou non dans le dictionnaire.

- **MainConsole**

Cette classe nous permet de lancer le jeu grâce au main()

## Illustration de 3 principes SOLID ou Design Pattern


## Compilation du projet
Aller dans le dossier LetterGame de notre projet via une console:
```
cd /LetterGame-IANCU-COULON/LetterGame/
```

Puis exécuter cette commande où se trouve le pom.xml:
```
mvn exec:java -Dexec.mainClass="fr.esiea.unique.binome.name.dictionary.MainConsole"
```

## Commentaires
Nous avons été deux à travailler sur le projet mais github n'affiche qu'un seul contributeur malgré que ce soit Florent Coulon qui ai fait certains push.
Ci-dessous un lien avec une capture d'écran montrant ces push:
[http://imgur.com/D8kmKsp](http://imgur.com/D8kmKsp)
