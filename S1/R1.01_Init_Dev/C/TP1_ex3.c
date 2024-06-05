#include <stdio.h>
#include <stdlib.h>
const float moyG = 10;
main(){
    float moyUE1,moyUE2,moyenneG;
    printf("Quelle moyenne");
    scanf("%f", &moyUE1);
    printf("Quelle moyenne");
    scanf("%f", &moyUE2);
    moyenneG = (moyUE1 + moyUE2)/2.0;
    if (moyUE1 <8 || moyUE2 < 8){
        printf("redouble gros nul");
    }else if (moyenneG < 10){
        printf("Jury souverain");
    }else{
        printf("semestre validé");
    }
}