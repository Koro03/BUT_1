package packScene;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Optional;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FenTableRandos extends Stage {
	// les donn�es
	ObservableList<Rando> liste = FXCollections.observableArrayList();
	
	// les composants de la fenetre
	private AnchorPane  		racine			= new AnchorPane();
	private TableView<Rando> 	tableRandos		= new TableView<Rando>();
	private Button 				bnAjouter 		= new Button("Ajouter...");
	private Button 				bnSupprimer 	= new Button("Supprimer");
	private Button 				bnFermer		= new Button("Fermer");
	private Button 				bnDetails		= new Button("Détails");

	// constructeur : initialisation de la fenetre
	public FenTableRandos(){
		this.setTitle("Liste des randos");
		this.setResizable(true);
		this.setWidth(500);
		this.setHeight(500);
		this.setMinWidth(500);
		this.setMinHeight(500);
		this.setScene(new Scene(creerContenu()));
		
		
	}
	
	// creation du contenu
	private Parent creerContenu() {
		
		BooleanBinding aucuneSelection = Bindings.equal(-1,  tableRandos.getSelectionModel().selectedIndexProperty());
		
		TableColumn<Rando,String> colonne1 = new TableColumn<Rando,String>("Titre");
		colonne1.setCellValueFactory(new PropertyValueFactory<Rando,String>("titre"));
		tableRandos.getColumns().add(colonne1);
		
		TableColumn<Rando, String> colonne2 = new TableColumn<Rando,String>("Date");
		colonne2.setCellValueFactory(new PropertyValueFactory<Rando, String>("date"));
		tableRandos.getColumns().add(colonne2);
		
		TableColumn<Rando, Integer> colonne3 = new TableColumn<Rando,Integer>("Distance (km)");
		colonne3.setCellValueFactory(new PropertyValueFactory<Rando, Integer>("distance"));
		tableRandos.getColumns().add(colonne3);
		
		tableRandos.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		bnAjouter.setPrefWidth(100);
		
		bnSupprimer.setPrefWidth(100);
		
		bnFermer.setPrefWidth(100);
		
		bnDetails.setPrefWidth(100);
		
		bnFermer.setOnAction(e -> clicFermer());
		bnDetails.disableProperty().bind(aucuneSelection);
		bnSupprimer.disableProperty().bind(aucuneSelection);
		
		bnAjouter.setOnAction(e-> {
			Principale.ouvrirNouvelleRando();
			
		});
		
		bnDetails.setOnAction(e -> {
            int selectedIndex = tableRandos.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                Principale.ouvrirDetailRando(selectedIndex);
            }
        });
		
		bnSupprimer.setOnAction(e->{
			if (tableRandos.getSelectionModel().getFocusedIndex() != -1) {
				Alert alert = new Alert(
						AlertType.CONFIRMATION,
						"Voulez-vous vraiment supprimer cet employé ?",
						ButtonType.YES,
						ButtonType.NO
				);
				alert.setTitle("Confirmation de suppression");
				alert.showAndWait();
				
				System.out.println("c bon");
			}
			
		});
		
		// construction du Scene graph
		AnchorPane.setTopAnchor(bnAjouter, 25.0);
		AnchorPane.setRightAnchor(bnAjouter, 10.0);
		AnchorPane.setTopAnchor(bnSupprimer, 105.0);
		AnchorPane.setRightAnchor(bnSupprimer, 10.0);
		AnchorPane.setBottomAnchor(bnFermer, 25.0);
		AnchorPane.setRightAnchor(bnFermer, 10.0);
		AnchorPane.setTopAnchor(bnDetails, 65.0);
		AnchorPane.setRightAnchor(bnDetails, 10.0);
		
		AnchorPane.setTopAnchor(tableRandos, 10.0);
		AnchorPane.setLeftAnchor(tableRandos, 10.0);
		AnchorPane.setRightAnchor(tableRandos, 150.0);
		AnchorPane.setBottomAnchor(tableRandos, 10.0);	
		racine.getChildren().addAll(tableRandos, bnAjouter, bnSupprimer, bnFermer,bnDetails);
		
		return racine;
	}
	
	public void clicFermer() {
		System.exit(0);
	}
	
	public void init() {
		this.tableRandos.setItems(Principale.getListe());
	}
}
