#include <stdio.h>
#include <stdlib.h>


int main()
{ // Declaration des variables
    char s1[10] = "robert";
    char s2[10];
    // Saisie des donnees
    printf("S2 ? ");
    scanf("%s", s2);// quand sup au nomb de carac il passe par dessus
    // Affichage
    printf("S1=%s\n",s1);
    printf("S2=%s\n",s2);
    return EXIT_SUCCESS;
}