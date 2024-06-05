#include <stdio.h>
#include <stdlib.h>

const float TVA=1.2;

int main()
{
    float prix_ht, prix_kwh,compteur,total;
    int nbKWh;
    prix_kwh = 0.10;
    compteur = 15.0;
    printf("combien de kWh\n");
    scanf("%d", &nbKWh);
    if(nbKWh<=100){
        prix_ht = prix_kwh * nbKWh;// varaiable intermediaire
    }
    else if (nbKWh < 150 && nbKWh > 100)
    {
        prix_ht = 100*prix_kwh + (nbKWh-100)*(prix_kwh+0.05);
        //on sait qu'on a au moins 100 et on veut calculer cb il y a entre 100 et 150
    }
    else
    {
       prix_ht = 100*prix_kwh + 50*(prix_kwh+0.05) + (nbKWh-150)*(prix_kwh+0.1); 
       //la meme mais on c qu'on a au moins 150 et on veut savoir cb apres 150
    }
    printf("%f\n",prix_kwh);
    total = (prix_ht+compteur)* TVA;

    printf("votre facture est de %f pour %d KWh\n",total,nbKWh);

}