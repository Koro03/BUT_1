#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

#define N 5
typedef int unTableau[N] ;

int somme(unTableau tablo);

int main(){
    int sommeTab;
    unTableau monTableau = {5,8,2,3,4};
    somme(monTableau);
    sommeTab = somme(monTableau);
    printf("%d\n",sommeTab);
    return 0;
}

int somme(unTableau tablo){
    int i,res = 0;
    for (i = 0; i< N;i++ ){
        res = res + tablo[i];
    }
    return res;
}