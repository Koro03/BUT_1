#include <stdio.h>
#include <stdlib.h>
#include <string.h> 
#include <stdbool.h>

typedef char chaine[20];


typedef struct{
    chaine nom;
    chaine prenom;
    int age;
}t_etudiant;


void afficherEtudiant(t_etudiant* etudiant);
void inscriptionEtuidant(t_etudiant *etudiant);
int compareEtudiant(t_etudiant etudiant,t_etudiant etudiant2);

int main(){
    t_etudiant etudiant, etudiant2 ;
    inscriptionEtuidant(&etudiant);
    inscriptionEtuidant(&etudiant2);

    afficherEtudiant(&etudiant2);
    afficherEtudiant(&etudiant);

    int etuidantComparer = compareEtudiant(etudiant,etudiant2);
    printf("%d\n",etuidantComparer);
    return 0;
}

void afficherEtudiant(t_etudiant *etudiant){
    printf("Etudiant : %s %s , %d ans\n", etudiant->nom,etudiant->prenom,etudiant->age) ;
}

void inscriptionEtuidant(t_etudiant *etudiant){
   printf("Saisie des informations de l'étudiant :\n");

    printf("Nom : ");
    scanf("%s", etudiant->nom);

    printf("Prénom : ");
    scanf("%s", etudiant->prenom);

    printf("Âge : ");
    scanf("%d", &etudiant->age);
    
}

int compareEtudiant(t_etudiant etudiant,t_etudiant etudiant2){
    int compare;
    if (etudiant.age > etudiant2.age)
    {
        printf("%s %s %d est plus vieux\n",etudiant.nom,etudiant.prenom,etudiant.age);
        compare = -1;
    }else if (etudiant.age < etudiant2.age)
    {
        printf("%s %s %d est plus vieux\n",etudiant2.nom,etudiant2.prenom,etudiant2.age);
        compare = 1;
    }else if(etudiant.age == etudiant2.age){
        printf("Les etudiants ont le meme age\n");
        compare = 0;
    }else{
        printf("donnee invalide\n");
        compare = -5;
    }
    return compare;
    
    
}