package sae201pack;

public class Jouer {
	String nomRole;
	Film film;
	Acteur acteur;
	public Jouer(Acteur acteur,Film film,String nomRole  ) {
		this.nomRole = nomRole;
		this.film=film;
		this.acteur = acteur;
	}
	public String getNomRole() {
		return nomRole;
	}
}
