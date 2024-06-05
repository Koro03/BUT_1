package sae201pack;

public class Main_sujet_part1 {
	public static void main(String[] args) {
		Commercial commercial = new Commercial("15", "ventes");
		
		Zone_geo lorient = new Zone_geo("lorient", commercial);
		Client client = new Client("fab", "17 rue", 1, lorient);
		lorient.ajoutClient(client);
		commercial.ajouterZone(lorient);
		
		client.affiche();
		lorient.afficheZone();
		commercial.affiche();
	}
}
