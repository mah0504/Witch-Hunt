package sample;

/**
 * Classe représentant l'entité de la personne qui joue (aka, la sorcière).
 *
 * La sorcière est représentée par un cercle.
 */
public class Player extends Entity {
	private double timeSinceCollision= 0;

	private double radius;
	private double vy;
	private double ay;
	private int color=1; 
	private boolean invincible; 
	/**
	 * Constructeur de la classe Player.
	 *
	 * @param x Coordonnée x initiale du joueur
	 * @param y Coordonnée y initiale du joueur
	 * @param r Rayon du cercle représentant la sorcière 
	 */

	public Player(double x, double y, double r) {
		super(x, y);

		this.radius = r;

		this.vy = 0;

		this.ay = -400;

		this.renderer = new PlayerRenderer(this);
	}

	/**
	 * Retourne le rayon du cercle représentant la sorcière.
	 * @return en pixels 
	 */

	public double getRadius() {
		return radius;
	}



	/**
	 * Retourne la coordonnée x du joueur.
	 *
	 * @return  un double
	 */


	public double getX() {
		return x;
	}


	/**
	 * Retourne la coordonnée y du joueur.
	 *
	 * @return  un double
	 */

	public double getY() {
		return y;
	}


	/**
	 * Indique si le joueur est invincible.
	 *
	 * @return booleen:  true si le joueur est invincible, sinon false
	 */

	public boolean getInvincible() {

		return this.invincible;
	}


	/**
	 * Définit  le joueur comme invincible.
	 *
	 * @param booleen invincible 
	 */
	public void setInvincible(boolean invincible) {

		this.invincible = invincible;

	}








	public void tick(double dt) {
		// Mise à jour de la vitesse par rapport à l'axe y
		vy += dt * ay;

		// Mise à jour de la position 
		y += dt * vy;

		// intervalle pour la vitesse 
		vy = Math.min(vy, 300);
		vy = Math.max(vy, -300);

		if (invincible) {

			timeSinceCollision += dt;
			// Si le temps écoulé dépasse 3 secondes, l'invincibilité prend fin
			if (timeSinceCollision > 3) {
				invincible = false;
				timeSinceCollision = 0;
			}
		}


	}


	/**
	 * Renvoie la couleur de l'obstacle.
	 *
	 * @return int
	 */

	public int getColor() {
		return color;
	}

	/**
	 * Remplace la couleur actuelle par une nouvelle couleur aléatoire
	 */
	public void randomizeColor() {

		int newColor;

		do {
			newColor = (int) (Math.random() * 4);
		} while (newColor == this.color);

		this.color = newColor;
	}

	/**
	 * Fait sauter la sorcière
	 */
	public void jump() {
		vy = Math.max(vy, 0);
		vy += 200;
	}




	/**
	 * Définit la coordonnée y de l'objet.
	 *
	 * @param y La nouvelle coordonnée y de l'objet.
	 */


	public void setY(double y) {
		this.y = y;
	}

	/**
	 *Retourne la largeur de la sorcière.
	 *
	 * @return width double: la largeur de la sorcière ( cercle représentant la sorcière) 
	 */

	public double getWidth() {
		return this.getRadius() * 2;
	}



	/**
	 *Retourne la hauteur de la sorcière.
	 *
	 * @return hright double: la largeur de la sorcière ( cercle représentant la sorcière) 
	 */


	public double getHeight() {
		return this.getRadius() * 2;
	}
}