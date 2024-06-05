#include <stdio.h>
#include <stdlib.h>
#include <string.h>

main(){
    char ch1[3],ch2[2];
    printf("chaine 1\n");
    scanf("%s", ch1);
    printf("chaine 2\n");
    scanf("%s", ch2);
    if (strcmp(ch2,ch1) > 0){
        printf("ch2 plus grand");
    }else if (strcmp(ch2,ch1) < 0){
        printf("ch1 plus grand");
    }else{
        printf("chaine egal");
    }

    return 0;
}