#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main(){
    int val;
    printf("Quelle val\n");
    scanf("%d",&val);
    printf("valeur non divisé %d\n",val);
    val = val/3;
    printf("valeur divisé %d\n",val);
    val = val *3;
    printf("valeur remultiplier %d\n",val);

}