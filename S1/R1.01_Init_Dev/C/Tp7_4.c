#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

#define N 9
typedef int money[N];


void total();
void somme(money guichet, money total,int valeuRetire);
void recapitulatif();
void saisie(money tab);

int main(){
    money guichet = {1,2,5,10,50,100,200,500};
    money total;
    saisie(total);

    return 0;

}

saisie(money tab){
    int i;
    for (i = 0; i <= N ;i++){
        tab[i]=0;
    }
}

void somme(money guichet,money total, int valeuRetire ){
    int i = N;
    int res =0;
    while (valeuRetire != 0)
    {
        if (guichet[i] <= valeuRetire)
        {
            res =valeuRetire - guichet[i];
            total[i] = total[i]+1;
        }else{
            i --;
        }
        
    }
    
    
}