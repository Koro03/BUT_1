package packScene;

import javafx.css.ParsedValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class FenDetailRando extends Stage {
	// les composants de la fen�tre	
	private VBox 			racine		= new VBox();
	
	private HBox			zoneTitre	= new HBox();
	private Label			titre		= new Label();
	private HBox			ligne		= new HBox();	
	private Label 			lblPartie1 	= new Label("Le ");
	private Label			lblDate		= new Label();
	private Label 			lblPartie2 	= new Label(", rando de ");
	private Label			lblDistance	= new Label();
	private Label 			lblPartie3 	= new Label(" km (D+ : ");
	private Label 			lblDevPos 	= new Label();
	private Label			lblPartie4	= new Label(" m , D- : ");
	private Label 			lblDevNeg 	= new Label();
	private Label			lblPartie5	= new Label(" m)");
	private TextArea		txtComments	= new TextArea();
	private Button			bnFermer	= new Button("Fermer");
	
	public FenDetailRando() {
		this.setTitle("D�tail de randonn�e");
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.setResizable(false);
		this.initModality(Modality.WINDOW_MODAL);
		this.sizeToScene();
	}
	
	public Parent creerContenu(){
		int ecart = 60;
		///////////////////////////////////////////////////////////////////////////
		// Zone pour le titre
		///////////////////////////////////////////////////////////////////////////
		titre.setStyle("-fx-font-size:16 ; -fx-font-weight:BOLD");
		zoneTitre.setAlignment(Pos.CENTER);
		zoneTitre.getChildren().add(titre);
		lblDate.setStyle("-fx-font-weight:BOLD");
		lblDistance.setStyle("-fx-font-weight:BOLD");
		lblDevPos.setStyle("-fx-font-weight:BOLD");
		lblDevNeg.setStyle("-fx-font-weight:BOLD");
		ligne.getChildren().addAll(lblPartie1, lblDate, lblPartie2, lblDistance, lblPartie3, lblDevPos, lblPartie4, lblDevNeg, lblPartie5);
		txtComments.setEditable(false);
		bnFermer.setPrefWidth(100);
		
		bnFermer.setOnAction(e->clicFermer());
		
		
		///////////////////////////////////////////////////////////////////////////
		// Racine du Scene Graph
		///////////////////////////////////////////////////////////////////////////
		racine.setPadding(new Insets(15));
		racine.setSpacing(10);
		racine.getChildren().addAll(zoneTitre, ligne, txtComments,bnFermer);

		return racine;
	}
	public void clicFermer() {
		System.exit(0);
	}
	public void initDetail(Rando r) {
        lblDate.setText(r.getDate());
        lblDistance.setText(String.valueOf(r.getDistance()));
        lblDevPos.setText(String.valueOf(r.getDevPos()));
        lblDevNeg.setText(String.valueOf(r.getDevNeg()));
	}


}

































































































