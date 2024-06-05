#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdbool.h>

float fcalcul(int v1, int v2);
int factorielle(int valeur);

int main(){
    int v1,v2,valFacto,valeur;
    printf("Valeur 1  de l'hypo\n");
    scanf("%d",&v1);
    printf("Valeur 2  de l'hypo\n");
    scanf("%d",&v2);
    float hypo =fcalcul(v1,v2);
    printf("%f\n",hypo);

    printf("Valeur\n");
    scanf("%d",&valeur);
    valFacto = factorielle(valeur);
    printf("%d",valFacto);
    

}

float fcalcul(int v1, int v2){
    float hypothenuse;
    hypothenuse = sqrt((v1*v1) + (v2*v2));
    return hypothenuse;
}
int factorielle(int valeur){
    int valFacto =1,i=1;
    if (valeur ==0)
    {
        valFacto = 1;
    }else{
        while (i <= valeur)
        {
            valFacto = (valFacto *i);
            i++;
        }
        
    }
    return valFacto;
}