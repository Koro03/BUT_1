#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdbool.h>

#define N 5
typedef int unTableau[N] ;

int sommeTab(unTableau tablo);
void remplirVecteur(unTableau vecteur);
void afficherVecteur(unTableau vecteur);
void sommeVecteur(unTableau vecteur1,unTableau vecteur2,unTableau vSomme);

int main(){
    unTableau tablo = {1,2,3,4,5};
    unTableau vecteur1,vecteur2,vSomme;
    int somme = sommeTab(tablo);
    printf("somme de tab: %d\n", somme);
    printf("*****************\n");
    remplirVecteur(vecteur1);
    remplirVecteur(vecteur2);
    afficherVecteur(vecteur1);
    afficherVecteur(vecteur2);
    sommeVecteur(vecteur1,vecteur2,vSomme);
    printf("*****************\n");
    afficherVecteur(vSomme);
    printf("***************        Ex3       ****************\n");
    
    return 0;

}

int sommeTab(unTableau tablo){
    int somme = 0;
    for (int i = 0; i < N; i++)
    {
        somme += tablo[i];
    }
    return somme;
}
void remplirVecteur(unTableau vecteur){
    for (int i = 0; i < N; i++)
    {
        printf("Quelle Valeur\n");
        scanf("%d",&vecteur[i]);
    }
    
}
void afficherVecteur(unTableau vecteur){
    for (int i = 0; i < N; i++)
    {
        printf("ivaleur du vecteur : %d\n",vecteur[i]);
    }
    
}
void sommeVecteur(unTableau vecteur1,unTableau vecteur2,unTableau vSomme){
    for (int i = 0; i < N; i++)
    {
        vSomme[i] = vecteur1[i] + vecteur2[i];
    }
    
}
