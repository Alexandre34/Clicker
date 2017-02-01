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
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Boutique implements EventHandler<ActionEvent>{
	private static ArrayList<Button> grilleBoutique;
	private static GridPane g;
	private Stage fenetre;
	private Label desc;
	private Button achat;
	private Achetable selection;
	
	public void display() {
		fenetre = new Stage();
		fenetre.setTitle("Boutique");
		fenetre.initModality(Modality.APPLICATION_MODAL);
		
		GridPane principal = new GridPane();
		grilleBoutique = new ArrayList<Button>();
		g = new GridPane();
		remplirListe();
		
		VBox description = new VBox(40);
		desc = new Label("Prix : ");
		description.getChildren().addAll(desc);
		
		Font fond = new Font(20);
		achat = new Button("Acheter");
		achat.setFont(fond);
		achat.setOnAction(this);
		principal.add(g, 0, 0);
		principal.add(description, 0, 1);
		principal.add(achat, 0, 2);
		Scene sc = new Scene(principal, 500, 300);
		fenetre.setScene(sc);
		fenetre.showAndWait();
	}
	
	private void remplirListe() {
		for(int i = 0 ; i < Environnement1.NOMBRE_BOUTONS_BOUTIQUE ; i++){
			Button b = new Button("Boutique "+Environnement1.élémentBoutique[i].toString());
			grilleBoutique.add(b);
			b.setMinSize(100, 100);
			g.add(b, i % 5, i / 5);
			grilleBoutique.get(i).setOnAction(this);
		}
	}
	
	public void handle(ActionEvent e) {
		if(e.getSource() == this.achat) {
			selection.acheter();
			fenetre.close();
		}
		
		for(int i = 0 ; i < Environnement1.NOMBRE_BOUTONS_BOUTIQUE ; i++){
			if(e.getSource() == grilleBoutique.get(i)){
				selection = Environnement1.élémentBoutique[i];
				this.desc.setText(selection.affichage());
			}
		}
	}
}
