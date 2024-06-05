#include <stdio.h>
#include <stdlib.h>
main(){
    char periode[0];
    int tarifE,tarifA;
    printf("Quelle Periode\n");
    scanf("%c", periode);
    printf("%s\n", periode);
    switch(periode[0]){
        case 'A' :
            tarifA = 7;
            tarifE = 12;
            printf("Payer %d et %d",tarifA,tarifE);
            break;
        case 'B' :
            tarifA = 8;
            tarifE = 14;
            printf("Payer %d et %d",tarifA,tarifE);          
            break;
        case 'C' :
            tarifA = 9;
            tarifE = 16;
            printf("Payer %d et %d",tarifA,tarifE);          
            break;
        case 'D' :
            tarifA = 10;
            tarifE = 18;
            printf("Payer %d et %d",tarifA,tarifE);
            break;
        default:
            printf("Mauvaises reponses %c",periode[0]);
    }
    return 0;
}