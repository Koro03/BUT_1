#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

#define N 10

typedef int tabEntiers[N];

int recherche_sequentielle (int valeur, tabEntiers tablo );

int main(){
    int valeur,valpresent;
    tabEntiers tablo= {23, 54, 65, 12, 43, 78, 68, 93, 18, 31};
    printf("quelle val");
    scanf("%d",&valeur);
    recherche_sequentielle(valeur,tablo);
    valpresent = recherche_sequentielle(valeur,tablo);
    printf("present à %d ou si -1 pas present",valpresent);

}

int recherche_sequentielle (int valeurrr, tabEntiers tablo ){
    int i=0;
    int present =-1;
    while (valeurrr != tablo[i] && i< N)
    {
        i++;
        
        
    }
    if (valeurrr == tablo[i] )
    {
        present = i;
    }
    return present;
    
}