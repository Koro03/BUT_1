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
    mot8lettres mot;
    char lettre;
    init(mot);
    saisir(mot);
    afficher(mot);
    printf("Quelle lettre tu recherche\n");
    scanf(" %c",&lettre);
    contient(mot, lettre);
    


}

void init(mot8lettres mot){
    for (int i = 0; i < N; i++)
    {
        mot[i] = '*';
    }
    
}

void saisir(mot8lettres mot){
    for (int i = 0; i < N; i++)
    {
        printf("Quelle lettre\n");
        scanf(" %c",&mot[i]);
    }
    
}

void afficher(mot8lettres mot){
    for (int i = 0; i < N; i++)
    {
        printf("%c",mot[i]);
    }
    
}

bool contient(mot8lettres mot,char lettre){
    int i=0;
    bool present = false;
    while (i<N && present == false)
    {
        if (lettre == mot[i])
        {
            present = true;
            printf("caractere trouve\n");
        }
        
        i++;
    }
    return present;
}