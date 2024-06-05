package vue;

import java.util.Optional;

import javax.swing.RepaintManager;

import controleur.Main;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modele.Donnees;
import modele.Employe;
import javafx.scene.control.*;

public class CtrlListeEmployes {

    @FXML private Button bnAjouter;
    @FXML private Button bnModifier;
    @FXML private Button bnSupprimer;
    @FXML private Button bnFermer;
    @FXML private TableView<Employe> tvListeEmployes;
    @FXML private MenuItem optionAjouter = new MenuItem("Ajouter...");
    @FXML private MenuItem optionModifier = new MenuItem("Modifier...");
    @FXML private MenuItem optionSupprimer = new MenuItem("Supprimer"); 
    private ContextMenu menu = new ContextMenu( optionAjouter,
    		new SeparatorMenuItem(),
    		optionModifier,
    		new SeparatorMenuItem(),
    		optionSupprimer);
    // clic sur bouton Ajouter
    @FXML void clicAjouter(ActionEvent event) {
    	Main.ouvrirNouvelEmploye();
    }
    
    // clic sur bouton Modifier
    @FXML void clicModifier(ActionEvent event) {
    	Main.ouvrirModifierEmploye(tvListeEmployes.getSelectionModel().getSelectedItem());
    }
    
    // clic sur bouton Supprimer
     @FXML void clicSupprimer(ActionEvent event) {
    	 Alert alert = new Alert(
    			 AlertType.CONFIRMATION,
    			 "Voulez-vous vraiment supprimer cet employé ?",
    			 ButtonType.YES,
    			 ButtonType.NO
    	);
    	 alert.setTitle("Confirmation du message");
    	 alert.showAndWait();
    	 Optional<ButtonType> reponse;
    	 reponse = alert.showAndWait();
    	 if (reponse.get() == ButtonType.YES) {
			Main.supprimerEmploye(tvListeEmployes.getSelectionModel().getSelectedItem());
		}
    	 
    }
     
     // clic sur bouton Fermer
    @FXML void clicFermer(ActionEvent event) {
    	Main.fermerAppli();;
    }
    
    @FXML void initialize() {
    	TableColumn<Employe,Integer> colonne1 = new TableColumn<Employe,Integer>("Matricule");
		colonne1.setCellValueFactory(new PropertyValueFactory<Employe,Integer>("matricule"));	
		tvListeEmployes.getColumns().set(0, colonne1);
		TableColumn<Employe, String> colonne2 = new TableColumn<Employe,String>("Nom");
		colonne2.setCellValueFactory(new PropertyValueFactory<Employe, String>("nom"));
		tvListeEmployes.getColumns().set(1, colonne2);
		TableColumn<Employe, String> colonne3 = new TableColumn<Employe,String>("Poste");
		colonne3.setCellValueFactory(new PropertyValueFactory<Employe, String>("poste"));
		tvListeEmployes.getColumns().set(2, colonne3);
		TableColumn<Employe,Integer> colonne4 = new TableColumn<Employe,Integer>("D�partement");
		colonne4.setCellValueFactory(new PropertyValueFactory<Employe, Integer>("dept"));
		tvListeEmployes.getColumns().set(3, colonne4);
				
		tvListeEmployes.setItems(Donnees.getLesEmployes());
		tvListeEmployes.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		//griser les boutons Modifier et Supprimer quand aucune s�lection
		BooleanBinding rien = Bindings.equal(tvListeEmployes.getSelectionModel().selectedIndexProperty(), -1);
		bnSupprimer.disableProperty().bind(rien);
		bnModifier.disableProperty().bind(rien);

    }
    
}
