package premsPackages;
import javafx.event.*;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class flowPane extends Application {
	private Button button = new Button("1");
	private Button button1 = new Button("11111111");
	private Button button2 = new Button("165565656");
	private Button button4 = new Button("1888888");
	private Button button5 = new Button("1000000000");
	String valeurs[] = {"Charles Baudelaire", "Albert Camus"};
	ListView<String> list = new ListView<String>();
	private int nbClic = 0;
	
	private Label label = new Label("Choissisez couleur");
	private Label texte = new Label("nb click = " + nbClic);
	private HBox hbox1 = new HBox();
	private HBox hbox2 = new HBox();
	private VBox vbox = new VBox();
	private Rectangle rectangle = new Rectangle(180,180);
	private Button ok = new Button("ok");
	private Button annuler = new Button("annuler");
	private Button clickCount = new Button("nb click");
	private RadioButton bleu = new RadioButton("Bleu");
	private RadioButton vert = new RadioButton("Vert");
	private RadioButton jaune = new RadioButton("jaune");
	private RadioButton orange = new RadioButton("orange");


	
	private FlowPane flowPane = new FlowPane();
	private TilePane tilePane = new TilePane();
	private HBox hbox = new HBox();
	private BorderPane borderP = new BorderPane();
	private GridPane grid = new GridPane();
	private StackPane stack = new StackPane();
	private AnchorPane anchor = new AnchorPane();


	
	public void start(Stage maFenetre) {
		maFenetre.setTitle("Batman le mauvais");
		maFenetre.setWidth(500);
		maFenetre.setHeight(500);
		maFenetre.setMinWidth(100);
		maFenetre.setMinHeight(100);
		
		
		Scene laScene = new Scene(buttonEvent());
		maFenetre.setScene(laScene);
		maFenetre.show();
	}
	
	public FlowPane creerSceneGraph() {
		flowPane.getChildren().addAll(button,button1,button2,button4,button5);
		flowPane.setOrientation(Orientation.VERTICAL);
		flowPane.setPadding(new Insets(10, 30, 10, 30));
		flowPane.setAlignment(Pos.BOTTOM_CENTER);
		flowPane.setHgap(20);
		flowPane.setVgap(10);
		return flowPane;
	}
	public TilePane creerSceneGraphTile() {
		tilePane.getChildren().addAll(button,button1,button2,button4,button5);
		//tilePane.setOrientation(Orientation.VERTICAL);
		tilePane.setPadding(new Insets(10, 30, 10, 30));
		tilePane.setAlignment(Pos.BOTTOM_CENTER);
		tilePane.setHgap(20);
		tilePane.setVgap(10);
		return tilePane;
	}
	public HBox creerSceneGraphHBox() {
		hbox.getChildren().addAll(button,button1,button2,button4,button5);
		//tilePane.setOrientation(Orientation.VERTICAL);
		HBox.setMargin(button,new Insets(10));
		hbox.setAlignment(Pos.BOTTOM_CENTER);
		
		button.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(button, Priority.ALWAYS);
		return hbox;
	}
	public BorderPane creerSceneGraphBorder(){
		borderP.setTop(button);
		borderP.setLeft(button1);
		borderP.setCenter(button2);
		borderP.setRight(button4);
		borderP.setBottom(button5);
		BorderPane.setAlignment(button, Pos.CENTER);
		BorderPane.setAlignment(button1, Pos.CENTER);
		BorderPane.setAlignment(button2, Pos.CENTER);
		BorderPane.setAlignment(button4, Pos.CENTER);
		BorderPane.setAlignment(button5, Pos.CENTER);
		return borderP;
	}
	public GridPane creerSceneGraphGrid(){
		grid.add(button, 0, 0);
		grid.add(button1, 1, 1);
		grid.add(button2, 2, 2);
		grid.add(button4, 3, 3);
		grid.add(button5, 3, 0,3,1);
		grid.setGridLinesVisible(true);
		//grid.setHAlignment(button, );
		//grid.setHAlignment(button1, Pos.CENTER);
		//grid.setHAlignment(button2, Pos.CENTER);
		//grid.setHAlignment(button4, Pos.CENTER);
		//grid.setVAlignment(button5, Pos.CENTER);
		button.setMaxWidth(Double.MAX_VALUE);
		button.setMaxHeight(Double.MAX_VALUE);

		
		grid.setHgrow(button, Priority.ALWAYS);
		grid.setVgrow(button, Priority.ALWAYS) ;
		return grid;
	}
	public StackPane creerSceneGraphStack() {
		StackPane stack = new StackPane();
		stack.getChildren().addAll(new Rectangle(100,100,Color.BLUE),
		new Rectangle(80,80,Color.RED), new Label("Légende"));
		return stack;
	}
	public AnchorPane creerSceneGraphAnchor() {
		AnchorPane.setTopAnchor(button, 10.0);
		AnchorPane.setRightAnchor(button, 10.0);
		
		AnchorPane.setTopAnchor(button1, 40.0);
		AnchorPane.setRightAnchor(button1, 10.0);
		
		AnchorPane.setTopAnchor(button2, 70.0);
		AnchorPane.setRightAnchor(button2, 10.0);
		
		AnchorPane.setBottomAnchor(button4, 10.0);
		AnchorPane.setRightAnchor(button4, 10.0);
		list.getItems().addAll(valeurs);
		AnchorPane.setTopAnchor(list, 10.0);
		AnchorPane.setLeftAnchor(list, 10.0);
		AnchorPane.setRightAnchor(list, 100.0);
		AnchorPane.setBottomAnchor(list, 10.0);
		// ajout des composants au panneau
		anchor.getChildren().addAll(button, button1, button2, button4, list);
		return anchor;
	}
	
	public BorderPane creerSceneGraphBorderEx(){
		borderP.setTop(label);
		SceneGraphHBox();
		SceneGraphVBox();
		borderP.setLeft(vbox);
		borderP.setCenter(rectangle);
		borderP.setBottom(hbox);
		
		rectangle.setFill(Color.BLUE);
		//BorderPane.setAlignment(button, Pos.CENTER);
		//BorderPane.setAlignment(button1, Pos.CENTER);
		//BorderPane.setAlignment(button2, Pos.CENTER);
		//BorderPane.setAlignment(button4, Pos.CENTER);
		//BorderPane.setAlignment(button5, Pos.CENTER);
		return borderP;
	}
	public HBox SceneGraphHBox() {
		hbox1.getChildren().addAll(ok,annuler);
		//tilePane.setOrientation(Orientation.VERTICAL);
		HBox.setMargin(button,new Insets(10));
		hbox1.setAlignment(Pos.BOTTOM_RIGHT);
		
		button.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(button, Priority.ALWAYS);
		return hbox1;
	}
	public VBox SceneGraphVBox() {
		hbox.getChildren().addAll(bleu,vert,jaune,orange);
		tilePane.setOrientation(Orientation.VERTICAL);
		HBox.setMargin(button,new Insets(10));
		hbox.setAlignment(Pos.CENTER);
		
		button.setMaxWidth(Double.MAX_VALUE);
		HBox.setHgrow(button, Priority.ALWAYS);
		return vbox;
	}
	public HBox buttonEvent() {
		hbox2.getChildren().addAll(clickCount, texte);
		//tilePane.setOrientation(Orientation.VERTICAL);
		HBox.setMargin(clickCount,new Insets(10));
		hbox2.setAlignment(Pos.CENTER);
		button.setMaxWidth(Double.MAX_VALUE);
		clickCount.setOnAction(e -> incrClick());
		return hbox2;
	}
	public HBox buttonEvent() {
		hbox2.getChildren().addAll(clickCount, texte);
		//tilePane.setOrientation(Orientation.VERTICAL);
		HBox.setMargin(clickCount,new Insets(10));
		hbox2.setAlignment(Pos.CENTER);
		button.setMaxWidth(Double.MAX_VALUE);
		clickCount.setOnAction(e -> incrClick());
		return hbox2;
	}
	public void incrClick() {
		nbClic++;
		texte.setText("Nombre de clic = " + nbClic);
	}
	private void gererClick(ActionEvent e) {
		if(e.getSource() == clickCount){
			nbClic++;
		}else if(e.getSource() == annuler){
			nbClic--;
		}
	}
	private void frappeClavier(ActionEvent e) {
		if(e.getSource() == clickCount){
			nbClic++;
		}else if(e.getSource() == annuler){
			nbClic--;
		}
	}
	public static void main(String args[]) {
		Application.launch();
	}
}
