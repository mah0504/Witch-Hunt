package sample;

import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
/**
 * Classe principale. Définit la vue.
 * 
 * @author maha AMHAOUCH 20272882 ,douae sekkat 20253363 , ZOUHAIR EL YANI 20238383 , ayman kaissi 20253368
 */

public class ColorsWitch extends Application {

	public static final double WIDTH = 320, HEIGHT = 480;
	private Text msgAffiche = new Text();
	public boolean pressTab;
	private Controller controller;
	private GraphicsContext context;

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Méthode appelée lors du démarrage de l'application JavaFX.
	 *
	 * @param primaryStage La fenêtre principale de l'application.
	 * @throws Exception Si une erreur se produit pendant le démarrage de l'application.
	 */

	@Override
	public void start(Stage primaryStage) throws Exception {

		controller = new Controller( );


		// Création d'un canevas avec les dimensions spécifiées
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		Pane root = new Pane(canvas);

		context = canvas.getGraphicsContext2D();

		msgAffiche.setLayoutX(10); // Définir la position horizontale du texte
		msgAffiche.setLayoutY(100); // Définir la position verticale du texte
		msgAffiche.setFill(Color.WHITE); // Définir la couleur du texte en rouge

		msgAffiche.setFont(Font.font("serif", 20));
		root.getChildren().add(msgAffiche);  //rajoute le message à l'interface graphique

		AnimationTimer timer = new AnimationTimer() {
			private long lastTime;

			@Override
			public void handle(long now) {
				controller.tick((now - lastTime) * 1e-9);
				controller.updateMessageVisibility();

				// Obtient le message à afficher
				String message = controller.getMessage();
				
				
				// Définit le texte à afficher de puis le message
				msgAffiche.setText(message);
				
				 // Définit la visibilit du message 
				msgAffiche.setVisible(!message.isEmpty());

				
				context.setFill(Color.BLACK);
				
				
				context.fillRect(0, 0, WIDTH, HEIGHT);

				
				 // Obtient la liste des entités à afficher depuis le contrôleur
				List<Entity> entities = controller.getEntities();

				for (Entity e : entities) {
					e.getRepresentation().draw(controller.getCurrentLevel(), context);
				}
				 // Met à jour le temps écoulé pour le prochain appel de la fonction handle
				lastTime = now;
			}
		};
		timer.start();

		Scene scene = new Scene(root, WIDTH, HEIGHT);

		scene.setOnKeyPressed((event) -> {
			if (event.getCode() == KeyCode.SPACE) {
				controller.spaceTyped();
			} else if (event.getCode() == KeyCode.TAB) {
				pressTab = !pressTab;
				if (pressTab) {
					controller.testMode(true);
				} else {
					controller.testMode(false);
				}
			}
		});

		primaryStage.setTitle("Colors Witch");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
}
