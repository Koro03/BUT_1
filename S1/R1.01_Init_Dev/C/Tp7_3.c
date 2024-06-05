#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

#define N 21
typedef int tableauNote[N];


void afficherTab();
void majTab(tableauNote tab,tableauNote tabNote);
void intialisationTab();


int main(){
    tableauNote tab = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    tableauNote tabNote = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    majTab(tab,tabNote);
    afficherTab(tabNote);
    
}

void majTab(tableauNote tab,tableauNote tabNote){
    int note,i;
    printf("Quelle note ?");
    scanf("%d",&note);
    while (note != -1)
    {
        for (i=0;i<N;i++){
            if (note == tab[i]){
                tabNote[note] = tabNote[note] + 1;
            }
        }
        printf("Quelle note ?");
        scanf("%d",&note);

    }
}

void afficherTab(tableauNote tabNote){
    int val,i;
    for (i=0;i<N;i++){
        val = tabNote[i];
        if (val !=0){
            printf("pour la note %d il y a %d occurence\n",i,val);
        }
        
    }
}