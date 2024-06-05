package premsPackages;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Td3 extends Application{
	public void start(Stage maFenetre) throws IOException{
		//
		maFenetre.setTitle("Batman le mauvais");
		maFenetre.setWidth(500);
		maFenetre.setHeight(500);
		maFenetre.setMinWidth(100);
		maFenetre.setMinHeight(100);
		
		
		Scene laScene = new Scene(creerSceneGraph());
		maFenetre.setScene(laScene);
		maFenetre.show();
		
	}
	private Pane creerSceneGraph() throws IOException {
		FXMLLoader loader;
		loader = new FXMLLoader(getClass().getResource("couleur.fxml"));
		Pane racine = loader.load();
		return racine;
	}
	public static void main(String args[]) {
		Application.launch();
	}
}
