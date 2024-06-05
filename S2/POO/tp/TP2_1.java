import java.util.*;
class Voiture{
        private int id;
        private String marque;
        private Double vitesse;
        private Double puissance;/*Variable d'instance chaque instance à ce termes */
        private static int prochaine = 0;/*Variable de classe */
        
        /**Variable d'instance s'utilise que 
        sur un objet de la classe Voiture
        Variable ou méthode de classe s'utilise que 
        sur une la Classe Voiture*/

        /**Q2 */
        public Voiture(String mark, Double speed, Double power){
            id = prochaine;
            prochaine++;
            marque = mark;
            vitesse = speed;
            puissance = power; 
        }
        public Voiture(){
            id = prochaine;
            prochaine++;
            Scanner saisie = new Scanner(System.in);
            System.out.println("Quelle marque ?");
            marque = saisie.next();

            System.out.println("Quelle vitesse ?");
            vitesse = saisie.nextDouble();

            System.out.println("Quelle puissance ?");
            puissance = saisie.nextDouble();

        }
        /*Q3 */
        static int suivant(){
            return prochaine;
        }

        public String getMarque(){
            return marque;
        }

        public Double getVitesse(){
            return vitesse;
        }

        public Double getPuissance(){
            return puissance;
        }

        public void setMarque(){
            Scanner saisie = new Scanner(System.in);
            System.out.println("Quelle marque ?");
            marque = saisie.next();
        }

        public void setVitesse(){
            Scanner saisie = new Scanner(System.in);
            System.out.println("Quelle vitesse ?");
            vitesse = saisie.nextDouble();
        }

        public void setPuissance(){
            Scanner saisie = new Scanner(System.in);
            System.out.println("Quelle puissance ?");
            puissance = saisie.nextDouble();
        }
        public String toString(){
            return "Voiture numero " + id + " " + marque + " " + vitesse + " " + puissance;
                    
        }        
}
public class TP2_1{
    
    public static void main(String arg[]){
        Voiture voiture1 = new Voiture();
        Voiture voiture2 = new Voiture("bmw",12.4,69.0);
        System.out.println(voiture1);
        System.out.println(voiture2);
        voiture1.getPuissance();
        voiture2.getVitesse();
        voiture2.setMarque();
        System.out.println(voiture2);        

    }
}