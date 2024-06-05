import java.util.InputMismatchException;
import java.util.Scanner;

public class qual_Dev{
    
    
    public static void main(String[] args) {
        int a, b, res; 
        Scanner clavier = new Scanner(System.in); 
        boolean test = false;
        try {
            a = clavier.nextInt(); 
            b = clavier.nextInt(); 
            res = a / b;
             
        } catch (Exception e) {
            System.out.println("division par 0");
            test = true;
        }finally{
            System.out.println ("Fin du programme") ;
        }
        if (test == false) {
            System.out.println("le résultat de " + a + " divisé par " + b + " est " + res);  
        }
        
    }
    public static void main(String[] args) { 
        try {
            int[] tab = null; 
            System.out.println(tab[2]);
        } catch (Exception e) {
            System.out.println("tableau non initialisé");
        } 
    } 
    
    public static void main(String[] args) {
        
        try {
            saisieC saisie = new saisieC();
            saisie.saisieCorrecte();  
        } catch (InputMismatchException e) {
            System.out.println("saisie incorrecte");
        }catch (IllegalArgumentException e){
            System.out.println("val inf ou egal à 10");
        }
    }
}

class saisieC {
    int test ;
    public saisieC(){
        
    }
    public void saisieCorrecte() throws IllegalArgumentException{
        Scanner s = new Scanner(System.in);  
        test = s.nextInt();
        if (test <= 10) {
            throw new IllegalArgumentException() ;
        } 
        
        
    }
    
}


class MonException extends Exception {
    public MonException(){
        System.out.println("le nombre de note est égal à 0");
    }
    public String toString(){
        return "nombre de note égal à 0";
    }
    
}

class Moyenne {

    static int somme = 0;
    static int entier,nbNotes;
    static int moyenne(String [] valeurs) throws MonException{
        for(int i = 0; i > valeurs.length; i++){
            try {
                entier = Integer.parseInt(valeurs[i]);
                somme = somme + entier;
                nbNotes++;

            } catch (NumberFormatException e) {
                System.out.println("valeurs non entière ");
            }
        }
        if (nbNotes == 0) {
            throw new MonException();
        }
        return somme/nbNotes;
    }
    
    
}

