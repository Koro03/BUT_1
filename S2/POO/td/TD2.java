import java.util.*;

class Domino{
    private int g;
    private int d;
    public Domino(int gauche,int droite){
        g = gauche;
        d = droite;
    }
    void afficher(){
        System.out.println("["+ g + "," + d + "]");
    }
    int laGauche(){
        return g;
    }
    int laDroite(){
        return d;
    }
    void inverser(){
        int temp;
        temp = d;
        d = g;
        g = temp;
    } 
}

class Table{
    private Domino[] dominoTab;
    private static int nbDomino = 0;
    private int nb1 , nb2;
    private Scanner saisie = new Scanner(System.in);
    

    public Table(int n){
        dominoTab = new Domino[n];
        for (int i = 0; i < n; i++) {
            dominoTab[i] = new Domino(0, 0);
        }
    }
    public void initTable(){
        System.out.println("Commencer par quelle chiffre du domino");
        nb1 = saisie.nextInt();
        System.out.println("Le suivant");
        nb2 = saisie.nextInt();
        dominoTab[0] = new Domino(nb1, nb2);
        nbDomino++;
    }
    public void affTable(){
        for (int i = 0; i<nbDomino;i++){
            dominoTab[i].afficher();
        }
    }
    public int recherche(int g, int d ){
        int possible = 0;
        if (g == dominoTab[nbDomino-1].laDroite()) {
            possible = -1;
        }
        if (d == dominoTab[nbDomino-1].laGauche()){
            possible = 1;
        }
        return possible;
    }
    public void poserAdroite(int g, int d){

        if (dominoTab.length > nbDomino) {
            dominoTab[nbDomino] = new Domino(g,d);
            nbDomino++;
        }else{
            System.out.println("Table Pleine");
        }
    }
    public void poserAgauche(int g, int d){
        if (dominoTab.length > nbDomino) {
            for(int i =nbDomino; i > 0;i--){
                dominoTab[i] = dominoTab[i-1];
            }
            dominoTab[0] = new Domino(g, d);
            nbDomino++;
            
        }else{
            System.out.println("Table Pleine");
        }
    
    }


}
public class TD2{
    public static void main(String arg[]){
        Table table = new Table(28);
        table.initTable();
        table.affTable();
        String finjeu;
        Scanner saisie = new Scanner(System.in);
        int placement;
        do {
            Random random = new Random();
            int nbGauche = random.nextInt(1,6);
            int nbDroite = random.nextInt(1,6);
            Domino domino = new Domino(nbGauche, nbDroite);
            domino.afficher();
            System.out.println(table.recherche(nbGauche,nbDroite));
            if (table.recherche(nbGauche,nbDroite) == 1) {
                System.out.println("domino poseable sur la droite");
            }else if (table.recherche(nbGauche,nbDroite) == -1) {
                System.out.println("domino poseable sur la gauche");
            }else{
                System.out.println("Possible dans aucun cas");
            }
            System.out.println("1 : poser à droite ");
            System.out.println("2 : poser à gauche ");
            System.out.println("3 : inverser");
            placement = saisie.nextInt();
            if (placement == 1  && table.recherche(nbGauche,nbDroite) == 1) {
                table.poserAdroite(nbGauche, nbDroite);
            }else if (placement == 2 && table.recherche(nbGauche,nbDroite) == -1){
                table.poserAgauche(nbGauche, nbDroite);
            }else{
                domino.inverser();
                nbGauche = domino.laGauche();
                System.out.println(nbGauche);
                nbDroite = domino.laDroite();
                System.out.println(nbDroite);
                domino.afficher();
                if (table.recherche(nbGauche,nbDroite) == 1) {
                    System.out.println("domino poser sur la droite");
                    table.poserAdroite(nbGauche, nbDroite);

                }else if (table.recherche(nbGauche,nbDroite) == -1) {
                    System.out.println("domino poser sur la droite");
                    table.poserAgauche(nbGauche, nbDroite);
                }else{
                    System.out.println("Possible dans aucun cas");
                }
            }
            table.affTable();
            System.out.println("Voulez vous continuez (oui/non)");
            finjeu = saisie.next();
            
        } while (finjeu.compareTo("oui") == 0 );

    } 
    

}
