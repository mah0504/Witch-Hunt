package sample;

/**
 * Obstacle dans un niveau.
 *
 * Lorsque le joueur entre en collision avec un obstacle, la partie est
 * terminée.
 */

public abstract class Obstacle extends LevelElement {
	
    protected double timeSinceColorChange=0 ;
    
    protected double  width ; 
    
    protected int color;

    public Obstacle(double x, double y) {
    	
        super(x, y);
    }

    /**Getter pour obtenir la couleur actuelle
     * 
     * @return color
     */
    public int getColor(){
    	
        return 0;
        
    }
    
    
    /**
     * Gestion de la collision entre le joueur et l'obstacle
     *
     * @param player Le joueur
     * @param game La partie en cours
     */
    @Override
    public void handleCollision(Player player, Game game) {
    	
        game.loose();
    }
}
