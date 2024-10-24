package sample;

import javafx.scene.canvas.GraphicsContext;

/**
* Fait le rendu d'un Circle en dessinant un cercle coloré sur l'écran.
*/
public class RotatingCircleRenderer extends Renderer {

   private RotatingCircle rCircle;
   
   /**
    * Constructeur du Renderer de cercle en rotation.
    * 
    * @param rotatingCircle Le cercle en rotation à rendre
    */
   public RotatingCircleRenderer(RotatingCircle rCircle) {
       this.rCircle = rCircle;
   }

   
   /**
    * Dessine le cercle en rotation sur le contexte graphique.
    * 
    * @param level   Le niveau actuel du jeu
    * @param context Le contexte graphique sur lequel dessiner
    */
   @Override
   public void draw(Level level, GraphicsContext context) {
    
       double canvasY = Renderer.computeScreenY(level, rCircle.getY());

       context.setFill(Renderer.convertColor(rCircle.getColor()));

       context.fillOval(
               rCircle.getX() - rCircle.getRadius(),
               canvasY - rCircle.getRadius(),
               rCircle.getRadius() * 2,
               rCircle.getRadius() * 2); 
   }
}