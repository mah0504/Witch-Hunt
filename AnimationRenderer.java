package sample;
import javafx.animation.AnimationTimer;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;




public class AnimationRenderer extends Renderer {
	
	private GraphicsContext context;
    protected double framerate;
    protected  Image[] frames; 
    protected Entity entity;
    private int frameIndex;
    
    /**
     * Constructeur de la classe AnimationRenderer.
     *
     * @param prefix    Le préfixe commun au nom des fichiers d'images.
     * @param number    Le nombre total d'images dans l'animation.
     * @param framerate Le taux de rafraîchissement de l'animation en images par seconde.
     * @param entity    L'entité à laquelle l'animation est associée.
     */
    
    public AnimationRenderer(String prefix, int number, double framerate,Entity entity) {
    	
	      this.entity= entity;
          this.framerate = framerate;
		  frames = new Image[number];
		  
		  // calcule le chemin relat
	      for (int i = 0; i < number; i++) {
		     frames[i] = new Image("/sample/"+prefix + "" + (i+1) + ".png");
		     
		    }
    }
    /**
     * Dessine l'animation sur l'interface graphique.
     *
     * @param level   Le niveau actuel du jeu.
     * @param context Le contexte graphique sur lequel dessiner l'animation.
     */
	
	
	@Override
	public void draw(Level level, GraphicsContext context) {
		
		
	     frameIndex=(int) ((Mushroom) entity).getFrameIndex(); 
	     // extraire le bon index incrémenté de la méthode tick() du mushroom

	     

	     
	     
	     
		    double x = entity.getX();
	        double y = Renderer.computeScreenY(level, entity.getY());
	        	
		context.clearRect( x - entity.getWidth() / 2, y - entity.getHeight() / 2,
        		entity.getWidth(), entity.getHeight());

	       
	        context.drawImage(frames[frameIndex] , x - entity.getWidth() / 2,
	        		y - entity.getHeight() / 2,
	        		entity.getWidth(), entity.getHeight());
			
	        
	}
}

