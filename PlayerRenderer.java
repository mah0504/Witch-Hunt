package sample;

import javafx.scene.canvas.GraphicsContext;

/**
 * Fait le rendu d'un Player sur l'écran en dessinant un cercle coloré
 */
public class PlayerRenderer extends Renderer {

    private Player player;

    
    /**
     * Constructeur du Renderer de joueur.
     * 
     * @param player Le joueur à rendre
     */
    
    public PlayerRenderer(Player player) {
        this.player = player;
    }

    
    /**
     * Dessine le joueur sur le contexte graphique.
     * 
     * @param level   Le niveau actuel du jeu
     * @param context Le contexte graphique sur lequel dessiner
     */
    
    @Override
    public void draw(Level level, GraphicsContext context) {

        double canvasY = Renderer.computeScreenY(level, player.getY());

        context.setFill(Renderer.convertColor(player.getColor()));

        context.fillOval(
                player.getX() - player.getRadius(),
                canvasY - player.getRadius(),
                2 * player.getRadius(),
                2 * player.getRadius());
    }
}
