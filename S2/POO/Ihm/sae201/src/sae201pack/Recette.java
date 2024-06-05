package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Recette {
	private String desc;
	ArrayList<Plat> liste_Plat;
	public Recette(String desc) {
		this.desc =desc;
		liste_Plat = new ArrayList<Plat>();
	}public String getDesc() {
		return desc;
	}public ArrayList<Plat> getListe_Plat() {
		return liste_Plat;
	}public void affiche() {
		System.out.println("id:" + getId()+" spe:"+getSpe());
		Iterator<Plat> iterator = this.liste_Plat.iterator();
		while (iterator.hasNext()) {
			Plat plat = (plat) iterator.next();
			plat.afficheZone();
		}
	}public void ajouterPlat(Plat plat) {
		if (plat == null || liste_Plat.contains(plat)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_Plat.add(plat);
		}
	}
	public void enleverZone(Plat g) {
		if (!liste_Plat.contains(g) && g != null) {
			liste_Plat.remove(g);
			g.afficheZone();
			System.out.println(" zone supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
}
