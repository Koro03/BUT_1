#include <stdio.h>
#include <stdlib.h>
void menu();

int main(){
    int nb1,nb2;
    printf("val1\n");
    scanf("%d",&nb1);
    printf("val2\n");
    scanf("%d",&nb2);
    menu(nb1,nb2);
}

void menu(int a,int b){
    int max;
    if (a>b)
    {
        max = a;
    }if (a<b)
    {
        max = b;
    }if (a==b)
    {
        max = a;
    }
    
    printf("la plus grande valeur est %d\n",max);
}