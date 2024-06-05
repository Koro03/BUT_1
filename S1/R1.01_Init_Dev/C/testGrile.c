#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define TAILLE 9


int main(){
    int tableau[TAILLE][TAILLE] = {
        {0,1,2,3,4,5,6,7,8},
        {0,1,2,3,4,5,6,7,8},
        {0,1,2,3,4,5,6,7,8},
        {0,1,2,3,4,5,6,7,8},
        {0,1,2,3,4,5,6,45,8},
        {0,1,2,3,4,5,6,7,8},
        {0,1,2,3,4,5,6,7,8},
        {0,1,2,3,4,5,6,7,8},
        {0,1,2,3,4,0,6,7,8},
    };
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
            if(tableau[i][j]==0){
                printf(" . ");
            }
            else{
                printf("%2d ",tableau[i][j]);   
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

    //faire la première boucle séparement de la deuxieme 
    //ce déplacer dans le tableau puis faire un compteur séparé pour 
    //les chiffres à gauche et quand on se déplace dans le tableau
    //afficher tab de i et j et tester si tab[i][j]==0 affiche "."
    
    
    return 0;
}