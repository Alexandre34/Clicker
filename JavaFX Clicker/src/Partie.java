import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Partie extends Environnement1 implements EventHandler<ActionEvent> {
	private static ArrayList<Button> grilleBoutons;
	private static GridPane g;
	private Label carVit;
	private Label carFib;
	
	public void display() {
		Stage fenetre = new Stage();
		fenetre.setTitle("Partie");
		
		grilleBoutons = new ArrayList<Button>();
		g = new GridPane();
		g.setPadding(new Insets(10, 10, 10, 10));
		g.setAlignment(Pos.TOP_CENTER);
		g.setHgap(100);
		g.setVgap(40);
		remplirListe();
		Font fond = new Font(20);
		
		Button boutique = new Button("Boutique");
		boutique.setPrefSize(150, 40);
		boutique.setFont(fond);
		Boutique b = new Boutique();
		boutique.setOnAction(e -> {
			b.display();
			System.out.println("Boutique ouverte");
		});
		
		carVit = new Label();
		carVit.setText("Vitamines : " +Principale.scoreVitamines+ "\n");
		carFib = new Label();
		carFib.setText("Fibres : " +Principale.scoreFibres);
		carVit.setFont(fond);
		carFib.setFont(fond);
		Button fermerFenetre = new Button("Fermer la fenêtre");
		fermerFenetre.setPrefSize(150, 40);
		fermerFenetre.setOnAction(e -> fenetre.close());
		
		HBox menu = new HBox(60);
		menu.setAlignment(Pos.CENTER);
		menu.setPadding(new Insets(10, 10, 10, 10));
		menu.getChildren().addAll(boutique, carVit, carFib, fermerFenetre);
		Background bleu = new Background(new BackgroundFill(Color.AZURE, 
				CornerRadii.EMPTY, null));
		menu.setBackground(bleu);
		
		BorderPane principal = new BorderPane();
		principal.setCenter(g);
		principal.setBottom(menu);
		
		Border bord = new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, 
				CornerRadii.EMPTY, new BorderWidths(6), new Insets(0)));
		principal.setBorder(bord);
		
		Image champ = new Image("Bg_XP.png", 800, 600, false, true);
		ImageView iv = new ImageView();
		iv.setImage(champ);
		
		StackPane base = new StackPane();
		base.getChildren().add(iv);
		base.getChildren().add(principal);
		
		Scene sc = new Scene(base, 800, 600, Color.BLUE);
		fenetre.setScene(sc);
		fenetre.show();
	}
	
	private void remplirListe() {
		for(int i = 0 ; i < Environnement1.NOMBRE_BOUTONS_EMPLACEMENTS ; i++) {
			Button b = new Button(Environnement1.champs[i].getType().toString());
			grilleBoutons.add(b);
			g.add(b, i % 5, i / 5);
			grilleBoutons.get(i).setOnAction(this);
		}
	}
	
	public void handle(ActionEvent e){
		//marquer score et placer une graine
		for(int i = 0 ; i < NOMBRE_BOUTONS_EMPLACEMENTS ; i++){
			if(e.getSource() == grilleBoutons.get(i)){
				//marquer score
				Environnement1.augmenterScore(Environnement1.champs[i]);
				Environnement1.afficherScore();
				
				//placer une graine
				if(Environnement1.tenir != null){
					
					if(Environnement1.champs[i].getType() == EnumLégumes.VIDE){
						
						Environnement1.champs[i] = new Légume( (EnumLégumes)Environnement1.tenir );
						grilleBoutons.get(i).setText(
								((EnumLégumes)Environnement1.tenir).toString() );
						
						Environnement1.tenir = null;
					}
				}
			}
		}
		
		carVit.setText("Vitamines : " +Principale.scoreVitamines+ "\n");
		carFib.setText("Fibres : " +Principale.scoreFibres);
	}
}
