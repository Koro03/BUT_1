#include <stdio.h>
#include <stdlib.h>

void ligneTiret(int nbTirets);
void ligneI(int I);
void corps(int longueur, int largeur);

int main(){
    int longueurRect, largeurRect;
    printf("Donner moi la longueur ");
    scanf("%d",&longueurRect);
    printf("la largeur de votre rectangle");
    scanf("%d",&largeurRect);

    corps(longueurRect,largeurRect);
}

void ligneTiret(int nbTirets){
    int i = 0;
    while(i < nbTirets){
        printf("-");
        i++;
    }
    printf("\n");
}

void ligneI(int I){
    int i =0;
    printf("I");
    while (i < I-2)
     {
        printf(" ");
        i++;
    }
    printf("I");
}

void corps(int longueur, int largeur){
    int i =0;
    ligneTiret(largeur);
    while (i < longueur)
    {
        ligneI(largeur);
        printf("\n");
        i++;
    }
    ligneTiret(largeur);
}