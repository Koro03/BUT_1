public class Tp5{
    public static void main(String args[]){
        
    }
}

class Cours{
    public String intitule;

    public Cours(String intitule){
        this.intitule = intitule;
    }

    public String toString(){
        return this.intitule;
    }
    public boolean equals(String intitule){
        boolean renvoie = false
        if (this.intitule == intitule){
            renvoie = true;
        }
        return renvoie;
    }
}

class Etudiant implements Comparable<Etudiant>{
    int matricule;
    String nom;
    String prenom;
    Map<Cours, Integer> noteEtu;//hashmap autorise les doublons
    public Etudiant(int matricule,String nom,String prenom){
        this.noteEtu = new HashMap<Cours, Integer>();
        this.nom = nom;
        this.matricule = matricule;
        this.prenom = prenom;

    }
    public int CompareTo(Etudiant etudiant){

    }
    public void ajoutNote(Cours cours,Integer note){
        this.noteEtu.put(cours,note);
    } 
    public void modifNote(Cours cours, double note){
        if (noteEtu.containsKey(cours)) {
            noteEtu.put(cours, note);
        }
    }
      
    public void afficheNote(){
        Set<Cours> clef;//set = un ensemble
        clef = noteEtu.keySet();//keySet ramene les clefs
        Iterator <Cours> it = clef.iterator();
        Cours c;
        Integer n;
        while(it.hasNext()){
            c = it.next();
            n = noteEtu.get(c);
            System.out.println(c+" "+n);
        }
        
    }
    public void afficheNoteEntry(){
        Set<Map.Entry<Cours,Integer>> setEnt = noteEtu.entrySet();
        Iterator<Map.Entry<Cours,Integer>> it = setEnt.iterator();
        Map.Entry<Cours,Integer> ent;
        Cours cours;
        while(it.hasNext()){
            ent.it.next();
            cours = ent.getKey();
            System.out.println("nom cours");
        } 
        
    }
    public void supNote(Cours cours){
        if noteEtu.isEmpty() == false{
            this.noteEtu.remove(cours);
        }

    }
    public double moyEtu(){
        Set<Cours> clef;
        clef = noteEtu.keySet();//keySet ramene les clefs
        Iterator <Cours> it = clef.iterator();
        Cours c;
        Integer n;
        double somme = 0;
        while(it.hasNext()){
            c = it.next();
            n = noteEtu.get(c);
            somme += n;
        }
        return somme / noteEtu.size();

    }
    public double meillNote(){
        double max = 0;
        Set<Cours> clef;
        clef = noteEtu.keySet();//keySet ramene les clefs
        Iterator <Cours> it = clef.iterator();
        Cours c;
        Integer n;
        while(it.hasNext()){
            c = it.next();
            if(max < noteEtu.get(c)){
                max = noteEtu.get(c);
            }
        }
        return max;

    }
    public double pireNote(){
        double min = noteEtu.get(0);
        Set<Cours> clef;
        clef = noteEtu.keySet();//keySet ramene les clefs
        Iterator <Cours> it = clef.iterator();
        Cours c;
        Integer n;
        while(it.hasNext()){
            c = it.next();
            if(min > noteEtu.get(c)){
                min = noteEtu.get(c);
            }
        }
        return min;
    }
    public int getMatricule(){
        return this.matricule;
    }
    public double noteMat(Cours mat){
        return noteEtu.values(mat);
    }
    public String toString() {
        return "Etudiant{" +
                "matricule=" + matricule +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}

class Groupe{
    String nom;
    HashSet<Integer,Etudiant> groupeEtu;//hash set aucun doublon
    public Groupe(String nom){
        this.nom = nom;
        this.etudiants = new HashSet<Integer, Etudiant>();
    }
    public void ajoutEtu(Etudiant etudiant){
        etudiants.add(etudiant);
    }
    public void suppEtu(int matricule){
        if groupeEtu.isEmpty() == false{
            groupeEtu.remove(matricule);
        }
    }
    public void afficheEtu(){
        Set<Integer> matr;

    }
    public void nbEtu(){
        return etudiants.size();
    }
    public void moyEtu(){
        if (etudiants.isEmpty()) {
            return 0.0;
        }
        double somme = 0.0;
        for (Etudiant etudiant : etudiants) {
            somme += etudiant.moyenneGenerale();
        }
        return somme / etudiants.size();
    }
    public void premsDer(){
        if (etudiants.isEmpty() == false) {
            Etudiant premier = etudiants.iterator().next();
            Etudiant dernier = premier;
            for (Etudiant etudiant : etudiants) {
                dernier = etudiant;
            }
            System.out.println("Premier étudiant : " + premier);
            System.out.println("Dernier étudiant : " + dernier);
        } else {
            System.out.println("Aucun étudiant dans le groupe.");
        }
    }
}