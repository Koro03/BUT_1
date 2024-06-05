#include <stdio.h>
#include <stdlib.h>
#include <string.h>


const int Prix1 = 5;
const int Prix2 = 8;
const int Prix3 = 11;
const int Prix4 = 15;


int main(){
    int i,nbInscr,montant,somme,donM,don,donTemp,distance,age;
    float moy;
    i=1;
    donM = 0;
    don = 0;
    somme = 0;
    donTemp = 0;
    printf("nb inscr\n");
    scanf("%d", &nbInscr);
    while(i < nbInscr){
        printf("Quelle disatance vous courez ?(5,12,20km)\n");
        scanf("%d", &distance); 
        printf("Quelle age avez vous ?\n");
        scanf("%d", &age); 
        if ((age < 15 && distance == 20) || (age >= 60 && distance == 12)){
            do{
                printf("payez %d ou le syteme va vous redemander\n",Prix2);
                scanf("%d", &montant); 
            } 
            while(montant < Prix2);
            donTemp = montant - Prix2;
        }
        else if((age < 15 && distance != 20) || (age >= 60 && distance == 5)){
            do{
                printf("payez %d ou le syteme va vous redemander\n",Prix1);
                scanf("%d", &montant); 
            } 
            while(montant < Prix1);
            donTemp = montant - Prix1;
        }
        else if(((age <= 15 &&  age < 60) && distance != 20) || (age >= 60 && distance == 20)){
            do{
                printf("payez %d ou le syteme va vous redemander\n",Prix3);
                scanf("%d", &montant); 
            } 
            while(montant < Prix3);
            donTemp = montant - Prix3;
        }else
        {
            do {
                printf("payez %d ou le syteme va vous redemander\n",Prix4);
                scanf("%d", &montant); 
            } 
            while(montant < Prix4);
            donTemp = montant - Prix4;
        }
        if (donM < donTemp){
            donM = montant;
        }
        don = don + donTemp;
        printf("vouys avez payer %d et fait un don de %d", montant,donTemp);
        somme = somme + montant ;
        i++;
        
    }
    moy = don / i;
    printf("Le montant payer est de %f  ",moy);
}