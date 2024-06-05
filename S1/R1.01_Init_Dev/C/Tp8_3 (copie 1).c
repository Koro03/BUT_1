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
    printf("Quelle valeur rechercher\n");
    scanf("%d",&valRech);
    tabEntiers leTabloTrie = {13, 24, 35, 42, 53, 68, 77, 83, 88, 91} ;
    val = recherche_dicho_iteratif(valRech,leTabloTrie);
    printf("%d\n",val);
    return 0;

}

int recherche_dicho_iteratif(int valeur, tabEntiers tablo){
    int i = 0;
    int j = N;
    int milieu = (i + j)/2;
    int trouve;
    while (j > i && valeur != tablo[milieu])
    {
        if (valeur < tablo[milieu]){
            j = milieu-1;
        }else if (valeur > tablo[milieu])
        {
            i = milieu+1;
        }
        milieu = (i + j)/2;
    }
    trouve = milieu;
    if (valeur != tablo[milieu])
    {
        printf("valeur non present\n");
        trouve = -1;
    }
    return trouve; 
}