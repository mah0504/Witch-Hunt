package sample;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un Square en dessinant un carré coloré sur l'écran.
 */


public class SquareRenderer extends Renderer {
    private Square carre;

    
    /**
     * Constructeur qui initialise un renderer pour un carré.
     *
     * @param square Le carré à rendre.
     */
    public SquareRenderer(Square c) {
        this.carre = c;
        
    }

    /**
     * Méthode qui le carré sur le contexte graphique spécifié.
     *
     * @param level   Le niveau actuel du jeu.
     * @param context Le contexte graphique sur lequel on veut  dessiner le carré.
     */
    
    @Override
    public void draw(Level level, GraphicsContext context) {
    	
    	
        double canvasY = Renderer.computeScreenY(level, carre.getY());

        context.setFill(Renderer.convertColor(carre.getColor()));

        context.fillRect(
                carre.getX() - carre.getWidth() / 2,  canvasY - carre.getWidth() / 2,carre.getWidth(),
                carre.getWidth());
        
    }
    
}
