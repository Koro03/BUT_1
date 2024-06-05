package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Avion {
	private String immat;
	ArrayList<Vol>liste_Vols;
	public Avion(String immat ) {
		this.immat = immat;
		liste_Vols = new ArrayList<Vol>();
	}public String getImmat() {
		return immat;
	}public ArrayList<Vol> getListe_Vols() {
		return liste_Vols;
	}public void affiche() {
		System.out.println("immat:" + getImmat());
		Iterator<Vol> iterator = this.liste_Vols.iterator();
		while (iterator.hasNext()) {
			Vol vol = (Vol) iterator.next();
			vol.affiche();
		}
	}public void ajouterVol(Vol vol) {
		if (vol == null || liste_Vols.contains(vol)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_Vols.add(vol);
		}
	}
	public void enleverVol(Vol g) {
		if (!liste_Vols.contains(g) && g != null) {
			liste_Vols.remove(g);
			g.affiche();
			System.out.println(" vol supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
}
