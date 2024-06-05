#include <stdio.h>
#include <stdlib.h>

void ligneTiret(int nbTirets);
void ligneI(int I);
void corps(int hauteur);

int main(){
    int hauteur;
    printf("Donner moi la hauteur\n");
    scanf("%d",&hauteur);
    corps(hauteur);
}

void ligneTiret(int hauteur){
    int i = 0;
    while(i < hauteur + 1){
        printf("-");
        i++;
    }
    printf("\n");
    
}

void ligneI(int nl){
    int i =0,compt =0;
    while (compt < nl)
    {
        i =0;
        printf("I");
        while (i < compt)
        {
            printf(" ");
            i++;
        }
        printf("\x5c");
        printf("\n");
        compt++;
    }
   
}

void corps(int hauteur){
    
    ligneI(hauteur);
    ligneTiret(hauteur);
}
