#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
#include <time.h>
#include <stdbool.h>

/**
 * \file main.c
 * \brief Programme pour manipuler un mot de 8 lettres.
 * \details Initialise un tableau de caractères, permet à l'utilisateur de saisir
 * un mot de 8 lettres, affiche le mot, et vérifie si une lettre spécifiée est présente.
 */

#define N 8 /** Nombre de lettres dans le tableau de caractères */
#define mois 12 /**Le nombre de mois d'une année */

typedef char mot8lettres[N]; /** Le tableau de caractères */
typedef char moisDeLannee[mois]; /** Un tableau de de tous les mois d'une année */

typedef struct 
{
    char nom; /** nom du mois de lannee*/
    int nbJours ; /*le nombre de jours d'un mois*/

}moisD1annee;

typedef struct 
{
    mot8lettres nom; /*Les nom donnée à des enfants sur une année*/
    int nbFois ; /*Le nombre de fois qu'un nom à été donnée à des enfants*/
    moisDeLannee nomDuMois ; /*Quelle nom à été le plus donnée selon le mois */
}nomDonneeDansUneAnnee;


/**
 * \brief Initialise chaque case du tableau avec le caractère '*'.
 * \details Remplace chaque lettre du mot par '*'.
 *
 * \param mot Le tableau de caractères.
 */
void init(mot8lettres mot);

/**
 * \brief Permet à l'utilisateur de saisir un mot de 8 lettres.
 * \details Demande à l'utilisateur de saisir chaque lettre du mot.
 * 
 * \param mot Le tableau de caractères.
 */
void saisir(mot8lettres mot);

/**
 * \brief Affiche le mot.
 * \details Affiche chaque lettre du mot.
 * 
 * \param mot Le tableau de caractères.
 */
void afficher(mot8lettres mot);

/**
 * \brief Vérifie si une lettre est présente dans le mot.
 * \details Parcourt le tableau pour vérifier si une lettre spécifiée est présente.
 * 
 * \param mot Le tableau de caractères.
 * \param lettre La lettre à rechercher.
 * \return true si la lettre est présente, false sinon.
 */
bool contient(mot8lettres mot, char lettre);

/**
 * \brief Fonction principale.
 * \details Initialise un mot, permet à l'utilisateur de le saisir, l'affiche, 
 * et vérifie si une lettre spécifiée est présente.
 * 
 * \return 0 en cas de succès.
 */
int main() {
    char lettre;
    bool contientVal;
    mot8lettres mot;
    init(mot);
    saisir(mot);
    afficher(mot);
    printf("Quelle lettre\n");
    scanf(" %c", &lettre);
    contientVal = contient(mot, lettre);
    if (contientVal == true) {
        printf("La lettre est présente dans le mot.\n");
    } else {
        printf("La lettre n'est pas présente dans le mot.\n");
    }
    return 0;
}
