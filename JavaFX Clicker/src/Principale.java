import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Principale extends Application {
	Stage fenetre;
	Label titre;
	Button demarrer, fermer;
	
	public static int score;
	public static int scoreFibres;
	public static int scoreVitamines;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		fenetre = primaryStage;
		fenetre.setTitle("Menu - Clicker");
		
		titre = new Label("Clicker des Chevaliers de Maxou");
		demarrer = new Button("Démarrer le jeu");
		Font f = new Font(20);
		demarrer.setFont(f);
		demarrer.setTextFill(Color.GREEN);
		Background ba = new Background(new BackgroundFill(Color.TRANSPARENT, 
				CornerRadii.EMPTY, null));
		demarrer.setBackground(ba);
		
		Partie p = new Partie();
		
		demarrer.setOnAction(e -> {
			p.display();
			fenetre.close();
		});
		
		fermer = new Button("Fermer la fenêtre");
		fermer.setOnAction(e -> {
			System.out.println("Fermeture de la fenêtre par le bouton.");
			fermerFenetre();
		});
		
		VBox menu = new VBox(200);
		demarrer.setPadding(new Insets(50, 50, 50, 0));
		demarrer.setTextAlignment(TextAlignment.CENTER);
		menu.getChildren().addAll(titre, demarrer, fermer);
		
		BorderPane principal = new BorderPane();
		BorderPane.setMargin(menu, new Insets(30, 30, 30, 30));
		principal.setLeft(menu);
		
		fenetre.setOnCloseRequest(e -> {
			e.consume();
			System.out.println("Fermeture de la fenêtre par la croix.");
			fermerFenetre();
		});
		
		Image ferme = new Image("5191174_132744055000_2.jpg", 800, 600, false, true);
		ImageView iv = new ImageView();
		iv.setImage(ferme);
		
		StackPane base = new StackPane();
		base.getChildren().add(iv);
		base.getChildren().add(principal);
		
		Scene sc = new Scene(base, 800, 600);
		fenetre.setScene(sc);
		fenetre.show();
	}
	
	private void fermerFenetre() {
		System.out.println("Fermeture de la fenêtre.");
		fenetre.close();
	}

}
