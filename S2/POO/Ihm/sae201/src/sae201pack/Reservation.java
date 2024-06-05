package sae201pack;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

class Reservation {
	private ArrayList<Restaurant> liste_Restaurants;
	private ArrayList<Clientv2> liste_Client;
	private Date date; 
	public Reservation(Date date) {
		// TODO Auto-generated constructor stub
		this.date = date;
		liste_Restaurants = new ArrayList<Restaurant>();
		liste_Client = new ArrayList<Clientv2>();
	}public Date getDate() {
		return date;
	}public ArrayList<Clientv2> getListe_Client() {
		return liste_Client;
	}public ArrayList<Restaurant> getListe_Restaurants() {
		return liste_Restaurants;
	}
	


	public void affiche() {
		System.out.println("id:" + getId()+" spe:"+getSpe());
		Iterator<Restaurant> iterator = this.liste_Restaurants.iterator();
		while (iterator.hasNext()) {
			Restaurant Restaurant = (Restaurant) iterator.next();
			Restaurant.afficheZone();
		}
	}public void ajouterZone(Restaurant zonzGeo) {
		if (zonzGeo == null || liste_Restaurants.contains(zonzGeo)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_Restaurants.add(zonzGeo);
		}
	}
	public void enleverZone(Restaurant g) {
		if (!liste_Restaurants.contains(g) && g != null) {
			liste_Restaurants.remove(g);
			g.afficheZone();
			System.out.println(" zone supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
	
	
	
	public void afficheR() {
		System.out.println("id:" + getId()+" spe:"+getSpe());
		Iterator<Clientv2> iterator = this.liste_Client.iterator();
		while (iterator.hasNext()) {
			Clientv2 Clientv2 = (Clientv2) iterator.next();
			Clientv2.afficheZone();
		}
	}public void ajouterZone(Clientv2 zonzGeo) {
		if (zonzGeo == null || liste_Client.contains(zonzGeo)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_Client.add(zonzGeo);
		}
	}
	public void enleverZone(Clientv2 g) {
		if (!liste_Client.contains(g) && g != null) {
			liste_Client.remove(g);
			g.afficheZone();
			System.out.println(" zone supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
}
