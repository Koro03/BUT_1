/*****preprocesseur*/

//gcc -o prog.txt -E prog.c -> prog.o


/*arrêt au code assembleur*/
//gcc -S prog.c -> prog.s

/*
const.h  define
types.h  types/ structure
globales.h déclaration des constantes et globales.cdéfinition des constantes
fonction.h déclaration des prototypes des fonctions
main.c définitions des fonctions
fonction.c définition du programme principal


# ifndef TYPES_H
# define TYPES_H
#include "const.h"
// types et structures
typedef struct{
char c_nom [LONG];
} t_personne;
# endif

# ifndef GLOBALES_H
# define GLOBALES_H
# include "types.h"
// constantes : variables globales
extern const t_personne PERS_VIDE; // extern : la variable sera définie dans un autre
// fichier
# endif

# include "types.h"
# include "globales.h" // vérification de la conformité avec globales.h
// definition des constantes
const t_personne PERS_VIDE ={"sans_nom"};

# ifndef FONCTIONS_H
# define FONCTIONS_H
# include "types.h"
// définition des prototypes
void init(t_personne *adrPers);
t_personne saisir_personne();
void affiche(t_personne pers);
# endif

# include <stdio.h>
# include <stdlib.h>
# include <string.h>
# include "types.h"
# include "globales.h"
# include "fonctions.h" // vérification de la conformité entre les prototypes et les entêtes des fonctions
// definition des fonctions
void init(t_personne *adrPers){...}
t_personne saisir_personne(){...}
void affiche(t_personne pers){...}

# include <stdio.h>
// constantes symboliques
# include "const.h"
// types et structures
# include "types.h"
// définition des prototypes
# include "fonctions.h"
// définition des constantes
# include "globale.h"
// programme principal
int main(){
...
return 0 ;
}


gcc -Wall -c globales.c // génération du fichier globales.o
gcc -Wall -c fonctions.c // génération du fichier fonction.o
gcc -Wall -c main_personne.c

#!/bin/bash
rm *.o # supprimer les fichiers .o
rm *.out # supprimer les fichiers .out

# compilation séparée
gcc -Wall -c globales.c
gcc -Wall -c fonctions.c
gcc -Wall -c main_personne.c

# edition de lien
gcc -Wall main_personne.o fonctions.o globales.o -o gestion_personne.out
# lancement du programm
./gestion_personne.out


fichier.h => inclusion avec #include
fichier.c ou fichier.o => compilation avec gcc
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define MAX_SIZE 100

typedef struct {
    // Autres champs de la structure t_element
    char date[MAX_SIZE]; // Champ pour stocker la date sous forme de chaîne de caractères
} t_element;

// Autres fonctions et structures nécessaires pour votre application...

// Supprimer les éléments antérieurs à une date donnée
void supprime_anciens_date(t_element *file, int *taille, const char *dateLimite) {
    int i, j;
    for (i = 0, j = 0; i < *taille; i++) {
        if (strcmp(file[i].date, dateLimite) > 0) {
            // L'élément est postérieur à la date limite, le conserver
            if (i != j) {
                // Déplacer l'élément vers la position correcte si nécessaire
                file[j] = file[i];
            }
            j++;
        }
        // Sinon, ignorer l'élément car il est antérieur à la date limite
    }
    *taille = j;
}

int main() {
    // Initialisation de votre file (tableau de t_element) et d'autres variables...
    
    // Appel de la fonction pour supprimer les éléments antérieurs à une date donnée
    supprime_anciens_date(file, &taille, "2023-01-01 00:00:00");

    // Autres opérations avec la file...

    return 0;
}

