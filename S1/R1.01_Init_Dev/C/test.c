#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define TAILLE 9
typedef int t_grille[TAILLE];

void affichageGrille(t_grille grille);
void chargerGrille()

int main(){
    
    t_grille grille = {0,1,2,3,4,5,6,7,8};
    affichageGrille(grille);
}

void affichageGrille(t_grille grille){
    int i,val;
    for (i=0 ; i<TAILLE ; i++){
        for (j=0 ; j<TAILLE ; j++){
            printf("%3d",grille[i][j]);
        // acces a chaque case t[i][j] du tableau
    }

}

void chargerGrille(t_grille g){
    char nomFichier[30]= "Grille1.sud";
    FILE * f;
    printf("Nom du fichier ? ");
    ///scanf("%s", nomFichier);
    f = fopen(nomFichier, "rb");

    if (f==NULL){
        printf("\n ERREUR sur le fichier %s\n", nomFichier);
    } else {
        fread(g, sizeof(int), TAILLE*TAILLE, f);
    }
    fclose(f);
}