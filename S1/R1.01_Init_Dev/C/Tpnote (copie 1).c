#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdbool.h>

#define TAILLE_MAX 15
typedef char tMot[TAILLE_MAX +1];

void initMot(tMot m);
void lireMot(tMot m);
void afficherMot(tMot m);
int longueur(tMot m);
void testeLongueur();
bool estDans(tMot m,char c);
bool compare(tMot mot1,tMot mot2 );
bool sequence(tMot m,char c,char c2);

int main(){
    tMot mot,mot2,mot3;
    char lettre,lettre1;


    testeLongueur();
    //initialisation des 3 mots
    initMot(mot);
    initMot(mot2);
    initMot(mot3);
    // lit les 3 mots et les affiche à l'écran et leurs longueur

    lireMot(mot);
    lireMot(mot2);
    lireMot(mot3);

    afficherMot(mot);
    afficherMot(mot2);
    afficherMot(mot3);

    int taille = longueur(mot);
    int taille2 = longueur(mot2);
    int taille3 = longueur(mot3);
    printf("taille du mot 1:%d\n",taille);
    printf("taille du mot 2:%d\n",taille2);
    printf("taille du mot 3:%d\n",taille3);
    
    // recherche une carac dans m1
    printf("Quelle lettre à chercher dans mot1\n");
    scanf(" %c", &lettre);
    estDans(mot, lettre);
    if (estDans(mot, lettre) == true)
    {
        printf("valeur %c presente dans le mot\n",lettre);
    }else{
        printf("valeur absente\n");
    }
    
    // recherche une sequence dans m3

    printf("Quelle lettre pour le debut de la sequence\n");
    scanf(" %c", &lettre);
    printf("Quelle lettre pour la fin de la sequence\n");
    scanf(" %c", &lettre1);
    sequence(mot3,lettre,lettre1);
    if (sequence(mot3,lettre,lettre1) == true)
    {
        printf("la sequence %c%c presente dans le mot\n",lettre,lettre1);
    }else{
        printf("sequence absente\n");
    }
}

void initMot(tMot m){
    for (int i = 0; i < TAILLE_MAX; i++)
    {
        m[i] = '*';
    }
    
}

void lireMot(tMot m){
    int i=0;
    char lettre;
    printf("Quelle lettre rentrer\n");
    scanf(" %c",&lettre);
    while (lettre != '*' && i < TAILLE_MAX)
    {
        m[i] = lettre;
        i++;
        printf("Quelle lettre rentrer\n");
        scanf(" %c",&lettre);
    }
    
}

void afficherMot(tMot m){
    int i=0;
    while (m[i] != '*' && i< TAILLE_MAX)
    {
        printf("%c",m[i]);
        i++;
    }
    printf("\n");
    
    
}

int longueur(tMot m){
    int taille=0,i=0;
    while (m[i] != '*' )
    {
        taille = taille +1;
        i++;
    }
    return taille;
    
}

void testeLongueur(){
    tMot mot = {'*'};
    tMot mot2 = {'C','H','I','E','N','*'};
    tMot mot3 = {'B','O','A','*'};
    tMot mot4 = {'B','O','A',' ','C','O','N','S','T','R','I','c','T','O','R','*'};

    printf("m1 = {'*'} valeur attendue 0 valeur obtenu :%d\n",longueur(mot));
    printf("m2 = {'*'} valeur attendue 5 valeur obtenu :%d\n",longueur(mot2));
    printf("m3 = {'*'} valeur attendue 3 valeur obtenu :%d\n",longueur(mot3));
    printf("m4 = {'*'} valeur attendue 15 valeur obtenu :%d\n",longueur(mot4));
    
}

bool estDans(tMot m,char c){
    int i=0;
    bool present = false;
    while (present != true && i< TAILLE_MAX)
    {
        if (m[i] == c)
        {
            present = true;
        }
        i++;
    }
    return present;
}

bool compare(tMot mot1,tMot mot2 ){
    int i=0;
    bool motPareil = true;
    while (motPareil != false && i < TAILLE_MAX )
    {
        if (mot1[i] != mot2[i])
        {
            motPareil = false;
        }
        i++;
    }
    return motPareil;
}

bool sequence(tMot m,char c,char c2){
    int i=0;
    bool sequencePresent = false;
    while (i < TAILLE_MAX && m[i] != '*')
    {
        if (m[i] == c && m[i+1] == c2)
        {
            sequencePresent = true;
            printf("Sequence present\n");
        }
        i++;
    }
    return sequencePresent;
    
}