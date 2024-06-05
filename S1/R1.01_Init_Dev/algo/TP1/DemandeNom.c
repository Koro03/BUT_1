/**
* @brief pg qui demande un nom et un age et qui les affiche
*/
#include <stdio.h>
#include <stdlib.h>
int main()
{
    char nom[20];// une chaîne d'au plus 20 caractères (dont le caractère de fin de chaîne, donc 19 disponibles)
    int age;

    printf("Bienvenue au departement info\n");
    printf("Quel est votre nom ?\n");
    scanf("%s",nom);// un string a une adress deja defini
    printf("quel age as tu ?");
    scanf("%d",&age);//  -&- defini ou se trouve l adresse

    printf("bonjour %s\n", nom);
    printf("tu as %d année(s)\n",age);
    return EXIT_SUCCESS;
}