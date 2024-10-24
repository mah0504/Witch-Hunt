package sample;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

/**
 * Obstacle simple : un cercle qui change de couleur à toutes les 2 secondes.
 */
public class RotatingCircle extends Obstacle {

	private double radius;
	private double timeSinceColorChange = 0;
	private double centerX; // Coordonnée x du centre du cercle
	private double centerY; // Coordonnée y du centre du cercle
	private double angularSpeed; // Vitesse angulaire de rotation en radians par seconde
	
	
	/**
	 * Initialise un nouveau cercle en rotation avec les coordonnées
	 *  spécifiées, le rayon, le centre de rotation et la vitesse angulaire.
	 *
	 * @param x            La coordonnée x du centre du cercle.
	 * @param y            La coordonnée y du centre du cercle.
	 * @param radius       Le rayon du cercle.
	 * @param centerX      La coordonnée x du centre de rotation. ( sur lequel le cercle tourne )
	 * @param centerY      La coordonnée y du centre de rotation.
	 * @param angularSpeed La vitesse angulaire de rotation en radians par seconde.
	 */
	
	
	

	public RotatingCircle(double x, double y, double radius, 
			double centerX, double centerY, double angularSpeed) {
		super(x, y);

		this.radius = radius;
		this.renderer = new RotatingCircleRenderer(this);
		this.centerX = centerX;
		this.centerY = centerY;
		this.angularSpeed = angularSpeed;

		// Initialisation de la couleur avec une valeur aléatoire entre 0 et 3
		this.color = (int) (Math.random() * 4);
	}

	/**
	 * Retourne la largeur de l'obstacle ( = diametre = 2*rayon ) 
	 *
	 * @return double
	 */

	@Override
	public double getWidth() {
		return radius * 2;
	}

	/**
	 * Retourne la hauteur de l'obstacle ( = diametre = 2*rayon) 
	 *
	 * @return double
	 */


	@Override
	public double getHeight() {
		return radius * 2;
	}

	/**
	 * Retourne le rayon de l'obstacle 
	 *
	 * @return double
	 */

	public double getRadius() {
		return radius;
	}

	/**
	 * Met à jour l'état de l'obstacle à chaque tick du jeu.
	 * 
	 * @param dt Delta-temps en secondes
	 */

	@Override
	public void tick(double dt) {
		timeSinceColorChange += dt;

		// Change la couleur toutes les 2 secondes
		if (timeSinceColorChange > 2) {
			color = (color + 1) % 4;
			timeSinceColorChange = 0;
		}

		// Met à jour les coordonnées du cercle pour le faire tourner autour du point central
		double angleChange = angularSpeed * dt;
		double newX = (getX() - centerX) * Math.cos(angleChange) - (getY() - centerY) * Math.sin(angleChange) + centerX;
		double newY = (getX() - centerX) * Math.sin(angleChange) + (getY() - centerY) * Math.cos(angleChange) + centerY;
		x = newX;
		y = newY;
	}

	/**
	 * Renvoie la couleur actuelle de l'obstacle.
	 * 
	 * @return La couleur actuelle de l'obstacle (int) 
	 */

	public int getColor() {
		return color;
	}

	/**
	 * Vérifie si cet obstacle intersecte un joueur.
	 * 
	 * @param player Le joueur à vérifier l'intersection
	 * @return true si l'obstacle et le joueur s'intersectent, sinon false
	 */
	@Override
	public boolean intersects(Player player) {
		return this.color != player.getColor()
				&& player.getX() + player.getRadius() < this.getX() + radius
				&& player.getX() + player.getRadius() > this.getX() - radius
				&& player.getY() + player.getRadius() < this.getY() + radius
				&& player.getY() + player.getRadius() > this.getY() - radius;
	}
}