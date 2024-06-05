public class test extends Application{
    private Button jsp = new Button() ;
    private RadioButtonButton jsp = new RadioButton() ;
    private TextField 	txtDollar		= new TextField();
	private Label 		symboleEuro 	= new Label("�");
    
    
    public void start(Stage fenetre){
        fenetre.setWidth();
        fenetre.setHeight();
        fenetre.setMinHeight();
        fenetre.setMinWidth();


        fenetre.setTitle("Convertisseur"); 
		fenetre.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		fenetre.setScene(laScene);
		fenetre.sizeToScene();
		fenetre.show();
    }
    
    private Pane creerSceneGraph(){
        return ;
    }
    public static void main(String args[]){
        Application.launch();
    }
}