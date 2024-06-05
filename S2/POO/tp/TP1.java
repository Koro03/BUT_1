import java.util.*;

public class TP1{

    public static void main(String args[]){
        Scanner saisie;
        String s1,s2;
        System.out.println("Chaine 1");
        saisie = new Scanner(System.in);
        s1 = saisie.next();
        System.out.println("Chaine 2");
        saisie = new Scanner(System.in);
        s2 = saisie.next();
        if (s1.charAt(0) == s2.charAt(0)){
            System.out.println("ces différentes chaine commencent par les même carac");
        }else{
            System.out.println("Pas les même");
        }

        /************question 6 ********** */
        System.out.println("**************Q6************");
        System.out.println("Chaine 1");
        saisie = new Scanner(System.in);
        s1 = saisie.next();
        System.out.println("Chaine 2");
        saisie = new Scanner(System.in);
        s2 = saisie.next();
        System.out.println("result s1 == s2" + s1==s2);
        System.out.println("result s1 equals s2" + s1.equals(s2));
        System.out.println("result s1 compare s2" + s1.compareTo(s2));
        System.out.println("result s1 compareToIgnoreCase s2" + s1.compareToIgnoreCase(s2));

        /************Q7 ************/
        System.out.println("**************Q7************");
        System.out.println("Chaine 1");
        saisie = new Scanner(System.in);
        s1 = saisie.next();
        System.out.println("Chaine 2");
        saisie = new Scanner(System.in);
        s2 = saisie.next();
        System.out.println("result s1 startWith s2 " + s1.startsWith(s2));
        System.out.println("result s1 endWith s2 " + s1.endsWith(s2));
        System.out.println("result s1 contains() s2 " + s1.contains(s2));

        /*******Q8********/
        System.out.println("*******Q8********");
        saisie = new Scanner(System.in);
        System.out.println("chaine 1");
        s1 = saisie.next();
        saisie = new Scanner(System.in);
        System.out.println("chaine 2");
        s2 = saisie.next();
        if (s1.contains(s2)) {
            int index = s1.indexOf(s2);
            String s1Av = s1.substring(0,index);
            String s1Ap = s1.substring(index,s2.length());
            s1 = s1Av + s1Ap;
            System.out.println("s1 sans s2 " + s1);
        }else{
            System.out.println("s2 pas dans s1 " + s1);
        }

    }


}