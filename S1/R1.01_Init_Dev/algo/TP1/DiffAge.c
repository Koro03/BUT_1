/**
* @brief deux ages sont demandés et leur différence affichée
*/
#include <stdio.h>
#include <stdlib.h>
int main()
{
    char nom1[50]; // nom d'une première personne (50 car, dont le caractère de fin de chaîne)
    int age1;
    char nom2[50];
    int age2;

    printf("Bienvenuen au departement info\n");
    printf("Donne ton nom 1\n");
    scanf("%s",nom1);
    printf("c quoi ton age 1 \n");
    scanf("%d",&age1);
    printf("Ton nom 2\n");
    scanf("%s", nom2);
    printf("Ton age 2\n");
    scanf("%d",&age2);

    printf("vous avez %d annees de diff les bgs\n", age1-age2);
    return EXIT_SUCCESS;


}