#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define TAILLE 9


int main(){
    int tableau[TAILLE] = {0,1,2,3,4,5,6,7,8};
    int i,j;
    printf("  ");
    for (i = 1; i<TAILLE+1; i++)
    {
        printf("%3d",i);
        if(i == 6 || i== 3){
            printf(" ");
        }

    }
    printf("\n  +---------+---------+---------+\n");

    
    for(j =1; j<TAILLE+1; j++){
        printf("%d |%2d %2d %2d |%2d %2d %2d |%2d %2d %2d |\n",j,tableau[8],tableau[j],tableau[j],tableau[j],tableau[j],tableau[j],tableau[j],tableau[j],tableau[j]);
        if(j == 3 || j ==6){
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