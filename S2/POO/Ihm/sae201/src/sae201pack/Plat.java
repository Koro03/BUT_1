package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Plat {
	String nom;
	Recette recette;
	ArrayList<Restaurant> liste_Restaurants;
	public Plat(String nom) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		liste_Restaurants = new ArrayList<Restaurant>();
	}public ArrayList<Restaurant> getListe_Restaurants() {
		return liste_Restaurants;
	}public String getNom() {
		return nom;
	}public Recette getRecette() {
		return recette;
	}public void affiche() {
		System.out.println("id:" + getId()+" spe:"+getSpe());
		Iterator<Zone_geo> iterator = this.liste_Restaurant.iterator();
		while (iterator.hasNext()) {
			Zone_geo zone_geo = (Zone_geo) iterator.next();
			zone_geo.afficheZone();
		}
	}public void ajouterZone(Zone_geo zonzGeo) {
		if (zonzGeo == null || liste_Restaurant.contains(zonzGeo)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_Restaurant.add(zonzGeo);
		}
	}
	public void enleverZone(Zone_geo g) {
		if (!liste_Restaurant.contains(g) && g != null) {
			liste_Restaurant.remove(g);
			g.afficheZone();
			System.out.println(" zone supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
}
