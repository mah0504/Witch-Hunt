package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Fait le rendu d'une Entity sur l'écran en affichant une image
 */
public class ImageRenderer extends Renderer {

    private Image img;
    private Entity entity;
    
    
    /**
     * Constructeur du Renderer d'image.
     * trouve le chemin relatif pour l'image qu'on veut afficher , stocké dans la variable img
     * 
     * @param name   Le nom de l'image à charger
     * @param entity L'entité associée à l'image
     */

    public ImageRenderer(String name, Entity e) {
        img = new Image("/sample/" + name + ".png");
        this.entity = e;
    }

    
    /**
     * Dessine l'entité sur le contexte graphique en affichant l'image.
     * 
     * @param level   Le niveau actuel du jeu
     * @param context Le contexte graphique sur lequel dessiner
     */
    
    @Override
    public void draw(Level level, GraphicsContext context) {

        double x = entity.getX();
        double y = Renderer.computeScreenY(level, entity.getY());
        
        // on obtient les coord de l'image depuis le centre , on centre l'image autour de l'entité

        context.drawImage(img, x - entity.getWidth() / 2,
        		y - entity.getHeight() / 2, entity.getWidth(), entity.getHeight());
    } 
}
