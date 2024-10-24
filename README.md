# Colors Witch

## Description
Colors Witch est un jeu inspiré du célèbre jeu mobile Color Switch. Dans ce jeu, vous incarnez une sorcière qui doit naviguer à travers divers obstacles colorés. 
La sorcière, représentée par une boule d'énergie, ne peut traverser un obstacle que si elle est de la même couleur.
Les joueurs peuvent trouver des potions magiques pour changer la couleur de la sorcière et ainsi passer à travers des obstacles.

## Fonctionnalités
- Mode de test pour tester les obstacles sans risque de perte.
- Trois nouveaux types d'obstacles :
  - **VerticalBar** : Une barre verticale fixe qui se déplace de gauche à droite.
  - **GrowingCircle** : Un cercle qui change de taille et de couleur avec le temps.
  - **RotatingCircle** : Un cercle fixe qui tourne autour d'un point central et change de couleur.
- Un nouvel item : **Shield** qui rend la sorcière invincible pendant 3 secondes.
- Quatre niveaux uniques intégrant les nouveaux obstacles et items.
- Améliorations des détections de collision pour une expérience de jeu fluide.
- Animation des champignons avec des images animées.
- Affichage de messages de victoire ou de défaite lors des niveaux.
- Animation de la mort de la sorcière en cas de collision fatale.
- Ajout d'un menu pour choisir le niveau de jeu.

## Structure du code
Le projet utilise une architecture Modèle-Vue-Contrôleur (MVC) pour séparer la logique du jeu, l'affichage graphique, et les contrôles :
- **Modèle** : Comprend la classe abstraite `Entity` et ses sous-classes pour gérer les entités du jeu.
- **Vue** : Gère l'interface graphique et le rendu des entités.
- **Contrôleur** : Relie le modèle et la vue, permettant l'interaction entre eux.
