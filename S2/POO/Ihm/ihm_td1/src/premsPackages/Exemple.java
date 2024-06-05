package premsPackages;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.*;
import javafx.util.converter.*;

public class Exemple {
	public static void main(String[] args) {
		IntegerProperty p1 = new SimpleIntegerProperty(100);
		IntegerProperty p2 = new SimpleIntegerProperty();
		
		DoubleProperty p3 = new SimpleDoubleProperty(300);
		DoubleProperty p4 = new SimpleDoubleProperty();
		
		/*****************Simple****************/
		System.out.println("***********************liaison simple********************");
		// p2 est liée à p1
		//liaison
		p2.bind(p1);
		// toute modification de p1 entraîne la modification de p2
		System.out.println(p2.get());
		p1.setValue(200.0);
		System.out.println(p2.get());
		
		
		/*****************liaison Bidirectionnel****************/
		System.out.println("***********************liaison Bidirectionnelle********************");
		// p1 et p2 sont liées l’une à l’autre
		p3.bindBidirectional(p4);
		// toute modification d'une propriété modifie l'autre
		System.out.println(p4.get());
		p3.setValue(200.0);
		System.out.println(p4.get());
				
		System.out.println(p3.get());
		p4.setValue(250.0);
		System.out.println(p3.get());
		
		
		/*****************liaison complexe****************/
		System.out.println("***********************liaison comp********************");
		IntegerProperty rayon = new SimpleIntegerProperty(100000);
		DoubleBinding perimetre = rayon.multiply(2*Math.PI); //double binding pour le type double
		
		System.out.println(perimetre.getValue());
		
		IntegerProperty p5 = new SimpleIntegerProperty(1000);
		IntegerProperty p6 = new SimpleIntegerProperty(205);
		NumberBinding total = p5.add(p6); //number binding pour les entiers
		
		System.out.println(total.getValue());
		
		/*****************Bindings****************/
		System.out.println("***********************Bindings********************");
		
		SimpleIntegerProperty nb = new SimpleIntegerProperty();
		SimpleStringProperty texte = new SimpleStringProperty();
		// création du "converter" nombre <-> chaine
		StringConverter<Number> converter = new NumberStringConverter();
		// liaison bidirectionnelle qui utilise le "converter"
		Bindings.bindBidirectional(texte, nb, converter);
		texte.setValue("54");
		System.out.println(nb.getValue());
		nb.setValue(45);
		System.out.println(texte.getValue());
		
		/*****************Bindings créateur de converter****************/
		System.out.println("***********************Bindings créateur de converter********************");
		
		SimpleIntegerProperty nb2 = new SimpleIntegerProperty();
		SimpleStringProperty texte2 = new SimpleStringProperty();
		// création d’une liaison : convert est liée à nb moyennant une conversion
		// de type : la valeur de nb est transformée en chaine
		StringBinding convert = Bindings.createStringBinding( () -> String.valueOf(nb.get()), nb);
		// liaison avec cette nouvelle "Binding"
		texte.bind(convert);
		
		/*****************Bindings liaiason conditionelle****************/
		System.out.println("***********************Bindings liaiason conditionelle********************");
		
		SimpleDoubleProperty somme = new SimpleDoubleProperty(89);
		SimpleDoubleProperty nb1 = new SimpleDoubleProperty(2);
		SimpleDoubleProperty moyenne = new SimpleDoubleProperty();
		BooleanBinding casErreur = Bindings.equal(nb1, 0);
		moyenne.bind(Bindings.when(casErreur).then(-1.0).otherwise(Bindings.divide(somme, nb1)));
		System.out.println(moyenne.getValue());
		
		/*****************liaison pour afficher texte****************/
		System.out.println("***********************liaison pour afficher texte********************");
		
		Label lblTexte1 = new Label("Texte :");
		TextField saisie = new TextField();
		Label lblTexte2 = new Label("Aperçu :");
		TextField apercu = new TextField();
		apercu.textProperty().bind(saisie.textProperty());
		
		
		}
		/*********************Test connexion*****************/
		Label 			lblLogin 		= new Label("Login : ");
		TextField 		txtLogin		= new TextField();
		Label 			lblPassword 	= new Label("Password : ");
		PasswordField 	txtPassword		= new PasswordField();
		Button 			bnSeConnecter 	= new Button("Se connecter");
		bnSeConnecter.disableProperty().bind(Bindings.when(txtLogin.textProperty().isEmpty()).then(true).otherwise(false));
		bnSeConnecter.disableProperty().bind(Bindings.when(txtLogin.textProperty().isEmpty().or(txtPassword.textProperty().isEmpty())).then(true).otherwise(false));

}
