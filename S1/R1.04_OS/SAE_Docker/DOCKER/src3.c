/**
* \page Jeu_De_SUDOKU_FINAL
* 
* \author Gachet Elouan: elouan.gachet@etudiant.univ-rennes1.fr
*
* \version 1.2
*
* \date 28 novembre 2023
*
* Ce programme propose de jouer à un jeu de sudoku à partir d'un fichier .sud

* le fichier .sud est un grille de jeu de sudoku.
*
* RAPPEL DES RÈGLES DE SUDOKU :
* Le Sudoku est un jeu de chiffres où vous remplissez une grille 9x9 avec les chiffres de 1 à 9. Les règles sont simples :
*
* Chaque ligne doit contenir tous les chiffres de 1 à 9, sans répétition.
* Chaque colonne doit également contenir tous les chiffres de 1 à 9, sans répétition.
* Chaque bloc 3x3 doit également contenir tous les chiffres de 1 à 9, sans répétition.

*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

/**
* \def TAILLE
* \brief Taille d'un coté de la grille
* chaque coté de la grille fera TAILLE valeurs
*
* Taille d'une grille de sudoku que l'on doit remplir.
*/
#define TAILLE 9

/**
* \typedef tGrille
* \brief Type tableau de TAILLE entier.
*
* Le type tGrille permet de définir un tableau de 2 dimensions de TAILLE x TAILLE
* les éléments (entier) de listes.
*
*/
typedef int tGrille[TAILLE][TAILLE];

/*******************************************************************
* FONCTIONS UTILITAIRES POUR MANIPULER LE FONCTIONNEMENT DU SUDOKU *
********************************************************************/

void chargerGrille(tGrille g);
void afficherGrille(tGrille g);
void saisir(int *S);
bool possible(int lig, int col, int val, tGrille g);
int grillecomplete(tGrille g);

/*******************************************************************
*                        PROGRAMME PRINCIPAL                       *
********************************************************************/

/**
* \fn int main()
* \brief Programme principal.
* \return Code de sortie du programme (0 : sortie normale).
* 
* Le programme principal va afficher une grille de sudoku et va demander à l'utilisateur d'entrer des entiers pour sélectionner
* la case choisie, puis lorsque la case choisie est valide, l'utilisateur peut entrer une valeur, si la valeur peut être rentrer alors
* la grille de sudoku s'affiche avec la valeur, et recommence le procéssus.
* Sinon le programme ré-affiche la grille et indique une erreur s'il y en a une.
* Le jeu continue, et ce, jusqu'à ce que la grille soit entièrement complète.
* 
* Le jeu s'arrête après la complétion entière de la grille, aucun moyen de finir le programme autrement.
* 
*/

int main(){
    tGrille grille;
    int numLigne,numColonne,valeur,compt;
    
    chargerGrille(grille);

    //81 étant le nombre de valeur pour que la grille soit complète
    //quand toutes les valeurs sont entrées dans la grille, c'est que le joueur à gagné donc on arrête la saisie à ce moment-là
    //et on lui dit qu'il a gagné
    compt=grillecomplete(grille);
    printf("il y a pour le moment %d valeurs dans la grille\n",compt);
    while(compt < 81){
        afficherGrille(grille);
        printf("Indice de la case ?\n");
        printf("Indice ligne: ");
        saisir(&numLigne);
        printf("Indice colonne: ");
        saisir(&numColonne);
        
        numColonne--; //dans le tableau la ligne 1 est l'indice 0
        numLigne--;   //dans le tableau la ligne 1 est l'indice 0
        if (grille[numLigne][numColonne] !=0){
            printf("Impossible, la case n'est pas libre.\n");
        }
        else{
            printf("Valeur a inserer ?\n");
            saisir(&valeur);
            if (possible(numLigne,numColonne,valeur,grille)){
                grille[numLigne][numColonne] = valeur;
                compt = compt +1;
                printf("il y a pour le moment %d valeurs dans la grille\n",compt);
            }
        }        
    }
    afficherGrille(grille);
    printf("\nGrille pleine fin de partie\n");
    return EXIT_SUCCESS;
}

/**
* \fn void chargerGrille (tGrille g)
* \brief Demande quel fichier.sud charger pour remplir la grille de sudoku
* \param g : paramètre d'entrée qui représente le tableau qui va être rempli par le fichier
*
* la procédure chargerGrille() demande le nom du fichier puis elle va ouvrir le fichier et intégrer les valeurs
* du fichier dans la grille et le refermer après
* 
* ATTENTION : Si la saisie du fichier est incorrecte, le programme s'arrête.
*/
void chargerGrille(tGrille g){
    char nomFichier[30];
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
* \fn void saisir (int * S)
* \brief Permet la saisie d'un caractère et vérifie s'il est possible de le convertir en entier
* \param S: paramètre d'entrée/sortie qui représente le caractère retourner en entier si la conversion réussi
* \return l'entier S si le caractère S est un nombre compris entre 1 et TAILLE
*
* La procédure saisir() va demander à l'utilisateur d'entrer une valeur ; si cette valeur n'est pas bonne ou que c'est
* un caractère autre qu'un chiffre,
* la procédure lui redemande alors de ressaisir un caractère valide (un chiffre entre 1 - 9).
*
*/

void saisir(int *S){
    char ch[10];
    int x;
    do{
        printf(">>");
        scanf("%s", ch);
        if (sscanf(ch, "%d", &x) !=0){ // la conversion a réussi, x contient la valeur entière lue au clavier.
            *S = x;
        } 
        else{ //la conversion en entier a échoué
            printf("saisie incorrecte, veuiller recommencer\n");
        }
    }while (*S < 1||*S > TAILLE); //vérifie que la valeur est comprise entre 1 et 9
}

/**
* \fn void afficherGrille(tGrille g)
* \brief Affiche la grille de sudoku
* \param g : paramètre d'entrée qui représente le tableau à afficher
*
* La procédure afficherGrille() affiche la grille, chaque ligne et colonne est numérotée,
* chaque bloc est délimité par des - en haut et des | sur les côtés,
* de plus à chaque intersection la procédure affichera des + .
* La procédure lorsqu'une case est vide la procédure place des points "." Et dès qu'une valeur est rajoutée dans la grille.
* Comme avec la procédure saisir(), la procedure afficherGrille() affichera la grille.
*
* 
*/

void afficherGrille(tGrille g){
    int entete,i,j,k;
    printf("     ");
    //affiche l'entete des numeros de collonne 
    for(entete=1; entete <= TAILLE; entete++){
        if(entete%3!=0){
            printf(" %d ", entete);
        }
        else{
            printf(" %d  ",entete);
        }
    }
    printf("\n    ");
    //affiche la ligne avec les + et - qui est en haut du jeu
    for(k=0; k < 3;k++){
        printf("+---------");
    }
    printf("+\n");
    //Affiche les lignes avec les numéros des lignes.
    //affiche aussi les séparateurs | et les . Ou un nombre
    for(i=0; i<TAILLE;i++){
        printf("%d   |",i+1);
        for(j=0; j<TAILLE;j++){

            if(g[i][j]==0){ //remplace par un . les zeros dans la grille 
                printf(" . ");
            }
            else{
                printf(" %d ", g[i][j]);
            }
            if((j+1)%3==0){ //affiche un | pour délimiter les cases
                printf("|");
            }
        }
        if((i+1)%3==0){ //lorsque le bloc fait 3 lignes, on saute de ligne et on 
            printf("\n    ");
            for(k=0; k < 3;k++){
                printf("+---------");
            }
            printf("+");
        }
        printf("\n");
    }  
}

/**
* \fn bool possible(int lig, int col, int val, tGrille g).
* \brief vérifie si la valeur que l'on veut insérer dans une case respecte les règle du sudoku.
* \param g : paramètre d'entrée qui représente le tableau de jeu.
* \param lig : paramètre d'entrée qui représente la ligne de la case sélectionner.
* \param col : paramètre d'entrée qui représente la colonne de la case sélectionner.
* \param val: paramètre d'entrée qui représente la valeur que l'utilisateur veut insérer dans la case.
* \return true si la valeur peut être insérer dans la case.
* 
* La fonction possible() vérifie si la valeur est présente sur la ligne, la colonne ou dans le bloc de 3x3.
* Si la valeur est présente sur la ligne, la colonne ou le bloc de 3x3 la fonction renvoie false
* et indique où est l'erreur, si elle se trouve sur la ligne, la colonne ou le bloc de 3x3.
* 
*/
bool possible(int lig, int col, int val, tGrille g){
    bool rep = true;
    int i,j;
    for (i=0; i<TAILLE;i++){
        if (g[lig][i] == val){
            rep = false;
            printf("cette valeur est présente sur la ligne\n");
        }
        if (g[i][col] == val){
            rep = false;
            printf("cette valeur est présente sur la colonne\n");
        }
    }
    // Vérification du bloc 3x3
    int coinLigne = 3 * (lig / 3);
    int coinColonne = 3 * (col / 3);
    /*printf("coin pour la verif du carre 3x3 (%d-", coinLigne+1);
    printf("%d)\n", coinColonne+1);*/
    for (i = coinLigne; i < coinLigne + 3; i++) {
        for (j = coinColonne; j < coinColonne + 3; j++) {
            if (g[i][j] == val) {
                rep = false;
                printf("Cette valeur est présente dans le bloc 3x3.\n");
            }
        }
    }
    return rep;
}

/**
* \fn int grillecomplete(tGrille g).
* \brief compte le nombre de valeur dans la grille de départ.
* \param g : paramètre d'entrée qui représente le tableau de jeu.
*
* \return le nombre de valeur présente dans le tableau, retourne 0 si la grille est vide.
* 
* La fonction grillecomplete() parcours le tableau et dès qu'une valeur est différente de zéros.
* Alors le nombre de valeur est incrémenter de 1.
*/
int grillecomplete(tGrille g){
    int compt = 0;
    int i, j;    
    for(i=0;i<TAILLE;i++){
        for(j=0;j<TAILLE;j++){
            if(g[i][j]!=0){
                compt = compt +1;
            }
        }
    }
    return compt;
}