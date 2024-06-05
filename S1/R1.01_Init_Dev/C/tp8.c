#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdbool.h>

#define N 10
typedef int tabEntiers[N];
typedef int tabEntiersS[N+1];

int recherche_sequentielle(int valeur, tabEntiers tablo);
int recherche_sentinelle(int valeur, tabEntiersS tablo);
int recherche_dicho(int valeur, tabEntiers tablo);

int main(){
    tabEntiers leTabloTrie = {13, 24, 35, 42, 53, 68, 77, 83, 88, 91} ;
    int valeur;
    printf("Quelle val rechercher\n");
    scanf("%d",&valeur);
    /*int indiceVal = recherche_sequentielle(valeur, tablo);
    int indiceVal = recherche_sentinelle(valeur,tablo);*/
    int indiceVal = recherche_dicho(valeur,leTabloTrie);
    printf("la val recherceh se trouve à l'indice %d\n",indiceVal);
    


}

int recherche_sequentielle(int valeur, tabEntiers tablo){
    int indVal,i = 0;
    bool present = false;
    while (i < N && present == false )
    {
        if (tablo[i] == valeur)
        {
            indVal = i;
            present = true;
        }
        i++;
        
    }
    if (i>N)
    {
        indVal = -1;
    }
    

    return indVal;
}

int recherche_sentinelle(int valeur, tabEntiersS tablo){
    int indVal,i=0;
    tablo[N] =-1;
    while (tablo[i] !=-1 && valeur != tablo[i])
    {
        i++;
    }
    if (tablo[i] == valeur)
    {
        indVal = i;
    }else{
        indVal =-1;
    }
    
    return indVal;
}

int recherche_dicho(int valeur, tabEntiers tablo){
    int i=0,j=N;
    int millieu = (i+j)/2;
    int indVal =-1;
    while (i <= j && tablo[millieu] != valeur)
    {
        millieu = (i+j)/2;
        if (valeur < tablo[millieu])
        {
            j = millieu -1;
        }else if(tablo[millieu] == valeur ){
            printf("val trouvee à l'indice %d\n", millieu);
            indVal = i;
        }else{
            i = millieu +1;
        }
        
    }
    return indVal;
    
}