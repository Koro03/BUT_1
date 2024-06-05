package premsPackages;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class controlleur_formu {

    @FXML
    private TextField nom_nb_carac;

    @FXML
    private ToggleGroup reglement;

    @FXML
    private TextField ville_nb_carac;

    @FXML
    private TextField prenom_nb_carac;

    @FXML
    private ToggleGroup abo;
    
    @FXML
    private Button bnOk;
    
    @FXML
    private Button Annuler;
    
    @FXML
    private TextField code_postal;
    
    @FXML
    private TextField adresse1;

    @FXML
    private TextField adresse2;
    
    @FXML
    private TextField numTel;

    @FXML
    private TextField email;

    
    @FXML
    public void initialize() {
    	//initialise tout ce qui doit être mit au début
    	nom_nb_carac.setTooltip(new Tooltip("Maximum 15 caractères"));
    	ville_nb_carac.setTooltip(new Tooltip("Maximum 15 caractères"));
    	prenom_nb_carac.setTooltip(new Tooltip("Maximum 15 caractères"));
    	//bnOk.setDisable(true);
    }
    
    @FXML 
    public void supp_carac(KeyEvent e) {
    	if (nom_nb_carac.getText().length() >= 16) {
    		nom_nb_carac.deletePreviousChar();
    		//keyEvent dans javafx
    	}
    }
    @FXML
    public void code_postal_correct(KeyEvent e) {
    	if (code_postal.getText().length()!= 5) {
    		e.consume();
    		Alert erreur = new Alert(AlertType.ERROR, "Le code postal doit être sur 5 caractères. Veuillez modifier ce champ.", ButtonType.OK);
    		erreur.setTitle("Code postal : format incorrect");
    		erreur.showAndWait();
    	}	
    }
    @FXML
    public void vile_nb_correct(KeyEvent e) {
    	
    	if (ville_nb_carac.getText().length() > 32) {
    		e.consume();
    		Alert erreur = new Alert(AlertType.ERROR, "Le code postal doit être sur 5 caractères. Veuillez modifier ce champ.", ButtonType.OK);
    		erreur.setTitle("Code postal : format incorrect");
    		erreur.showAndWait();
    	}
    }
    @FXML
    void adresse_correct(KeyEvent e) {
    	if (adresse1.getText().length() > 38 || adresse2.getText().length() > 38) {
    		e.consume();
    		Alert erreur = new Alert(AlertType.ERROR, "Le code postal doit être sur 5 caractères. Veuillez modifier ce champ.", ButtonType.OK);
    		erreur.setTitle("Code postal : format incorrect");
    		erreur.showAndWait();
    	}
    }
    @FXML
    void email_correct(KeyEvent e) {
    	if (!email.getText().contains("@")) {
    		e.consume();
    		Alert erreur = new Alert(AlertType.ERROR, "Le code postal doit être sur 5 caractères. Veuillez modifier ce champ.", ButtonType.OK);
    		erreur.setTitle("Code postal : format incorrect");
    		erreur.showAndWait();
    	}
    }
    @FXML
    void prenom_correct(KeyEvent e) {
    	if (prenom_nb_carac.getText().length() > 15) {
    		e.consume();
    		Alert erreur = new Alert(AlertType.ERROR, "Le code postal doit être sur 5 caractères. Veuillez modifier ce champ.", ButtonType.OK);
    		erreur.setTitle("Code postal : format incorrect");
    		erreur.showAndWait();
    	}
    }
   @FXML
    void valider_formu(MouseEvent e) {
    	//if(prenom_nb_carac.getText().length() > 15 && !email.getText().contains("@") && (adresse1.getText().length() > 38 || adresse2.getText().length() > 38) && ville_nb_carac.getText().length() > 32 && code_postal.getText().length()!= 5) {
    		//e.consume();
    		//Alert erreur = new Alert(AlertType.ERROR, "Le code postal doit être sur 5 caractères. Veuillez modifier ce champ.", ButtonType.OK);
    		//erreur.setTitle("formulaire non correct");
    		//erreur.showAndWait();
    	//}
    	//if() {
    		
    	}
    //}
    @FXML
    void annuler(MouseEvent e) {
    	TP3_ihm_formu.fermer();
    }
    
    
    
    
}


