package packScene;

import java.time.LocalDate;
import java.util.Optional;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class FenNouvelleRando extends Stage {
	// les composants de la fen�tre	
	private VBox 			racine			= new VBox();
	
	private HBox			zoneTitre		= new HBox();
	private Label			titre			= new Label("Nouvelle randonn�e");
	private HBox			champTitre		= new HBox();	
	private Label 			lblTitre 		= new Label("Titre* :");
	private TextField		txtTitre		= new TextField();
	private HBox			champDate		= new HBox();	
	private Label 			lblDate			= new Label("Date :");
	private DatePicker		dpDate			= new DatePicker();
	private HBox			champDistance	= new HBox();	
	private Label 			lblDistance 	= new Label("Dist. :");
	private TextField		txtDistance		= new TextField("0");
	private Label			lblKm			= new Label(" km");
	private HBox			champDevPos		= new HBox();	
	private Label 			lblDevPos 		= new Label("Dev + :");
	private Spinner<Integer>spDevPos		= new Spinner<Integer>(0,3000,500,50);
	private Label			lblM1			= new Label(" m");
	private HBox			champDevNeg		= new HBox();	
	private Label 			lblDevNeg 		= new Label("Dev - :");
	private Spinner<Integer>spDevNeg		= new Spinner<Integer>(0,3000,500,50);
	private Label			lblM2			= new Label(" m");
	private Label 			lblCommentaires	= new Label("Commentaires :");
	private TextArea		txtCommentaires	= new TextArea();
	
	private HBox			zoneBoutons		= new HBox();
	private Button			bnOK			= new Button("OK");
	private Button			bnAnnuler		= new Button("Annuler");
	
	public FenNouvelleRando() {
		this.setTitle("Ajouter une randonn�e");
		this.setResizable(false);
		this.initModality(Modality.APPLICATION_MODAL);
		Scene laScene = new Scene(creerContenu());
		this.setScene(laScene);
		this.sizeToScene();
	}
	
	public Parent creerContenu(){
		int ecart = 60;
		BooleanBinding titreVide = Bindings.equal(0,  txtTitre.textProperty().length());
		
		///////////////////////////////////////////////////////////////////////////
		// Zone pour le titre
		///////////////////////////////////////////////////////////////////////////
		titre.setStyle("-fx-font-size:16 ; -fx-font-weight:BOLD");
		zoneTitre.setAlignment(Pos.CENTER);
		zoneTitre.getChildren().add(titre);
		
		///////////////////////////////////////////////////////////////////////////
		// Zone pour les champs de saisie
		///////////////////////////////////////////////////////////////////////////
		lblTitre.setPrefWidth(ecart);
		lblTitre.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		txtTitre.setPrefWidth(250);
		txtTitre.setTooltip(new Tooltip("50 caract�res maximum"));
		champTitre.getChildren().addAll(lblTitre, txtTitre);
		
		lblDate.setPrefWidth(ecart);
		lblDate.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		dpDate.setPrefWidth(100);
		dpDate.setValue(LocalDate.now());
		champDate.getChildren().addAll(lblDate, dpDate);
		
		lblDistance.setPrefWidth(ecart);
		lblDistance.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		txtDistance.setPrefWidth(60);
		txtDistance.setAlignment(Pos.CENTER_RIGHT);
		lblKm.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		champDistance.getChildren().addAll(lblDistance, txtDistance, lblKm);
		
		lblDevPos.setPrefWidth(ecart);
		lblDevPos.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		spDevPos.setPrefWidth(70);
//		spDevPos.setEditable(true);
		lblM1.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		champDevPos.getChildren().addAll(lblDevPos, spDevPos, lblM1);
		
		lblDevNeg.setPrefWidth(ecart);
		lblDevNeg.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		spDevNeg.setPrefWidth(70);
//		spDevNeg.setEditable(true);
		lblM2.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		champDevNeg.getChildren().addAll(lblDevNeg, spDevNeg, lblM2);
		
		lblCommentaires.setStyle("-fx-font-size:14 ; -fx-font-weight:BOLD");
		txtCommentaires.setPrefWidth(300);
		txtCommentaires.setMaxHeight(100);
		
		///////////////////////////////////////////////////////////////////////////
		// Zone pour les BOUTONS
		///////////////////////////////////////////////////////////////////////////
		bnOK.setPrefWidth(80);
		bnOK.disableProperty().bind(Bindings.when(titreVide).then(true).otherwise(false));
		bnOK.setOnAction(e -> {
			int distance;
			if (txtDistance.getText().isEmpty()) distance=0; else distance = Integer.parseInt(txtDistance.getText());
			if (distance<0) {
				Alert alert = new Alert(AlertType.ERROR,"",ButtonType.OK);
				alert.setContentText("La distance ne peut pas �tre n�gative.");
				alert.setTitle("Erreur de distance");
				alert.showAndWait();
			} else {
				Principale.ajouterRando(txtTitre.getText(),
										dpDate.getValue().getDayOfMonth(),
										dpDate.getValue().getMonthValue(),
										dpDate.getValue().getYear(),
										distance,
										spDevPos.getValue(),
										spDevPos.getValue(),
										txtCommentaires.getText() );
				this.close();
			}
		});
		
		
		bnAnnuler.setPrefWidth(80);
		bnAnnuler.setCancelButton(true);
		bnAnnuler.setOnAction(e -> {
				this.close();
		});
		zoneBoutons.setSpacing(10);
		zoneBoutons.setAlignment(Pos.CENTER_RIGHT);
		zoneBoutons.getChildren().addAll(bnOK, bnAnnuler);
		
		///////////////////////////////////////////////////////////////////////////
		// Racine du Scene Graph
		///////////////////////////////////////////////////////////////////////////
		racine.setPadding(new Insets(15));
		racine.setSpacing(10);
		racine.getChildren().addAll(zoneTitre, champTitre, champDate, champDistance, champDevPos,
									champDevNeg, lblCommentaires, txtCommentaires, zoneBoutons);

		return racine;
	}
	
	public void initNouveau() {
		txtTitre.clear();
		dpDate.setValue(LocalDate.now());
		txtDistance.clear();
		txtCommentaires.clear();
	}
	
}

































































































