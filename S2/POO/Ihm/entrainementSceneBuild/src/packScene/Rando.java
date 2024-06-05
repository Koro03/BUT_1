package packScene;

import javafx.beans.property.*;

public class Rando {
	private final IntegerProperty	numero;
	private final StringProperty 	titre;
	private final StringProperty	date;
	private final IntegerProperty 	distance;
	private final IntegerProperty 	devPos;
	private final IntegerProperty	devNeg;
	private final StringProperty 	commentaires;
	
	static private int nbRandos = 0;
	
	public Rando(String titre, String date, int distance, int devPos, int devNeg, String commentaires) {
		nbRandos++;
		this.numero 		= new SimpleIntegerProperty(nbRandos);
		this.titre 			= new SimpleStringProperty(titre);
		this.date 			= new SimpleStringProperty(date);
		this.distance 		= new SimpleIntegerProperty(distance);
		this.devPos			= new SimpleIntegerProperty(devPos);
		this.devNeg 		= new SimpleIntegerProperty(devNeg);
		this.commentaires 	= new SimpleStringProperty(commentaires);
	}
	
	public int getNumero() {
		return numero.get();
	}
	public IntegerProperty numeroProperty() {
		return this.numero;
	}

	public String getTitre() {
		return titre.get();
	}
	public void setTitre(String titre) {
		this.titre.set(titre);
	}
	public StringProperty titreProperty() {
		return this.titre;
	}
	
	public String getDate() {
		return date.get();
	}
	public void setDate(String date) {
		this.date.set(date);
	}
	public StringProperty dateProperty() {
		return this.date;
	}
	
	public int getDistance() {
		return distance.get();
	}
	public void setDistance(int distance) {
		this.distance.set(distance);
	}
	public IntegerProperty distanceProperty() {
		return this.distance;
	}
	
	public int getDevPos() {
		return devPos.get();
	}
	public void setDevPos(int devPos) {
		this.devPos.set(devPos);
	}
	public IntegerProperty devPosProperty() {
		return this.devPos;
	}
	
	public int getDevNeg() {
		return devNeg.get();
	}
	public void setDevNeg(int devNeg) {
		this.devNeg.set(devNeg);
	}
	public IntegerProperty devNegProperty() {
		return this.devNeg;
	}
	
	public String getCommentaires() {
		return commentaires.get();
	}
	public void setCommentaires(String commentaires) {
		this.commentaires.set(commentaires);
	}
	public StringProperty commentairesProperty() {
		return this.commentaires;
	}
	
	public void afficher() {
		System.out.println("Numero : "+ numero.get());
		System.out.println("Titre : "+ titre.get());
		System.out.println("Date : "+ date.get());
		System.out.println("Distance : "+ distance.get());
		System.out.println("dev+ : "+ devPos.get());
		System.out.println("dev- : "+ devNeg.get());
		System.out.println("Commentaires : "+ commentaires.get());
	}
}
