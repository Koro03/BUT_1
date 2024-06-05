package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Aeroport {
	private String indent;
	private String nom;
	ArrayList<Vol> liste_Vols;
	public Aeroport(String indent, String nom ) {
		this.indent = indent;
		this.nom = nom;
		liste_Vols = new ArrayList<Vol>();
		
	}public String getIndent() {
		return indent;
	}public ArrayList<Vol> getListe_Vols() {
		return liste_Vols;
	}public String getNom() {
		return nom;
	}public void affiche() {
		System.out.println("immat:" + getIndent() + " nom:" + getNom());
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
