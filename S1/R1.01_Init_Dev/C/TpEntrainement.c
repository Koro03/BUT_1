#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

void division_entier(int a, int b,int *reste);

int main(){
    int reste;
    int a,b;
    printf("Quelle val pour a");
    scanf("%d",&a);
    printf("Quelle val pour b");
    scanf("%d",&b);
    division_entier(a,b,&reste);
    printf("%d",reste);
}

void division_entier(int a, int b,int *reste){
    *reste = a%b;
}