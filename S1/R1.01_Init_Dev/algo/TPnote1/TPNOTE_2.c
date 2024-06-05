#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const char FIN[3] = "*";
int main(){
    char nom[19];
    int km,nbPart5,nbPart12,nbPart20,i,pourcentage; 
    nbPart5 = 0;
    nbPart12 = 0;
    nbPart20 =0;
    printf("votre nom?\n");
    scanf("%s", nom);
    i=1;
    while(strcmp(nom,FIN)!=0){
        printf("Distance?\n");
        scanf("%d", &km);
        if(km == 5){
            nbPart5 = nbPart5 + 1;
        }else if(km == 12){
            nbPart12 = nbPart12 +1;
        }else if(km == 20){
            nbPart20 = nbPart20 +1; 
        }
        i++;
        printf("votre nom?\n");
        scanf("%s", nom);
    }
    pourcentage = nbPart12;
    printf("***Fin de la saisie des inscription***\n Randonnee de 5 km : %d\n Randonnee de 12 km : %d\n Randonnee de 20 km : %d\n",nbPart5,nbPart12,nbPart20);
    printf("%d",pourcentage);
    /*Mettre en float*/
    return EXIT_SUCCESS ;
}