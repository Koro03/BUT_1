package sae201pack;

import java.util.HashMap;

public class Question4 {
	public static void main(String[] args) {
		
	}
}

abstract class Personne2{
    private String numeroSS;

    public Personne2(String num){
        this.numeroSS = num;
    }public String getNumeroSS() {
        return numeroSS;
    }@Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Numero SS :" + this.numeroSS;
    }
    
}

/**
 * InnerQuestion4
 */
class Etudiant extends Personne2 {
    public Etudiant(String num){
        super(num);
    }@Override
    public String getNumeroSS() {
        // TODO Auto-generated method stub
        return super.getNumeroSS();
    }@Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
}

class Enseignant extends Personne2 {
    public Enseignant(String num){
        super(num);
    }@Override
    public String getNumeroSS() {
        // TODO Auto-generated method stub
        return super.getNumeroSS();
    }@Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    
    
}

/**
 * InnerQuestion4
 */
class Contrat {
    private String numero;
    public Contrat(String numero){
        this.numero = numero;
    }
    public String getNumero() {
        return numero;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "num contrat :" + this.numero;
    }
    
}

class Diplome {
    private String intitule;
    public Diplome(String intitule){
        this.intitule = intitule;
    }
    public String getIntitule() {
        return intitule;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "num intitule :" + this.numero;
    }
    
}

class Universite  {
    //inverser les clé et les valeurs car sa se traduit 
    //par la clé la table et la valeur la classe association
    private HashMap<Diplome,Etudiant> liste_etudiant;
    private HashMap<Contrat,Enseignant> liste_Enseignant;
    private String nom;
    public Universite(String nom){
        this.nom = nom;
        liste_Enseignant = new HashMap<>();
        liste_etudiant = new HashMap<>();
        
    }

    public void ajouterEtu(Diplome d,Etudiant e){
        if (e == null || liste_etudiant.containsValue(e)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_etudiant.put(d,e);
		}
    }
    public void listerEtu(){
		/* 
        Iterator<Etudiant> iterator = this.liste_etudiant.getValues().iterator();
        Iterator<Diplome> it = this.liste_etudiant.getKey().iterator();
		while (iterator.hasNext()) {
			Etudiant e = (Etudiant) iterator.next();
			System.out.println(e);
            Etudiant d = (Etudiant) it.next();
			System.out.println(d);
		}*/
        for (Map.Entry<Diplome, Etudiant> entry : liste_etudiant.entrySet()) {
            Diplome diplome = entry.getKey();
            Etudiant etudiant = entry.getValue();
            System.out.println(diplome);
            System.out.println(etudiant);
        }
    }
    public void supprimerEtu(Diplome d,Etudiant e){
        if (liste_etudiant.containsValue(e)&& liste_etudiant.containsKey(d) && liste_etudiant.size() > 1) {

			this.liste_etudiant.remove(d,e);
		} else {
			System.out.println("impossible de supprimer ou inexistant");
		}
    }
    public void supprimerEns(Contrat c, Enseignant e){
        if (liste_Enseignant.containsValue(e) && liste_Enseignant.containsKey(c) && liste_Enseignant.size() > 1) {

			this.liste_Enseignant.remove(c,e);
		} else {
			System.out.println("impossible de supprimer ou inexistant");
		}
    }public void listerEns(){
        for (Map.Entry<Contrat, Enseignant> entry : liste_Enseignant.entrySet()) {
            Contrat contrat = entry.getKey();
            Enseignant enseignant = entry.getValue();
            System.out.println(contrat);
            System.out.println(enseignant);
        }
    }public void ajouterEns(Contrat c, Enseignant e){
        if (e == null || liste_Enseignant.containsValue(e) || c== null || liste_Enseignant.containsKey(c)) {
			System.out.println("Acteurs n'existe pas ou est déjà présent");
		} else {
			this.liste_Enseignant.put(d,e);
		}
    }

    
}