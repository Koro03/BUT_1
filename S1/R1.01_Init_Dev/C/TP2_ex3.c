#include <stdio.h>
#include <stdlib.h>
int main (){
    int i, n ,nb, somme;
    float moyenne;
    printf(" Cb chiffre : \n") ;
    scanf("%d",&n) ;
    i=0;
    somme=0 ;
    while ( i< n ) {
        printf(" Quelle chiffre : \n") ;
        scanf("%d",&nb) ;
        somme=somme+nb ;
        i=i+1;
    }
    moyenne = somme / n;
    printf("résultat : %f\n",moyenne) ;
    return EXIT_SUCCESS ;
}