package packScene;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class controlleurGeek {

    @FXML
    private Button fermer;

    @FXML
    private Button imprimer;

    @FXML
    void fermer(MouseEvent event) {
    	System.exit(0);
    }

    @FXML
    void imprimer(MouseEvent event) {
    	System.out.println("imprimer");
    }

}