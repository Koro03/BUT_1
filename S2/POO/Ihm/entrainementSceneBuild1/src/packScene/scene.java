package packScene;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import packScene.*;
import javafx.stage.Stage;

public class scene extends Application{
	public void start(Stage primaryStage) throws IOException {
        // Créer un champ de texte
        TextField textField = new TextField();

        

        // Créer un conteneur et ajouter le champ de texte
        VBox root = new VBox(textField);
        Scene scene = new Scene(creerSceneGraph());

        // Configurer et afficher la fenêtre
        primaryStage.setScene(scene);
        primaryStage.setTitle("Application JavaFX");
        primaryStage.show();
    }
	private Pane creerSceneGraph() throws IOException {
		FXMLLoader loader;
		loader = new FXMLLoader(getClass().getResource("/geek.fxml"));
		Pane racine = loader.load();
		return racine;
	}

    public static void main(String[] args) {
        Application.launch(args);
    }
}