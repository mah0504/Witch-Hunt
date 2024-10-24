package sample;


	public class Level3 extends Level {
		

		/**
	    * Troisième niveau du jeu avec les dimensions spécifiées de la scène.
	    * @param screenWidth Largeur de l'écran
	    * @param screenHeight Hauteur de l'écran
	    */

		public Level3(double screenWidth, double screenHeight) {
		super(screenWidth, screenHeight);

		double x = screenWidth / 2;

		// Création des obstacles
		Square obstacle1 = new Square(x, 0.75 * screenHeight, 60);
		Square obstacle2 = new Square(x, 1.25 * screenHeight, 70);
		Square obstacle3 = new Square(x, 2.25 * screenHeight, 50);
		VerticalBar obstacle4 = new VerticalBar(x, 1.5 * screenHeight, 50, 90, 150 );
		RotatingCircle obstacle5 = new RotatingCircle(x/2, 3.5 * screenHeight, 20, x, 3.5*screenHeight, 20);
		
		GrowingCircle obstacle6 = new GrowingCircle(x, 3 * screenHeight, 40 );

		obstacles.add(obstacle1);
		obstacles.add(obstacle2);
		obstacles.add(obstacle3);
		obstacles.add(obstacle4);
		obstacles.add(obstacle5);
		obstacles.add(obstacle6);
		
		// Création des items
		Potion potion1 = new Potion(x, 1 * screenHeight);
		Potion potion2 = new Potion(x, 1.75 * screenHeight);
		Shield shield = new Shield(x, 2.5*screenHeight);

		items.add(potion1);
		items.add(potion2);
		items.add(shield);

		
		victoryMushroom = new Mushroom(screenWidth / 2, 4.25 * screenHeight);
		}
	}
