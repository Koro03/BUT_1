package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Per {
	private String numPassePort;
	private String nom;
	private String prenom;
	private ArrayList<Vol> liste_Vol;
	public Per(String numPassePort,String nom,String prenom ) {
		this.numPassePort = numPassePort;
		this.nom = nom;
		this.prenom = prenom;
		this.liste_Vol = new ArrayList<Vol>();

	}public ArrayList<Vol> getListe_Vol() {
		return liste_Vol;
	}public String getNom() {
		return nom;
	}public String getNumPassePort() {
		return numPassePort;
	}public String getPrenom() {
		return prenom;
	}public void affiche() {
		System.out.println("nom:" + getNom() + " prenom:" + getPrenom()+" num pass:"+ getNumPassePort());
		Iterator<Vol> iterator = this.liste_Vol.iterator();
		while (iterator.hasNext()) {
			Vol vol = (Vol) iterator.next();
			vol.affiche();
		}
	}public void ajouterVol(Vol vol) {
		if (vol == null || liste_Vol.contains(vol)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_Vol.add(vol);
		}
	}
	public void enleverVol(Vol g) {
		if (!liste_Vol.contains(g) && g != null) {
			liste_Vol.remove(g);
			g.affiche();
			System.out.println(" vol supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
}
