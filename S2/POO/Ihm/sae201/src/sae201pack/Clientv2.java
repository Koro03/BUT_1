package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Clientv2 {
	private ArrayList<Reservation> liste_Reservations;
	private String nom;
	public Clientv2(String nom) {
		// TODO Auto-generated constructor stub
		liste_Reservations = new ArrayList<Reservation>();
		this.nom = nom;
	}
	public ArrayList<Reservation> getListe_Reservations() {
		return liste_Reservations;
	}public String getNom() {
		return nom;
	}
	
	
	public void affiche() {
		System.out.println("id:" + getId()+" spe:"+getSpe());
		Iterator<Reservation> iterator = this.liste_Reservations.iterator();
		while (iterator.hasNext()) {
			Reservation Reservation = (Reservation) iterator.next();
			Reservation.afficheZone();
		}
	}public void ajouterZone(Reservation zonzGeo) {
		if (zonzGeo == null || liste_Reservations.contains(zonzGeo)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_Reservations.add(zonzGeo);
		}
	}
	public void enleverZone(Reservation g) {
		if (!liste_Reservations.contains(g) && g != null) {
			liste_Reservations.remove(g);
			g.afficheZone();
			System.out.println(" zone supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
}
