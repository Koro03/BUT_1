package sae201;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

class Reservation {
	private Date date;
	private ArrayList<Restaurant>liste_resto;
	private ArrayList<Client>liste_client;
	
	public Reservation(Date d,Restaurant restaurant,Client c ) {
		// TODO Auto-generated constructor stub
		this.date = d;
		this.liste_client = new ArrayList<Client>();
		this.liste_resto = new ArrayList<Restaurant>();
		liste_client.add(c);
		liste_resto.add(restaurant);
	}
	public Date getDate() {
		return date;
	}
	public void affiche() {
		System.out.println(""+getDate());
		Iterator<Restaurant> iterator = this.liste_resto.iterator();
		while (iterator.hasNext()) {
			Restaurant Restaurant = (Restaurant) iterator.next();
			Restaurant.affiche();
		}
		Iterator<Client> it = this.liste_client.iterator();
		while (it.hasNext()) {
			Client client = (Client) it.next();
			client.affiche();
		}
	}
}
