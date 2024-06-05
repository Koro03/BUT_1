package vue;

import java.io.IOException;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenListeEmployes extends Stage {
	
	public FenListeEmployes() throws IOException {
		this.setTitle("Liste des employ�s");
		Scene laScene = new Scene(creerSceneGraph());
		this.setMinHeight(600);
		this.setMinWidth(30);
		this.setScene(laScene);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/listeEmployes.fxml"));
        Pane root = loader.load();
        loader.getController();
     	return root;
	}
}

