#include <stdio.h>
#include <stdlib.h>
#include <string.h>
const float TAUX=0.80;
int main ()
{
    int i,salaireBrut;
    float moy,salaireNet;
    char nom[19];
    i=0;
    moy = 0;
    salaireNet = 0;
      
    printf("nom\n");
    scanf("%s",nom);
    while ( strcmp(nom,"*")!=0 )
    {
        printf(" salaire ? \n") ;
        scanf("%d",&salaireBrut) ; 
        salaireNet = salaireNet + (salaireBrut * TAUX);
        i++;
        printf("nom\n");
        scanf("%s",nom);
    }
    if(i!=0){
        moy=salaireNet/i;
    }
    printf("résultat : %f\n",moy) ;
    return EXIT_SUCCESS ;
}
//Question 2 additionne la somme des entiers jusqu a n