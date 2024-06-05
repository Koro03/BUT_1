#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

void saisir(int *nb_A_Rentrer);

int main(){
    int numLignes,numColonne,valeur;
    saisir(&numLignes);
    saisir(&numColonne);
    saisir(&valeur);
    numLignes =numLignes -1;
    printf("ligne : %d colonne : %d valeur : %d",numLignes,numColonne,valeur);
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
        printf("Quelle valeur ?\n");
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