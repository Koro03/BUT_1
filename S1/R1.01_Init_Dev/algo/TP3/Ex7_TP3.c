#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main ()
{
   int action;
   do 
   {

    printf("quel action\n");
    scanf("%d",&action);
    if (action==1)
    {
        printf("action 1\n");/* code */
    }else if (action==2)
    {
        printf("action 2\n");/* code */
    }else if (action==0)
    {
        printf("quitter\n");/* code */
    }
    else{
        printf("pas bonne saisie\n");
    } 
   }while (action !=0);
   
    return EXIT_SUCCESS ;
}
//Question 2 additionne la somme des entiers jusqu a n