#include <stdio.h>
#include <stdlib.h>
#include <string.h>
const float TAUX = 0.80;
const char fin[] = "*";
int main (){
    char nom[19];
    int i, salaireBrut ;
    float salaireMoy,somme;
    
    i=0;
    somme=0 ;
    printf("Ton nom\n");
    scanf("%s", nom);

    while ( strcmp(nom,fin)!=0) {
        printf(" Quelle salaire : \n") ;
        scanf("%d",&salaireBrut) ;
        somme=somme+(salaireBrut*TAUX) ;
        printf("Ton nom\n");
        scanf("%s", nom);
        i=i+1;
    }
    salaireMoy = somme / i;
    printf("résultat : %f\n",salaireMoy) ;
    return EXIT_SUCCESS ;
}