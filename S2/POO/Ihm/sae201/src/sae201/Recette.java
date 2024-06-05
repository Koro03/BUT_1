package sae201;

class Recette {
	private String description;
	public Recette(String d) {
		// TODO Auto-generated constructor stub
		this.description = d;
	}public String getDescription() {
		return description;
	}public void affiche() {
		System.out.println(""+getDescription());
	}
}
