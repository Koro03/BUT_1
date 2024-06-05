package premsPackages;

import javafx.application.Application;
import javafx.beans.binding.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class FenConnexion extends Application{
	
	public void start(Stage f)  {
		// les composants du formulaire
		Label 			lblLogin 		= new Label("Login : ");
		TextField 		txtLogin		= new TextField();
		Label 			lblPassword 	= new Label("Password : ");
		PasswordField 	txtPassword		= new PasswordField();
		Button 			bnSeConnecter 	= new Button("Se connecter");

		bnSeConnecter.setOnAction(e -> f.close());
		bnSeConnecter.disableProperty().bind(Bindings.when(txtLogin.textProperty().isEmpty().or(txtPassword.textProperty().isEmpty())).then(true).otherwise(false));
		
		
		
		GridPane grid = new GridPane();
		grid.addRow(0, lblLogin, txtLogin);
		grid.addRow(1, lblPassword, txtPassword);
		grid.add(bnSeConnecter, 3, 2);
		grid.setPadding(new Insets(10));
		grid.setVgap(10);
		Scene scene = new Scene(grid);
		f.setTitle("Connexion");
		f.setScene(scene);
		f.setResizable(false);
		f.show();
	}
	
	
	
	static public void main(String args[]) {
		Application.launch();
	}
}
















