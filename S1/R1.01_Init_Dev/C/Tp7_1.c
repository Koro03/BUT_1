#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

#define N 5
typedef int vecteur[N] ;
void remplirVecteur (vecteur v) ;// initialise v avec les valeurs fournies au clavier .
void afficherVecteur (vecteur v); //affiche à l’écran les
//N coefficients du
//vecteur v.
void sommeVecteur (vecteur v1, vecteur v2, vecteur vSomme);
// met
//dans vs la somme des vecteurs v1 et v2.



int main(){
    vecteur vecteur1,vecteur2,vecteurSomme;
    remplirVecteur(vecteur1);
    remplirVecteur(vecteur2);
    afficherVecteur(vecteur1);
    afficherVecteur(vecteur2);
    sommeVecteur(vecteur1,vecteur2,vecteurSomme);
    afficherVecteur(vecteurSomme);
    return 0;
}

void sommeVecteur (vecteur v1, vecteur v2, vecteur vSomme){
    int i,valV1,valV2;
    for (i = 0; i<N;i++){
        valV1=v1[i];
        valV2=v2[i];
        vSomme[i] = valV1 +valV2;
    }
    
}

void afficherVecteur (vecteur v){
    //pas d'étoile car le tableau on connait déjà 
    //l'adresse de la première valeur

    int i,val;
    for (i = 0; i<N;i++){
        val=v[i];
        printf("%d\n",val); 
    }
}

void remplirVecteur (vecteur v) {
    int i,val;
    for (i = 0; i<N;i++){
        printf("vecteur ?\n");
        scanf("%d",&val); 
        v[i]=val;
    }
}