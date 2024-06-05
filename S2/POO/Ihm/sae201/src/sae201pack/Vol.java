package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Vol {
	ArrayList<Per> liste_passager;
	private Aeroport aeroport;
	private Avion avion;
	public Vol(Aeroport aero,Avion avion) {
		this.aeroport = aero;
		this.avion = avion;
		liste_passager = new ArrayList<Per>();
	}public Aeroport getAeroport() {
		return aeroport;
	}public Avion getAvion() {
		return avion;
	}public ArrayList<Per> getListe_passager() {
		return liste_passager;
	}public void affiche() {
		System.out.println("aero:" + getAeroport() + " avion:" + getAvion());
		Iterator<Per> iterator = this.liste_passager.iterator();
		while (iterator.hasNext()) {
			Per per = (Per) iterator.next();
			per.affiche();
		}
	}public void ajouterVol(Per per) {
		if (per == null || liste_passager.contains(per)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_passager.add(per);
		}
	}
	public void enleverVol(Per g) {
		if (!liste_passager.contains(g) && g != null) {
			liste_passager.remove(g);
			g.affiche();
			System.out.println(" vol supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
}
