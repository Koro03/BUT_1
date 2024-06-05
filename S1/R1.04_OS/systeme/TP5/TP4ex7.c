#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void usage();
void calcul(int nb1,char operande[1],int nb2);

const char arret[] = ":";

int main(){
    int nb1, nb2;
    char operande[1];
    usage();
    while(strcmp(operande,arret)!=0){
        printf("nb1 ? ");
        scanf("%d",&nb1);

        printf("operande ? ");
        scanf("%s",operande);
        printf("nb2 ? ");
        scanf("%d",&nb2); 

        calcul(nb1,operande,nb2);
    }
    printf("au revoir ...");
}


void usage(){

    printf("Ecrivez une suite d’operations sous la forme:\n"); 
    printf("<operande> <operateur> <operande>\n");
    printf(" terminer utilisez : comme operateur.\n"); 

}

void calcul (int nb1, char operande[1] , int nb2){
    int calcul = 0;
    switch(operande[0]){
        case '+':
            calcul = nb1 + nb2;
            printf(" %d",calcul);
            break;
        case '-':
            calcul = nb1 - nb2;
            printf(" %d ",calcul);
            break;
        case '*':
            calcul = nb1 * nb2;
            printf(" %d",calcul);
            break;
        case '/':
            calcul = nb1 / nb2;
            printf(" %d",calcul);
            break;
        default :
            printf("operateur inconnu\n");    
    }
}