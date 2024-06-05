/*
Remplacement de type bool par des int 
pour les valeur aui pouvait l'être

ajout de la fonction de SingletonCache et singleton nu



*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

#define N 4
#define TAILLE (N*N)

typedef struct {
    int valeur;
    bool candidats[TAILLE + 1];
    int nbCandidats;
} tCase2;

typedef int tGrille[TAILLE][TAILLE];
typedef tCase2 tGrilleCase[TAILLE][TAILLE];

void afficherStats(int *nbCasesVides,int *nbCasesVidesAvantSolver, int *nombreDeCandidats, int *nombreDeCandidatsAvantSolver,char *nomFichier);

void initCase(tCase2 *Case);

int initNbCaseVide(tGrille grille);

int nombreDeCandidats(tGrilleCase grilleCase);

void initCandidats(tGrilleCase grilleCase);

void chargerGrille(tGrille grille,char *nomFichier);

bool estCandidats(tGrilleCase grilleCase, int valeur, int numLignes , int numColonne  );

void ajouterCandidats(tCase2 *Case, int valeur);

void ajouterValeur(tCase2 *Case, tGrilleCase grilleCase, int numLigne, int numColonne);

void retirerCandidats(tCase2 *Case, int valeur);

void retirerCandidatsColonne(tGrilleCase grilleCase, int numColonne, int valeur);
void retirerCandidatsBloc(tGrilleCase grilleCase, int numLigne, int numColonne, int valeur);
void retirerCandidatsLigne(tGrilleCase grilleCase, int numLigne, int valeur);

void afficherGrille(tGrille grille);

void affecterValeur(tGrille grille,tGrilleCase grilleCase);

void singletonCache(tGrille grille,tGrilleCase grilleCase, int numLigne, int numColonne, int valeur,int *nbCasesVides);

bool backtracking(tGrille grille, int numeroCase);
bool absentSurColonne(int valeur, tGrille grille, int colonne);
bool absentSurLigne(int valeur, tGrille grille, int ligne);
bool absentSurBloc(int valeur, tGrille grille, int ligne, int colonne);

int main(){
    tGrille grille;
    tGrilleCase grilleCase;
    char nomgrille[30];
    int progression = 1;
    int nbCasesVidesAvant;
    int nombresCandidats = 0;
    int nbCasesVides;
    int nbCaseRempli = 0 ;
    int toursSansAvance = 0;
    clock_t tmpsDebut = clock();    

    chargerGrille(grille,nomgrille);
    afficherGrille(grille);
    printf("Grille initial");  
    nbCasesVides = initNbCaseVide(grille);
    affecterValeur(grille,grilleCase);
    initCandidats(grilleCase);

    while (nbCasesVides != 0 && progression == 1 && toursSansAvance < 5000) {
        nbCasesVidesAvant = nbCasesVides;

        for (int i = 0; i < TAILLE; i++) {
            for (int j = 0; j < TAILLE; j++) {

                if (grilleCase[i][j].nbCandidats == 1) {
                    ajouterValeur(&grilleCase[i][j], grilleCase, i, j);
                    grille[i][j] = grilleCase[i][j].valeur;
                    // Retirer les candidats dans la ligne, colonne et bloc
                    retirerCandidatsLigne(grilleCase, i, grilleCase[i][j].valeur);
                    retirerCandidatsColonne(grilleCase, j, grilleCase[i][j].valeur);
                    retirerCandidatsBloc(grilleCase, i, j, grilleCase[i][j].valeur);
                    nbCasesVides--;
                    nombresCandidats++;
                    nbCaseRempli++;
                    progression = 1;
                }
                if (nbCasesVidesAvant == nbCasesVides) {
                    toursSansAvance++;
                } else {
                    toursSansAvance = 0;
                }
                if (toursSansAvance == 100) {
                    progression = 0;
                }
            }
        }
    }
    for (int i = 0; i < TAILLE; i++)
    {
        for (int j = 0; j < TAILLE; j++)
        {
            if (grilleCase[i][j].valeur == 0 && grilleCase[i][j].nbCandidats != 1)
            {
                for (int val = 1; val <= TAILLE; val++) {
                    if (grilleCase[i][j].candidats[val] == true) {
                        singletonCache(grille, grilleCase, i, j, val , &nbCasesVides);
                    }
                }
            }
        }
        
    }
         
    if (backtracking(grille, 0)) {
        printf("\nGrille résolue :\n");
        afficherGrille(grille);
    } else {
        printf("\nLa grille ne peut pas être résolue.\n");
    }
    clock_t tmpsFin = clock();
    double tmpsCPU = (double)(tmpsFin - tmpsDebut) / CLOCKS_PER_SEC;
    printf("Temps CPU = %.6f secondes\n", tmpsCPU);   
}

void initCase(tCase2 *Case){
    for (int i = 1; i <= TAILLE; i++)
    {
        Case->candidats[i] = false;
    }
    Case->nbCandidats = 0;
    
}

int initNbCaseVide(tGrille grille){
    int nbCaseVide = 0;
    for (int i = 0; i < TAILLE; i++)
    {
        for (int j = 0; j < TAILLE; j++)
        {
            if (grille[i][j] == 0)
            {
                nbCaseVide++;
            }
            
        }
        
    }
    return nbCaseVide;
    
}

void initCandidats(tGrilleCase grilleCase){
    bool nbEstCandidats;
    for (int i = 0; i < TAILLE; i++)
    {
        for (int j = 0; j < TAILLE; j++)
        {
            if (grilleCase[i][j].valeur == 0)
            {
                for (int compt = 1; compt <= TAILLE; compt++) {
                    nbEstCandidats = estCandidats(grilleCase, compt, i, j);
                    if (nbEstCandidats == true) {
                        ajouterCandidats(&grilleCase[i][j], compt);
                    }
                }
            } 
        }    
    }
     
}

int nombreDeCandidats(tGrilleCase grilleCase){
    int sommeCandidats = 0;
    for (int i = 0; i < TAILLE; i++)
    {
        for (int j = 0; j < TAILLE; j++)
        {
            sommeCandidats += grilleCase[i][j].nbCandidats;
        } 
    } 
    return sommeCandidats;
}

void ajouterCandidats(tCase2 *Case, int valeur){
    if (valeur>0)
    {
        Case->candidats[valeur] = true;
        Case->nbCandidats++;
    }    
}

void retirerCandidats(tCase2 *Case, int valeur){
    if (Case->candidats[valeur] == true) {
        Case->candidats[valeur] = false;
        Case->nbCandidats--;
    }
}

void retirerCandidatsColonne(tGrilleCase grilleCase, int numColonne, int valeur) {
    for (int i = 0; i < TAILLE; i++) {
        if (grilleCase[i][numColonne].valeur == 0) {
            retirerCandidats(&grilleCase[i][numColonne], valeur);
        }
    }
}

void retirerCandidatsBloc(tGrilleCase grilleCase, int numLigne, int numColonne, int valeur) {
    int coinLigne = (numLigne / N) * N;
    int coinColonne = (numColonne / N) * N;

    for (int i = coinLigne; i < coinLigne + N; i++) {
        for (int j = coinColonne; j < coinColonne + N; j++) {
            if (grilleCase[i][j].valeur == 0) {
                retirerCandidats(&grilleCase[i][j], valeur);
            }
        }
    }
}

void retirerCandidatsLigne(tGrilleCase grilleCase, int numLigne, int valeur) {
    for (int j = 0; j < TAILLE; j++) {
        if (grilleCase[numLigne][j].valeur == 0) {
            retirerCandidats(&grilleCase[numLigne][j], valeur);
        }
    }
}

bool estCandidats(tGrilleCase grilleCase, int valeur, int numLignes , int numColonne){
    int i, j, coinLigne, coinColonne;
    bool possible = true;
    for (j = 0; j < TAILLE; j++) {
        if (grilleCase[numLignes][j].valeur == valeur && j != numColonne) {
            possible = false;
        }
    }

    j = numColonne;
    i = 0;

    for (i = 0; i < TAILLE; i++) {
        if (grilleCase[i][numColonne].valeur == valeur && i != numLignes) {
            possible = false;
        }
    }

    coinLigne = (numLignes / N) * N;
    coinColonne = (numColonne / N) * N;

    for (int i = coinLigne; i < coinLigne + N; i++) {
        for (int j = coinColonne; j < coinColonne + N; j++) {
            if (grilleCase[i][j].valeur == valeur && (i != numLignes || j != numColonne)) {
                possible = false;
            }
        }
    }
    return possible;  
}

void affecterValeur(tGrille grille, tGrilleCase grilleCase) {
    for (int i = 0; i < TAILLE; i++) {
        for (int j = 0; j < TAILLE; j++) {
            if (grille[i][j] != 0) {
                grilleCase[i][j].valeur = grille[i][j];
                initCase(&grilleCase[i][j]);
            }else{
                grilleCase[i][j].valeur = 0;
                initCase(&grilleCase[i][j]);
            }
        }
    }

    
}

void ajouterValeur(tCase2 *Case, tGrilleCase grilleCase, int numLigne, int numColonne) {
    int i = 1;
    while (Case->candidats[i] != true && i <= TAILLE) {
        i++;
    }
    Case->valeur = i;
    retirerCandidats(Case, i);

    // Mettre à jour la grilleCase et retirer les candidats associés à la nouvelle valeur
    grilleCase[numLigne][numColonne].valeur = Case->valeur;
    retirerCandidatsLigne(grilleCase, numLigne, Case->valeur);
    retirerCandidatsColonne(grilleCase, numColonne, Case->valeur);
    retirerCandidatsBloc(grilleCase, numLigne, numColonne, Case->valeur);
}
void singletonCache(tGrille grille, tGrilleCase grilleCase, int numLigne, int numColonne, int valeur, int *nbCasesVides) {
    int coinColonne, coinLigne;
    int nbCandidatsTrouves = 0;

    for (int j = 0; j < TAILLE; j++) {
        if (j != numColonne && grilleCase[numLigne][j].candidats[valeur] == true) {
            nbCandidatsTrouves++;
        }
    }

    for (int i = 0; i < TAILLE; i++) {
        if (i != numLigne && grilleCase[i][numColonne].candidats[valeur] == true) {
            nbCandidatsTrouves++;
        }
    }

    coinLigne = (numLigne / N) * N;
    coinColonne = (numColonne / N) * N;

    for (int i = coinLigne; i < coinLigne + N; i++) {
        for (int j = coinColonne; j < coinColonne + N; j++) {
            if ((i != numLigne || j != numColonne) && grilleCase[i][j].candidats[valeur] == true) {
                nbCandidatsTrouves++;
            }
        }
    }

    int compteurCandidats = 0;
    for (int i = 0; i < TAILLE; i++) {
        for (int j = 0; j < TAILLE; j++) {
            if (grilleCase[i][j].valeur == 0 && grilleCase[i][j].candidats[valeur] == true) {
                compteurCandidats++;
            }
        }
    }

    if (nbCandidatsTrouves == 0 && compteurCandidats == 1) {
        retirerCandidats(&grilleCase[numLigne][numColonne], valeur);
        grilleCase[numLigne][numColonne].valeur = valeur;
        grille[numLigne][numColonne] = valeur;
        (*nbCasesVides)--;
    }
}



bool backtracking(tGrille grille, int numeroCase) {
    int ligne, colonne;
    bool resultat = false;

    if (numeroCase == TAILLE * TAILLE) {
        // toutes les cases sont traitées
        resultat = true;
    } else {
        ligne = numeroCase / TAILLE;
        colonne = numeroCase % TAILLE;
        if (grille[ligne][colonne] != 0) {
            // si la case n'est pas vide, on passe à la suivante
            resultat = backtracking(grille, numeroCase + 1);
        } else {
            for (int valeur = 1; valeur <= TAILLE; valeur++) {
                if (absentSurLigne(valeur, grille, ligne) && absentSurColonne(valeur, grille, colonne) && absentSurBloc(valeur, grille, ligne, colonne)) {
                    grille[ligne][colonne] = valeur;

                    if (backtracking(grille, numeroCase + 1)) {
                        resultat = true;
                        break; 
                    } else {
                        grille[ligne][colonne] = 0;  
                    }
                }
            }
        }
    }
    return resultat;
}

bool absentSurLigne(int valeur, tGrille grille, int ligne) {
    int j;
    bool possible = true;
    for (j = 0; j < TAILLE; j++) {
        if (grille[ligne][j] == valeur) {
            possible = false;
            break;  
        }
    }
    return possible;
}

bool absentSurColonne(int valeur, tGrille grille, int colonne) {
    int i;
    bool possible = true;
    for (i = 0; i < TAILLE; i++) {
        if (grille[i][colonne] == valeur) {
            possible = false;
            break;  
        }
    }
    return possible;
}

bool absentSurBloc(int valeur, tGrille grille, int ligne, int colonne) {
    int coinBlocColonne, coinBlocLigne;
    bool possible = true;
    coinBlocLigne = (ligne / N) * N;
    coinBlocColonne = (colonne / N) * N;
    for (int i = coinBlocLigne; i < coinBlocLigne + N; i++) {
        for (int j = coinBlocColonne; j < coinBlocColonne + N; j++) {
            if (grille[i][j] == valeur) {
                possible = false;
                break;  
            }
        }
    }
    return possible;
}

void chargerGrille(tGrille g,char *nomFichier) {
    FILE *f;
    printf("Nom du fichier ?\n");
    scanf("%s", nomFichier);
    f = fopen(nomFichier, "rb");

    if (f == NULL) {
        printf("\nERREUR sur le fichier %s\n", nomFichier);
    } else {
        fread(g, sizeof(int), TAILLE * TAILLE, f);
    }
    fclose(f);
}

void afficherGrille(tGrille grille) {
    int i, j, compteur1, compteur2 = 1;
    printf("    ");
    for (compteur1 = 1; compteur1 < TAILLE + 1; compteur1++) {
        printf("%3d", compteur1);
        if (compteur1 == 8 || compteur1 == 4 || compteur1 == 12) {
            printf(" ");
        }
    }
    printf("\n    +------------+------------+------------+------------+\n");
    for (i = 0; i < TAILLE; i++) {
        printf("%3d |", compteur2);
        for (j = 0; j < TAILLE; j++) {
            if (grille[i][j] == 0) {
                printf(" . ");
            } else {
                printf("%2d ", grille[i][j]);
            }
            if (j == 3 || j == 7 || j == 11) {
                printf("|");
            }
        }
        printf("|\n");
        compteur2++;
        if (compteur2 == 5 || compteur2 == 9 || compteur2 == 13) {
            printf("    +------------+------------+------------+------------+\n");

        }
    }
    printf("    +------------+------------+------------+------------+\n");

}