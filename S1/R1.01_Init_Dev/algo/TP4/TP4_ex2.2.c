#include <stdio.h>
#include <stdlib.h>
void menu();

int main(){
    int act;
    do{
        menu(act);
        scanf("%d",&act); 
    }while (act != 0 && act != 1 && act != 2 );
    if (act == 1)
    {
        printf("action 1\n");
    }else if (act == 2)
    {
        printf("action 2\n");
    }else{
       printf("arrêt\n");
    } 
}

void menu(int act){
    printf("0 pour arrêter\n2 pour l'action n2\n1 pour l'action n1\nSinon on le redemendera\n\n");
    if (act != 0 && act != 1 && act != 2)
    {
        printf("erreur erronee\n\n0 pour arrêter\n2 pour l'action n2\n1 pour l'action n1\n\n");
    }
    
}