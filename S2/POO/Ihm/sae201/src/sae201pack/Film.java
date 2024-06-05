package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Film {
	private String titre;
	private int duree;
	private String nationalite;
	private String resume;
	private ArrayList<Acteur> mesActeurs;
	private ArrayList<Seance> mesSeance;
	
	public Film(int duree,String titre,String nationalite,String resume) {
		this.duree = duree;
		this.nationalite = nationalite;
		this.titre = titre;
		this.resume = resume;
		mesActeurs = new ArrayList<Acteur>();
		mesSeance = new ArrayList<Seance>();
	}
	public int getDuree() {
		return duree;
	}
	public String getNationalite() {
		return nationalite;
	}
	public String getResume() {
		return resume;
	}
	public String getTitre() {
		return titre;
	}
	public ArrayList<Seance> getMesSeance() {
		return this.mesSeance;
	}
	public ArrayList<Acteur> getMesActeurs() {
		return mesActeurs;
	}
	public boolean contientActeur(Acteur a) {
		return this.mesActeurs.contains(a);
	}
	public void ajouterActeur(Acteur a) {
		if (a == null || this.contientActeur(a)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");

		} else {
			this.mesActeurs.add(a);
			
		}
	}
	public void listerActeurs() {
		Iterator<Acteur> iterator = this.mesActeurs.iterator();
		while (iterator.hasNext()) {
			Acteur acteur = (Acteur) iterator.next();
			acteur.affihe();
		}
	}
	
	public void enleverJouer(Acteur a) {
		if (contientActeur(a) && a != null) {
			enleverActeur(a);
			a.affihe();
			System.out.println(" acteur supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
	public void enleverActeur(Acteur a) {
		this.mesActeurs.remove(a);
	}
	public void ajouterSeance(Seance s) {
		if (s == null || mesSeance.contains(s)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.mesSeance.add(s);
		}
	}
	
	public boolean equals(Film f){
        
        return this.titre.equals((f.getTitre()));
    }
	public String toString() {
		return this.getTitre() + " Film   "+this.getNationalite() + " de "+this.getDuree() + " resume :" + this.getResume() ;
	}
	public void affiche() {
		System.out.println(this.getTitre() + "\tFilm "+this.getNationalite() + " de "+this.getDuree() + "\n\nresume :" + this.getResume() );
		System.out.print("\nActeurs :");
		this.listerActeurs();
	}
	
	
}
