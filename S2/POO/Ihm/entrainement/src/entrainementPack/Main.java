package entrainementPack;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Créer un champ de texte
        TextField textField = new TextField();

        

        // Créer un conteneur et ajouter le champ de texte
        VBox root = new VBox(textField);
        Scene scene = new Scene(root, 300, 200);

        // Configurer et afficher la fenêtre
        primaryStage.setScene(scene);
        primaryStage.setTitle("Application JavaFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
