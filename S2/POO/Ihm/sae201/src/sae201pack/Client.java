package sae201pack;

class Client {
	private Zone_geo zone_geo;
	private int num;
	private String nom;
	private String adresse;
	public Client(String nom,String adresse,int num,Zone_geo zone_geo) {
		this.nom = nom;
		this.adresse = adresse;
		this.num = num;
		this.zone_geo = zone_geo;
	}
	public String getAdresse() {
		return adresse;
	}public String getNom() {
		return nom;
	}public int getNum() {
		return num;
	}public Zone_geo getZone_geo() {
		return zone_geo;
	}
	public void affiche() {
		System.out.println("Adresse :" + getAdresse() + " Nom :"+getNom()+" Num :"+getNum());
	}
}
