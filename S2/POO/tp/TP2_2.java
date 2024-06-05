import java.util.Scanner;

class Produit{
    private String reference;
    private int date;

    public Produit(int dateProd){
        Scanner saisie = new Scanner(System.in);
        System.out.println("ref prod");
        reference = saisie.next();
        date = dateProd;
    }
    public void affiche(){
        System.out.println(reference);
        System.out.println(date);
    }

}

class Pile{
    private int indicePile;
    private Produit[] pileProduits;
    public Pile(int maxProd){
        pileProduits = new Produit[maxProd];
        indicePile = -1;
    }

    public boolean pilePleine(){
        boolean pleine = false;
        int longueur = pileProduits.length;
        if (indicePile == longueur) {
            pleine = true;
        }
        return pleine;
    }
    
    public boolean pileVide(){
        boolean vide = false;
        int longueur = pileProduits.length;
        if (indicePile == -1) {
            vide = true;
        }
        return vide;
    }
    public void empiler(Produit p){
        if (pilePleine() != true) {
            indicePile++;
            pileProduits[indicePile] = p; 
            
        }
    }
    public void depiler(){
        if (pileVide() != true) {
            pileProduits[indicePile] = null;
            indicePile--;
        }
    }
    public Produit sommet(){
        Produit sommet;
        if (!pileVide()) {
            sommet = pileProduits[indicePile];
        }else{
            System.out.println("pile vide");
            sommet = null ;
        }
        return sommet;
    }
    public void afficheStock(){
        if (indicePile != -1) {
            for (int i = 0; i <= indicePile; i++){
                pileProduits[i].affiche();
            } 
        }else{
            System.out.println("Pile Vide");
        }
    }
}

class Stock{
    private Pile pile;
    private int date;

    public Stock(int taille){
        pile = new Pile(taille);
        date = 1;
    }
    public void entrer(Produit produit){
        pile.empiler(produit);
        date++;
    }
    public void sortir (int dateJ){
        Produit sommet;  
        if (pile.pileVide() != true) {
            if ( dateJ - date > 5){
                while (pile.pileVide() != true) {
                    sommet = pile.sommet();
                    sommet.affiche();
                    pile.depiler();
                }    
            }else{
                sommet = pile.sommet();
                sommet.affiche();
                pile.depiler();
            }
        }
    }
    public void afficheMenu() {
        Scanner scanner = new Scanner(System.in);
        String choix;
        int dateJour = date;
        do {
            System.out.println("Menu :");
            System.out.println("e : Entrée d’un produit dans le stock");
            System.out.println("s : Sortie d’un produit du stock");
            System.out.println("i : Incrémenter la date du jour");
            System.out.println("q : Quitter");
            choix = scanner.next();
            switch (choix) {
                case "e":
                    Produit p = new Produit(dateJour);
                    this.entrer(p);
                    System.out.println("produit entrer");
                    pile.afficheStock();
                    dateJour++;
                    break;
                case "s": 
                    System.out.println("stock initial ");
                    pile.afficheStock();
                    System.out.println("produit sortie ");
                    this.sortir(dateJour); 
                    System.out.println("stock final ");
                    pile.afficheStock();           
                    break;
                case "i":
                    dateJour++;
                    break;
                case "q":
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (!choix.equals("q"));
    }

}



public class TP2_2{

    public static void main(String arg[]){
        Stock stock = new Stock(5);
        stock.afficheMenu();
        
        
        
    }

}