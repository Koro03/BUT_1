package sae201pack;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

class Principal {
	public static void main(String args[]) {
		Film film = new Film(102, "BIS", "français", " beaucoup ded blabla");
		Acteur franck = new Acteur("Franck ", "Dubosc") ;
		Acteur kad = new Acteur("kad ", "merad") ;
		Acteur alex = new Acteur("alex ", "lamy") ;
		
		Film film2 = new Film(104, "PAPA OU MAMAN", "français", " beaucoup ded blabla");
		Acteur marina = new Acteur("Marina ", "Fois") ;
		Acteur laurent = new Acteur("Laurent ", "Lafitte") ;
		
		film.ajouterActeur(franck);
		film.ajouterActeur(kad);
		film.ajouterActeur(alex);
		
		film2.ajouterActeur(marina);
		film.ajouterActeur(laurent);
		
		film.affiche();
		Date date = new Date();
		Seance seance_mat = new Seance(date, "matinée");
		Seance seance_deb_ap = new Seance(date, "matinée");
		Seance seance_fin_ap = new Seance(date, "matinée");
		Seance seance_soire = new Seance(date, "matinée");
		
		ArrayList<Seance> liste_Seances = new ArrayList<Seance>();
		liste_Seances.add(seance_mat);
		liste_Seances.add(seance_deb_ap);
		liste_Seances.add(seance_fin_ap);
		liste_Seances.add(seance_soire);
		
		film.ajouterSeance(seance_mat);
		film2.ajouterSeance(seance_deb_ap);
		film2.ajouterSeance(seance_fin_ap);
		film.ajouterSeance(seance_soire);
		
		seance_mat.ajouterFilm(film);
		seance_deb_ap.ajouterFilm(film2);
		seance_fin_ap.ajouterFilm(film2);
		seance_soire.ajouterFilm(film);
		
		Iterator<Seance> iterator = liste_Seances.iterator();
		while (iterator.hasNext()) {
			Seance seance = (Seance) iterator.next();
			seance.affiche();
					
		}
		System.out.println("*********************");
		
		alex.ajouterFilm(film);
		alex.lister_film();
		
		
	}
}
 