package sample;

public class Level2 extends Level {

	 /**
    * Deuxième niveau du jeu avec les dimensions spécifiées de la scène.
    * @param screenWidth Largeur de l'écran
    * @param screenHeight Hauteur de l'écran
    */
	

	public Level2(double screenWidth, double screenHeight) {
		
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;

		// Création des obstacles
		Square obstacle1 = new Square(x, 0.75 * screenHeight, 70);
		Square obstacle2 = new Square(x, 2.25 * screenHeight, 90);
		VerticalBar obstacle3 = new VerticalBar(x, 2.5 * screenHeight, 40, 80, 150 );
		GrowingCircle obstacle4 = new GrowingCircle(x, 2.75*screenHeight, 50 );
		GrowingCircle obstacle5 = new  GrowingCircle(x, 3.5*screenHeight, 70 );
		

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		// Création des items
		Potion potion1 = new Potion(x, 1.25 * screenHeight);
		items.add(potion1);
		

		Potion potion2 = new Potion(x, 3 * screenHeight);
		items.add(potion2);

		// ajout du champignon de victoire
		
		victoryMushroom = new Mushroom(screenWidth / 2, 4.5 * screenHeight);
		
		}
}