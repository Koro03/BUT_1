// ComptePersonne

import java.util.*;
class Personne{
	private String nom, prenom, adresse;

	Personne(String nom, String prenom, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}
	
	public String toString() {
		return nom+" "+" "+prenom+" "+adresse;
	}
	
	public void afficher() {
		System.out.println("Nom : "+nom);
		System.out.println("Pr�nom : "+prenom);
		System.out.println("Adresse : "+adresse);
	}
	
	public String getNom() {
		return nom+" "+prenom;
	}
}

abstract class Compte{

	private String numero;
	public double solde;

	Compte(String i){
		this.numero = i;
		this.solde = 0;
	}
	public void deposer(double nbArgent){
        this.solde = this.solde + nbArgent;
        System.out.println("somme ajouter :" + nbArgent);
    }

    public void retirer(int nbArgent){
        if (this.solde - nbArgent >= 0){
            this.solde = this.solde - nbArgent;
        }else{
            System.out.println("a decouvert");
        }
    }
	public double getSolde(){
		return solde;
	}
	public String toString() {
		return "compte num�ro : " + numero  + "solde :" + solde ;
	}
    public void afficher(){
		System.out.println("Nom : "+numero);
		System.out.println("solde : "+solde);
	}
    
	
}

class CompteN extends Compte{
	Personne titulaire;
	public CompteN(String numero,Personne t){
		super(numero);
		titulaire = t;
		
	}
	public void afficher(){
		super.afficher();
		System.out.println("titulaire : " + this.titulaire);
	}
}

class CompteRemunere extends CompteN{
    double tauxRemune;
    public CompteRemunere(String numero,Personne personne, double taux){
        super(numero , personne);
        this.tauxRemune = taux;
    }
	public void versementINT(){
		this.deposer(super.solde * tauxRemune);
	}
	public String toString(){
		return	super.toString() + "taux : " + this.tauxRemune;
	}
	public void afficher(){
		super.afficher();
		System.out.println("taux : " + this.tauxRemune);
	}
	
}


class Entreprise{
	private String nom;
	private Personne comptable;
	public Entreprise(String n , Personne compta){
		nom = n;
		comptable = compta;
	}
	public String toString(){
		return "nom : "+ nom +"comptable : "+ comptable.toString();
	}
	public void afficher(){
		System.out.println("nom :" + nom);
		System.out.println("compta :" + comptable);
	}
}

class CompteDentreprise extends Compte{
	Entreprise entreprise;

	public CompteDentreprise(String i, Entreprise entre){
		super(i);
		entreprise = entre;
	}
	public void mettreSoldeAzero(){
		super.solde = 0;
	}
	public String toString(){
		return "Compte : " + super.toString() + " Comptable : "+entreprise.toString();
	}
	public void afficher(){
		System.out.println("Le compte: " + super.toString());
		System.out.println("entreprise: " + this.entreprise.toString());

	}

}
class Banque {
	private String nom;
	private ArrayList<Compte> tabCompte = new ArrayList<Compte>(100);
	private int longueur = tabCompte.size();
	public Banque(String n){
		nom = n;
	}
	public void ajouterCompte(Compte compte){
		tabCompte.add(compte);
		longueur++;
	}
	public void afficher(){
		int i =0;
		System.out.println("Nom de la banque : " + nom);
		while (longueur > i){
			tabCompte.get(i).afficher(); 
			i++;
		}
		
	}

}
public class TD3{
    public static void main(String arg[]){
        Personne personne = new Personne("fauchet","benjamin","sulniac");
        personne.afficher();
        CompteRemunere compteRemunere = new CompteRemunere("5",personne,50);
		compteRemunere.deposer(500);
		compteRemunere.afficher();	
		compteRemunere.versementINT();
		compteRemunere.afficher();


    }
}
