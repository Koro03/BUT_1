#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

#define N 5
typedef char chaine20[21] ;
typedef chaine20 tabnoms[N] ;

void affiche(tabnoms tabNom,int n);
void maintientTrie(tabnoms tabNom,int i);
void triParInsertion(tabnoms tabnom, int n);



int main(){
    tabnoms tabNom;
    int i;
}

void affiche(tabnoms tabNom, int n){
    for (int i = 0; i < N; i++)
    {
        printf("%s",tabNom);
    }
    
}

void maintientTrie(tabnoms tabNom,int i){
    if (tabNom[i] < tabNom[i-1] && i-1 >= 0)
    {
       strcpy(tabNom[i],tabNom[i-1]);
    } 
}

void triParInsertion(tabnoms tabnom, int n){
    int i = 0;
}

