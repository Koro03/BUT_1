#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>

void plusPetit();

int main(){
    int max,min;
    plusPetit(&max,&min);
    printf("%d et %d\n",max,min);
    
}

void plusPetit(int *max,int*min){
    *max = 0;
    *min = 0;
    int val;
    printf("Quelle valeur\n");
    scanf("%d",&val);
    while (val != 0)
    {
        if (*max < val)
        {
            *max = val;
        }
        if (*min >=val || *min ==0 )
        {
            *min = val;
        }
        printf("Quelle valeur\n");
        scanf("%d",&val); 
        
    }
    if (*max ==0 && *min ==0)
    {
        *max =-1;
        *min = -1;
    }
    
}