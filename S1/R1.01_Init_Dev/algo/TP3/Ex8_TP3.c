#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main ()
{
   int nb,compt;
   compt=1;
   printf("nb");
   scanf("%d",&nb);
   while (compt>0 && compt>10)
   {
        if(nb%compt==0 && (compt!=1 && compt!=nb)){
            printf("le nombre %d est un diviseur de %d",compt,nb);
        }else{
            printf("Le nombre %d est un nombre premier",nb);
        }
   }
}
//Question 2 additionne la somme des entiers jusqu a n