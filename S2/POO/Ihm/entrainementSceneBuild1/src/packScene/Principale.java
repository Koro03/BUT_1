package packScene;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

public class Principale extends Application{
	static public FenTableRandos 	f1 ;
	static public FenDetailRando 	f3; //;
	static public FenNouvelleRando 	f2;
	
	static private ObservableList<Rando> lesRandos = FXCollections.observableArrayList();

	public void start(Stage primaryStage){ 
		lesRandos.add(new Rando("Tour du lac de Guerledan", "12/05/2018", 36, 640, 640, "Boucle autour du lac a partir de Bon-Repos. GR37 et GR341."));
		lesRandos.add(new Rando("Lannion-Plouaret", "15/06/2018", 22, 230, 110, "Par l'ancien GR34A.\nA voir :  chateau de Tonquedec, chapelle des Sept Saints"));
		lesRandos.add(new Rando("Prequ'ile de Crozon", "18/09/2018", 175, 1000, 1000, "Boucle a partir de Landevennec. GR34 puis GRP.\nPassage par Camaret-sur-mer, Crozon et le Menez Hom."));
		f1 = new FenTableRandos();
		primaryStage = f1;
		f1.init();
		f1.show(); 
	} 
	
	static void ajouterRando(String titre, int d, int m, int a, int distance, int devPos, int devNeg, String commentaires) {
		lesRandos.add(new Rando(titre, d+"/"+m+"/"+a, distance, devPos, devNeg, commentaires) );
	}
	
	static public void ouvrirNouvelleRando() {
		f2 = new FenNouvelleRando();
		f2.show();
	}
	
	static public void ouvrirDetailRando(int index) {
		Rando rando_selec = lesRandos.get(index);
		f3 = new FenDetailRando();
		f3.initDetail(rando_selec);
		f3.show();
	}
	
	static public void supprimerRando(Rando r) {
		lesRandos.remove(r);
	}
	
	static public ObservableList<Rando> getListe(){
		return lesRandos;
	}
	
	public static void main(String[] args) { 
		Application.launch(); 
	} 
}







































