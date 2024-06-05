package sae201pack;

import java.util.Date;
import java.util.Iterator;

class Seance {
	private Date date;
	private String typeSeance;
	private Film monFilm;
	
	public Seance(Date date,String typeSeance) {
		this.date = date;
		this.typeSeance = typeSeance;
		
	}public Date getDate() {
		return date;
	}
	public Film getMonFilm() {
		return monFilm;
	}
	public String getTypeSeance() {
		return typeSeance;
	}
	
	public void ajouterFilm(Film f) {
		if (f == null) {
			System.out.println(" c nul");
		} else {
			affecterFilm(f);
			f.affiche();
			System.out.println("Film ajouter");
		}
	}
	public void affecterFilm(Film f) {
		Iterator<Seance> iterator = f.getMesSeance().iterator();
		while (iterator.hasNext()) {
			Seance seance = (Seance) iterator.next();
			if (seance == this) {
				this.monFilm = f;
				seance.affiche();
			}			
		}
	}
	public void enleverProgrammer(Film f) {
		if (f == null) {
			System.out.println("pas de film a enlever");
		} else {
			this.monFilm.affiche();
			enleverFilm(f);
			
		}
	}
	public void enleverFilm(Film f) {
		Iterator<Seance> iterator = f.getMesSeance().iterator();
		while (iterator.hasNext()) {
			Seance seance = (Seance) iterator.next();
			if (seance == this) {
				seance.affiche();
				this.monFilm = null;
			}			
		}
		
	}
	public boolean equals(Seance s){
        
        return (this.date.equals((s.getDate())) && this.typeSeance.equals((s.getTypeSeance()))  );
    }
	public void affiche() {
		System.out.println(this.getDate() + " date   "+this.getTypeSeance() + " de type ");
		if (this.getMonFilm() != null) {
	        System.out.println(" de type " + this.getMonFilm().toString());
	    } else {
	        System.out.println(" (Aucun film associé)");
	    }
	}
}
