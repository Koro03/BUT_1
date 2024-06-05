package premsPackages;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
//import javafx.stage.Modality;
import javafx.stage.Stage;

public class TP3_ihm_formu extends Application{
	static private Stage f;
	public void start(Stage maFenetre) throws IOException{
		//
		
		
		f = new Stage();
		f.setTitle("BULLETIN D'ABONNEMENT");
		f.setResizable(false);
		f.initModality(Modality.APPLICATION_MODAL);
		
		//maFenetre.setTitle("Formu test");
		//maFenetre.setWidth(800);
		//maFenetre.setHeight(800);
		//maFenetre.setResizable(false);
		//maFenetre.initModality(Modality.APPLICATION_MODAL);
		Scene laScene = new Scene(creerSceneGraph());
		f.setScene(laScene);
		f.show();
		
	}
	private Pane creerSceneGraph() throws IOException {
		FXMLLoader loader;
		loader = new FXMLLoader(getClass().getResource("/formulaire.fxml"));
		Pane racine = loader.load();
		return racine;
	}
	public static void main(String args[]) {
		Application.launch();
	}
	static public void fermer() {
		f.close();
	}
}
