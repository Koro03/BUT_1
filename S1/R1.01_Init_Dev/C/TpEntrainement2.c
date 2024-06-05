#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

void traiterUnEmploye(char *nom,int *salaireBrut,float *salaireNet);
void afficherMoyenne();

int main(){
    int salaireBrut;
    float salaireNet;
    char nom[30];
    printf("Quelle est votre nom\n");
    scanf("%s", nom);
    printf("Quelle est votre slaire\n");
    scanf("%d", &salaireBrut);
    traiterUnEmploye(nom, &salaireBrut , &salaireNet);
    return 0;

}

void traiterUnEmploye(char *nom,int *salaireBrut,float *salaireNet){
    *salaireNet = 0;
    *salaireNet = *salaireNet + (*salaireBrut * 0.8);
    printf("Mr/Mme %s votre salaire net est: %f\n",nom,*salaireNet);
}
