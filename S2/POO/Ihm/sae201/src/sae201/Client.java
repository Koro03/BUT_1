package sae201;

import java.util.ArrayList;
import java.util.Iterator;

class Client {
	private String nom;
	private ArrayList<Reservation>liste_reservation;
	public Client(String nom) {
		// TODO Auto-generated constructor stub
		this.nom = nom;
		liste_reservation = new ArrayList<Reservation>();
	}public String getNom() {
		return nom;
	}public void affiche() {
		System.out.println("Nom du cli:"+this.getNom());
		Iterator<Reservation> iterator = this.liste_reservation.iterator();
		while (iterator.hasNext()) {
			Reservation resa = (Reservation) iterator.next();
			resa.affiche();
		}
	}
}
