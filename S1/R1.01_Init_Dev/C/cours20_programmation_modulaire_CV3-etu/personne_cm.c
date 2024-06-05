# include <stdio.h>
# include <stdlib.h>
# include <string.h>

//constantes symboliques
# define LONG 30

// types et structures
typedef struct{
	char c_nom [LONG];
} t_personne;

// constantes
const t_personne PERS_VIDE ={"sans_nom"};

// définition des prototypes
void init(t_personne *adrPers);
void affiche(t_personne pers);
t_personne saisir_personne();

// programme principal
int main(){
    t_personne personne;
    int choix;
    choix = -1;
    system("clear");
    while (choix != 0){
        printf("------------------------------\n");
        printf("0 : quitter\n");
        printf("1 : initialiser la personne\n");
        printf("2 : saisir la personnel\n");
        printf("3 : afficher la personnel\n");
        printf("votre choix : ");
        scanf("%d", &choix);
        system("clear");
        switch(choix){
            case 0 : break;
            case 1: init(&personne);
                    break;
            case 2: personne = saisir_personne();
                    break;      
            case 3: affiche(personne);
                    break;        
            default : printf("erreur de saisie");
        }
    }
    return 0;
}
// definition des fonctions
void init(t_personne *adrPers){
    *adrPers = PERS_VIDE;
}
t_personne saisir_personne(){
    t_personne pers;
    printf("le nom :");
    scanf("%s",pers.c_nom);
    return pers;
}
void affiche(t_personne pers){
    printf("bonjour %s\n",pers.c_nom);
}
