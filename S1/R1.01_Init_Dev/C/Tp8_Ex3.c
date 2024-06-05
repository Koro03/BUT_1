#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdbool.h>

#define N 8
typedef char mot8lettres[N] ;

void init(mot8lettres mot);
void saisir(mot8lettres mot);
void afficher(mot8lettres mot);
bool contient(mot8lettres mot, char lettre);

int main(){
    char lettre;
    bool contientVal;
    mot8lettres mot;
    init(mot);
    saisir(mot);
    afficher(mot);
    printf("Quelle lettre\n");
    scanf(" %c", &lettre);
    contientVal = contient(mot,lettre);
    if (contientVal == true)
    {
        printf("valeur contenu");
    }else{
        printf("Pas valeur");
    }
    return 0;
}

void init(mot8lettres mot){
    for (int i = 0; i < N; i++)
    {
        mot[i] = '*';
        printf("%c\n",mot[i]);
    } 
}

void saisir(mot8lettres mot){
    //char lettre;
    for (int i = 0; i < N; i++)
    {
        printf("Quelle lettre\n");
        scanf(" %c",&mot[i]);//scanf(" %c",&lettre);
        //mot[i] = lettre;
        printf("%c\n",mot[i]);
    }
}

void afficher(mot8lettres mot){
    for (int i = 0; i < N; i++)
    {
        printf("%c\n",mot[i]);
    }
}

bool contient(mot8lettres mot, char lettre){
    int i = 0;
    bool present = false;
    while ( mot[i]!= lettre && i < N)
    {
        i++;
    }
    if (mot[i] == lettre )
    {
        present = true;
    }
    return present;   
}

/*******************************************************
*           ex1 et 2                                    *
*********************************************************/

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