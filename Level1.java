package sample;

public class Level1 extends Level {
	
	
	 /**
     * Premier niveau du jeu avec les dimensions spécifiées de la scène.
     * @param screenWidth Largeur de l'écran
     * @param screenHeight Hauteur de l'écran
     */
	

	public Level1(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;

		// Création des obstacles
		Square obstacle1 = new Square(x, 0.75 * screenHeight, 70);
		Square obstacle2 = new Square(x, 1.25 * screenHeight, 80);
		VerticalBar obstacle3 = new VerticalBar(x, 1.75 * screenHeight, 40, 70, 150 );
		Square obstacle4 = new Square(x, 2.25 * screenHeight, 200);
		VerticalBar obstacle5 = new VerticalBar(x, 3 * screenHeight, 40, 90, 150 );
		
		// ajout des obstacles 
		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);

		// Création des items
		Potion potion1 = new Potion(x, 1 * screenHeight);
		
		// ajout des items
		items.add(potion1);
		
		// ajout du champignon qui permet d'incrémenter le niveau 
		victoryMushroom = new Mushroom(screenWidth /2, 3.5* screenHeight);
		}
}

	

