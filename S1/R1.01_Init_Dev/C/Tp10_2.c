#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define NM 12
typedef char t_chaine9[10];

typedef struct{
    t_chaine9 c_nom;
    int c_nbJours;
} t_mois;

typedef t_mois t_tabMois[NM];

const t_tabMois tMois= { {"janvier",31},
    {"fevrier",28},
    {"mars",31},
    {"avril",30},
    {"mai",30},
    {"juin",30},
    {"juillet",30},
    {"aout",30},
    {"septembre",30},
    {"octobre",30},
    {"novembre",30},
    {"decembre", 31}
};

void mois31j(const t_tabMois tMois);
int nbrJours(t_chaine9 nomMois,const t_tabMois tMois);


int main(){
    mois31j(tMois);
    t_chaine9 mois;
    printf("mois ?\n");
    scanf("%s",mois);
    int nbJ = nbrJours(mois,tMois);
    printf("%d",nbJ);
    return 0;
}

void mois31j(const t_tabMois tMois){
    for (size_t i = 0; i <= NM; i++)
    {

        if (tMois[i].c_nbJours == 31)
        {
            printf("%s",tMois[i].c_nom);
        }
    }
    
}

int nbrJours(t_chaine9 nomMois,const t_tabMois tMois){
    int nbrJours = -1;
    for (int i = 0; i <= NM; i++)
    {
        if (strcmp(tMois->c_nom,nomMois) == 0)
        {
           nbrJours = tMois->c_nbJours;
        }
    }
    return nbrJours;

}

#include <stdio.h>

#define MAX 198

typedef struct {
    int c_numero;
    int c_temps;
} t_concurrent;

typedef t_concurrent t_tabconc[MAX];

void permuter(t_concurrent *c1, t_concurrent *c2) {
    t_concurrent temp = *c1;
    *c1 = *c2;
    *c2 = temp;
}

void insere(t_concurrent c, t_tabconc tc, int n) {
    tc[n] = c;

    // Remonter à la vraie place
    int i = n;
    while (i > 0 && tc[i].c_temps < tc[i - 1].c_temps) {
        permuter(&tc[i], &tc[i - 1]);
        i--;
    }
}

void affiche_classement(t_tabconc tc, int n) {
    printf("Classement provisoire :\n");
    for (int i = 0; i < n; i++) {
        printf("Dossard : %d, Temps : %d\n", tc[i].c_numero, tc[i].c_temps);
    }
    printf("\n");
}

int main() {
    t_tabconc concurrents;
    int n = 0; // Nombre de concurrents déjà classés

    printf("Entrez les numéros et temps des concurrents (tapez -1 pour terminer) :\n");

    int numero, temps;
    scanf("%d", &numero);

    while (numero != -1 && n < MAX) {
        scanf("%d", &temps);

        t_concurrent nouveau_concurrent = {numero, temps};
        insere(nouveau_concurrent, concurrents, n);
        n++;

        affiche_classement(concurrents, n);

        scanf("%d", &numero);
    }

    return 0;
}