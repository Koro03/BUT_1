package premsPackages;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MaClasseControleur {
	@FXML
    private RadioButton orange;

    @FXML
    private Rectangle rect;

    @FXML
    private RadioButton bleu;

    @FXML
    private Button bnOk;

    @FXML
    private RadioButton vert;

    @FXML
    private RadioButton jaune;

    @FXML
    private Button bnAnnuler;

    @FXML
    void cliquebleu(ActionEvent event) {
    	rect.setFill(Color.BLUE);
    }
    

    @FXML
    void cliquevert(ActionEvent event) {
    	rect.setFill(Color.GREEN);
    }

	
}
