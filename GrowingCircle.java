	package sample;
	
	import javafx.animation.AnimationTimer;
	import javafx.scene.canvas.GraphicsContext;
	
	/**
	* classe fille d'obstacle: un cercle qui change de taille et de couleur chaque 2secondes.
	* la taille est bornée entre une taille maximale et une minimale 
	 */ 
	public class GrowingCircle extends Obstacle {
	private double growthRate = 10 ;
	private double radius;
	private double max = 80;
	private double min = 20; 
	
	/**
	 * Constructeur de la classe GrowingCircle.
	 * 
	 * @param x      La coordonnée x du centre du cercle.
	 * @param y      La coordonnée y du centre du cercle.
	 * @param radius Le rayon initial du cercle.
	 */
	
	
	public GrowingCircle(double x, double y, double radius) {
	super(x, y);
	
	this.radius = radius;
	this.renderer = new CircleRenderer(this);
	this.color = (int) (Math.random() * 4);
	}
	
	 /**
     * Obtient le rayon du cercle.
     * @return Rayon du cercle
     */
	public double getRadius() {
		 return radius;
		}
		
	/**
     * Obtient la largeur du cercle.
     * @return Largeur du cercle (diamètre)
     */
		@Override
		public double getWidth() {
			return 2 * radius;
		}
		
    /**
     * Obtient la hauteur du cercle.
     * @return Hauteur du cercle (diamètre)
	 */
		
		@Override
		public double getHeight() {
			return 2 * radius;
		}
		
		
		
		
   /**
	 * Obtient la couleur du cercle.
	 * @return Couleur du cercle
     */
		public int getColor() {
			return color;
		}
	
		
    /**
	 * Vérifie si le cercle intersecte le joueur.
	 * @param player Le joueur
	 * @return true si le cercle et le joueur s'intersectent, sinon false
	 */
		
	@Override
	public boolean intersects(Player player) {
	return this.color != player.getColor()
	&& player.getX() + player.getRadius() < this.getX() + radius
	&& player.getX() + player.getRadius() > this.getX() - radius
	&& player.getY() + player.getRadius() < this.getY() + radius
	&& player.getY() + player.getRadius() > this.getY() - radius;
	}
	
	
	/**
     * Met à jour la position et la taille du cercle à chaque frame.
     * @param dt Delta-temps (en secondes)
     */

	@Override
	public void tick(double dt) {
		
    	// dt= temps écoulé depuis le dernier changement de couleur 
        timeSinceColorChange += dt;
     
    // changement de couleur chaque 2 secondes
     if (timeSinceColorChange > 2) {
         color = (color + 1) % 4;
         timeSinceColorChange = 0;
     }
		
  // incrémente le rayon du cercle en fonction du taux de croissance
	radius += dt * growthRate;
	
	if (radius > max) {
		
	growthRate = -growthRate;    // Inverse le taux de croissance pour réduire le cercle
	} else if (radius < min ) {
	growthRate = -1* growthRate; // Inverse le taux de croissance pour agrandir le cercle
			}
		}
		}