#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdbool.h>

#define MAX 10

typedef int t_vecteur[MAX];
typedef int t_matrice[MAX][MAX];

void afficherVecteur(t_vecteur vect, int nb);
void afficherMatrice(t_matrice mEvolution, int nb);
void produitVectMat(t_vecteur vInitial, t_matrice mEvolution,t_vecteur vResultat, int nb);
void copiervecteur(t_vecteur vInitial,t_vecteur vResultat,int nb);


int main(){


}

void afficherVecteur(t_vecteur vect, int nb){
    for (int i = 0; i < nb; i++)
    {
        printf("élément %d du tableau : %d\n",i,vect[i]);
    }
    
}

void afficherMatrice(t_matrice mEvolution, int nb){
    for (int i = 0; i < nb; i++)
    {
        for (int j = 0; j < nb; j++)
        {
            printf("élément %d\n",mEvolution[i][j]);
        }
        
    }
    
}

void produitVectMat(t_vecteur vInitial, t_matrice mEvolution,t_vecteur vResultat, int nb){
    for (int j = 0; j < nb; j++)
    {
        vResultat[j] = 0.0;
        for (int i = 0; i < nb; i++)
        {
            vResultat[j] =+ vInitial[i] * mEvolution[i][j];
        }
        
    }
    
}

void copiervecteur(t_vecteur vInitial,t_vecteur vResultat,int nb){
    for (int i = 0; i < nb; i++)
    {
        vResultat[i] = vInitial[i];
        
    }
    
}

