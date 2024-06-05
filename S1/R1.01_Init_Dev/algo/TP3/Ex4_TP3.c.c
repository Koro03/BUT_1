#include <stdio.h>
#include <stdlib.h>
const int MARQUEUR=-1;
int main ()
{
    int i, suite,val;
    float moy;
    printf(" Premiere valeur de la suite (pour terminer prog ecrire -1)\n") ;
    scanf("%d",&val) ;
    i=0;
    while ( val!= MARQUEUR && val!=0 ) 
    {
        suite = suite + val;
        printf(" Valeur (pour terminer prog ecrire -1) \n") ;
        scanf("%d",&val) ;
        i++;
    }
    moy=suite/i;
    printf("résultat : %f\n",moy) ;
    return EXIT_SUCCESS ;
}
//Question 2 additionne la somme des entiers jusqu a n