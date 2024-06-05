package premsPackages;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.event.*;

public class fenetre extends Application {
	private Group racine = new Group();
	private Label label = new Label("Choissisez couleur");
	private RadioButton bleu = new RadioButton("Bleu");
	private RadioButton vert = new RadioButton("Vert");
	private RadioButton jaune = new RadioButton("jaune");
	private RadioButton orange = new RadioButton("orange");
	private Rectangle rectangle = new Rectangle(180,180);
	private Button ok = new Button("ok");
	private Button annuler = new Button("annuler");
	private ToggleGroup groupeBR = new ToggleGroup();
	
	private Stage f; 
	
	
	public void start(Stage maFenetre) {
		maFenetre.setTitle("Batman le mauvais");
		maFenetre.setWidth(500);
		maFenetre.setHeight(500);
		maFenetre.setMinWidth(100);
		maFenetre.setMinHeight(100);
		
		f = maFenetre;
		
		Scene laScene = new Scene(creerSceneGraph());
		maFenetre.setScene(laScene);
		maFenetre.show();
	}
	
	public Group creerSceneGraph(){
		label.setLayoutX(10);
		label.setLayoutY(10);
		
		bleu.setLayoutX(10);
		bleu.setLayoutY(100);

		
		vert.setLayoutX(10);
		vert.setLayoutY(120);

		
		jaune.setLayoutX(10);
		jaune.setLayoutY(140);
		
		orange.setLayoutX(10);
		orange.setLayoutY(160);

		
		ok.setLayoutX(220);
		ok.setLayoutY(300);
		
		annuler.setLayoutX(280);
		annuler.setLayoutY(300);
		
		rectangle.setLayoutX(180);
		rectangle.setLayoutY(40);
		rectangle.setFill(Color.BLUE);
		
		groupeBR.getToggles().add(vert);
		groupeBR.getToggles().add(bleu);
		groupeBR.getToggles().add(jaune);
		groupeBR.getToggles().add(orange);
		
		groupeBR.selectToggle(bleu);
		
		racine.getChildren().addAll(label,bleu,vert,jaune,orange,ok,annuler,rectangle);
		//setOnAction = click
		bleu.setOnAction(e -> {gererClick(e);});
		vert.setOnAction(e -> {gererClick(e);});
		orange.setOnAction(e -> {gererClick(e);});
		jaune.setOnAction(e -> {gererClick(e);});
		ok.setOnAction(e -> {gererClick(e);});
		annuler.setOnAction(e -> {gererClick(e);});
		// setOnMouseEnter
		bleu.setOnMouseEntered(e -> {gererSurvole(e);});
		vert.setOnMouseEntered(e -> {gererSurvole(e);});
		orange.setOnMouseEntered(e -> {gererSurvole(e);});
		jaune.setOnMouseEntered(e -> {gererSurvole(e);});
		
		bleu.setOnMouseExited(e -> {gererExit(e);});
		vert.setOnMouseExited(e -> {gererExit(e);});
		orange.setOnMouseExited(e -> {gererExit(e);});
		jaune.setOnMouseExited(e -> {gererExit(e);});
		
		return racine;
	}
	public void gererClick(ActionEvent e) {
		if (e.getSource()== jaune){
			rectangle.setFill(Color.YELLOW);
		} else if (e.getSource()== vert){
			rectangle.setFill(Color.GREEN);
		}else if (e.getSource()== bleu){
			rectangle.setFill(Color.BLUE);
		}else if (e.getSource()== orange){
			rectangle.setFill(Color.ORANGE);
		}else if (e.getSource()== ok){
			System.out.println("couleur choisie :" + rectangle.getFill());
		}else if (e.getSource()== annuler){
			f.close();
		}
	}
	public void gererSurvole(MouseEvent e) {
		if (e.getSource()== jaune){
			rectangle.setFill(Color.YELLOW);
		} else if (e.getSource()== vert){
			rectangle.setFill(Color.GREEN);
		}else if (e.getSource()== bleu){
			rectangle.setFill(Color.BLUE);
		}else if (e.getSource()== orange){
			rectangle.setFill(Color.ORANGE);
		}
	}
	public void gererExit(MouseEvent e) {
		if (e.getSource()== jaune){
			
			rectangle.setFill(rectangle.getFill());
		} else if (e.getSource()== vert){
			rectangle.setFill(rectangle.getFill());
		}else if (e.getSource()== bleu){
			rectangle.setFill(rectangle.getFill());
		}else if (e.getSource()== orange){
			rectangle.setFill(rectangle.getFill());
		}
	}
	public static void main(String args[]) {
		Application.launch();
	}
}
