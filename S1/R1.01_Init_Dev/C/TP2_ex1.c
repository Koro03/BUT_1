#include <stdio.h>
#include <stdlib.h>
int main (){
    int i, n , somme;
    printf(" entrez un entier naturel : \n") ;
    scanf("%d",&n) ;
    i=2;
    somme=1 ;
    while ( i<= n ) {
        somme=somme*i ;
        i=i+1;
    }
    if(n==0){
        somme = 1;
    }
    printf("résultat : %d\n",somme) ;
    return EXIT_SUCCESS ;
}