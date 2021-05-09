# POGL-Project
**INTRODUCTION :**
Ce projet est à réaliser en groupes de un à trois et il nous invite à construire une version electronique et simplifiée du jeu Colt Express.
A l'aide de github.com, notre trinôme (_MSILINI Yassine_ALIOUCHOUCHE Ilan_KHAIRALLAH Marwan_) a pu réaliser le Projet qui nous invite à construire une version élécronique et simplifiée du jeu de plateau Colt Express, cette plateforme nous a permis de travailler efficacement et rapidement sur la conception du jeu dans tous ces aspects.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**REGLES DU JEU :**

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**PARTIES DU SUJET TRAITEES :**
Au niveau de l'implementation des aspects du jeu demandés par le sujet, tout a été fait, ensuite pour la partie dite "Libre" où nous devions rajouter une fonctionnalité bonus, nous avons décidé de faire une bulle d'affichage des actions faites par les joueurs ainsi qu'une interface qui permet de jouer de maniere optimisé à plusieurs sur un seul écran.
Sur notre version, le jeu est jouable de 1 à 4 joueurs (_ceci est dû à la limite de l'interface visuelle_) dans un train avec tout au plus 6 wagons.
Nous avons aussi rajouté la possibilité d'ajuster la nervosité du Marshall. La personnalisation du jeu pour les joueurs s'etends jusqu'à, le choix du nom du bandit, la nervosite du Marshall, la taille du plateau (_donc le nombre de wagons_) et enfin, le choix de retour en arrière en pleine partie.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**ARCHITECTURE DU PROJET :**
Pour l'architecture suivie, nous avons décidé de rester sur une architecture classique qui était suggerée par le sujet : Modele-Vue-Controleur plus communément appelé MVC.

**_Modele :_**
Le Modele était composé des classes les plus importante au projet, comme son nom l'indique nous avions simplement les templates de tout les élèments du jeu que ça soit le Marhsall, les Bandis, le Train, les Butins ainsi que les actions possibles dans le jeu tout a fait et ordonnées de manière logique et cohérente (_au niveau de la création des classes et de l'utilisation de notre propre diagramme de classe_).

**_Vue :_**
La vue était composée des classes permettant l'affichage des élèments du train comme les butins, la position du Marshall ainsi que des bandits mais aussi le nombre wagons etc.

**_Controleur :_**
Le Controleur était composé de deux classes permettant le bon fonctionnement des mouvements : Action et Direction ainsi que du main permettant le lancement du jeu.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**TRAVAIL EFFECTUE :**

Classe : |	Code : |	Progression : |	Difficulté sur 5 : | Compléter/Corriger : |
---------|---------|----------------|--------------------|----------------------|                  
Main.java |	Yassine	|Classe complète. |	2| [x]
Action.java |	Ilan	|Complet, correction de syntaxe. |	0| [x]
Direction.java |	Marwan |	Complet, correction de syntaxe. |	0| [x]
Bandit.java |	Marwan	|Classe complète |	3| [x]
Train.java |	Yassine|	Classe complète. |	4.5| [x]
Marshall.java |	Yassine	|Classe complète. |	2| [x]
VueTrain.java | Marwan |Classe complète.|	3 | [x]
Butin.java | Ilan | Classe complète. | 4 | [x]
Action2.java | Ilan | Classe complète.| 4 |[x]
Affichage.java | Yassine | Commencement de la fenêtre de jeu. | 5 |[x]
