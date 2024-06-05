#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int main(){
    int present = 2 ;
    present = !present; // sa veut dire inverse
    if (present != 2)
    {
        printf("ça marche %d\n",present);
    }
    
}