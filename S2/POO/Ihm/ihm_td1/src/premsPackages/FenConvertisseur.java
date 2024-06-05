package premsPackages;

import javafx.application.Application;
import javafx.beans.binding.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
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

public class FenConvertisseur extends Application{
	static private final double TAUX_DE_CHANGE = 1.09;
	
	public void start(Stage f){
		// les composants du formulaire
		Label 		labelEuro 	= new Label("Euros :");
		TextField 	txtEuros 	= new TextField("0.0");
		Label 		labelDollar = new Label("Dollars :");
		TextField 	txtDollar 	= new TextField("0.0");
		Button 		bnFermer 	= new Button("Fermer");

		// les propriétés
		final SimpleDoubleProperty valEuros = new SimpleDoubleProperty();
		final SimpleDoubleProperty valDollars = new SimpleDoubleProperty();
		
		//valEuros.bind(Bindings.createDoubleBinding(()->Double.parseDouble(txtEuros.getText()), txtEuros.textProperty()));
		
		valDollars.bind(valEuros.multiply(TAUX_DE_CHANGE));
		// crer un convertisseur de double vers String
		txtDollar.textProperty().bind(Bindings.createStringBinding( () -> String.valueOf(valDollars.get()), valDollars));

		BooleanBinding casErreur = Bindings.equal(txtEuros.textProperty(), " "); 
		// crer un convertisseur de String vers doubleah mer
		valEuros.bind(Bindings.when(casErreur).then(0.0).otherwise(Bindings.createDoubleBinding(()->Double.parseDouble(txtEuros.getText()), txtEuros.textProperty())));

		bnFermer.setOnAction(e -> f.close());
		GridPane grid = new GridPane();
		grid.addRow(0, labelEuro, txtEuros);
		grid.addRow(1, labelDollar, txtDollar);
		grid.add(bnFermer, 3, 2);
		grid.setPadding(new Insets(10));
		grid.setVgap(10);
		Scene scene = new Scene(grid);
		f.setTitle("Convertisseur");
		f.setScene(scene);
		f.setResizable(false);
		f.show();
	}
	
	
	static public void main(String args[]) {
		Application.launch();
	}
}

