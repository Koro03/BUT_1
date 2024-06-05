import java.util.*;


abstract class Employe{
    String nom;
    int age;
    int nb_a;
    int nb;
    private static int prochain = 0;

    public Employe(String nom ,int age, int nb_a){
        this.nom = nom ;
        this.age = age;
        this.nb_a = nb_a;
        this.nb = prochain;
        prochain++;
    }
    public abstract double salaire();

    public String toString(){
        return "Numero " + this.nb +" nom: "+ this.nom +" age " + this.age + " annee xp " + this.nb_a;
    }
    public void afficher(){
        System.out.println("Numero " + this.nb + " age " + this.age + " annee xp " + this.nb_a);
    }

}

class Ouvrier extends Employe{
    private static final int nb_h_O = 35;
    private static final int coeff_h_O = 4;
    private static final int coef_A_O = 10;
    
    public Ouvrier(String nom ,int age, int nb_a){
        super(nom,age,nb_a);

    }
    public double salaire(){
        return 4 * this.nb_h_O * (10 + (super.nb_a/2));
    }
    public String toString(){
        return super.toString() + " salaire ouv " + this.salaire() + " nb heure " + this.nb_h_O;

    }
    public void afficher(){
        System.out.println(super.toString() + " salaire ouv " + this.salaire() + " nb heure " + this.nb_h_O );
    }
}
class Gerant extends Employe{
    private static final int nb_h_G = 20;
    private static final int coeff_h_G = 5;
    private static final int coef_A_G = 20;
    
    public Gerant(String nom ,int age, int nb_a){
        super(nom,age,nb_a);
    }
    public double salaire(){
        return 5 * this.nb_h_G * (10 + (super.nb_a/2));
    }
    public String toString(){
        return super.toString() + " salaire gerant " + this.salaire() + " nb heure " + this.nb_h_G;

    }
    public void afficher(){
        System.out.println(super.toString() + " salaire gerant " + this.salaire() + " nb heure " + this.nb_h_G );
    }
}

class ListeEmploye{
    ArrayList<Employe> listeEmploye;

    public ListeEmploye(int taille){
        this.listeEmploye = new ArrayList<Employe>(taille);
    }

    public ArrayList trierEmp(){
        
        for (int i = 0 ;i < listeEmploye.size(); i++ ){
            int index = i;
            for(int j = i+1 ; j < listeEmploye.size() ; j++){
                if( listeEmploye.get(j).salaire() > listeEmploye.get(i).salaire()){
                    index = j;
                    Employe min = listeEmploye.get(index);
                    listeEmploye.set(index,listeEmploye.get(i));
                    listeEmploye.set(i,min);
                }  
            }
                
        }
        return listeEmploye;
    }

    public void ajouterEmp(Employe emp1){
        this.listeEmploye.add(emp1);
    }

    public ArrayList selectionner(int min,int max){
        ArrayList<Employe> listeEmp = new ArrayList<Employe>(20);
        return listeEmp;
    } 
    public String toString(int i){
        return listeEmploye.get(i).toString() ;
    }
    public void afficher(){
        for (int i=0; i < listeEmploye.size(); i++){
            System.out.println(listeEmploye.get(i).toString());
        }

    }
}
public class Tp3_2{
    public static void main(String[] args){
        Ouvrier o1 = new Ouvrier("momo",18, 2);
        o1.afficher();
        Gerant g1 = new Gerant("walid", 45, 25);
        g1.afficher();

        ListeEmploye liste_emp = new ListeEmploye(20);
        liste_emp.ajouterEmp(g1);
        liste_emp.ajouterEmp(o1);
        System.out.println("Avant");
        liste_emp.afficher();
        liste_emp.trierEmp();
        System.out.println("apres");
        liste_emp.afficher();



    }
}

