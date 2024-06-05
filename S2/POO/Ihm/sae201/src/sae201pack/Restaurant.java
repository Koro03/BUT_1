package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Restaurant {
	private String nom;
	private String adresse;
	ArrayList<Plat> liste_Plats;
	private ArrayList<Reservation>liste_Reservations;
	public Restaurant(String nom,String adresse ) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		this.adresse = adresse;
		liste_Plats = new ArrayList<Plat>();
		liste_Reservations = new ArrayList<Reservation>();
	}public String getAdresse() {
		return adresse;
	}public ArrayList<Plat> getListe_Plats() {
		return liste_Plats;
	}public ArrayList<Reservation> getListe_Reservations() {
		return liste_Reservations;
	}public String getNom() {
		return nom;
	}
	
	
	public void affiche() {
		System.out.println("id:" + getId()+" spe:"+getSpe());
		Iterator<Plat> iterator = this.liste_Reservations.iterator();
		while (iterator.hasNext()) {
			Plat plat = (Plat) iterator.next();
			plat.afficheZone();
		}
	}public void ajouterZone(Plat zonzGeo) {
		if (zonzGeo == null || liste_Reservations.contains(zonzGeo)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_Reservations.add(zonzGeo);
		}
	}
	public void enleverZone(Plat g) {
		if (!liste_Reservations.contains(g) && g != null) {
			liste_Reservations.remove(g);
			g.afficheZone();
			System.out.println(" zone supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}



	public void afficheR() {
		System.out.println("id:" + getId()+" spe:"+getSpe());
		Iterator<Reservation> iterator = this.liste_Reservations.iterator();
		while (iterator.hasNext()) {
			Reservation reservation = (Plat) iterator.next();
			reservation.afficheZone();
		}
	}public void ajouterR(Reservation zonzGeo) {
		if (zonzGeo == null || liste_Reservations.contains(zonzGeo)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_Plats.add(zonzGeo);
		}
	}
	public void enleverR(Reservation g) {
		if (!liste_Reservations.contains(g) && g != null) {
			liste_Reservations.remove(g);
			g.afficheZone();
			System.out.println(" zone supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
	
}
