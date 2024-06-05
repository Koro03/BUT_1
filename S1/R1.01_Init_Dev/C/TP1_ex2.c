#include <stdio.h>
#include <stdlib.h>

const float TVA = 1.20;
main()
{
    int nbKwh;
    float PrixKwh,TotKwh;
    PrixKwh = 0.10;
    TotKwh = 0;
    printf("nombre de kwh\n");
    scanf("%d", &nbKwh);

    if (nbKwh <= 100)
    {
        TotKwh = nbKwh * PrixKwh;
       
    }else if (nbKwh > 100 && nbKwh <=150){
        TotKwh = ((nbKwh - 100)*(PrixKwh+0.05)) + (100*PrixKwh);
        
    }else{
        TotKwh = ((100)*(PrixKwh)) + ((50)*(PrixKwh+0.05)) + ((nbKwh-150)*(PrixKwh+0.10));
        

    }
    TotKwh = (TotKwh + 15)*TVA;
    printf("Le prix est de %f", TotKwh);
}