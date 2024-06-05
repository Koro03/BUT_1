#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>



#define N 10
typedef int tabEntiers[N];

int recherche_dicho_iteratif(int valeur, tabEntiers tablo);

int main(){
    int valRech,val;
    printf("Quelle valeur rechercher");
    scanf("%d",&valRech);
    tabEntiers leTabloTrie = {13, 24, 35, 42, 53, 68, 77, 83, 88, 91} ;
    val = recherche_dicho_iteratif(valRech,leTabloTrie);
    printf("%d",val);
    return 0;

}

int recherche_dicho_iteratif(int valeur, tabEntiers tablo){
    int i = 0;
    int j = N;
    int milieu = (i + j)/2;
    while (j > i || valeur == tablo[milieu])
    {
        milieu = (i + j)/2;
        if (valeur < milieu){
            i = i +1;
        }else{
            j = milieu;
        }
    }
    return milieu; 
}