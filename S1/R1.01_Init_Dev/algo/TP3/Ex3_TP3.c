#include <stdio.h>
#include <stdlib.h>
int main ()
{
    int i, n , suite,val;
    float moy;
    printf(" Combien de valeurs il faut \n") ;
    scanf("%d",&n) ;
    i=0;
    
    while ( i!=n && n!=0 ) 
    {
        printf(" Valeur \n") ;
        scanf("%d",&val) ;
        suite = suite + val;
        i++;
    }
    moy=suite/n;
    printf("résultat : %f\n",moy) ;
    return EXIT_SUCCESS ;
}
//Question 2 additionne la somme des entiers jusqu a n