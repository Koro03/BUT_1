#include <stdio.h>
#include <stdlib.h>

void ligne(int nbMult);


int main(){
    int compt = 0;
    while (compt < 9){
        printf("|_____________________________________________________________________|\n");
        ligne(compt);
        printf("\n");
        printf("|_____________________________________________________________________|\n");
        compt = compt +1;
    }
    
}


void ligne(int nbMult){
    int i =0;
    int total = 0;
    while (i < 9){
        total = i*nbMult;
        printf("|%d|",total);
        i++;
    }

}