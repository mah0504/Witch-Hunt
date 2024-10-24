package sample;
import javafx.animation.AnimationTimer;



	public class VerticalBar extends Obstacle{

	private double dt;
	private double width, height, vx;

	public VerticalBar(double x, double y, double width, double height, double vx) {
	super(x,y);  // mêmes coordonnées que ceux de la classe mère 
	this.width= width;   
	this.height= height;
	this.vx= vx;  // vitesse par rapport à l'axe x 
	this.color= 1;
	this.renderer = new VerticalBarRenderer(this);  // rep graphique de VerticalBar 
	    }

	/**
	 * Méthode qui vérifie s'il y a intersection entre la sorcière et VerticalBar en 
	 * comparant leurs coordonnées
	 * @param player la sorcière 
	 * @return booleen : true si il y'a intersection sinon false 
	 */ 
	
	@Override
	public boolean intersects(Player player) {
	return this.color != player.getColor()
	               && player.getX() + player.getRadius() < this.getX() + this.getWidth() / 2
	               && player.getX() + player.getRadius()> this.getX() - this.getWidth() / 2
	               && player.getY() + player.getRadius()< this.getY() + this.getHeight() / 2
	               && player.getY() + player.getRadius()> this.getY() - this.getHeight() / 2; 
	   }

	/**
	 * getter pour obtenir la largeur de l'obstacle
	 * @return x  double :largeur de VerticalBar
	 */
	
	@Override
	public double getWidth() {
	return width;
	   }

	/**
	 * getter pour obtenir la hauteur de l'obstacle
	 * @return x  double :hauteur de Verticalbar
	 */
	
	@Override
	public double getHeight() {
	return height;
	   }
	
	
	/**
	 * getter pour obtenir la couleur actuelle l'obstacle
	 * @return color int: couleur actuelle
	 */

	public int getColor() {
	return color;
	   }

	

	/**
	 * getter pour obtenir la coordonnée x de l'obstacle
	 * @return x  double :la coorodnnée x
	 */
	
	public double  getX() {
	return x;
	   }

	
	/**
	 * getter pour obtenir la coordonnée y de l'obstacle
	 * @return y  double :la coorodnnée y
	 */
	
	public double  getY() {
	return y;
	   }

	/**
     * Change la position de VerticalBar à chaque dt 
     *
     * @param dt  en secondes (double) :Le temps écoulé depuis la dernière mise à jour.
     */

	@Override

	public void tick(double dt) {
	double newX = x + dt*vx; 
	if (newX + getWidth() / 2 > ColorsWitch.WIDTH || newX - getWidth() / 2 < 0) {
	vx *= -1; 
	} 
	
	else { x = newX; }
	
	}
	
	
}
	
