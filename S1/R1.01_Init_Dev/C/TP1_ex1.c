#include <stdio.h>
#include <stdlib.h>

const int essence = 10;
const float KmEssence = 1.2;
const int diesel = 15;
const float KmDiesel = 1.0;
main()
{
    int nbKm,nbJours;
    float TotDiesel,TotEssence;

    TotDiesel = 0;
    TotEssence = 0;
    printf("nombre de jours\n");
    scanf("%d", &nbJours);
    printf("nombre de km\n");
    scanf("%d", &nbKm);

    TotDiesel = (diesel * nbJours) + (KmDiesel * nbKm);
    TotEssence = (essence * nbJours) + (KmEssence * nbKm);
    if (TotDiesel > TotEssence)
    {
        printf("L essence coute moins chere avec %f compare a %f", TotEssence,TotDiesel);
    }else if (TotDiesel < TotEssence){
        printf("Diesel coute moins chere avec %f compare a %f", TotDiesel,TotEssence);

    }else{
        printf("egaux avec %f et %f",TotDiesel,TotEssence);

    }
    
    
}