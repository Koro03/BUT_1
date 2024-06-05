package sae201pack;

import java.util.ArrayList;
import java.util.Iterator;

class Commercial {
	private String id;
	private String spe;
	private ArrayList<Zone_geo> liste_zone;
	public Commercial(String id,String spe) {
		this.id = id;
		this.spe = spe;
		liste_zone = new ArrayList<Zone_geo>();
	}public String getId() {
		return id;
	}public String getSpe() {
		return spe;
	}public void affiche() {
		System.out.println("id:" + getId()+" spe:"+getSpe());
		Iterator<Zone_geo> iterator = this.liste_zone.iterator();
		while (iterator.hasNext()) {
			Zone_geo zone_geo = (Zone_geo) iterator.next();
			zone_geo.afficheZone();
		}
	}public void ajouterZone(Zone_geo zonzGeo) {
		if (zonzGeo == null || liste_zone.contains(zonzGeo)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_zone.add(zonzGeo);
		}
	}
	public void enleverZone(Zone_geo g) {
		if (!liste_zone.contains(g) && g != null) {
			liste_zone.remove(g);
			g.afficheZone();
			System.out.println(" zone supprimer");
		} else {
			System.out.println("Acteur pas dans la liste");
		}
	}
}
