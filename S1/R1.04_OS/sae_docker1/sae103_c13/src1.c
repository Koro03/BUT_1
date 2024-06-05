/**
*
* Ce programme permet de jouer au jeu de sudoku  et en même temps de savoir cb de fois un nom à été donnée dans une année
*
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>


#define TAILLE 4 /**TAILLE qui vaut 9, correspond à la taille de la grille de jeu */
#define TAILLE2 5 /**TAILLE2 qui vaut 5, correspond à la taille de rien */

/**
 *  \struct test
 * 
*/
struct test {
    int test; /**test*/
};


const char ANNULE[5] = "A";
const char ANNULE2[5] = "B";

typedef struct {
    char nom[8]; /** Nom de l'étudiant·e */
    char groupe_td; /** Lettre indiquant son groupe TD */
    int num_td; /** Numéro de son groupe TP (1 ou 2) */
} str_etu; /** Structure d'un·e étudiant·e */

typedef struct {
    char nom[8]; /** Nom de l'étudiant·e */
    char bah_oui; /** Lettre indiquant son groupe tp */
    int mais_oui; /** variable est fait beau*/
} str_oui; /** Structure d'un·e étudiant·e */

/**
 * \typedef tGrille
 * \brief création de la grille de jeu de taille 9x9
 */
typedef int tGrille[TAILLE][TAILLE];

/******************************************************
 *      FONCTION ET PROCÉDURE UTILITAIRES             *
*******************************************************/
void chargerGrille(tGrille g);
void afficherGrille(tGrille g);
void saisir(int *S);
bool possible(int lig, int col, int val, tGrille g);
int verifGrille(tGrille g);


/******************************
* PROGRAMME PRINCIPAL         *
*******************************/

int main(){
    // déclaration des variables
    int numLigne,numColonne,valeur; /**Numero de ligne, colonne et valeur*/
    int compt = 0; /**compteur*/
    char valide[5];/**chaine de caractère valide*/
    tGrille grille1 = { {1,2,3,0},
                       {3,0,1,0},
                       {2,1,4,3},
                       {0,0,2,1}
                    };

    //boucle principale
    while (compt < (TAILLE*TAILLE))
    {
        afficherGrille(grille1);
        compt = verifGrille(grille1);
        printf("Action (A ou Z) ?");
        scanf("%s",valide);
        if (strcmp(valide,ANNULE)==0)
        {
            printf("Indice de la case ?\n");
            saisir(&numLigne);
            saisir(&numColonne);

            // décrémentation des coordonnée saisient par l'utilisateur pour correspondre au coordonnées du tableau
            numLigne--;
            numColonne--;

            //boucle et condition pour insérer une valeur
            if (grille1[numLigne][numColonne] !=0)
            {
                printf("Impossible, la case n'est pas libre.\n");
            }else{
                printf("Valeur à insérer ?\n");
                saisir(&valeur);
                if (possible(numLigne,numColonne,valeur,grille1)== true)
                {
                    grille1[numLigne][numColonne] = valeur;
                    compt += 1;
                }    
            }
        }else{
            grille1[numLigne][numColonne] = 0;
        }                
    }
    afficherGrille(grille1);  
    printf("Grille pleine fin de partie\n");
    return EXIT_SUCCESS;
}


/**
*
* \fn void chargerGrille(tGrille g)
*
* \brief procédure qui charge la grille de jeu 
* \details elle charge le fichier pour afficher la grille
*
*/
void chargerGrille(tGrille g){
    char nomFichier[30];/**chaine qui contient le nom du fichier*/
    FILE * f;
    printf("Nom du fichier ? ");
    scanf("%s", nomFichier);
    f = fopen(nomFichier, "rb");
    if (f==NULL){
        printf("\n ERREUR sur le fichier %s\n", nomFichier);
    } else {
        fread(g, sizeof(int), TAILLE*TAILLE, f);
    }
    fclose(f);
}


/**
 * 
 * \fn void afficherGrille( tGrille g)
 *
 * @brief affiche la grille de jeu
 * 
 * @param g 
 */
void afficherGrille(tGrille g) {
    // affichage des numeros de colonne espacé tout les 3 chiffres
    printf("    ");
    printf(" 1  2   3  4");
    printf("\n");
    printf("   ");

    // affichage de la séparation avec + et ----
    for (int i = 0; i < 2; i++)
    {
        printf("+");
        printf("------");        
    }
    printf("+");
    printf("\n");

    // boucle qui affiche chaque ligne
    for (int i = 0; i < TAILLE; i++){
        printf("%d  ",i+1);
        printf("|");

        // boucle qui affiche chaque colonne
        for (int j = 0; j < TAILLE; j++) {
            if (g[i][j] == 0)
            {
                printf(" . ");
            }else
            {
                printf(" %d ", g[i][j]);
            } 
            if (j==1 || j ==3){
                printf("|");
            }
        }
        printf("\n");

        // separation avec + et ---- entre les bloc de 3 lignes
        if ((i==1) && i !=TAILLE) 
        {
            printf("   ");
            for (int i = 0; i < 2; i++)
            {
                printf("+");
                printf("------");        
            }
            printf("+\n");
        } 
    }

    // affichage du dernier séparateur avec + et ----
    printf("   ");
    for (int i = 0; i < 2; i++)
    {
        printf("+");
        printf("------");        
    }
    printf("+\n");
}



/**
 * \fn saisir(int*S) 
 *
 * @brief fonction qui fait la saisie des doonnées, indice de case et valeur
 * \details cette fonction permet de saissir un chiffre puis 
 * la compare pour verifier qu'elle est valide
 * 
 * @param S 
 */
void saisir(int *S){
    char ch[10]; /**chaine qui permet de comparé au celle entré*/
    int x;/**entier x*/
    do
    {
        printf("Saisissez un chiffre :\n");
        scanf("%s", ch);
        if (sscanf(ch, "%d", &x) !=0){
            // la conversion a réussi, x contient la
            // valeur entière lue au clavier
            *S = x;
        } else {
            //la conversion en entier a échoué
            printf("La saisie a échoué, nb invalide\n");
        }
    } while (*S < 1 || *S > TAILLE);    
}

/**
 * \fn  possible(int lig, int col, int val, tGrille g)
 * 
 * @brief vérifie si les coordonnées et la valeurs sont valide
 * doublons sur une ligne, colonne, dans le carre 3x3
 * 
 * \details cette fonction vérifie les valeurs et les coordonnées 
 * en fonction d'ou elles sont positionnées
 * 
 * @param lig 
 * @param col 
 * @param val 
 * @param g 
 * @return true si les données sont valide, false sinon 
 */
bool possible(int lig, int col, int val, tGrille g){
    bool rep = true;/**booléen qui donne la réponse*/
    int debut_lig = (lig/2)*2;/**variable qui contient la 1ere ligne du carré 3x3*/
    int debut_col = (col/2)*2;/**variable qui contient la 1ere colonne du carré 3x3*/
    for (int i = 0; i < TAILLE; i++)// verifie les doublons dans la ligne
    {
        if (g[lig][i] == val)
        {
            rep = false;
            printf("il y a déjà cette valeur sur la ligne\n");
        } 
    }
    for (int i = 0; i < TAILLE; i++)// verifie les doublons dans la colonne
    {
        if (g[i][col] == val)
        {
            rep = false;
            printf("il y a déjà cette valeur sur la colonne\n");
        }
    }
    // vérifie les doublons dans le carre 3x3
    for(int i = debut_lig; i < debut_lig + 3 ; i++)
    {
        for (int j = debut_col; j < debut_col + 3; j++)
        {
            if (g[i][j] == val)
            {
                rep = false;
                printf("valeur déjà dans le carré de 3x3\n");
            }    
        } 
    }
    return rep;  
}


/**
 * \fn verifGrille(tGrille g)
 * 
 * @brief compte le nombre de nombre dans la grille de depart
 * le compteur partira de ce nombre pour atteindre 81 a la fin
 * 
 * \details cette fonction parcours le tableau et compte le nombre de chiffre déjà dans la grille
 * 
 * @param g 
 * @return int 
 */
int verifGrille(tGrille g){
    int compt = 0;/*compteur qui commence à 0 puis est incrémenter a chaque chiffre présent dans le tableau*/
    for (int i = 0; i < TAILLE; i++)
    {
        for (int j = 0; j < TAILLE; j++)
        {
            if (g[i][j] != 0)
            {
                compt += 1;
            }
        }
    } 
    return compt;
}
