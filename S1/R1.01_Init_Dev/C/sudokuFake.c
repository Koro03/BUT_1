#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define TAILLE 9


typedef int t_grille[TAILLE][TAILLE];

/*****************************************************
*             déclaration des prototypes             *
******************************************************/

void affichageGrille();
void saisir(int *nb_A_Rentrer);
void chargerGrille(t_grille grille);
bool possible(t_grille grille,int numLignes,int numColonne,int valeur);
bool finPart(t_grille grille);

/*****************************************************
*             Programme principal                    *
******************************************************/

int main(){
    bool valPossible,fin = false;
    t_grille grille;
    int numLignes,numColonne,valeur;

    chargerGrille(grille);
    while (fin == false)
    {
        affichageGrille(grille);
        printf("Quelle indices ? (rentrer en premier la lignes puis la colonne sinon votre tableau sera faux)\n");
        saisir(&numLignes);
        numLignes = numLignes -1;
        saisir(&numColonne);
        numColonne = numColonne -1;
        if (grille[numLignes][numColonne] !=0){
            printf("La case n'est pas vide !!!!\n");
        }else{
            printf("Valeur insérer\n");
            saisir(&valeur);
            valPossible = possible(grille, numLignes, numColonne, valeur); 
            if (valPossible == true)
            {
                grille[numLignes][numColonne] = valeur;
            }
            fin = finPart(grille);
        }
    }
    if (fin == true)
    {
        
    }
     
    return 0;
    


}

/*****************************************************
*             Procédure et fonction                  *
******************************************************/

void affichageGrille(t_grille grille){
    int i,j,compteur1,compteur2=1;
    printf("  ");
    for (compteur1 = 1; compteur1<TAILLE+1; compteur1++)
    {
        printf("%3d",compteur1);
        if(compteur1 == 6 || compteur1== 3){
            printf(" ");
        }
    }
    printf("\n  +---------+---------+---------+\n");
    for(i =0; i<TAILLE; i++){
        printf("%d |",compteur2);
        for(j=0; j<TAILLE; j++){
            if(grille[i][j]==0){
                printf(" . ");
            }
            else{
                printf("%2d ",grille[i][j]);   
            } 
            if(j == 2 || j== 5){
                printf("|");
            }
        }
        printf("|\n");
        compteur2++;
        if(compteur2 == 4 || compteur2 ==7){
            printf("  +---------+---------+---------+\n");
        }
    }
    printf("  +---------+---------+---------+\n");
}

void chargerGrille(t_grille g){
    char nomFichier[30];
    FILE * f;
    printf("Nom du fichier ?\n");
    scanf("%s", nomFichier);
    f = fopen(nomFichier, "rb");

    if (f==NULL){
        printf("\n ERREUR sur le fichier %s\n", nomFichier);
    } else {
        fread(g, sizeof(int), TAILLE*TAILLE, f);
    }
    fclose(f);
}

//cherche un 0 pour savoir si il reste des valeur à placer

bool finPart(t_grille grille){
    int i=0,j=0;
    bool pasPresent = true;
    while (i < TAILLE && j < TAILLE && pasPresent == true) {
        if (grille[i][j] == 0) {
            pasPresent = false;
        }

        j++;

        if (j == TAILLE) {
            i++;
            j = 0;
        }
    }
    return pasPresent;

}

/******************************************************
*    La procédure prends en paramètre une adresse     *
*    on demande une chaine de carac si cette chaine   *
*    est convertible en entier  et que cette valeur   *
*    entrer dans nb_a_rentrer est dans les bornes     *
*    ça la convertit et renvoie true sur la conversion*
*    sinon erreur et redemande une valeur             *
*******************************************************/

void saisir(int *nb_A_Rentrer){
    char ch[30];
    bool conversion = false;
    do{
        printf("Quelle valeur à rentrer?\n");
        scanf("%s", ch);
        if (sscanf(ch, "%d", nb_A_Rentrer) !=0){ 
            if (*nb_A_Rentrer <= 9 && *nb_A_Rentrer >= 1)
            {
                printf("la conversion a réussi, x contient la %d\n",*nb_A_Rentrer);
                conversion = true;
            }

        }else {
            printf("la conversion en entier a échoué\n");
        }
    }while(conversion == false );
}

bool possible(t_grille grille,int numLignes,int numColonne,int valeur){
    int i,j,coinLigne,coinColonne;
    bool possible = true;
    for (j = 0; j < TAILLE; j++) {
        if (grille[numLignes][j] == valeur && j != numColonne) {
            printf("Valeur impossible à placer, elle est déjà présente sur la ligne.\n");
            possible = false;
        }
    }
    j = numColonne;
    i = 0;
    for(i = 0; i < TAILLE; i++)
    {
        if(grille[i][numColonne] == valeur && i != numLignes){
            printf("Valeur impossible à placé elle est déjà présente sur la colonne\n");
            possible = false;   
        }
    }
    coinLigne = (numLignes / 3) * 3;
    coinColonne = (numColonne / 3) * 3;
    // retrouver l'indice du coin gauche du 3*3 puis se déplacer dans ce 3*3 pour retrouver la bonne valeur
    // on teste si i ou j ne sortent pas du carré 3*3

    for (int i = coinLigne; i < coinLigne + 3; i++) {
        for (int j = coinColonne; j < coinColonne + 3; j++) {
            if (grille[i][j] == valeur && (i != numLignes || j != numColonne)) {
                printf("Valeur impossible à placer, elle est déjà présente dans le carré 3x3.\n");
                possible =  false;
            }
        }
    }

    return possible; 
}