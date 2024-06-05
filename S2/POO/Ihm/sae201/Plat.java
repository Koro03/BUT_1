package sae201;

import java.util.ArrayList;
import java.util.Iterator;

class Plat {
	//pas d'arrayliste puisque on prend 
	//la multiplicité en face
	private ArrayList<Recette>liste_recette;
	private String nomString;
	public Plat(String n,Recette r) {
		// TODO Auto-generated constructor stub
		this.nomString = n;
		this.liste_recette = new ArrayList<Recette>();
		liste_recette.add(r);
	}public ArrayList<Recette> getListe_recette() {
		return liste_recette;
	}public String getNomString() {
		return nomString;
	}public void affiche() {
		System.out.println(""+getNomString());
		Iterator<Recette> iterator = this.liste_recette.iterator();
		while (iterator.hasNext()) {
			Recette recette = (Recette) iterator.next();
			recette.affiche();
		}
	}public void ajouteR(Recette r) {
		if (r == null || liste_recette.contains(r)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_recette.add(r);
		}
	}public void supR(Recette r) {
		if (r == null || liste_recette.contains(r) == false) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_recette.remove(r);
		}
	}
}
