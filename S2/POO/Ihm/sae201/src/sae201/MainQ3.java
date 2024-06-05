package sae201;

import java.util.Date;

public class MainQ3 {
	public static void main(String[] args) {
		Recette recette = new Recette("taboule sauce bangala");
		recette.affiche();
		Plat plat = new Plat("taboule", recette);
		plat.affiche();
		Restaurant restaurant = new Restaurant("le filou", "kerdavid", plat);
		restaurant.affiche();
		Date date = new Date();
		Client client = new Client("le b");
		Reservation reservation = new Reservation(date, restaurant, client);
		reservation.affiche();
		
		
		Recette recette1 = new Recette("taboule sauce truffala");

		plat.ajouteR(recette1);
		plat.ajouteR(recette);
		
		plat.affiche();
		plat.supR(recette1);
		plat.affiche();
	}
}
