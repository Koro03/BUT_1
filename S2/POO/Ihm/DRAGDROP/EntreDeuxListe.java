package monPackage;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class EntreDeuxListe extends Application { 
	// Les composants de la fen�tre
	private ListView<String> 	listeGauche	= new ListView<String>();
	private ListView<String>	listeDroite	= new ListView<String>();
	private Button 				bnTransfert	= new Button(">");
	private Button 				bnTransfert2	= new Button("<");
	// Les layout de la fen�tre
	private VBox zoneBoutons = new VBox();
	private HBox root = new HBox();
	private Stage f;
	
	
	public void start(Stage fenetre){ 
		fenetre.setTitle("DnD entre deux listes"); 
		fenetre.setResizable(false);
		Scene laScene = new Scene(creerSceneGraph());
		fenetre.setScene(laScene);
		f = fenetre;
		fenetre.sizeToScene();
		fenetre.show();
	}
	
	
	private Pane creerSceneGraph(){
		for (int i=1 ; i<11 ; i++){
			listeGauche.getItems().add("Element "+i);
		}
		
		
		bnTransfert.setPrefWidth(80);
		bnTransfert.setOnMouseDragged(e -> {
			if(e.getSceneY() > 0 && e.getSceneY() < f.getScene().getHeight() - bnTransfert.getHeight()) {
				bnTransfert.setTranslateY(e.getSceneY()) ;
			}
		});
		
		//selection multiple
		listeGauche.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		//etape 1
		listeGauche.setOnDragDetected(e -> {
			
			Dragboard db = listeGauche.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			ClipboardContent content = new ClipboardContent();
			String ch = new String();
			int taille = listeGauche.getSelectionModel().getSelectedItems().size();
			for(int i = 0; i < taille;i++) {
				ch = ch + listeGauche.getSelectionModel().getSelectedItems().get(i) + "\n";
			}
			content.putString(ch);
			db.setContent(content);
		});
		
		//etape 2
		listeDroite.setOnDragOver(e -> {e.acceptTransferModes(TransferMode.COPY_OR_MOVE);});
		
		//etape 3
		listeDroite.setOnDragDropped(e -> {
			Dragboard db = e.getDragboard();
			String data = db.getString();
			String [] elements = data.split("\n");
			// ... et on l'ajoute à la liste de droite
			for(int i = 0; i < elements.length ; i++) {
				listeDroite.getItems().add(elements[i]);
			}
			// on signale la fin de l'opération. Ceci va déclencher l'événement
			// "Dragdone" (voir ci-après)
			e.setDropCompleted(true);
		});
		
		//etape 4
		listeGauche.setOnDragDone(e -> {
			if (e.getTransferMode() == TransferMode.MOVE) {
				listeGauche.getItems().removeAll(
				listeGauche.getSelectionModel().getSelectedItems());
			}
		});
		
		
		bnTransfert.setOnAction(e -> {transferer(e);});
		
		// ***********bouton de transfert retour*******************
		
		bnTransfert2.setPrefWidth(80);
		
		bnTransfert2.setOnMouseDragged(e -> {
			if(e.getSceneY() > 0 && e.getSceneY() < f.getScene().getHeight() - bnTransfert2.getHeight()) {
				bnTransfert2.setTranslateY(e.getSceneY()) ;
			}
		});
		
		//selection multiple
		listeDroite.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		//etape 1
		listeDroite.setOnDragDetected(e -> {
			
			Dragboard db = listeDroite.startDragAndDrop(TransferMode.COPY_OR_MOVE);
			ClipboardContent content = new ClipboardContent();
			String ch = new String();
			int taille = listeDroite.getSelectionModel().getSelectedItems().size();
			for(int i = 0; i < taille;i++) {
				ch = ch + listeDroite.getSelectionModel().getSelectedItems().get(i) + "\n";
			}
			content.putString(ch);
			db.setContent(content);
		});
		
		//etape 2
		listeGauche.setOnDragOver(e -> {e.acceptTransferModes(TransferMode.COPY_OR_MOVE);});
		
		//etape 3
		listeGauche.setOnDragDropped(e -> {
			Dragboard db = e.getDragboard();
			String data = db.getString();
			String [] elements = data.split("\n");
			// ... et on l'ajoute à la liste de droite
			for(int i = 0; i < elements.length ; i++) {
				listeGauche.getItems().add(elements[i]);
			}
			// on signale la fin de l'opération. Ceci va déclencher l'événement
			// "Dragdone" (voir ci-après)
			e.setDropCompleted(true);
		});
		
		//etape 4
		listeDroite.setOnDragDone(e -> {
			if (e.getTransferMode() == TransferMode.MOVE) {
				listeDroite.getItems().removeAll(
				listeDroite.getSelectionModel().getSelectedItems());
			}
		});
		
		
		bnTransfert2.setOnAction(e -> {transferer2(e);});
		
		zoneBoutons.setAlignment(Pos.TOP_CENTER);
		zoneBoutons.getChildren().addAll(bnTransfert,bnTransfert2 );
		root.getChildren().addAll(listeGauche, zoneBoutons, listeDroite);

		return root;
	}
	
	public void transferer(ActionEvent e) {
		String elem = listeGauche.getSelectionModel().getSelectedItem();
		int val = listeGauche.getSelectionModel().getSelectedIndex();
		
		if (val != -1) {
			listeDroite.getItems().add(elem);
			listeGauche.getItems().remove(val);
		}else {
			System.out.println("rien n'est selectionné");
		}	
	}
	
	public void transferer2(ActionEvent e) {
		String elem = listeDroite.getSelectionModel().getSelectedItem();
		int val = listeDroite.getSelectionModel().getSelectedIndex();
		
		if (val != -1) {
			listeGauche.getItems().add(elem);
			listeDroite.getItems().remove(val);
		}else {
			System.out.println("rien n'est selectionné");
		}	
	}
	

	
	
	
	static public void main(String args[]) {
		Application.launch();
	}
}