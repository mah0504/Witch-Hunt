package sample;

public class Level4 extends Level{
	

	 /**
   * Quatrième niveau du jeu avec les dimensions spécifiées de la scène.
   * @param screenWidth Largeur de l'écran
   * @param screenHeight Hauteur de l'écran
   */
	
	public Level4(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;

		// Création des obstacles
		RotatingCircle obstacle1 = new RotatingCircle(x/2, 0.75 * screenHeight, 20, x, 0.75*screenHeight, 90);
		VerticalBar obstacle2 = new VerticalBar(x, 1.5 * screenHeight, 30, 70, 150 );
		Square obstacle3 = new Square(x, 2 * screenHeight, 10);
		GrowingCircle obstacle4 = new GrowingCircle(x, 2.75 * screenHeight, 50 );
		RotatingCircle obstacle5 = new RotatingCircle(x/2, 3.5 * screenHeight, 20, x, 3.5*screenHeight, 70);
		VerticalBar obstacle6 = new VerticalBar(x, 3.5 * screenHeight, 30, 60, 100 );

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);
		//obstacles.add(obstacle7);
		// Création des items
		Potion potion1 = new Potion(x, 1 * screenHeight);
		Potion potion2 = new Potion(x, 1.75 * screenHeight);
		Shield shield = new Shield(x, 2.5*screenHeight);

		items.add(potion1);
		items.add(potion2);
		items.add(shield);

		// changer la position du champignon dans Level1
		victoryMushroom = new Mushroom(screenWidth / 2, 4.25 * screenHeight);
		}
		
}
