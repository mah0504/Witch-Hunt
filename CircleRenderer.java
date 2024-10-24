package sample;

import javafx.scene.canvas.GraphicsContext;

/**
* Fait le rendu d'un Circle en dessinant un cercle coloré sur l'écran.
*/
public class CircleRenderer extends Renderer {

   private GrowingCircle circle;

   
   /**
    * Constructeur de la classe CircleRenderer.
    *
    * @param circle Le cercle à rendre.
    */
   public CircleRenderer(GrowingCircle circle) {
       this.circle = circle;
   }

   /**
    * Dessine le cercle sur l'interface graphique.
    *
    * @param level   Le niveau actuel du jeu.
    * @param context Le contexte graphique sur lequel dessiner le cercle.
    */
   
   
   @Override
   public void draw(Level level, GraphicsContext context) {

       double canvasY = Renderer.computeScreenY(level, circle.getY());

       context.setFill(Renderer.convertColor(circle.getColor()));

       context.fillOval(
               circle.getX() - circle.getRadius(),
               canvasY - circle.getRadius(),
               circle.getRadius() * 2,
               circle.getRadius() * 2);
   }
}