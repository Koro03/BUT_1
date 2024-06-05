package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Acteur {
	private String prenom;
	private String nom;
	private ArrayList<Film> mesFilms;
	public Acteur(String prenom,String nom ) {
		this.nom = nom;
		this.prenom = prenom;
		mesFilms = new ArrayList<Film>();
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public ArrayList<Film> getMesFilms() {
		return mesFilms;
	}
	public void ajouterFilm(Film f) {
		Iterator<Acteur> iterator = f.getMesActeurs().iterator();
		while (iterator.hasNext()) {
			Acteur acteur = (Acteur) iterator.next();
			if (acteur == this) {
				this.mesFilms.add(f);
			}			
		}
	}
	public void lister_film() {
		Iterator<Film> iterator = this.mesFilms.iterator();
		while (iterator.hasNext()) {
			Film film = (Film) iterator.next();
			film.affiche();
		}
	}
	
	public boolean equals(Object o){
        
        return (this.nom.equals(((Acteur)o).getNom()) && this.prenom.equals(((Acteur)o).getPrenom()) );
    }
	public void affihe() {
		System.out.print(" " + getNom() + " " + getPrenom() + " ");
	}
	
}
