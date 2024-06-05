package sae201;

import java.util.ArrayList;
import java.util.Iterator;

class Restaurant {
	private String nomString;
	private String adresseString;
	private ArrayList<Plat>liste_plat;
	public Restaurant(String n,String adr,Plat p) {
		// TODO Auto-generated constructor stub
		this.adresseString = adr;
		this.nomString = n;
		this.liste_plat = new ArrayList<Plat>();
		liste_plat.add(p);

	}public String getAdresseString() {
		return adresseString;
	}public ArrayList<Plat> getListe_plat() {
		return liste_plat;
	}public String getNomString() {
		return nomString;
	}public void ajouterP() {
		
	}public void supP() {
		
	}public void affiche() {
		System.out.println(""+getAdresseString());
		System.out.println(""+getNomString());
		Iterator<Plat> iterator = this.liste_plat.iterator();
		while (iterator.hasNext()) {
			Plat plat = (Plat) iterator.next();
			plat.affiche();
		}

	}
}
