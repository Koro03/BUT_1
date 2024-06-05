package premsPackages;

import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.util.*;
import javafx.util.converter.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.effect.*;

public class jsp extends Application{
	
	public void start(Stage f) {
		Label lblTexte1 = new Label("Texte :");
		TextField tfChamp1 = new TextField();
		Button bnFermer = new Button("Fermer");
		bnFermer.setOnAction(e -> f.close() );
		
		
		
		GridPane grid = new GridPane();
		grid.addRow(0, lblTexte1, tfChamp1);
		grid.add(bnFermer, 1, 1);
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(10));
		Scene scene = new Scene(grid);
		f.setScene(scene);
		f.setTitle("Aper�u");
		f.titleProperty.bind(tfChamp1.textProperty());
		f.show();
	}
	
	
	
	static public void main(String args[]) {
		Application.launch();
	}
	
}


