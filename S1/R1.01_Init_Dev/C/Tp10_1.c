#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

typedef char chaine20[20] ;

typedef struct 
{
    chaine20 nom ;
    chaine20 prenom;
    int age;
}t_etudiant;


void caracEtu( t_etudiant *etu );
void saisieEtu(t_etudiant *etu);
int compareEtu(t_etudiant *etu1, t_etudiant *etu2);

int main(){
    t_etudiant etu,etu1;
    saisieEtu(&etu);
    caracEtu(&etu);
    saisieEtu(&etu1);
    caracEtu(&etu1);
    int plusAge = compareEtu(&etu,&etu1);
    if (plusAge == -1)
    {
        printf("etu2 plus age\n");
    }else if (plusAge == 0)
    {
        printf("les etudiant ont le même age\n");
    }
    else
    {
        printf("etu1 plus age\n");
    }
    
    
    return 0;
}

void caracEtu(t_etudiant *etu){
    printf("Etudiant: %s %s %d\n",etu->nom, etu->prenom,etu->age);

}

void saisieEtu(t_etudiant *etu){
    printf("votre nom ?\n");
    scanf("%s",etu->nom);
    printf("votre prenom ?\n");
    scanf("%s",etu->prenom);
    printf("votre age ?\n");
    scanf("%d",&etu->age);

}

int compareEtu(t_etudiant *etu1, t_etudiant *etu2){
    int plusAge;
    if (etu1->age < etu2->age )
    {
        plusAge = -1;
    }else if (etu1->age == etu2->age)
    {
        plusAge = 0;
    }
    else
    {
        plusAge = 1;
    }
    return plusAge;
}