#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <time.h>
/*******************************************************************
*
* @brief programme de TRI RAPIDE sur un tableau de 100 000 entiers
* initialis� avec des valeurs al�atoires
*
*******************************************************************/
#define TAILLE 100000

typedef int typeTab[TAILLE];

void triRapide(typeTab t, int debut, int fin);
int partitionner(typeTab t, int debut, int fin, int pivot);
void remplirTableau(typeTab tab);


int main () {
    typeTab leTableau;
    double tmpsCPU;

    srand(time(NULL));
    double tmps1 = time(NULL);
    clock_t begin = clock();
    remplirTableau(leTableau);
    triRapide(leTableau, 0, TAILLE-1);
    double tmps2 = time(NULL);
    double tmpsFin = difftime(tmps2,tmps1);
    clock_t end = clock();
    tmpsCPU = (end - begin)*1.0 / CLOCKS_PER_SEC;
    printf("%lf",tmpsCPU);
    printf("%lf",tmpsFin);
    return EXIT_SUCCESS;
}

int partitionner(typeTab t, int debut, int fin, int pivot){
    int tmp;
    int j;

    tmp = t[pivot];
    t[pivot] = t[fin];
    t[fin] = tmp;

    j = debut;
    for (int i=debut ; i<fin ; i++){
        if (t[i]<=t[fin]){
            tmp = t[i];
            t[i] = t[j];
            t[j] = tmp;
            j++;
        }
    }
    tmp = t[fin];
    t[fin] = t[j];
    t[j] = tmp;

    return j;
}

void triRapide(typeTab t, int debut, int fin){
    int pivot;
    if (debut < fin){
        pivot = (debut+fin) / 2;
        pivot = partitionner(t, debut, fin, pivot);
        triRapide(t, debut, pivot-1);
        triRapide(t, pivot+1, fin);
    }
}

void remplirTableau(typeTab tab){
    int i;
    for (i=0 ; i<TAILLE ; i++){
        tab[i] = rand();
    }
}
