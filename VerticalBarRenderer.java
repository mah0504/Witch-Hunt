package sample;

import javafx.scene.canvas.GraphicsContext;

public class VerticalBarRenderer extends Renderer {
	
	private GraphicsContext context;
	private VerticalBar bar;
   
	
	 /**
     *  Constructeur qui initialise une instance de VerticalBarRenderer avec le VerticalBar spécifié.
     *
     * @param  b le vertical bar 
     */
	
	public VerticalBarRenderer(VerticalBar b) {
		
		this.bar= b;
	
	}
	
	
	 /**
     * Dessine la VerticalBar  sur le contexte graphique spécifié.
     *
     * @param level   niveau actuel du jeu.
     * @param context contexte graphique sur lequel on affiche la représentation graphique
     */
	
	
	@Override
	public void draw(Level level, GraphicsContext context) {
		
		this.context= context;
	    
		// Calcule la position de VerticalBar par rapport à l'écran
        double canvasY = Renderer.computeScreenY(level, bar.getY());
        
        // Définit la couleur de remplissage
        context.setFill(Renderer.convertColor(bar.getColor()));
        
       // Efface la zone où le VerticalBar était précédemment
		context.clearRect(bar.getX()- bar.getWidth()/2, canvasY-bar.getHeight()/2, bar.getWidth(), bar.getHeight());
		
		// Dessine VerticalBar dans la nouvelle position. 

		context.fillRect(bar.getX()- bar.getWidth()/2,canvasY-bar.getHeight()/2, bar.getWidth(), bar.getHeight());
				
	}

}
