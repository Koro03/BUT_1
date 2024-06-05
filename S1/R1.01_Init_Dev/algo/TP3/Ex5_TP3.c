#include <stdio.h>
#include <stdlib.h>
int main ()
{
    int i, n ,val,valMax;
    printf(" Combien de valeurs il faut \n") ;
    scanf("%d",&n) ;
    i=0;
    valMax = 0;
    while ( i!=n && n!=0 ) 
    {
        printf(" Valeur \n") ;
        scanf("%d",&val) ;
        if (valMax<val)
        {
            valMax = val;
        }
        i++;
    }
    printf("résultat : %d\n",valMax) ;
    return EXIT_SUCCESS ;
}
//Question 2 additionne la somme des entiers jusqu a n