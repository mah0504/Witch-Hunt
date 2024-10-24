package sample;

/**
 * Item : Potion magique.
 * 
 * Fait changer la sorcière de couleur
 */
public class Potion extends Item {

	private boolean used = false;

	/**
	 * Initialise une nouvelle potion magique avec les coordonnées spécifiées.
	 * 
	 * @param x La coordonnée x de la potion.
	 * @param y La coordonnée y de la potion.
	 */ 


	public Potion(double x, double y) {
		super(x, y);
		// Assigner un renderer pour afficher l'image de la potion (sa représentation graphique) 
		this.renderer = new ImageRenderer("potion", this);
	}

	@Override
	public void tick(double dt) {
		// Rien à faire
	
	}
	
	
	/**
	 * Retourne la largeur de l'image de la potion.
	 * 
	 * @return La largeur fixe de l'image de la potion.
	 */
	@Override
	public double getWidth() {
		return 48;
	}

	/**
	 * Retourne la hauteur de l'image de la potion.
	 * 
	 * @return La hauteur fixe de l'image de la potion.
	 */
	
	@Override
	public double getHeight() {
		return 48;
	}
	
	
	/**
	 * Gère la collision entre la potion et la sorcière .
	 * Marque la potion comme utilisée, change son image et modifie la couleur du joueur.
	 * 
	 * @param player La sorcière en collision avec la potion.
	 * @param game   Le jeu en cours.
	 */

	@Override
	public void handleCollision(Player player, Game game) {
		used = true;
		this.renderer = new ImageRenderer("empty-potion", this);
		player.randomizeColor();
	}

	/**
	 * Vérifie si la sorcière est en collision avec la potion.
	 * 
	 * @param player La sorcière à vérifier la collision.
	 * @return true si la sorcière est en collision avec la potion, sinon false.
	 */ 
	
	@Override
	public boolean intersects(Player player) {
		// Vérifier si la potion est encore disponible et si le joueur est en collision avec elle
		return !used
				&& player.getX() - player.getRadius() < this.getX() + this.getWidth() / 2
				&& player.getX() + player.getRadius() > this.getX() - this.getWidth() / 2
				&& player.getY() - player.getRadius() < this.getY() + this.getHeight() / 2
				&& player.getY() + player.getRadius() > this.getY() - this.getHeight() / 2;
	}

}
