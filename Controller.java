package sample;
import java.util.List;

import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
 * Contrôleur pour le jeu : fait le pont entre la vue et les modèles.
 */
public class Controller {
	private Game game;
	private int level = 1;
	private boolean showMessage= false;
	private Timeline messageTimer;


	/**
	 * Constructeur de la classe Controller.
	 * Initialise le jeu avec les dimensions spécifiées et le niveau initial.
	 */

	public Controller () { 

		this.game = new Game(ColorsWitch.WIDTH, ColorsWitch.HEIGHT, level);
		// Initialiser le Timeline pour gérer l'affichage du message pendant 2 secondes et redémarrer le jeu
		messageTimer = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
			showMessage = false; // Cacher le message après 2 secondes
			restartGame();
		}));
		messageTimer.setCycleCount(1); // Exécuter une seule fois
	}

	/**
	 * Retourne la liste des entités du jeu.
	 *
	 * @return La liste des entités du jeu.
	 */


	public List<Entity> getEntities() {
		return this.game.getEntities();
	}
	
	private void restartGame() {
	       if (game.hasWon()) {
	           level++;  // Incrémenter le niveau s'il a gagné
	       }
	       if (level == 5) {
	           System.exit(-1);  // Quitter si le niveau maximal est atteint
	       }
	       this.game = new Game(ColorsWitch.WIDTH, ColorsWitch.HEIGHT, level);
	   }

	/**
	 * Fonction appelée à chaque frame du jeu.
	 * @param dt Delta-temps exprimé en seconde   s
	 */
	   public void tick(double dt) {
	       if (this.game.isGameOver()) {
	           if (!showMessage) {
	        	// Si un message n'est pas déjà affiché, affiche-le et démarre le timer
	               showMessage = true;
	               messageTimer.playFromStart(); // Démarrer le timer
	           }
	       } else {
	    	// Si le jeu n'est pas terminé, met à jour la logique du jeu
	           this.game.tick(dt);
	       }
	   }

	public boolean updateMessageVisibility() {
		return showMessage;
	}


	/**
	 * Méthode qui le message à afficher en fonction de l'état du jeu.
	 *
	 * @return de type String. le message approprié en fonction du statut du jeu 
	 */
	

	public String getMessage() {
	       if (showMessage) {
	           if (this.game.hasWon()) {
	               return "You won! Congrats.";
	           } else {
	               return "You lost... better luck next time!";
	           }
	       } else {
	           return "";
	       }
	   }
	
	
	/**
	 * Récupère le niveau actuel du jeu.
	 * 
	 * @return Le niveau actuel du jeu.
	 */

	
	public Level getCurrentLevel() {
		return this.game.getLevel();
	}

	/**
	 * Fonction appelée lorsque la barre espace est enfoncée.
	 */
	public void spaceTyped() {
		this.game.jump();
	}

	/**
	 * méthode qui active ou désactive le mode de test du jeu.
	 *
	 * @param test vrai pour activer le mode de test, sinon faux
	 */
	public void testMode(boolean test){
		this.game.setTest(test);
	}
}
