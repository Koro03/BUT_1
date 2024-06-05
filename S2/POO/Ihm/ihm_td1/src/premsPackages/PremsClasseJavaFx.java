package premsPackages;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class PremsClasseJavaFx extends Application {
	private Circle soleil = new Circle(300,60,40);
	private Rectangle mer = new Rectangle(0,200,600,600);
	private Rectangle ciel = new Rectangle(0,0,600,600);
	private Rectangle sable = new Rectangle(0,300,600,600);
	private Rectangle serviette = new Rectangle(400,200,20,20);
	private Group plage = new Group();
	private Group racine = new Group();
	private Group horizon = new Group();
	
	
	public void start(Stage maFenetre){
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
	
	public Group creerSceneGraph() {	

		mer.setFill(Color.BLUE);
		serviette.setFill(Color.PINK);	
		soleil.setFill(Color.BLUEVIOLET);
		sable.setFill(Color.YELLOW);
		ciel.setFill(Color.AQUA);
		
		horizon.getChildren().addAll(ciel,soleil);
		plage.getChildren().addAll(serviette,sable);
		racine.getChildren().addAll(horizon,mer,plage);

		return racine;
	}
	
	public static void main(String args[]) {
		Application.launch();
	}
}

