/**
* @brief deux ages sont demandés et leur différence affichée
*/
#include <stdio.h>
#include <stdlib.h>

const float PI=3.14159;

int main()
{
    int un;
    float x;

    un = 12;
    x = 8.42;

    printf("voici un : %d et x : %f. Ce sont deux variables.\n", un,x);
    printf("voici un : %d", un);
    printf(" et x : %f. Ce sont deux variables.",x);
    printf("\n");
    printf("voici un : %.3f", PI);
    return EXIT_SUCCESS;
    


}
