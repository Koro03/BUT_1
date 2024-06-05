package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Zone_geo {
	private String nom;
	private Commercial commercial;
	private ArrayList<Client> liste_client;
	
	public Zone_geo(String nom,Commercial  com) {
		liste_client = new ArrayList<Client>();
		this.commercial = com;
		this.nom = nom;
		
	}public ArrayList<Client> getListe_client() {
		return liste_client;
	}public Commercial getCommercial() {
		return commercial;
	}public String getNom() {
		return nom;
	}
	public void ajoutClient(Client client) {
		if (client != null) {
			this.liste_client.add(client);
		} else {
			System.out.println("Client inexistant");
		}
		
	}public void suppressionClient(Client client) {
		if (client != null && !liste_client.contains(client)) {
			this.liste_client.remove(client);
		} else {
			System.out.println("Client inexistant");
		}
		
	}public void afficheZone() {
		System.out.println(" nom zone :" +getNom()+"Commercial" );
		Iterator<Client> iterator = this.liste_client.iterator();
		while (iterator.hasNext()) {
			Client client = (Client) iterator.next();
			client.affiche();
		}
	}
}
