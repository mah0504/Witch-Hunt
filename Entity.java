package sample;

/**
 * Classe abstraite pour représenter une entité sur le jeu.
 *
 * Une entité possède minimalement un Renderer et une position (x, y) définie
 * par rapport au niveau (où y=0 est tout en bas).
 */
public abstract class Entity {

    protected double x, y;
    protected Renderer renderer;

    
    /**
     * Initialise une nouvelle entité avec les coordonnées spécifiées.
     *
     * @param x La coordonnée horizontale de l'entité.
     * @param y La coordonnée verticale de l'entité.
     */
    
    
    public Entity(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Renvoie la coordonnée horizentale de l'entité.
     *
     * @return La coordonnée horizentale de l'entité.
     */
    public double getX() {
        return x;
    }

    /**
     * Renvoie la coordonnée verticale de l'entité.
     *
     * @return La coordonnée verticale de l'entité.
     */
    
    public double getY() {
        return y;
    }

    /**
     * @return la largeur totale de l'entité
     */
    public abstract double getWidth();

    /**
     * @return la hauteur totale de l'entité
     */
    public abstract double getHeight();

    public Renderer getRepresentation() {
        return renderer;
    }

    /**
     * Fonction appelée à chaque frame pour mettre à jour les attributs de
     * l'entité.
     *
     * @param dt Delta-Temps en secondes
     */
    public abstract void tick(double dt);
}
