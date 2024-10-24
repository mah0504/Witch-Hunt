package sample;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private Level level;
	private Player player;
	private boolean test = false;

	/**
	 * Dimensions de l'écran
	 */
	private double screenWidth, screenHeight;

	/**
	 * Indique si la partie est terminée/gagnée
	 */
	private boolean gameOver = false;
	private boolean hasWon = false;

	/**
	 * Crée une partie dans le niveau levelNumber.
	 *
	 * @param screenWidth largeur de l'écran
	 * @param screenHeight hauteur de l'écran
	 * @param levelNumber numéro du niveau
	 */
	public Game(double screenWidth, double screenHeight, int levelNumber) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;

		player = new Player(screenWidth / 2, 200, 15);

		switch (levelNumber) {
		case 1:
			level = new Level1(screenWidth, screenHeight);
			break;
		case 2:
			level = new Level2(screenWidth, screenHeight);
			break;
		case 3:
			level = new Level3(screenWidth, screenHeight);
			break;
		case 4:
			level = new Level4(screenWidth, screenHeight); 
			break;
		default:
			throw new IllegalArgumentException("Niveau inconnu");
		}
	}
	public void setTest(boolean test){
		this.test = test;
	}
	/**
	 * Fonction appelée à chaque frame
	 *
	 * @param dt Delta-Temps (en secondes)
	 */
	public void tick(double dt) {
		level.tick(dt);
		player.tick(dt);
		if (player.getY() - player.getRadius() < level.getScroll()) {
			// Empêche la balle de sortir de l'écran
			
			player.setY(level.getScroll() + player.getRadius());
			
		} else if (player.getY() - level.getScroll() > screenHeight / 2) {
			// Scroll le level verticalement si nécessaire
			
			level.incrementScroll(player.getY() - level.getScroll() - screenHeight / 2);
		}
		// apres 3s la sorciere nest plus invincible 
		// Gestion des collisions avec les éléments (items/obstacles/...) du niveau
		if(!this.test) {
			
			if(!player.getInvincible()) {
				
				for (LevelElement element : level.getEntities()) {
					
					if (element.intersects(player)) {
						
						element.handleCollision(player, this);
					}
				}
			}
		}
	}

	/**
	 * @return les entités à afficher à l'écran
	 */
	public List<Entity> getEntities() {
		List<Entity> entities = new ArrayList<>();

		entities.addAll(level.getEntities());
		entities.add(player);

		return entities;
	}
	
	
	/**
	 * Renvoie le niveau actuel du jeu.
	 * 
	 * @return Le niveau actuel du jeu.
	 */

	public Level getLevel() {
		return level;
	}
	/**
	 * Méthode pour sauter la sorcière
	 */

	public void jump() {
		player.jump();
	}
	
	/**
	 * Méthode qui marque la fin du jeu avec une défaite.
	 */

	public void loose() {
		System.out.println("You loose... Too bad !");
		this.gameOver = true;
	}

	
	/**
	 * Méthode qui marque la fin du jeu avec une victoire.
	 */
	public void win() {
		System.out.println("You win !");
		this.hasWon = true;
		this.gameOver = true;

	}

	/**
	 * Indique si la partie est gagnée
	 *
	 * @return
	 */
	public boolean hasWon() {
		return hasWon;
	}

	/**
	 * Indique si la partie est terminée
	 *
	 * @return
	 */
	public boolean isGameOver() {
		return gameOver;
	}
}
