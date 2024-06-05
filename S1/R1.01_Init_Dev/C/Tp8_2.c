#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

#define N 10

typedef int tabEntiers[N+1];
int recherchePresent(tabEntiers tablo,int valRechercher);

int main(){
    int valrecherche,val;
    tabEntiers leTablo = {23, 54, 65, 12, 43, 78, 68, 93, 18, 31,0} ;
    printf("Quelle val\n");
    scanf("%d",&val);
    valrecherche = recherchePresent(leTablo,val);
    printf("présen à l'indice %d et si c -1 pas présent\n",valrecherche);

    
}

//VERSION MOI 
int recherchePresent(tabEntiers tablo,int valRechercher){
    int i =0;
    int present =-1;
    tablo[N] = valRechercher;
    while (valRechercher != tablo[i])
    {   
        i++;
    }
    if (i!=N)
    {
        present = i;
    }
    
    return present;

}


int recherche_sentinelle(int valeur, tabEntiers tablo) {
    int i = 0;

    // Ajout de la sentinelle à la fin du tableau
    tablo[N] = valeur;

    while (valeur != tablo[i]) {
        i++;
    }

    if (i < N) {
        return i; // La valeur a été trouvée
    } else {
        return -1; // La valeur n'a pas été trouvée
    }
}