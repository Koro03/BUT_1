#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdbool.h>

float TAUX = 0.8;
#define MARQUEUR_FIN  "*"

void traiterEmploye(char nom[30],int *salaireBrut,float *salaireNet);
void afficherMoyenne(float *salaireNet,int *i);

int main(){
    char nom[30];
    int salaireBrut,i=1;
    float salaireNet,totalSalaire=0;
    printf("Ton nom ?\n");
    scanf("%s", nom);
    printf("Ton salaire ?\n");
    scanf("%d", &salaireBrut);
    traiterEmploye(nom,&salaireBrut,&salaireNet);
    totalSalaire = totalSalaire + salaireNet;
    while (strcmp(nom,MARQUEUR_FIN) != 0)
    {
        printf("Ton nom ?\n");
        scanf("%s", nom);
        if (strcmp(nom,MARQUEUR_FIN) == 0)
        {
            printf("saisie terminee\n");
        }else{
            printf("Ton salaire ?\n");
            scanf("%d", &salaireBrut);
            traiterEmploye(nom,&salaireBrut,&salaireNet);
            printf("salaire brut : %d, salaire net : %f , nom : %s\n",salaireBrut,salaireNet,nom);
            totalSalaire = totalSalaire + salaireNet;
            i++;
        }
        
        
    }
    afficherMoyenne(&totalSalaire,&i);
    printf("salaire moyen : %f\n",totalSalaire);
    return 0;
}

void traiterEmploye(char nom[30],int *salaireBrut,float *salaireNet){
    *salaireNet = 0;
    *salaireNet = *salaireNet + (*salaireBrut * TAUX);

}

void afficherMoyenne(float *totalSalaireNet,int *i){
    
    *totalSalaireNet = *totalSalaireNet / *i;
    
}