package sae201pack;

import java.util.Date;

public class sae201 {
	public static void main(String[] args) {
		Date currentdateDate = new Date();
		Acteur acteur = new Acteur("Brat", "Pitt");
		acteur.affihe();
		
		Acteur acteur1 = new Acteur("Brat", "Pitte");
		acteur1.affihe();
		
		if (acteur.equals(acteur1)) {
			System.out.println("act identiques");
		} else {
			System.out.println("act pas identiques");
		}
		Acteur acteur3 = new Acteur("Brat", "Pitt");
		acteur.affihe();
		if (acteur.equals(acteur3)) {
			System.out.println("act identiques");
		} else {
			System.out.println("act pas identiques");
		}
		
		/*********************Film********************/
		Film film = new Film(0, "Brat", "Pitt", " top");
		film.affiche();
		
		Film film1 = new Film(0,"Brat", "Pitte","incr");
		film1.affiche();
		
		if (film.equals(film1)) {
			System.out.println("act identiques");
		} else {
			System.out.println("act pas identiques");
		}
		Film film3 = new Film(0, "Brat", "Pitt", " top");
		film3.affiche();
		if (acteur.equals(acteur3)) {
			System.out.println("act identiques");
		} else {
			System.out.println("act pas identiques");
		}
		/******************************Seance**********************/
		Seance seance = new Seance(currentdateDate, "Brat");
		seance.ajouterFilm(film3);
		seance.affecterFilm(film3);
		Seance seance2 = new Seance(currentdateDate,"Brat1");
		//seance2.ajouterFilm(null);
		//seance2.affecterFilm(null);
		seance.affiche();
		seance.enleverProgrammer(film3);
		
		
		/****************************Q5*****************/
		Film film5 = new Film(102, "BIS", "français", " beaucoup ded blabla");
		Acteur franck = new Acteur("Franck ", "Dubosc") ;
		Acteur kad = new Acteur("kad ", "merad") ;
		Acteur alex = new Acteur("alex ", "lamy") ;

		film5.ajouterActeur(franck);
		film5.ajouterActeur(kad);
		film5.ajouterActeur(alex);
		
		film5.affiche();
		film5.enleverJouer(alex);
		film5.affiche();
	}
	
}
