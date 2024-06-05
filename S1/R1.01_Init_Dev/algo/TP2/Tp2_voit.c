#include <stdio.h>
#include <stdlib.h>

int main()
{
    int km,jour;
    float prixD,prixE,carD,carE;

    printf("Combien de jour\n");
    scanf("%d",&jour);
    printf("Combien de kilometre\n");  
    scanf("%d",&km);
    prixE = 1.2;
    carE=(jour*10)+(prixE*km);
    prixD = 1.0;
    carD = (jour*15)+(prixD*km);

    if (carD > carE)
    {
        printf("essence(%5.1f euro contre %5.1f euros)\n",carE,carD);
    }
    else if (carD == carE)
    {
        printf("egalite pour %5.1f\n",carD); 
    }
    else
    {
        printf("essence(%5.1f euro contre %5.1f euros)\n",carD,carE);
    }

}