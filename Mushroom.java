package sample;

/**
 * Item : champignon.
 * 
 * Ramasser un champignon permet de gagner le niveau actuel
 * Le champignon est représenté par une animation
 */

public class Mushroom extends Item {
    private double deltaTime = 0;
    
    private  int frameIndex = 0;           // Index du frame (image) actuel dans l'animation
    private double frameDuration = 1/20;   // Durée de chaque frame en secondes
    private double timeSinceLastFrame = 0; // Temps écoulé depuis le dernier changement de frame


    /**
     * Constructeur qui crée un nouveau objet champignon
     * @param x coordonnée horizontale du champignon
     * @param y coordonnée verticale du champignon
     */
    
    public Mushroom(double x, double y) {
        super(x, y);

        this.renderer = new AnimationRenderer("mushroom_animation", 26, 20, this);
    }
    public double getDeltaTime(){
        return deltaTime;
    }
    /**
     * Méthode qui met à jour l'état du champignon à chaque frame.
     * @param dt Delta-temps en secondes depuis la dernière frame
     */
    @Override
    public void tick(double dt) {
    	

    	// Mise à jour du frame de l'animation
    	     timeSinceLastFrame += dt;
          
          if (timeSinceLastFrame >= frameDuration) {
              frameIndex = (frameIndex + 1) % 26; 
              timeSinceLastFrame = 0; // Réinitialisation du temps écoulé depuis le dernier changement de frame
              
          }
      
    }
    
    /** 
     * Renvoie l'index du frame actuel dans l'animation du champignon
     * @return index du frame actuel dans l'animation.
     */
    public double getFrameIndex() {
    	return frameIndex;
    }
    
    
    
    /**
     * Retourne la largeur du champignon.
     * @return La largeur du champignon en pixels
     */
    @Override
    public double getWidth() {
        return 64;
    }

    
    /**
     * Retourne la largeur du champignon.
     * @return La largeur du champignon en pixels
     */
    
    
    @Override
    public double getHeight() {
        return 64;
    } 
    
    
    /**
     * Gère la collision entre le joueur et le champignon.
     * @param player Le joueur
     * @param game Le jeu
     */

    @Override
    public void handleCollision(Player player, Game game) {
        game.win();
                
    }
    /**
     * Vérifie si le joueur intersecte le champignon.
     * @param player Le joueur
     * @return un booleen : true si le joueur intersecte le champignon, sinon false
     */
    
    @Override
    public boolean intersects(Player player) {
    	
    	 return 
                player.getX() + player.getRadius()< this.getX() + this.getWidth() / 2
                && player.getX()+ player.getRadius() > this.getX() - this.getWidth() / 2
                && player.getY()+ player.getRadius() < this.getY() + this.getHeight() / 2
                && player.getY() + player.getRadius()> this.getY() - this.getHeight() / 2;
      
    }
}
