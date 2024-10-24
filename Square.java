package sample;

/**
 * Obstacle simple : un carré qui change de couleur à toutes les 2 secondes.
 */
public class Square extends Obstacle {

	/**
     * Initialise un nouveau carré avec les coordonnées spécifiées et une longueur donnée.
     *
     * @param x        La coordonnée x du centre du carré.
     * @param y        La coordonnée y du centre du carré.
     * @param longueur La longueur d'un côté du carré.
     */

    public Square(double x, double y, double longueur) {
        super(x, y);  

        this.width = longueur; // taille d'une arête du carré
        
        this.renderer = new SquareRenderer(this);
        
    // couleur choisie aléatoirement
        this.color = (int) (Math.random() * 4);
    }
    
    
    
    /**
     * Getter pour obtenir la largeur de l'obstacle
     * @return double la largeur de l'obstacle
     * 
     */
    
    @Override
    public double getWidth() {
        return width;
    }
    
    
    /**
     * Getter pour obtenir la longueur de l'obstacle
     * @return double la longueur de l'obstacle
     * 
     */
    
    @Override
    public double getHeight() {
        return width; 
    }

    /**
     * Met à jour le carré en fonction du temps écoulé depuis la update.
     *
     * @param dt Le temps écoulé depuis la dernière mise à jour, en secondes.
     */
    
    
    @Override
    public void tick(double dt) {
    	
    	// dt= temps écoulé depuis le dernier changement de couleur 
           timeSinceColorChange += dt;
        
        // si on a dépassé les 2s , on change de couleur ( %4 car on a 4 couleurs dispo ) 
        if (timeSinceColorChange > 2) {
            color = (color + 1) % 4;
            timeSinceColorChange = 0;
        }
    }
    
    
    
    /**
     * Getter qui retourne  la couleur  du cercle.
     *
     * @return int: La couleur actuelle du cercle.
     */
    public int getColor() {
        return color;
    }
    
    /**
     * Vérifie si le joueur entre en collision avec le cercle en comparant les couleurs et les coordonnées.
     *
     * @param player la sorcière 
     * @return booleen: true si le joueur entre en collision avec le cercle, sinon false.
     */

    @Override    
    public boolean intersects(Player player) {
        return this.color != player.getColor()
                && player.getX() + player.getRadius()< this.getX() + this.getWidth() / 2
                && player.getX()+ player.getRadius() > this.getX() - this.getWidth() / 2
                && player.getY()+ player.getRadius() < this.getY() + this.getHeight() / 2
                && player.getY() + player.getRadius()> this.getY() - this.getHeight() / 2;
    }
}
